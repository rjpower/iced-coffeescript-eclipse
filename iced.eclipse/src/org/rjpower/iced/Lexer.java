package org.rjpower.iced;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.rjpower.iced.parser.antlr.internal.InternalIcedCoffeeLexer;

// Horribly inefficient lexer hack to add indent/dedent tokens.  We
// make a new copy of our input string, then split it into a bunch
// of other strings.  But hey, it works!
public class Lexer extends InternalIcedCoffeeLexer {
  @Override
  public void setCharStream(CharStream input) {
    System.err.println("Using modified lexer.");
    String content = input.substring(0, input.size());
    StringBuilder out = new StringBuilder();
    String[] lines = content.split("\n");
    int lastIndent = 0;

    for (String l : lines) {
      int curIndent = 0;
      int endWs = 0;
      for (char c : l.toCharArray()) {
        endWs++;
        if (c == ' ')
          curIndent++;
        else if (c == '\t')
          curIndent += 2;
        else
          break;
      }
      while (curIndent > lastIndent) {
        out.append("{{{");
        lastIndent += 2;
      }
      while (lastIndent > curIndent) {
        out.append("}}}");
        lastIndent -= 2;
      }
      if (endWs > 0) {
        out.append(l.substring(endWs - 1));
      }
    }
    String indented = out.toString();
    super.setCharStream(new ANTLRStringStream(indented));
  }
}

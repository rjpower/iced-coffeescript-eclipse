package org.rjpower.iced;

import java.util.Stack;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.rjpower.iced.parser.antlr.internal.InternalIcedCoffeeLexer;

public class IcedCoffeeLexer extends InternalIcedCoffeeLexer {
  int lastIndent = 0;
  boolean newLine = true;

  Stack<Token> buffer = new Stack<Token>();

  @Override
  public void reset() {
    super.reset();
    this.newLine = true;
    this.lastIndent = 0;
    buffer.clear();
  }

  private Token create(CommonToken orig, int type) {
    Token t = new CommonToken(input, type, orig.getChannel(), orig.getStartIndex(), orig.getStartIndex() - 1);
    t.setLine(orig.getLine());
    t.setCharPositionInLine(orig.getCharPositionInLine());
    return t;
  }

  @Override
  public Token nextToken() {
    if (!buffer.empty()) {
      Token next = buffer.pop();
//      System.err.println(next.getType() + " : '" + next.getText() + "'");
      return next;
    }

    Token t = super.nextToken();
    if (t.getType() == RULE_NL || t.getType() == RULE_SL_COMMENT) {
      newLine = true;
    } else if (newLine) {
      int curIndent = 0;
      if (t.getType() == RULE_WS) {
        curIndent = t.getText().length();
      }
      curIndent /= 2;
      while (curIndent < lastIndent) {
        buffer.push(create((CommonToken) t, RULE_DEDENT));
        curIndent++;
      }
      while (lastIndent < curIndent) {
        buffer.push(create((CommonToken) t, RULE_INDENT));
        lastIndent++;
      }
      newLine = false;
    }
    buffer.push(t);

    Token next = buffer.pop();
//    System.err.println(next.getType() + " : '" + next.getText() + "'");
    return next;
  }
}

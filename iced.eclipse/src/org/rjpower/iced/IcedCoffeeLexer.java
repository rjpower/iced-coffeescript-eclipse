package org.rjpower.iced;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.rjpower.iced.parser.antlr.internal.InternalIcedCoffeeLexer;

public class IcedCoffeeLexer extends InternalIcedCoffeeLexer {
  @Override
  public Token nextToken() {
    Token t = super.nextToken();
    return t;
  }
}

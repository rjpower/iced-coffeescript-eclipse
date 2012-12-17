package org.rjpower.iced.ui;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

public class IcedCoffeeTokenMapper extends DefaultAntlrTokenToAttributeIdMapper {
  @Override
  protected String calculateId(String tokenName, int tokenType) {
    if (tokenName.contains("KW")) {
      return IcedCoffeeHighlighter.KEYWORD_ID;
    }
    if (tokenName.contains("COMMENT")) {
      return IcedCoffeeHighlighter.COMMENT_ID;
    }
    if (tokenName.contains("CLASS")) {
      return IcedCoffeeHighlighter.CLASSVAR_ID;
    }
    if (tokenName.contains("STRING")) {
      return IcedCoffeeHighlighter.STRING_ID;
    }
    return super.calculateId(tokenName, tokenType);
  }
}
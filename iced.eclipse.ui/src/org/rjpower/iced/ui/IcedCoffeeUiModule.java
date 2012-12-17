package org.rjpower.iced.ui;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.rjpower.iced.Lexer;

/**
 * Use this class to register components to be used within the IDE.
 */
public class IcedCoffeeUiModule extends
    org.rjpower.iced.ui.AbstractIcedCoffeeUiModule {

  public static class Highlighter extends DefaultHighlightingConfiguration {
    public static String CLASSVAR_ID = "classvar";

    public void configure(IHighlightingConfigurationAcceptor acceptor) {
      acceptor.acceptDefaultHighlighting(CLASSVAR_ID, "Class variable",
          classVarStyle());
      super.configure(acceptor);
    }

    public TextStyle classVarStyle() {
      TextStyle textStyle = defaultTextStyle().copy();
      textStyle.setColor(new RGB(60, 60, 250));
      return textStyle;
    }
  }

  public static class TokenMapper extends
      DefaultAntlrTokenToAttributeIdMapper {
    @Override
    protected String calculateId(String tokenName, int tokenType) {
      if (tokenName.contains("KW")) {
        return Highlighter.KEYWORD_ID;
      }
      if (tokenName.contains("COMMENT")) {
        return Highlighter.COMMENT_ID;
      }
      if (tokenType == Lexer.RULE_CLASSVAR) {
        return Highlighter.CLASSVAR_ID;
      }
      if (tokenType == Lexer.RULE_STRING) {
        return Highlighter.STRING_ID;
      }
      return super.calculateId(tokenName, tokenType);
    }
  }

  public IcedCoffeeUiModule(AbstractUIPlugin plugin) {
    super(plugin);
  }

  public Class<? extends IHighlightingConfiguration> bindHighlightingConfiguration() {
    System.err.println("Using alternate highlighter...");
    return Highlighter.class;
  }

  public Class<? extends IHighlightingConfiguration> bindIcedCoffeeHighlightingConfiguration() {
    System.err.println("Using alternate highlighter...");
    return Highlighter.class;
  }

  public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
    return TokenMapper.class;
  }

  public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindTokenToAttributeIdMapper() {
    return TokenMapper.class;
  }
}

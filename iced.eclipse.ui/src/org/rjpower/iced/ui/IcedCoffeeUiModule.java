package org.rjpower.iced.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;

/**
 * Use this class to register components to be used within the IDE.
 */
public class IcedCoffeeUiModule extends
    org.rjpower.iced.ui.AbstractIcedCoffeeUiModule {

  public IcedCoffeeUiModule(AbstractUIPlugin plugin) {
    super(plugin);
  }

  public Class<? extends IHighlightingConfiguration> bindHighlightingConfiguration() {
    return IcedCoffeeHighlighter.class;
  }

  public Class<? extends IHighlightingConfiguration> bindIcedCoffeeHighlightingConfiguration() {
    return IcedCoffeeHighlighter.class;
  }

  public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
    return IcedCoffeeTokenMapper.class;
  }

  public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindTokenToAttributeIdMapper() {
    return IcedCoffeeTokenMapper.class;
  }

  public void configureHighlightingLexer(com.google.inject.Binder binder) {
    binder
        .bind(org.eclipse.xtext.parser.antlr.Lexer.class)
        .annotatedWith(
            com.google.inject.name.Names
                .named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING))
        .to(org.rjpower.iced.IcedCoffeeLexer.class);
  }
  
  @Override
  public Class<? extends IContentFormatterFactory> bindIContentFormatterFactory() {
    // TODO Auto-generated method stub
    return super.bindIContentFormatterFactory();
  }

}

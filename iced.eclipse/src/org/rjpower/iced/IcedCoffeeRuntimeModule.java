package org.rjpower.iced;

public class IcedCoffeeRuntimeModule extends
    org.rjpower.iced.AbstractIcedCoffeeRuntimeModule {

  public Class<? extends org.eclipse.xtext.parser.antlr.Lexer> bindLexer() {
    return org.rjpower.iced.IcedCoffeeLexer.class;
  }

  public void configureRuntimeLexer(com.google.inject.Binder binder) {
    binder
        .bind(org.eclipse.xtext.parser.antlr.Lexer.class)
        .annotatedWith(
            com.google.inject.name.Names
                .named(org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME))
        .to(org.rjpower.iced.IcedCoffeeLexer.class);
  }
}

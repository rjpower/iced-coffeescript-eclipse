package org.rjpower.iced.ui;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class IcedCoffeeHighlighter extends DefaultHighlightingConfiguration {
  public static String CLASSVAR_ID = "classvar";
  public static String CLASSNAME_ID = "classname";

  @Override
  public void configure(IHighlightingConfigurationAcceptor acceptor) {
    acceptor.acceptDefaultHighlighting(CLASSVAR_ID, "Class variable",
        classVarStyle());
    acceptor.acceptDefaultHighlighting(CLASSNAME_ID, "Class", classStyle());
    super.configure(acceptor);
  }

  @Override
  public TextStyle punctuationTextStyle() {
    TextStyle textStyle = defaultTextStyle().copy();
    textStyle.setColor(new RGB(60, 60, 250));
    return textStyle;
}

  public TextStyle classStyle() {
    TextStyle textStyle = defaultTextStyle().copy();
    textStyle.setColor(new RGB(255, 140, 0));
    return textStyle;
  }

  public TextStyle classVarStyle() {
    TextStyle textStyle = defaultTextStyle().copy();
    textStyle.setColor(new RGB(30, 144, 255));
    return textStyle;
  }
}
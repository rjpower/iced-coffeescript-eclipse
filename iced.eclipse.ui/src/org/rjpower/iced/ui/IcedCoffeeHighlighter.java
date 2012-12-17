package org.rjpower.iced.ui;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class IcedCoffeeHighlighter extends DefaultHighlightingConfiguration {
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
/*
 * generated by Xtext
 */
package org.rjpower.iced.formatting;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.rjpower.iced.services.IcedCoffeeGrammarAccess;

public class IcedCoffeeFormatter extends AbstractDeclarativeFormatter {

  @Override
  protected void configureFormatting(FormattingConfig c) {
    IcedCoffeeGrammarAccess g = (IcedCoffeeGrammarAccess) getGrammarAccess();
    c.setLinewrap(0, 1, 2).before(g.getSL_COMMENTRule());

    c.setNoSpace().around(g.getWSRule());
    c.setNoSpace().around(g.getNLRule());
    c.setNoSpace().around(g.getINDENTRule());
    c.setNoSpace().around(g.getDEDENTRule());
    c.setNoLinewrap().around(g.getNLRule());
    c.setIndentationDecrement().after(g.getDEDENTRule());
    c.setIndentationIncrement().after(g.getINDENTRule());
  }
}

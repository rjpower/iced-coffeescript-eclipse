package org.rjpower.iced.ui;

import org.eclipse.xtext.formatting.IIndentationInformation;

public class IcedCoffeeIndentationInformation implements
    IIndentationInformation {

  @Override
  public String getIndentString() {
    return "  ";
  }
}

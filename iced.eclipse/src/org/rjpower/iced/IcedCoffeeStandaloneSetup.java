
package org.rjpower.iced;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class IcedCoffeeStandaloneSetup extends IcedCoffeeStandaloneSetupGenerated{

	public static void doSetup() {
		new IcedCoffeeStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


/*
 * generated by Xtext
 */
package org.eclipse.papyrus.infra.gmfdiag.css3;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class CSSStandaloneSetup extends CSSStandaloneSetupGenerated{

	public static void doSetup() {
		new CSSStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


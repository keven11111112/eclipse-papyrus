/*
 * generated by Xtext
 */
package org.eclipse.papyrus.infra.gmfdiag.css3;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class CSSUiInjectorProvider implements IInjectorProvider {
	
	@Override
	public Injector getInjector() {
		return org.eclipse.papyrus.infra.gmfdiag.css3.ui.internal.CSSActivator.getInstance().getInjector("org.eclipse.papyrus.infra.gmfdiag.css3.CSS");
	}
	
}

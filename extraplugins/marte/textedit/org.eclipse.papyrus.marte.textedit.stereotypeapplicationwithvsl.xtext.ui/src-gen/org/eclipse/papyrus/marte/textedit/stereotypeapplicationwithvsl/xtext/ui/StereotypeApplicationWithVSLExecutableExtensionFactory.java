/*
 * generated by Xtext
 */
package org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui;

import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui.internal.StereotypeApplicationWithVSLActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass.
 */
public class StereotypeApplicationWithVSLExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return StereotypeApplicationWithVSLActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return StereotypeApplicationWithVSLActivator.getInstance().getInjector(StereotypeApplicationWithVSLActivator.ORG_ECLIPSE_PAPYRUS_MARTE_TEXTEDIT_STEREOTYPEAPPLICATIONWITHVSL_XTEXT_STEREOTYPEAPPLICATIONWITHVSL);
	}

}

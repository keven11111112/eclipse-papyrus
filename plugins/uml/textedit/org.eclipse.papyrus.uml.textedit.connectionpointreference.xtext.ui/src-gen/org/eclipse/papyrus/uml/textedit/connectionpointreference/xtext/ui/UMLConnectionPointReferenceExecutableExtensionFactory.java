/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui.internal.UMLConnectionPointReferenceActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass.
 */
public class UMLConnectionPointReferenceExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return UMLConnectionPointReferenceActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return UMLConnectionPointReferenceActivator.getInstance().getInjector(UMLConnectionPointReferenceActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_CONNECTIONPOINTREFERENCE_XTEXT_UMLCONNECTIONPOINTREFERENCE);
	}

}

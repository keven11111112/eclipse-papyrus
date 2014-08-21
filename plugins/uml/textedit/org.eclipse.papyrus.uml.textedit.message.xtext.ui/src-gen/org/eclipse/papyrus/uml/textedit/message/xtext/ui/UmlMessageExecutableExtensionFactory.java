/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.message.xtext.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.eclipse.papyrus.uml.textedit.message.xtext.ui.internal.UmlMessageActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass.
 */
public class UmlMessageExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return UmlMessageActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return UmlMessageActivator.getInstance().getInjector(UmlMessageActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_MESSAGE_XTEXT_UMLMESSAGE);
	}

}

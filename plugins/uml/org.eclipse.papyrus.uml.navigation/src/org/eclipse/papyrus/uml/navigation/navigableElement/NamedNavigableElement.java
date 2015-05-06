/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Shuai Li (CEA LIST) shuai.li@cea.fr - Creation
 *****************************************************************************/
package org.eclipse.papyrus.uml.navigation.navigableElement;

import java.util.Collections;

import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.navigation.service.ExtendedNavigableElement;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.papyrus.infra.widgets.util.NavigationTarget;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Navigates from a NamedElementdElement to its NamedElement declaration
 *
 * @author Shuai Li
 */
public class NamedNavigableElement implements ExtendedNavigableElement {

	protected final NamedElement element;

	/**
	 *
	 * @param element
	 *            The NamedElement to navigate to. May be null.
	 */
	public NamedNavigableElement(NamedElement element) {
		this.element = element;
	}

	public String getLabel() {
		String label = "Go to element" + getNamedElementLabel() + "...";
		return label;
	}

	public String getDescription() {
		return "Go to the element declaration of this NamedElement" + getNamedElementLabel();
	}

	protected String getNamedElementLabel() {
		if (element == null) {
			return " (Undefined)";
		} else {
			return " (" + element.getName() + ")";
		}
	}

	@Deprecated
	public void navigate(IRevealSemanticElement navigationContext) {
		if (!isEnabled()) {
			return;
		}

		navigationContext.revealSemanticElement(Collections.singletonList(element));
	}

	public Image getImage() {
		if (element == null) {
			return null;
		}

		try {
			return ServiceUtilsForEObject.getInstance().getServiceRegistry(element).getService(LabelProviderService.class).getLabelProvider().getImage(element);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Enabled when the element is defined
	 */
	public boolean isEnabled() {
		return element != null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean navigate(NavigationTarget navigationContext) {
		if (!isEnabled()) {
			return false;
		}
		return navigationContext.revealElement(element);
	}

	/**
	 * Returns the element (UML Element) of the NamedElementdNavigableElement
	 * @return element
	 */
	public Element getNamedElement() {
		return this.element;
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.navigation.service.NavigableElement#getSemanticElement()
	 *
	 * @return
	 */
	public Object getSemanticElement() {
		return getNamedElement();
	}
}

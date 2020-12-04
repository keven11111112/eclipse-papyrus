/******************************************************************************
 * Copyright (c) 2006, 2007 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Dmitry Stadnik - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.wizards.pages.simple;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.gmf.internal.common.ui.ExtensibleModelSelectionPage;
import org.eclipse.papyrus.gmf.internal.common.ui.ResourceLocationProvider;

/**
 * @author dstadnik
 */
public class DomainModelSelectionPage extends ExtensibleModelSelectionPage implements DomainModelSource {

	private static final String DEE = "diagramElement"; //$NON-NLS-1$

	private EPackage contents;

	public DomainModelSelectionPage(String pageId, ResourceLocationProvider rloc, ResourceSet resourceSet) {
		super(pageId, rloc, resourceSet, "ecore"); //$NON-NLS-1$
	}

	protected void addExtensions() {
		addExtension(DEE, new DiagramElementSelectorExtension());
	}

	@Override
	protected void resourceChanged() {
		super.resourceChanged();
		contents = null;
		if (getResource() != null) {
			List<EObject> rc = getResource().getContents();
			if (rc.size() >= 1 && rc.get(0) instanceof EPackage) {
				contents = (EPackage) rc.get(0);
			}
		}
	}

	public EPackage getContents() {
		return contents;
	}

	public EClass getDiagramElement() {
		return (EClass) ((DiagramElementSelectorExtension) getExtension(DEE)).getModelElement();
	}

	public boolean isDisabled(EObject domainElement) {
		throw new UnsupportedOperationException();
	}
}

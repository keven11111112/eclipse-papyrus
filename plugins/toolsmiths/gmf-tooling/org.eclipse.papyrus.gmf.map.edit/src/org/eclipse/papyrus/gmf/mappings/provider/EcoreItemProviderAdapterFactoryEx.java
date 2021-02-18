/*******************************************************************************
 * Copyright (c) 2005, 2020 Borland Software Corporation, CEA LIST, ARTAL
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Borland - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 ******************************************************************************/
package org.eclipse.papyrus.gmf.mappings.provider;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EAttributeItemProvider;
import org.eclipse.emf.ecore.provider.EReferenceItemProvider;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;

/**
 * @author artem
 */
public class EcoreItemProviderAdapterFactoryEx extends EcoreItemProviderAdapterFactory {
	
	public EcoreItemProviderAdapterFactoryEx() {
		eAttributeItemProvider = new EAttributeItemProvider(this) {
			@Override
			public String getText(Object obj) {
				if (GMFMapEditPlugin.isQualifiedFeatureLabels()) {
					return GMFMapEditPlugin.getFeatureLabel((EStructuralFeature) obj);
				}
				return super.getText(obj);
			}
		};
		eReferenceItemProvider = new EReferenceItemProvider(this) {
			@Override
			public String getText(Object obj) {
				if (GMFMapEditPlugin.isQualifiedFeatureLabels()) {
					return GMFMapEditPlugin.getFeatureLabel((EStructuralFeature) obj);
				}
				return super.getText(obj);
			}
		};
	}

}

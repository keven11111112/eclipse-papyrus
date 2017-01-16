/*****************************************************************************
 * Copyright (c) 2011, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *  
 *****************************************************************************/
package org.eclipse.papyrus.toolsmiths.factory;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IPluginEditor;
import org.eclipse.papyrus.toolsmiths.model.customizationplugin.CustomizableElement;


public interface ExtensionFactory {

	public static ExtensionFactoryRegistry registry = ExtensionFactoryRegistry.instance;

	public void addElement(CustomizableElement element, IPluginEditor editor);

	public EClass getCustomizableElementClass();

	public String getName();
}

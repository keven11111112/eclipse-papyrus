/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thomas Daniellou (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.adltool.reversible.extension;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;

/**
 * This class is a reversible adapter of a loaded extension. (Extensions
 * that are defined by loaded plug-ins)
 */
public class LoadedExtension extends AbstractExtension {

	private IExtension extension;

	/**
	 * Constructor.
	 *
	 * @param extension
	 */
	public LoadedExtension(IExtension extension) {
		this.extension = extension;
	}

	@Override
	public String getId() {
		return extension.getExtensionPointUniqueIdentifier();
	}

	@Override
	public List<SchemaElement> getElements() {
		List<SchemaElement> result = new ArrayList<>();

		for (IConfigurationElement configurationElement : extension.getConfigurationElements()) {
			String elementName = configurationElement.getName();
			SchemaElement element = new SchemaElement(elementName);

			for (String attributeName : configurationElement.getAttributeNames()) {
				String value = configurationElement.getAttribute(attributeName);
				element.addAttribute(new SchemaAttribute(attributeName, value));
			}

			result.add(element);
		}

		return result;
	}

}

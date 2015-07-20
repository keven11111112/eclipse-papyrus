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
package org.eclipse.papyrus.adltool.reversible.extensionpoint;

import static org.eclipse.papyrus.adltool.Activator.log;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.papyrus.adltool.reversible.extension.SchemaElement;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.papyrus.adltool.reversible.extension.SchemaAttribute;

/**
 * This class is a reversible adapter of a loaded extension point. (Extension points
 * that are defined by loaded plug-ins)
 */
public class LoadedExtensionPoint extends AbstractExtensionPoint {

	private IExtensionPoint extensionPoint;

	public LoadedExtensionPoint(IExtensionPoint extensionPoint) {
		this.extensionPoint = extensionPoint;
	}

	@Override
	public String getId() {
		return extensionPoint.getUniqueIdentifier();
	}

	@Override
	public void fillStereotype() {
		if (!applyStereotype()) {
			log.warn(getId() + ": cannot fill the stereotype properties");
		}
	}

	@Override
	public ReversibleProject getParent() {
		return parent;
	}

	@Override
	public List<SchemaElement> getElements() {
		List<SchemaElement> result = new ArrayList<>();

		for (IConfigurationElement element : extensionPoint.getConfigurationElements()) {
			String elementName = element.getName();
			SchemaElement schemaElement = new SchemaElement(elementName);

			for (String attributeName : element.getAttributeNames()) {
				String value = element.getAttribute(attributeName);

				schemaElement.addAttribute(new SchemaAttribute(attributeName, value));
			}

			result.add(schemaElement);

		}

		return result;
	}

}

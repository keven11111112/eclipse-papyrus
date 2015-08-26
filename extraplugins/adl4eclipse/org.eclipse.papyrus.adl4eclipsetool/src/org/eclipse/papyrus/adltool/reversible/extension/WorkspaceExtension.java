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

import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginObject;

/**
 * This class is a reversible adapter of a workspace extension. (Extensions
 * that are defined by plug-ins in the workspace)
 */
public class WorkspaceExtension extends AbstractExtension {

	private IPluginExtension extension;

	/**
	 * Constructor.
	 *
	 * @param extension
	 */
	public WorkspaceExtension(IPluginExtension extension) {
		this.extension = extension;
	}

	@Override
	public String getId() {
		return extension.getPoint();
	}

	@Override
	public List<SchemaElement> getElements() {
		List<SchemaElement> elements = new ArrayList<>();

		for (IPluginObject child : extension.getChildren()) {
			if (child instanceof IPluginElement) {
				IPluginElement element = (IPluginElement) child;
				SchemaElement schemaElement = new SchemaElement(element.getName());

				for (IPluginAttribute attribute : element.getAttributes()) {
					String attributeName = attribute.getName();
					String attributeValue = attribute.getValue();

					schemaElement.addAttribute(new SchemaAttribute(attributeName, attributeValue));
				}

				elements.add(schemaElement);
			}
		}

		return elements;
	}

}

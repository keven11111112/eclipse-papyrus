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

import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.reversible.extension.SchemaAttribute;
import org.eclipse.papyrus.adltool.reversible.extension.SchemaElement;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.pde.core.plugin.IPluginExtensionPoint;
import org.eclipse.pde.internal.core.ischema.ISchema;
import org.eclipse.pde.internal.core.ischema.ISchemaAttribute;
import org.eclipse.pde.internal.core.ischema.ISchemaElement;

/**
 * This class is a reversible adapter of a workspace extension point. (Extension points
 * that are defined by plug-ins in the workspace)
 */
@SuppressWarnings("restriction")
public class WorkspaceExtensionPoint extends AbstractExtensionPoint {

	private IPluginExtensionPoint extensionPoint;

	public WorkspaceExtensionPoint(IPluginExtensionPoint extensionPoint) {
		this.extensionPoint = extensionPoint;
	}

	@Override
	public String getId() {
		return extensionPoint.getFullId();
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
		ISchema schema = ADL4EclipseUtils.getSchema(getId());

		for (ISchemaElement element : schema.getElements()) {
			String elementName = element.getName();
			SchemaElement schemaElement = new SchemaElement(elementName);

			schemaElement.setType(element.getType().getName());
			schemaElement.setMinOccurs(element.getMinOccurs());
			schemaElement.setMaxOccurs(element.getMaxOccurs());

			for (ISchemaAttribute attribute : element.getAttributes()) {
				schemaElement.addAttribute(new SchemaAttribute(attribute.getName()));
			}

			result.add(schemaElement);
		}

		return result;
	}

}

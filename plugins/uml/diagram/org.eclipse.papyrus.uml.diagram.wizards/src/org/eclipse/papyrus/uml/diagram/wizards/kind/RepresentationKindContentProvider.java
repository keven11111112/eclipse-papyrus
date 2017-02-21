/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.kind;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureViewpoint;
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager;

/**
 * The ContentProvider for DiagramCategory table.
 * Returns available diagram kinds for the given diagram category(ies).
 */
public class RepresentationKindContentProvider implements IStructuredContentProvider {

	/**
	 * Input changed.
	 *
	 * @param viewer
	 *            the viewer
	 * @param oldInput
	 *            the old input
	 * @param newInput
	 *            the new input
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	/**
	 * Gets the elements.
	 *
	 * @param inputElement
	 *            the input element
	 * @return the elements
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		ArchitectureDomainManager manager = ArchitectureDomainManager.getInstance();
		if (inputElement instanceof Object[]) {
			Set<RepresentationKind> result = new TreeSet<RepresentationKind>(new Comparator<RepresentationKind>() {
				@Override
				public int compare(RepresentationKind o1, RepresentationKind o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
			for (Object next : (Object[]) inputElement) {
				if (next instanceof String) {
					String viewpointId = (String) next;
					MergedArchitectureViewpoint viewpoint = manager.getArchitectureViewpointById(viewpointId);
					result.addAll(viewpoint.getRepresentationKinds());
				}
			}
			return result.toArray(new Object[result.size()]);
		}
		if (inputElement instanceof String) {
			String viewpointId = (String) inputElement;
			MergedArchitectureViewpoint viewpoint = manager.getArchitectureViewpointById(viewpointId);
			Collection<RepresentationKind> result = viewpoint.getRepresentationKinds();
			return result.toArray(new Object[result.size()]);
		}
		return null;
	}

}

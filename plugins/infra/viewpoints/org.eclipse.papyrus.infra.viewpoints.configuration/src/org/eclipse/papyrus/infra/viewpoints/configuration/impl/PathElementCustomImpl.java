/**
 * Copyright (c) 2015 CEA LIST.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Benoit Maggi benoit.maggi@cea.fr - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.viewpoints.configuration.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.PathElement;


public class PathElementCustomImpl extends PathElementImpl implements PathElement {
	
	
	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PathElementImpl#basicGetOrigin()
	 *
	 * @return
	 */
	@Override
	public EClass basicGetOrigin() {
		ChildRule rule = (ChildRule) this.eContainer();
		return basicGetOriginFrom(rule.getInsertionPath(), rule.getOrigin());
	}

	private EClass basicGetOriginFrom(EList<PathElement> list, EClass from) {
		EClass current = from;
		int index = 0;
		while ((current != null) && list.get(index) != this) {
			EReference feature = list.get(index).getFeature();
			if (!current.getEAllReferences().contains(feature))
				return null;
			current = feature.getEReferenceType();
			index++;
		}
		return current;
	}
	
	
	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.PathElementImpl#basicGetTarget()
	 *
	 * @return
	 */
	@Override
	public EClass basicGetTarget() {
		EReference feature = this.getFeature();
		if (feature == null)
			return null;
		EClass origin = basicGetOrigin();
		if (origin == null)
			return null;
		if (!origin.getEAllReferences().contains(feature))
			return null;
		return feature.getEReferenceType();
	}
} 

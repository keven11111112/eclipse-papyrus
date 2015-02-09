/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.assistant.core.util;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;

/**
 * An ephemeral proxy element type manifesting both a generic {@linkplain #resolveSemanticType() semantic type facet} and a {@linkplain #resolveVisualType() visual (diagram) type facet}.
 */
public interface IProxyElementType extends ISpecializationType, IHintedType {
	IElementType resolveSemanticType();

	IHintedType resolveVisualType();
}

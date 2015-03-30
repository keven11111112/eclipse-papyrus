/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Onder Gurcan <onder.gurcan@cea.fr>
 *
 *****************************************************************************/
package org.eclipse.papyrus.umlrt.custom;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class UMLRTElementTypesEnumerator extends AbstractElementTypeEnumerator {

	public static final IHintedType RT_MESSAGE_SET = (IHintedType) getElementType("org.eclipse.papyrus.umlrt.RTMessageSet"); //$NON-NLS-1$

	public static final IHintedType PROTOCOL_CONTAINER = (IHintedType) getElementType("org.eclipse.papyrus.umlrt.ProtocolContainer"); //$NON-NLS-1$

}

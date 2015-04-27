/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.umlrt.custom.utils;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.papyrus.umlrt.UMLRealTime.RTMessageKind;
import org.eclipse.papyrus.umlrt.custom.IUMLRTElementTypes;
import org.eclipse.papyrus.umlrt.internals.Activator;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;

/**
 * Utility class for UMLRT::Protocols
 */
public class ProtocolUtils {

	/**
	 * Returns the package that corresponds to the protocol container. There should be a check here for the applied stereotype on the package.
	 * 
	 * @param protocol
	 *            the collaboration for which the protocol container is searched
	 * @return the collaboration for which the protocol container is searched or <code>null</code> if none is found
	 */
	public static Package getPackageContainer(Collaboration protocol) {
		return protocol.getNearestPackage();
	}

	/**
	 * Returns <code>true</code> if the context element is a Protocol (Collaboration stereotyped by "protocol")
	 * 
	 * @param context
	 *            the eobject to test
	 * @return <code>true</code> if the context element is a Protocol (Collaboration stereotyped by "protocol")
	 */
	public static Boolean isProtocol(EObject context) {
		IElementType type = ElementTypeRegistry.getInstance().getType(IUMLRTElementTypes.PROTOCOL_ID);
		if (!(type instanceof ISpecializationType)) { // check at the same time UMLRT element types are correctly loaded
			return false;
		}
		if (((ISpecializationType) type).getMatcher().matches(context)) {
			return true;
		}
		return false;
	}

	/**
	 * @param in
	 * @return
	 */
	public static List<Operation> getRTMessages(Collaboration protocol, RTMessageKind direction, boolean showInherited) {
		Package protocolContainer = getPackageContainer(protocol);
		if(protocolContainer ==null) {
			Activator.log.error("Impossible to get the root protocol container", null);
			return Collections.emptyList();
		}
		
		return ProtocolContainerUtils.getRTMessages(protocolContainer, direction, showInherited);
	}

}

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

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.umlrt.UMLRealTime.RTMessageKind;
import org.eclipse.papyrus.umlrt.UMLRealTime.RTMessageSet;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Utility class for PackageContainers
 */
public class ProtocolContainerUtils {

	/**
	 * Returns all the In Operations attached to the protocol in this protocol container
	 * 
	 * @return all the In Operations attached to the protocol in this protocol container or an empty list if there was no protocol/interfacein.
	 */ 
	public static List<Operation> getAllInOperations(Package protocolContainer) {
		Interface messageSetIn = getMessageSetIn(protocolContainer);
		if(messageSetIn !=null) {
			// warning: this will display only direct contained operations, not the inherited ones.
			return messageSetIn.getOwnedOperations();
		}
		return Collections.emptyList();
	}

	/**
	 * Returns all the Out Operations attached to the protocol in this protocol container
	 * 
	 * @return all the Out Operations attached to the protocol in this protocol container or <code>null</code> if there was no protocol/interfacein.
	 */
	public static Collection<Operation> getAllOutOperations(Package protocolContainer) {
		Interface messageSetOut = getMessageSetOut(protocolContainer);
		if (messageSetOut != null) {
			// warning: this will display only direct contained operations, not the inherited ones.
			return messageSetOut.getOwnedOperations();
		}
		return Collections.emptyList();
	}

	/**
	 * Returns all the InOut Operations attached to the protocol in this protocol container
	 * 
	 * @return all the InOut Operations attached to the protocol in this protocol container or <code>null</code> if there was no protocol/interfacein.
	 */
	public static Collection<Operation> getAllInOutOperations(Package protocolContainer) {
		Interface messageSetInOut = getMessageSetInOut(protocolContainer);
		if (messageSetInOut != null) {
			// warning: this will display only direct contained operations, not the inherited ones.
			return messageSetInOut.getOwnedOperations();
		}
		return Collections.emptyList();
	}

	public static Interface getMessageSet(Package protocolContainer, RTMessageKind messageKind) {
		for(PackageableElement packageableElement : protocolContainer.getPackagedElements()) {
			// look each interface to find the right one with the stereotype message set
			if(packageableElement instanceof Interface) {
				RTMessageSet messageSet = UMLUtil.getStereotypeApplication(packageableElement, RTMessageSet.class);
				if (messageSet != null && messageKind != null && messageKind.equals(messageSet.getRtMsgKind())) {
					return (Interface)packageableElement;
				}
			}
		}
		return null;
	}
	
	
	public static Interface getMessageSetIn(Package protocolContainer) {
		return getMessageSet(protocolContainer, RTMessageKind.IN);
	}
	
	public static Interface getMessageSetOut(Package protocolContainer) {
		return getMessageSet(protocolContainer, RTMessageKind.OUT);
	}
	
	public static Interface getMessageSetInOut(Package protocolContainer) {
		return getMessageSet(protocolContainer, RTMessageKind.IN_OUT);
	}


}

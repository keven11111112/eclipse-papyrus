/**
 * Copyright (c) 2015 CEA LIST.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.umlrt.utils;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.umlrt.UMLRealTime.Protocol;
import org.eclipse.papyrus.umlrt.UMLRealTime.ProtocolContainer;
import org.eclipse.papyrus.umlrt.UMLRealTime.RTMessageKind;
import org.eclipse.papyrus.umlrt.UMLRealTime.RTMessageSet;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Utility class for UMLRT
 * 
 * @author ysroh
 *
 */
public class UMLRTUtil {

	private UMLRTUtil() {
	}

	/**
	 * Queries the protocol container containing the object passed in
	 * 
	 * @param eObject
	 * @return
	 */
	public static Package getProtocolContainer(EObject eObject) {
		if (eObject == null) {
			return null;
		}

		if (isProtocolContainer(eObject)) {
			return (Package) eObject;
		}

		return getProtocolContainer(eObject.eContainer());
	}

	/**
	 * Queries the protocol under the protocol container
	 * 
	 * @param container
	 * @return
	 */
	public static Collaboration getProtocol(Package container) {
		EList<PackageableElement> elements = container.getPackagedElements();
		for (PackageableElement e : elements) {
			if (isProtocol(e)) {
				return (Collaboration) e;
			}
		}
		return null;
	}

	/**
	 * Queries message set of given message kind
	 * 
	 * @param protocolContainer
	 *            Protocol container
	 * @param kind
	 *            RTMessageKind
	 * @return
	 */
	public static Interface getMessageSet(Package protocolContainer,
			RTMessageKind kind) {
		String protocolName = protocolContainer.getName();
		Collaboration protocol = (Collaboration) protocolContainer
				.getPackagedElement(protocolName, false,
						UMLPackage.Literals.COLLABORATION, false);
		if (protocol == null) {
			return null;
		}
		if (kind.equals(RTMessageKind.IN)) {
			EList<Interface> provides = getProvideds(protocol);
			if (!provides.isEmpty()) {
				return provides.get(0);
			}
		} else if (kind.equals(RTMessageKind.OUT)) {
			EList<Interface> requires = getRequireds(protocol);
			if (!requires.isEmpty()) {
				return requires.get(0);
			}
		} else {
			EList<Interface> provides = getProvideds(protocol);
			EList<Interface> requires = getRequireds(protocol);
			for (Interface p : provides) {
				if (requires.contains(p)) {
					return p;
				}
			}
		}
		return null;
	}

	/**
	 * Get list of provided interfaces from the protocol
	 * 
	 * @param source
	 * @return
	 */
	public static EList<Interface> getProvideds(Collaboration source) {
		EList<Interface> provideds = new BasicEList<Interface>();
		for (DirectedRelationship directedRelation : ((Collaboration) source)
				.getSourceDirectedRelationships()) {
			if (directedRelation instanceof Realization) {
				EList<NamedElement> suppliers = ((Realization) directedRelation)
						.getSuppliers();
				if (suppliers.size() > 0) {
					NamedElement supplier = suppliers.get(0);
					if (supplier instanceof Interface) {
						provideds.add((Interface) supplier);
					}
				}
			}
		}
		return provideds;
	}

	/**
	 * Get list of required interfaces from the protocol
	 * 
	 * @param source
	 * @return
	 */
	public static EList<Interface> getRequireds(Collaboration source) {
		return ((Collaboration) source).getUsedInterfaces();
	}

	/**
	 * Queries if the given element is a ProtocolContainer
	 * 
	 * @param element
	 * @return
	 */
	public static boolean isProtocolContainer(EObject element) {

		return isStereotypedBy(element, ProtocolContainer.class);
	}

	/**
	 * Queries if the given element is a Protocol
	 * 
	 * @param element
	 * @return
	 */
	public static boolean isProtocol(EObject element) {

		return isStereotypedBy(element, Protocol.class);

	}

	/**
	 * Queries if the given element is a RtMessageSet
	 * 
	 * @param element
	 * @return
	 */
	public static boolean isRTMessageSet(EObject element) {

		return isStereotypedBy(element, RTMessageSet.class);
	}

	/**
	 * Queries if the given element is stereotyped by the given class
	 * 
	 * @param element
	 * @param clazz
	 * @return
	 */
	public static <T extends EObject> boolean isStereotypedBy(EObject element,
			Class<T> clazz) {
		if (element instanceof Element
				&& UMLUtil.getStereotypeApplication((Element) element, clazz) != null) {
			return true;

		}
		return false;
	}
}

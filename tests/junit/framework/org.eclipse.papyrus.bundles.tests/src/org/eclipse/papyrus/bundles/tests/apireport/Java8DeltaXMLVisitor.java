/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.bundles.tests.apireport;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.Flags;
import org.eclipse.pde.api.tools.internal.IApiXmlConstants;
import org.eclipse.pde.api.tools.internal.provisional.comparator.IDelta;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * A specialized {@link SafeDeltaXmlVisitor} that accounts for new
 * compatibility scenarios in Java8's interface evoluation
 * capabilities (such as default and static methods).
 */
public class Java8DeltaXMLVisitor extends SafeDeltaXmlVisitor {
	private static final Map<String, Integer> deltaConstantsDecoder = new HashMap<>();

	private final Element root;

	static {
		try {
			for (Field next : IDelta.class.getFields()) {
				if (next.getType() == int.class) {
					deltaConstantsDecoder.put(next.getName(), next.getInt(null));
				}
			}
		} catch (Exception e) {
			// Won't happen because we iterate known fields of an interface, which
			// are by definition always accessible
			throw new Error(e);
		}
	}

	public Java8DeltaXMLVisitor() throws CoreException {
		super();

		root = getDocument().getDocumentElement();
	}


	/**
	 * Appends my XML content to a given {@code appendable}.
	 * 
	 * @param appendable
	 *            the appenable on which to append me
	 * 
	 * @throws IOException
	 *             on failure to append
	 */
	public void appendTo(Appendable appendable) throws IOException {
		try {
			appendable.append(getXML());
		} catch (CoreException e) {
			throw new IOException(e);
		}
	}

	@Override
	protected void processLeafDelta(IDelta delta) {
		super.processLeafDelta(delta);

		Element deltaElement = getNewElement();
		if (isIncompatible(deltaElement)) {
			amend(deltaElement);
		}
	}

	/**
	 * Obtains the element most recently added to the delta report.
	 * 
	 * @return the newest delta element
	 */
	Element getNewElement() {
		NodeList nodes = root.getChildNodes();
		// We don't append interstitial text
		return (Element) nodes.item(nodes.getLength() - 1);
	}

	public boolean isIncompatible(Element delta) {
		String result = getString(delta, IApiXmlConstants.ATTR_NAME_COMPATIBLE);
		return !Boolean.parseBoolean(result);
	}

	protected void setCompatible(Element delta, boolean compatible) {
		set(delta, IApiXmlConstants.ATTR_NAME_COMPATIBLE, compatible);
	}

	protected String getString(Element element, String attribute) {
		return element.getAttribute(attribute);
	}

	protected void set(Element element, String attribute, String value) {
		if (value == null) {
			element.removeAttribute(attribute);
		} else {
			element.setAttribute(attribute, value);
		}
	}

	protected boolean getBoolean(Element element, String attribute) {
		String result = getString(element, attribute);
		return Boolean.parseBoolean(result);
	}

	protected void set(Element element, String attribute, boolean value) {
		set(element, attribute, Boolean.toString(value));
	}

	protected int getInt(Element element, String attribute) {
		String result = getString(element, attribute);
		return (result == null) ? 0 : Integer.parseInt(result);
	}

	protected void set(Element element, String attribute, int value) {
		set(element, attribute, Integer.toString(value));
	}

	protected void amend(Element delta) {
		Integer elementType = deltaConstantsDecoder.getOrDefault(
				getString(delta, IApiXmlConstants.ATTR_NAME_ELEMENT_TYPE),
				0);

		switch (elementType) {
		case IDelta.INTERFACE_ELEMENT_TYPE:
			amendInterface(delta);
			break;
		}
	}

	protected void amendInterface(Element delta) {
		boolean compatible = false;
		Integer kind = deltaConstantsDecoder.getOrDefault(
				getString(delta, IApiXmlConstants.ATTR_KIND),
				0);
		String newMessage = null;

		switch (kind) {
		case IDelta.ADDED:
			// Something was added to the interface
			switch (getInt(delta, IApiXmlConstants.ATTR_FLAGS)) {
			case IDelta.FIELD:
				// Interfaces can only have static fields, so of course this is
				// compatible because the linkage is static
				compatible = isStatic(delta);
				if (compatible) {
					newMessage = getString(delta, IApiXmlConstants.ATTR_MESSAGE);
					if (newMessage != null) {
						newMessage = newMessage.replaceFirst("field", "static field");
						newMessage = newMessage.replaceFirst("in an interface that .*? has", "has");
					}
				}
				break;
			case IDelta.METHOD:
				// Java 8 default and static methods are a compatible addition
				compatible = isDefaultOrStaticMethod(delta);
				if (compatible) {
					newMessage = getString(delta, IApiXmlConstants.ATTR_MESSAGE);
					if (newMessage != null) {
						newMessage = newMessage.replaceFirst("method",
								isStatic(delta) ? "static method" : "default method");
						newMessage = newMessage.replaceFirst("in an interface that .*? has", "has");
					}
				}
				break;
			}
			break;
		}

		if (compatible) {
			setCompatible(delta, compatible);
			if (newMessage != null) {
				set(delta, IApiXmlConstants.ATTR_MESSAGE, newMessage);
			}
		}
	}

	private boolean isDefaultOrStaticMethod(Element delta) {
		// Assume not if we can't get the method details
		boolean result = false;

		int modifiers = getInt(delta, IApiXmlConstants.ATTR_NAME_NEW_MODIFIERS);
		result = Flags.isDefaultMethod(modifiers) || Flags.isStatic(modifiers)
				|| !Flags.isAbstract(modifiers); // May not know that it's explicitly default

		return result;
	}

	private boolean isStatic(Element delta) {
		// Assume not if we can't get the method details
		boolean result = false;

		int modifiers = getInt(delta, IApiXmlConstants.ATTR_NAME_NEW_MODIFIERS);
		result = Flags.isStatic(modifiers);

		return result;
	}
}

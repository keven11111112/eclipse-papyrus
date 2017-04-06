/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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
/*******************************************************************************
 * Copyright (c) 2007, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.bundles.tests.apireport;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.lang3.text.translate.AggregateTranslator;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;
import org.apache.commons.lang3.text.translate.CodePointTranslator;
import org.apache.commons.lang3.text.translate.EntityArrays;
import org.apache.commons.lang3.text.translate.LookupTranslator;
import org.apache.commons.lang3.text.translate.NumericEntityEscaper;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.api.tools.internal.IApiXmlConstants;
import org.eclipse.pde.api.tools.internal.provisional.comparator.ApiComparator;
import org.eclipse.pde.api.tools.internal.provisional.comparator.DeltaProcessor;
import org.eclipse.pde.api.tools.internal.provisional.comparator.DeltaVisitor;
import org.eclipse.pde.api.tools.internal.provisional.comparator.IDelta;
import org.eclipse.pde.api.tools.internal.util.Util;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Copy of org.eclipse.pde.api.tools.internal.comparator.DeltaXmlVisitor that has a fix to escape xml special chars
 * 
 * Delta visitor that generates XML for the delta.
 *
 * @since 1.0.0
 */
public class SafeDeltaXmlVisitor extends DeltaVisitor {
	/**
	 * XML doc being generated
	 */
	private Document fDoc;

	/**
	 * Top deltas element
	 */
	private Element fDeltas;

	/**
	 * Constructs a new visitor for the given component.
	 *
	 * @param component
	 *            API component
	 * @throws CoreException
	 *             if unable to construct the visitor
	 */
	public SafeDeltaXmlVisitor() throws CoreException {
		fDoc = Util.newDocument();
		fDeltas = fDoc.createElement(IApiXmlConstants.DELTAS_ELEMENT_NAME);
		fDoc.appendChild(fDeltas);
	}

	@Override
	public boolean visit(IDelta delta) {
		if (delta == ApiComparator.NO_DELTA) {
			return false;
		}
		if (delta.getChildren().length == 0) {
			processLeafDelta(delta);
		}
		return true;
	}

	protected void processLeafDelta(IDelta delta) {
		Element deltaElement = fDoc.createElement(IApiXmlConstants.DELTA_ELEMENT_NAME);
		deltaElement.setAttribute(IApiXmlConstants.ATTR_FLAGS, Integer.toString(delta.getFlags()));
		deltaElement.setAttribute(IApiXmlConstants.ATTR_KIND, Util.getDeltaKindName(delta));
		deltaElement.setAttribute(IApiXmlConstants.ATTR_NAME_ELEMENT_TYPE, Util.getDeltaElementType(delta));
		deltaElement.setAttribute(IApiXmlConstants.ATTR_KEY, delta.getKey());
		String typeName = delta.getTypeName();
		if (typeName != null) {
			deltaElement.setAttribute(IApiXmlConstants.ATTR_NAME_TYPE_NAME, typeName);
		}
		deltaElement.setAttribute(IApiXmlConstants.ATTR_NAME_COMPATIBLE, Boolean.toString(DeltaProcessor.isCompatible(delta)));
		deltaElement.setAttribute(IApiXmlConstants.ATTR_NAME_OLD_MODIFIERS, Integer.toString(delta.getOldModifiers()));
		deltaElement.setAttribute(IApiXmlConstants.ATTR_NAME_NEW_MODIFIERS, Integer.toString(delta.getNewModifiers()));
		deltaElement.setAttribute(IApiXmlConstants.ATTR_RESTRICTIONS, Integer.toString(delta.getCurrentRestrictions()));
		String apiComponentID = delta.getComponentVersionId();
		if (apiComponentID != null) {
			deltaElement.setAttribute(IApiXmlConstants.ATTR_NAME_COMPONENT_ID, apiComponentID);
		}

		deltaElement.setAttribute(IApiXmlConstants.ATTR_MESSAGE, ESCAPE_XML11.translate(delta.getMessage()));
		String[] messageArguments = delta.getArguments();
		int length = messageArguments.length;
		if (length > 0) {
			Element messageArgumentsElement = fDoc.createElement(IApiXmlConstants.ELEMENT_DELTA_MESSAGE_ARGUMENTS);
			for (int j = 0; j < length; j++) {
				Element messageArgumentElement = fDoc.createElement(IApiXmlConstants.ELEMENT_DELTA_MESSAGE_ARGUMENT);

				messageArgumentElement.setAttribute(IApiXmlConstants.ATTR_VALUE, ESCAPE_XML11.translate(String.valueOf(messageArguments[j])));

				messageArgumentsElement.appendChild(messageArgumentElement);
			}
			deltaElement.appendChild(messageArgumentsElement);
		}
		fDeltas.appendChild(deltaElement);
	}

	public CharSequenceTranslator ESCAPE_XML11 = new AggregateTranslator(
			new LookupTranslator(EntityArrays.BASIC_ESCAPE()),
			new LookupTranslator(EntityArrays.APOS_ESCAPE()),
			new LookupTranslator(
					new String[][] {
							{ "\u0000", "" },
							{ "\u000b", "&#11;" },
							{ "\u000c", "&#12;" },
							{ "\ufffe", "" },
							{ "\uffff", "" }
					}),
			NumericEntityEscaper.between(0x1, 0x8),
			NumericEntityEscaper.between(0xe, 0x1f),
			NumericEntityEscaper.between(0x7f, 0x84),
			NumericEntityEscaper.between(0x86, 0x9f),
			new UnicodeUnpairedSurrogateRemover());

	public class UnicodeUnpairedSurrogateRemover extends CodePointTranslator {
		@Override
		public boolean translate(final int codepoint, final Writer out) throws IOException {
			if (codepoint <= Character.MAX_SURROGATE && codepoint >= Character.MIN_SURROGATE) {
				return true;
			}
			return false;
		}
	}

	@Override
	public void endVisit(IDelta delta) {
		// nothing to do
	}

	/**
	 * Returns the settings as a UTF-8 string containing XML.
	 *
	 * @return XML
	 * @throws CoreException
	 *             if something goes wrong
	 */
	public String getXML() throws CoreException {
		return Util.serializeDocument(fDoc);
	}

	/**
	 * Return the xml dom document this visitor generates. Use {@link #getXML()}
	 * to get the serialized xml string.
	 *
	 * @return xml dom document
	 */
	public Document getDocument() {
		return fDoc;
	}
}
/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 468079
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.developper.mde.transcription;

import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.papyrus.uml.developper.mde.I_DocumentStereotype;
import org.eclipse.papyrus.uml.developper.mde.LinkUtil;
import org.eclipse.papyrus.uml.developper.mde.LinkUtil.Hyperlink;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;

import com.google.common.base.Function;

/**
 * this class is a specialization to generate mediawiki files.
 *
 */
public class WikiTranscription implements ITranscription {

	private final Function<LinkUtil.Hyperlink, String> hyperlinkFunction = new Function<LinkUtil.Hyperlink, String>() {
		@Override
		public String apply(Hyperlink input) {
			return String.format("[[#%s|%s]]", input.href(), input.text());
		}
	};

	@Override
	public Function<? super Hyperlink, String> getHyperlinkTranscoder() {
		return hyperlinkFunction;
	}

	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeEndingDocument(java.lang.StringBuffer)
	 *
	 * @param out
	 */

	@Override
	public void writeEndingDocument(StringBuffer out) {
	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeBeginningDocument(java.lang.StringBuffer)
	 *
	 * @param out
	 * @return the string buffer after adding the prefix for the document
	 */

	@Override
	public StringBuffer writeBeginningDocument(StringBuffer out) {
		out.append("\n__TOC__"); //$NON-NLS-1$
		return out;
	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeDocumentTitle(java.lang.StringBuffer, org.eclipse.uml2.uml.Model)
	 *
	 * @param out
	 * @param documentModel
	 */

	@Override
	public void writeDocumentTitle(StringBuffer out, Model documentModel) {
		out.append("\n= " + documentModel.getName() + " ="); //$NON-NLS-1$ //$NON-NLS-2$
	}




	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writesectionTitle(java.lang.StringBuffer, int, org.eclipse.uml2.uml.Element)
	 *
	 * @param out
	 * @param level
	 * @param packageableElement
	 */

	@Override
	public void writeSectionTitle(StringBuffer out, int level, Element packageableElement) {
		if (level == 2) {
			out.append("\n==<span" + getId(packageableElement) + ">" + ((Package) packageableElement).getName() + "</span>=="); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (level == 3) {
			out.append("\n===<span" + getId(packageableElement) + ">" + ((Package) packageableElement).getName() + "</span>==="); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (level == 4) {
			out.append("\n====<span" + getId(packageableElement) + ">" + ((Package) packageableElement).getName() + "</span>===="); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (level == 5) {
			out.append("\n=====<span" + getId(packageableElement) + ">" + ((Package) packageableElement).getName() + "</span>====="); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (level == 4) {
			out.append("\n======<span" + getId(packageableElement) + ">" + ((Package) packageableElement).getName() + "</span>======"); //$NON-NLS-1$ //$NON-NLS-2$
		}

	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeImageRef(java.lang.StringBuffer, org.eclipse.uml2.uml.Element, org.eclipse.uml2.uml.Stereotype)
	 *
	 * @param out
	 * @param packageableElement
	 * @param imgRefStereotype
	 */

	@Override
	public void writeImageRef(StringBuffer out, Element packageableElement, Stereotype imgRefStereotype) {
		out.append("\n<br>\n[[Image:" + packageableElement.getValue(imgRefStereotype, I_DocumentStereotype.IMAGEREF_REF_ATT) + "|" + ((Comment) packageableElement).getBody() + "]]\n<br>''" + ((Comment) packageableElement).getBody() + "''<br>\n<br>"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeParagraph(java.lang.StringBuffer, org.eclipse.uml2.uml.Element)
	 *
	 * @param out
	 * @param packageableElement
	 */

	@Override
	public void writeParagraph(StringBuffer out, Element packageableElement) {
		out.append("\n<span" + getId(packageableElement) + ">" + ((Comment) packageableElement).getBody() + "</span><br>"); //$NON-NLS-1$
	}


	@Override
	public String getNameFile() {

		return "DeveloperDoc.mediawiki"; //$NON-NLS-1$
	}

	/**
	 * @return
	 */
	public String getId(Element packageableElement) {
		String packageableElementtFragment = ((XMIResource) packageableElement.eResource()).getID(packageableElement);
		String id = " id=\"" + packageableElementtFragment + "\"";
		return id;
	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeTable(java.lang.StringBuffer, java.lang.String)
	 *
	 * @param out
	 * @param tableCaption
	 */
	@Override
	public void writeTable(StringBuffer out, String tableCaption) {
		out.append("\n{| border=\"1\" cellpadding=\"20\" cellspacing=\"0\"\n");
		out.append("!ID\n");
		out.append("!Satisfied by\n");
		out.append("!Verified by");
	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeLine(java.lang.StringBuffer, java.lang.String, java.lang.String)
	 *
	 * @param out
	 * @param uri
	 * @param text
	 */
	@Override
	public void writeLine(StringBuffer out, String uri, String requirementName, String text) {
		if (uri.equals("")) {
			out.append(text);
		} else {
			out.append("[[#" + uri + "|" + text + "]]");
		}

	}

	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeNewLine(java.lang.StringBuffer)
	 *
	 * @param out
	 */
	@Override
	public void writeNewLine(StringBuffer out) {
		out.append("\n");

	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeBeginTRTag(java.lang.StringBuffer)
	 *
	 * @param out
	 */
	@Override
	public void writeBeginTRTag(StringBuffer out) {
		out.append("\n|-\n");
	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeEndTRTag(java.lang.StringBuffer)
	 *
	 * @param out
	 */
	@Override
	public void writeEndTRTag(StringBuffer out) {
		// TODO Auto-generated method stub

	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeEndingTable(java.lang.StringBuffer)
	 *
	 * @param out
	 */
	@Override
	public void writeEndingTable(StringBuffer out) {
		out.append("\n|}");
	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeBeginTDTag(java.lang.StringBuffer)
	 *
	 * @param out
	 */
	@Override
	public void writeBeginTDTag(StringBuffer out) {
		out.append("|");
	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeEndTDTag(java.lang.StringBuffer)
	 *
	 * @param out
	 */
	@Override
	public void writeEndTDTag(StringBuffer out) {
		out.append("\n");

	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeUncoveredRequirement(java.lang.StringBuffer, java.lang.String, java.lang.String)
	 *
	 * @param out
	 * @param uri
	 * @param reqID
	 */
	@Override
	public void writeRefContent(StringBuffer out, String uri, String requirementName, String reqID) {
		if (uri.equals("")) {
			out.append(reqID);
		} else {
			out.append("[[#" + uri + "|" + reqID + "]]");
		}
	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeBeginParagraph(java.lang.StringBuffer)
	 *
	 * @param out
	 */
	@Override
	public void writeBeginParagraph(StringBuffer out) {
		out.append("\n<span>");

	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeEndingParagraph(java.lang.StringBuffer)
	 *
	 * @param out
	 */
	@Override
	public void writeEndingParagraph(StringBuffer out) {
		out.append("</span>\n");

	}


	/**
	 * @see org.eclipse.papyrus.uml.developper.mde.transcription.ITranscription#writeTOCSection(java.lang.StringBuffer, java.lang.String, java.lang.String, int)
	 *
	 * @param out
	 * @param chapterName
	 * @param uri
	 * @param chapterNb
	 */
	@Override
	public void writeTOCSection(StringBuffer out, String chapterName, String uri) {
		out.append("\n:[[#" + uri + "|" + chapterName + "]]");
	}




}

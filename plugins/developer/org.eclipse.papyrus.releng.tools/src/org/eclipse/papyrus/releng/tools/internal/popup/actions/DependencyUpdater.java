/*******************************************************************************
 * Copyright (c) 2011, 2015 Mia-Software, CEA LIST, Christian W. Damus, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 366567 - [Releng] Tool to update rmaps
 *     Camille Letavernier (CEA LIST) - Generalize to support POMs
 *     Christian W. Damus (CEA) - Add support for updating Oomph setup models
 *     Christian W. Damus - Support updating of multiple selected files
 *      
 *******************************************************************************/
package org.eclipse.papyrus.releng.tools.internal.popup.actions;

import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.eclipse.b3.aggregator.Contribution;
import org.eclipse.b3.aggregator.MappedRepository;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.releng.tools.internal.Activator;
import org.eclipse.swt.widgets.Shell;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public abstract class DependencyUpdater {

	private final Pattern commentPattern = Pattern.compile("updateFrom\\s*\\(\\s*\"(.*?)\"\\s*,\\s*(\\d+)\\s*\\)"); //$NON-NLS-1$

	private final Pattern typicalBuildTimestampPattern = Pattern.compile("[NISMR](?:-\\d+\\.\\d+(?:\\.\\d+)?(?:M|RC)\\d[abcd]-)?20\\d\\d[-0-9]+"); //$NON-NLS-1$

	public DependencyUpdater() {
		super();
	}

	protected static final String PREFIX = "http://download.eclipse.org/"; //$NON-NLS-1$

	public abstract boolean canUpdate(IFile file);

	public void updateDocument(final Shell parentShell, final IFile mapFile, final EList<Contribution> contributions, final Map<Object, Object> context) throws CoreException {
		try {
			File rmapFile = mapFile.getLocation().toFile();

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(rmapFile);
			doc.normalize();
			Element documentElement = doc.getDocumentElement();

			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList uris = (NodeList) xpath.evaluate(getXpath(), documentElement, XPathConstants.NODESET);

			for (int i = 0; i < uris.getLength(); i++) {
				Node uri = uris.item(i);
				Node precedingComment = getPrecedingComment(uri);
				if (precedingComment != null) {
					String comment = getCommentContent(precedingComment);
					Matcher matcher = getCommentPattern().matcher(comment);
					if (matcher.find()) {
						String contributionName = matcher.group(1);
						int repositoryIndex = Integer.parseInt(matcher.group(2));
						Contribution contribution = findContribution(contributions, contributionName);
						if (contribution == null) {
							throw new RuntimeException("'updateFrom' failed: cannot find contribution with label \"" + contributionName + "\""); //$NON-NLS-1$ //$NON-NLS-2$
						}
						updateWithContribution(parentShell, uri, contribution, repositoryIndex, context);
					} else if (comment.contains("updateFrom")) { //$NON-NLS-1$
						throw new Exception("Wrong syntax for 'updateFrom' : should be " + getCommentSyntax()); //$NON-NLS-1$
					}
				}
			}

			save(doc, rmapFile);

			mapFile.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());

		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error updating map: " + e.getLocalizedMessage(), e)); //$NON-NLS-1$
		}
	}

	protected void save(Document document, File destination) throws Exception {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //$NON-NLS-1$

		StreamResult result = new StreamResult(destination);
		DOMSource source = new DOMSource(document);
		transformer.transform(source, result);
	}

	protected void updateWithContribution(final Shell parentShell, final Node uri, final Contribution contribution, final int repositoryIndex, final Map<Object, Object> context) {
		EList<MappedRepository> repositories = contribution.getRepositories();
		if (repositoryIndex >= repositories.size()) {
			throw new RuntimeException("wrong index in updateFrom(\"" + contribution.getLabel() + "\"" + repositoryIndex //$NON-NLS-1$ //$NON-NLS-2$
					+ ") : there are " + repositories.size() + " contributions"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		String location = repositories.get(repositoryIndex).getLocation();
		String current = getCurrentLocation(uri);

		if ((current == null) || !current.equals(location)) {
			if ((current == null) || current.isEmpty()
					|| isLocationSimilar(current, location) || promptToReplace(parentShell, contribution.getLabel(), current, location, context)) {
				updateUri(uri, location);
			}
		}
	}

	protected abstract String getCurrentLocation(Node uri);

	protected abstract void updateUri(Node uri, String location);

	protected Contribution findContribution(Iterable<? extends Contribution> contributions, final String contributionName) {
		Contribution matchingContribution = null;
		for (Contribution contribution : contributions) {
			if (contributionName.equalsIgnoreCase(contribution.getLabel())) {
				matchingContribution = contribution;
			}
		}
		return matchingContribution;
	}

	protected Node getPrecedingComment(final Node node) {
		Comment comment = null;
		Node previous = node.getPreviousSibling();
		while (previous != null) {
			if (previous.getNodeType() == Node.COMMENT_NODE) {
				comment = (Comment) previous;
				break;
			} else if (previous.getNodeType() != Node.TEXT_NODE) {
				break;
			}
			previous = previous.getPreviousSibling();
		}
		return comment;
	}

	protected Pattern getCommentPattern() {
		return commentPattern;
	}

	protected String getCommentContent(Node comment) {
		return comment.getTextContent();
	}

	protected String getCommentSyntax() {
		return "updateFrom(\"<contributionName>\",<index>)"; //$NON-NLS-1$
	}

	protected abstract String getXpath();

	protected boolean isLocationSimilar(String oldLocation, String newLocation) {
		boolean result = true; // Optimistically assume sameness if we can't find any build timestamps

		Matcher oldMatcher = typicalBuildTimestampPattern.matcher(oldLocation);
		Matcher newMatcher = typicalBuildTimestampPattern.matcher(newLocation);
		boolean foundOld = oldMatcher.find();
		boolean foundNew = newMatcher.find();

		if (foundOld != foundNew) {
			// definitely different
			result = false;
		} else if (foundNew) {
			// Compare prefixes
			String oldPrefix = oldLocation.substring(0, oldMatcher.start());
			String newPrefix = newLocation.substring(0, newMatcher.start());
			result = newPrefix.equals(oldPrefix);
		}

		return result;
	}

	protected boolean promptToReplace(Shell parentShell, String contributionName, String oldLocation, String newLocation, Map<Object, Object> context) {
		String key = "$replace$::" + contributionName; //$NON-NLS-1$
		Boolean result = (Boolean) context.get(key);

		if (result == null) {
			String message = NLS.bind("The new location \"{0}\" for project \"{1}\" is not like the current location \"{2}\". This could roll back to a previous (obsolete) version. Update anyways?", new Object[] { newLocation, contributionName, oldLocation });
			result = MessageDialog.openQuestion(parentShell, "Confirm Location Update", message);
			context.put(key, result);
		}

		return result;
	}
}

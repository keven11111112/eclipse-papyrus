/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eclipse.project.editors.project;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.eclipse.project.editors.Activator;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IFeatureProjectEditor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FeatureProjectEditor extends ProjectEditor implements IFeatureProjectEditor {

	/** the name of the file feature.xml */
	public static final String FRAGMENT_XML_FILE = "feature.xml"; //$NON-NLS-1$

	private static final String ID = "id"; //$NON-NLS-1$
	private static final String LABEL = "label"; //$NON-NLS-1$
	private static final String VERSION = "version"; //$NON-NLS-1$
	private static final String PROVIDER = "provider-name"; //$NON-NLS-1$

	private static final String URL = "url"; //$NON-NLS-1$
	private static final String COPYRIGHT = "copyright"; //$NON-NLS-1$
	private static final String LICENSE = "license"; //$NON-NLS-1$
	private static final String DESCRIPTION = "description"; //$NON-NLS-1$

	private static final String OS = "os"; //$NON-NLS-1$
	private static final String WS = "ws"; //$NON-NLS-1$
	private static final String NL = "nl"; //$NON-NLS-1$
	private static final String ARCH = "arch"; //$NON-NLS-1$
	private static final String UPDATE = "update"; //$NON-NLS-1$

	private static final String PLUGIN = "plugin"; //$NON-NLS-1$
	private static final String IMPORT = "import"; //$NON-NLS-1$
	private static final String INCLUDES = "includes"; //$NON-NLS-1$
	private static final String REQUIRES = "requires"; //$NON-NLS-1$
	private static final String FEATURE = "feature"; //$NON-NLS-1$

	// TODO pour l'externalization : utiliser l'éditeur de Properties! dans java Utils

	private Document fragmentXML;

	private IFile fragmentFile;

	private Element fragmentRoot;

	/**
	 * Constructor.
	 *
	 * @param project the eclipse project
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws CoreException
	 */
	public FeatureProjectEditor(final IProject project) throws ParserConfigurationException, SAXException, IOException, CoreException {
		super(project);
	}

	@Override
	public void init() {
		fragmentFile = getFeature();
		if (fragmentFile != null && fragmentFile.exists()) {
			final DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
				fragmentXML = documentBuilder.parse(fragmentFile.getLocation().toOSString());
				fragmentRoot = fragmentXML.getDocumentElement();
			} catch (final ParserConfigurationException e) {
				Activator.log.error(e);
			} catch (final SAXException e) {
				Activator.log.error(e);
			} catch (final IOException e) {
				Activator.log.error(e);
			}
		}
	}

	@Override
	public void createFiles(final Set<String> files) {
		if (files.contains(FRAGMENT_XML_FILE)) {
			fragmentFile = getProject().getFile(FRAGMENT_XML_FILE);
			if (!fragmentFile.exists()) {
				InputStream content = getInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<feature>\n</feature>\n\n"); //$NON-NLS-1$

				try {
					fragmentFile.create(content, true, null);
				} catch (CoreException e) {
					Activator.log.error(e);
				}
			}
		}
	}

	@Override
	public boolean exists() {
		return getFeature().exists() && super.exists();
	}

	public void setAttribute(final Element element, final String attributeName, final String attributeValue) {
		element.setAttribute(attributeName, attributeValue);
	}

	/**
	 * @return the feature.xml file if it exists
	 */
	private IFile getFeature() {
		final IFile fragment = getProject().getFile(FRAGMENT_XML_FILE);

		if (fragment.exists()) {
			return fragment;
		}

		return null;
	}

	@Override
	public void save() {
		if (exists()) {
			try {
				final TransformerFactory transformerFactory = TransformerFactory.newInstance();
				final Transformer transformer = transformerFactory.newTransformer();
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); //$NON-NLS-1$
				final StreamResult result = new StreamResult(new StringWriter());
				final DOMSource source = new DOMSource(fragmentXML);
				transformer.transform(source, result);

				final InputStream inputStream = getInputStream(result.getWriter().toString());
				fragmentFile.setContents(inputStream, true, true, null);
			} catch (final TransformerException ex) {
				Activator.log.error(ex);
			} catch (final CoreException ex) {
				Activator.log.error(ex);
			}
		}
		super.save();
	}

	@Override
	public Set<String> getMissingNature() {
		// TODO
		return Collections.emptySet();
	}

	@Override
	public Set<String> getMissingFiles() {
		// TODO
		return Collections.emptySet();
	}

	@Override
	public Set<String> getMissingBuildCommand() {
		// TODO
		return Collections.emptySet();
	}

	public Document getDocument() {
		return fragmentXML;
	}

	public String getId() {
		return fragmentRoot.getAttribute(ID);
	}

	public String getLabel() {
		return fragmentRoot.getAttribute(LABEL);
	}

	public String getVersion() {
		return fragmentRoot.getAttribute(VERSION);
	}

	public String getProviderName() {
		return fragmentRoot.getAttribute(PROVIDER);
	}

	public String getDescriptionText() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescriptionURL() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCopyrightURL() {
		final Element copyrightNode = getNode(COPYRIGHT);
		if (copyrightNode != null) {
			final String value = copyrightNode.getAttribute("url");
			if (value != null && value.startsWith("%")) {
				final IFile file = getProject().getFile("feature.properties");
				final Properties prop = new Properties(); // TODO create a method to use Properties for others fields too
				try {
					prop.load(file.getContents());
				} catch (final IOException e) {
					Activator.log.error(e);
				} catch (final CoreException e) {
					Activator.log.error(e);
				}
				final Object val = prop.get("url");
				if (val != null) {
					return (String) val;
				}
			}
			return copyrightNode.getAttribute("url");
		}
		return null;
	}

	public String getCopyrightText() {
		final Element copyrightNode = getNode(COPYRIGHT);

		return copyrightNode != null ? copyrightNode.getTextContent() : null;
	}

	public String getLicenseText() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLicenceURL() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOS() {
		return fragmentRoot.getAttribute(OS);
	}

	public String getWS() {
		return fragmentRoot.getAttribute(WS);
	}

	public String getNL() {
		return fragmentRoot.getAttribute(NL);
	}

	public String getArch() {
		return fragmentRoot.getAttribute(ARCH);
	}

	public void setId(final String id) {
		fragmentRoot.setAttribute(ID, id);
	}

	public void setLabel(final String label) {
		fragmentRoot.setAttribute(LABEL, label);
	}

	public void setVersion(final String version) {
		fragmentRoot.setAttribute(VERSION, version);
	}

	public void setProviderName(final String providerName) {
		fragmentRoot.setAttribute(PROVIDER, providerName);
	}

	public void setDescription(final String descriptionURL, final String description) {
		if (exists()) {
			Element extension = getNode(DESCRIPTION);

			if (extension == null) {
				extension = fragmentXML.createElement(DESCRIPTION);
				fragmentRoot.appendChild(extension);
			}

			extension.setAttribute(URL, descriptionURL);
			extension.setTextContent(description);
		}
	}

	public void setCopyright(final String copyrightURL, final String copyrightDesc) {
		setURLNode(COPYRIGHT, copyrightURL, copyrightDesc);
	}

	public void setLicense(final String licenseURL, final String licenseDesc) {
		setURLNode(LICENSE, licenseURL, licenseDesc);
	}

	public void setOS(final String os) {
		fragmentRoot.setAttribute(OS, os);
	}

	public void setWS(final String ws) {
		fragmentRoot.setAttribute(WS, ws);
	}

	public void setNL(final String nl) {
		fragmentRoot.setAttribute(NL, nl);
	}

	public void setArch(final String architecture) {
		fragmentRoot.setAttribute(ARCH, architecture);
	}

	public void setUpdateURL(final String urlLabel, final String url) {
		Element urlNode = getNode(URL);

		if (urlNode == null) {
			urlNode = createElement(URL);
			fragmentRoot.appendChild(urlNode);
		}

		Element updateNode = getNodeChild(UPDATE, urlNode);
		if (updateNode == null) {
			updateNode = createElement(UPDATE);
			urlNode.appendChild(updateNode);
		}

		updateNode.setAttribute(LABEL, urlLabel);
		updateNode.setAttribute(URL, url);
	}

	public void addPlugin(final String pluginName) {
		// Get the plug-in element or create it if it does not exist
		Element pluginNode = getPlugin(pluginName);

		if (pluginNode == null) {
			pluginNode = createElement(PLUGIN);
			fragmentRoot.appendChild(pluginNode);
		}

		// Set the id on the element
		pluginNode.setAttribute(ID, pluginName);
	}

	public void addRequiredFeature(final String featureName, final String version) {
		// Make sure the "requires" element exists
		Element requires = getNode(REQUIRES);

		if (requires == null) {
			requires = createElement(REQUIRES);
			fragmentRoot.appendChild(requires);
		}

		// Get or create the required feature element
		Element feature = getRequiredFeature(featureName);

		if (feature == null) {
			feature = createElement(IMPORT);
			requires.appendChild(feature);
		}

		// Set the element values
		feature.setAttribute(FEATURE, featureName);
		feature.setAttribute(VERSION, version);
	}

	public void addRequiredPlugin(final String pluginName) {
		// Make sure the "requires" element exists
		Element requires = getNode(REQUIRES);

		if (requires == null) {
			requires = createElement(REQUIRES);
			fragmentRoot.appendChild(requires);
		}

		// Get or create the plug-in element
		Element plugin = getRequiredPlugin(pluginName);

		if (plugin == null) {
			plugin = createElement(IMPORT);
			requires.appendChild(plugin);
		}

		plugin.setAttribute(PLUGIN, pluginName);
	}

	public void addInclude(final String featureName, final String version) {
		Element includeNode = getInclude(featureName);

		if (includeNode == null) {
			includeNode = createElement(INCLUDES);
			fragmentRoot.appendChild(includeNode);
		}

		includeNode.setAttribute(ID, featureName);
		includeNode.setAttribute(VERSION, version);
	}

	/**
	 * Creates an element and returns it.
	 *
	 * @param elementName the name of the element to create
	 * @return the created element
	 */
	private Element createElement(String elementName) {
		return fragmentXML.createElement(elementName);
	}

	protected void setURLNode(final String nodeName, final String url, final String description) {
		if (exists()) {
			Element extension = getNode(nodeName);
			if (extension == null) {
				extension = fragmentXML.createElement(nodeName);
				if (url != null) {
					extension.setAttribute(URL, url);
				}
				extension.setTextContent(description);
				fragmentRoot.appendChild(extension);
			} else {
				if (url != null) {
					extension.setAttribute(URL, url);
				}
				extension.setTextContent(description);
			}
		}
	}

	/**
	 * Gets an element inside a parent element.
	 *
	 * @param parentElement
	 * @param nodeName the node name of the element
	 * @param attributeValue the value of the element's attribute to retrieve
	 * @return the element or null if it does not exist
	 */
	private Element getElement(final Element parentElement, final String nodeName, final String attributeName, final String attributeValue) {
		NodeList childNodes = parentElement.getChildNodes();

		for (int i = 0; i < childNodes.getLength(); i++) {
			Node item = childNodes.item(i);

			if (nodeName.equals(item.getNodeName())) {
				if (attributeValue.equals(getNodeAttribute(item, attributeName))) {
					if (item instanceof Element) {
						return (Element) item;
					}
				}
			}
		}

		return null;
	}

	private Element getNodeChild(final String childName, final Element node) {
		NodeList childNodes = node.getChildNodes();

		if (childNodes == null) {
			return null;
		}

		for (int i = 0; i < childNodes.getLength(); i++) {
			Node item = childNodes.item(i);

			if (item.getNodeName().equals(childName)) {
				if (item instanceof Element) {
					return (Element) item;
				}
			}
		}

		return null;
	}

	/**
	 * Gets a node element inside the root element.
	 *
	 * @param nodeName the node name
	 * @return the node element or null if it does not exist.
	 */
	private Element getNode(final String nodeName) {
		if (exists()) {
			final NodeList nodes = fragmentRoot.getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				final Node item = nodes.item(i);
				if (item instanceof NodeList) {
					final String name = item.getNodeName();
					if (name.equals(nodeName)) {
						if (item instanceof Element) {
							return (Element) item;
						}
					}
				}
			}
		}

		return null;
	}

	private Element getPlugin(String pluginName) {
		return getElement(fragmentRoot, PLUGIN, ID, pluginName);
	}

	private Element getInclude(String featureName) {
		return getElement(fragmentRoot, INCLUDES, ID, featureName);
	}

	/**
	 * @param pluginName
	 * @return
	 */
	private Element getRequiredPlugin(String pluginName) {
		Element requires = getNode(REQUIRES);

		if (requires != null) {
			return getElement(requires, IMPORT, PLUGIN, pluginName);
		}

		return null;
	}

	private String getNodeAttribute(Node node, String name) {
		Node attribute = node.getAttributes().getNamedItem(name);

		return attribute != null ? attribute.getNodeValue() : null;
	}

	private Element getRequiredFeature(String featureName) {
		Element requires = getNode(REQUIRES);

		if (requires != null) {
			return getElement(requires, IMPORT, FEATURE, featureName);
		}

		return null;
	}

}

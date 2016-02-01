/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.elementtypesconfigurations.developer.handlers;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MigrateElementTypesConfigurations extends AbstractHandler {


	public Object execute(ExecutionEvent event) throws ExecutionException {

		final String FILE_EXTENSION = "elementtypesconfigurations";

		final String ELEMENTTYPECONFIGURATION_NAMESPACE_ATTRIBUTE = "xmlns:elementtypesconfigurations";
		final String ELEMENTTYPECONFIGURATION_NAMESPACE_OLD = "http://www.eclipse.org/papyrus/infra/elementtypesconfigurations/1.0";
		final String ELEMENTTYPECONFIGURATION_NAMESPACE_NEW = "http://www.eclipse.org/papyrus/infra/elementtypesconfigurations/1.1";

		final String APPLYSTEREOTYPEADVICECONFIGURATION_NAMESPACE_ATTRIBUTE = "xmlns:applystereotypeadviceconfiguration";
		final String APPLYSTEREOTYPEADVICECONFIGURATION_NAMESPACE_NEW = "http://www.eclipse.org/papyrus/infra/elementtypesconfigurations/uml/applystereotypeadvice/1.1";

		final String INVARIANTSTEREOTYPERULECONFIGURATION_NAMESPACE_ATTRIBUTE = "xmlns:invariantstereotyperuleconfiguration";
		final String INVARIANTSTEREOTYPERULECONFIGURATION_NAMESPACE_NEW = "http://www.eclipse.org/papyrus/infra/elementtypesconfigurations/invariantstereotyperule/1.1";

		final String SETTYPEADVICECONFIGURATION_NAMESPACE_ATTRIBUTE = "xmlns:settypeadviceconfiguration";
		final String SETTYPEADVICECONFIGURATION_NAMESPACE_NEW = "http://www.eclipse.org/papyrus/infra/elementtypesconfigurations/uml/settypeadvice/1.1";

		final String STEREOTYPEAPPLICATIONMATCHERCONFIGURATION_NAMESPACE_ATTRIBUTE = "xmlns:stereotypeapplicationmatcherconfiguration";
		final String STEREOTYPEAPPLICATIONMATCHERCONFIGURATION_NAMESPACE_NEW = "http://www.eclipse.org/payrus/elementtypesconfigurations/uml/stereotypematcherconfiguration/1.1";

		final String INVARIANTCONTAINERRULECONFIGURATION_NAMESPACE_ATTRIBUTE = "xmlns:invariantcontainerruleconfiguration";
		final String INVARIANTCONTAINERRULECONFIGURATION_NAMESPACE_NEW = "http://www.eclipse.org/papyrus/infra/elementtypesconfigurations/invarianttypeconfiguration/containerruleconfiguration/1.1";

		final String RUNTIMEVALUESEDITIONADVICECONFIGURATION_NAMESPACE_ATTRIBUTE = "xmlns:runtimevalueseditionadviceconfiguration";
		final String RUNTIMEVALUESEDITIONADVICECONFIGURATION_NAMESPACE_NEW = "http://www.eclipse.org/papyrus/infra/elementtypesconfigurations/emf/runtimevalueseditionadviceconfiguration/1.1";

		final String SETVALUESADVICECONFIGURATION_NAMESPACE_ATTRIBUTE = "xmlns:setvaluesadviceconfiguration";
		final String SETVALUESADVICECONFIGURATION_NAMESPACE_NEW = "http://www.eclipse.org/papyrus/infra/elementtypesconfigurations/emf/setvaluesadviceconfiguration/1.1";

		final String INVARIANTTYPECONFIGURATION_NAMESPACE_ATTRIBUTE = "xmlns:invarianttypeconfiguration";
		final String INVARIANTTYPECONFIGURATION_NAMESPACE_NEW = "http://www.eclipse.org/papyrus/infra/elementtypesconfigurations/invarianttype/1.1";



		final String TYPE_ATTRIBUTE = "xsi:type";
		final String EDITHELPERADVICECONFIGURATION_TAG = "editHelperAdviceConfiguration";
		final String MATCHERCONFIGURATION_TAG = "matcherConfiguration";
		final String NAME_ATTRIBUTE = "name";
		final String IDENTIFIER_ATTRIBUTE = "identifier";
		final String EDITHELPERADVICECLASSNAME_ATTRIBUTE = "editHelperAdviceClassName";
		final String ADVICEBINDINGSCONFIGURATIONS_TAG = "adviceBindingsConfigurations";
		final String MATCHER_TYPE = "elementtypesconfigurations:MatcherConfiguration";
		final String ADVICEBINDINGCONFIGURATION_TYPE = "elementtypesconfigurations:AdviceBindingConfiguration";
		final String EDITHELPERADVICECONFIGURATION_TYPE = "elementtypesconfigurations:EditHelperAdviceConfiguration";
		final String MATCHERCLASSNAME_ATTRIBUTE = "matcherClassName";


		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (!(currentSelection instanceof IStructuredSelection) || currentSelection.isEmpty()) {
			return null;
		}

		final IStructuredSelection selection = (IStructuredSelection) currentSelection;

		Iterator<?> it = selection.iterator();

		while (it.hasNext()) {
			Object selectedElement = (Object) it.next();

			if (selectedElement instanceof IFile) {
				if (FILE_EXTENSION.equals(((IFile) selectedElement).getFileExtension())) {
					IFile selectedFile = ((IFile) selectedElement);
					URI uri = selectedFile.getLocationURI();

					if (selectedFile.isLinked()) {
						uri = selectedFile.getRawLocationURI();
					}

					try {
						File file = EFS.getStore(uri).toLocalFile(0, new NullProgressMonitor());
						DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
						DocumentBuilder builder = factory.newDocumentBuilder();
						Document doc = builder.parse(file);
						Element root = doc.getDocumentElement();

						if (root.getAttribute(ELEMENTTYPECONFIGURATION_NAMESPACE_ATTRIBUTE).equals(ELEMENTTYPECONFIGURATION_NAMESPACE_OLD)) {

							// Update namespaces
							root.setAttribute(ELEMENTTYPECONFIGURATION_NAMESPACE_ATTRIBUTE, ELEMENTTYPECONFIGURATION_NAMESPACE_NEW);

							if (!root.getAttribute(APPLYSTEREOTYPEADVICECONFIGURATION_NAMESPACE_ATTRIBUTE).isEmpty()) {
								root.setAttribute(APPLYSTEREOTYPEADVICECONFIGURATION_NAMESPACE_ATTRIBUTE, APPLYSTEREOTYPEADVICECONFIGURATION_NAMESPACE_NEW);
							}

							if (!root.getAttribute(INVARIANTSTEREOTYPERULECONFIGURATION_NAMESPACE_ATTRIBUTE).isEmpty()) {
								root.setAttribute(INVARIANTSTEREOTYPERULECONFIGURATION_NAMESPACE_ATTRIBUTE, INVARIANTSTEREOTYPERULECONFIGURATION_NAMESPACE_NEW);
							}

							if (!root.getAttribute(SETTYPEADVICECONFIGURATION_NAMESPACE_ATTRIBUTE).isEmpty()) {
								root.setAttribute(SETTYPEADVICECONFIGURATION_NAMESPACE_ATTRIBUTE, SETTYPEADVICECONFIGURATION_NAMESPACE_NEW);
							}

							if (!root.getAttribute(STEREOTYPEAPPLICATIONMATCHERCONFIGURATION_NAMESPACE_ATTRIBUTE).isEmpty()) {
								root.setAttribute(STEREOTYPEAPPLICATIONMATCHERCONFIGURATION_NAMESPACE_ATTRIBUTE, STEREOTYPEAPPLICATIONMATCHERCONFIGURATION_NAMESPACE_NEW);
							}

							if (!root.getAttribute(INVARIANTCONTAINERRULECONFIGURATION_NAMESPACE_ATTRIBUTE).isEmpty()) {
								root.setAttribute(INVARIANTCONTAINERRULECONFIGURATION_NAMESPACE_ATTRIBUTE, INVARIANTCONTAINERRULECONFIGURATION_NAMESPACE_NEW);
							}

							if (!root.getAttribute(RUNTIMEVALUESEDITIONADVICECONFIGURATION_NAMESPACE_ATTRIBUTE).isEmpty()) {
								root.setAttribute(RUNTIMEVALUESEDITIONADVICECONFIGURATION_NAMESPACE_ATTRIBUTE, RUNTIMEVALUESEDITIONADVICECONFIGURATION_NAMESPACE_NEW);
							}

							if (!root.getAttribute(SETVALUESADVICECONFIGURATION_NAMESPACE_ATTRIBUTE).isEmpty()) {
								root.setAttribute(SETVALUESADVICECONFIGURATION_NAMESPACE_ATTRIBUTE, SETVALUESADVICECONFIGURATION_NAMESPACE_NEW);
							}

							if (!root.getAttribute(INVARIANTTYPECONFIGURATION_NAMESPACE_ATTRIBUTE).isEmpty()) {
								root.setAttribute(INVARIANTTYPECONFIGURATION_NAMESPACE_ATTRIBUTE, INVARIANTTYPECONFIGURATION_NAMESPACE_NEW);
							}

							NodeList editHelperAdviceConfigurations = root.getElementsByTagName(EDITHELPERADVICECONFIGURATION_TAG);

							for (int i = 0; i < editHelperAdviceConfigurations.getLength(); i++) {
								Element editHelperAdvice = (Element) editHelperAdviceConfigurations.item(i);

								Node type = editHelperAdvice.getAttributes().getNamedItem(TYPE_ATTRIBUTE);

								if (type == null) {
									editHelperAdvice.setAttribute(TYPE_ATTRIBUTE, EDITHELPERADVICECONFIGURATION_TYPE);
								} else if (!type.getNodeValue().equals(EDITHELPERADVICECONFIGURATION_TYPE)) {
									editHelperAdvice.removeAttribute(EDITHELPERADVICECLASSNAME_ATTRIBUTE);
								}

								editHelperAdvice.removeAttribute(NAME_ATTRIBUTE);
								editHelperAdvice.removeAttribute(IDENTIFIER_ATTRIBUTE);
							}

							NodeList adviceBindingsConfigurations = root.getElementsByTagName(ADVICEBINDINGSCONFIGURATIONS_TAG);

							for (int i = 0; i < adviceBindingsConfigurations.getLength(); i++) {
								Element adviceBinding = (Element) adviceBindingsConfigurations.item(i);

								Node type = adviceBinding.getAttributes().getNamedItem(TYPE_ATTRIBUTE);

								if (type == null) {
									adviceBinding.setAttribute(TYPE_ATTRIBUTE, ADVICEBINDINGCONFIGURATION_TYPE);
								} else if (!type.getNodeValue().equals(ADVICEBINDINGCONFIGURATION_TYPE)) {
									adviceBinding.removeAttribute(EDITHELPERADVICECLASSNAME_ATTRIBUTE);
								}

								adviceBinding.removeAttribute(NAME_ATTRIBUTE);
							}

							NodeList matcherConfigurations = root.getElementsByTagName(MATCHERCONFIGURATION_TAG);

							for (int i = 0; i < matcherConfigurations.getLength(); i++) {
								Element matcher = (Element) matcherConfigurations.item(i);

								Node type = matcher.getAttributes().getNamedItem(TYPE_ATTRIBUTE);

								if (type == null) {
									matcher.setAttribute(TYPE_ATTRIBUTE, MATCHER_TYPE);
								} else {
									matcher.removeAttribute(MATCHERCLASSNAME_ATTRIBUTE);
								}
							}

							Transformer transformer = TransformerFactory.newInstance().newTransformer();
							Result output = new StreamResult(file);
							Source input = new DOMSource(doc);

							transformer.transform(input, output);
						}

					} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerFactoryConfigurationError e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

		}
		return null;
	}





}

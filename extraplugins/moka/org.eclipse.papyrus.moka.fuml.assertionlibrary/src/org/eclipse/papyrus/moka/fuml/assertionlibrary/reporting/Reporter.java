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
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.assertionlibrary.reporting;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class Reporter {

	protected List<TestReport> testReports;

	private Reporter() {
		this.testReports = new ArrayList<TestReport>();
	}

	public static Reporter INSTANCE = new Reporter();

	public boolean add(TestReport report) {
		return this.testReports.add(report);
	}

	public Document getReport() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document xmlReport = builder.newDocument();
		Element testSuiteNode = xmlReport.createElement(JUnit.TEST_SUITE);
		testSuiteNode.setAttribute(JUnit.NAME, "Unknown"); //TODO
		for(TestReport t : this.testReports) {
			testSuiteNode.appendChild(this.toDOMElement(t, xmlReport));
		}
		xmlReport.appendChild(testSuiteNode);
		this.testReports.clear();
		return xmlReport;
	}

	protected Element toDOMElement(TestReport test, Document context) {
		Element testNode = context.createElement(JUnit.TEST_CASE);
		if(test.getContext() != null) {
			testNode.setAttribute(JUnit.CLASS_NAME, test.getContext().getQualifiedName());
		} else {
			testNode.setAttribute(JUnit.CLASS_NAME, "unknown");
		}
		testNode.setAttribute(JUnit.NAME, test.getLabel());
		testNode.setAttribute(JUnit.TIME, "0"); //TODO obtain elapsed time per test case
		if(test.getVerdict().equals(TestDecision.FAILED)) {
			Element failureNode = context.createElement(JUnit.FAILURE);
			failureNode.setAttribute(JUnit.MESSSAGE, test.getLabel());
			failureNode.setAttribute(JUnit.TYPE, test.getAssertionType().getName());
			testNode.appendChild(failureNode);
		}
		return testNode;
	}
}

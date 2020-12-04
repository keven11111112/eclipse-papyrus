/******************************************************************************
 * Copyright (c) 2005, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.genmodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.gmf.gmfgraph.Identity;
import org.eclipse.papyrus.gmf.mappings.AuditContainer;
import org.eclipse.papyrus.gmf.mappings.CanvasMapping;
import org.eclipse.papyrus.gmf.mappings.LinkMapping;
import org.eclipse.papyrus.gmf.mappings.MetricContainer;
import org.eclipse.papyrus.gmf.mappings.TopNodeReference;

/**
 * Creates bare extended version of basic Diagram Run-Time model from gmfmap. 
 * This extended version is expected to be modified by toolsmith to capture additional
 * attributes/features of diagram.
 * @author artem
 */
public class DiagramRunTimeModelTransformer extends MappingTransformer {
	private final EPackage myPackage;

	public DiagramRunTimeModelTransformer(String modelName, String modelNsURI) {
		myPackage = EcoreFactory.eINSTANCE.createEPackage();
		myPackage.setName(modelName);
		myPackage.setNsPrefix(modelName+"-drt");
		myPackage.setNsURI(modelNsURI);
	}

	public EPackage getResult() {
		return myPackage;
	}

	protected void process(CanvasMapping cme) {
		addEClass(cme.getDiagramCanvas(), NotationPackage.eINSTANCE.getDiagram());
	}

	protected void process(TopNodeReference topNode) {
		addEClass(topNode.getChild().getDiagramNode(), NotationPackage.eINSTANCE.getNode());
	}

	protected void process(LinkMapping lme) {
		addEClass(lme.getDiagramLink(), NotationPackage.eINSTANCE.getEdge());
	}

	private void addEClass(Identity diaDefElement, EClass superClass) {
		EClass c = createEClass(diaDefElement.getName(), superClass);
		myPackage.getEClassifiers().add(c);
//		for (Iterator it = diaDefElement.getProperties().iterator(); it.hasNext();) {
//			RunTimeProperty p = (RunTimeProperty) it.next();
//			EAttribute a = EcoreFactory.eINSTANCE.createEAttribute();
//			a.setName(p.getName());
//			a.setEType(EcorePackage.eINSTANCE.getEString());
//			c.getEStructuralFeatures().add(a);
//		}
	}

	private EClass createEClass(String name, EClass superClass) {
		EClass c = EcoreFactory.eINSTANCE.createEClass();
		c.setName(name);
		c.getESuperTypes().add(superClass);
		return c;
	}

	protected void process(AuditContainer audits) {
	}

	protected void process(MetricContainer metrics) {
	}
}

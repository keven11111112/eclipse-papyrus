/*******************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 464647
 *     
 ******************************************************************************/
package org.eclipse.papyrus.tests.framework.gmfgen2uml;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.papyrus.tests.framework.gmfgenuml2utp.GMFGen2UTPComponent;
import org.eclipse.uml2.uml.Model;

import com.google.common.collect.Iterables;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * A workflow component that configures and runs a transformation of a GMFGen model to its UML representation.
 * The output is intended as an input to the UTP model generation.
 * 
 * @see GMFGen2UTPComponent
 */
public class GMFGen2UMLComponent extends WorkflowComponentWithModelSlot {

	private Log log = LogFactory.getLog(getClass());

	private String metamodelSlot;

	private String outputSlot;

	public GMFGen2UMLComponent() {
		super();
	}

	public String getMetamodelSlot() {
		return metamodelSlot;
	}

	public void setMetamodelSlot(String metamodelSlot) {
		this.metamodelSlot = metamodelSlot;
	}

	public String getOutputSlot() {
		return outputSlot;
	}

	public void setOutputSlot(String outputSlot) {
		this.outputSlot = outputSlot;
	}

	protected GMFGen2UMLModule createGMFGen2UMLModule(WorkflowContext ctx) {
		return new GMFGen2UMLModule((Model) ctx.get(getMetamodelSlot()));
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {

		log.info("Transforming GMFGen to UML ...");
		Object modelSlotContent = ctx.get(getModelSlot());
		GenEditorGenerator model = null;
		if (modelSlotContent instanceof GenEditorGenerator) {
			model = (GenEditorGenerator) modelSlotContent;
		} else if (modelSlotContent instanceof List) {
			List<?> slotContentList = (List<?>) modelSlotContent;
			model = Iterables.getFirst(Iterables.filter(slotContentList, GenEditorGenerator.class), null);
		}
		if ((model == null) || !(model instanceof GenEditorGenerator)) {
			log.error("The input model for the transformation was not loaded!");
			return;
		}

		Injector injector = Guice.createInjector(createGMFGen2UMLModule(ctx));

		GMFGen2UML transformation = injector.getInstance(GMFGen2UML.class);

		Model uml = transformation.toUMLModel(model);

		ctx.set(getOutputSlot(), uml);
		log.info("The transformation successfully created Model " + uml.getLabel());
	}

}

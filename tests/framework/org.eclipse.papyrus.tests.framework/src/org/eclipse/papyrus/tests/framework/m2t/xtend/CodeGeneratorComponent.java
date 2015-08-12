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
package org.eclipse.papyrus.tests.framework.m2t.xtend;


import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;
import org.eclipse.papyrus.tests.framework.m2t.xtend.templates.CodegenContext;
import org.eclipse.papyrus.tests.framework.m2t.xtend.templates.PapyrusDiagramCanonicalTests;
import org.eclipse.uml2.uml.Model;

import com.google.common.base.Supplier;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * The step in the test framework workflow that generates the test code from the UML-UTP test model.
 */
public class CodeGeneratorComponent extends WorkflowComponentWithModelSlot {

	private String tempSrcPath = null;
	private Log log = LogFactory.getLog(getClass());

	private final Injector injector;

	@Inject
	private PapyrusDiagramCanonicalTests canonicalTests;

	@Inject
	private CodegenContext codegenContext;

	public CodeGeneratorComponent(Supplier<? extends CodeGeneratorModule> codegenModule) {
		injector = Guice.createInjector(codegenModule.get());
		injector.injectMembers(this);
	}

	public String getTempSrcPath() {
		return tempSrcPath;
	}

	public void setTempSrcPath(String tempSrcPath) {
		this.tempSrcPath = tempSrcPath;
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		log.info("Generating code...");
		Object modelSlotContent = ctx.get(getModelSlot());
		Model model = null;
		if (modelSlotContent instanceof Model) {
			model = (Model) modelSlotContent;
		} else if (modelSlotContent instanceof List) {
			List<?> slotContentList = (List<?>) modelSlotContent;
			model = (Model) slotContentList.get(0);
		}
		if (model == null || !(model instanceof Model)) {
			log.error("The input model for the generation was not loaded!");
		}
		EcoreUtil.resolveAll(model);

		codegenContext.setOutputFolderPath(tempSrcPath);
		codegenContext.setResourceLoader(ResourceLoaderFactory.createResourceLoader());

		canonicalTests.generate(model);
		log.info("The code was succesfully generated in " + tempSrcPath);
	}

}

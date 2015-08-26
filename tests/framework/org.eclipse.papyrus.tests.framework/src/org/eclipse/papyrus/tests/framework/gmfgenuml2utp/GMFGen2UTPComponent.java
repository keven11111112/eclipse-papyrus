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
package org.eclipse.papyrus.tests.framework.gmfgenuml2utp;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.AbstractEMFWorkflowComponent;
import org.eclipse.papyrus.tests.framework.exceptions.TestExceptions;
import org.eclipse.papyrus.tests.framework.gmfgen2uml.GMFGen2UMLComponent;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.xtext.xbase.lib.Functions.Function3;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * A workflow component that configures and runs a transformation of the UML representation of a
 * GMFGen model to a UML-UTP model describing the tests to be generated for that diagram.
 * 
 * @see GMFGen2UMLComponent
 */
public class GMFGen2UTPComponent extends AbstractEMFWorkflowComponent {

	private Log log = LogFactory.getLog(getClass());

	private String metamodelSlot;

	private String frameworkBaseSlot;

	private String utpSlot;

	private String outputSlot;

	private Function3<Model, Model, Profile, GMFGen2UTPModule> utpModule;

	public GMFGen2UTPComponent() {
		super();
	}

	public String getMetamodelSlot() {
		return metamodelSlot;
	}

	public void setMetamodelSlot(String metamodelSlot) {
		this.metamodelSlot = metamodelSlot;
	}

	public String getFrameworkBaseSlot() {
		return frameworkBaseSlot;
	}

	public void setFrameworkBaseSlot(String frameworkBaseSlot) {
		this.frameworkBaseSlot = frameworkBaseSlot;
	}

	public String getUtpSlot() {
		return utpSlot;
	}

	public void setUtpSlot(String utpSlot) {
		this.utpSlot = utpSlot;
	}

	public String getOutputSlot() {
		return outputSlot;
	}

	public void setOutputSlot(String outputSlot) {
		this.outputSlot = outputSlot;
	}

	public Function3<Model, Model, Profile, GMFGen2UTPModule> getUtpModule() {
		return utpModule;
	}

	public void setUtpModule(Function3<Model, Model, Profile, GMFGen2UTPModule> utpModule) {
		this.utpModule = utpModule;
	}

	protected GMFGen2UTPModule createGMFGen2UTPModule(WorkflowContext ctx, Collection<TestExceptions> testExceptions) {
		TestExceptionManager excmgr = new TestExceptionManager(testExceptions);

		GMFGen2UTPModule result = getUtpModule().apply(
				(Model) ctx.get(getMetamodelSlot()),
				(Model) ctx.get(getFrameworkBaseSlot()),
				(Profile) ctx.get(getUtpSlot()));
		result.setTestExceptionManager(excmgr);

		return result;
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {

		log.info("Transforming GMFGen UML model to UTP test model ...");
		Object modelSlotContent = ctx.get(getModelSlot());
		Model model = null;
		Collection<TestExceptions> testExceptions = Collections.emptyList();
		if (modelSlotContent instanceof Model) {
			model = (Model) modelSlotContent;
		} else if (modelSlotContent instanceof List) {
			List<?> slotContentList = (List<?>) modelSlotContent;
			model = Iterables.getFirst(Iterables.filter(slotContentList, Model.class), null);
			testExceptions = ImmutableList.copyOf(Iterables.filter(slotContentList, TestExceptions.class));
		}
		if ((model == null) || !(model instanceof Model)) {
			log.error("The input model for the transformation was not loaded!");
			return;
		}

		GMFGen2UTPModule module = createGMFGen2UTPModule(ctx, testExceptions);
		module.initEditPartDefaults(model, new TransformationUtilities());
		Injector injector = Guice.createInjector(module);

		CanonicalTests transformation = injector.getInstance(CanonicalTests.class);

		// Need a resource set context for working with static profiles
		ResourceSet rset = getResourceSet();
		rset.getResourceFactoryRegistry().getContentTypeToFactoryMap().put(UMLPackage.eCONTENT_TYPE, UMLResource.Factory.INSTANCE);
		Resource resource = rset.createResource(URI.createURI("tmp:uml"), UMLPackage.eCONTENT_TYPE);

		Model uml = transformation.toUTPModel(model, resource);
		ctx.set(getOutputSlot(), uml);
		log.info("The transformation successfully created Model " + uml.getLabel());
	}

}

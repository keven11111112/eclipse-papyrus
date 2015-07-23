/*****************************************************************************
 * Copyright (c) 2015 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 464647
 *   
 *****************************************************************************/

package org.eclipse.papyrus.tests.framework.gmfgenuml2utp

import static extension org.eclipse.papyrus.tests.framework.m2m.DefaultingList.*

import com.google.common.collect.ImmutableList
import com.google.inject.AbstractModule
import com.google.inject.TypeLiteral
import com.google.inject.name.Names
import java.util.Collection
import java.util.List
import org.eclipse.papyrus.tests.framework.m2m.Metamodels
import org.eclipse.papyrus.tests.framework.xtend.annotations.Cached
import org.eclipse.uml2.uml.InstanceSpecification
import org.eclipse.uml2.uml.Model
import org.eclipse.uml2.uml.Profile
import org.eclipse.uml2.uml.Property
import org.eclipse.uml2.uml.util.UMLUtil
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Guice module for the GMFGen(UML)-to-UTP transformation.
 */
public class GMFGen2UTPModule extends AbstractModule {
	@Accessors final Model gmfgenMetamodel
	@Accessors final Model frameworkBase
	@Accessors final Profile utp
	
	@Accessors TestExceptionManager testExceptionManager

	@Accessors String diagramTestPackageName;
	@Accessors String diagramUpdater;
	@Accessors String diagramCreationCommand;
	@Accessors String testConstantsInterface;

	@Accessors String topContainerEditPart;
	@Accessors final List<String> topNodesToTest = newDefaultingList
	@Accessors final List<String> childNodesToTest = newDefaultingList
	@Accessors final List<String> childLabelNodesToTest = newDefaultingList
	@Accessors final List<String> linksToTest = newDefaultingList
	@Accessors final List<String> linksOwnedBySourceToTest = newDefaultingList
	@Accessors final List<String> elementTypesAppearanceTests = newDefaultingList
	@Accessors final List<String> elementTypesDeleteTests = newDefaultingList
	@Accessors final List<String> elementTypesDropTests = newDefaultingList
	@Accessors final List<String> elementTypesEditTests = newDefaultingList

	@Accessors final List<String> testExceptionURIs = newArrayList()

	new(Model gmfgenMetamodel, Model frameworkBase, Profile utp) {
		super()

		this.gmfgenMetamodel = gmfgenMetamodel
		this.frameworkBase = frameworkBase
		this.utp = utp
	}

	protected override configure() {
		bindLogger()

		bindMetamodels()
		bindGMFGen2UTP()

		bindTestRules()
	
		bindTestExceptionManager()
		
		bindTestParameters()
	}

	protected def void bindLogger() {
		// May be overridden if transformation rules are not to use their own loggers
	}

	protected def void bindMetamodels() {
		bind(Metamodels).toInstance(new Metamodels(gmfgenMetamodel, frameworkBase, utp))
	}

	protected def void bindTestRules() {
		// May be overridden to inject custom transformation rules
	}
	
	protected def void bindTestExceptionManager() {
		bind(TestExceptionManager).toInstance(testExceptionManager ?: new TestExceptionManager)
	}

	protected def void bindGMFGen2UTP() {
		// Pass
	}

	protected def void bindTestParameters() {
		if(diagramTestPackageName != null) bind(String).annotatedWith(Names.named('diagramTestPackageName')).toInstance(
			diagramTestPackageName)
		if(diagramUpdater != null) bind(String).annotatedWith(Names.named('diagramUpdater')).toInstance(diagramUpdater)
		if(diagramCreationCommand != null) bind(String).annotatedWith(Names.named('diagramCreationCommand')).toInstance(
			diagramCreationCommand)
		if(testConstantsInterface != null) bind(String).annotatedWith(Names.named('testConstantsInterface')).toInstance(
			testConstantsInterface)

		if(topContainerEditPart != null) bind(String).annotatedWith(Names.named('topContainerEditPart')).toInstance(
			topContainerEditPart)

		val TypeLiteral<Collection<String>> stringsKey = new TypeLiteral<Collection<String>> {
		}
		bind(stringsKey).annotatedWith(Names.named('topNodesToTest')).toInstance(ImmutableList.copyOf(topNodesToTest))
		bind(stringsKey).annotatedWith(Names.named('childNodesToTest')).toInstance(
			ImmutableList.copyOf(childNodesToTest))
		bind(stringsKey).annotatedWith(Names.named('childLabelNodesToTest')).toInstance(
			ImmutableList.copyOf(childLabelNodesToTest))
		bind(stringsKey).annotatedWith(Names.named('linksToTest')).toInstance(ImmutableList.copyOf(linksToTest))
		bind(stringsKey).annotatedWith(Names.named('linksOwnedBySourceToTest')).toInstance(
			ImmutableList.copyOf(linksOwnedBySourceToTest))
		bind(stringsKey).annotatedWith(Names.named('elementTypesAppearanceTests')).toInstance(
			ImmutableList.copyOf(elementTypesAppearanceTests))
		bind(stringsKey).annotatedWith(Names.named('elementTypesDeleteTests')).toInstance(
			ImmutableList.copyOf(elementTypesDeleteTests))
		bind(stringsKey).annotatedWith(Names.named('elementTypesDropTests')).toInstance(
			ImmutableList.copyOf(elementTypesDropTests))
		bind(stringsKey).annotatedWith(Names.named('elementTypesEditTests')).toInstance(
			ImmutableList.copyOf(elementTypesEditTests))
	}
	
	def void initEditPartDefaults(Model gmfgen, extension TransformationUtilities utilities) {
		if (topNodesToTest.isDefault) {
			topNodesToTest += gmfgen.getInstances[isTopNode].map[editPart]
		}
		if (childNodesToTest.isDefault) {
			childNodesToTest += gmfgen.getInstances[isChildNode].map[editPart]
		}
		if (childLabelNodesToTest.isDefault) {
			childLabelNodesToTest += gmfgen.getInstances[isLabelNode].map[editPart]
		}
		if (linksToTest.isDefault) {
			linksToTest += gmfgen.getInstances[isLink && !isOwnedBySource(utilities)].map[editPart]
		}
		if (linksOwnedBySourceToTest.isDefault) {
			linksOwnedBySourceToTest += gmfgen.getInstances[isLink && isOwnedBySource(utilities)].map[editPart]
		}
		if (elementTypesAppearanceTests.isDefault) {
			elementTypesAppearanceTests += topNodesToTest
		}
		if (elementTypesDeleteTests.isDefault) {
			elementTypesDeleteTests += topNodesToTest
		}
		if (elementTypesDropTests.isDefault) {
			elementTypesDropTests += topNodesToTest
		}
		if (elementTypesEditTests.isDefault) {
			elementTypesEditTests += topNodesToTest
		}
	}
	
	private def isOwnedBySource(InstanceSpecification linkEditPart, extension TransformationUtilities utilities) {
		val modelFacet = linkEditPart.getSlotInstances('modelFacet').head
		val containment = modelFacet?.getSlotStringValue('containmentMetaFeature')?.umlMetaattribute
		val source = modelFacet?.getSlotStringValue('sourceMetaFeature')?.umlMetaattribute
		
		// A feature-link trivially is owned by the source end.  Otherwise, if the source is null we assume
		// ownership by the source end (otherwise, the link can't reference its source)
		modelFacet.isA('FeatureLinkModelFacet') ||
			((containment != null) && ((source == null) || (source.otherEnd == containment)))
	}
    
    @Cached def Property umlMetaattribute(String qualifiedName) {
    	if (qualifiedName == null) null else UMLUtil.findNamedElements(utp.eResource.resourceSet, qualifiedName).filter(Property).head
    }
}

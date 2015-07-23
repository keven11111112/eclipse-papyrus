/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - adapted from QVTo
 *   Christian W. Damus - bug 464647
 *   
 *****************************************************************************/

package org.eclipse.papyrus.tests.framework.gmfgen2uml

import javax.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.gmf.codegen.gmfgen.ElementType
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenLinkEnd
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import org.eclipse.papyrus.tests.framework.m2m.Metamodels
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.InstanceSpecification
import org.eclipse.uml2.uml.InstanceValue
import org.eclipse.uml2.uml.UMLFactory
import org.eclipse.uml2.uml.ValueSpecification
import java.util.List
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet

/**
 * Mapping of GMFGen model elements to UML instance-specifications.
 */
class GMFGen2UML {
    static extension UMLFactory = UMLFactory.eINSTANCE
    
    @Inject extension Metamodels
    
    def create createModel toUMLModel(GenEditorGenerator genEditor) {
        it.name = genEditor.modelID
        it.packagedElements += #[genEditor.toUML, genEditor.diagram.toUML] +
            genEditor.diagram.nodesAndLinks.map[toUML] +
            genEditor.diagram.nodesAndLinks.map[elementType?.toUML].filterNull +
            genEditor.diagram.nodesAndLinks.map[modelFacet?.toUML].filterNull +
            genEditor.diagram.compartments.map[toUML]
    }
    
    def nodesAndLinks(GenDiagram genDiagram) {
        genDiagram.topLevelNodes +
        genDiagram.childNodes +
        genDiagram.links.filter[modelFacet instanceof TypeModelFacet]
    }
    
    def getModelFacet(GenLinkEnd genLinkEnd) {
        switch (genLinkEnd) {
            GenNode : genLinkEnd.modelFacet
            GenLink : genLinkEnd.modelFacet
            default : null
        }
    }
    
    private def instanceName(EObject object, String name) {
        object.metaclassName + '_' + (name ?: '')
    }
    
    def dispatch create createInstanceSpecification toUML(GenEditorGenerator genEditor) {
        it.name = genEditor.instanceName(genEditor.packageNamePrefix)
        
        val metaclass = genEditor.gmfgenMetaclass
        it.classifiers += metaclass
        it.slots += #[
            genEditor.packageNamePrefix.toSlot('packageNamePrefix', metaclass),
            genEditor.diagram.toUML.toSlot('diagram', metaclass),
            genEditor.modelID.toSlot('modelID', metaclass),
            genEditor.domainFileExtension.toSlot('domainFileExtension', metaclass)
        ]
    }
    
    private def toSlot(Object value, String propertyName, Class ofMetaclass) {
        createSlot => [
            it.definingFeature = ofMetaclass.getInheritedAttribute(propertyName)
            it.values += switch (value) {
                String : createLiteralString => [it.value = value]
                Integer : createLiteralInteger => [it.value = value]
                InstanceSpecification : createInstanceValue => [it.instance = value]
                EStructuralFeature : createLiteralString => [it.value = value.umlMetamodelProperty.qualifiedName]
                case null : createLiteralNull as ValueSpecification
            }
        ]
    }
    
    private def toEditPartListSlot(List<? extends GenCommonBase> editParts, String propertyName, Class ofMetaclass) {
        createSlot => [
            it.definingFeature = ofMetaclass.getInheritedAttribute(propertyName)
            it.values += editParts.map[editPartClassName].filterNull.map[editPart |
            	createLiteralString => [it.value = editPart]
            ]
        ]
    }
    
    /**
     * Queries an attribute, possibly inherited in the Java sense, of a class.
     * In this case, inheritance includes properties defined by realized interfaces
     * (which are not, strictly UMLishly speaking, actually inherited).
     */
    def getInheritedAttribute(Class class_, String name) {
        class_.getAllAttributes().findFirst[it.name == name] ?:
            class_.allImplementedInterfaces.map[getAllAttributes().findFirst[it.name == name]].filterNull.head
    }
    
    private def commonBase(InstanceSpecification is, GenCommonBase genBase) {
        is.name = genBase.instanceName(genBase.editPartClassName)
        
        val metaclass = genBase.gmfgenMetaclass
        is.classifiers += metaclass
        is.slots += #[
            genBase.visualID.toSlot('visualID', metaclass),
            genBase.editPartClassName.toSlot('editPartClassName', metaclass),
            genBase.itemSemanticEditPolicyClassName.toSlot('itemSemanticEditPolicyClassName', metaclass)
        ]
        
        return metaclass
    }
    
    def dispatch create createInstanceSpecification toUML(GenDiagram genDiagram) {
        val metaclass = it.commonBase(genDiagram)
        
        it.slots += #[
            genDiagram.canonicalEditPolicyClassName.toSlot('canonicalEditPolicyClassName', metaclass),
            createSlot => [
                it.definingFeature = metaclass.getInheritedAttribute('topLevelNodes')
                it.values += (genDiagram.nodesAndLinks + genDiagram.compartments)
                        .map[toUML].map[is|createInstanceValue => [instance = is]]
            ]
        ]
    }
    
    def dispatch create createInstanceSpecification toUML(GenNode genNode) {
        val metaclass = it.commonBase(genNode)
        
        it.slots += #[
            genNode.elementType?.toUML.toSlot('elementType', metaclass),
            genNode.modelFacet?.toUML.toSlot('modelFacet', metaclass)
        ]
    }
    
    def dispatch create createInstanceSpecification toUML(GenLink genLink) {
        val metaclass = it.commonBase(genLink)
        
        it.slots += #[
            genLink.elementType?.toUML.toSlot('elementType', metaclass),
            genLink.modelFacet?.toUML.toSlot('modelFacet', metaclass),
            
            // These are derived properties in the GMFGen that will be awkward to compute from the UML,
            // so just cache the derived values in the intermediate model
            genLink.sources.toEditPartListSlot('sources', metaclass),
            genLink.targets.toEditPartListSlot('targets', metaclass)
        ]
    }
    
    def dispatch create createInstanceSpecification toUML(GenCompartment genCompartment) {
        val metaclass = it.commonBase(genCompartment)
        
        it.slots += #[
            genCompartment.node.toUML.toSlot('node', metaclass),
            createSlot => [
                it.definingFeature = metaclass.getInheritedAttribute('childNodes')
                it.values += genCompartment.childNodes.map[toUML].map[is|createInstanceValue => [instance = is]]
            ]
        ]
        
        it.setOppositeSlots('node', 'compartments')
        it.setOppositeSlots('childNodes', 'containers')
    }
    
    private def setOppositeSlots(InstanceSpecification is, String slotName, String oppositeName) {
        is.getSlot(slotName).values.filter(InstanceValue).forEach[ref|
            var opposite = ref.instance.getSlot(oppositeName)
            if (opposite == null) {
                // Create the opposite slot
                ref.instance.slots += is.toSlot(oppositeName, ref.instance.classifiers.head as Class)
            } else {
                // Add to the opposite slot
                opposite.values += createInstanceValue => [instance = is]
            }
        ]
    }
    
    def getSlot(InstanceSpecification is, String name) {
        is.slots.findFirst[definingFeature.name == name]
    }
    
    def dispatch create createInstanceSpecification toUML(ElementType elementType) {
        it.name = elementType.instanceName(elementType.displayName)
        
        val metaclass = elementType.gmfgenMetaclass
        it.classifiers += metaclass
        it.slots += #[
            elementType.displayName.toSlot('displayName', metaclass)
        ]
    }
    
    def dispatch create createInstanceSpecification toUML(TypeModelFacet modelFacet) {
        it.name = modelFacet.instanceName(modelFacet.modelFacetName)
        
        val metaclass = modelFacet.gmfgenMetaclass
        it.classifiers += metaclass
        it.slots += #[
            modelFacet.modelFacetName.toSlot('metaClass', metaclass)
        ]
    }
    
    def dispatch create createInstanceSpecification toUML(TypeLinkModelFacet modelFacet) {
        it.name = modelFacet.instanceName(modelFacet.modelFacetName)
        
        val metaclass = modelFacet.gmfgenMetaclass
        it.classifiers += metaclass
        it.slots += #[
            modelFacet.modelFacetName.toSlot('metaClass', metaclass),
            modelFacet.containmentMetaFeature?.ecoreFeature.toSlot('containmentMetaFeature', metaclass),
            modelFacet.sourceMetaFeature?.ecoreFeature.toSlot('sourceMetaFeature', metaclass),
            modelFacet.targetMetaFeature?.ecoreFeature.toSlot('targetMetaFeature', metaclass)
        ]
    }
    
    def dispatch create createInstanceSpecification toUML(FeatureLinkModelFacet modelFacet) {
        it.name = modelFacet.instanceName(modelFacet.metaFeature.name)
        
        val metaclass = modelFacet.gmfgenMetaclass
        it.classifiers += metaclass
        it.slots += #[
            modelFacet.metaFeature.ecoreFeature.toSlot('metaFeature', metaclass)
        ]
    }
    
    /** 
     * A TypeModelFacet may be unresolved, which is usually the case for the Diagram shortcut.
     * In such cases, we try to infer a name from the last segment of the URI fragment.
     */
    private def modelFacetName(TypeModelFacet modelFacet) {
        var result = modelFacet.metaClass.ecoreClass?.name
        
        result ?: {
            // Proxy case
            val uriFragment = EcoreUtil.getURI(modelFacet.metaClass).fragment
            uriFragment.substring(uriFragment.lastIndexOf('/') + 1)
        }
    }
    
    private def umlMetamodelProperty(EStructuralFeature eFeature) {
    	eFeature.EContainingClass.name.umlMetaclass.getAttribute(eFeature.name, null)
    }
}

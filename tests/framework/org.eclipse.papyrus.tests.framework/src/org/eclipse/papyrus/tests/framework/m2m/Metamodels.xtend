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

package org.eclipse.papyrus.tests.framework.m2m

import javax.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.uml2.uml.Model
import org.eclipse.uml2.uml.Property
import org.eclipse.uml2.uml.UMLPackage
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.uml2.uml.Profile
import org.eclipse.uml2.uml.Element
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.PrimitiveType
import org.eclipse.papyrus.tests.framework.xtend.annotations.Cached
import org.eclipse.uml2.uml.Enumeration
import org.eclipse.emf.common.util.URI
import org.eclipse.uml2.uml.resource.UMLResource

/**
 * Reference metamodels for GMFGen-to-UML transformations.
 */
@Data
@Singleton
class Metamodels {
    Model gmfgenMetamodel
    Model frameworkBase
    Profile utp
    
    def metaclassName(EObject element) {
        element.eClass.name
    }
    
    @Cached def org.eclipse.uml2.uml.Class gmfgenMetaclass(String name) {
        gmfgenMetamodel.getMember(name, false, UMLPackage.Literals.CLASS) as org.eclipse.uml2.uml.Class
    }
    
    def gmfgenMetaclass(EObject gmfgenElement) {
        gmfgenElement.metaclassName.gmfgenMetaclass
    }
    
    @Cached def frameworkClass(String name) {
        frameworkBase.eAllContents.filter(org.eclipse.uml2.uml.Class).findFirst[it.name == name]
    }
    
    @Cached def frameworkEnum(String name) {
        frameworkBase.eAllContents.filter(Enumeration).findFirst[it.name == name]
    }
    
    def utpStereotype(String name) {
        utp.getOwnedStereotype(name)
    }
    
    private def applyUTP(Element element, String name) {
        utpStereotype(name) => [
            element.applyStereotype(it)
        ]
    }
    
    def applyTestContext(org.eclipse.uml2.uml.Class class_) {
        class_.applyUTP('TestContext')
    }
    
    def applySUT(Property property) {
        property.applyUTP('SUT')
    }
    
    def applyTestCase(Operation operation) {
        operation.applyUTP('TestCase')
    }
    
    def primitiveType(String name) {
        frameworkBase.members.filter(PrimitiveType).findFirst[it.name == name]
    }
    
    def stringType() {
        'String'.primitiveType
    }
    
    def booleanType() {
        'Boolean'.primitiveType
    }
    
    def integerType() {
        'Integer'.primitiveType
    }
    
    def umlMetaclass(String name) {
    	umlMetamodel.getOwnedType(name) as org.eclipse.uml2.uml.Class
    }
    
    @Cached def Model umlMetamodel() {
    	gmfgenMetamodel.eResource.resourceSet.getResource(URI.createURI(UMLResource.UML_METAMODEL_URI), true).contents.filter(Model).head
    }
}

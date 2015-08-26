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
package org.eclipse.papyrus.tests.framework.m2t.xtend.templates

import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.InstanceSpecification
import org.eclipse.uml2.uml.Package
import org.eclipse.uml2.uml.Property
import javax.inject.Singleton
import javax.inject.Inject
import org.eclipse.uml2.uml.Expression
import java.util.Calendar
import org.eclipse.uml2.uml.NamedElement
import com.google.common.io.Resources
import com.google.common.base.Charsets
import org.eclipse.papyrus.tests.framework.xtend.annotations.Cached

/**
 * Helper query operations and template snippets for the model-to-text transformations
 * that generate test class code from the UML-UTP model describing a diagram's test cases.
 */
@Singleton
class TemplateQueries {
    @Inject extension CodegenContext
    @Inject extension Importator
    @Inject extension Queries
    
    def javaHeader() '''
    /*****************************************************************************
     * Copyright (c) «thisYear» CEA LIST and others.
     *
     * All rights reserved. This program and the accompanying materials
     * are made available under the terms of the Eclipse Public License v1.0
     * which accompanies this distribution, and is available at
     * http://www.eclipse.org/legal/epl-v10.html
     *
     * This file has been generated automatically in the Papyrus Test Framework.
     *
     *****************************************************************************/
    '''
    
    private def create Calendar.instance.get(Calendar.YEAR) thisYear() {
        // Pass
    }
    
    def getQualifiedJavaName(NamedElement element) {
        element.qualifiedName.replace('::', '.')
    }
    
    def getTestCases(Class class_) {
        class_.ownedOperations.filter[getAppliedStereotype("utp::TestCase") != null]
    }
    
    def hasTestCases(Class class_) {
        !class_.testCases.nullOrEmpty
    }
    
	def umlPackageElementType(InstanceSpecification node) {
		var componentName = getComponentName(node) as String
		if (componentName == 'Class') componentName = componentName + '_'
		
		'''«imported('org.eclipse.uml2.uml.UMLPackage')».eINSTANCE.get«componentName»()'''
	}

	def getComponentName(InstanceSpecification node) {
		node.getInstanceSlotValue('modelFacet').getStringSlotValue('metaClass')
	}

	def getDiagramName(Class clazz) {
		clazz.getDefaultValueInstanceSpecification('generator').getStringSlotValue('modelID').replace('PapyrusUML', '')
	}

    private def getDiagramCreationCommandName(Class clazz) {
        clazz.getAttribute('diagramCreationCommand', null)?.defaultStringValue
    }
    
    def diagramCreationCommand(Class class_) {
        resolveImportedClassName(packageRootName(class_), class_.diagramCreationCommandName, #['custom', ''])
    }

	def packageRootName(Class clazz) {
		clazz.getDefaultValueInstanceSpecification('generator').getStringSlotValue('packageNamePrefix')
	}

	def computePackagePath(Package model) {
		model.name.replace(".", System.getProperty("file.separator")) +
			//System.getProperty("file.separator") + "canonical" +
			System.getProperty("file.separator")
	}
    
    private def constantsInterfaceName(Class class_) {
        class_.getAttribute('testConstantsInterface', null)?.defaultStringValue
    }
	
	def constantsInterface(Class class_) {
	    resolveImportedClassName(class_.packageRootName, class_.constantsInterfaceName, #['test', 'tests'])
	}
	
	private def diagramUpdaterName(Class class_) {
	   class_.getAttribute('diagramUpdater', null)?.defaultStringValue
	}
	
	def defaultStringValue(Property property) {
        val value = property.defaultValue

        switch (value) {
            case null: ''
            Expression: value.symbol // XXX Why do we use an expression symbol to store the updater name?
            default: value.stringValue
        }
    }
	
	def diagramUpdater(Class class_) {
	    class_.resolveDiagramUpdater.imported
    }
    
    private def resolveDiagramUpdater(Class class_) {
        resolveClassName(class_.packageRootName, class_.diagramUpdaterName,
            #['custom.edit.part', 'custom.edit.parts', 'custom.part', 'edit.part', 'edit.parts', 'part']
        )
    }
    
    @Cached
    def diagramUpdaterInstanceField(Class class_) {
        val resourceName = class_.resolveDiagramUpdater.replace('.', '/') + '.class'
        val resourceURL = resourceLoader.getResource(resourceName)
        if (resourceURL == null) {
            'INSTANCE'
        } else {
            // Quick hack to look for legacy field name
            try {
                val contents = Resources.toString(resourceURL, Charsets.UTF_8)
                if (contents.contains('TYPED_INSTANCE')) 'TYPED_INSTANCE' else 'INSTANCE'
            } catch (Exception e) {
                'INSTANCE'
            }
        }
    }
    
    def String resolveImportedClassName(String rootPackage, String name, Iterable<String> searchPath) {
        rootPackage.resolveClassName(name, searchPath).imported
    }
    
    @Cached
    def String resolveClassName(String rootPackage, String name, Iterable<String> searchPath) {
        val search = searchPath.map [
            val prefix = if (it.startsWith(rootPackage+'.')) it else rootPackage + '.' + it
                
            // Account for a '' search path, which results in the prefix ending with a '.'
            if (prefix.endsWith('.')) prefix + name else prefix + '.' + name
        ]

        val result = search.findFirst [
            try {
                // The diagram plug-in is on our classpath, so look for the class
                resourceLoader.getResource(it.replace('.', '/') + '.class') != null
            } catch (Exception e) {
                false
            }
        ]

        result ?: search.last
    }
}

/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.tests.framework.m2t.xtend.templates

import org.eclipse.xtend.lib.annotations.Accessors
import javax.inject.Inject
import java.io.File
import java.io.FileWriter
import com.google.common.io.Closeables
import javax.inject.Singleton
import org.eclipse.emf.mwe.core.resources.ResourceLoader

/**
 * A code generation context for the Xtend templates.
 */
 @Singleton
class CodegenContext {
    @Inject extension TemplateQueries
    @Inject extension Importator
    
    @Accessors String outputFolderPath
    
    @Accessors ResourceLoader resourceLoader
    
    def create new File(outputFolderPath) outputFolder() {
        // Pass
    }
    
    def create new File(outputFolder, package_.computePackagePath) outputFolder(org.eclipse.uml2.uml.Package package_) {
        if (!it.exists) it.mkdirs
    }
    
    def outputFile(org.eclipse.uml2.uml.Class class_) {
        class_.nearestPackage.outputFile(class_.name)
    }
    
    def create new File(package_.outputFolder, class_ + '.java') outputFile(org.eclipse.uml2.uml.Package package_, String class_) {
        // Pass
    }
    
    def createClass(org.eclipse.uml2.uml.Package package_, String className, () => CharSequence template) {
        createFile(package_.outputFile(className), template)
    }
    
    def createFile(org.eclipse.uml2.uml.Package package_, String fileName, () => CharSequence template) {
        createFile(new File(package_.outputFolder, fileName), template)
    }
    
    def createFile(org.eclipse.uml2.uml.Class class_, () => CharSequence template) {
        createFile(class_.outputFile, template)
    }
    
    def createFile(File file, () => CharSequence template) {
        val writer = new FileWriter(file)
        try {
            writer.write(managingImports(file, template).toString)
        } finally {
            Closeables.close(writer, true)
        }
    }
}
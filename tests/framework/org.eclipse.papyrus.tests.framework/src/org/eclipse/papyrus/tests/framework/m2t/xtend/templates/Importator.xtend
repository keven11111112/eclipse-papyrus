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

import java.util.Map
import com.google.common.collect.Maps
import com.google.common.base.Joiner
import com.google.common.collect.Iterables
import com.google.common.collect.Ordering
import javax.inject.Singleton
import java.io.File

/**
 * Extensions for managing imports in generated Java files.
 */
 @Singleton
class Importator {
    Map<File, Map<String, String>> importsByFile = Maps.newHashMap
    ThreadLocal<File> tlFile = new ThreadLocal;
    
    def reset() {
        imports.clear
    }
    
    def CharSequence managingImports(File file, () => CharSequence template) {
        var CharSequence result = null
        
        tlFile.set(file)
        try {
            result = importify(template.apply)
        } finally {
            tlFile.remove
            importsByFile.remove(file)
        }
        
        result
    }
    
    private def file() {
        tlFile.get
    }
    
    def imports() {
        if (importsByFile.containsKey(file))
            importsByFile.get(file)
        else
            Maps.newHashMap => [
                importsByFile.put(file, it)
            ]
    }
    
    def String imported(String qualifiedClassName) {
        val simpleName = qualifiedClassName.substring(qualifiedClassName.lastIndexOf('.') + 1)
        val existing = imports.get(simpleName)
        
        if ((simpleName == qualifiedClassName) || ((existing != null) && (existing != qualifiedClassName))) {
            // Cannot import the same name again
            qualifiedClassName
        } else {
            imports.put(simpleName, qualifiedClassName)
            simpleName
        }
    }
    
    def String markImports() {
        "$$$imports$$$"
    }
    
    private def CharSequence importify(CharSequence text) {
        val importsText = Joiner.on(System.getProperty("line.separator")).join(
            Iterables.transform(Ordering.natural.sortedCopy(imports.values), [f|'import ' + f + ';'])
        )
        
        text.toString.replaceFirst("\\$\\$\\$imports\\$\\$\\$", importsText)
    }
}
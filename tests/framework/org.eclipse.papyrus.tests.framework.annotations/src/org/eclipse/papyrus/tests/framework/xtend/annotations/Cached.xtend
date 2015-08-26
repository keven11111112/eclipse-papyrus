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

package org.eclipse.papyrus.tests.framework.xtend.annotations

import java.lang.annotation.Target
import java.util.Map
import org.eclipse.xtend.lib.macro.AbstractMethodProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.ValidationContext
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.eclipse.xtend.lib.macro.declaration.TypeReference

/**
 * An active annotation for cached methods.  A cached method's value is computed at most once
 * for any given set of actual parameters.
 */
@Target(METHOD)
@Active(CachedProcessor)
annotation Cached {}

class CachedProcessor extends AbstractMethodProcessor {
    
    override doValidate(MethodDeclaration method, extension ValidationContext context) {
        if (method.returnType.inferred) {
            method.addError('Method result of inferred type cannot be cached')
        } else if (method.returnType.primitiveIfWrapper.isVoid) {
            method.addError('Void method result cannot be cached')
        }
    }
    
    override doTransform(MutableMethodDeclaration method, extension TransformationContext context) {
        // Create the once-method
        method.declaringType.addMethod('_once_' + method.simpleName) [
            visibility = Visibility.PRIVATE
            returnType = method.returnType
            method.typeParameters.forEach[tp |
                addTypeParameter(tp.simpleName, tp.upperBounds)
            ]
            method.parameters.forEach[p |
                addParameter(p.simpleName, p.type)
            ]
            body = method.body
            primarySourceElement = method
        ]

        val listType = newWildcardTypeReference.list
        val collectionLiteralsType = CollectionLiterals.findTypeGlobally.newTypeReference
        
        // Ensure the existence of the cached-null token
        val cachedNull = method.declaringType.findDeclaredField('_CACHED_NULL_') ?:
            method.declaringType.addField('_CACHED_NULL_') [
                visibility = Visibility.PRIVATE
                static = true
                final = true
                type = object
                initializer = ['''new «object»()''']
            ]
        
        // And of the cache
        val cache = method.declaringType.addField('_cache_' + method.simpleName + '_' + method.parameters.map[type.type.simpleName].join('_')) [
                visibility = Visibility.PRIVATE
                final = true
                type = Map.findTypeGlobally.newTypeReference(listType, object)
                initializer = ['''«collectionLiteralsType.name».newHashMap()''']
            ]
        
        // Create a new body for the cached method.
        method.body = ['''
            final «listType» key = «collectionLiteralsType.name».newArrayList(«FOR p : method.parameters SEPARATOR ', '»«p.simpleName»«ENDFOR»);
            «object» result;
            
            synchronized («cache.simpleName») {
                result = «cache.simpleName».get(key);
                if (result == null) {
                    result = _once_«method.simpleName»(«FOR p : method.parameters SEPARATOR ', '»«p.simpleName»«ENDFOR»);
                    if (result == null) {
                    	result = «cachedNull.simpleName»;
                    }
                    «cache.simpleName».put(key, result);
                }
            }
            
            return (result == «cachedNull.simpleName») ? null : («method.returnType.nonClashingName(context)») result;
        ''']
    }
    
    // Prefer qualified names for classes whose simple name clashes with a type in the java.lang package 
    private def nonClashingName(TypeReference typeRef, extension TransformationContext context) {
    	val base = typeRef.simpleName
    	val simpleName = if (typeRef.actualTypeArguments.empty) base else base.substring(0, base.indexOf('<'))
    	
    	if (('java.lang.' + simpleName).findTypeGlobally == null) base else typeRef.name
    }
}

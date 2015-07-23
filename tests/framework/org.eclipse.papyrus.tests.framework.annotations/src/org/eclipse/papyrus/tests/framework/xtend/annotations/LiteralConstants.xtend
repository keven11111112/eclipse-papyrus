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
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.ValidationContext
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility

/**
 * An active annotation for fields of enumeration type that generates camel-case-named constants for each literal of
 * the enumeration type.
 */
@Target(FIELD)
@Active(LiteralConstantsProcessor)
annotation LiteralConstants {
	/** Whether to generate static constants (default is true). */
	boolean isStatic = true
}

class LiteralConstantsProcessor extends AbstractFieldProcessor {
    
    override doValidate(FieldDeclaration field, extension ValidationContext context) {
        if (field.type.inferred) {
            field.addError('Cannot generate enumeration literal constants for inferred field type')
        } else if (!Enum.findTypeGlobally.isAssignableFrom(field.type.type)) {
            field.addError('Field is not of enumeration type')
        }
    }
    
    override doTransform(MutableFieldDeclaration field, extension TransformationContext context) {
    	val enumType = field.type.type
    	val isStatic = field.findAnnotation(LiteralConstants.findTypeGlobally).getBooleanValue('isStatic')
    	
    	switch (enumType) {
    		EnumerationTypeDeclaration : {
		        for (next : enumType.enumConstants) {
		        	field.declaringType.addField(next.literalName) [
		        		visibility = Visibility.PUBLIC
		        		static = isStatic
		        		final = true
		        		type = field.type
		        		initializer = '''«field.type.simpleName».«next.constantName»'''
		        		
		        		primarySourceElement = field
		        	]
		        }
    		}
    		
    		default: field.addError('Cannot resolve field\'s enumeration type declaration')
    	}
    }
    
    def enumConstants(EnumerationTypeDeclaration enumType) {
    	enumType.declaredValues.map[ new EnumConstants(simpleName.toCamelCase, simpleName) ]
    }
    
    def toCamelCase(String name) {
    	val parts = name.toLowerCase.split('_')
    	parts.get(0) + parts.subList(1, parts.size).map[toFirstUpper].join
    }
    
    //
    // Nested types
    //
    
    @Data
    private static class EnumConstants {
    	String literalName
    	String constantName
    }
}

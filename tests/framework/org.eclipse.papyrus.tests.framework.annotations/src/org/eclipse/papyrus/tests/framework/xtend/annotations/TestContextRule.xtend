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
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.eclipse.xtend.lib.macro.declaration.Visibility

/**
 * An active annotation for test-context class rules.  Such rules are blocks that
 * define a {@link TestContextBuilder} as the only input (the implicit <b>{@code it}</b> variable).
 * The field declaration may omit the type.  It may be declared as either {@code var} or {@code val}
 * but it will be generated as a {@code val}.
 */
@Target(FIELD)
@Active(TestContextRuleProcessor)
annotation TestContextRule {}

class TestContextRuleProcessor extends AbstractFieldProcessor {
    
    override doTransform(MutableFieldDeclaration field, extension TransformationContext context) {
        field.type = findTypeGlobally(Procedure1).newTypeReference(
            findTypeGlobally("org.eclipse.papyrus.tests.framework.gmfgenuml2utp.TransformationUtilities.TestContextBuilder").newTypeReference.newWildcardTypeReferenceWithLowerBound
        )
        field.final = true
        field.visibility = Visibility.PRIVATE
        
        field.declaringType.addMethod('get' + field.simpleName.toFirstUpper) [
            field.markAsRead
            returnType = field.type
            body = ['''
                return «field.simpleName»;
            ''']
            primarySourceElement = field
        ]
    }
    
}
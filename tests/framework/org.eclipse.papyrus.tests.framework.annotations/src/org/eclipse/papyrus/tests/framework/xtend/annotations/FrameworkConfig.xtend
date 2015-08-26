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
import com.google.inject.Inject
import com.google.inject.name.Named

/**
 * An active annotation for framework configuration parameters. Annotate a field with this
 * to mark it as optionally injected by Guice with the field name as the named injection binding.
 * That is, the result of annotating a field as
 * <pre>
 *     {@literal @FrameworkConfig val Iterable<String> myConfigParameter}
 * </pre>
 * is the same as annotating the field with
 * <pre>
 *     {@literal @Inject(optional=true)}
 *     {@literal @Named('myConfigParameter')}
 *     {@literal val Iterable<String> myConfigParameter}
 * </pre>
 */
@Target(FIELD)
@Active(FrameworkConfigProcessor)
annotation FrameworkConfig {}

class FrameworkConfigProcessor extends AbstractFieldProcessor {
    
    override doTransform(MutableFieldDeclaration field, extension TransformationContext context) {
        field.addAnnotation(Inject.newAnnotationReference[
            setBooleanValue('optional', true)
        ])
        field.addAnnotation(Named.newAnnotationReference[
            setStringValue('value', field.simpleName)
        ])
    }
    
}
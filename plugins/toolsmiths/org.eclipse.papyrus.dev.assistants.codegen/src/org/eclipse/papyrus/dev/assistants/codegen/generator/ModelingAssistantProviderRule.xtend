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
package org.eclipse.papyrus.dev.assistants.codegen.generator

import javax.inject.Inject
import javax.inject.Singleton
import org.eclipse.papyrus.infra.gmfdiag.assistant.AssistantFactory
import org.eclipse.papyrus.infra.gmfdiag.assistant.ModelingAssistantProvider
import org.eclipse.papyrus.uml.profile.types.generator.UMLElementTypes
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

/**
 * Transformation rule for generating a {@link ModelingAssistantProvider} from a UML {@link Profile}.
 */
@Singleton
class ModelingAssistantProviderRule extends org.eclipse.papyrus.uml.profile.assistants.generator.ModelingAssistantProviderRule {
    static extension AssistantFactory assistantFactory = AssistantFactory.eINSTANCE

    @Inject extension ElementTypeToAssistantRule
    @Inject extension GMFGenToAssistantRule
    @Inject extension UMLElementTypes

    def create createModelingAssistantProvider toModelingAssistantProvider(ElementTypeSetConfiguration elementTypeSet) {
        name = elementTypeSet.name
        
        elementTypeSet.elementTypeConfigurations.forEach[ type |
            
            if (!type.relationship) {
                // Popup assistants to create non-relationships
                elementTypeIDs.add(type.identifier)
                popupAssistants.add(type.toPopupAssistant)
            } else {
                relationshipTypeIDs.add(type.identifier)
                connectionAssistants.add(type.toConnectionAssistant)
            }
        ]
    }
    
    def create createModelingAssistantProvider toModelingAssistantProvider(GenEditorGenerator editor) {
        name = editor.modelID
        elementTypeIDs.addAll(editor.diagram.validNodes.map[elementType?.uniqueIdentifier].filterNull)
        relationshipTypeIDs.addAll(editor.diagram.validLinks.map[elementType?.uniqueIdentifier].filterNull)
        
        popupAssistants.addAll(editor.diagram.validNodes.map[toPopupAssistant])
        connectionAssistants.addAll(editor.diagram.validLinks.map[toConnectionAssistant])
    }
}

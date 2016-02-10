/*****************************************************************************
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   Benoit Maggi       - #474408 : order by identifier the generated file   
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.types.generator

import java.util.List
import javax.inject.Inject
import javax.inject.Singleton
import org.eclipse.papyrus.infra.types.AbstractAdviceBindingConfiguration
import org.eclipse.papyrus.infra.types.ElementTypeConfiguration
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration
import org.eclipse.uml2.uml.Profile
import org.eclipse.uml2.uml.UMLPackage
import org.eclipse.papyrus.infra.types.ElementTypesConfigurationsFactory

/**
 * Transformation rule for generating an {@link ElementTypeSetConfiguration} from a UML {@link Profile}.
 */
@Singleton
class ConfigurationSetRule {
    static extension ElementTypesConfigurationsFactory elementtypesconfigurationsFactory = ElementTypesConfigurationsFactory.
        eINSTANCE

    @Inject extension Identifiers
    @Inject extension UML
    @Inject extension UMLElementTypes
    @Inject extension ElementTypeRule
    @Inject extension ApplyStereotypeAdviceRule

    def create createElementTypeSetConfiguration toConfigurationSet(Profile umlProfile) {

        // Initialize the generation of IDs
        umlProfile.setIdentifierBase

        identifier = "elementTypes".qualified
        metamodelNsURI = baseUMLElementTypeSet?.metamodelNsURI ?: UMLPackage.eNS_URI;

       val List<ElementTypeConfiguration> elementTypeConfigurationList = newArrayList()
       val List<AbstractAdviceBindingConfiguration> adviceBindingConfigurationList = newArrayList()		
		
        umlProfile.allExtensions.forEach[ext | 
            elementTypeConfigurationList.addAll(ext.metaclass.diagramSpecificElementTypes.map[ext.toElementType(it)])
            
            // We only need to generate advice bindings for element types that won't inherit the from a parent semantic type
            val typesNeedingAdvice = ext.metaclass.diagramSpecificElementTypes.filter[!hasSemanticSupertype]
            adviceBindingConfigurationList.addAll(typesNeedingAdvice.map[ext.stereotype.toAdviceConfiguration(ext, it)])
        ]
       adviceBindingsConfigurations.addAll(adviceBindingConfigurationList.sortBy[identifier])     
       elementTypeConfigurations.addAll(elementTypeConfigurationList.sortBy[identifier])        
    }
}

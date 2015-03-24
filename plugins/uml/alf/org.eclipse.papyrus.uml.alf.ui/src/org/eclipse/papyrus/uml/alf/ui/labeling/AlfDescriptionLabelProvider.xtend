/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.ui.labeling

//import org.eclipse.xtext.resource.IEObjectDescription

/**
 * Provides labels for a IEObjectDescriptions and IResourceDescriptions.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
class AlfDescriptionLabelProvider extends org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider {
  
  override getImage(Object object) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub")
  }

	// Labels and icons can be computed like this:
	
//	override text(IEObjectDescription ele) {
//		ele.name
//	}
//	 
//	override image(IEObjectDescription ele) {
//		ele.EClass.name + '.gif'
//	}	 
}

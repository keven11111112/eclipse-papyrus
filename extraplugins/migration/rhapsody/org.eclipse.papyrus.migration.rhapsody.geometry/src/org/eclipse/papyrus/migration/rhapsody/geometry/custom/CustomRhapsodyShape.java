/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.migration.rhapsody.geometry.custom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyShapeImpl;
import org.eclipse.papyrus.migration.rhapsody.geometry.utils.RhapsodyShapeOperations;

public class CustomRhapsodyShape extends RhapsodyShapeImpl {

	
	@Override
	public void setRhapsodyMetamodelObject(EObject newRhapsodyMetamodelObject) {
		
		RhapsodyShapeOperations.initializeShape(this, newRhapsodyMetamodelObject);
		
		super.setRhapsodyMetamodelObject(newRhapsodyMetamodelObject);
	}
	
}

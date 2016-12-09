/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.wizard;

import org.eclipse.papyrus.migration.common.MigrationParameters.ThreadConfig;
import org.eclipse.papyrus.migration.common.transformation.AbstractImportTransformationLauncher;
import org.eclipse.papyrus.migration.common.wizard.AbstractTransformationWizard;
import org.eclipse.papyrus.migration.rhapsody.transformations.RhapsodyImportTransformationLauncher;
import org.eclipse.swt.widgets.Control;

/**
 * 
 * @author Vincent Lorenzo
 *
 */
public class TransformationRhapsodyWizard extends AbstractTransformationWizard {

	public TransformationRhapsodyWizard() {
		super("Rhapsody Transformation Wizard", new RhapsodyDialogData());
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.migration.common.wizard.AbstractTransformationWizard#createTransformationLauncher(org.eclipse.papyrus.migration.common.MigrationParameters.Config, org.eclipse.swt.widgets.Control)
	 *
	 * @param config
	 * @param baseControl
	 * @return
	 */
	@Override
	protected AbstractImportTransformationLauncher createTransformationLauncher(ThreadConfig config, Control baseControl) {
		return new RhapsodyImportTransformationLauncher(config, baseControl);
	}

}

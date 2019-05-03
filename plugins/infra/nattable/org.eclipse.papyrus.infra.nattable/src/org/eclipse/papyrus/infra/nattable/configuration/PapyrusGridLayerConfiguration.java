/*****************************************************************************
 * Copyright (c) 2013, 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Thanh Liem PHAN (ALL4TEC) thanhliem.phan@all4tec.net - Bug 417095, 515737
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.configuration;

import org.eclipse.nebula.widgets.nattable.grid.layer.config.DefaultGridLayerConfiguration;
import org.eclipse.nebula.widgets.nattable.layer.CompositeLayer;
import org.eclipse.papyrus.infra.nattable.applynamedstyle.PapyrusApplyNamedStyleBindings;
import org.eclipse.papyrus.infra.nattable.export.PapyrusExportBindings;
import org.eclipse.papyrus.infra.nattable.export.file.PapyrusFileExportBindings;
import org.eclipse.papyrus.infra.nattable.internal.export.image.PapyrusImageExportBindings;

/**
 * We change the edit configuration
 *
 * @author Vincent Lorenzo
 *
 */
public class PapyrusGridLayerConfiguration extends DefaultGridLayerConfiguration {

	/**
	 *
	 * Constructor.
	 *
	 * @param gridLayer
	 */
	public PapyrusGridLayerConfiguration(CompositeLayer gridLayer) {
		super(gridLayer);
		addFileExportUIBindings();
		addImageExportUIBindings();
		addApplyNamedStyleBindings();
	}

	/**
	 *
	 * @see org.eclipse.nebula.widgets.nattable.grid.layer.config.DefaultGridLayerConfiguration#addEditingHandlerConfig()
	 *
	 */
	@Override
	protected void addEditingHandlerConfig() {
		addConfiguration(new EditConfiguration());
	}

	/**
	 *
	 * @see org.eclipse.nebula.widgets.nattable.grid.layer.config.DefaultGridLayerConfiguration#addEditingUIConfig()
	 *
	 */
	@Override
	protected void addEditingUIConfig() {
		addConfiguration(new PapyrusDefaultEditBindings());
	}

	/**
	 *
	 * @see org.eclipse.nebula.widgets.nattable.grid.layer.config.DefaultGridLayerConfiguration#addExcelExportUIBindings()
	 *
	 */
	@Override
	protected void addExcelExportUIBindings() {
		addConfiguration(new PapyrusExportBindings());
	}

	/**
	 * Add the file export binding.
	 * 
	 * @since 2.0
	 */
	protected void addFileExportUIBindings() {
		addConfiguration(new PapyrusFileExportBindings());
	}

	/**
	 * Add the image export binding.
	 * @since 3.0
	 */
	protected void addImageExportUIBindings() {
		addConfiguration(new PapyrusImageExportBindings());
	}

	/**
	 * Add the apply named style binding.
	 *
	 * @since 5.0
	 */
	protected void addApplyNamedStyleBindings() {
		addConfiguration(new PapyrusApplyNamedStyleBindings());
	}
}

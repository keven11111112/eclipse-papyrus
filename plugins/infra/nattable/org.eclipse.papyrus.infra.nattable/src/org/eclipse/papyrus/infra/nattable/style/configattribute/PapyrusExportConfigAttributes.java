/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.style.configattribute;

import org.eclipse.nebula.widgets.nattable.export.ILayerExporter;
import org.eclipse.nebula.widgets.nattable.style.ConfigAttribute;

/**
 * Papyrus configuration attributes that are used to configure the export functionality.
 * 
 * @since 2.0
 */
public interface PapyrusExportConfigAttributes {

	/**
     * The configuration attribute for specifying the concrete implementation
     * instance of ILayerExporter that should be used for a file export.
     */
    ConfigAttribute<ILayerExporter> SIMPLE_FILE_EXPORTER = new ConfigAttribute<ILayerExporter>();
}

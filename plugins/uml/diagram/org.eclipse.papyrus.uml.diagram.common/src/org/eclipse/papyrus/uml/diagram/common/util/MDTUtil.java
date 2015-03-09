/*******************************************************************************
 * Copyright (c) 2008, 2014 Conselleria de Infraestructuras y Transporte, Generalitat
 * de la Comunitat Valenciana, CEA, and others. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *   Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation.
 *   Gabriel Merin Cubero (Prodevelop) – Operations to add a diagram version
 *   Christian W. Damus (CEA) - bug 422257
 *
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util;

import org.eclipse.ui.IEditorPart;


/**
 * The Class MDTUtil.
 *
 * @author <a href="fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @author <a href="gmerin@prodevelop.es">Grabriel Merin Cubero</a>
 *
 *@deprecated since 1.1.0
 *use org.eclipse.papyrus.infra.gmfdiag.common.utils.MDTUtil
 */
@Deprecated
public class MDTUtil extends org.eclipse.papyrus.infra.gmfdiag.common.utils.MDTUtil{

	
	@Deprecated
	public static IEditorPart getActiveEditor() {
		return org.eclipse.papyrus.infra.gmfdiag.common.utils.MDTUtil.getActiveEditor();
	}
}

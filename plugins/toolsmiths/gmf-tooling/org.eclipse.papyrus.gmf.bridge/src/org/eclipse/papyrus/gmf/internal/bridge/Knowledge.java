/******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge;

import org.eclipse.papyrus.gmf.mappings.LabelMapping;
import org.eclipse.papyrus.gmf.mappings.NodeMapping;

/**
 * Handcoded decisions
 * @author artem
 */
public class Knowledge {

	/**
	 * @return whether nodeMapping has single label, no children and node's diagram 
	 * element is DiagramLabel equivalent that of it's label
	 */
	public static boolean isPureLabelNode(NodeMapping childNodeMapping) {
		if (childNodeMapping.getLabelMappings().size() == 1 && childNodeMapping.getChildren().isEmpty()) {
			LabelMapping soleLabel = childNodeMapping.getLabelMappings().get(0);
			return childNodeMapping.getDiagramNode() == soleLabel.getDiagramLabel(); 
		}
		return false;
	}

}

/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.util.UMLUtil;


public class StandardLoopCharacteristicsCustom {

	private StandardLoopCharacteristicsCustom() {
	}

	public static boolean isTestBefore(StandardLoopCharacteristics s) {
		boolean isTestBefore = false;
		LoopNode loopNode = s.getBase_LoopNode();
		if (loopNode != null) {
			isTestBefore = loopNode.isTestedFirst();
		}

		return isTestBefore;
	}

	public static BPMNExpression basicGetLoopCondition(StandardLoopCharacteristics s) {
		BPMNExpression expression = null;
		LoopNode loopNode = s.getBase_LoopNode();
		if (loopNode != null) {
			EList<ExecutableNode> nodes = loopNode.getTests();
			if (nodes != null && !nodes.isEmpty()) {
				expression = UMLUtil.getStereotypeApplication(nodes.get(0), BPMNExpression.class);
			}
		}
		return expression;
	}
}

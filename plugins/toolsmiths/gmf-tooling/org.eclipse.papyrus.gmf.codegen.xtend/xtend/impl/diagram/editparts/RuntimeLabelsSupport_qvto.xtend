/*******************************************************************************
 * Copyright (c) 2011 - 2013 Montages AG
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Svyatoslav Kovalsky (Montages) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package impl.diagram.editparts

import com.google.inject.Inject
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenNode
import org.eclipse.papyrus.gmf.codegen.gmfgen.ModeledViewmap
import org.eclipse.papyrus.gmf.codegen.gmfgen.ParentAssignedViewmap
import org.eclipse.papyrus.gmf.codegen.gmfgen.Viewmap
import org.eclipse.papyrus.gmf.gmfgraph.DiagramLabel
import org.eclipse.papyrus.gmf.gmfgraph.VerticalLabel
import xpt.Common_qvto
import org.eclipse.papyrus.gmf.codegen.xtend.annotations.MetaDef

@com.google.inject.Singleton class RuntimeLabelsSupport_qvto {
	@Inject extension Common_qvto

	def boolean isVerticalLabel(GenCommonBase commonBase) {
		var Viewmap vm = commonBase.viewmap
		switch (vm) {
			ParentAssignedViewmap:
				vm.figureQualifiedClassName == getVerticalLabelFQN()
			ModeledViewmap:
				vm.figureModel.oclIsKindOf(typeof(DiagramLabel)) &&
					isVerticalDiagramLabel(vm.figureModel as DiagramLabel)
			default:
				false
		}
	}

	def boolean isVerticalDiagramLabel(DiagramLabel figureModel) {
		return figureModel.accessor != null && figureModel.accessor.figure.oclIsKindOf(typeof(VerticalLabel))
	}

	@MetaDef def String getSimpleLabelDelegateFQN() {
		return getRuntimeLabelPackage() + "." + "SimpleLabelDelegate";
	}

	@MetaDef def String getVerticalLabelFQN() {
		return getRuntimeLabelPackage() + "." + "VerticalLabel";
	}

	@MetaDef def String getVerticalLabelDelegateFQN() {
		return getRuntimeLabelPackage() + "." + "VerticalLabelDelegate";
	}

	@MetaDef def String getVerticalLabelCellEditorLocatorFQN() {
		return getRuntimeLabelPackage() + "." + "VerticalLabelCellEditorLocator";
	}

	@MetaDef def String getRuntimeLabelPackage() {
		return "org.eclipse.gmf.tooling.runtime.draw2d.labels";
	}

	def boolean supportsVerticalLabels(GenDiagram diagram) {
		return diagram.allNodes.exists[n|hasVerticalLabels(n)]
	}

	def boolean hasVerticalLabels(GenNode node) {
		return isVerticalLabel(node) || node.labels.exists[label|isVerticalLabel(label)]
	}

}

/*******************************************************************************
﻿ * Copyright (c) 2007, 2020 Borland Software Corporation, CEA LIST, Artal and others
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
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package gmfgraph

import java.util.List
import org.eclipse.papyrus.gmf.gmfgraph.Alignment
import org.eclipse.papyrus.gmf.gmfgraph.BasicFont
import org.eclipse.papyrus.gmf.gmfgraph.BorderLayoutData
import org.eclipse.papyrus.gmf.gmfgraph.ChildAccess
import org.eclipse.papyrus.gmf.gmfgraph.Color
import org.eclipse.papyrus.gmf.gmfgraph.ConnectionFigure
import org.eclipse.papyrus.gmf.gmfgraph.CustomFigure
import org.eclipse.papyrus.gmf.gmfgraph.DecorationFigure
import org.eclipse.papyrus.gmf.gmfgraph.Ellipse
import org.eclipse.papyrus.gmf.gmfgraph.Figure
import org.eclipse.papyrus.gmf.gmfgraph.FigureAccessor
import org.eclipse.papyrus.gmf.gmfgraph.FigureDescriptor
import org.eclipse.papyrus.gmf.gmfgraph.FigureRef
import org.eclipse.papyrus.gmf.gmfgraph.Label
import org.eclipse.papyrus.gmf.gmfgraph.Polyline
import org.eclipse.papyrus.gmf.gmfgraph.PolylineConnection
import org.eclipse.papyrus.gmf.gmfgraph.RealFigure
import org.eclipse.papyrus.gmf.gmfgraph.Rectangle
import org.eclipse.papyrus.gmf.gmfgraph.RoundedRectangle
import org.eclipse.papyrus.gmf.gmfgraph.SVGProperty
import org.eclipse.papyrus.gmf.gmfgraph.SVGPropertyType
import org.eclipse.papyrus.gmf.gmfgraph.Shape
import org.eclipse.papyrus.gmf.codegen.xtend.annotations.MetaDef
import xpt.Common_qvto
import com.google.inject.Injectimport java.util.LinkedList

@com.google.inject.Singleton class Utils_qvto {
	@Inject extension Common_qvto;

	def String compilationUnitName(FigureDescriptor figure) {
		return figure.name.toFirstUpper
	}

	def boolean hasSourceDecoration(PolylineConnection figure) {
		return null != figure.sourceDecoration
	}

	def Iterable<String> requiredBundles(Iterable<String> referencedBundles) {
		var List<String> result = newLinkedList('org.eclipse.core.runtime', 'org.eclipse.draw2d');
		if (isFullRuntime()) {
			result.add('org.eclipse.gmf.runtime.draw2d.ui');
		}
		result.addAll(referencedBundles)
		return result.sort
	}

	//	def String additionalStaticFields() {
	//		return if(xpandGetStreamNames().contains('staticFields')) xpandGetStreamContents('staticFields') else ''
	//	}
	//
	//	def boolean isFullRuntime() {
	//		return internalCheckRuntimeToken() == null || !internalCheckRuntimeToken().toLower == 'full';
	//	}
	//
	//	def String internalCheckRuntimeToken() {
	//		return xpandGetStringGlobalVar('runtimeToken')
	//	}
	/**
	 * XXX: [MG] As of 2013 only full runtime is supported 
	 */
	def boolean isFullRuntime() {
		true
	}

	def boolean hasTargetDecoration(PolylineConnection figure) {
		return null != figure.targetDecoration
	}

	def dispatch boolean needsField(RealFigure figure) {
		return realFigureNeedsField(figure);
	}

	def dispatch boolean needsField(CustomFigure figure) {
		return customFigureNeedsField(figure) || realFigureNeedsField(figure);
	}

	def boolean customFigureNeedsField(CustomFigure figure) {
		hasDescriptor(figure) && !figure.customChildren.empty
	}

	def boolean realFigureNeedsField(RealFigure figure) {
		hasDescriptor(figure) && figure.descriptor.accessors.exists[a|a.figure == figure]
	}

	def boolean hasDescriptor(RealFigure figure) {
		figure.descriptor != null 
	}

	def String figureVariableName(RealFigure figure, int count) {
		if(needsField(figure)) return figure.figureFieldName();
		var base = if(figure.name.nullOrSpaces) figure.variableNameStem() else figure.name.toFirstLower
		return base + count;
	}

	def dispatch nameStem(FigureRef xptSelf) {
		return xptSelf.figure.variableNameStem()
	}

	def dispatch nameStem(Figure xptSelf) {
		return xptSelf.variableNameStem()
	}

	def dispatch variableNameStem(Figure xptSelf) {
		return 'fig'
	}

	def dispatch variableNameStem(RealFigure xptSelf) {
		return 'fig'
	}

	def dispatch variableNameStem(Shape xptSelf) {
		return 'shape'
	}

	def dispatch variableNameStem(Rectangle xptSelf) {
		return 'rect'
	}

	def dispatch variableNameStem(RoundedRectangle xptSelf) {
		return 'rrect'
	}

	def dispatch variableNameStem(Ellipse xptSelf) {
		return 'elli'
	}

	def dispatch variableNameStem(Polyline xptSelf) {
		return 'polyline'
	}

	def dispatch variableNameStem(Label xptSelf) {
		return 'l'
	}

	def dispatch variableNameStem(DecorationFigure xptSelf) {
		return 'dec'
	}

	def dispatch variableNameStem(ConnectionFigure xptSelf) {
		return 'conn'
	}

	def dispatch String figureFieldName(RealFigure xptSelf) {
		return figureFieldName(xptSelf.descriptor.accessors.filter[a|xptSelf == a.figure])
	}

	def dispatch String figureFieldName(ChildAccess xptSelf) {
		return 'f' + xptSelf.accessor.trimPrefixIfAny('get')
	}

	def dispatch String figureFieldName(CustomFigure xptSelf) {
			return 'my' + xptSelf.name.toFirstUpper;
	}

	def dispatch String figureFieldName(Iterable<ChildAccess> accesses) {
		return accesses.map[x|x.figureFieldName()].head
	}

	def String borderLayoutConstant(BorderLayoutData layoutData) {
		return switch (layoutData.alignment) {
			case Alignment::BEGINNING_LITERAL: if(layoutData.vertical) 'TOP' else 'LEFT'
			case Alignment::END_LITERAL: if(layoutData.vertical) 'BOTTOM' else 'RIGHT'
			default: 'CENTER'
		}
	}

	def Iterable<FigureAccessor> allCustomAccessors(FigureDescriptor fd) {
		return filterCustom(newLinkedList(fd.actualFigure)).map[cf|cf.customChildren].flatten
	}

	def Iterable<CustomFigure> filterCustom(Iterable<Figure> figures) {
		val result = <CustomFigure>newLinkedList();
		deepCollectCustom(figures, result);
		return result;
	}

	protected def void deepCollectCustom(Iterable<Figure> figures, List<CustomFigure> acc) {
		if(figures.empty) return;
		acc.addAll(figures.filter(typeof(CustomFigure)));
		deepCollectCustom(figures.filter(typeof(RealFigure)).map[rf|rf.children].flatten, acc)
		deepCollectCustom(figures.filter(typeof(CustomFigure)).map[rf|rf.customChildren].flatten.map[cc | cc.typedFigure].filter(typeof(Figure)), acc)
	}
	
	def LinkedList<FigureAccessor> getCustomFigureChainFigureAccess(ChildAccess it) {
		val result = <FigureAccessor>newLinkedList();
		if (oclIsKindOf(it.figure, CustomFigure)) {
			var cf = it.figure as CustomFigure;
			while (oclIsKindOf(cf.eContainer, FigureAccessor)) {
				result.push(cf.eContainer as FigureAccessor)
				cf = cf.eContainer.eContainer as CustomFigure;
			}
		}
		return result;
	}

	def String svgPropertyType(SVGProperty p) {
		return switch (p.type) {
			case SVGPropertyType::COLOR: 'org.eclipse.swt.graphics.Color'
			case SVGPropertyType::FLOAT: 'float'
			default: 'String'
		}
	}

	@MetaDef def String fontVariableName(BasicFont it, String figureVarName) {
		figureVarName.toUpperCase + '_FONT'
	}

	@MetaDef def String backgroundColorVariableName(Color it, String figureVarName) {
		figureVarName.toUpperCase + '_BACK'
	}

	@MetaDef def String foregroundColorVariableName(Color it, String figureVarName) {
		figureVarName.toUpperCase + '_FORE'
	}
	
	protected def trimPrefixIfAny(String text, String prefix) {
		return if(text.startsWith(prefix) && text.length > prefix.length) text.substring(prefix.length) else text
	}

}

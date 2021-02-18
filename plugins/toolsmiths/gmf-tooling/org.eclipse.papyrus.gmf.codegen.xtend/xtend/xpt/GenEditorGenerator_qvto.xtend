/*******************************************************************************
 * Copyright (c) 2007, 2020 Borland Software Corporation, CEA LIST, Artal and others
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
package xpt

import com.google.inject.Inject
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenEditorGenerator

@com.google.inject.Singleton class GenEditorGenerator_qvto {
	@Inject extension GenModelUtils_qvto;

	/** 
	 * FIXME remove java-only GenEditorGenerator#hasAudits or declare it in metamodel
	 */
	def boolean hasAudits(GenEditorGenerator editorGen) {
		return editorGen.audits != null && !editorGen.audits.rules.empty
	}

	/** 
	 * @see GenModelUtils#jdkComplianceLevel
	 */
	def int jdkComplianceLevel(GenEditorGenerator xptSelf) {
		//TODO honest field in the GenEditorGenerator instead of hardcoded value
		return xptSelf.diagram.domainDiagramElement.jdkComplianceLevel();
	}

	def int jdkComplianceLevel(GenCommonBase xptSelf) {
		return xptSelf.diagram.editorGen.jdkComplianceLevel()
	}

}

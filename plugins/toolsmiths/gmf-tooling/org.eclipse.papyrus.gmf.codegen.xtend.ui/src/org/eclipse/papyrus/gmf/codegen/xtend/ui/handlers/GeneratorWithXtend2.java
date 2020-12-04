/*******************************************************************************
* Copyright (c) 2013, 2020 Montages A.G., CEA LIST, Artal
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License 2.0
* which accompanies this distribution, and is available at
* https://www.eclipse.org/legal/epl-2.0/
*
* Contributors:
*  	Guillaume Hillairet (Montages A.G.) : initial implementation
*    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
*****************************************************************************/
package org.eclipse.papyrus.gmf.codegen.xtend.ui.handlers;

import org.eclipse.papyrus.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.papyrus.gmf.internal.common.codegen.CodeFormatterFactory;

/**
 * Use {@link org.eclipse.papyrus.gmf.codegen.util.GeneratorWithXtend2}
 */
@Deprecated
public class GeneratorWithXtend2 extends org.eclipse.papyrus.gmf.codegen.util.GeneratorWithXtend2 {

	public GeneratorWithXtend2(GenEditorGenerator genModel) {
		super(genModel, new CodegenEmittersWithXtend2(genModel));
	}

	public GeneratorWithXtend2(GenEditorGenerator genModel, CodegenEmittersWithXtend2 codegenEmitters) {
		super(genModel, codegenEmitters, CodeFormatterFactory.DEFAULT);
	}

	public GeneratorWithXtend2(GenEditorGenerator genModel, CodegenEmittersWithXtend2 codegenEmitters, CodeFormatterFactory codeFormatterFactory) {
		super(genModel, codegenEmitters, codeFormatterFactory);
	}

}

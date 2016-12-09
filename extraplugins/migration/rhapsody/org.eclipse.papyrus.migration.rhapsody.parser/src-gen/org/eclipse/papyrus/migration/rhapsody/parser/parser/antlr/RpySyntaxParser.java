/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.migration.rhapsody.parser.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.papyrus.migration.rhapsody.parser.services.RpySyntaxGrammarAccess;

public class RpySyntaxParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private RpySyntaxGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS");
	}
	
	@Override
	protected org.eclipse.papyrus.migration.rhapsody.parser.parser.antlr.internal.InternalRpySyntaxParser createParser(XtextTokenStream stream) {
		return new org.eclipse.papyrus.migration.rhapsody.parser.parser.antlr.internal.InternalRpySyntaxParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "RpyFile";
	}
	
	public RpySyntaxGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(RpySyntaxGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}

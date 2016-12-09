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
package org.eclipse.papyrus.migration.rhapsody.parser.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.eclipse.papyrus.migration.rhapsody.parser.services.RpySyntaxGrammarAccess;

public class RpySyntaxParser extends AbstractContentAssistParser {
	
	@Inject
	private RpySyntaxGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.eclipse.papyrus.migration.rhapsody.parser.ui.contentassist.antlr.internal.InternalRpySyntaxParser createParser() {
		org.eclipse.papyrus.migration.rhapsody.parser.ui.contentassist.antlr.internal.InternalRpySyntaxParser result = new org.eclipse.papyrus.migration.rhapsody.parser.ui.contentassist.antlr.internal.InternalRpySyntaxParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getRpyContentAccess().getAlternatives(), "rule__RpyContent__Alternatives");
					put(grammarAccess.getRpyFeatureValueAccess().getAlternatives(), "rule__RpyFeatureValue__Alternatives");
					put(grammarAccess.getVALUE_TERMINALAccess().getAlternatives(), "rule__VALUE_TERMINAL__Alternatives");
					put(grammarAccess.getRpyFileAccess().getGroup(), "rule__RpyFile__Group__0");
					put(grammarAccess.getRpyNodeAccess().getGroup(), "rule__RpyNode__Group__0");
					put(grammarAccess.getRpyFeatureAccess().getGroup(), "rule__RpyFeature__Group__0");
					put(grammarAccess.getSimpleValueListAccess().getGroup(), "rule__SimpleValueList__Group__0");
					put(grammarAccess.getRpySimpleValueElementAccess().getGroup(), "rule__RpySimpleValueElement__Group__0");
					put(grammarAccess.getRpyStringMapEntryAccess().getGroup(), "rule__RpyStringMapEntry__Group__0");
					put(grammarAccess.getRpyFileAccess().getVersionAssignment_1(), "rule__RpyFile__VersionAssignment_1");
					put(grammarAccess.getRpyFileAccess().getContentsAssignment_2(), "rule__RpyFile__ContentsAssignment_2");
					put(grammarAccess.getRpyNodeAccess().getNameAssignment_1(), "rule__RpyNode__NameAssignment_1");
					put(grammarAccess.getRpyNodeAccess().getContentsAssignment_2(), "rule__RpyNode__ContentsAssignment_2");
					put(grammarAccess.getRpyFeatureAccess().getNameAssignment_1(), "rule__RpyFeature__NameAssignment_1");
					put(grammarAccess.getRpyFeatureAccess().getValueAssignment_3(), "rule__RpyFeature__ValueAssignment_3");
					put(grammarAccess.getRpyNodeListAccess().getValuesAssignment(), "rule__RpyNodeList__ValuesAssignment");
					put(grammarAccess.getSimpleValueListAccess().getIsOldIDAssignment_1(), "rule__SimpleValueList__IsOldIDAssignment_1");
					put(grammarAccess.getSimpleValueListAccess().getIsGUIDAssignment_2(), "rule__SimpleValueList__IsGUIDAssignment_2");
					put(grammarAccess.getSimpleValueListAccess().getValueElementsAssignment_3(), "rule__SimpleValueList__ValueElementsAssignment_3");
					put(grammarAccess.getRpySimpleValueElementAccess().getValuesAssignment_1(), "rule__RpySimpleValueElement__ValuesAssignment_1");
					put(grammarAccess.getRpyStringMapAccess().getEntriesAssignment(), "rule__RpyStringMap__EntriesAssignment");
					put(grammarAccess.getRpyStringMapEntryAccess().getKeyAssignment_0(), "rule__RpyStringMapEntry__KeyAssignment_0");
					put(grammarAccess.getRpyStringMapEntryAccess().getValueAssignment_1(), "rule__RpyStringMapEntry__ValueAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.eclipse.papyrus.migration.rhapsody.parser.ui.contentassist.antlr.internal.InternalRpySyntaxParser typedParser = (org.eclipse.papyrus.migration.rhapsody.parser.ui.contentassist.antlr.internal.InternalRpySyntaxParser) parser;
			typedParser.entryRuleRpyFile();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS" };
	}
	
	public RpySyntaxGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(RpySyntaxGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

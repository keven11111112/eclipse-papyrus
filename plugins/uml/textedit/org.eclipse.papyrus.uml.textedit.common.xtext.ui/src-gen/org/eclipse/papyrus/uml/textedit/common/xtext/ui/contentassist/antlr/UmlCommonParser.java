/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.common.xtext.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.eclipse.papyrus.uml.textedit.common.xtext.services.UmlCommonGrammarAccess;

public class UmlCommonParser extends AbstractContentAssistParser {

	@Inject
	private UmlCommonGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected org.eclipse.papyrus.uml.textedit.common.xtext.ui.contentassist.antlr.internal.InternalUmlCommonParser createParser() {
		org.eclipse.papyrus.uml.textedit.common.xtext.ui.contentassist.antlr.internal.InternalUmlCommonParser result = new org.eclipse.papyrus.uml.textedit.common.xtext.ui.contentassist.antlr.internal.InternalUmlCommonParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getUnlimitedLiteralAccess().getAlternatives(), "rule__UnlimitedLiteral__Alternatives");
					put(grammarAccess.getVisibilityKindAccess().getAlternatives(), "rule__VisibilityKind__Alternatives");
					put(grammarAccess.getDirectionAccess().getAlternatives(), "rule__Direction__Alternatives");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getTypeRuleAccess().getGroup(), "rule__TypeRule__Group__0");
					put(grammarAccess.getMultiplicityRuleAccess().getGroup(), "rule__MultiplicityRule__Group__0");
					put(grammarAccess.getMultiplicityRuleAccess().getGroup_2(), "rule__MultiplicityRule__Group_2__0");
					put(grammarAccess.getQualifiedNameAccess().getPathAssignment_0(), "rule__QualifiedName__PathAssignment_0");
					put(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2(), "rule__QualifiedName__RemainingAssignment_2");
					put(grammarAccess.getTypeRuleAccess().getPathAssignment_0(), "rule__TypeRule__PathAssignment_0");
					put(grammarAccess.getTypeRuleAccess().getTypeAssignment_1(), "rule__TypeRule__TypeAssignment_1");
					put(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1(), "rule__MultiplicityRule__BoundsAssignment_1");
					put(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2_1(), "rule__MultiplicityRule__BoundsAssignment_2_1");
					put(grammarAccess.getBoundSpecificationAccess().getValueAssignment(), "rule__BoundSpecification__ValueAssignment");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.eclipse.papyrus.uml.textedit.common.xtext.ui.contentassist.antlr.internal.InternalUmlCommonParser typedParser = (org.eclipse.papyrus.uml.textedit.common.xtext.ui.contentassist.antlr.internal.InternalUmlCommonParser) parser;
			typedParser.entryRuleQualifiedName();
			return typedParser.getFollowElements();
		} catch (RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public UmlCommonGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(UmlCommonGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

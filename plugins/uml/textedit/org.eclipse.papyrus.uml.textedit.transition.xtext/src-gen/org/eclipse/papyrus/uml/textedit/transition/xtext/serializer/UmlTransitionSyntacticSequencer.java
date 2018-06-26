/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.serializer;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.transition.xtext.services.UmlTransitionGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class UmlTransitionSyntacticSequencer extends AbstractSyntacticSequencer {

	protected UmlTransitionGrammarAccess grammarAccess;

	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (UmlTransitionGrammarAccess) access;
	}

	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}


	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty())
			return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

}

/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.serializer;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.services.UmlCollaborationUseGrammarAccess;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.CollaborationUseRule;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.TypeRule;
import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.UmlCollaborationUsePackage;
import org.eclipse.papyrus.uml.textedit.common.xtext.serializer.UmlCommonSemanticSequencer;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class UmlCollaborationUseSemanticSequencer extends UmlCommonSemanticSequencer {

	@Inject
	private UmlCollaborationUseGrammarAccess grammarAccess;

	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == UmlCollaborationUsePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case UmlCollaborationUsePackage.COLLABORATION_USE_RULE:
				sequence_CollaborationUseRule(context, (CollaborationUseRule) semanticObject);
				return;
			case UmlCollaborationUsePackage.TYPE_RULE:
				sequence_TypeRule(context, (TypeRule) semanticObject);
				return;
			}
		else if (epackage == UmlCommonPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case UmlCommonPackage.BOUND_SPECIFICATION:
				sequence_BoundSpecification(context, (BoundSpecification) semanticObject);
				return;
			case UmlCommonPackage.MULTIPLICITY_RULE:
				sequence_MultiplicityRule(context, (MultiplicityRule) semanticObject);
				return;
			case UmlCommonPackage.QUALIFIED_NAME:
				sequence_QualifiedName(context, (QualifiedName) semanticObject);
				return;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}

	/**
	 * Contexts:
	 * CollaborationUseRule returns CollaborationUseRule
	 *
	 * Constraint:
	 * (visibility=VisibilityKind name=ID type=TypeRule?)
	 */
	protected void sequence_CollaborationUseRule(ISerializationContext context, CollaborationUseRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * TypeRule returns TypeRule
	 *
	 * Constraint:
	 * (path=QualifiedName? type=[Collaboration|ID])
	 */
	protected void sequence_TypeRule(ISerializationContext context, TypeRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


}

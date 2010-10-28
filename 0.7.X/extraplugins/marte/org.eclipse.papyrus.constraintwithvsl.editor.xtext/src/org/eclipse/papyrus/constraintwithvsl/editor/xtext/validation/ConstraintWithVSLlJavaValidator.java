package org.eclipse.papyrus.constraintwithvsl.editor.xtext.validation;

import org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintSpecification;
import org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintWithVSLlPackage;
import org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil;
import org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator.VSLValidationResult;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtext.validation.Check;
 

public class ConstraintWithVSLlJavaValidator extends AbstractConstraintWithVSLlJavaValidator {

//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital", MyDslPackage.GREETING__NAME);
//		}
//	}

	private static Namespace model ;
	private static Element contextElement ;
	
	public static void init(Element _contextElement) {
		contextElement = _contextElement ;
		if (contextElement != null) {
			Element elem = contextElement.getOwner() ;
			while (elem.getOwner() != null) {
				elem = elem.getOwner() ;
			}
			model = (Namespace)elem ;
		}
	}

	public static Namespace getModel() {
		return model ;
	}
	
	public static Element getContextElement() {
		return contextElement ;
	}
	
	@Check
	public void checkConstraintSpecification_Expression(ConstraintSpecification constraintSpecificationRule) {
		if (constraintSpecificationRule != null && constraintSpecificationRule.getExpression() != null) {
			
			VSLJavaValidator.setExpectedType(VSLJavaValidator._boolean) ;
//			Type inferedType = new VSLTypeInferenceUtil(valuedProperty.getType())
//									.typeOfExpression(expressionValueRule.getExpression()) ;
//			
//			if (inferedType != valuedProperty.getType()) {
//				String message = "" +
//					(inferedType == null ? 
//							"Could not infer type of expression. " :
//								"Found an expression of type " + inferedType.getName()+ ". ");
//				message += "Expecting an expression of type " + valuedProperty.getType().getName() ;
//				error(message, StereotypeApplicationWithVSLPackage.EXPRESSION_VALUE_RULE__EXPRESSION) ;
//			}
			
			VSLValidationResult validationResult = VSLJavaValidator.eInstance.checkExpressionRule(constraintSpecificationRule.getExpression()) ;
			if (! validationResult.errorFound()) {
				String inferedTypeName = validationResult.inferedType() != null ? validationResult.inferedType().getName() : "null" ;
				if (! inferedTypeName.equals("Boolean")) {
					error("Expecting an expression of type Boolean. Found an expression of type " + inferedTypeName,
							constraintSpecificationRule.getExpression(),
							ConstraintWithVSLlPackage.CONSTRAINT_SPECIFICATION__EXPRESSION) ;
				}
			}
			else {
				error(validationResult.errorMessage(),
						validationResult.validatedRule(),
						validationResult.validatedFeature()) ;
			}
		}
	}
	
}

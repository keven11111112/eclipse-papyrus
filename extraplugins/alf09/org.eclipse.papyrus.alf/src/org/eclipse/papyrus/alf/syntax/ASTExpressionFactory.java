package org.eclipse.papyrus.alf.syntax;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.alf.alf.AdditiveExpression;
import org.eclipse.papyrus.alf.alf.AndExpression;
import org.eclipse.papyrus.alf.alf.BOOLEAN_LITERAL;
import org.eclipse.papyrus.alf.alf.BooleanValue;
import org.eclipse.papyrus.alf.alf.CollectOrIterateOperation;
import org.eclipse.papyrus.alf.alf.ConditionalAndExpression;
import org.eclipse.papyrus.alf.alf.ExclusiveOrExpression;
import org.eclipse.papyrus.alf.alf.ForAllOrExistsOrOneOperation;
import org.eclipse.papyrus.alf.alf.INTEGER_LITERAL;
import org.eclipse.papyrus.alf.alf.InclusiveOrExpression;
import org.eclipse.papyrus.alf.alf.IsUniqueOperation;
import org.eclipse.papyrus.alf.alf.LITERAL;
import org.eclipse.papyrus.alf.alf.LinkOperationTuple;
import org.eclipse.papyrus.alf.alf.MultiplicativeExpression;
import org.eclipse.papyrus.alf.alf.NonLiteralValueSpecification;
import org.eclipse.papyrus.alf.alf.NullExpression;
import org.eclipse.papyrus.alf.alf.ParenthesizedExpression;
import org.eclipse.papyrus.alf.alf.PrimaryExpression;
import org.eclipse.papyrus.alf.alf.QualifiedNamePath;
import org.eclipse.papyrus.alf.alf.QualifiedNameWithBinding;
import org.eclipse.papyrus.alf.alf.STRING_LITERAL;
import org.eclipse.papyrus.alf.alf.SelectOrRejectOperation;
import org.eclipse.papyrus.alf.alf.SuffixExpression;
import org.eclipse.papyrus.alf.alf.TupleElement;
import org.eclipse.papyrus.alf.alf.UNLIMITED_LITERAL;
import org.eclipse.papyrus.alf.alf.UnqualifiedName;
import org.eclipse.papyrus.alf.syntax.expressions.ArithmeticExpression;
import org.eclipse.papyrus.alf.syntax.expressions.BitStringUnaryExpression;
import org.eclipse.papyrus.alf.syntax.expressions.BooleanLiteralExpression;
import org.eclipse.papyrus.alf.syntax.expressions.BooleanUnaryExpression;
import org.eclipse.papyrus.alf.syntax.expressions.CastExpression;
import org.eclipse.papyrus.alf.syntax.expressions.ClassExtentExpression;
import org.eclipse.papyrus.alf.syntax.expressions.ClassificationExpression;
import org.eclipse.papyrus.alf.syntax.expressions.ConditionalLogicalExpression;
import org.eclipse.papyrus.alf.syntax.expressions.ConditionalTestExpression;
import org.eclipse.papyrus.alf.syntax.expressions.EqualityExpression;
import org.eclipse.papyrus.alf.syntax.expressions.Expression;
import org.eclipse.papyrus.alf.syntax.expressions.ExtentOrExpression;
import org.eclipse.papyrus.alf.syntax.expressions.FeatureInvocationExpression;
import org.eclipse.papyrus.alf.syntax.expressions.FeatureReference;
import org.eclipse.papyrus.alf.syntax.expressions.ForAllOrExistsOrOneExpression;
import org.eclipse.papyrus.alf.syntax.expressions.InstanceCreationExpression;
import org.eclipse.papyrus.alf.syntax.expressions.InvocationExpression;
import org.eclipse.papyrus.alf.syntax.expressions.IsUniqueExpression;
import org.eclipse.papyrus.alf.syntax.expressions.IsolationExpression;
import org.eclipse.papyrus.alf.syntax.expressions.LinkOperationExpression;
import org.eclipse.papyrus.alf.syntax.expressions.LogicalExpression;
import org.eclipse.papyrus.alf.syntax.expressions.NameBinding;
import org.eclipse.papyrus.alf.syntax.expressions.NameExpression;
import org.eclipse.papyrus.alf.syntax.expressions.NamedExpression;
import org.eclipse.papyrus.alf.syntax.expressions.NamedTemplateBinding;
import org.eclipse.papyrus.alf.syntax.expressions.NamedTuple;
import org.eclipse.papyrus.alf.syntax.expressions.NaturalLiteralExpression;
import org.eclipse.papyrus.alf.syntax.expressions.NumericUnaryExpression;
import org.eclipse.papyrus.alf.syntax.expressions.PositionalTuple;
import org.eclipse.papyrus.alf.syntax.expressions.PropertyAccessExpression;
import org.eclipse.papyrus.alf.syntax.expressions.QualifiedName;
import org.eclipse.papyrus.alf.syntax.expressions.RelationalExpression;
import org.eclipse.papyrus.alf.syntax.expressions.SelectOrRejectExpression;
import org.eclipse.papyrus.alf.syntax.expressions.SequenceAccessExpression;
import org.eclipse.papyrus.alf.syntax.expressions.SequenceConstructionExpression;
import org.eclipse.papyrus.alf.syntax.expressions.SequenceElements;
import org.eclipse.papyrus.alf.syntax.expressions.SequenceExpressionList;
import org.eclipse.papyrus.alf.syntax.expressions.SequenceOperationExpression;
import org.eclipse.papyrus.alf.syntax.expressions.SequenceRange;
import org.eclipse.papyrus.alf.syntax.expressions.SequenceReductionExpression;
import org.eclipse.papyrus.alf.syntax.expressions.ShiftExpression;
import org.eclipse.papyrus.alf.syntax.expressions.StringLiteralExpression;
import org.eclipse.papyrus.alf.syntax.expressions.SuperInvocationExpression;
import org.eclipse.papyrus.alf.syntax.expressions.TemplateBinding;
import org.eclipse.papyrus.alf.syntax.expressions.TemplateParameterSubstitution;
import org.eclipse.papyrus.alf.syntax.expressions.ThisExpression;
import org.eclipse.papyrus.alf.syntax.expressions.Tuple;
import org.eclipse.papyrus.alf.syntax.expressions.UnaryExpression;
import org.eclipse.papyrus.alf.syntax.expressions.UnboundedLiteralExpression;

public class ASTExpressionFactory {
	/*
	 * Synthesizes a alf.syntax.expressions.QualifiedName from a QualifiedNameWithBinding
	 */
	public static final QualifiedName synthesizeQualifiedName(QualifiedNameWithBinding parsed) {
		QualifiedName synthesized = new QualifiedName() ; 
		
		/* 1. Synthesizes property isAmbigous:boolean */
		// LIMITATION: The parser implementation only supports :: (no .)
		// Therefore, a qualified name is never ambiguous
		synthesized.isAmbiguous = false ;
		
		/* 2. Synthesizes property nameBinding:List<NameBinding> */
		synthesized.nameBinding = new ArrayList<NameBinding>() ;
		synthesized.nameBinding.add(
				ASTExpressionFactory.synthesizeNameBinding(parsed)) ;
		QualifiedNameWithBinding remaining = parsed.getRemaining() ;
		while(remaining != null) {
			synthesized.nameBinding.add(
					ASTExpressionFactory.synthesizeNameBinding(remaining)) ;
			remaining = remaining.getRemaining() ;
		}
		
		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.QualifiedName from a NameExpression
	 */
	public static final QualifiedName synthesizeQualifiedName(org.eclipse.papyrus.alf.alf.NameExpression parsed) {
		QualifiedName synthesized = new QualifiedName() ;
		/* 1. Synthesizes property isAmbigous:boolean */
		// LIMITATION: The parser implementation only supports :: (no .)
		// Therefore, a qualified name is never ambiguous
		synthesized.isAmbiguous = false ;

		/* 2. Synthesizes property nameBinding:List<NameBinding> */
		synthesized.nameBinding = new ArrayList<NameBinding>() ;
		if (parsed.getPath() != null) {
			QualifiedNamePath path = parsed.getPath() ;
			for (UnqualifiedName pathElement : path.getNamespace()) {
				synthesized.nameBinding.add(ASTExpressionFactory.synthesizeNameBinding(pathElement)) ;
			}
		}
		// Finally add the last name binding (i.e., parsed.id)
		// LIMITATION: The parser implementation does not support a template binding for the last element of the path
		NameBinding last = new NameBinding() ;
		last.name = parsed.getId() ;
		synthesized.nameBinding.add(last) ;
		
		// TODO: raise an error in the cases where the following properties have a value:
		// - prefixOp
		// - invocationCompletion
		// - sequenceConstructionCompletion
		// - postfixOp
		// - suffix
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.QualifiedName from a NameExpression
	 */
	public static final QualifiedName synthesizeQualifiedName(
			org.eclipse.papyrus.alf.alf.Expression parsed) {
		// TODO Raise an error in the case where "parsed" does not finally resolve to a NameExpression
		org.eclipse.papyrus.alf.alf.ConditionalTestExpression tmp1 = 
				(org.eclipse.papyrus.alf.alf.ConditionalTestExpression)parsed ;
		if (tmp1.getWhenFalse() != null || tmp1.getWhenTrue() != null)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.alf.alf.ConditionalOrExpression tmp2 = tmp1.getExp() ;
		if (tmp2.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.alf.alf.ConditionalAndExpression tmp3 = tmp2.getExp().get(0) ;
		if (tmp3.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.alf.alf.InclusiveOrExpression tmp4 = tmp3.getExp().get(0) ;
		if (tmp4.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.alf.alf.ExclusiveOrExpression tmp5 = tmp4.getExp().get(0) ;
		if (tmp5.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.alf.alf.AndExpression tmp6 = tmp5.getExp().get(0) ;
		if (tmp6.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.alf.alf.EqualityExpression tmp7 = tmp6.getExp().get(0) ;
		if (tmp7.getOp().size() != 0)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.alf.alf.ClassificationExpression tmp8 = tmp7.getExp().get(0) ;
		if (tmp8.getOp() != null && !tmp8.getOp().equals(""))
			//error
			return new QualifiedName() ;
		org.eclipse.papyrus.alf.alf.RelationalExpression tmp9 = tmp8.getExp() ;
		if (tmp9.getOp() != null && !tmp9.getOp().equals(""))
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.alf.alf.ShiftExpression tmp10 = tmp9.getLeft() ;
		if (tmp10.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.alf.alf.AdditiveExpression tmp11 = tmp10.getExp().get(0) ;
		if (tmp11.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.alf.alf.MultiplicativeExpression tmp12 = tmp11.getExp().get(0) ;
		if (tmp12.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.alf.alf.UnaryExpression tmp13 = tmp12.getExp().get(0) ;
		if (tmp13.getOp() != null && !tmp13.getOp().equals(""))
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.alf.alf.PrimaryExpression tmp14 = tmp13.getExp() ;
		if (tmp14.getPrefix() == null)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.alf.alf.ValueSpecification tmp15 = tmp14.getPrefix() ;
		
		if (! (tmp15 instanceof org.eclipse.papyrus.alf.alf.NameExpression))
			// error
			return new QualifiedName() ;
		
		return ASTExpressionFactory.synthesizeQualifiedName((org.eclipse.papyrus.alf.alf.NameExpression)tmp15) ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.QualifiedName from a alf.syntax.expressions.Expression
	 */
	public static final QualifiedName synthesizeQualifiedName(Expression synthesized) {
		if (synthesized instanceof NameExpression)
			return ((NameExpression) synthesized).name ;
		return new QualifiedName() ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.NameBinding from a QualifiedNameWithBinding
	 */
	public static final NameBinding synthesizeNameBinding(QualifiedNameWithBinding parsed) {
		NameBinding synthesized = new NameBinding() ;
		/* 1. Synthesizes property name:String */
		synthesized.name = "" + parsed.getId() ;
		
		/* 2. Synthesizes property binding:TemplateBinding */
		if (parsed.getBinding() != null) {
			synthesized.binding = 
					ASTExpressionFactory.synthesizeTemplateBinding(parsed.getBinding()) ;
		}
		
		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.NameBinding from a String
	 */
	public static final NameBinding synthesizeNameBinding(String parsed) {
		NameBinding synthesized = new NameBinding() ;
		/* 1. Synthesizes property name:String */
		synthesized.name = "" + parsed ;
		
		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.NameBinding from a UnqualifiedName
	 */
	public static final NameBinding synthesizeNameBinding(UnqualifiedName parsed) {
		NameBinding synthesized = new NameBinding() ;
		/* 1. Synthesizes property name:String */
		synthesized.name = "" + parsed.getName() ;
		
		/* 2. Synthesizes property binding:TemplateBinding */
		if (parsed.getTemplateBinding() != null) {
			synthesized.binding = 
					ASTExpressionFactory.synthesizeTemplateBinding(parsed.getTemplateBinding()) ;
		}
		
		return synthesized ;
	}

	/*
	 * Synthesizes a import alf.syntax.expressions.TemplateBinding from a TemplateBinding
	 */
	public static final TemplateBinding synthesizeTemplateBinding(org.eclipse.papyrus.alf.alf.TemplateBinding parsed) {
		// LIMITATION: In this implementation of the Alf parser, only NamedTemplateBinding are supported		
		return ASTExpressionFactory.synthesizeNamedTemplateBinding(parsed) ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.NamedTemplateBinding from a TemplateBinding
	 */
	public static final NamedTemplateBinding synthesizeNamedTemplateBinding(org.eclipse.papyrus.alf.alf.TemplateBinding parsed) {
		NamedTemplateBinding synthesized = new NamedTemplateBinding() ;
		
		/*1. Synthesizes property substitution:List<TemplateParameterSubstitution> */
		synthesized.substitution = new ArrayList<TemplateParameterSubstitution>() ;
		for (org.eclipse.papyrus.alf.alf.NamedTemplateBinding s : parsed.getBindings()) {
			synthesized.substitution.add(
				ASTExpressionFactory.synthesizeTemplateParameterSubstitution(s)) ;
		}
		return synthesized ;
	}
	/*
	 * Synthesizes a alf.syntax.expressions.TemplateParameterSubstitution from a NamedTemplateBinding
	 * NOTE: The class NamedTemplateBinding, from the implementation of the Alf grammar, is misleading
	 * Should be TemplateParameterSubsitution
	 */
	public static final TemplateParameterSubstitution synthesizeTemplateParameterSubstitution(org.eclipse.papyrus.alf.alf.NamedTemplateBinding parsed) {
		TemplateParameterSubstitution synthesized = new TemplateParameterSubstitution() ;
		
		/* 1. Synthesizes property parameterName:String */
		synthesized.parameterName = parsed.getFormal() ;
		
		/* 2. Synthesizes property argumentName:QualifiedName */
		synthesized.argumentName =
				ASTExpressionFactory.synthesizeQualifiedName(parsed.getActual()) ;
		
		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from an Expression
	 */
	public static final Expression synthesizeExpression(org.eclipse.papyrus.alf.alf.Expression parsed) {
		
		// In this implementation of the Alf parser, rule Expression can only 
		// produce a ConditionalTestExpression
		// NOTE: In the Alf spec, Expression can also produce an AssignmentExpression,
		// which are not directly supported by our parser.
		return ASTExpressionFactory.synthesizeConditionalTestExpression((org.eclipse.papyrus.alf.alf.ConditionalTestExpression)parsed); 
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ParenthesizedExpression
	 */
	public static final Expression synthesizeExpression(ParenthesizedExpression parsed) {
		// first check it is really a ParenthesizedExpression
		if (parsed.getCasted() == null) {
			// this is a ParenthesizedExpression
			Expression synthesized = ASTExpressionFactory.synthesizeExpression(parsed.getExpOrTypeCast()) ;
			if (parsed.getSuffix() != null)
				return ASTExpressionFactory.synthesizeExpression(synthesized, parsed.getSuffix()) ;
			return synthesized ;
		}
		
		// this is not a ParenthesizedExpression, i.e., this is a cast expression
		return ASTExpressionFactory.synthesizeCastExpression(parsed) ;
	}
	
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a NameExpression
	 */
	public static final Expression synthesizeExpression(org.eclipse.papyrus.alf.alf.NameExpression exp) {
		// TODO Auto-generated method stub
		return new Expression();
	}
	
	
	public static final Expression synthesizeCastExpression(ParenthesizedExpression parsed) {
		CastExpression synthesized = new CastExpression() ;
		
		/* 1. Synthesizes property operand:Expression */
		synthesized.operand = ASTExpressionFactory.synthesizePrimaryExpression(parsed.getCasted()) ;
		
		/* 2. Synthesizes property typeName:QualifiedName */
		synthesized.typeName = ASTExpressionFactory.synthesizeQualifiedName(parsed.getExpOrTypeCast()) ;
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ConditionTestExpression
	 */
	public static final Expression synthesizeConditionalTestExpression(org.eclipse.papyrus.alf.alf.ConditionalTestExpression parsed) {
		// First checks if it is actually a ConditionalTestExpression
		if (parsed.getWhenFalse() != null || parsed.getWhenTrue() != null) {
			// This is a ConditionalTestExpression
			ConditionalTestExpression synthesized = new ConditionalTestExpression() ;
			/* 1. Synthesizes property operand1:Expression */
			synthesized.operand1 = ASTExpressionFactory.synthesizeConditionalLogicalExpression(parsed.getExp()) ;
			
			/* 2. Synthesizes property operand2:Expression */
			synthesized.operand2 = ASTExpressionFactory.synthesizeConditionalTestExpression(parsed.getWhenTrue()) ;
			
			/* 3. Synthesizes property operand3:Expression */
			synthesized.operand3 = ASTExpressionFactory.synthesizeConditionalTestExpression(parsed.getWhenFalse()) ;
			
			return synthesized ;
		}
		
		// This is not a ConditionalTestExpression
		return ASTExpressionFactory.synthesizeConditionalLogicalExpression(parsed.getExp()) ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ConditionalOrExpression
	 */
	public static final Expression synthesizeConditionalLogicalExpression(org.eclipse.papyrus.alf.alf.ConditionalOrExpression parsed) {

		// First check if it is a ConditionalOrExpression
		if (parsed.getExp().size() == 1)
			// This is not a ConditionalOrExpression
			return ASTExpressionFactory.synthesizeConditionalLogicalExpression(parsed.getExp().get(0)) ;
		
		// This is a ConditionalOrExpression
		ConditionalLogicalExpression synthesized = new ConditionalLogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = ASTExpressionFactory.synthesizeConditionalLogicalExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeConditionalLogicalExpression(parsed.getExp().subList(1, parsed.getExp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "||" ;

		return synthesized ;
		
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ConditionalAndExpression
	 */
	public static final Expression synthesizeConditionalLogicalExpression(
			ConditionalAndExpression parsed) {
		//first check if it is a ConditionalAndExpression
		if (parsed.getExp().size() == 1)
			// This is not a ConditionalAndExpression
			return ASTExpressionFactory.synthesizeLogicalExpression(parsed.getExp().get(0)) ;

		// This is a ConditionalAndExpression
		ConditionalLogicalExpression synthesized = new ConditionalLogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = ASTExpressionFactory.synthesizeLogicalExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeLogicalExpressionFromListOfInclusiveOrExpression (parsed.getExp().subList(1, parsed.getExp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "&&" ;

		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list ConditionalAndExpression
	 * representing a flat ConditionalAndExpression
	 */
	public static final Expression synthesizeConditionalLogicalExpression(
			List<ConditionalAndExpression> flatParsed) {
		
		//first check if it is a ConditionalAndExpression
		if (flatParsed.size() == 1)
			// This is not a flat ConditionalAndExpression
			return ASTExpressionFactory.synthesizeConditionalLogicalExpression(flatParsed.get(0)) ;
		
		// This is a flat ConditionalAndExpression
		ConditionalLogicalExpression synthesized = new ConditionalLogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = ASTExpressionFactory.synthesizeConditionalLogicalExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeConditionalLogicalExpression(flatParsed.subList(1, flatParsed.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "&&" ;
		
		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a InclusiveOrExpression
	 */
	public static final Expression synthesizeLogicalExpression(
			InclusiveOrExpression parsed) {
		//first check if it is an InclusiveOrExpression
		if (parsed.getExp().size() == 1)
			// This is not an InclusiveOrExpression
			return ASTExpressionFactory.synthesizeLogicalExpression(parsed.getExp().get(0)) ;

		// This is an InclusiveOrExpression
		LogicalExpression synthesized = new LogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = ASTExpressionFactory.synthesizeLogicalExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeLogicalExpressionFromListOfExclusiveOrExpression(parsed.getExp().subList(1, parsed.getExp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "|" ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list of InclusiveOrExpression
	 * representing a flat InclusiveOrExpression
	 */
	public static final Expression synthesizeLogicalExpressionFromListOfInclusiveOrExpression (
			List<InclusiveOrExpression> flatParsed) {
		//first check if it is a flat InclusiveOrExpression
		if (flatParsed.size() == 1)
			// This is not a flat InclusiveOrExpression
			return ASTExpressionFactory.synthesizeLogicalExpression(flatParsed.get(0)) ;

		// This is a flat InclusiveOrExpression
		LogicalExpression synthesized = new LogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = ASTExpressionFactory.synthesizeLogicalExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeLogicalExpressionFromListOfInclusiveOrExpression (flatParsed.subList(1, flatParsed.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "|" ;

		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ExclusiveOrExpression
	 */
	public static final Expression synthesizeLogicalExpression(
			ExclusiveOrExpression parsed) {
		//first check if it is an ExclusiveOrExpression
		if (parsed.getExp().size() == 1)
			// This is not an ExclusiveOrExpression
			return ASTExpressionFactory.synthesizeLogicalExpression(parsed.getExp().get(0)) ;

		// This is an InclusiveOrExpression
		LogicalExpression synthesized = new LogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = ASTExpressionFactory.synthesizeLogicalExpression(parsed.getExp().get(0));

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeLogicalExpressionFromListOfAndExpression(parsed.getExp().subList(1, parsed.getExp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "^" ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list of ExclusiveOrExpression
	 * representing a flat ExclusiveOrExpression
	 */
	public static final Expression synthesizeLogicalExpressionFromListOfExclusiveOrExpression(
			List<ExclusiveOrExpression> flatParsed) {
		//first check if it is a flat ExclusiveOrExpression
		if (flatParsed.size() == 1)
			// This is not a flat ExclusiveOrExpression
			return ASTExpressionFactory.synthesizeLogicalExpression(flatParsed.get(0)) ;

		// This is a flat ExclusiveOrExpression
		LogicalExpression synthesized = new LogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = ASTExpressionFactory.synthesizeLogicalExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeLogicalExpressionFromListOfExclusiveOrExpression (flatParsed.subList(1, flatParsed.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "^" ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a AndExpression
	 */
	public static final Expression synthesizeLogicalExpression(AndExpression parsed) {
		//first check if it is an AndExpression
		if (parsed.getExp().size() == 1)
			// This is not an AndExpression
			return ASTExpressionFactory.synthesizeEqualityExpression(parsed.getExp().get(0)) ;

		// This is an AndOrExpression
		LogicalExpression synthesized = new LogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = ASTExpressionFactory.synthesizeEqualityExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeLogicalExpressionFromListOfEqualityExpression(parsed.getExp().subList(1, parsed.getExp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "&" ;

		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list of EqualityExpression
	 * representing a flat AndExpression
	 */
	public static final Expression synthesizeLogicalExpressionFromListOfEqualityExpression(
			List<org.eclipse.papyrus.alf.alf.EqualityExpression> flatParsed) {
		//first check if it is a flat AndExpression
		if (flatParsed.size() == 1)
			// This is not a flat AndExpression
			return ASTExpressionFactory.synthesizeEqualityExpression(flatParsed.get(0)) ;

		// This is a flat AndExpression
		LogicalExpression synthesized = new LogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = ASTExpressionFactory.synthesizeEqualityExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeLogicalExpressionFromListOfEqualityExpression (flatParsed.subList(1, flatParsed.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "&" ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list of AndExpression
	 * representing a flat AndExpression
	 */
	public static final Expression synthesizeLogicalExpressionFromListOfAndExpression(
			List<AndExpression> flatParsed) {
		//first check if it is a flat AndExpression
		if (flatParsed.size() == 1)
			// This is not a flat AndExpression
			return ASTExpressionFactory.synthesizeLogicalExpression(flatParsed.get(0)) ;

		// This is a flat AndExpression
		LogicalExpression synthesized = new LogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = ASTExpressionFactory.synthesizeLogicalExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeLogicalExpressionFromListOfAndExpression (flatParsed.subList(1, flatParsed.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "&" ;

		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a EqualityExpression
	 */
	public static final Expression synthesizeEqualityExpression(
			org.eclipse.papyrus.alf.alf.EqualityExpression parsed) {
		//first check if it is an EqualityExpression
		if (parsed.getExp().size() == 1)
			// This is not an EqualityExpression
			return ASTExpressionFactory.synthesizeClassificationExpression(parsed.getExp().get(0)) ;

		// This is an EqualityExpression
		EqualityExpression synthesized = new EqualityExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = ASTExpressionFactory.synthesizeClassificationExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeEqualityExpression(parsed.getExp().subList(1, parsed.getExp().size()),
																 parsed.getOp().subList(1, parsed.getOp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = parsed.getOp().get(0) ;

		return synthesized ;
	}
	
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list of ClassificationExpression
	 * and (equality) operators representing a flat EqualityExpression
	 */
	public static final Expression synthesizeEqualityExpression(
			List<org.eclipse.papyrus.alf.alf.ClassificationExpression> flatParsed,
			List<String> operators) {
		//first check if it is a flat EqualityExpression
		if (flatParsed.size() == 1)
			// This is not a flat EqualityExpression
			return ASTExpressionFactory.synthesizeClassificationExpression(flatParsed.get(0)) ;

		// This is a flat EqualityExpression
		EqualityExpression synthesized = new EqualityExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = ASTExpressionFactory.synthesizeClassificationExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeEqualityExpression (flatParsed.subList(1, flatParsed.size()),
																  operators.subList(1, operators.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = operators.get(0) ;

		return synthesized ;
	}

	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ClassificationExpression
	 */
	public static final Expression synthesizeClassificationExpression(
			org.eclipse.papyrus.alf.alf.ClassificationExpression parsed) {
		//first check if it is a ClassificationExpression
		if (parsed.getOp() == null || parsed.getOp().equals(""))
			// This is not a ClassificationExpression
			return ASTExpressionFactory.synthesizeRelationalExpression(parsed.getExp()) ;

		// This is a ClassificationExpression
		ClassificationExpression synthesized = new ClassificationExpression() ;
		/* 1. Synthesizes property operand:Expression */
		synthesized.operand= ASTExpressionFactory.synthesizeRelationalExpression(parsed.getExp()) ;

		/* 2. Synthesizes property typename:QualifiedName */
		synthesized.typeName = ASTExpressionFactory.synthesizeQualifiedName(parsed.getTypeName()) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = parsed.getOp() ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a RelationalExpression
	 */
	public static final Expression synthesizeRelationalExpression(org.eclipse.papyrus.alf.alf.RelationalExpression parsed) {
		//first check if it is a RelationalExpression
		if (parsed.getOp() == null || parsed.getOp().equals(""))
			// This is not a RelationalExpression
			return ASTExpressionFactory.synthesizeShiftExpression(parsed.getLeft()) ;

		// This is a RelationalExpression
		RelationalExpression synthesized = new RelationalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1= ASTExpressionFactory.synthesizeShiftExpression(parsed.getLeft()) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeShiftExpression(parsed.getRight()) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = parsed.getOp() ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ShiftExpression
	 */
	public static final Expression synthesizeShiftExpression(org.eclipse.papyrus.alf.alf.ShiftExpression parsed) {
		//first check if it is a ShiftExpression
		if (parsed.getExp().size() == 1)
			// This is not a ShiftExpression
			return ASTExpressionFactory.synthesizeArithmeticExpression(parsed.getExp().get(0)) ;

		// This is a ShiftExpression
		ShiftExpression synthesized = new ShiftExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1= ASTExpressionFactory.synthesizeArithmeticExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeArithmeticExpression(parsed.getExp().get(1)) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = parsed.getOp() ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a AdditiveExpression
	 */
	public static final Expression synthesizeArithmeticExpression(
			AdditiveExpression parsed) {
		//first check if it is a AdditiveExpression
		if (parsed.getExp().size() == 1)
			// This is not a ShiftExpression
			return ASTExpressionFactory.synthesizeArithmeticExpression(parsed.getExp().get(0)) ;

		// This is a ShiftExpression
		ArithmeticExpression synthesized = new ArithmeticExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1= ASTExpressionFactory.synthesizeArithmeticExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeArithmeticExpressionFromListOfMultiplicativeExpression(parsed.getExp().subList(1, parsed.getExp().size()),
																   parsed.getOp().subList(1, parsed.getOp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = parsed.getOp().get(0) ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list of AdditiveExpression
	 * and (additive) operators representing a flat AdditiveExpression
	 */
	public static final Expression synthesizeArithmeticExpressionFromListOfMultiplicativeExpression(
			List<MultiplicativeExpression> flatParsed, List<String> operators) {
		//first check if it is a flat AdditiveExpression
		if (flatParsed.size() == 1)
			// This is not a flat AdditiveExpression
			return ASTExpressionFactory.synthesizeArithmeticExpression(flatParsed.get(0)) ;

		// This is a flat AdditiveExpression
		EqualityExpression synthesized = new EqualityExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = ASTExpressionFactory.synthesizeArithmeticExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeArithmeticExpressionFromListOfMultiplicativeExpression(flatParsed.subList(1, flatParsed.size()),
				operators.subList(1, operators.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = operators.get(0) ;

		return synthesized ;
	}

	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a MultiplicativeExpression
	 */
	public static final Expression synthesizeArithmeticExpression(
			MultiplicativeExpression parsed) {
		//first check if it is a MultiplicativeExpression
		if (parsed.getExp().size() == 1)
			// This is not a MultiplicativeExpression
			return ASTExpressionFactory.synthesizeUnaryExpression(parsed.getExp().get(0)) ;

		// This is a MultiplicativeExpression
		ArithmeticExpression synthesized = new ArithmeticExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1= ASTExpressionFactory.synthesizeUnaryExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeArithmeticExpressionFromListOfUnaryExpression(parsed.getExp().subList(1, parsed.getExp().size()),
				parsed.getOp().subList(1, parsed.getOp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = parsed.getOp().get(0) ;

		return synthesized ;
	}
	

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list of UnaryExpression
	 * and (multiplicative) operators representing a flat MultiplicativeExpression
	 */
	public static final Expression synthesizeArithmeticExpressionFromListOfUnaryExpression(
			List<org.eclipse.papyrus.alf.alf.UnaryExpression> flatParsed,
			List<String> operators) {
		//first check if it is a flat MultiplicativeExpression
		if (flatParsed.size() == 1)
			// This is not a flat MultiplicativeExpression
			return ASTExpressionFactory.synthesizeUnaryExpression(flatParsed.get(0)) ;

		// This is a flat MultiplicativeExpression
		EqualityExpression synthesized = new EqualityExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = ASTExpressionFactory.synthesizeUnaryExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = ASTExpressionFactory.synthesizeArithmeticExpressionFromListOfUnaryExpression(flatParsed.subList(1, flatParsed.size()),
				operators.subList(1, operators.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = operators.get(0) ;

		return synthesized ;
	}

	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a UnaryExpression
	 */
	public static final Expression synthesizeUnaryExpression(
			org.eclipse.papyrus.alf.alf.UnaryExpression parsed) {
		//first check if it is a UnaryExpression
		if (parsed.getOp() == null || parsed.getOp().equals(""))
			// This is not a UnaryExpression
			return ASTExpressionFactory.synthesizePrimaryExpression(parsed.getExp()) ;

		// This is a UnaryExpression
		UnaryExpression synthesized = new UnaryExpression() ;
		// depending on the operator, synthesizes the right kind of UnaryExpression 
		if (parsed.getOp().equals("!"))
			synthesized = new BooleanUnaryExpression() ;
		else if (parsed.getOp().equals("$"))
			synthesized = new IsolationExpression() ;
		else if (parsed.getOp().equals("~"))
			synthesized = new BitStringUnaryExpression() ;
		else // "+" or "-" unary operators
			synthesized = new NumericUnaryExpression() ;

		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand= ASTExpressionFactory.synthesizePrimaryExpression(parsed.getExp()) ;

		/* 2. Synthesizes property operator:String */
		synthesized.operator = parsed.getOp() ;
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a PrimaryExpression
	 */
	public static final Expression synthesizePrimaryExpression(PrimaryExpression exp) {
		if (exp.getPrefix() instanceof org.eclipse.papyrus.alf.alf.LITERAL)
			return ASTExpressionFactory.synthesizeLiteralExpression(
					(org.eclipse.papyrus.alf.alf.LITERAL) exp.getPrefix()) ;
		else if (exp.getPrefix() instanceof org.eclipse.papyrus.alf.alf.ThisExpression)
			return ASTExpressionFactory.synthesizeThisExpression(
					(org.eclipse.papyrus.alf.alf.ThisExpression) exp.getPrefix()) ;
		else if (exp.getPrefix() instanceof org.eclipse.papyrus.alf.alf.SuperInvocationExpression)
			return ASTExpressionFactory.synthesizeSuperInvocationExpression(
					(org.eclipse.papyrus.alf.alf.SuperInvocationExpression) exp.getPrefix()) ;
		else if (exp.getPrefix() instanceof org.eclipse.papyrus.alf.alf.InstanceCreationExpression)
			return ASTExpressionFactory.synthesizeInstanceCreationExpression(
					(org.eclipse.papyrus.alf.alf.InstanceCreationExpression) exp.getPrefix()) ;
		else if (exp.getPrefix() instanceof org.eclipse.papyrus.alf.alf.ParenthesizedExpression)
			return ASTExpressionFactory.synthesizeExpression(
					(org.eclipse.papyrus.alf.alf.ParenthesizedExpression) exp.getPrefix()) ;
		else if (exp.getPrefix() instanceof org.eclipse.papyrus.alf.alf.NameExpression)
			return ASTExpressionFactory.synthesizeExpression(
					(org.eclipse.papyrus.alf.alf.NameExpression) exp.getPrefix()) ;
		else // NullExpression
			return ASTExpressionFactory.synthesizeSequenceConstructionExpression(
					(org.eclipse.papyrus.alf.alf.NullExpression) exp.getPrefix()) ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a NullExpression
	 */
	public static final Expression synthesizeSequenceConstructionExpression(
			NullExpression exp) {
		SequenceConstructionExpression synthesized = new SequenceConstructionExpression() ;
		/*. No property to synthesize */
		return synthesized ;
	}
	

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a NonLiteralValueSpecification
	 */
	public static final Expression synthesizePrimaryExpression(NonLiteralValueSpecification exp) {
		if (exp instanceof org.eclipse.papyrus.alf.alf.ThisExpression)
			return ASTExpressionFactory.synthesizeThisExpression(
					(org.eclipse.papyrus.alf.alf.ThisExpression) exp) ;
		else if (exp instanceof org.eclipse.papyrus.alf.alf.SuperInvocationExpression)
			return ASTExpressionFactory.synthesizeSuperInvocationExpression(
					(org.eclipse.papyrus.alf.alf.SuperInvocationExpression) exp) ;
		else if (exp instanceof org.eclipse.papyrus.alf.alf.InstanceCreationExpression)
			return ASTExpressionFactory.synthesizeInstanceCreationExpression(
					(org.eclipse.papyrus.alf.alf.InstanceCreationExpression) exp) ;
		else if (exp instanceof org.eclipse.papyrus.alf.alf.ParenthesizedExpression)
			return ASTExpressionFactory.synthesizeExpression(
					(org.eclipse.papyrus.alf.alf.ParenthesizedExpression) exp) ;
		else // NameExpression
			return ASTExpressionFactory.synthesizeExpression(
					(org.eclipse.papyrus.alf.alf.NameExpression) exp) ;
	}
	
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a LITERAL
	 */
	public static final Expression synthesizeLiteralExpression(LITERAL parsed) {
		if (parsed instanceof INTEGER_LITERAL) {
			NaturalLiteralExpression synthesized = new NaturalLiteralExpression() ;
			/* 1. Synthesizes property image:String */
			synthesized.image = ((INTEGER_LITERAL) parsed).getValue() ;
			return synthesized ;
		}
		else if (parsed instanceof UNLIMITED_LITERAL) {
			UnboundedLiteralExpression synthesized = new UnboundedLiteralExpression() ;
			/*. No properties to synthesize */
			return synthesized ;
		}
		else if (parsed instanceof STRING_LITERAL) {
			StringLiteralExpression synthesized = new StringLiteralExpression() ;
			/* 1. Synthesizes property image:String */
			synthesized.image = ((STRING_LITERAL) parsed).getValue() ;
			return synthesized ;
		}
		else { // BOOLEAN_LITERAL
			BOOLEAN_LITERAL castedExp = (BOOLEAN_LITERAL)parsed ;
			BooleanLiteralExpression synthesized = new BooleanLiteralExpression() ;
			/* 1. Synthesizes property image:String */
			if (castedExp.getValue() == BooleanValue.TRUE)
				synthesized.image = "true" ;
			else
				synthesized.image = "false" ;
			return synthesized ;
		}
	}
	
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ThisExpression
	 */
	public static final Expression synthesizeThisExpression(org.eclipse.papyrus.alf.alf.ThisExpression parsed) {
		ThisExpression synthesized = new ThisExpression() ;
		/*. No properties to synthesize */
		if (parsed.getSuffix() != null)
			return ASTExpressionFactory.synthesizeExpression(synthesized, parsed.getSuffix()) ;
		return synthesized ;
	}

	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a SuperInvocationExpression
	 */
	public static final Expression synthesizeSuperInvocationExpression(
			org.eclipse.papyrus.alf.alf.SuperInvocationExpression parsed) {
		SuperInvocationExpression synthesized = new  SuperInvocationExpression() ;
		
		/* 1. Synthesizes property target:QualifiedName */
		if (parsed.getOperationName() != null)
			synthesized.target = ASTExpressionFactory.synthesizeQualifiedName(parsed.getOperationName()) ;
		
		/* 2. Synthesizes property tuple:Tuple */
		synthesized.tuple = ASTExpressionFactory.synthesizeTuple(parsed.getTuple(), synthesized) ;
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Tuple from a Tuple
	 */
	public static final Tuple synthesizeTuple(org.eclipse.papyrus.alf.alf.Tuple parsed,
								 InvocationExpression invocation) {
		// LIMITATION: This implementation of the Alf Parser only supports positional tuples
		return ASTExpressionFactory.synthesizePositionalTuple(parsed, invocation);
	}

	/*
	 * Synthesizes a alf.syntax.expressions.PositionalTuple from a Tuple
	 */
	public static final Tuple synthesizePositionalTuple(
			org.eclipse.papyrus.alf.alf.Tuple parsed,
			InvocationExpression invocation) {
		PositionalTuple synthesized = new PositionalTuple() ;
		
		/* 1. Synthesizes property expression:List<Expression> */
		synthesized.expression = new ArrayList<Expression>() ;
		for (TupleElement t :parsed.getTupleElements()) {
			synthesized.expression.add(ASTExpressionFactory.synthesizeExpression(t.getArgument())) ;
		}
		
		/* 2. Synthesizes property invocation:InvocationExpression */
		synthesized.invocation = invocation ;
		
		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Tuple from a LinkOperationTuple
	 */
	public static final Tuple synthesizeNamedTupleFromLinkOperationExpression(LinkOperationTuple tuple,
			LinkOperationExpression invocation) {
		NamedTuple synthesized = new NamedTuple() ;
		
		/*1. Synthesize property invocation:InvocationExpression */
		synthesized.invocation = invocation ;
		
		/*2. Synthesize property namedExpression:List<NamedExpression> */
		synthesized.namedExpression = new ArrayList<NamedExpression>() ;
		//NamedExpression n ;
		// Hypothesis: All LinkOperationTupleElement have both a "objectOrRole" and an "object"
//		for (LinkOperationTupleElement t : tuple.getLinkOperationTupleElement()) {
//			n = new NamedExpression() ;
//			n.name = t.getObjectOrRole() ;
//			if (t.getRoleIndex() != null)
//				n.index = this.synthesizeExpression(t.getRoleIndex()) ;
//			n.expression = this.synthesizeNameExpression(t.getObject()) ;
//			synthesized.namedExpression.add(n) ;
//		}
		
		return synthesized ;
	}
	
	public static final Expression synthesizeNameExpression(String object) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a InstanceCreationExpression
	 */
	public static final Expression synthesizeInstanceCreationExpression(
			org.eclipse.papyrus.alf.alf.InstanceCreationExpression parsed) {
		InstanceCreationExpression synthesized = new InstanceCreationExpression() ;
		
		/* 1. Synthesizes property target:QualifiedName */
		synthesized.constructor = ASTExpressionFactory.synthesizeQualifiedName(parsed.getConstructor()) ;
		
//		/* 2. Synthesizes property tuple:Tuple */
//		synthesized.tuple = this.synthesizeTuple(parsed.getTuple(), synthesized) ;
		
		if (parsed.getSuffix() != null)
			return ASTExpressionFactory.synthesizeExpression(synthesized, parsed.getSuffix()) ;
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a SuffixExpression
	 */
	public static final Expression synthesizeExpression(
			Expression synthesized, SuffixExpression suffix) {
		if (suffix instanceof org.eclipse.papyrus.alf.alf.OperationCallExpression)
			return ASTExpressionFactory.synthesizeFeatureInvocationExpression(
					synthesized,
					(org.eclipse.papyrus.alf.alf.OperationCallExpression)suffix) ;
		if (suffix instanceof org.eclipse.papyrus.alf.alf.PropertyCallExpression)
			return ASTExpressionFactory.synthesizePropertyAccessExpression(
					synthesized,
					(org.eclipse.papyrus.alf.alf.PropertyCallExpression)suffix) ;
		if (suffix instanceof org.eclipse.papyrus.alf.alf.LinkOperationExpression)
			return ASTExpressionFactory.synthesizeLinkOperationExpression(
					synthesized,
					(org.eclipse.papyrus.alf.alf.LinkOperationExpression)suffix) ;
		if (suffix instanceof org.eclipse.papyrus.alf.alf.SequenceOperationExpression)
			return ASTExpressionFactory.synthesizeSequenceOperationExpression(
					synthesized,
					(org.eclipse.papyrus.alf.alf.SequenceOperationExpression)suffix) ;
		if (suffix instanceof org.eclipse.papyrus.alf.alf.SequenceReductionExpression)
			return ASTExpressionFactory.synthesizeSequenceReductionExpression(
					synthesized,
					(org.eclipse.papyrus.alf.alf.SequenceReductionExpression)suffix) ;
		if (suffix instanceof org.eclipse.papyrus.alf.alf.SequenceExpansionExpression)
			return ASTExpressionFactory.synthesizeSequenceExpansionExpression(
					synthesized,
					(org.eclipse.papyrus.alf.alf.SequenceExpansionExpression)suffix) ;
		else // org.eclipse.papyrus.alf.alf.ClassExtentExpression
			return ASTExpressionFactory.synthesizeClassExtentExpression(
					synthesized,
					(org.eclipse.papyrus.alf.alf.ClassExtentExpression)suffix) ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix OperationCallExpression
	 */
	public static final Expression synthesizeFeatureInvocationExpression(
			Expression target, org.eclipse.papyrus.alf.alf.OperationCallExpression suffix) {
		FeatureInvocationExpression synthesized = new FeatureInvocationExpression() ;
		
		/*1. Synthesizes property tuple:Tuple */
		synthesized.tuple = ASTExpressionFactory.synthesizeTuple(suffix.getTuple(), synthesized) ;
		
		/*2. Synthesizes property target:FeatureReference */
		FeatureReference featureReference = new FeatureReference() ;
		featureReference.expression = target ;
		featureReference.nameBinding = ASTExpressionFactory.synthesizeNameBinding(suffix.getOperationName()) ;
		synthesized.target = featureReference ;
		
		if (suffix.getSuffix() != null)
			return ASTExpressionFactory.synthesizeExpression(synthesized, suffix.getSuffix()) ;
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix PropertyCallExpression
	 */
	public static final Expression synthesizePropertyAccessExpression(Expression target,
			org.eclipse.papyrus.alf.alf.PropertyCallExpression suffix) {
		PropertyAccessExpression synthesized = new PropertyAccessExpression() ;
		/*1. Synthesize property featureReference */
		FeatureReference featureReference = new FeatureReference() ;
		featureReference.expression = target ;
		// LIMITATION: in this version of the Alf parser, no binding can be specified in a property access expression
		NameBinding nameBinding = new NameBinding() ;
		nameBinding.name = suffix.getPropertyName() ;
		featureReference.nameBinding = nameBinding ;
		synthesized.featureReference = featureReference ;
		
		Expression resultingExpression = synthesized ;
		
		// in the case where an index is specified, needs to synthesize a SequenceAccessExpression
		if (suffix.getIndex() != null) {
			SequenceAccessExpression synthesizedAccessExpression = new SequenceAccessExpression() ;
			synthesizedAccessExpression.primary = synthesized ;
			synthesizedAccessExpression.index =
					ASTExpressionFactory.synthesizeExpression(suffix.getIndex()) ;
			resultingExpression = synthesizedAccessExpression ;
		}
		
		if (suffix.getSuffix() != null)
			return ASTExpressionFactory.synthesizeExpression(resultingExpression, suffix.getSuffix()) ;
		
		return resultingExpression ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix LinkCallExpression
	 */
	public static final Expression synthesizeLinkOperationExpression(
			Expression target, org.eclipse.papyrus.alf.alf.LinkOperationExpression suffix) {
		LinkOperationExpression synthesized = new LinkOperationExpression() ;
		
		/*1. Synthesize property tuple:Tuple */
		synthesized.tuple = ASTExpressionFactory.synthesizeNamedTupleFromLinkOperationExpression(suffix.getTuple(), synthesized) ;
		
		/*2. Synthesize property associationName:QualifiedName */
		synthesized.associationName = ASTExpressionFactory.synthesizeQualifiedName(target) ;

		/*3. Synthesize property operation:String */
		switch (suffix.getKind()) {
		case CLEAR:
			synthesized.operation = "clearAssoc" ;
			break;
		case CREATE:
			synthesized.operation = "createLink" ;
			break;
		case DESTROY:
			synthesized.operation = "destroyLink" ;
			break;
		}
		
		return synthesized ;
	}
	
	/**
	 * Build a alf.syntax.expressions.SequenceConstructionExpression from a SequenceConstructionExpression
	 * @param parsed
	 * @return The SequenceConstructionExpression
	 */
	public static final Expression synthesizeSequenceConstructionExpression(
			org.eclipse.papyrus.alf.alf.SequenceConstructionExpression parsed){
		SequenceConstructionExpression synthesized = null;
		if(parsed != null){
			synthesized = new SequenceConstructionExpression();
			if(parsed.getSequenceElement()!=null){
				/*0. Determine if we want to generate a SequenceExpressionList or a SequenceRange*/
				if(parsed.getRangeUpper() != null){
					SequenceRange seqRange = new SequenceRange();
					seqRange.rangeUpper = ASTExpressionFactory.synthesizeExpression(parsed.getRangeUpper());
					NaturalLiteralExpression literalExp = new NaturalLiteralExpression();
					literalExp.image = "0";
					seqRange.rangeLower = literalExp;
				}else{	
					synthesized.elements = ASTExpressionFactory.synthesizeSequenceExpressionList(
							parsed.getSequenceElement());
				}
			}
		}
		return synthesized;
	}

	/**
	 * Build an alf.syntax.expressions.SequenceExpressionList from a list of SequenceElement
	 * @param seqElts
	 * @return The SequenceExpressionList
	 */
	public static final SequenceElements synthesizeSequenceExpressionList(
			EList<org.eclipse.papyrus.alf.alf.SequenceElement> seqElts){
		SequenceExpressionList synthesized = null;
		if(seqElts!=null){
			synthesized = new SequenceExpressionList();
			synthesized.element = new ArrayList<Expression>();
			for(org.eclipse.papyrus.alf.alf.SequenceElement seqElt : seqElts){		
				/*1.1 If it is not an Expression it is a SequenceConstructionExpression*/
				if(seqElt instanceof org.eclipse.papyrus.alf.alf.impl.SequenceConstructionExpressionImpl){
					synthesized.element.add(ASTExpressionFactory.synthesizeSequenceConstructionExpression(
							(org.eclipse.papyrus.alf.alf.SequenceConstructionExpression)seqElt));
				}else{
					synthesized.element.add(ASTExpressionFactory.synthesizeExpression(
							(org.eclipse.papyrus.alf.alf.ConditionalTestExpression)seqElt));
				}
			}
			//TODO : upper and lower must be computed
		}
		return synthesized;
	}

	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix SequenceOperationExpression
	 */
	public static final Expression synthesizeSequenceOperationExpression(
			Expression target, org.eclipse.papyrus.alf.alf.SequenceOperationExpression suffix) {
		SequenceOperationExpression synthesized = new SequenceOperationExpression() ;
		
		/*1. Synthesize property tuple:Tuple */
		synthesized.tuple = ASTExpressionFactory.synthesizeTuple(suffix.getTuple(), synthesized) ;
		
		/*2. Synthesize property associationName:QualifiedName */
		synthesized.operation = ASTExpressionFactory.synthesizeQualifiedName(target) ;

		if (suffix.getSuffix() != null) {
			return ASTExpressionFactory.synthesizeExpression(synthesized, suffix.getSuffix()) ;
		}
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix SequenceReductionExpression
	 */
	public static final Expression synthesizeSequenceReductionExpression(
			Expression target, org.eclipse.papyrus.alf.alf.SequenceReductionExpression suffix) {
		SequenceReductionExpression synthesized = new SequenceReductionExpression() ;
		
		/*1. Synthesize property behaviorName:QualifiedName */
		synthesized.behaviorName = ASTExpressionFactory.synthesizeQualifiedName(suffix.getBehavior()) ;
		
		/*2. Synthesize property isOrdered:boolean */
		synthesized.isOrdered = suffix.isIsOrdered() ;
		
		/*3. Synthesize property primary:ExtentOrExpression */
		synthesized.primary = ASTExpressionFactory.synthesizeExtentOrExpression(target) ;

		if (suffix.getSuffix() != null) {
			return ASTExpressionFactory.synthesizeExpression(synthesized, suffix.getSuffix()) ;
		}
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix SequenceExpansionExpression
	 */
	public static final Expression synthesizeSequenceExpansionExpression(
			Expression target, org.eclipse.papyrus.alf.alf.SequenceExpansionExpression suffix) {
		if (suffix instanceof org.eclipse.papyrus.alf.alf.SelectOrRejectOperation) {
			return ASTExpressionFactory.synthesizeSelectOrRejectExpression(target, 
									(org.eclipse.papyrus.alf.alf.SelectOrRejectOperation)suffix) ;
		}
		else if (suffix instanceof org.eclipse.papyrus.alf.alf.ForAllOrExistsOrOneOperation) {
			return ASTExpressionFactory.synthesizeForAllOrExistsOrOneExpression(target, 
					(org.eclipse.papyrus.alf.alf.ForAllOrExistsOrOneOperation)suffix) ;
		}
		else if (suffix instanceof org.eclipse.papyrus.alf.alf.CollectOrIterateOperation) {
			return ASTExpressionFactory.synthesizeCollectOrIterateExpression(target, 
					(org.eclipse.papyrus.alf.alf.CollectOrIterateOperation)suffix) ;
		}
		else { // instanceof org.eclipse.papyrus.alf.alf.IsUniqueOperation
			return ASTExpressionFactory.synthesizeIsUniqueExpression(target, 
					(org.eclipse.papyrus.alf.alf.IsUniqueOperation)suffix) ;
		}		
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix SelectOrRejectExpression
	 */
	public static final Expression synthesizeSelectOrRejectExpression(Expression target,
			SelectOrRejectOperation suffix) {
		SelectOrRejectExpression synthesized = new SelectOrRejectExpression() ;
		
		/*1. Synthesize property argument:Expression */
		synthesized.argument = ASTExpressionFactory.synthesizeExpression(suffix.getExpr());
		
		/*2. Synthesize property operation:String */
		switch (suffix.getOp()) {
		case SELECT:
			synthesized.operation = "select" ;
			break;
		case REJECT:
			synthesized.operation = "reject" ;
			break;
		default:
			break;
		}
		
		/*3. Synthesize property variable:String */
		synthesized.variable = suffix.getName() ;
		
		/*4. Synthesize property primary:ExtentOrExpression */
		synthesized.primary = ASTExpressionFactory.synthesizeExtentOrExpression(target) ;
		
		if (suffix.getSuffix() != null) {
			return ASTExpressionFactory.synthesizeExpression(synthesized, suffix.getSuffix()) ;
		}
		return synthesized;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix ForAllOrExistsOrOneExpression
	 */
	public static final Expression synthesizeForAllOrExistsOrOneExpression(
			Expression target, ForAllOrExistsOrOneOperation suffix) {
		ForAllOrExistsOrOneExpression synthesized = new ForAllOrExistsOrOneExpression() ;
		
		/*1. Synthesize property argument:Expression */
		synthesized.argument = ASTExpressionFactory.synthesizeExpression(suffix.getExpr());
		
		/*2. Synthesize property operation:String */
		switch (suffix.getOp()) {
		case EXISTS:
			synthesized.operation = "exists" ;
			break;
		case FORALL:
			synthesized.operation = "forAll" ;
			break;
		case ONE:
			synthesized.operation = "one" ;
			break;
		default:
			break;
		}
		
		/*3. Synthesize property variable:String */
		synthesized.variable = suffix.getName() ;
		
		/*4. Synthesize property primary:ExtentOrExpression */
		synthesized.primary = ASTExpressionFactory.synthesizeExtentOrExpression(target) ;
		
		if (suffix.getSuffix() != null) {
			return ASTExpressionFactory.synthesizeExpression(synthesized, suffix.getSuffix()) ;
		}
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix ForAllOrExistsOrOneExpression
	 */
	public static final Expression synthesizeCollectOrIterateExpression(Expression target,
			CollectOrIterateOperation suffix) {
		ForAllOrExistsOrOneExpression synthesized = new ForAllOrExistsOrOneExpression() ;
		
		/*1. Synthesize property argument:Expression */
		synthesized.argument = ASTExpressionFactory.synthesizeExpression(suffix.getExpr());
		
		/*2. Synthesize property operation:String */
		switch (suffix.getOp()) {
		case COLLECT:
			synthesized.operation = "collect" ;
			break;
		case ITERATE:
			synthesized.operation = "iterate" ;
			break;
		default:
			break;
		}
		
		/*3. Synthesize property variable:String */
		synthesized.variable = suffix.getName() ;
		
		/*4. Synthesize property primary:ExtentOrExpression */
		synthesized.primary = ASTExpressionFactory.synthesizeExtentOrExpression(target) ;
		
		if (suffix.getSuffix() != null) {
			return ASTExpressionFactory.synthesizeExpression(synthesized, suffix.getSuffix()) ;
		}
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix IsUniqueExpression
	 */
	public static final Expression synthesizeIsUniqueExpression(Expression target,
			IsUniqueOperation suffix) {
		IsUniqueExpression synthesized = new IsUniqueExpression() ;
		
		/*1. Synthesize property argument:Expression */
		synthesized.argument = ASTExpressionFactory.synthesizeExpression(suffix.getExpr());
		
		/*2. Synthesize property variable:String */
		synthesized.variable = suffix.getName() ;
		
		/*3. Synthesize property primary:ExtentOrExpression */
		synthesized.primary = ASTExpressionFactory.synthesizeExtentOrExpression(target) ;
		
		if (suffix.getSuffix() != null) {
			return ASTExpressionFactory.synthesizeExpression(synthesized, suffix.getSuffix()) ;
		}
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix ClassExtentExpression
	 */
	public static final Expression synthesizeClassExtentExpression(Expression target,
			org.eclipse.papyrus.alf.alf.ClassExtentExpression suffix) {
		ClassExtentExpression synthesized = new ClassExtentExpression() ;
		
		/*1. Synthesize property className:QualifiedName */
		synthesized.className = ASTExpressionFactory.synthesizeQualifiedName(target) ;
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.ExtentOrExpression 
	 * from a alf.syntax.expressions.Expression
	 */
	public static final ExtentOrExpression synthesizeExtentOrExpression(
			Expression target) {
		ExtentOrExpression synthesized = new ExtentOrExpression() ;
		
		/* 1. Case where it is an Extent: Tries to synthesize property name:QualifiedName */
		QualifiedName tryQualifiedName = ASTExpressionFactory.synthesizeQualifiedName(target) ;
		if (tryQualifiedName.nameBinding != null &&
			!tryQualifiedName.nameBinding.isEmpty()) {
			synthesized.name = tryQualifiedName ;
		}
		else { // this is not an extent expression.
			/* 2. Synthesize property nonNameExpression:Expression */
			synthesized.nonNameExpression = target ;
		}
		
		return synthesized ;
	}
}

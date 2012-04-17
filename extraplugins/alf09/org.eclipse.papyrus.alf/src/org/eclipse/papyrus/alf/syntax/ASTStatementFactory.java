package org.eclipse.papyrus.alf.syntax;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.alf.syntax.expressions.QualifiedName;
import org.eclipse.papyrus.alf.syntax.statements.AcceptBlock;
import org.eclipse.papyrus.alf.syntax.statements.AcceptStatement;
import org.eclipse.papyrus.alf.syntax.statements.Block;
import org.eclipse.papyrus.alf.syntax.statements.ConcurrentClauses;
import org.eclipse.papyrus.alf.syntax.statements.IfStatement;
import org.eclipse.papyrus.alf.syntax.statements.LocalNameDeclarationStatement;
import org.eclipse.papyrus.alf.syntax.statements.NonFinalClause;
import org.eclipse.papyrus.alf.syntax.statements.QualifiedNameList;
import org.eclipse.papyrus.alf.syntax.statements.Statement;
import org.eclipse.papyrus.alf.syntax.statements.WhileStatement;

public class ASTStatementFactory {

	/**
	 * Build an alf.syntax.statements.Block from Block 
	 * @param parsed
	 * @return alf.syntax.statements.Block
	 */
	public static final Block synthesizeBlock(org.eclipse.papyrus.alf.alf.Block parsed){
		Block synthesized = null;
		if(parsed!=null){
			synthesized = new Block();
			/*1. Retrieve all statements*/
			synthesized.statement = new ArrayList<Statement>();
			if(parsed.getSequence()!=null){
				org.eclipse.papyrus.alf.alf.StatementSequence seq = parsed.getSequence();
				if(seq.getStatements() != null){
					for(org.eclipse.papyrus.alf.alf.DocumentedStatement dst :seq.getStatements()){
						synthesized.statement.add(
								ASTStatementFactory.synthesizeStatement(dst));
					}
				}
			}
			//TODO AssignmentBefore and AssignmentAfter
		}
		return synthesized;
	}
	
	/**
	 * Build an alf.syntax.statements.Statement from DocumentedStatement
	 * @param stmt
	 * @return
	 */
	public static final Statement synthesizeStatement(
			org.eclipse.papyrus.alf.alf.DocumentedStatement docstmt){
			org.eclipse.papyrus.alf.alf.Statement stmt = docstmt.getStatement();
			Statement synthesized = null;
			if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.AnnotatedStatementImpl){
				
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.BlockStatementImpl){
				
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.EmptyStatementImpl){
				
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.LocalNameDeclarationStatementImpl){
				synthesized = ASTStatementFactory.synthesizeLocalNameDeclarationStatement(
						(org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement)stmt);
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.IfStatementImpl){
				
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.SwitchStatementImpl){
				
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.WhileStatementImpl){
				synthesized = ASTStatementFactory.synthesizeWhileStatement(
						(org.eclipse.papyrus.alf.alf.WhileStatement)stmt);
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.DoStatementImpl){
				
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.ForStatementImpl){
				
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.BreakStatementImpl){
				
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.ReturnStatementImpl){

			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.AcceptStatementImpl){
				synthesized = ASTStatementFactory.synthesizeAcceptStatement(
						(org.eclipse.papyrus.alf.alf.AcceptStatement)stmt);
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.ClassifyStatementImpl){
				
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.InvocationOrAssignementOrDeclarationStatementImpl){
				
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.SuperInvocationStatementImpl){
				
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.ThisInvocationStatementImpl){
				
			}
			else if(stmt instanceof org.eclipse.papyrus.alf.alf.impl.InstanceCreationInvocationStatementImpl){
				
			}
		return synthesized;
	}
	
	/**
	 * Build an alf.syntax.statements.AcceptStatement from an AcceptStatement
	 * @param accept
	 * @return The AcceptStatement
	 */
	public static final AcceptStatement synthesizeAcceptStatement(org.eclipse.papyrus.alf.alf.AcceptStatement parsed){
		AcceptStatement synthesized = null;
		if(parsed != null){
			synthesized = new AcceptStatement();
			synthesized.acceptBlock = new ArrayList<AcceptBlock>();
			/*1. Determine whether the accept is simple or compound*/
			if(parsed.getCompoundAccept() != null){
				synthesized.isSimple = false;
				org.eclipse.papyrus.alf.alf.CompoundAcceptStatementCompletion accept = parsed.getCompoundAccept();
				/*1.1 Retrieve the block of the top AcceptStatement*/
				AcceptBlock tmpAcceptBlock = ASTStatementFactory.synthesizeAcceptBlock(parsed.getClause());
				tmpAcceptBlock.block = ASTStatementFactory.synthesizeBlock(accept.getBlock());
				synthesized.acceptBlock.add(tmpAcceptBlock);
				/*1.2 Retrieve the list of AcceptBlock of the CompoundStatement*/
				for(org.eclipse.papyrus.alf.alf.AcceptBlock block: accept.getAcceptBlock()){
					synthesized.acceptBlock.add(ASTStatementFactory.synthesizeAcceptBlock(block));
				}
			}else{
				synthesized.isSimple = true;
				synthesized.acceptBlock.add(ASTStatementFactory.synthesizeAcceptBlock(parsed.getClause()));
			}
			/*3. Determine which behavior contains this AcceptStatement*/
			//TODO Assign the ElementReference to the behavior attribute
			
			/*4. Determine the context behavior*/
			//TODO Assign the behavior attribute to the context behavior evaluation provided by AlfJavaValidator
		}
		return synthesized;
	}
	
	/**
	 * Build an alf.syntax.statements.AcceptBlock from an AcceptClause
	 * @param parsed
	 * @return The AcceptBlock
	 */
	public static final AcceptBlock synthesizeAcceptBlock(org.eclipse.papyrus.alf.alf.AcceptClause parsed){
		AcceptBlock synthesized = null;
		if(parsed != null){
			synthesized = new AcceptBlock();
			/*1. Local name which holds the signal instance*/
			synthesized.name = parsed.getName();
			/*2. Retrieve the list of signal accepted by this AcceptBlock*/
			if(parsed.getQualifiedNameList() != null){
				synthesized.signalNames = new QualifiedNameList();
				synthesized.signalNames.name = new ArrayList<QualifiedName>();
				for(org.eclipse.papyrus.alf.alf.QualifiedNameWithBinding sigName : 
						parsed.getQualifiedNameList().getQualifiedName()){
					synthesized.signalNames.name.add(
							ASTExpressionFactory.synthesizeQualifiedName(sigName));
				}
			}
			/*3 Set up the element reference on the signal*/
			//TODO Assign the ElementReference to the signal attribute
		}
		return synthesized;
	}
	
	/**
	 * Build an alf.syntax.statements.AcceptBlock from an AcceptBlock
	 * @param parsed
	 * @return The AcceptBlock
	 */
	public static final AcceptBlock synthesizeAcceptBlock(org.eclipse.papyrus.alf.alf.AcceptBlock parsed){
		AcceptBlock synthesized = null;
		if(parsed!=null){
			synthesized = ASTStatementFactory.synthesizeAcceptBlock(parsed.getClause());
			synthesized.block = ASTStatementFactory.synthesizeBlock(parsed.getBlock());
		}
		return synthesized;
	}
	
	/**
	 * Build an alf.syntax.statements.LocalNameDeclarationStatement from an LocalNameDeclarationStatement
	 * @param parsed
	 * @return The LocalNameDeclarationStatement
	 */
	public static final LocalNameDeclarationStatement synthesizeLocalNameDeclarationStatement(org.eclipse.papyrus.alf.alf.LocalNameDeclarationStatement parsed){
		LocalNameDeclarationStatement synthesized = null;
		if(parsed!=null){
			synthesized = new LocalNameDeclarationStatement();
			/*1. Determine if the multiplicity is specified*/
			synthesized.hasMultiplicity = parsed.isMultiplicityIndicator();
			/*2. Determine the name of the local name being declared*/
			synthesized.name = parsed.getVarName();
			/*3. Determine the type of the local name being declared*/
			synthesized.typeName = ASTExpressionFactory.synthesizeQualifiedName(parsed.getType());
			/*4 Build the expression to evaluated in order to provide the initial value*/
			if(parsed.getInit() != null){
				/*If it is not an Expression it is a SequenceConstructionExpression*/
				if(parsed.getInit() instanceof 
						org.eclipse.papyrus.alf.alf.impl.SequenceConstructionExpressionImpl){
					synthesized.expression = ASTExpressionFactory.synthesizeSequenceConstructionExpression(
							(org.eclipse.papyrus.alf.alf.SequenceConstructionExpression)parsed.getInit());
				}else{
					synthesized.expression = ASTExpressionFactory.synthesizeExpression(
							(org.eclipse.papyrus.alf.alf.ConditionalTestExpression)parsed.getInit());
				}
			}
			/*5. type attribute should be assigned to an ElementReference referencing the type*/
			if(synthesized.expression.type != null){
				synthesized.type = synthesized.expression.type;
			} 
		}
		return synthesized;
	}
	
	/**
	 * Build an alf.syntax.statements.WhileStatement from an WhileStatement
	 * @param parsed
	 * @return The WhileStatement
	 */
	public static final WhileStatement synthesizeWhileStatement(org.eclipse.papyrus.alf.alf.WhileStatement parsed){
		WhileStatement synthesized = null;
		if(parsed!=null){
			/*Condition and Block shall be valid*/
			if(parsed.getCondition() != null && parsed.getBlock() != null){
				synthesized = new WhileStatement();
				synthesized.condition = ASTExpressionFactory.synthesizeExpression(parsed.getCondition());
				synthesized.body = ASTStatementFactory.synthesizeBlock(parsed.getBlock()); 
			}
		}
		return synthesized;
	}
	
	/**
	 * Build an alf.syntax.statements.IfStatement from an IfStatement
	 * @param parsed
	 * @return The IfStatement
	 */
	public static final IfStatement synthesizeIfStatement(org.eclipse.papyrus.alf.alf.IfStatement parsed){
		IfStatement synthesized = null;
		if(parsed!=null){
			synthesized = new IfStatement();
			synthesized.finalClause = ASTStatementFactory.synthesizeBlock(parsed.getFinalClause());
			synthesized.nonFinalClauses = ASTStatementFactory.
					synthesizeConcurrentClausesList(parsed.getSequentialClausses());
		}
		return synthesized;
	}
	
	/**
	 * Build an alf.syntax.statements.Block from a FinalClause
	 * @param parsed
	 * @return The Block
	 */
	public static final Block synthesizeBlock(org.eclipse.papyrus.alf.alf.FinalClause parsed){
		Block synthesized = null;
		if(parsed!=null && parsed.getBlock()!=null){
			synthesized = ASTStatementFactory.synthesizeBlock(parsed.getBlock());
		}
		return synthesized;
	}
	
	/**
	 * Build an alf.syntax.statements.NonFinalClause from a NonFinalClause
	 * @param parsed
	 * @return
	 */
	public static final NonFinalClause synthesizeNonFinalClause(org.eclipse.papyrus.alf.alf.NonFinalClause parsed){
		NonFinalClause synthesized = null;
		if(parsed != null && (parsed.getBlock() != null && parsed.getCondition() != null)){
			synthesized = new NonFinalClause();
			synthesized.condition = ASTExpressionFactory.synthesizeExpression(parsed.getCondition());
			synthesized.body = ASTStatementFactory.synthesizeBlock(parsed.getBlock());
		}
		return synthesized;
	}
	
	/**
	 * Build an alf.syntax.statements.ConcurrentClauses from a ConcurrentClauses
	 * @param parsed
	 * @return The ConcurrentClauses
	 */
	public static final ConcurrentClauses synthesizeConcurrentClauses(org.eclipse.papyrus.alf.alf.ConcurrentClauses parsed){
		ConcurrentClauses synthesized = null;
		if(parsed!=null && parsed.getNonFinalClause().size() >= 1){
			synthesized = new ConcurrentClauses();
			synthesized.clause = new ArrayList<NonFinalClause>();
			for(org.eclipse.papyrus.alf.alf.NonFinalClause nonFinalClause :parsed.getNonFinalClause()){
				NonFinalClause clause = ASTStatementFactory.synthesizeNonFinalClause(nonFinalClause);
				if(clause!=null){
					synthesized.clause.add(clause);
				}
			}
		}
		return synthesized;
	}
	
	public static final List<ConcurrentClauses> synthesizeConcurrentClausesList(org.eclipse.papyrus.alf.alf.SequentialClauses parsed){
		List<ConcurrentClauses> synthesized = null;
		if(parsed!=null && parsed.getConccurentClauses().size()>=1){
			synthesized = new ArrayList<ConcurrentClauses>();
			for(org.eclipse.papyrus.alf.alf.ConcurrentClauses concClause: parsed.getConccurentClauses()){
				 ConcurrentClauses clause = ASTStatementFactory.synthesizeConcurrentClauses(concClause);
				 if(clause!=null){
					 synthesized.add(clause); 
				 }
			}
		}
		return synthesized;
	}
}

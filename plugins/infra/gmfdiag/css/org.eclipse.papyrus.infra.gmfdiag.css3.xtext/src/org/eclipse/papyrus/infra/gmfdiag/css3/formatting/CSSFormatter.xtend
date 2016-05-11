/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial Implementation
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 473188
 * 
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css3.formatting

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig
import org.eclipse.papyrus.infra.gmfdiag.css3.services.CSSGrammarAccess

 import com.google.inject.Inject;

/**
 * This class contains custom formatting declarations.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#formatting
 * on how and when to use it.
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
class CSSFormatter extends AbstractDeclarativeFormatter {

	@Inject extension CSSGrammarAccess
	
	/**
	 * The space character.
	 */
	private static final String SPACE = " "; //$NON-NLS-1$
	
	override protected void configureFormatting(FormattingConfig c) {
		// Semantic formatting (Prevent XText from adding invalid spaces)
		c.setNoSpace().around(WSRule);
		
		// Manage all the curly bracket
		for(curlyBracketPair : findKeywordPairs("{", "}")){ //$NON-NLS-1$ $NON-NLS-2$
			c.setSpace(SPACE).before(curlyBracketPair.first);
			c.setIndentationIncrement().after(curlyBracketPair.first);
			c.setLinewrap().after(curlyBracketPair.first);
			c.setIndentationDecrement().before(curlyBracketPair.second);
			c.setLinewrap().after(curlyBracketPair.second);
		}
		
		// Manage all the square bracket
		for(squareBracketPair : findKeywordPairs("[", "]")){ //$NON-NLS-1$ $NON-NLS-2$
			c.setNoSpace().after(squareBracketPair.first);
			c.setNoSpace().before(squareBracketPair.second);
		}
		
		// Manage all the simple bracket
		for(bracketPair : findKeywordPairs("(", ")")){ //$NON-NLS-1$ $NON-NLS-2$
			c.setNoSpace().after(bracketPair.first);
			c.setNoSpace().before(bracketPair.second);
		}
		
		// Manage the semi colon
		for(semicolon : findKeywords(";")){ //$NON-NLS-1$
			c.setNoSpace().before(semicolon);
			c.setLinewrap().after(semicolon);
		}
		
		// Manage the dot
		for(dot : findKeywords(".")){ //$NON-NLS-1$
			c.setNoSpace().around(dot);
		}
		
		// Manage the percent
		for(percent : findKeywords("%")){ //$NON-NLS-1$
			c.setNoSpace().before(percent);
		}
		
		// Manage the superior
		for(superior : findKeywords(">")){ //$NON-NLS-1$
			c.setSpace(SPACE).around(superior);
			c.setNoLinewrap().around(superior);
		}
		
		// Lexical Comments
	    c.setLinewrap(0, 1, 2).before(ML_COMMENTRule);
	    c.setLinewrap(0, 1, 1).after(ML_COMMENTRule);
		
		// The root document structure
		c.setLinewrap(2).after(stylesheetAccess.charsetAssignment_0);
		c.setLinewrap(2).after(stylesheetAccess.importsImportExpressionParserRuleCall_1_0);
		c.setLinewrap(2).after(rulesetRule);
		c.setLinewrap(2).after(mediaRule);
		c.setLinewrap(2).after(pageRule);
		c.setLinewrap(2).after(font_faceRule);
		c.setLinewrap(2).after(keyframesRule);

		// Charset format
		c.setSpace(SPACE).after(charsetAccess.charsetKeyword_0_0);
		c.setSpace(SPACE).after(charsetAccess.CHARSETKeyword_0_1);
		
		// Import expression format
		c.setSpace(SPACE).after(importExpressionAccess.importKeyword_0_0);
		c.setSpace(SPACE).after(importExpressionAccess.IMPORTKeyword_0_1);
		
		// Page format
		c.setSpace(SPACE).after(pageAccess.pageKeyword_1_0);
		c.setSpace(SPACE).after(pageAccess.PAGEKeyword_1_1);
		c.setNoSpace().around(pseudo_pageAccess.COLONTerminalRuleCall_0);
		
		// Media format
		c.setSpace(SPACE).after(mediaAccess.mediaKeyword_0_0);
		c.setSpace(SPACE).after(mediaAccess.MEDIAKeyword_0_1);
		c.setNoSpace().before(media_listAccess.COMMATerminalRuleCall_1_0);
		c.setSpace(SPACE).after(media_listAccess.COMMATerminalRuleCall_1_0);
		
		// Font face format
		c.setSpace(SPACE).after(font_faceAccess.fontFaceKeyword_1_0);
		c.setSpace(SPACE).after(font_faceAccess.FONTFACEKeyword_1_1);
		
		// Key frames format
		c.setSpace(SPACE).after(keyframesAccess.keyframesKeyword_1_0);
		c.setSpace(SPACE).after(keyframesAccess.KEYFRAMESKeyword_1_1);
		
		// Rule set
		c.setNoSpace().before(rulesetAccess.COMMATerminalRuleCall_1_1);
		c.setLinewrap().after(rulesetAccess.COMMATerminalRuleCall_1_1);

		// No spaces between unary operator and number
		c.setNoSpace().after(PLUSRule);
		c.setNoSpace().after(DASHRule);
		c.setNoSpace().before(ONE_INTRule);
		c.setNoSpace().before(ONE_HEX_LETTERRule);
		c.setNoSpace().around(INCLUDESRule);
		c.setNoSpace().around(DASHMATCHRule);
		c.setNoSpace().around(operatorRule);
		
		// No spaces before simpleSelector condition
		c.setNoSpace().around(pseudoClassAccess.COLONTerminalRuleCall_0);
		c.setNoSpace().around(pseudoClassAccess.COLONTerminalRuleCall_1);
		c.setNoSpace().around(pseudoClassFunctionAccess.COLONTerminalRuleCall_1_0);
		c.setNoSpace().after(pseudoClassFunctionAccess.nameAssignment_1_1);

		// Declarations
		c.setNoSpace().before(css_declarationAccess.COLONTerminalRuleCall_3);
		c.setSpace(SPACE).after(css_declarationAccess.COLONTerminalRuleCall_3)
		
		// Attribute
		c.setNoSpace().around(attributeSelectorAccess.opAssignment_3_0);
		
		// The not function format
		c.setNoSpace().after(notFunctionCallAccess.notKeyword_1);
		
		// Manage the specific implementations
		c.setNoSpace().around(symbolTokAccess.symbolAssignment_1);
		c.setNoSpace().around(validURLRule);
	}
}

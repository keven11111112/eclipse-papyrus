/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.message.xtext.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class UmlMessageAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/eclipse/papyrus/uml/textedit/message/xtext/parser/antlr/internal/InternalUmlMessage.tokens");
	}
}

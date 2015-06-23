package org.eclipse.papyrus.texteditor.cdt;

import java.util.regex.Pattern;

public class TextEditorConstants {

	/**
	 * Regular expression for accepted language for compatible CDT code generators
	 */
	public static final Pattern CPP = Pattern.compile("C\\+\\+|c\\+\\+|CPP|cpp|C|c"); //$NON-NLS-1$

}

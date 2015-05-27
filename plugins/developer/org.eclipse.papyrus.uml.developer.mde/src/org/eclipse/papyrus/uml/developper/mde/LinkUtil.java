/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.developper.mde;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.papyrus.infra.emf.utils.EMFFunctions;
import org.eclipse.papyrus.uml.developper.mde.handler.IDMAbstractHandler;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

/**
 * An utility for generating and parsing simple textual hyperlinks.
 */
public class LinkUtil {
	private static final Pattern HYPERLINK_PATTERN = Pattern.compile("\\$\\{link:([^\\|]+)\\|([^\\|]*)\\|([^\\}]*)\\}");

	private final Function<? super NamedElement, String> titleFunction;
	private final Function<? super NamedElement, String> nameFunction = EMFFunctions.getFeature(UMLPackage.Literals.NAMED_ELEMENT__NAME, String.class);
	private final Function<NamedElement, String> hyperlinkFunction = new Function<NamedElement, String>() {

		@Override
		public String apply(NamedElement input) {
			return createHyperlink(input, titleFunction.apply(input), nameFunction.apply(input));
		}
	};

	/**
	 * Initializes me with the function that I use to obtain titles for links to model elements.
	 * 
	 * @param titleFunction
	 *            my element title function
	 */
	public LinkUtil(Function<? super NamedElement, String> titleFunction) {
		super();

		this.titleFunction = titleFunction;
	}

	public static String createHyperlink(NamedElement element, String title, String name) {
		return String.format("${link:%s|%s|%s}", element.eResource().getURIFragment(element), title, name);
	}

	public Function<? super NamedElement, String> getHyperlinkFunction() {
		return hyperlinkFunction;
	}

	public static List<Hyperlink> parseHyperlinks(CharSequence text, int start, int end) {
		ImmutableList.Builder<Hyperlink> result = ImmutableList.builder();

		for (Matcher m = HYPERLINK_PATTERN.matcher(text.subSequence(start, end)); m.find();) {
			result.add(new Hyperlink(m, start));
		}

		return result.build();
	}

	/**
	 * Transcodes a length of {@code text} with any potential encoded hyperlinks into a format suitable for the
	 * output of the generation pipeline.
	 * 
	 * @param text
	 *            a string of (comment) text from the documentation model
	 * @param start
	 *            the starting offset (inclusive) in the {@code text} to process
	 * @param end
	 *            the ending offset (exclusive) in the {@code text} to process
	 * @param transcoder
	 *            a function that generates the textual representation of an hyperlink in the output format
	 * 
	 * @return the transcoded text, or {@code null} if it had no embedded hyperlinks
	 */
	public static String transcodeHyperlinks(CharSequence text, int start, int end, Function<? super Hyperlink, String> transcoder) {
		String result = null;

		List<Hyperlink> hyperlinks = parseHyperlinks(text, start, end);
		if (!hyperlinks.isEmpty()) {
			StringBuilder buf = new StringBuilder(3 * text.length() / 2);
			int offset = start;

			for (Hyperlink next : hyperlinks) {
				// Up to the start of the hyperlink
				buf.append(text, offset, next.offset());

				// Output representation of the hyperlink
				buf.append(transcoder.apply(next));

				// Prepare for next
				offset = next.offset() + next.length();
			}

			// Remainder of the string
			buf.append(text, offset, end);

			result = buf.toString();
		}

		return result;
	}

	//
	// Nested types
	//

	public static final class Hyperlink {
		private final int offset;
		private final int length;
		private final String href;
		private final String title;
		private final String text;

		Hyperlink(MatchResult match, int offset) {
			super();

			this.offset = offset + match.start();
			this.length = match.end() - match.start();

			this.href = match.group(1);
			this.title = match.group(2);
			this.text = match.group(3);
		}

		public int offset() {
			return offset;
		}

		public int length() {
			return length;
		}

		public String href() {
			String result = IDMAbstractHandler.getDocHREF(href);
			return (result == null) ? href : result;
		}

		public String title() {
			return Strings.isNullOrEmpty(title) ? text : title;
		}

		public String text() {
			return text;
		}
	}
}

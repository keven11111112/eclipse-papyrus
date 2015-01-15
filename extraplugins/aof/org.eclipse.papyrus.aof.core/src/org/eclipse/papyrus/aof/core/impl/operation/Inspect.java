/*******************************************************************************
 *  Copyright (c) 2015 ESEO.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.aof.core.impl.operation;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver;

public class Inspect<A> extends Operation<A> {

	private IBox<A> a;
	private String label;

	public IBox<A> getResult() {
		return a;
	}

	public Inspect(IBox<A> a, String label) {
		this.a = a;
		this.label = label;
		a.addObserver(new AObserver());
	}

	public boolean isOptional() {
		return a.isOptional();
	}

	public boolean isSingleton() {
		return a.isSingleton();
	}

	public boolean isOrdered() {
		return a.isOrdered();
	}

	public boolean isUnique() {
		return a.isUnique();
	}

	protected class AObserver extends DefaultObserver<A> {

		public void created(Iterable<A> elements) {
			System.out.println(label + a);
		}

		public void added(int index, A element) {
			System.out.println(label + a);
			System.out.println(tab(label, index) + "^ Add(" + index + ", " + element + ")");
		}

		public void removed(int index, A element) {
			System.out.println(label + a);
			System.out.println(tab(label, index) + "^ Remove(" + index + ", " + element + ")");
		}

		public void replaced(int index, A element) {
			System.out.println(label + a);
			System.out.println(tab(label, index) + "^ Replace(" + index + ", " + element + ")");
		}

		/**
		 * Builds a tab from the size of the whole inspect string. This tab
		 * enhances displaying operations on the observable 'a'
		 * @param label a string to display
		 * @param index the index of the element to tabulate
		 * @return a tab
		 */
		private String tab(String label, int index) {
			int length = label.length() + a.getType().toString().length() + "(".length();
			for (int i = 0; i < index; i++) {
				length += a.get(i).toString().length() + ", ".length();
			}
			String spaces = "";
			for (int i = 0; i < length; i++) {
				spaces += " ";
			}
			return spaces;
		}
	}

}

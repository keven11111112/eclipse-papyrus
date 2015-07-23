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

package org.eclipse.papyrus.tests.framework.m2m

import org.eclipse.emf.common.util.BasicEList
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * A custom list implementation that has an initial unset state that can be queried to determine whether
 * the list was ever modified.
 */
class DefaultingList<E> extends BasicEList<E> {
	@Accessors(PUBLIC_GETTER) boolean set
	
	static def <E> DefaultingList<E> newDefaultingList() {
		new DefaultingList<E>
	}
	
	static def dispatch isDefault(Iterable<?> collection) {
		false
	}
	
	static def dispatch isDefault(DefaultingList<?> collection) {
		!collection.isSet
	}
	
	/**
	 * Iterable alternation:  the result is {@code collection} if it is not {@link #isDefault()}, otherwise the value of
	 * the {@code defaultBlock}.
	 */
	def static <E> Iterable<? extends E> operator_or(Iterable<? extends E> collection, ()=>Iterable<? extends E> defaultBlock) {
		if (collection.isDefault) defaultBlock.apply else collection
	}
	
	/**
	 * Iterable alternation:  the result is {@code collection} if it is not {@link #isDefault()}, otherwise the value of
	 * the {@code defaultBlock}.
	 */
	def static <E> Iterable<? extends E> operator_or(Iterable<? extends E> collection, Iterable<? extends E> defaultValue) {
		if (collection.isDefault) defaultValue else collection
	}
	
	override protected didChange() {
		set = true
	}
}

/*******************************************************************************
 *  Copyright (c) 2015 Christian W. Damus and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Christian W. Damus - initial API and implementation
 *     
 *******************************************************************************/
package org.eclipse.papyrus.aof.emf.impl;

import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver;

class ListReverseNotificationAdapter<E> extends DefaultObserver<E> {

	private final ListFeatureDelegate<E> listFeatureDelegate;

	ListReverseNotificationAdapter(ListFeatureDelegate<E> listFeatureDelegate) {
		this.listFeatureDelegate = listFeatureDelegate;
	}

	@Override
	public void added(int index, E element) {
		if (this.listFeatureDelegate.silentReverse) {
			return;
		}
		this.listFeatureDelegate.silentForward = true;
		try {
			this.listFeatureDelegate.list.add(index, element);
		} finally {
			this.listFeatureDelegate.silentForward = false;
		}
	}

	@Override
	public void removed(int index, E element) {
		if (this.listFeatureDelegate.silentReverse) {
			return;
		}
		this.listFeatureDelegate.silentForward = true;
		try {
			this.listFeatureDelegate.list.remove(index);
		} finally {
			this.listFeatureDelegate.silentForward = false;
		}
	}

	@Override
	public void replaced(int index, E newElement, E oldElement) {
		if (this.listFeatureDelegate.silentReverse) {
			return;
		}
		this.listFeatureDelegate.silentForward = true;
		try {
			this.listFeatureDelegate.list.set(index, newElement);
		} finally {
			this.listFeatureDelegate.silentForward = false;
		}
	}

	@Override
	public void moved(int newIndex, int oldIndex, E element) {
		if (this.listFeatureDelegate.silentReverse) {
			return;
		}
		this.listFeatureDelegate.silentForward = true;
		try {
			this.listFeatureDelegate.list.move(newIndex, oldIndex);
		} finally {
			this.listFeatureDelegate.silentForward = false;
		}
	}
}
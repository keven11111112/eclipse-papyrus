package org.eclipse.papyrus.aof.emf.impl;

import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver;

public class ListReverseNotificationAdapter<E> extends DefaultObserver<E> {

	/**
	 * 
	 */
	private final ListFeatureDelegate<E> listFeatureDelegate;

	/**
	 * @param listFeatureDelegate
	 */
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
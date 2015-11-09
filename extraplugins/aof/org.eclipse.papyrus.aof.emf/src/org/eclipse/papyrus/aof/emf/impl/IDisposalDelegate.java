package org.eclipse.papyrus.aof.emf.impl;

/**
 * A call-back for processing additional actions on disposal of a
 * {@link FeatureDelegate}.
 */
public interface IDisposalDelegate {
	/**
	 * Notifies my that a feature delegate has been disposed.
	 */
	void onDisposed(FeatureDelegate<?> delegate);
}
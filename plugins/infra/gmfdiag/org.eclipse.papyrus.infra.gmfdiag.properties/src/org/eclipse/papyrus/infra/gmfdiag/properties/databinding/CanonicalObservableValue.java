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

package org.eclipse.papyrus.infra.gmfdiag.properties.databinding;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.canonical.editpolicy.CanonicalStateListener;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.SetCanonicalCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.gmfdiag.properties.modelelement.SynchronizationModelElement;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.tools.databinding.ReferenceCountedObservable;
import org.eclipse.papyrus.uml.tools.databinding.AggregatedPapyrusObservableValue;
import org.eclipse.papyrus.uml.tools.databinding.CommandBasedObservableValue;

/**
 * The observable boolean "canonical synchronization" state of an {@link EditPart}, as represented by
 * a {@link SynchronizationModelElement}.
 */
public class CanonicalObservableValue extends ReferenceCountedObservable.Value implements CommandBasedObservableValue, AggregatedObservable, IObserving {
	private TransactionalEditingDomain domain;
	private EditPart editPart;
	private boolean lastComputed;

	private CanonicalStateListener canonicalStateListener;
	private CanonicalStateListener.Handler refreshHandler;

	public CanonicalObservableValue(TransactionalEditingDomain domain, EditPart editPart) {
		super();

		this.domain = domain;
		this.editPart = editPart;

		final Runnable update = new Runnable() {
			public void run() {
				boolean oldValue = lastComputed; // doGetValue updates this
				fireValueChange(Diffs.createValueDiff(oldValue, doGetValue()));
			}
		};

		if (editPart instanceof IGraphicalEditPart) {
			IGraphicalEditPart graphical = (IGraphicalEditPart) editPart;
			canonicalStateListener = CanonicalStateListener.getInstance(graphical);

			refreshHandler = new CanonicalStateListener.Handler() {

				public Runnable handleAdd(CanonicalStyle style) {
					return update;
				}

				public Runnable handleRemove(CanonicalStyle style) {
					return update;
				}
			};
			canonicalStateListener.addCanonicalRefreshHandler(refreshHandler);
		}
	}

	@Override
	public synchronized void dispose() {
		try {
			if (canonicalStateListener != null) {
				canonicalStateListener.removeCanonicalRefreshHandler(refreshHandler);
				canonicalStateListener.release();
				canonicalStateListener = null;
			}
		} finally {
			super.dispose();
		}
	}

	public Object getObserved() {
		return editPart;
	}

	public Object getValueType() {
		return Boolean.class;
	}

	@Override
	protected Object doGetValue() {
		boolean result = DiagramEditPartsUtil.isCanonical(editPart);
		lastComputed = result;
		return result;
	}

	@Override
	protected void doSetValue(Object value) {
		Command command = getCommand(value);
		domain.getCommandStack().execute(command);
	}

	public Command getCommand(Object value) {
		boolean canonical = (value instanceof Boolean) && ((Boolean) value).booleanValue();

		return GMFtoEMFCommandWrapper.wrap(new SetCanonicalCommand(domain, NotationHelper.findView(editPart), canonical));
	}

	public AggregatedObservable aggregate(IObservable observable) {
		return new AggregatedPapyrusObservableValue(domain, this, observable);
	}

	public boolean hasDifferentValues() {
		return false; // Primitive component has only one value
	}
}

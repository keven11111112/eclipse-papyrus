/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.properties.modelelement;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IMultiPageEditorPart;
import org.eclipse.papyrus.infra.nattable.common.editor.NatTableEditor;
import org.eclipse.papyrus.infra.properties.contexts.DataContextElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.ui.util.EditorHelper;
import org.eclipse.ui.IEditorPart;

/**
 * The model factory to create {@link NatTableModelElement}s from the current nattable editor.
 * 
 * @since 2.1
 */
public class EObjectInNatTableFactory extends NatTableFactory {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElementFactory#doCreateFromSource(java.lang.Object, org.eclipse.papyrus.infra.properties.contexts.DataContextElement)
	 */
	@Override
	protected EMFModelElement doCreateFromSource(final Object sourceElement, final DataContextElement context) {
		EMFModelElement result = null;

		final NatTableEditor nattableEditor = getCurrentNatTableEditor();
		if (null != nattableEditor) {
			final EditingDomain domain = nattableEditor.getTableEditingDomain();
			result = new NatTableModelElement(nattableEditor.getTable(), domain);
		} else {
			result = super.doCreateFromSource(sourceElement, context);
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractEMFModelElementFactory#updateModelElement(org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement, java.lang.Object)
	 */
	@Override
	protected void updateModelElement(final EMFModelElement modelElement, final Object newSourceElement) {
		final NatTableEditor nattableEditor = getCurrentNatTableEditor();
		if (null != nattableEditor) {
			if (modelElement instanceof NatTableModelElement) {
				updateTableModelElement((NatTableModelElement) modelElement, nattableEditor.getTable());
			}
			updateEMFModelElement(modelElement, nattableEditor.getTable());
		} else {
			super.updateModelElement(modelElement, newSourceElement);
		}
	}

	/**
	 * This allows to get the current nattable editor when this is available.
	 * 
	 * @return The current nattable editor if available or <code>null</code>.
	 */
	protected NatTableEditor getCurrentNatTableEditor() {
		NatTableEditor result = null;

		final IEditorPart currentEditor = EditorHelper.getCurrentEditor();
		if (currentEditor instanceof IMultiPageEditorPart) {
			result = ((IMultiPageEditorPart) currentEditor).getActiveEditor().getAdapter(NatTableEditor.class);
		} else if (currentEditor instanceof IAdaptable) {
			result = ((IAdaptable) currentEditor).getAdapter(NatTableEditor.class);
		}

		return result;
	}
}

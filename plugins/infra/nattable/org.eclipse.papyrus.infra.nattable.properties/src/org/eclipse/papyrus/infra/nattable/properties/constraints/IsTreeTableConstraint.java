/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.infra.nattable.properties.constraints;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.TableHelper;

/**
 * The constraint which allow to determinate if this is a tree table.
 */
public class IsTreeTableConstraint extends AbstractConstraint {

	/**
	 * {@inheritDoc}
	 *
	 * The default implementation matches a selection iff the constraint matches
	 * each object of the selection.
	 */
	@Override
	public boolean match(final IStructuredSelection selection) {
		boolean result = false;
		
		if (!selection.isEmpty()) {
			final int elementMultiplicity = display.getElementMultiplicity();
	
			final int selectionSize = selection.size();
			if (elementMultiplicity == 1) {
				if (selectionSize == 1) {
					if (match(selection.getFirstElement())) {
						result = true;
					}
				}
				// Manage the multiple elements only if the selection is multiple too
			} else if ((elementMultiplicity == selectionSize) || (elementMultiplicity < 0 && selection.size() > 1)) {
				result = true;
				
				final Iterator<?> selectionIterator = selection.iterator();
				while (selectionIterator.hasNext() && result) {
					final Object selectedItem = selectionIterator.next();
					if (!match(selectedItem)) {
						result = false;
					}
				}
			}
		}

		return result;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint#match(java.lang.Object)
	 */
	@Override
	public boolean match(final Object selection) {
		final boolean expectedValue = Boolean.parseBoolean(getValue("expectedValue")); //$NON-NLS-1$
		final EObject table = EMFHelper.getEObject(selection);
		return table instanceof Table && expectedValue == TableHelper.isTreeTable((Table) table);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint#equivalent(org.eclipse.papyrus.infra.constraints.constraints.Constraint)
	 */
	@Override
	protected boolean equivalent(final Constraint constraint) {
		return constraint == this || constraint instanceof IsTreeTableConstraint;
	}

}

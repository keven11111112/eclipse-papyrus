/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.nattable.stereotype.display.utils;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayCommandExecution;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayUtil;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * @author Céline JANSSENS
 *
 */
public class StereotypeDisplayTreeTableHelper {

	private static final String EMPTY_STRING = ""; // $NON-NLS-1$

	private StereotypeDisplayUtil helper = StereotypeDisplayUtil.getInstance();
	/**
	 * singleton instance
	 */
	private static StereotypeDisplayTreeTableHelper labelHelper;


	/** Singleton contructor */
	private StereotypeDisplayTreeTableHelper() {
	}

	/**
	 * Returns the singleton instance of this class
	 *
	 * @return the singleton instance.
	 */
	public static StereotypeDisplayTreeTableHelper getInstance() {
		if (labelHelper == null) {
			labelHelper = new StereotypeDisplayTreeTableHelper();
		}
		return labelHelper;
	}


	public String getShortValue(Object name) {
		String shortName = EMPTY_STRING;
		if (name instanceof String) {
			shortName = ((String) name).substring(StereotypeDisplayTreeTableConstants.PREFIX.length(), ((String) name).length());

		}

		return shortName;
	}

	/**
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	public Object getBraceValue(Object rowElement) {

		Object row = AxisUtils.getRepresentedElement(rowElement);
		if (rowElement instanceof ITreeItemAxis) {


			// Depth 1
			if (row instanceof Node) {

				return null;
			}

			// Depth 2
			if (row instanceof Stereotype) {
				Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());
				if (parent instanceof View) {

					View brace = helper.getStereotypeBraceCompartment((View) parent, (Stereotype) row);
					return brace.isVisible();
				}

			}
		}


		return Boolean.FALSE;
	}

	/**
	 * @param domain
	 * @param rowElement
	 * @param newValue
	 */
	public void setBraceValue(TransactionalEditingDomain domain, Object rowElement, Object newValue) {
		Object row = AxisUtils.getRepresentedElement(rowElement);

		// Depth 2
		if (row instanceof Stereotype) {
			Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());
			if (parent instanceof View) {
				if (newValue instanceof Boolean) {
					View brace = helper.getStereotypeBraceCompartment((View) parent, (Stereotype) row);
					StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, brace, (Boolean) newValue);
				}
			}

		}

		// Depth 3
		if (row instanceof Property) {
			Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent().getParent().getParent());
			Object stereo = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent());

			if (parent instanceof View) {
				if (stereo instanceof Stereotype) {
					if (newValue instanceof Boolean) {
						View brace = helper.getStereotypePropertyInBrace((View) parent, (Stereotype) stereo, (Property) row);
						StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, brace, (Boolean) newValue);
					}
				}
			}

		}



	}
}

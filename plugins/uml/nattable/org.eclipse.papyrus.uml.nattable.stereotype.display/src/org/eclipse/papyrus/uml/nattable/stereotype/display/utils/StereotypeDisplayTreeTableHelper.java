/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
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

package org.eclipse.papyrus.uml.nattable.stereotype.display.utils;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayCommandExecution;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayUtil;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The helper for the stereotype display tree table.
 */
public class StereotypeDisplayTreeTableHelper {

	/**
	 * The empty string.
	 */
	private static final String EMPTY_STRING = ""; // $NON-NLS-1$

	
	/**
	 * The singleton instance.
	 */
	private StereotypeDisplayUtil helper = StereotypeDisplayUtil.getInstance();
	
	/**
	 * The stereotype display tree table helper.
	 */
	private static StereotypeDisplayTreeTableHelper labelHelper;


	/**
	 * Default Constructor.
	 */
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

	/**
	 * Get the short value (without prefix).
	 * 
	 * @param name The name.
	 * @return The short value.
	 */
	public String getShortValue(final Object name) {
		String shortName = EMPTY_STRING;
		if (name instanceof String) {
			shortName = ((String) name).substring(StereotypeDisplayTreeTableConstants.PREFIX.length(), ((String) name).length());
		}

		return shortName;
	}

	/**
	 * Get the depth value.
	 * 
	 * @param rowElement The row element.
	 * @return The delpth value.
	 */
	public Object getDepthValue(final Object rowElement) {
		Object row = AxisUtils.getRepresentedElement(rowElement);

		if (rowElement instanceof ITreeItemAxis) {
			// Depth 2
			if (row instanceof Stereotype) {
				Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());

				final View label = helper.getStereotypeLabel((View) parent, (Stereotype) row);
				if (label instanceof DecorationNode) {
					return helper.getDepth((DecorationNode) label);
				}
			}
		}
		return null;
	}

	/**
	 * Set the delpth value.
	 * 
	 * @param domain The transactional editing domain.
	 * @param rowElement The row element.
	 * @param newValue The value to set.
	 */
	public void setDepthValue(final TransactionalEditingDomain domain, final Object rowElement, final Object newValue) {
		Object row = AxisUtils.getRepresentedElement(rowElement);

		// Depth 2
		if (row instanceof Stereotype) {
			Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());
			if (parent instanceof View) {
				if (newValue instanceof String) {
					StereotypeDisplayCommandExecution.getInstance().setDepth(domain, (Stereotype) row, (View) parent, (String) newValue, true);
				}
			}
		}
	}

	/**
	 * Get the displayed value.
	 * 
	 * @param rowElement The row element.
	 * @return The displayed value.
	 */
	public Object getDisplayedValue(final Object rowElement) {
		Object row = AxisUtils.getRepresentedElement(rowElement);
		if (rowElement instanceof ITreeItemAxis) {

			// Depth 1
			if (row instanceof Node) {
				return ICellManager.EMPTY_STRING;
			}

			// Depth 2
			if (row instanceof Stereotype) {
				Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());

				View propertyLabel = helper.getStereotypeLabel((View) parent, (Stereotype) row);
				if (null != propertyLabel) {
					return propertyLabel.isVisible();
				}
			}

			// Depth 3
			if (row instanceof Property) {
				return ICellManager.EMPTY_STRING;
			}
		}

		return Boolean.FALSE;
	}

	/**
	 * Set the displayed value.
	 * 
	 * @param domain The transactional editing domain.
	 * @param rowElement The row element.
	 * @param newValue The value to set.
	 */
	public void setDisplayedValue(final TransactionalEditingDomain domain, final Object rowElement, final Object newValue) {
		Object row = AxisUtils.getRepresentedElement(rowElement);

		// Depth 2
		if (row instanceof Stereotype) {
			Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());
			if (parent instanceof View) {
				if (newValue instanceof Boolean) {
					View propertyLabel = helper.getStereotypeLabel((View) parent, (Stereotype) row);
					StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, propertyLabel, (Boolean) newValue);
				}
			}
		}
	}

	/**
	 * Get the brace value.
	 * 
	 * @param rowElement The row element.
	 * @return The brace value.
	 */
	public Object getBraceValue(final Object rowElement) {
		Object row = AxisUtils.getRepresentedElement(rowElement);
		if (rowElement instanceof ITreeItemAxis) {

			// Depth 1
			if (row instanceof Node) {
				return ICellManager.EMPTY_STRING;
			}

			// Depth 2
			if (row instanceof Stereotype) {
				Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());
				if (parent instanceof View) {

					View brace = helper.getStereotypeBraceCompartment((View) parent, (Stereotype) row);
					if (null != brace) {
						return brace.isVisible();
					}
				}
			}

			// Depth 3
			if (row instanceof Property) {
				Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent().getParent().getParent());
				Object stereo = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent());

				if (parent instanceof View) {
					View brace = helper.getStereotypePropertyInBrace((View) parent, (Stereotype) stereo, (Property) row);
					if (null != brace) {
						return brace.isVisible();
					}
				}
			}
		}

		return Boolean.FALSE;
	}

	/**
	 * Set the brace value.
	 * 
	 * @param domain The transactional editing domain.
	 * @param rowElement The row element.
	 * @param newValue The value to set.
	 */
	public void setBraceValue(final TransactionalEditingDomain domain, final Object rowElement, final Object newValue) {
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

	/**
	 * Get the comment value.
	 * 
	 * @param rowElement The row element.
	 * @return The comment value.
	 */
	public Object getCommentValue(final Object rowElement) {
		Object row = AxisUtils.getRepresentedElement(rowElement);
		if (rowElement instanceof ITreeItemAxis) {

			// Depth 1
			if (row instanceof Node) {
				return ICellManager.EMPTY_STRING;
			}

			// Depth 2
			if (row instanceof Stereotype) {
				Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());
				if (parent instanceof View) {

					View comment = helper.getStereotypeComment((View) parent);
					if (null != comment) {
						return comment.isVisible();
					}
				}
			}

			// Depth 3
			if (row instanceof Property) {
				Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent().getParent().getParent());
				Object stereo = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent());

				if (parent instanceof View) {
					View comment = helper.getStereotypePropertyInComment((View) parent, (Stereotype) stereo, (Property) row);
					if (null != comment) {
						return comment.isVisible();
					}
				}
			}
		}

		return Boolean.FALSE;
	}

	/**
	 * Set the comment value.
	 * 
	 * @param domain The transactional editing domain.
	 * @param rowElement The row element.
	 * @param newValue The value to set.
	 */
	public void setCommentValue(final TransactionalEditingDomain domain, final Object rowElement, final Object newValue) {
		Object row = AxisUtils.getRepresentedElement(rowElement);

		// Depth 2
		if (row instanceof Stereotype) {
			Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());
			if (parent instanceof View) {
				if (newValue instanceof Boolean) {
					View comment = helper.getStereotypeComment((View) parent);
					StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, comment, (Boolean) newValue);
					// The comment compartment will be displayed in the same time
					View compartment = helper.getStereotypeCompartment(comment, (Stereotype) row);
					StereotypeDisplayCommandExecution.getInstance().setUserVisibilityWithoutPersistence(domain, compartment, (Boolean) newValue);
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
						View commentProperty = helper.getStereotypePropertyInComment((View) parent, (Stereotype) stereo, (Property) row);
						StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, commentProperty, (Boolean) newValue);
					}
				}
			}
		}
	}

	/**
	 * Get the compartment value.
	 * 
	 * @param rowElement The row element.
	 * @return The compartment value.
	 */
	public Object getCompartmentValue(final Object rowElement) {
		Object row = AxisUtils.getRepresentedElement(rowElement);
		if (rowElement instanceof ITreeItemAxis) {

			// Depth 1
			if (row instanceof Node) {
				return ICellManager.EMPTY_STRING;
			}

			// Depth 2
			if (row instanceof Stereotype) {
				Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());
				if (parent instanceof View) {

					View compartment = helper.getStereotypeCompartment((View) parent, (Stereotype) row);
					if (null != compartment) {
						return compartment.isVisible();
					}
				}
			}

			// Depth 3
			if (row instanceof Property) {
				Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent().getParent().getParent());
				Object stereo = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent());

				if (parent instanceof View) {
					View compartment = helper.getStereotypePropertyInCompartment((View) parent, (Stereotype) stereo, (Property) row);
					if (null != compartment) {
						return compartment.isVisible();
					}
				}
			}
		}

		return Boolean.FALSE;
	}

	/**
	 * Set the compartment value.
	 * 
	 * @param domain The transactional editing domain.
	 * @param rowElement The row element.
	 * @param newValue The value to set.
	 */
	public void setCompartmentValue(final TransactionalEditingDomain domain, final Object rowElement, final Object newValue) {
		Object row = AxisUtils.getRepresentedElement(rowElement);

		// Depth 2
		if (row instanceof Stereotype) {
			Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());
			if (parent instanceof View) {
				if (newValue instanceof Boolean) {
					View compartment = helper.getStereotypeCompartment((View) parent, (Stereotype) row);
					StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, compartment, (Boolean) newValue);
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
						View compartment = helper.getStereotypePropertyInCompartment((View) parent, (Stereotype) stereo, (Property) row);
						StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, compartment, (Boolean) newValue);
					}
				}
			}
		}
	}
}

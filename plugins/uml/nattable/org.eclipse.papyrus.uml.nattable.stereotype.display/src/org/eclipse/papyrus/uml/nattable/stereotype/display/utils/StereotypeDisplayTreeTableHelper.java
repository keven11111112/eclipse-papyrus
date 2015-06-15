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
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayConstant;
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
	 * @param name
	 *            The name.
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
	 * @param rowElement
	 *            The row element.
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
	 * @param domain
	 *            The transactional editing domain.
	 * @param rowElement
	 *            The row element.
	 * @param newValue
	 *            The value to set.
	 */
	public void setDepthValue(final TransactionalEditingDomain domain, final Object rowElement, final Object newValue) {
		Object row = AxisUtils.getRepresentedElement(rowElement);

		// Depth 2
		if (row instanceof Stereotype) {
			Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());
			if (parent instanceof View) {
				View label = helper.getStereotypeLabel((View) parent, (Stereotype) row);
				if (newValue instanceof String) {
					if (StereotypeDisplayConstant.DEFAULT_DEPTH_VALUE != (String) newValue) {
						StereotypeDisplayCommandExecution.getInstance().setUserDepth(domain, (Stereotype) row, label, (String) newValue);
					} else {
						StereotypeDisplayCommandExecution.getInstance().setDepth(domain, (Stereotype) row, label, (String) newValue, true);
						StereotypeDisplayCommandExecution.getInstance().unsetPersistency(domain, label, true);

					}
				}
			}
		}
	}

	/**
	 * Get the displayed value.
	 * 
	 * @param rowElement
	 *            The row element.
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
	 * @param domain
	 *            The transactional editing domain.
	 * @param rowElement
	 *            The row element.
	 * @param newValue
	 *            The value to set.
	 */
	public void setDisplayedValue(final TransactionalEditingDomain domain, final Object rowElement, final Object newValue) {
		Object row = AxisUtils.getRepresentedElement(rowElement);

		// Depth 2
		if (row instanceof Stereotype) {
			Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());
			if (parent instanceof View) {
				if (newValue instanceof Boolean) {
					View label = helper.getStereotypeLabel((View) parent, (Stereotype) row);
					if (!(Boolean) newValue) {
						StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, label, false);
					} else {
						StereotypeDisplayCommandExecution.getInstance().setVisibility(domain, label, true, true);
						StereotypeDisplayCommandExecution.getInstance().unsetPersistency(domain, label, false);
					}
				}
			}
		}
	}

	/**
	 * Get the brace value.
	 * 
	 * @param rowElement
	 *            The row element.
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
	 * @param domain
	 *            The transactional editing domain.
	 * @param rowElement
	 *            The row element.
	 * @param newValue
	 *            The value to set.
	 */
	public void setBraceValue(final TransactionalEditingDomain domain, final Object rowElement, final Object newValue) {
		Object row = AxisUtils.getRepresentedElement(rowElement);

		// Depth 2
		if (row instanceof Stereotype) {
			Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());
			if (parent instanceof View) {
				if (newValue instanceof Boolean) {
					View brace = helper.getStereotypeBraceCompartment((View) parent, (Stereotype) row);
					if ((Boolean) newValue) {
						StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, brace, true);
					} else {
						StereotypeDisplayCommandExecution.getInstance().setVisibility(domain, brace, false, true);
						StereotypeDisplayCommandExecution.getInstance().unsetPersistency(domain, brace, false);
					}

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

						View braceProperty = helper.getStereotypePropertyInBrace((View) parent, (Stereotype) stereo, (Property) row);
						if (!(Boolean) newValue) {
							StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, braceProperty, false);
						} else {
							StereotypeDisplayCommandExecution.getInstance().setVisibility(domain, braceProperty, true, true);
							StereotypeDisplayCommandExecution.getInstance().unsetPersistency(domain, braceProperty, false);
						}

					}
				}
			}
		}
	}

	/**
	 * Get the comment value.
	 * 
	 * @param rowElement
	 *            The row element.
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
					View compartment = helper.getStereotypeCompartment(comment, (Stereotype) row);

					if (null != comment) {
						return comment.isVisible() && compartment.isVisible();
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
	 * @param domain
	 *            The transactional editing domain.
	 * @param rowElement
	 *            The row element.
	 * @param newValue
	 *            The value to set.
	 */
	public void setCommentValue(final TransactionalEditingDomain domain, final Object rowElement, final Object newValue) {
		Object row = AxisUtils.getRepresentedElement(rowElement);

		// Depth 2
		if (row instanceof Stereotype) {
			Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());
			if (parent instanceof View) {
				if (newValue instanceof Boolean) {
					View comment = helper.getStereotypeComment((View) parent);
					// The comment compartment will be displayed in the same time
					View compartment = helper.getStereotypeCompartment(comment, (Stereotype) row);
					if ((Boolean) newValue) {
						StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, compartment, true);
					} else {
						StereotypeDisplayCommandExecution.getInstance().setVisibility(domain, compartment, false, true);
						StereotypeDisplayCommandExecution.getInstance().unsetPersistency(domain, compartment, false);
					}
					// Update comment visibility depending on the content
					updateComment(domain, comment);

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
						if (!(Boolean) newValue) {
							StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, commentProperty, false);
						} else {
							StereotypeDisplayCommandExecution.getInstance().setVisibility(domain, commentProperty, true, true);
							StereotypeDisplayCommandExecution.getInstance().unsetPersistency(domain, commentProperty, false);
						}

					}
				}
			}
		}
	}



	/**
	 * Get the compartment value.
	 * 
	 * @param rowElement
	 *            The row element.
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
	 * @param domain
	 *            The transactional editing domain.
	 * @param rowElement
	 *            The row element.
	 * @param newValue
	 *            The value to set.
	 */
	public void setCompartmentValue(final TransactionalEditingDomain domain, final Object rowElement, final Object newValue) {
		Object row = AxisUtils.getRepresentedElement(rowElement);

		// Depth 2
		if (row instanceof Stereotype) {
			Object parent = AxisUtils.getRepresentedElement(((ITreeItemAxis) rowElement).getParent().getParent().getParent().getParent());
			if (parent instanceof View) {
				if (newValue instanceof Boolean) {
					View compartment = helper.getStereotypeCompartment((View) parent, (Stereotype) row);
					if ((Boolean) newValue) {
						StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, compartment, true);
					} else {
						StereotypeDisplayCommandExecution.getInstance().setVisibility(domain, compartment, false, true);
						StereotypeDisplayCommandExecution.getInstance().unsetPersistency(domain, compartment, false);
					}
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
						View property = helper.getStereotypePropertyInCompartment((View) parent, (Stereotype) stereo, (Property) row);
						if (!(Boolean) newValue) {
							StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, property, false);
						} else {
							StereotypeDisplayCommandExecution.getInstance().setVisibility(domain, property, true, true);
							StereotypeDisplayCommandExecution.getInstance().unsetPersistency(domain, property, false);
						}
					}
				}
			}
		}
	}

	/**
	 * Update the Comment visibility depending on its content.
	 * 
	 * @param domain
	 *            Transactional Domain
	 * @param comment
	 *            the Comment notation view
	 */
	private void updateComment(TransactionalEditingDomain domain, View comment) {

		if (!StereotypeDisplayUtil.getInstance().hasVisibleCompartment(comment)) {
			StereotypeDisplayCommandExecution.getInstance().setVisibility(domain, comment, false, true);
		} else {
			StereotypeDisplayCommandExecution.getInstance().setUserVisibility(domain, comment, true);
		}

	}
}

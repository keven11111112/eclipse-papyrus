/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.requirements.sysml.matrix.derivedFrom.config.cellmanager;

import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
//import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.requirements.sysml.common.I_SysMLStereotype;
import org.eclipse.papyrus.requirements.sysml.matrix.derivedFrom.config.Activator;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

@SuppressWarnings("deprecation")
public class DerivedFromMatrixCellManager extends AbstractCellManager {
	public static final String CELL_MANAGER_ID = Activator.PLUGIN_ID + ".cellmanager.DerivedFromMatrixCellManager";

	@Override
	public boolean handles(Object columnElement, Object rowElement) {
		// Supports Requirement x Requirement
		Object column = AxisUtils.getRepresentedElement(columnElement);
		Object row = AxisUtils.getRepresentedElement(rowElement);
		if (rowElement instanceof ITreeItemAxis) {
			ITreeItemAxis axis = (ITreeItemAxis) rowElement;
			AxisManagerRepresentation manager = axis.getManager();
			TableConfiguration conf = (TableConfiguration) manager.eContainer().eContainer();
			String type = conf.getType();
			if (!type.equals("DerivedFromMatrix")) {
				return false;
			}
		}

		if (column instanceof Element && row instanceof Element) {
			Element colUMLElement = (Element) column;
			Element rowUMLElement = (Element) row;
			if (UMLUtil.getStereotypeApplication(colUMLElement, Requirement.class) != null
					&& UMLUtil.getStereotypeApplication(rowUMLElement, Requirement.class) != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected Object doGetValue(Object columnElement, Object rowElement, INattableModelManager tableManager) {
		Object column = AxisUtils.getRepresentedElement(columnElement);
		Object row = AxisUtils.getRepresentedElement(rowElement);
		if (column instanceof Element && row instanceof Element) {
			Element colUMLElement = (Element) column;
			Element rowUMLElement = (Element) row;
			if (UMLUtil.getStereotypeApplication(colUMLElement, Requirement.class) != null
					&& UMLUtil.getStereotypeApplication(rowUMLElement, Requirement.class) != null) {
				Requirement requirementInRow = UMLUtil.getStereotypeApplication(rowUMLElement, Requirement.class);
				@SuppressWarnings("unchecked")
				EList<EObject> list = (EList<EObject>) UMLUtil.getTaggedValue(colUMLElement,
						I_SysMLStereotype.REQUIREMENT_STEREOTYPE, I_SysMLStereotype.REQUIREMENT_DERIVEDFROM_ATT);
				// Find if the requirement in the row is in the list of
				// requirements that derive the requirement (in the column)
				for (EObject requirementThatDerivedRequirementInColumn : list) {
					if (requirementThatDerivedRequirementInColumn.equals(requirementInRow)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void setValue(TransactionalEditingDomain domain, Object columnElement, Object rowElement, Object newValue,
			INattableModelManager tableManager) {
		Object column = AxisUtils.getRepresentedElement(columnElement);
		Object row = AxisUtils.getRepresentedElement(rowElement);
		EObject eObjectInRow = (EObject) row;

		if (column instanceof Element) {
			Element colUMLElement = (Element) column;
			Element rowUMLElement = (Element) row;
			if (Boolean.FALSE.equals(newValue)) {
				if (UMLUtil.getStereotypeApplication(colUMLElement, Requirement.class) != null) {
					Stereotype reqStereotype = colUMLElement
							.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
					Object listOfObjectsThatSatisfyRequirement = colUMLElement.getValue(reqStereotype, "derivedFrom");

					if (listOfObjectsThatSatisfyRequirement instanceof EList<?>) {
						@SuppressWarnings("unchecked")
						EList<EObject> list = (EList<EObject>) listOfObjectsThatSatisfyRequirement;
						// check the list of elements that satisfy the
						// requirement to see if the element in the current row
						DirectedRelationship toDestroy = null;
						for (EObject eObjectThatSatisfiesRequirement : list) {
							if (toDestroy == null) {
								EObject baseClass = UMLUtil.getBaseElement(eObjectThatSatisfiesRequirement);
								if (eObjectInRow.equals(baseClass)) {
									EList<DirectedRelationship> directedRelationships = colUMLElement
											.getSourceDirectedRelationships();

									Iterator<DirectedRelationship> iter = directedRelationships.iterator();
									while (iter.hasNext() && toDestroy == null) {
										DirectedRelationship relationship = iter.next();
										if (relationship instanceof Abstraction) {
											if (relationship.getAppliedStereotype(
													I_SysMLStereotype.DERIVEREQT_STEREOTYPE) != null) {
												EList<Element> sources = relationship.getSources();
												EList<Element> targets = relationship.getTargets();
												if (sources.contains(column) && targets.contains(rowUMLElement)) {
													toDestroy = relationship;
												}
											}
										}
									}
								}
							}
						}

						if (toDestroy != null) {
							DestroyElementRequest req = new DestroyElementRequest(toDestroy, false);
							IElementEditService provider = ElementEditServiceUtils.getCommandProvider(toDestroy);
							ICommand cmd = provider.getEditCommand(req);
							if (cmd != null && cmd.canExecute()) {
								domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
							}
						}
					}
				}
			} else if (Boolean.TRUE.equals(newValue)
					|| (newValue instanceof Abstraction && ((Abstraction) newValue).eContainer() == null)) {
				Element container = rowUMLElement.getNearestPackage();
				// derivedReqt is owned by the most concrete requirement package
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container);
				CreateRelationshipRequest request = new CreateRelationshipRequest(domain, container, (EObject) column,
						rowUMLElement, SysMLElementTypes.DERIVE_REQT);
				request.setContainer(container);
				ICommand cmd = provider.getEditCommand(request);
				if (cmd != null && cmd.canExecute()) {
					domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
				}
			}
		}
	}

	@Override
	public Command getSetValueCommand(TransactionalEditingDomain domain, Object columnElement, Object rowElement,
			Object newValue, INattableModelManager tableManager) {
		return super.getSetValueCommand(domain, columnElement, rowElement, newValue, tableManager);
	}

	@Override
	public boolean isCellEditable(Object columnElement, Object rowElement) {
		Object column = AxisUtils.getRepresentedElement(columnElement);
		Object row = AxisUtils.getRepresentedElement(rowElement);

		if (column instanceof Element && row instanceof Element) {
			return UMLUtil.getStereotypeApplication((Element) column, Requirement.class) != null
					&& UMLUtil.getStereotypeApplication((Element) row, Requirement.class) != null;
		}
		return false;
	}
}

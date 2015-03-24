/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Tatibouet (CEA LIST)
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.transaction.commit;

import static org.eclipse.papyrus.uml.alf.transaction.ActivatorTransaction.logger;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.compare.CompareUI;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.uml.alf.text.merge.manual.AlfCompareEditor;
import org.eclipse.papyrus.uml.alf.text.merge.manual.MergeActionDialog;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;
import org.eclipse.papyrus.uml.alf.transaction.commands.AlfCommandFactory;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Package;

public class SyncScenario extends Scenario implements ISyncScenario {

	/**
	 * The model state that is taken as reference to perform the synchronization
	 */
	protected AlfTextualRepresentation modelStateToBeCommitted;

	public SyncScenario() {
		super();
		this.modelStateToBeCommitted = null;
	}

	/**
	 * Checks required before to perform a synchronization
	 */
	public void before() {
		/* 1. It means the user model has not been saved in the current model */
		if (this.userModelState.isSaved()) {
			/* 1.1. The two models diverge */
			if (this.userModelState.isDifferent(this.currentModelState)) {
				MergeActionDialog mergeActionDialog = new MergeActionDialog(Display.getCurrent().getActiveShell(), this.currentModelState.getOwner());
				/* 1.1.1. The user has to choose what to do */
				if (mergeActionDialog.open() == Window.OK) {
					if (mergeActionDialog.getReturnCode() == MergeActionDialog.REBASE) {
						this.userModelState.rebase(this.currentModelState);
						this.modelStateToBeCommitted = this.userModelState;
					} else if (mergeActionDialog.getReturnCode() == MergeActionDialog.MERGE) {
						CompareUI.openCompareDialog(new AlfCompareEditor(this.userModelState, this.currentModelState));
					} else {
						this.currentModelState.reconcile(this.userModelState);
						this.currentModelState.setSource(this.userModelState.getSource());
						this.modelStateToBeCommitted = this.currentModelState;
					}
				}
			}
		} else {
			this.modelStateToBeCommitted = this.userModelState.rebase(this.currentModelState);
		}
	}

	protected Set<NamedElement> getRealTargets(Element target, List<Notification> changes) {
		Set<NamedElement> realTargets = new HashSet<NamedElement>();
		Iterator<Notification> changesIterator = changes.iterator();
		/* 1. Handle model modifications implied by Generalization */
		if (target instanceof Generalization) {
			while (changesIterator.hasNext()) {
				Notification notification = changesIterator.next();
				switch (notification.getEventType()) {
				/* Handle the case where Class::superClass derived feature changed but no notification was emitted */
				case Notification.SET: {
					/* The specific feature has changed (deletion / update) */
					if (notification.getFeature() == UMLPackage.eINSTANCE.getGeneralization_Specific()
							&& notification.getOldValue() != null) {
						realTargets.add((NamedElement) notification.getOldValue());
					}
					/* The general feature has changed (deletion / update) */
					else if (notification.getFeature() == UMLPackage.eINSTANCE.getGeneralization_General()
							&& ((Generalization) target).getSpecific() != null) {
						realTargets.add(((Generalization) target).getSpecific());
					}
				}
					break;
				}
			}
		}
		/* 2. Handle model modifications implied by Packages */
		else if (target instanceof Package) {
			while (changesIterator.hasNext()) {
				Notification notification = changesIterator.next();
				switch (notification.getEventType()) {
				case Notification.ADD: {
					if (notification.getFeature() == UMLPackage.eINSTANCE.getPackage_PackagedElement()) {
						realTargets.add((NamedElement) notification.getNewValue());
					}
				}
					break;
				case Notification.REMOVE: {
					if (notification.getFeature() == UMLPackage.eINSTANCE.getPackage_PackagedElement()) {
						NamedElement oldValue = (NamedElement) notification.getOldValue();
						/* In case a element is deleted from the package */
						if (oldValue.getModel() != null) {
							realTargets.add((NamedElement) notification.getOldValue());
						}
					}
				}
					break;
				}
			}
			realTargets.add((Package) target);
		}
		/* 3. */
		else {
			realTargets.add((NamedElement) target);
		}
		return realTargets;
	}

	public Command synchronize(Element target, List<Notification> changes) {
		CompoundCommand compoundCommand = new CompoundCommand("synchronize");
		for (NamedElement affectedElement : this.getRealTargets(target, changes)) {
			compoundCommand.append(this._synchronize(affectedElement));
		}
		return compoundCommand;
	}

	/**
	 * Provide a synchronization command for the given target
	 * 
	 * @param target
	 *            - the model element on which textual specification must be aligned
	 * @return command - a command to synchronize the model element and the text
	 */
	protected Command _synchronize(NamedElement target) {
		/* 1. Load the target states */
		this.init(target);
		/* 2. Do before checks */
		this.before();
		/* 3. Provide save command */
		return AlfCommandFactory.getInstance().creatSaveCommand(this.modelStateToBeCommitted);
	}

	public void after() {
		logger.info("Synchronization Done");
	}
}

/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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
package org.eclipse.papyrus.infra.elementtypesconfigurations.notification;

import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.IdentityCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.AdviceApprovedEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.AdviceDisapprovedEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.AdvicePhase;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.AdviceRequestConfigurationEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.EditHelperApprovedEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.EditHelperDisapprovedEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.EditHelperRequestConfigurationEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.ExecutableAdviceEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.ExecutableEditHelperEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.IdentityAdviceEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.IdentityEditHelperEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.UnexecutableAdviceEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.UnexecutableEditHelperEvent;

/**
 * An override of the {@link AbstractEditHelper} to provide Notifications during edithelper execution.
 * The notifications provide EditHelper trace information for testing and debugging purpose.
 */
public abstract class AbstractNotifierEditHelper extends AbstractEditHelper {

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#getEditCommand(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 *
	 * @param req
	 * @return
	 */
	@Override
	public ICommand getEditCommand(IEditCommandRequest req) {
		ElementTypesConfigurationsEventsChain eventsChain = new ElementTypesConfigurationsEventsChain(this, req);
		// Get the matching edit helper advice
		IEditHelperAdvice[] advice = getEditHelperAdvice(req);
		// Consult advisors to allow them to configure the request
		configureRequest(req, advice, eventsChain);
		// Consult advisors to allow them approve the request
		boolean approved = approveRequest(req, advice, eventsChain);
		if (!approved) {
			// Notify listeners
			if (Platform.inDebugMode()) {
				ElementTypesConfigurationsListenersRegistry.getInstance().notifyChain(eventsChain);
			}
			return null;
		}
		ICommand result = getEditCommand(req, advice, eventsChain);
		if (result != null) {
			// Notify listeners
			if (Platform.inDebugMode()) {
				ElementTypesConfigurationsListenersRegistry.getInstance().notifyChain(eventsChain);
			}
			return result.reduce();
		}
		// Notify listeners
		if (Platform.inDebugMode()) {
			ElementTypesConfigurationsListenersRegistry.getInstance().notifyChain(eventsChain);
		}
		return result;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#getEditCommand(IEditCommandRequest, IEditHelperAdvice[])
	 * 
	 * @param req
	 * @param advice
	 * @param eventsChain
	 * @return
	 */
	private ICommand getEditCommand(IEditCommandRequest req, IEditHelperAdvice[] advice, ElementTypesConfigurationsEventsChain eventsChain) {
		ICompositeCommand command = createCommand(req);
		// Get 'before' commands from matching element type
		// specializations
		if (advice != null) {
			for (int i = 0; i < advice.length; i++) {
				IEditHelperAdvice nextAdvice = advice[i];
				// Before commands
				ICommand beforeAdvice = nextAdvice.getBeforeEditCommand(req);
				if (beforeAdvice != null) {
					if (beforeAdvice.canExecute()) {
						if (Platform.inDebugMode()) {
							if (beforeAdvice.equals(IdentityCommand.INSTANCE)) {
								IdentityAdviceEvent event = new IdentityAdviceEvent(req, this, nextAdvice, advice, AdvicePhase.before);
								eventsChain.addBeforeAdvicesCommandsEvent(event);
								ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
							} else {
								ExecutableAdviceEvent event = new ExecutableAdviceEvent(req, this, nextAdvice, beforeAdvice, advice, AdvicePhase.before);
								eventsChain.addBeforeAdvicesCommandsEvent(event);
								ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
							}
						}
						command.compose(beforeAdvice);
					} else {
						if (Platform.inDebugMode()) {
							UnexecutableAdviceEvent event = new UnexecutableAdviceEvent(req, this, nextAdvice, beforeAdvice, advice, AdvicePhase.before);
							eventsChain.addBeforeAdvicesCommandsEvent(event);
							ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
						}
						return beforeAdvice;
					}
				}
			}
		}
		// Check if the parameter has been set to ignore the default edit command.
		Object replaceParam = req.getParameter(IEditCommandRequest.REPLACE_DEFAULT_COMMAND);
		if (replaceParam != Boolean.TRUE) {
			// Get 'instead' command from this edit helper
			ICommand insteadCommand = getInsteadCommand(req);
			if (insteadCommand != null) {
				if (insteadCommand.canExecute()) {
					if (Platform.inDebugMode()) {
						if (insteadCommand.equals(IdentityCommand.INSTANCE)) {
							IdentityEditHelperEvent event = new IdentityEditHelperEvent(req, this);
							eventsChain.setEditHelperCommandEvent(event);
							ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
						} else {
							ExecutableEditHelperEvent event = new ExecutableEditHelperEvent(req, this, insteadCommand);
							eventsChain.setEditHelperCommandEvent(event);
							ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
						}
					}
					command.compose(insteadCommand);
				} else {
					if (Platform.inDebugMode()) {
						UnexecutableEditHelperEvent event = new UnexecutableEditHelperEvent(req, this, insteadCommand);
						eventsChain.setEditHelperCommandEvent(event);
						ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
					}
					return insteadCommand;
				}
			}
		}
		// Get 'after' commands from matching element type
		// specializations
		if (advice != null) {
			for (int i = 0; i < advice.length; i++) {
				IEditHelperAdvice nextAdvice = advice[i];
				// After commands
				ICommand afterAdvice = nextAdvice.getAfterEditCommand(req);
				if (afterAdvice != null) {
					if (afterAdvice.canExecute()) {
						if (Platform.inDebugMode()) {
							if (afterAdvice.equals(IdentityCommand.INSTANCE)) {
								IdentityAdviceEvent event = new IdentityAdviceEvent(req, this, nextAdvice, advice, AdvicePhase.after);
								eventsChain.addBeforeAdvicesCommandsEvent(event);
								ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
							} else {
								ExecutableAdviceEvent event = new ExecutableAdviceEvent(req, this, nextAdvice, afterAdvice, advice, AdvicePhase.after);
								eventsChain.addBeforeAdvicesCommandsEvent(event);
								ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
							}
						}
						command.compose(afterAdvice);
					} else {
						if (Platform.inDebugMode()) {
							UnexecutableAdviceEvent event = new UnexecutableAdviceEvent(req, this, nextAdvice, afterAdvice, advice, AdvicePhase.after);
							eventsChain.addBeforeAdvicesCommandsEvent(event);
							ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
						}
						return afterAdvice;
					}
				}
			}
		}
		return command.isEmpty() ? null : command;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#configureRequest(IEditCommandRequest, IEditHelperAdvice[])
	 * 
	 * @param req
	 * @param advice
	 * @param eventsChain
	 */
	private void configureRequest(IEditCommandRequest req, IEditHelperAdvice[] advice, ElementTypesConfigurationsEventsChain eventsChain) {
		if (advice != null) {
			for (int i = 0; i < advice.length; i++) {
				IEditHelperAdvice nextAdvice = advice[i];
				nextAdvice.configureRequest(req);
				if (Platform.inDebugMode()) {
					AdviceRequestConfigurationEvent event = new AdviceRequestConfigurationEvent(req, this, nextAdvice, advice);
					eventsChain.addAdviceRequestConfigurationEvent(event);
					ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
				}
			}
		}
		// All advice has configured the request. Now consult this edit helper.
		configureRequest(req);
		if (Platform.inDebugMode()) {
			EditHelperRequestConfigurationEvent event = new EditHelperRequestConfigurationEvent(req, this);
			eventsChain.setEditHelperRequestConfigurationEvent(event);
			ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
		}
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#approveRequest(IEditCommandRequest, IEditHelperAdvice[])
	 * 
	 * @param req
	 * @param advice
	 * @param eventsChain
	 * @return
	 */
	private boolean approveRequest(IEditCommandRequest req, IEditHelperAdvice[] advice, ElementTypesConfigurationsEventsChain eventsChain) {
		if (advice != null) {
			for (int i = 0; i < advice.length; i++) {
				IEditHelperAdvice nextAdvice = advice[i];
				boolean approved = nextAdvice.approveRequest(req);
				if (!approved) {
					if (Platform.inDebugMode()) {
						AdviceDisapprovedEvent event = new AdviceDisapprovedEvent(req, this, nextAdvice, advice);
						eventsChain.addAdviceApprovalEvent(event);
						ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
					}
					return false;
				} else {
					if (Platform.inDebugMode()) {
						AdviceApprovedEvent event = new AdviceApprovedEvent(req, this, nextAdvice, advice);
						eventsChain.addAdviceApprovalEvent(event);
						ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
					}
				}
			}
		}
		// All advice has approved the request. Now consult this edit helper.
		boolean approved = approveRequest(req);
		if (Platform.inDebugMode()) {
			if (!approved) {
				EditHelperDisapprovedEvent event = new EditHelperDisapprovedEvent(req, this);
				eventsChain.setEditHelperApprovalEvent(event);
				ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
			} else {
				EditHelperApprovedEvent event = new EditHelperApprovedEvent(req, this);
				eventsChain.setEditHelperApprovalEvent(event);
				ElementTypesConfigurationsListenersRegistry.getInstance().notifyEvent(event);
			}
		}
		return approved;
	}
}

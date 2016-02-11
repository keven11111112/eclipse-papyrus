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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.AbstractElementTypesConfigurationsEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.AdviceApprovedEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.AdviceDisapprovedEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.AdviceRequestConfigurationEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.EditHelperApprovedEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.EditHelperDisapprovedEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.ExecutableAdviceEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.ExecutableEditHelperEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.IdentityAdviceEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.IdentityEditHelperEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.UnexecutableAdviceEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.UnexecutableEditHelperEvent;

public class ElementTypesConfigurationsEventsChain {

	/**
	 * Timestamp of the creation of the chain
	 */
	private long timestamp;

	/**
	 * The {@link IEditHelper} that triggered the {@link ElementTypesConfigurationsEventsChain}
	 */
	private IEditHelper editHelper;

	/**
	 * The {@link IEditCommandRequest} that triggered the {@link ElementTypesConfigurationsEventsChain}
	 */
	private IEditCommandRequest req;

	ElementTypesConfigurationsEventsChain(IEditHelper editHelper, IEditCommandRequest req) {
		timestamp = System.currentTimeMillis();
		this.editHelper = editHelper;
		this.req = req;
	}

	/**
	 * The various categories of events that occur during the execution of the {@link IEditHelper}
	 */
	private List<AbstractElementTypesConfigurationsEvent> adviceRequestConfigurationEvents = new ArrayList<AbstractElementTypesConfigurationsEvent>();

	private AbstractElementTypesConfigurationsEvent editHelperRequestConfigurationEvent = null;

	private List<AbstractElementTypesConfigurationsEvent> adviceApprovalEvents = new ArrayList<AbstractElementTypesConfigurationsEvent>();

	private AbstractElementTypesConfigurationsEvent editHelperApprovalEvent = null;

	private List<AbstractElementTypesConfigurationsEvent> beforeAdvicesCommandsEvents = new ArrayList<AbstractElementTypesConfigurationsEvent>();

	private List<AbstractElementTypesConfigurationsEvent> afterAdvicesCommandsEvents = new ArrayList<AbstractElementTypesConfigurationsEvent>();

	private AbstractElementTypesConfigurationsEvent editHelperCommandEvent = null;

	/**
	 * @return the adviceApprovalEvents
	 */
	public List<AbstractElementTypesConfigurationsEvent> getAdviceApprovalEvents() {
		return adviceApprovalEvents;
	}

	/**
	 * Add a {@link AdviceDisapprovedEvent} or {@link AdviceApprovedEvent} event
	 * 
	 * @param adviceApprovalEvent
	 */
	public void addAdviceApprovalEvent(AbstractElementTypesConfigurationsEvent adviceApprovalEvent) {
		if(adviceApprovalEvent instanceof AdviceDisapprovedEvent || adviceApprovalEvent instanceof AdviceApprovedEvent) {
			adviceApprovalEvents.add(adviceApprovalEvent);
		}
	}

	/**
	 * @return the editHelperAprrovalEvent
	 */
	public AbstractElementTypesConfigurationsEvent getEditHelperApprovalEvent() {
		return editHelperApprovalEvent;
	}

	/**
	 * @param editHelperAprrovalEvent
	 *        the editHelperAprrovalEvent to set
	 */
	public void setEditHelperApprovalEvent(AbstractElementTypesConfigurationsEvent editHelperApprovalEvent) {
		if(editHelperApprovalEvent instanceof EditHelperDisapprovedEvent || editHelperApprovalEvent instanceof EditHelperApprovedEvent) {
			this.editHelperApprovalEvent = editHelperApprovalEvent;
		}
	}

	/**
	 * @return the beforeAdvicesCommandsEvents
	 */
	public List<AbstractElementTypesConfigurationsEvent> getBeforeAdvicesCommandsEvents() {
		return beforeAdvicesCommandsEvents;
	}

	/**
	 * Add a {@link ExecutableAdviceEvent}, {@link UnexecutableAdviceEvent} or {@link IdentityAdviceEvent} event
	 * 
	 * @param beforeAdvicesCommandsEvents
	 *        the beforeAdvicesCommandsEvents to set
	 */
	public void addBeforeAdvicesCommandsEvent(AbstractElementTypesConfigurationsEvent beforeAdvicesCommandEvent) {
		if(beforeAdvicesCommandEvent instanceof ExecutableAdviceEvent || beforeAdvicesCommandEvent instanceof UnexecutableAdviceEvent || beforeAdvicesCommandEvent instanceof IdentityAdviceEvent) {
			beforeAdvicesCommandsEvents.add(beforeAdvicesCommandEvent);
		}
	}

	/**
	 * @return the afterAdvicesCommandsEvents
	 */
	public List<AbstractElementTypesConfigurationsEvent> getAfterAdvicesCommandsEvents() {
		return afterAdvicesCommandsEvents;
	}

	/**
	 * Add a {@link ExecutableAdviceEvent}, {@link UnexecutableAdviceEvent} or {@link IdentityAdviceEvent} event
	 * 
	 * @param afterAdvicesCommandEvent
	 */
	public void addAfterAdvicesCommandsEvent(AbstractElementTypesConfigurationsEvent afterAdvicesCommandEvent) {
		if(afterAdvicesCommandEvent instanceof ExecutableAdviceEvent || afterAdvicesCommandEvent instanceof UnexecutableAdviceEvent || afterAdvicesCommandEvent instanceof IdentityAdviceEvent) {
			afterAdvicesCommandsEvents.add(afterAdvicesCommandEvent);
		}
	}

	/**
	 * @return the editHelperCommandEvent
	 */
	public AbstractElementTypesConfigurationsEvent getEditHelperCommandEvent() {
		return editHelperCommandEvent;
	}

	/**
	 * @param editHelperCommandEvent
	 *        the editHelperCommandEvent to set ({@link ExecutableEditHelperEvent}, {@link UnexecutableEditHelperEvent} or
	 *        {@link IdentityEditHelperEvent})
	 */
	public void setEditHelperCommandEvent(AbstractElementTypesConfigurationsEvent editHelperCommandEvent) {
		if(editHelperCommandEvent instanceof ExecutableEditHelperEvent || editHelperCommandEvent instanceof UnexecutableEditHelperEvent || editHelperCommandEvent instanceof IdentityEditHelperEvent) {
			this.editHelperCommandEvent = editHelperCommandEvent;
		}
	}

	/**
	 * Returns all the events that occurred during the execution of the {@link IEditHelper} (i.e. all events categories)
	 * 
	 * @return
	 */
	public List<AbstractElementTypesConfigurationsEvent> getAllEvents() {
		List<AbstractElementTypesConfigurationsEvent> result = new ArrayList<AbstractElementTypesConfigurationsEvent>();
		if(!adviceRequestConfigurationEvents.isEmpty()) {
			result.addAll(adviceRequestConfigurationEvents);
		}
		if(editHelperRequestConfigurationEvent != null) {
			result.add(editHelperRequestConfigurationEvent);
		}
		if(!adviceApprovalEvents.isEmpty()) {
			result.addAll(adviceApprovalEvents);
		}
		if(editHelperApprovalEvent != null) {
			result.add(editHelperApprovalEvent);
		}
		if(!beforeAdvicesCommandsEvents.isEmpty()) {
			result.addAll(beforeAdvicesCommandsEvents);
		}
		if(editHelperCommandEvent != null) {
			result.add(editHelperCommandEvent);
		}
		if(!afterAdvicesCommandsEvents.isEmpty()) {
			result.addAll(afterAdvicesCommandsEvents);
		}
		return result;
	}

	/**
	 * @return the timestamp creation of this {@link ElementTypesConfigurationsEventsChain}
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * @return the req
	 */
	public IEditCommandRequest getRequest() {
		return req;
	}

	/**
	 * The Simple Name of the class of the {@link IEditHelper} that triggered this {@link ElementTypesConfigurationsEventsChain}
	 * 
	 * @return
	 */
	public String getName() {
		return editHelper.getClass().getSimpleName();
	}

	/**
	 * @return the adviceRequestConfigurationEvents
	 */
	public List<AbstractElementTypesConfigurationsEvent> getAdviceRequestConfigurationEvents() {
		return adviceRequestConfigurationEvents;
	}

	/**
	 * @param adviceConfigureEvent
	 */
	public void addAdviceRequestConfigurationEvent(AdviceRequestConfigurationEvent adviceConfigureEvent) {
		adviceRequestConfigurationEvents.add(adviceConfigureEvent);
	}

	/**
	 * @return the editHelperRequestConfigurationEvent
	 */
	public AbstractElementTypesConfigurationsEvent getEditHelperRequestConfigurationEvent() {
		return editHelperRequestConfigurationEvent;
	}

	/**
	 * @param editHelperRequestConfigurationEvent
	 *        the editHelperRequestConfigurationEvent to set
	 */
	public void setEditHelperRequestConfigurationEvent(AbstractElementTypesConfigurationsEvent editHelperRequestConfigurationEvent) {
		this.editHelperRequestConfigurationEvent = editHelperRequestConfigurationEvent;
	}
}

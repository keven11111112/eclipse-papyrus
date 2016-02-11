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

package org.eclipse.papyrus.elementtypesconfigurations.developer.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.AdviceApprovedEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.AdviceDisapprovedEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.AdviceRequestConfigurationEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.EditHelperApprovedEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.EditHelperDisapprovedEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.EditHelperRequestConfigurationEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.ExecutableAdviceEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.ExecutableEditHelperEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.IAdviceEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.IElementTypesConfigurationsEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.IdentityAdviceEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.IdentityEditHelperEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.UnexecutableAdviceEvent;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.UnexecutableEditHelperEvent;

public class ElementTypesConfigurationsEventPrinter {
	public static Map<String, String> getEventDetails(IElementTypesConfigurationsEvent event) {
		Map<String, String> result = new HashMap<>();

		if (event instanceof AdviceApprovedEvent) {
			result.put("Approved Advice", ((AdviceApprovedEvent) event).getAdvice().getClass().getName());
		} else if (event instanceof AdviceDisapprovedEvent) {
			result.put("Disapprover Advice", ((AdviceDisapprovedEvent) event).getAdvice().getClass().getName());
		} else if (event instanceof EditHelperApprovedEvent) {
			result.put("Approver edithelper", ((EditHelperApprovedEvent) event).getEditHelper().getClass().getName());
		} else if (event instanceof EditHelperDisapprovedEvent) {
			result.put("Disapprover edithelper", ((EditHelperDisapprovedEvent) event).getEditHelper().getClass().getName());
		} else if (event instanceof ExecutableAdviceEvent) {
			result.put("Advice", ((ExecutableAdviceEvent) event).getAdvice().getClass().getName());
			result.put("Phase ", ((ExecutableAdviceEvent) event).getAdvicePhase().name());
			result.put("Executable command", ((ExecutableAdviceEvent) event).getCommand().getClass().getName());
		} else if (event instanceof ExecutableEditHelperEvent) {
			result.put("Executable command from edithelper", ((ExecutableEditHelperEvent) event).getEditHelper().getClass().getName());
			result.put("Executable command", ((ExecutableEditHelperEvent) event).getCommand().getClass().getName());
		} else if (event instanceof IdentityAdviceEvent) {
			result.put("Identity Advice", ((IdentityAdviceEvent) event).getAdvice().getClass().getName());
			result.put("Phase ", ((IdentityAdviceEvent) event).getAdvicePhase().name());
		} else if (event instanceof IdentityEditHelperEvent) {
			result.put("Identity EditHelper", ((IdentityEditHelperEvent) event).getEditHelper().getClass().getName());
		} else if (event instanceof UnexecutableAdviceEvent) {
			result.put("Unexecutable Advice", ((UnexecutableAdviceEvent) event).getAdvice().getClass().getName());
			result.put("Phase ", ((UnexecutableAdviceEvent) event).getAdvicePhase().name());
			result.put("Unexecutable command", ((UnexecutableAdviceEvent) event).getCommand().getClass().getName());
		} else if (event instanceof UnexecutableEditHelperEvent) {
			result.put("Unexecutable command from edithelper", ((UnexecutableEditHelperEvent) event).getEditHelper().getClass().getName());
			result.put("Unexecutable command", ((UnexecutableEditHelperEvent) event).getCommand().getClass().getName());
		} else if (event instanceof AdviceRequestConfigurationEvent) {
			result.put("RequestConfiguration Advice", ((AdviceRequestConfigurationEvent) event).getAdvice().getClass().getName());
		} else if (event instanceof EditHelperRequestConfigurationEvent) {
			result.put("RequestConfiguration EditHelper", ((EditHelperRequestConfigurationEvent) event).getEditHelper().getClass().getName());
		}

		if (event instanceof IAdviceEvent) {
			String adviceNames = "";
			for (IEditHelperAdvice editHelperAdvice : ((IAdviceEvent) event).getAdvices()) {
				adviceNames += " -" + editHelperAdvice.getClass().getName() + "\n";
			}
			result.put("Among the following advices ", adviceNames);
		}

		return result;
	}

	public static String printHtmlEvent(Map<String, String> details) {


		String html = "<table border=\"1\">";
		for (String key : details.keySet()) {
			html += "<tr>";
			html += "<td><b>" + key + "<b></td>";
			html += "<td>" + details.get(key) + "</td>";
			html += "</tr>";
		}
		html += "</table>";

		html = html.replaceAll("\\n", "<br>");

		return html;
	}

	/**
	 * @param req
	 * @return
	 */
	public static String printHtmRequest(IEditCommandRequest req) {
		String result = "<ul>";
		result += "<li><b>Request</b>: " + req + "</li>";
		result += "<li><b>Label</b>: " + req.getLabel() + "</li>";
		result += "<li><b>Kind</b>: " + req.getClass().getName() + "</li>";
		result += "<li><b>ElementsToEdit</b>: " + req.getElementsToEdit() + "</li>";
		result += "<li><b>Parameters</b>:</li>";

		if (!req.getParameters().keySet().isEmpty()) {
			result += "<ul>";

			for (Object key : req.getParameters().keySet()) {
				result += "<li><b>" + key + "</b> <-> " + req.getParameters().get(key) + "</li>";
			}
			result += "</ul>";
		}
		result += "<li><b>EditHelperContext</b>: " + req.getEditHelperContext() + "</li>";

		if (req instanceof CreateElementRequest) {
			result += "<li><b>ElementType</b>: " + ((CreateElementRequest) req).getElementType() + "</li>";
			result += "<li><b>Container</b>: " + ((CreateElementRequest) req).getContainer() + "</li>";
			result += "<li><b>ContainmentFeature</b>: " + ((CreateElementRequest) req).getContainmentFeature() + "</li>";
			if (req instanceof CreateRelationshipRequest) {
				result += "<li><b>Source</b>: " + ((CreateRelationshipRequest) req).getSource() + "</li>";
				result += "<li><b>Target</b>: " + ((CreateRelationshipRequest) req).getTarget() + "</li>";
			}
		}
		result += "</ul>";

		return result;
	}
}

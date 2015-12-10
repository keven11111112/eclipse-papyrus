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

package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityParameterNodeExceptionLabelEditPart;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Show and hide exception label edit policy according to {@link Parameter#isException()}
 */
public class ShowHideExceptionEditPolicy extends AbstractShowHideParameterPropertyEditPolicy {

	public static final String KEY = "ShowHideExceptionEditPolicy";

	@Override
	protected void notifyParameter(Notification notification) {
		switch (notification.getFeatureID(Parameter.class)) {
		case UMLPackage.PARAMETER__IS_EXCEPTION:
			refresh();
		}
	}

	@Override
	public void refresh() {
		Parameter parameter = getHostSemantic().getParameter();
		View streamLabel = getLabelView(ActivityParameterNodeExceptionLabelEditPart.VISUAL_ID);

		if (streamLabel != null) {

			if (parameter == null || !parameter.isException()) {
				hideLabelView(streamLabel);
			} else {
				showLabelView(streamLabel);
			}
			getHost().refresh();
		}
	}

}

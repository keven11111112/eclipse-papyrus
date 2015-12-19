/*****************************************************************************
 * Copyright (c) 2015 CEA LIST, Montages AG and others
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Svyatoslav Kovalsky - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.linklf.providers;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.linklf.LinkLFShapeNodeAnchorDelegate;
import org.eclipse.gmf.tooling.runtime.linklf.editparts.LinkLFAnchorsDelegatingEditPart;
import org.eclipse.gmf.tooling.runtime.linklf.editparts.LinkLFConnectionNodeEditPart;
import org.eclipse.gmf.tooling.runtime.linklf.policies.AdjustBorderItemAnchorsEditPolicy;
import org.eclipse.gmf.tooling.runtime.linklf.policies.AdjustImplicitlyMovedLinksEditPolicy;
import org.eclipse.gmf.tooling.runtime.linklf.policies.AdjustSyntheticBendpointsEditPolicy;
import org.eclipse.papyrus.uml.diagram.linklf.policy.graphicalnode.DefaultLinksLFEditPolicy;

public class LinksLFEditPolicyProvider extends AbstractProvider implements
		IEditPolicyProvider, IExecutableExtension {

	public static final String DIAGRAM_NOTATION_CLASS = "org.eclipse.gmf.runtime.notation.Diagram(org.eclipse.gmf.runtime.notation)";

	private String myDiagramID;

	@Override
	public boolean provides(IOperation op) {
		if (false == op instanceof CreateEditPoliciesOperation) {
			return false;
		}
		CreateEditPoliciesOperation operation = (CreateEditPoliciesOperation) op;
		EditPart host = operation.getEditPart();

		if (false == host instanceof IGraphicalEditPart) {
			return false;
		}

		View notationView = ((IGraphicalEditPart) host).getNotationView();
		if (notationView == null) {
			return false;
		}

		Diagram diagram = notationView.getDiagram();
		if (!isSupportedDiagram(diagram)) {
			return false;
		}
		return true;
	}

	private boolean isSupportedDiagram(Diagram diagram) {
		return diagram != null && myDiagramID != null
				&& myDiagramID.equals(diagram.getType());
	}

	@Override
	public void createEditPolicies(EditPart editPart) {
		IGraphicalEditPart graphicalEP = (IGraphicalEditPart) editPart;
		if (graphicalEP instanceof LinkLFConnectionNodeEditPart) {
			installLinkEditPolicies((LinkLFConnectionNodeEditPart) editPart);
		} else if (editPart instanceof INodeEditPart) {
			installNodeEditPolicies((INodeEditPart) editPart);
		}
	}

	protected void installLinkEditPolicies(LinkLFConnectionNodeEditPart linkEP) {
		linkEP.setLinkLFEnabled(true);
	}

	protected void installNodeEditPolicies(INodeEditPart nodeEP) {
		if (nodeEP instanceof LinkLFAnchorsDelegatingEditPart) {
			LinkLFAnchorsDelegatingEditPart linklfEP = (LinkLFAnchorsDelegatingEditPart) nodeEP;
			linklfEP.setAnchorDelegate(new LinkLFShapeNodeAnchorDelegate(
					linklfEP.getNodeFigure()));
		}

		installGraphicalNodeEditPolicy(nodeEP);

		nodeEP.installEditPolicy(AdjustSyntheticBendpointsEditPolicy.ROLE,
				new AdjustSyntheticBendpointsEditPolicy());
		nodeEP.installEditPolicy(AdjustImplicitlyMovedLinksEditPolicy.ROLE,
				new AdjustImplicitlyMovedLinksEditPolicy());
		if (nodeEP instanceof IBorderItemEditPart) {
			nodeEP.installEditPolicy(AdjustBorderItemAnchorsEditPolicy.ROLE,
					new AdjustBorderItemAnchorsEditPolicy());
		}
	}

	protected void installGraphicalNodeEditPolicy(INodeEditPart nodeEP) {
		if (nodeEP.getEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE) != null) {
			nodeEP.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DefaultLinksLFEditPolicy());
		}
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		initFromIConfig(config);
	}

	public void initFromIConfig(IConfigurationElement config) {
		String classAttr = config.getAttribute("class");
		if (DIAGRAM_NOTATION_CLASS.equals(classAttr)) {
			myDiagramID = getValue(config);
		}
		IConfigurationElement[] children = config.getChildren();
		if (children != null) {
			for (IConfigurationElement child : children) {
				initFromIConfig(child);
			}
		}
	}

	private String getValue(IConfigurationElement config) {
		IConfigurationElement methods[] = config.getChildren("method");
		if (methods == null || methods.length != 1) {
			return "";
		}
		IConfigurationElement method = methods[0];
		String value = method.getAttribute("value");
		if (value == null || value.isEmpty()) {
			return "";
		}
		return value;
	}
}

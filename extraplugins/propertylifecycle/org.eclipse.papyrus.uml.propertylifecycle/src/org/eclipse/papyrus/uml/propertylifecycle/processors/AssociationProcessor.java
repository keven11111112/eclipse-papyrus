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

package org.eclipse.papyrus.uml.propertylifecycle.processors;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.propertylifecycle.commands.LifecycleSetCommand;
import org.eclipse.papyrus.propertylifecycle.utils.CommandValueProcessor;
import org.eclipse.papyrus.uml.propertylifecycle.Activator;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;

/**
 *
 */
public class AssociationProcessor implements CommandValueProcessor {

	Association association;

	@Override
	public ICommand setValueFromRequest(String featureLabel, boolean isImmutable, AbstractEditCommandRequest request) {
		return setName(request, isImmutable);
	}

	public AssociationProcessor() {

	}

	public ICommand setName(AbstractEditCommandRequest request, boolean isImmutable) {
		if (isImmutable) {
			Activator.log.trace(Activator.PLCSTRATEGY_TRACE, "isJambon: " + isImmutable);
		} else {
			Activator.log.trace(Activator.PLCSTRATEGY_TRACE, "isJambon: " + isImmutable);
		}
		ICommand gmfCommand = null;

		if (request instanceof ConfigureRequest) {
			ConfigureRequest confRequest = (ConfigureRequest) request;

			association = (Association) confRequest.getElementToConfigure();
			Classifier sourceType = getSourceOwnerType(confRequest);
			Classifier targetType = getTargetOwnerType(confRequest);

			String initializedName = "A_" + sourceType.getName() + "_" + targetType.getName();//$NON-NLS-1$ //$NON-NLS-2$
			EStructuralFeature feature = association.eClass().getEStructuralFeature("name");

			ICommand setCommand = new LifecycleSetCommand("AssociationConfigure", association, feature, initializedName);
			gmfCommand = CompositeCommand.compose(gmfCommand, setCommand);
		}

		if (request instanceof ReorientRelationshipRequest) {
			ReorientRelationshipRequest reorientRequest = (ReorientRelationshipRequest) request;

			association = (Association) reorientRequest.getRelationship();
			EStructuralFeature feature = association.eClass().getEStructuralFeature("name");
			if (association == null || feature == null) {
				return gmfCommand;
			}

			Property sourceProperty = association.getMemberEnds().get(1);
			Property targetProperty = association.getMemberEnds().get(0);
			String initializedName = null;

			if (reorientRequest.getDirection() == ReorientRelationshipRequest.REORIENT_SOURCE) {
				sourceProperty.setName(getReorientOwnerType(reorientRequest).getName().toLowerCase());
				initializedName = "A_" + getReorientOwnerType(reorientRequest).getName() + "_" + targetProperty.getType().getName();
			}
			if (reorientRequest.getDirection() == ReorientRelationshipRequest.REORIENT_TARGET) {
				targetProperty.setName(getReorientOwnerType(reorientRequest).getName().toLowerCase());
				initializedName = "A_" + sourceProperty.getType().getName() + "_" + getReorientOwnerType(reorientRequest).getName();
			}

			// The strategies will be browsed by this setRequest and a command will be constructed in the PropertyProcessor if any match
			ICommand setCommand = new LifecycleSetCommand("AssociationReorient", association, feature, initializedName);
			gmfCommand = CompositeCommand.compose(gmfCommand, setCommand);
		}

		return gmfCommand;
	}


	/**
	 * This method provides the new owner type
	 * 
	 * @param request
	 *            The {@link ConfigureRequest}
	 * @return
	 * 		The Classifier owning the new end or null if none exists
	 */
	protected Classifier getReorientOwnerType(ReorientRelationshipRequest request) {
		Object paramObject = request.getNewRelationshipEnd();
		if (paramObject instanceof Classifier) {
			return (Classifier) paramObject;
		}

		return null;
	}

	/**
	 * This method provides the source type
	 * 
	 * @param request
	 *            The {@link ConfigureRequest}
	 * @return
	 * 		The Classifier owning the new end or null if none exists
	 */
	protected Classifier getSourceOwnerType(ConfigureRequest request) {
		Object paramObject = request.getParameter(CreateRelationshipRequest.SOURCE);
		if (paramObject instanceof Classifier) {
			return (Classifier) paramObject;
		}

		return null;
	}

	/**
	 * This method provides the target type
	 * 
	 * @param request
	 *            The {@link ConfigureRequest}
	 * @return
	 * 		The Classifier owning the new end or null if none exists
	 */
	protected Classifier getTargetOwnerType(ConfigureRequest request) {
		Object paramObject = request.getParameter(CreateRelationshipRequest.TARGET);
		if (paramObject instanceof Classifier) {
			return (Classifier) paramObject;
		}

		return null;
	}

}

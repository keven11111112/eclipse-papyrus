/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.manager.axis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.manager.axis.IIdAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.FeatureIdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.papyrus.uml.nattable.provider.UMLStereotypeRestrictedPropertyContentProvider;
import org.eclipse.papyrus.uml.nattable.utils.Constants;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * This axis manager provides the axis for properties of stereotypes
 *
 * @author Vincent Lorenzo
 *
 */
public class UMLStereotypePropertyAxisManager extends UMLFeatureAxisManager implements IIdAxisManager {

	/**
	 *
	 * @see org.eclipse.papyrus.uml.nattable.manager.axis.UMLFeatureAxisManager#isAllowedContents(java.lang.Object)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public boolean isAllowedContents(Object object) {
		boolean result = false;
		if (object instanceof Property) {
			final Property prop = (Property) object;
			Element owner = prop.getOwner();
			if (owner instanceof Stereotype) {
				while(owner.getOwner() instanceof Package && !result){
					owner = owner.getOwner();
					result = owner instanceof Profile;
				}
				if (result) {
					result = EMFHelper.isReadOnly(prop);
				}
			}
		}
		return result;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getComplementaryAddAxisCommand(TransactionalEditingDomain, java.util.Collection)
	 *
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	@Override
	public Command getComplementaryAddAxisCommand(final TransactionalEditingDomain domain, final Collection<Object> objectToAdd) {
		final Set<Object> propertiesToAdd = getPropertiesToAdd(objectToAdd);
		if (!propertiesToAdd.isEmpty()) {
			return getAddAxisCommand(domain, propertiesToAdd);
		}
		return null;
	}
	
	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.axis.EStructuralFeatureAxisManager#getComplementaryAddAxisCommand(org.eclipse.emf.transaction.TransactionalEditingDomain, java.util.Collection, int)
	 *
	 * @param domain
	 * @param objectToAdd
	 * @param index
	 * @return
	 */
	@Override
	public Command getComplementaryAddAxisCommand(final TransactionalEditingDomain domain, final Collection<Object> objectToAdd, final int index) {
		final Set<Object> propertiesToAdd = getPropertiesToAdd(objectToAdd);
		if (!propertiesToAdd.isEmpty()) {
			return getAddAxisCommand(domain, propertiesToAdd, index);
		}
		return null;
	}

	/**
	 * Get the properties to add.
	 * 
	 * @param objectToAdd The initial objects to add.
	 * @return The properties to add.
	 */
	protected Set<Object> getPropertiesToAdd(final Collection<Object> objectToAdd){
		final Set<Stereotype> appliedStereotypes = new HashSet<Stereotype>();
		for (final Object current : objectToAdd) {
			if (current instanceof Element) {
				appliedStereotypes.addAll(((Element) current).getAppliedStereotypes());
			}
		}
		final Set<Object> propertiesToAdd = new HashSet<Object>();

		for (final Stereotype stereotype : appliedStereotypes) {
			propertiesToAdd.addAll(StereotypeUtil.getAllStereotypePropertiesWithoutBaseProperties(stereotype));
		}
		return propertiesToAdd;
	}
	
	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getAddAxisCommand(TransactionalEditingDomain, java.util.Collection)
	 *
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	@Override
	public Command getAddAxisCommand(final TransactionalEditingDomain domain, final Collection<Object> objectToAdd) {
		Collection<IAxis> toAdd = getAxisToAdd(objectToAdd);
		if(!toAdd.isEmpty()){
			return new AddCommandWrapper(AddCommand.create(domain, getRepresentedContentProvider(), NattableaxisproviderPackage.eINSTANCE.getAxisProvider_Axis(), toAdd), objectToAdd);
		}
		return null;
	}
	
	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.axis.EStructuralFeatureAxisManager#getAddAxisCommand(org.eclipse.emf.transaction.TransactionalEditingDomain, java.util.Collection, int)
	 *
	 * @param domain
	 * @param objectToAdd
	 * @param index
	 * @return
	 */
	@Override
	public Command getAddAxisCommand(final TransactionalEditingDomain domain, final Collection<Object> objectToAdd, final int index) {
		Collection<IAxis> toAdd = getAxisToAdd(objectToAdd);
		if(!toAdd.isEmpty()){
			return new AddCommandWrapper(AddCommand.create(domain, getRepresentedContentProvider(), NattableaxisproviderPackage.eINSTANCE.getAxisProvider_Axis(), toAdd, index), objectToAdd);
		}
		return null;
	}
	
	/**
	 * Get the axis to add from the objects to add.
	 * 
	 * @param objectToAdd The objects to add.
	 * @return The axis to add.
	 */
	protected Collection<IAxis> getAxisToAdd(final Collection<Object> objectToAdd){
		final Collection<IAxis> toAdd = new ArrayList<IAxis>();
		final List<String> allPropertyQN = new ArrayList<String>();
		for (Object object : objectToAdd) {
			if (isAllowedContents(object)) {
				allPropertyQN.add(Constants.PROPERTY_OF_STEREOTYPE_PREFIX + ((NamedElement) object).getQualifiedName());
			}
		}
		allPropertyQN.removeAll(getElements());
		if (!allPropertyQN.isEmpty()) {
			for (String propQN : allPropertyQN) {
				final IdAxis newAxis = NattableaxisFactory.eINSTANCE.createFeatureIdAxis();
				newAxis.setElement(propQN);
				newAxis.setManager(this.representedAxisManager);
				toAdd.add(newAxis);
			}
		}
		return toAdd;
	}


	/**
	 * return the content provider for the stereotypes properties
	 */
	@Override
	public IRestrictedContentProvider createPossibleAxisContentProvider(boolean isRestricted) {
		return new UMLStereotypeRestrictedPropertyContentProvider(this, isRestricted);
	}

	/**
	 *
	 * @see org.eclipse.papyrus.uml.nattable.manager.axis.UMLFeatureAxisManager#getAllPossibleAxis()
	 *
	 * @return
	 */
	@Override
	public Collection<Object> getAllPossibleAxis() {
		return getRootProfiles();
	}

	/**
	 *
	 * @return
	 *         the list of the root profiles availables in the model
	 */
	private Collection<Object> getRootProfiles() {
		EObject context = ((INattableModelManager) getTableManager()).getTable().getContext();
		assert context instanceof Element;

		final List<Profile> allAppliedProfiles = ((Element) context).getNearestPackage().getAllAppliedProfiles();
		final Collection<Object> profiles = new HashSet<Object>();
		for (Profile profile : allAppliedProfiles) {
			EObject rootContainer = EcoreUtil.getRootContainer(profile);
			profiles.add(rootContainer);
		}
		return profiles;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getDestroyAxisCommand(TransactionalEditingDomain, java.util.Collection)
	 *
	 * @param domain
	 * @param umlProperties
	 *            the UML Property for which we want destroy axis
	 * @return
	 */
	@Override
	public Command getDestroyAxisCommand(final TransactionalEditingDomain domain, final Collection<Object> umlProperties) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getRepresentedContentProvider());
		final CompositeCommand compositeCommand = new CompositeCommand("Destroy IAxis Command"); //$NON-NLS-1$
		final List<String> propIdToDestroy = new ArrayList<String>();
		for (final Object current : umlProperties) {
			if (current instanceof Property && ((Property) current).eContainer() instanceof Stereotype) {
				propIdToDestroy.add(Constants.PROPERTY_OF_STEREOTYPE_PREFIX + ((NamedElement) current).getQualifiedName());
			}else if(current instanceof String){
				propIdToDestroy.add((String)current);
			}else if(current instanceof IAxis){
				propIdToDestroy.add(((IAxis) current).getElement().toString());
			}
		}

		for (final IAxis current : getRepresentedContentProvider().getAxis()) {
			if (current instanceof IdAxis) {
				String propId = AxisUtils.getPropertyId(current);
				if (propIdToDestroy.contains(propId)) {
					DestroyElementRequest request = new DestroyElementRequest(domain, current, false);
					compositeCommand.add(provider.getEditCommand(request));
				}
			}
		}

		if (!compositeCommand.isEmpty()) {
			return new RemoveCommandWrapper(new GMFtoEMFCommandWrapper(compositeCommand), umlProperties);
		}
		return null;
	}

	/**
	 *
	 * @param path
	 * @return
	 */
	@Override
	public Object resolvedPath(final String path) {
		if (path.startsWith(Constants.PROPERTY_OF_STEREOTYPE_PREFIX)) {
			return UMLTableUtils.getRealStereotypeProperty(getTableContext(), path);
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.axis.EStructuralFeatureAxisManager#getElementAxisName(org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis)
	 */
	@Override
	public String getElementAxisName(final IAxis axis) {
		String returnedValue = null; // $NON-NLS-1$
		if (axis instanceof FeatureIdAxis) {
			String elementId = ((FeatureIdAxis) axis).getElement();
			final Object resolvedElement = resolvedPath(elementId);
			if (resolvedElement instanceof NamedElement) {
				returnedValue = UMLLabelInternationalization.getInstance().getLabel((NamedElement) resolvedElement);
			} else {
				elementId = elementId.replace(Constants.PROPERTY_OF_STEREOTYPE_PREFIX, ""); //$NON-NLS-1$
				final String[] splitedElementId = elementId.split("::"); //$NON-NLS-1$
				returnedValue = splitedElementId[splitedElementId.length - 1];
			}

		}
		return null != returnedValue ? returnedValue : super.getElementAxisName(axis);
	}

}

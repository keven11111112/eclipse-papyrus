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

package org.eclipse.papyrus.uml.tools.databinding;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.tools.databinding.ReferenceCountedObservable;
import org.eclipse.papyrus.uml.tools.helper.UMLDatabindingHelper;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The multiplicity observable values contains a list of 3 observable values : The first the multiplicity lower and upper value for the 'simple' mode and the 2 following are the lower and the upper value observable value.
 */
public class ExtendedMultiplicityObservableValue extends AbstractObservableValue {

	/**
	 * The number of ObservableValue in the ObservableList.
	 */
	private static final int NUMBER_OBSERVABLE_VALUES = 3;


	/**
	 * The list of observable values for the multiplicity editors (simple mode, lower and upper values)
	 */
	private final List<IObservableValue> observableValues;

	/**
	 * The reference counted observable support.
	 */
	private final ReferenceCountedObservable.Support refCount = new ReferenceCountedObservable.Support(this);
	
	
	/**
	 * Constructor.
	 *
	 * @param eObject
	 *            The object to edit.
	 * @param domain
	 *            The editing domain.
	 */
	public ExtendedMultiplicityObservableValue(final EObject eObject, final EditingDomain domain) {
		observableValues = new ArrayList<IObservableValue>(NUMBER_OBSERVABLE_VALUES);
		observableValues.add(new MultiplicityObservableValue(eObject, domain));

		// Get the lower and upper values features
		final EStructuralFeature lowerValueFeature = UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue();
		final EStructuralFeature upperValueFeature = UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue();

		// Add the ObservableValues
		observableValues.add(UMLDatabindingHelper.getObservableValue(eObject, lowerValueFeature, domain));
		observableValues.add(UMLDatabindingHelper.getObservableValue(eObject, upperValueFeature, domain));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.databinding.observable.value.IObservableValue#getValueType()
	 */
	@Override
	public Object getValueType() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doGetValue()
	 */
	@Override
	protected Object doGetValue() {
		return observableValues;
	}
	
	/**
	 * @see org.eclipse.core.databinding.observable.AbstractObservable#dispose()
	 *
	 */
	@Override
	public synchronized void dispose() {
		for(IObservableValue observableValue : observableValues){
			observableValue.dispose();
		}
		observableValues.clear();
		super.dispose();
	}
	
	/**
	 * This retains the support.
	 */
	public void retain() {
		refCount.retain();
	}

	/**
	 * This releases the support.
	 */
	public void release() {
		refCount.release();
	}

	/**
	 * This auto-relreases the support.
	 */
	public void autorelease() {
		refCount.autorelease();
	}

}

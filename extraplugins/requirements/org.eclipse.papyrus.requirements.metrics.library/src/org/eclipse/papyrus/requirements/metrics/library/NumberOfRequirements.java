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
package org.eclipse.papyrus.requirements.metrics.library;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.omg.smm.Annotation;
import org.omg.smm.Argument;
import org.omg.smm.Attribute;
import org.omg.smm.Characteristic;
import org.omg.smm.MeasureCategory;
import org.omg.smm.MeasureRelationship;
import org.omg.smm.Operation;
import org.omg.smm.ScaleOfMeasurement;
import org.omg.smm.Scope;
import org.omg.smm.SmmFactory;
import org.omg.smm.SmmRelationship;
import org.omg.smm.UnitOfMeasure;

public class NumberOfRequirements extends org.eclipse.papyrus.metrics.extensionpoints.PapyrusNamedMeasure {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.omg.smm.SmmElement#getName()
	 */
	@Override
	public String getName() {
		return "Number of Requirements";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.omg.smm.DimensionalMeasure#getFormula()
	 */
	@Override
	public String getFormula() {
		return "Different ways to do it:\n"
				+ "1. UML::Element.allInstances()->select(e | e.getAppliedStereotype('SysML::Requirements::Requirement')<>null)"
				+ "2. self.ownedElement->select(e | e.getAppliedStereotype('SysML::Requirements::Requirement')<>null)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.omg.smm.Measure#getScope()
	 */
	@Override
	public Scope getScope() {
		// Measurement Scope: The domain (set of entities) to which a given
		// measure may be applied.
		Scope scope = SmmFactory.eINSTANCE.createScope();
		scope.setName("org.eclipse.uml2.uml.Package");
		Operation recognizer = SmmFactory.eINSTANCE.createOperation();
		recognizer.setLanguage("Java");
		recognizer.setBody("Package or Model");
		scope.setRecognizer(recognizer);
		return scope;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.omg.smm.Measure#getDefaultQuery()
	 */
	@Override
	public Operation getDefaultQuery() {
		Operation query = SmmFactory.eINSTANCE.createOperation();
		query.setLanguage("Java");
		query.setBody("countRequirements");
		return query;
	}

	@Override
	public UnitOfMeasure getUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUnit(UnitOfMeasure value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFormula(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getMeasureLabelFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMeasureLabelFormat(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getMeasurementLabelFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMeasurementLabelFormat(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setVisible(boolean value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSource(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDefaultQuery(Operation value) {
		// TODO Auto-generated method stub

	}

	@Override
	public EList<MeasureRelationship> getMeasureRelationships() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<MeasureCategory> getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScope(Scope value) {
		// TODO Auto-generated method stub

	}

	@Override
	public Characteristic getTrait() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTrait(Characteristic value) {
		// TODO Auto-generated method stub

	}

	@Override
	public ScaleOfMeasurement getScale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScale(ScaleOfMeasurement value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getCustomScale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCustomScale(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public EList<Argument> getAllArguments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Argument> getArguments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescription(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setName(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getShortDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setShortDescription(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public EList<SmmRelationship> getInRelationships() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<SmmRelationship> getOutRelationships() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Attribute> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Annotation> getAnnotations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EClass eClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource eResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EObject eContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EReference eContainmentFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<EObject> eContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eIsProxy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EList<EObject> eCrossReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Adapter> eAdapters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub

	}

}

/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.migration.rhapsody.xmi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.papyrus.m2m.qvto.TraceHelper;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RpyUtil;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * @author VL222926
 * 
 * This class allows to reuse Rhapsody id when possible end and calls helper to generate "standart" XMI_ID when we can't reuse Rhapsody ones.
 *
 */
public class PreserveRhapsodySemanticIDHelper {

	/**
	 * The context of the QVTo transformation
	 */
	@SuppressWarnings("restriction")
	private Context context;

	/**
	 * the name of the feature representing the Rhapsody ID
	 */
	private static final String ID_FEATURE_NAME = "id"; //$NON-NLS-1$
	/**
	 * The helper to use to manipulate QVTo trace
	 */
	private TraceHelper helper = new TraceHelper();

	/**
	 * 
	 * Constructor.
	 *
	 * @param context
	 *            the context of the QVTo transformation
	 */
	public PreserveRhapsodySemanticIDHelper(@SuppressWarnings("restriction") final Context context) {
		this.context = context;
	}

	public void keepIdForUMLResource(final XMIResource res) {

		// a set owning the known id to avoid duplicate
		final Set<String> knownIds = new HashSet<String>();

		// the object to manage in the second run
		final List<EObject> eobjectForSecondRun = new ArrayList<>();

		// we mainly set the stereotype application in this list
		final List<EObject> eobjectForThirdRun = new ArrayList<>();

		// we iterate on all elements of the UML model
		final TreeIterator<EObject> iter = res.getAllContents();
		while (iter.hasNext()) {
			final EObject current = iter.next();
			if (isStereotypeApplication(current)) {
				eobjectForThirdRun.add(current);
				continue;
			}
			if (requiredToBeManagedInASecondRun(current)) {
				eobjectForSecondRun.add(current);
				continue;
			}


			// looking for the Rhapsody object in the QVto trace
			final Object result = helper.traceFrom(context, current, null);
			String rpyId = getRhapsodyId(result);

			if (isValidId(rpyId) && false == knownIds.contains(rpyId)) {
				knownIds.add(rpyId);
				res.setID(current, rpyId);
			} else {
				eobjectForSecondRun.add(current);
			}
		}

		// second run (duplicated and null id in the first run)
		for (final EObject current : eobjectForSecondRun) {
			final String value = XMI_ID_Helper.calculateXMI_ID(current);
			if (isValidId(value) && false == knownIds.contains(value)) {
				knownIds.add(value);
				res.setID(current, value);
			} else {
				System.out.println("It is not possible to found an id for " + current.toString()); //$NON-NLS-1$
			}
		}

		// third run (stereotype)
		for (final EObject current : eobjectForThirdRun) {
			final String value = XMI_ID_Helper.calculateXMI_ID(current);
			if (isValidId(value) && false == knownIds.contains(value)) {
				knownIds.add(value);
				res.setID(current, value);
			} else {
				System.out.println("It is not possible to found an id for " + current.toString()); //$NON-NLS-1$
			}
		}
	}

	/**
	 * 
	 * @param eobject
	 *            an eobject
	 * @return
	 * 		<code>true</code> if the object must be manage during the second run
	 */
	protected boolean requiredToBeManagedInASecondRun(final EObject eobject) {
		return eobject instanceof ConnectorEnd;
	}

	/**
	 * 
	 * @param object
	 *            a rhapsody object
	 * @return
	 * 		the id of this object or <code>null</code> if not found
	 */
	protected String getRhapsodyId(final Object object) {
		if (object instanceof EObject) {
			final EObject eobject = (EObject) object;
			final EStructuralFeature idFeature = eobject.eClass().getEStructuralFeature(ID_FEATURE_NAME);
			if (null != idFeature) {
				final String value = (String) eobject.eGet(idFeature);
				return value;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param eobject
	 *            an eobject
	 * @return
	 * 		<code>true</code> when the element represents a stereotype application
	 */
	protected boolean isStereotypeApplication(final EObject eobject) {
		return null != UMLUtil.getBaseElement(eobject);
	}

	/**
	 * 
	 * @param id
	 *            an id
	 * @return
	 * 		<code>true</code> when the string represents a valid id : so it must contains GUID or OLDID
	 */
	public static final boolean isValidId(final String id) {
		return null != id && (id.contains(RpyUtil.GUID_STRING) || id.contains(RpyUtil.OLDID_STRING));
	}

}

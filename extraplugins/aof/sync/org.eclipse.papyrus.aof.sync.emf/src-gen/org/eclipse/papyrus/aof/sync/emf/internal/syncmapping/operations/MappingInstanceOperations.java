/**
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 */
package org.eclipse.papyrus.aof.sync.emf.internal.syncmapping.operations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.aof.core.utils.ObserverTracker;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.IMappingInstance;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingModel;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Mapping Instance</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#addConsequent(org.eclipse.papyrus.aof.sync.IMappingInstance) <em>Add Consequent</em>}</li>
 * <li>{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#destroy() <em>Destroy</em>}</li>
 * <li>{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#iterator() <em>Iterator</em>}</li>
 * <li>{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#eBasicSetContainer(org.eclipse.emf.ecore.InternalEObject) <em>EBasic Set Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingInstanceOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected MappingInstanceOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static <F, T> void addConsequent(MappingInstance<F, T> mappingInstance, IMappingInstance<?, ?> consequent) {
		mappingInstance.getConsequents().add(consequent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static <F, T> void destroy(MappingInstance<F, T> mappingInstance) {
		ObserverTracker tracker = mappingInstance.getTracker();
		if (tracker != null) {
			tracker.dispose();
			mappingInstance.setTracker(null);
		}
		mappingInstance.forEach(IMappingInstance::destroy);

		if (mappingInstance.eContainer() instanceof MappingModel) {
			EcoreUtil.remove(mappingInstance);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static <F, T> Iterator<IMappingInstance<?, ?>> iterator(MappingInstance<F, T> mappingInstance) {
		return mappingInstance.getConsequents().iterator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static <F, T> void eBasicSetContainer(MappingInstance<F, T> mappingInstance, InternalEObject newContainer) {
		EObject oldContainer = mappingInstance.eContainer();

		if (!(newContainer instanceof MappingModel) && (oldContainer instanceof MappingModel)) {
			mappingInstance.destroy();
		} else if ((newContainer instanceof MappingModel) && !(oldContainer instanceof MappingModel)
				&& (mappingInstance.getTracker() == null)) {

			// If I am being (re-)added to a mapping model, run the mapping.
			// Undo typically adds us to a ChangeDescription. Don't run the mapping in that case!
			F from = mappingInstance.getLeft().get();
			T to = mappingInstance.getRight().get();
			IMapping<F, T> type = mappingInstance.getType();
			MappingInstance<F, T> newInstance = (MappingInstance<F, T>) type.map(from, to);

			// Grab its tracker and other details
			mappingInstance.setTracker(newInstance.getTracker());
			List<IMappingInstance<?, ?>> consequents = new ArrayList<>(newInstance.getConsequents());
			ECollections.setEList(mappingInstance.getConsequents(), consequents);
		}
	}

} // MappingInstanceOperations

/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.aof.sync.examples.uml.internal;

import static org.eclipse.papyrus.infra.tools.util.StreamUtil.select;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.aof.sync.MappingFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.sync.spi.AOFSyncDelegate;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A synchronization delegate that discovers and installs synchronization
 * mappings automatically on <tt>&lt;&lt;capsule&gt;&gt;</tt> classes.
 */
public class CapsuleSyncDelegate extends AOFSyncDelegate {

	public CapsuleSyncDelegate() {
		super();
	}

	@Override
	public String getID() {
		return Activator.PLUGIN_ID + ".capsuleSync";
	}

	@Override
	protected MappingFactory createMappingFactory(ServicesRegistry serviceRegistry) {
		return new UMLRTMappingFactory(() -> {
			try {
				return serviceRegistry.getService(TransactionalEditingDomain.class);
			} catch (ServiceException e) {
				Activator.log.error("Failed to get editing domain service.", e);
				return null;
			}
		});
	}

	@Override
	protected void doDiscoverInitialSynchronizations(Iterable<?> scope) {
		visitor(scope).addVisitor(UMLPackage.Literals.CLASS, this::discoverCapsule)
				.walkModel();
	}

	protected void discoverCapsule(Class class_) {
		if (isCapsule(class_)) {
			select(class_.getTargetDirectedRelationships().stream(), Generalization.class)
					.map(Generalization::getSpecific)
					.filter(CapsuleSyncDelegate::isCapsule)
					.forEach(specific -> synchronize(class_, specific));
		}
	}

	static boolean isCapsule(Classifier classifier) {
		return classifier.getAppliedStereotype("sync-example::Capsule") != null;
	}
}

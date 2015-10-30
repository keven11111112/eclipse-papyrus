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

package org.eclipse.papyrus.aof.sync.examples.uml.ui.internal;

import static org.eclipse.papyrus.aof.sync.examples.uml.ui.internal.StateMachineDiagramMappingModule.isInStateMachineDiagram;

import java.util.Objects;
import java.util.stream.Stream;

import javax.inject.Provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.aof.gmf.util.ViewUtil;
import org.eclipse.papyrus.aof.sync.MappingFactory;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.UMLRTMappingModule;
import org.eclipse.papyrus.aof.sync.gmf.DiagramMappingFactory;
import org.eclipse.papyrus.aof.sync.gmf.DiagramMappingModule;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.sync.spi.AOFSyncDelegate;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.StateMachine;

import com.google.inject.util.Modules;

/**
 * A synchronization delegate that discovers and installs synchronization
 * mappings automatically on <tt>&lt;&lt;capsule&gt;&gt;</tt> classes' state machine
 * diagrams for the state machine that is the capsule behaviour.
 */
public class DiagramSyncDelegate extends AOFSyncDelegate {

	public DiagramSyncDelegate() {
		super();
	}

	@Override
	public String getID() {
		return Activator.PLUGIN_ID + ".diagramSync";
	}

	@Override
	protected MappingFactory createMappingFactory(ServicesRegistry serviceRegistry) {
		Provider<EditingDomain> editingDomainProvider = () -> ServiceUtils.getInstance().getService(TransactionalEditingDomain.class, serviceRegistry, null);

		return new DiagramMappingFactory(
				Modules.override(new DiagramMappingModule(editingDomainProvider))
						.with(Modules.override(new UMLRTMappingModule(editingDomainProvider))
								.with(new StateMachineDiagramMappingModule())));
	}

	@Override
	public boolean canSynchronize(Object source, Object target) {
		boolean result = super.canSynchronize(source, target);

		if (result && (source instanceof Diagram) && (target instanceof Diagram)) {
			// Only synchronize diagrams of the same type that have corresponding
			// semantic elements
			Diagram sourceDiagram = (Diagram) source;
			Diagram targetDiagram = (Diagram) target;

			result = Objects.equals(sourceDiagram.getType(), targetDiagram.getType()) &&
					// Does the target correspond to the source?
					correspond(targetDiagram, sourceDiagram);
		}

		return result;
	}

	boolean correspond(View sourceView, View targetView) {
		ViewUtil util = getMappingFactory().getInstance(ViewUtil.class);

		return util.getSemanticCorrespondence().test(sourceView, targetView);
	}

	@Override
	protected void doDiscoverInitialSynchronizations(Iterable<?> scope) {
		visitor(scope).addVisitor(NotationPackage.Literals.DIAGRAM, this::discoverCapsuleStateMachineDiagram)
				.walkModel();
	}

	protected void discoverCapsuleStateMachineDiagram(Diagram diagram) {
		supercapsuleSMDs(diagram).forEach(redefined -> synchronize(redefined, diagram));
	}

	static Stream<Diagram> supercapsuleSMDs(Diagram diagram) {
		Stream<Diagram> result;

		if (!isCapsuleStateMachineDiagram(diagram)) {
			result = Stream.empty();
		} else {
			StateMachine machine = (StateMachine) diagram.getElement();
			result = machine.getExtendedStateMachines().stream()
					.flatMap(DiagramSyncDelegate::diagrams)
					.filter(DiagramSyncDelegate::isCapsuleStateMachineDiagram);
		}

		return result;
	}

	static boolean isCapsuleStateMachineDiagram(Diagram diagram) {
		boolean result = false;

		// Firstly, is it a state machine diagram?
		if (isInStateMachineDiagram(diagram) && (diagram.getElement() instanceof StateMachine)) {
			// And is it the classifier behavior of a capsule?
			StateMachine machine = (StateMachine) diagram.getElement();
			BehavioredClassifier context = machine.getContext();

			result = isCapsule(context) && (context.getClassifierBehavior() == machine);
		}

		return result;
	}

	static boolean isCapsule(Classifier classifier) {
		return (classifier != null)
				&& (classifier.getAppliedStereotype("sync-example::Capsule") != null);
	}

	static Stream<Diagram> diagrams(EObject element) {
		return ECrossReferenceAdapter.getCrossReferenceAdapter(element).getNonNavigableInverseReferences(element).stream()
				.filter(setting -> setting.getEStructuralFeature() == NotationPackage.Literals.VIEW__ELEMENT)
				.filter(setting -> setting.getEObject() instanceof Diagram)
				.map(setting -> (Diagram) setting.getEObject());
	}
}

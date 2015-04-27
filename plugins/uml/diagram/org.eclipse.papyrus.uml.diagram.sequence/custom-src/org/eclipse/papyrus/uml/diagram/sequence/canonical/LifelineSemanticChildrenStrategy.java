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

package org.eclipse.papyrus.uml.diagram.sequence.canonical;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.canonical.DefaultUMLSemanticChildrenStrategy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.MessageEnd;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Custom semantic-children strategy for lifelines in sequence diagrams.
 */
public class LifelineSemanticChildrenStrategy extends DefaultUMLSemanticChildrenStrategy {

	public LifelineSemanticChildrenStrategy() {
		super();
	}

	@Override
	public List<? extends EObject> getCanonicalSemanticChildren(EObject semanticFromEditPart, View viewFromEditPart) {
		List<? extends EObject> _result;

		if (semanticFromEditPart instanceof Lifeline) {
			// Get the execution specifications covering it
			Lifeline lifeline = (Lifeline) semanticFromEditPart;

			List<EObject> result = Lists.newArrayList();
			_result = result;

			Iterables.addAll(result, Iterables.filter(lifeline.getCoveredBys(), ExecutionSpecification.class));
		} else {
			_result = super.getCanonicalSemanticChildren(semanticFromEditPart, viewFromEditPart);
		}

		return _result;
	}

	@Override
	public List<? extends EObject> getCanonicalSemanticConnections(EObject semanticFromEditPart, View viewFromEditPart) {
		// Lifelines are responsible for the messages connected to them via message-ends
		List<? extends EObject> result = null;

		Lifeline lifeline = (semanticFromEditPart instanceof Lifeline) ? (Lifeline) semanticFromEditPart : null;
		if (lifeline != null) {
			List<Element> messages = Lists.newArrayList();
			result = messages;

			for (MessageEnd next : Iterables.filter(lifeline.getCoveredBys(), MessageEnd.class)) {
				if (next.getMessage() != null) {
					messages.add(next.getMessage());
				}
			}
		}

		return result;
	}
}

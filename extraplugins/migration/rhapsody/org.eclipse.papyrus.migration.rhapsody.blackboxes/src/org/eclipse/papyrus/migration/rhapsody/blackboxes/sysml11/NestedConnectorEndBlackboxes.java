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

package org.eclipse.papyrus.migration.rhapsody.blackboxes.sysml11;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * This blackbox allows to calculate NestedConnectorEnd value
 *
 */
public class NestedConnectorEndBlackboxes {

	/**
	 * 
	 * @param connectorEnd
	 *            a connector End
	 * @return
	 * 		<code>true</code> if the connector end must be stereotyped NestedConnectorEnd
	 */
	@Operation(kind = Kind.HELPER)
	public boolean isNestedConnectorEndStereotypeRequired(final ConnectorEnd connectorEnd) {
		return null != getNestedConnectorEndPropertyPath(connectorEnd) && getNestedConnectorEndPropertyPath(connectorEnd).size() > 0;
	}

	/**
	 * 
	 * @param connectorEnd
	 *            a connector End
	 * @return
	 * 		The property path value to set to the stereotype NestedConnectorEnd
	 */
	@Operation(kind = Kind.HELPER)
	public List<Property> getNestedConnectorEndPropertyPath(final ConnectorEnd connectorEnd) {
		final Connector connector = (Connector) connectorEnd.getOwner();
		final Classifier connectorOwner = (Classifier) connector.getOwner();
		final List<Property> path = getPath(connectorOwner, (Property) connectorEnd.getRole());

		if (path.size() == 1) {
			path.clear();
		} else if (path.size() == 2) {
			final NamedElement first = (NamedElement) path.get(0);
			final NamedElement second = (NamedElement) path.get(1);
			if (second instanceof Port && first instanceof Property) {
				path.clear();
			}
		} else if (!path.isEmpty()) {
			path.remove(path.size() - 1);
		}
		return path;
	}

	/**
	 * 
	 * @param connectorOwner
	 *            the owner of a given connector
	 * @param roleOfTheConnectorEnd
	 *            the role of a ConnectorEnd of the given Connector
	 * @return
	 * 		the full path to navigate from the connector to the connector end, including roleOfTheConnectorEnd itself
	 */
	private List<Property> getPath(Classifier connectorOwner, final Property roleOfTheConnectorEnd) {
		final List<Property> path = new ArrayList<Property>();
		final List<Property> allAtributtes = connectorOwner.getAllAttributes();
		for (int i = 0; i < allAtributtes.size(); i++) {
			final Property current = allAtributtes.get(i);
			if (current == roleOfTheConnectorEnd) {
				path.add(current);
				break;
			}
		}
		if (path.size() == 0) {
			for (int i = 0; i < allAtributtes.size(); i++) {
				final Property current = allAtributtes.get(i);
				final Type type = current.getType();
				if (type instanceof Classifier) {
					List<Property> tmpPath = getPath((Classifier) type, roleOfTheConnectorEnd);
					if (tmpPath.size() > 0) {
						tmpPath.add(0, current);
						path.addAll(tmpPath);
						break;
					}
				}
			}
		}
		return path;
	}

	/**
	 * 
	 * @param eobject
	 *            an EObejct
	 * @return
	 * 		the list of all connectors owned directly and in sub-elements by this eobject
	 */
	public List<ConnectorEnd> getAllConnectorEnds(final Element eobject) {
		final TreeIterator<EObject> iter = eobject.eAllContents();
		final List<ConnectorEnd> connectors = new ArrayList<ConnectorEnd>();
		while (iter.hasNext()) {
			final EObject current = iter.next();
			if (current instanceof ConnectorEnd) {
				connectors.add((ConnectorEnd) current);
			}
		}
		return connectors;
	}
}

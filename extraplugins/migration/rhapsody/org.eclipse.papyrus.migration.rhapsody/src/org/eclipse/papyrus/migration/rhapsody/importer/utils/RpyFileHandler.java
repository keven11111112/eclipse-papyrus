/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sebastien Revol (CEA LIST) sebastien.revol@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.migration.rhapsody.importer.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyContent;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNode;


/**
 * @author sr246418
 *
 */
public class RpyFileHandler {

	private Map<String, RpyNode> idToNodeMap = new HashMap<String, RpyNode>();
	private RpyFile rpyFile;
	private RpyProjectHandler project;

	public URI getURI() {
		if (rpyFile != null && rpyFile.eResource() != null) {
			return rpyFile.eResource().getURI();
		}
		return null;
	}

	public RpyFile getRpyFile() {
		return rpyFile;
	}

	public RpyFileHandler(Resource resource, RpyProjectHandler project) {
		this.project = project;
		if (resource != null && !resource.getContents().isEmpty() && resource.getContents().get(0) instanceof RpyFile) {
			rpyFile = (RpyFile) resource.getContents().get(0);
		}


		// initialize ID to Node Map
		Iterator<EObject> iterator = rpyFile.eAllContents();
		while (iterator.hasNext()) {
			EObject obj = iterator.next();
			if (obj instanceof RpyNode) {
				RpyNode node = (RpyNode) obj;
				String id = RpyUtil.getID(node);
				if (id != null) {
					idToNodeMap.put(id, node);
				}
			}

		}
	}

	/**
	 * 
	 * @return
	 */
	public List<RpyContent> getContents() {
		return rpyFile.getContents();
	}

	/**
	 * @param id
	 * @return
	 */
	public RpyNode getNodeById(String id) {
		return idToNodeMap.get(id);
	}
}

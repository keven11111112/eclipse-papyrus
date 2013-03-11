/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core.resource;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler2;

import com.google.common.base.Optional;

/**
 * This is the CDOReadOnlyHandler type. Enjoy.
 */
public class CDOReadOnlyHandler
		implements IReadOnlyHandler2 {

	public CDOReadOnlyHandler() {
		super();
	}

	public boolean handlesURIs(URI[] uris, EditingDomain editingDomain) {
		boolean result = false;

		if ((uris.length > 0) && CDOUtils.isCDOEditingDomain(editingDomain)) {
			for (int i = 0; !result && (i < uris.length); i++) {
				if (CDOUtils.isCDOURI(uris[i])) {
					result = true;
				}
			}
		}

		return result;
	}

	public Optional<Boolean> anyReadOnly(URI[] uris, EditingDomain editingDomain) {
		Optional<Boolean> result = Optional.absent();

		if ((uris.length > 0) && CDOUtils.isCDOEditingDomain(editingDomain)) {
			for (int i = 0; !result.or(Boolean.FALSE) && (i < uris.length); i++) {
				// if it's a cdo:// URI, then I have a definitive answer
				if (CDOUtils.isCDOURI(uris[i])) {
					result = Optional.of(isReadOnly(uris[i], editingDomain));
				}
			}
		}

		return result;
	}

	protected boolean isReadOnly(URI uri, EditingDomain domain) {
		boolean result = false;

		Resource resource = domain.getResourceSet().getResource(uri, false);
		if (resource instanceof CDOObject) {
			result = CDOUtils.isReadOnly((CDOObject) resource);
		}

		return result;
	}

	public Optional<Boolean> isReadOnly(EObject eObject,
			EditingDomain editingDomain) {

		Optional<Boolean> result = Optional.absent();

		Resource resource = eObject.eResource();
		if ((resource == null) || CDOUtils.isCDOURI(resource.getURI())) {
			CDOObject cdo = CDOUtils.getCDOObject(eObject);
			if (cdo != null) {
				// I have a definitive answer for CDO objects
				result = Optional.of(CDOUtils.isReadOnly(cdo));
			}
		}

		return result;
	}

	public Optional<Boolean> makeWritable(URI[] uris,
			EditingDomain editingDomain) {

		// CDO requires the administrative UI to edit user permissions
		return Optional.absent();
	}

	public Optional<Boolean> makeWritable(EObject eObject,
			EditingDomain editingDomain) {

		// CDO requires the administrative UI to edit user permissions
		return Optional.absent();
	}
}

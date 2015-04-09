package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.util.ExpansionmodelResourceImpl;

/**
 * Overrides default generated resource to use uuids instead of index
 */
public class CustomExpansionmodelResource extends ExpansionmodelResourceImpl {
	/**
	 * Creates an instance of the resource.
	 *
	 * @param uri
	 *            the URI of the new resource.
	 */
	public CustomExpansionmodelResource(URI uri) {
		super(uri);
	}

	@Override
	protected boolean useUUIDs() {
		return true;
	}

}
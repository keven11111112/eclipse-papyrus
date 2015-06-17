/*****************************************************************************
 * Copyright (c) 2011 LIFL & CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.common.modelresource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource;
import org.eclipse.papyrus.infra.core.resource.BadArgumentExcetion;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;



/**
 * A model used to save data from the {@link DefaultNattableEditor}
 *
 * @author cedric dumoulin
 *
 */
public class PapyrusNattableModel extends AbstractModelWithSharedResource<Table> implements IModel {

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.infra.nattable.resource.NattableModel"; //$NON-NLS-1$

	/**
	 * the file extension where table are stored
	 */
	public static final String TABLE_MODEL_FILE_EXTENSION = NotationModel.NOTATION_FILE_EXTENSION;

	/**
	 *
	 * Constructor.
	 *
	 */
	public PapyrusNattableModel() {

	}

	// Initialize stuff in the model.
	@Override
	public void init(ModelSet modelManager) {
		super.init(modelManager);
		// nothing to do now
	}

	/**
	 * Get the file extension used for this model.
	 *
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getModelFileExtension()
	 *
	 * @return
	 */
	@Override
	protected String getModelFileExtension() {
		return TABLE_MODEL_FILE_EXTENSION;
	}

	/**
	 * Get the identifier used to register this model.
	 *
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getIdentifier()
	 *
	 * @return
	 */
	@Override
	public String getIdentifier() {
		return MODEL_ID;
	}

	/**
	 * Add a new initialized {@link PapyrusTableInstance} to the model.
	 *
	 * @param tableInstance
	 *            The tableInstance to add.
	 */
	public void addPapyrusTable(Table tableInstance) {
		EObject context = tableInstance.getContext();
		if (context != null) { // we check the resource for control mode feature
			Resource targetResource;
			Resource contextResource = context.eResource();
			if (!contextResource.getURI().trimFileExtension().equals(getResource().getURI().trimFileExtension())) {
				URI uri = contextResource.getURI();
				uri = uri.trimFileExtension();
				uri = uri.appendFileExtension(getModelFileExtension());
				ResourceSet set = contextResource.getResourceSet();
				targetResource = set.getResource(uri, true);
			} else {
				targetResource = getResource();
			}
			if (targetResource != null) {
				targetResource.getContents().add(tableInstance);
			}
		}

		// it doesn't work when we call this method from the Create Project/Model wizard, because the file is not yet in the workspace
		// see bug 470299: [Table] impossible to create new table from the creation wizard https://bugs.eclipse.org/bugs/show_bug.cgi?id=470299
		// try {
		// TransactionalEditingDomain editingDomain = ServiceUtilsForResourceSet.getInstance().getTransactionalEditingDomain(modelSet);
		// Resource notationResource = NotationUtils.getNotationResourceForDiagram(tableInstance.getContext(), editingDomain);
		// if (notationResource != null) {
		// notationResource.getContents().add(tableInstance);
		// }
		// } catch (ServiceException ex) {
		// Activator.log.error(ex);
		// }
	}

	/**
	 * Add a new initialized {@link PapyrusTableInstance} to the model.
	 *
	 * @param tableInstance
	 *            The tableInstance to add.
	 */
	public void removeTable(Table tableInstance) {
		if (tableInstance.eResource() != null) {
			tableInstance.eResource().getContents().remove(tableInstance);
		}
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#isModelRoot(org.eclipse.emf.ecore.EObject)
	 *
	 * @param object
	 * @return
	 */
	@Override
	protected boolean isModelRoot(EObject object) {
		return object instanceof Table;
	}

	/**
	 * Get a table by its name.
	 *
	 * @param tableName
	 *            Name of the table. This is the name set by the user.
	 * @return
	 * @throws NotFoundException
	 * @throws BadArgumentExcetion
	 */
	public Table getTable(String tableName) throws NotFoundException, BadArgumentExcetion {

		if (tableName == null || tableName.length() == 0) {
			throw new BadArgumentExcetion("Table name should not be null and size should be >0."); //$NON-NLS-1$
		}

		for (EObject element : getResource().getContents()) {
			if (element instanceof Table) {
				Table table = (Table) element;

				if (tableName.equals(table.getName())) {
					// Found
					return table;

				}
			}
		}
		// not found
		throw new NotFoundException(NLS.bind("No Table named '{0}' can be found in Model.", tableName)); //$NON-NLS-1$
	}

}

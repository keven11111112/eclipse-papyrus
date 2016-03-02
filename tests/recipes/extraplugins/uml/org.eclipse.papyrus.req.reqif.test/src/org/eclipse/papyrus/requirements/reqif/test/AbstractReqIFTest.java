/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.requirements.reqif.test;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.rmf.reqif10.ReqIF;
import org.osgi.framework.Bundle;

public abstract class AbstractReqIFTest extends AbstractEditorTest {

	protected ReqIF importedReqIFModel = null;

	protected TransactionalEditingDomain domain = null;

	protected static final String PLUGIN_NAME = "org.eclipse.papyrus.requirements.reqif.test";

	public AbstractReqIFTest() {
		super();
	}

	public void openDiagram(IMultiDiagramEditor editor, final String name) {
		try {
			ModelSet modelSet = ServiceUtils.getInstance().getModelSet(editor.getServicesRegistry());
			NotationModel notation = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
			domain = modelSet.getTransactionalEditingDomain();
			Diagram diagram = notation.getDiagram(name);
			ServiceUtils.getInstance().getIPageManager(editor.getServicesRegistry()).openPage(diagram);
			flushDisplayEvents();
		} catch (Exception e) {
			throw new IllegalStateException("Cannot initialize test", e);
		}
	}

	public void getReqIFFile(String ReqIFName) throws CoreException, IOException {
		//final IFile reqifFile = PapyrusProjectUtils.copyIFile(getSourcePath(), getBundle(), project, ReqIFName);
		//final IFile createdFile = targetProject.getFile(targetFileName);
		ResourceSet resourceSet = Util.createTemporaryResourceSet();
		Resource reqIFResource = resourceSet.getResource(URI.createPlatformPluginURI(PLUGIN_NAME + "/" + getSourcePath() + ReqIFName, true), true);
		if(reqIFResource.getContents().size() > 0) {
			if(reqIFResource.getContents().get(0) instanceof ReqIF) {
				importedReqIFModel = (ReqIF)reqIFResource.getContents().get(0);
			}
		}
	}

	@Override
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}
}

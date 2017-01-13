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

package org.eclipse.papyrus.migration.rhapsody.tests.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.migration.rhapsody.tests.tests.EMFCompareUtils;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author VL222926
 *
 */
public class CompareAsPapyrusJUnitHandler extends AbstractHandler {

	

	private static final String MATCHES = "matches"; //$NON-NLS-1$

	private static final String DIFFERENCES = "differences"; //$NON-NLS-1$

	private static final String CONFLICTS = "conflicts"; //$NON-NLS-1$

	private static final String COMPARISON = "comparison"; //$NON-NLS-1$

	private static final String DIFF_RESULT_FOLDER = "diffResult"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final List<URI> selectedFiles = getSelectedFileURIs(event);
		if (selectedFiles.size() == 2) {

			final URI currentVersionURI = selectedFiles.get(0);
			final URI expectedVersionURI = selectedFiles.get(1);
			final EMFCompare compare = EMFCompareUtils.createEMFCompare();
			final ResourceSet left = new ResourceSetImpl();
			final ResourceSet right = new ResourceSetImpl();

			left.getResource(currentVersionURI, true); // the first one is the edited model
			right.getResource(expectedVersionURI, true); // the second one is the expected model
			final IComparisonScope scope = new DefaultComparisonScope(left, right, null);
			final Comparison comparison = compare.compare(scope);

			URI baseURI = currentVersionURI.trimFileExtension();
			String lastSeg = baseURI.lastSegment();
			baseURI = baseURI.appendSegment(DIFF_RESULT_FOLDER);
			baseURI = baseURI.appendSegment(lastSeg);
			saveResult(baseURI, comparison);
		}
		return null;
	}

	protected void saveResult(final URI baseURI, final Comparison comparison) {
		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put(DIFFERENCES, new XMIResourceFactoryImpl());
		m.put(COMPARISON, new XMIResourceFactoryImpl());
		m.put(MATCHES, new XMIResourceFactoryImpl());
		m.put(CONFLICTS, new XMIResourceFactoryImpl());

		final ResourceSet savedSet = new ResourceSetImpl();

		final URI comparisonURI = baseURI.appendFileExtension(COMPARISON);
		final URI differencesURI = baseURI.appendFileExtension(DIFFERENCES);
		final URI conflictsURI = baseURI.appendFileExtension(CONFLICTS);
		final URI matchesURI = baseURI.appendFileExtension(MATCHES);

		final Resource comparisonResource = savedSet.createResource(comparisonURI);
		final Resource differencesResource = savedSet.createResource(differencesURI);
		final Resource conflictsResource = savedSet.createResource(conflictsURI);
		final Resource matchesResource = savedSet.createResource(matchesURI);


		comparisonResource.getContents().add(comparison);

		EcoreUtil.copy(comparison);
		differencesResource.getContents().addAll(EcoreUtil.copy(comparison).getDifferences());
		conflictsResource.getContents().addAll(EcoreUtil.copy(comparison).getConflicts());
		matchesResource.getContents().addAll(EcoreUtil.copy(comparison).getMatches());

		for (Resource current : savedSet.getResources()) {
			try {
				current.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 *
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		// TODO Auto-generated method stub
		super.setEnabled(evaluationContext);
	}

	/**
	 * 
	 * @param event
	 * @return
	 * 		an empty list or a list with 2 URI. The first one should be the current version of the file and the second one should be the expected version of the file
	 * 
	 */
	protected List<URI> getSelectedFileURIs(final ExecutionEvent event) {
		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		final List<URI> selectedURI = new ArrayList<>();
		if (selection instanceof IStructuredSelection) {
			List<?> selectedElement = ((IStructuredSelection) selection).toList();
			if (selectedElement.size() == 2) {
				final Object element1 = selectedElement.get(0);
				final Object element2 = selectedElement.get(1);
				if (element1 instanceof IAdaptable) {
					final IFile file = ((IAdaptable) element1).getAdapter(IFile.class);
					URI uri = getUMLFileURI(file);
					if (uri != null) {
						selectedURI.add(uri);
					}
				}
				if (element2 instanceof IAdaptable) {
					final IFile file = ((IAdaptable) element2).getAdapter(IFile.class);
					URI uri = getUMLFileURI(file);
					if (uri != null) {
						selectedURI.add(uri);
					}
				}
			}
		}
		if (selectedURI.size() != 2) {
			selectedURI.clear();
		}
		return selectedURI;
	}


	/**
	 * 
	 * @param file
	 *            an ifile, must not be null
	 * @return
	 * 		the file URI in case of uml file and <code>null</code> in other case
	 */
	protected URI getUMLFileURI(final IFile file) {
		String path = file.getFullPath().toPortableString();
		URI uri = URI.createURI(path);
		if ("uml".equals(uri.fileExtension())) { //$NON-NLS-1$
			return uri;
		}
		return null;
	}

}

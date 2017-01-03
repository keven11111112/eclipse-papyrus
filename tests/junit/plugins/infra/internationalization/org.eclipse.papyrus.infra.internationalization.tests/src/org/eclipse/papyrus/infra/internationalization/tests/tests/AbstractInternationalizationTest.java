/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.internationalization.tests.tests;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.internationalization.tests.Activator;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest;
import org.eclipse.papyrus.views.modelexplorer.DecoratingLabelProviderWTooltips;
import org.junit.Assert;
import org.junit.Before;

/**
 * This allows to define the abstract class for the internationalization tests.
 */
@SuppressWarnings({ "nls", "restriction" })
public abstract class AbstractInternationalizationTest extends AbstractEditorTest {

	/** The label provider. */
	protected DecoratingLabelProviderWTooltips labelProvider;

	/** The existing diagram. */
	protected Diagram diagram;

	/** The existing table. */
	protected Table table;

	/**
	 * Constructor.
	 */
	public AbstractInternationalizationTest() {
		super();
	}

	/**
	 * Initialize the model.
	 * 
	 * @throws Exception
	 *             The caught exception.
	 */
	@Before
	public void initTest() throws Exception {
		initModel("testLabels", "internationalizationModel", Activator.getDefault().getBundle());

		labelProvider = (DecoratingLabelProviderWTooltips) getModelExplorerView().getCommonViewer().getLabelProvider();
		
		for(Object object : getPageManager().allPages()){
			if(object instanceof Table){
				table = (Table) object;
			}else if(object instanceof Diagram){
				diagram = (Diagram) object;
			}
		}
	}

	/**
	 * This allows to test the labels when the internationalization is not used.
	 * 
	 * @throws Exception
	 *             The caught exception.
	 */
	public void checkNoLabels() throws Exception {
		Assert.assertEquals("The diagram label is not the expected one.", "Diagram ClassDiagram",
				labelProvider.getText(diagram));

		Assert.assertEquals("The table label is not the expected one.", "Table GenericTable0", labelProvider.getText(table));
	}

	/**
	 * This allows to test the french labels of all initial existing objects.
	 * 
	 * @throws Exception
	 *             The caught exception.
	 */
	public void checkFrenchLabels() throws Exception {
		Assert.assertEquals("The diagram label is not the expected one.", "Diagram MonDiagrammeDeClasse",
				labelProvider.getText(diagram));

		Assert.assertEquals("The table label is not the expected one.", "Table MaTableGenerique",
				labelProvider.getText(table));
	}

	/**
	 * This allows to test the english labels of all initial existing objects.
	 * 
	 * @throws Exception
	 *             The caught exception.
	 */
	public void checkEnglishLabels() throws Exception {
		Assert.assertEquals("The diagram label is not the expected one.", "Diagram MyClassDiagram",
				labelProvider.getText(diagram));

		Assert.assertEquals("The table label is not the expected one.", "Table MyGenericTable", labelProvider.getText(table));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest#getSourcePath()
	 */
	@Override
	protected String getSourcePath() {
		return "resources/";
	}
}

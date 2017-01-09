/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.internationalization.controlmode.tests.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeManager;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.uml.internationalization.tests.tests.AbstractUMLInternationalizationTest;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Element;
import org.junit.Assert;

/**
 * The abstract class for the internationalization control mode tests.
 */
@SuppressWarnings("nls")
public abstract class AbstractInternationalizationControlModeTest extends AbstractUMLInternationalizationTest {

	/** The existing diagram. */
	protected Diagram diagram;

	/** The existing table. */
	protected Table table;

	/**
	 * Constructor.
	 */
	public AbstractInternationalizationControlModeTest() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.internationalization.tests.tests.AbstractUMLInternationalizationTest#initTest()
	 */
	@Override
	public void initTest() throws Exception {
		super.initTest();

		for (Object object : fixture.getPageManager().allPages()) {
			if (object instanceof Table) {
				table = (Table) object;
			} else if (object instanceof Diagram) {
				diagram = (Diagram) object;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.internationalization.tests.tests.AbstractUMLInternationalizationTest#checkNoLabels()
	 */
	@Override
	public void checkNoLabels() throws Exception {
		super.checkNoLabels();

		Assert.assertEquals("The root element label is not the expected one.", "Diagram ClassDiagram",
				labelProvider.getText(diagram));

		Assert.assertEquals("The class label is not the expected one.", "Table GenericTable0",
				labelProvider.getText(table));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.internationalization.tests.tests.AbstractUMLInternationalizationTest#checkFrenchLabels()
	 */
	@Override
	public void checkFrenchLabels() throws Exception {
		super.checkFrenchLabels();

		Assert.assertEquals("The diagram label is not the expected one.", "Diagram MonDiagrammeDeClasse",
				labelProvider.getText(diagram));

		Assert.assertEquals("The table label is not the expected one.", "Table MaTableGenerique",
				labelProvider.getText(table));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.internationalization.tests.tests.AbstractUMLInternationalizationTest#checkEnglishLabels()
	 */
	@Override
	public void checkEnglishLabels() throws Exception {
		super.checkEnglishLabels();

		Assert.assertEquals("The root element label is not the expected one.", "Diagram MyClassDiagram",
				labelProvider.getText(diagram));

		Assert.assertEquals("The class label is not the expected one.", "Table MyGenericTable",
				labelProvider.getText(table));
	}

	/**
	 * This allows to create the submodel for the element in parameter with the
	 * name of the fragment.
	 * 
	 * @param element
	 *            The element to control.
	 * @param fragmentName
	 *            The fragment name to create.
	 * @return The resource created.
	 * @throws ServiceException
	 *             The exception can be caught by the control operation.
	 */
	protected Resource control(final Element element, final String fragmentName) throws ServiceException {
		final ControlModeRequest request = request(element, fragmentName);
		final ICommand control = ControlModeManager.getInstance().getControlCommand(request);

		execute(control);
		assertThat("Cannot undo control command", fixture.getEditingDomain().getCommandStack().canUndo(), is(true));

		return request.getTargetResource(UmlModel.UML_FILE_EXTENSION);
	}

	/**
	 * Get the control request for the object in parameter with the fragment
	 * name.
	 * 
	 * @param objectToControl
	 *            The object to control.
	 * @param initialFragmentName
	 *            The initial fragment name (if does not contain 'uml'
	 *            extension, must be added).
	 * @return The control mode request for the object.
	 */
	private ControlModeRequest request(final EObject objectToControl, final String initialFragmentName) {
		ControlModeRequest result = null;

		String fragmentName = initialFragmentName;

		if (!fragmentName.endsWith("." + UmlModel.UML_FILE_EXTENSION)) {
			fragmentName = fragmentName + "." + UmlModel.UML_FILE_EXTENSION;
		}

		try {
			final URI fragmentURI = objectToControl.eResource().getURI().trimSegments(1).appendSegment(fragmentName);
			result = new ControlModeRequest(fixture.getEditingDomain(), objectToControl, fragmentURI);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to create ControlModeRequest: " + e.getLocalizedMessage());
		}

		return result;
	}

	/**
	 * This allows to re-integrate submodel corresponding to the object in
	 * parameter.
	 * 
	 * @param element
	 *            The object to uncontrol.
	 * @throws ServiceException
	 *             The exception that can be caught by the uncontrol command.
	 */
	protected void uncontrol(final Element element) throws ServiceException {
		final ICommand uncontrol = ControlModeManager.getInstance().getUncontrolCommand(request(element));

		execute(uncontrol);
		assertThat("Cannot undo control command", fixture.getEditingDomain().getCommandStack().canUndo(), is(true));
	}

	/**
	 * Get the uncontrol request for the object in parameter.
	 * 
	 * @param objectToUncontrol
	 *            The object to uncontrol.
	 * @return The uncontrol request for the object.
	 */
	private ControlModeRequest request(final EObject objectToUncontrol) {
		ControlModeRequest result = null;

		result = new ControlModeRequest(fixture.getEditingDomain(), objectToUncontrol);

		return result;
	}

	/**
	 * This allows to execute a GMF command.
	 * 
	 * @param command
	 *            The GMF command to execute.
	 */
	protected void execute(final ICommand command) {
		fixture.getEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
	}

	/**
	 * This allows to undo the last command done.
	 */
	protected void undo() {
		fixture.getEditingDomain().getCommandStack().undo();
	}

	/**
	 * This allows to redo the last command undoable.
	 */
	protected void redo() {
		fixture.getEditingDomain().getCommandStack().redo();
	}

}

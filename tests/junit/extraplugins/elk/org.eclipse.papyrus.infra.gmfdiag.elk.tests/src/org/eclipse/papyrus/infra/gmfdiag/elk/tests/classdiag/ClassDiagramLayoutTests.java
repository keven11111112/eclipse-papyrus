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
package org.eclipse.papyrus.infra.gmfdiag.elk.tests.classdiag;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.compare.contentmergeviewer.TokenComparator;
import org.eclipse.compare.rangedifferencer.IRangeComparator;
import org.eclipse.compare.rangedifferencer.RangeDifference;
import org.eclipse.compare.rangedifferencer.RangeDifferencer;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.elk.core.service.DiagramLayoutEngine;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.papyrus.infra.gmfdiag.export.actions.ExportAllDiagramsParameter;
import org.eclipse.papyrus.infra.gmfdiag.export.engine.ExportAllDiagramsEngine;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.rules.ActiveDiagram;
import org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.junit.utils.rules.UIThreadRule;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Basic tests for Class diagram layout by ELK
 */
@PluginResource(ClassDiagramLayoutTests.SOURCE_FOLDER+"model.di")
public class ClassDiagramLayoutTests extends AbstractPapyrusTest {

	static final String SOURCE_FOLDER = "/resource/simple-classdiag/";

	public static final String BASIC_DIAGRAM_NAME = "Basic";
	public static final String ADVANCED_DIAGRAM_NAME = "Advanced";

	@ClassRule
	public static final TestRule uiThread = new UIThreadRule();

	@ClassRule
	public static final PapyrusEditorFixture editor = new PapyrusEditorFixture();

	private static final int TOLERANCE = 1;

	private final Rectangle class1Bounds = new Rectangle(104, 307, 202, 179);

	private final Rectangle class1BoundsAfterLayout = new Rectangle(12, 21, 202, 179);

	/**
	 * Creates a new {@link ClassDiagramLayoutTests}
	 */
	public ClassDiagramLayoutTests() {
		// Empty constructor.
	}
	
	@Test
	public void testELKAdvancedLayout() {
		editor.openDiagram(ADVANCED_DIAGRAM_NAME);
		assertThat("Active diagram is not the one expected" , editor.getActiveDiagram().getDiagramView().getName(), equalTo(ADVANCED_DIAGRAM_NAME));
		runLayout(editor.getEditor().getSite().getPart());
		IFile currentFile = exportDiagramToFile();
		IFile expectedFile = retrieveReferenceFile(editor.getActiveDiagram().getDiagramView().getName());
		compareResult(expectedFile, currentFile);
		editor.undo();
	}
	
	@Test
	public void testELKBasicLayout() {
		editor.openDiagram(BASIC_DIAGRAM_NAME);
		assertThat("Active diagram is not the one expected" , editor.getActiveDiagram().getDiagramView().getName(), equalTo(BASIC_DIAGRAM_NAME));
		runLayout(editor.getEditor().getSite().getPart());
		EditPart class1EditPart = editor.requireEditPart(editor.getActiveDiagram().getChildBySemanticHint("Class_Shape"), editor.getModel().getPackagedElement("Class1"));
		Rectangle class1NewBounds = ((GraphicalEditPart)class1EditPart).getFigure().getBounds();
		assertThat("Class position after layout is not the expected one", class1NewBounds, equalTo(this.class1BoundsAfterLayout));
		IFile currentFile = exportDiagramToFile();
		IFile expectedFile = retrieveReferenceFile(editor.getActiveDiagram().getDiagramView().getName());
		compareResult(expectedFile, currentFile);
		editor.undo();
	}
	
	@Test
	public void checkInitialConditions() {
		EditPart class1EditPart = editor.requireEditPart(editor.getActiveDiagram().getChildBySemanticHint("Class_Shape"), editor.getModel().getPackagedElement("Class1"));
		assertThat("Impossible to find Class1 edit part or is not a GraphicalEditPart", class1EditPart, instanceOf(GraphicalEditPart.class));
		// get class1 position (no layout yet)
		Rectangle class1Bounds = ((GraphicalEditPart)class1EditPart).getFigure().getBounds();
		assertThat("Initial condition does not match test configuration", class1Bounds, equalTo(this.class1Bounds));
		// check status of the ELK layout handler
		ICommandService commandService = PlatformUI.getWorkbench().getService(ICommandService.class);
		org.eclipse.core.commands.Command cmd = commandService.getCommand("org.eclipse.elk.core.ui.command.layout"); //$NON-NLS-1$
		IHandler handler = cmd.getHandler();
		((AbstractHandler)handler).setEnabled("org.eclipse.elk.core.ui.command.layout"); //$NON-NLS-1$
		boolean res = handler.isEnabled();
		assertTrue("Layout must be enable", res); //$NON-NLS-1$
	}
	
	private IFile retrieveReferenceFile(String diagramName) {
		Bundle bundle = FrameworkUtil.getBundle(ClassDiagramLayoutTests.class);
		URL url = bundle.getResource(SOURCE_FOLDER+"expected/"+diagramName+"-expected.SVG");
		try (InputStream contents = url.openStream()) {
			IFile expectedFile = editor.getProject().getProject().getFile(URI.createURI(url.toExternalForm()).lastSegment());
			expectedFile.create(contents, false, null);
		} catch (Exception e) {
			throw new WrappedException(e);
		}
		return editor.getProject().getProject().getFile(diagramName+"-expected.SVG");	}

	private IFile exportDiagramToFile() {
		ExportAllDiagramsEngine engine = new ExportAllDiagramsEngine();
		ExportAllDiagramsParameter parameter = new ExportAllDiagramsParameter(editor.getModelSet());
		parameter.setExportFormat("SVG");
		parameter.setOutputDirectory(editor.getProject().getProject());
		parameter.setDisplayStatus(false); // avoid popup at the end of the export
		engine.initialise(parameter);
		engine.export(new NullProgressMonitor(), Arrays.asList(editor.getActiveDiagram().getDiagramView()));
		return editor.getProject().getProject().getFile(editor.getActiveDiagram().getDiagramView().getName() + "." + parameter.getExportFormat());
	}

	public void runLayout(IWorkbenchPart part) {
		DiagramLayoutEngine.invokeLayout(part, null, false, false, false, false);
		editor.flushDisplayEvents();
	}

	public void compareResult(IFile expected, IFile current) {
		IRangeComparator expectedContent = new TokenComparator(readFile(expected));
		IRangeComparator currentContent = new TokenComparator(readFile(current));
		RangeDifference[] diffs = RangeDifferencer.findDifferences(expectedContent, currentContent);
		for(int i = 0; i < diffs.length; i++) {
			System.err.println(i + " -> " + diffs[i].toString());
		}
		assertThat("There should not be any difference, but some diffs were found.", diffs.length, equalTo(0));
	}

	private static String readFile(IFile file) {
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(file.getContents()))) {
			return buffer.lines().collect(Collectors.joining("\n"));
		} catch (IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (CoreException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		return "ERROR";
	}
}

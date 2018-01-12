/*****************************************************************************
 * Copyright (c) 2015, 2018 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.component.test.canonical;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.junit.Test;

/**
 * Check ability to create geoshapes
 */
@SuppressWarnings("nls")
public class TestGeoshapes extends AbstractPapyrusTestCase {

	@Test
	public void testCreationNote() {
		IGraphicalEditPart diagram = getDiagramEditPart();
		Point p = selectEditpart(diagram);
		List<String> menuChain = Arrays.asList(new String[]{"Add", "&Note"});
		selectMenu(diagram, p, menuChain);
	}

	@Test
	public void testCreationTriangle() {
		IGraphicalEditPart diagram = getDiagramEditPart();
		Point p = selectEditpart(diagram);
		List<String> menuChain = Arrays.asList(new String[]{"Add", "Tri&angle"});
		selectMenu(diagram, p, menuChain);
	}

	protected void selectMenu(IGraphicalEditPart dc, Point p, List<String> chain) {
		Control control = getDiagramEditPart().getViewer().getControl();
		Menu menu = control.getMenu();
		Event event = createEvent();
		event.widget = control;
		event.x = p.x;
		event.y = p.y;
		MenuItem item = findItem(menu, chain.iterator(), event);
		StringBuilder menuChain = new StringBuilder();
		for (int i = 0 ; i < chain.size(); i++) {
			if (i != 0) {
				menuChain.append("->");
			}
			menuChain.append(chain.get(i));
		} 
		assertNotNull("Menu item was not found:" + menuChain.toString(),item);
		assertTrue("Menu was not enabled", item.getEnabled());
	}

	private MenuItem findItem(Menu menu, Iterator<String> chain, Event event) {
		menu.notifyListeners(SWT.Show, event);
		menu.setVisible(true);
		String text = chain.next();
		for (MenuItem item: menu.getItems()) {
			if (item.getText().contains(text)) {
				return chain.hasNext() ? findItem(item.getMenu(), chain, event) : item;
			}
		}
		return null;
	}

	protected Event createMouseEvent(int x, int y, int button, int stateMask, int count) {
		Event event = new Event();
		event.time = (int) System.currentTimeMillis();
		event.widget = null;
		event.display = Display.getDefault();
		event.x = x;
		event.y = y;
		event.button = button;
		event.stateMask = stateMask;
		event.count = count;
		return event;
	}

	protected Event createEvent() {
		Event event = new Event();
		event.time = (int) System.currentTimeMillis();
		event.widget = null;
		event.display = Display.getDefault();
		return event;
	}

	protected Event createSelectionEvent(int stateMask) {
		Event event = createEvent();
		event.stateMask = stateMask;
		return event;
	}

	private Point selectEditpart(IGraphicalEditPart dc) {
		// select edit part
		Control control = dc.getViewer().getControl();
		Point p = getAbsoluteBounds(dc).getCenter();
		Event event = createMouseEvent(p.x, p.y, 1, SWT.NONE, 1);
		event.type = SWT.MouseDown;
		event.widget = control;
		control.notifyListeners(SWT.MouseDown, event);
		event.type = SWT.MouseUp;
		control.notifyListeners(SWT.MouseUp, event);
		return p;
	}

	public static Rectangle getAbsoluteBounds(IGraphicalEditPart part) {
		// take bounds from figure
		Rectangle bounds = part.getFigure().getBounds().getCopy();

		if(part.getNotationView() instanceof Node) {
			// rather update with up to date model bounds
			Node node = (Node)part.getNotationView();
			LayoutConstraint cst = node.getLayoutConstraint();
			if(cst instanceof Bounds) {
				Bounds b = (Bounds)cst;
				Point parentLoc = part.getFigure().getParent().getBounds().getLocation();
				if(b.getX() > 0) {
					bounds.x = b.getX() + parentLoc.x;
				}
				if(b.getY() > 0) {
					bounds.y = b.getY() + parentLoc.y;
				}
				if(b.getHeight() != -1) {
					bounds.height = b.getHeight();
				}
				if(b.getWidth() != -1) {
					bounds.width = b.getWidth();
				}
			}
		}

		part.getFigure().getParent().translateToAbsolute(bounds);
		return bounds;
	}
}

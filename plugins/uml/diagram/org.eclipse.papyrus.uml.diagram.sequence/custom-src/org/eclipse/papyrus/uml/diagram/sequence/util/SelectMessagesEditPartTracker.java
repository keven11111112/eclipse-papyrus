/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.selection.SelectSeveralLinksEditPartTracker;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PlatformUI;

/**
 * @author PT202707
 * @since 3.0
 *
 */
public class SelectMessagesEditPartTracker extends SelectSeveralLinksEditPartTracker {
	protected Listener KeyDownListener = new  Listener() {

		@Override
		public void handleEvent(Event event) {
			// in case the SHIFT key is released, the creation mode goes back to normal
			if (event.keyCode == SWT.SHIFT) {
				allowReoder = true;
			}
		}

	};
	protected Listener KeyUPListener = new  Listener() {

		@Override
		public void handleEvent(Event event) {
			// in case the SHIFT key is released, the creation mode goes back to normal
			if (event.keyCode == SWT.SHIFT) {
				allowReoder = false;
			}
		}

	};
	protected int MinDistancetop= Integer.MAX_VALUE;
	protected int MinDistancebottom=Integer.MAX_VALUE;
	protected Dimension delta= null;
	/**
	 * @see org.eclipse.gef.tools.AbstractTool#activate()
	 *
	 */
	@Override
	public void activate() {
		super.activate();
	}
	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.selection.SelectSeveralLinksEditPartTracker#handleButtonDown(int)
	 *
	 * @param button
	 * @return
	 */
	@Override
	protected boolean handleButtonDown(int button) {
		Dimension delta= null;
		MinDistancetop= Integer.MAX_VALUE;
		MinDistancebottom=Integer.MAX_VALUE;
		//1. look for all Nodes connected by connections 
		//and  find the MinDistancetop (maximum mouvment without reorder to the top) and the MinDistancebottom (maximum distance without reorder to the bottom)

		
		ArrayList<GraphicalEditPart> nodeEditPart= new ArrayList<GraphicalEditPart>();

		List selectedEditparts = getOperationSet();

		for (int i=0; i<selectedEditparts.size();i++){
			Object currentEditPart = selectedEditparts.get(i);
			if(currentEditPart instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart ){
				org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart currentConnectionEdiPart=(org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart) currentEditPart;
				nodeEditPart.add((GraphicalEditPart)currentConnectionEdiPart.getSource());

			}				

		}
		//2. take all messages between this nodes
		ArrayList<AbstractMessageEditPart> messageEditPartList = new ArrayList<AbstractMessageEditPart>();
		for (GraphicalEditPart anodeEditPart : nodeEditPart) {
			for (Object connection:anodeEditPart.getSourceConnections()){

				if(connection instanceof AbstractMessageEditPart){
					if(!(selectedEditparts.contains(connection))){
						messageEditPartList.add((AbstractMessageEditPart)connection);
					}
				}
			}
			for (Object connection:anodeEditPart.getTargetConnections()){
				if(!(selectedEditparts.contains(connection))){
					if(connection instanceof AbstractMessageEditPart){
						messageEditPartList.add((AbstractMessageEditPart)connection);
					}
				}
			}
		}

		//3 calculate minimum distance
		for (AbstractMessageEditPart abstractMessageEditPart : messageEditPartList) {
			Point currentConnectionPosition = abstractMessageEditPart.getConnectionFigure().getPoints().getFirstPoint().getCopy();
			for (Object selectedEditPart : selectedEditparts) {
				if( selectedEditPart instanceof AbstractMessageEditPart){
					AbstractMessageEditPart currentSelectedMessage=(AbstractMessageEditPart)selectedEditPart;
					Point currentSelectedConnectionPosition = currentSelectedMessage.getConnectionFigure().getPoints().getFirstPoint().getCopy();

					// selected Message is below the currentConnection
					if( currentConnectionPosition.y<currentSelectedConnectionPosition.y){
						if(MinDistancetop> (currentSelectedConnectionPosition.y-currentConnectionPosition.y)){
							MinDistancetop=(currentSelectedConnectionPosition.y-currentConnectionPosition.y);
						}
					}
					else{
						// selected Message is above the currentConnection
						if(MinDistancebottom> (currentConnectionPosition.y-currentSelectedConnectionPosition.y)){
							MinDistancebottom=(currentConnectionPosition.y-currentSelectedConnectionPosition.y);
						}
					}
				}

			}
		}

		return super.handleButtonDown(button);
	}
	/**
	 * Constructor.
	 *
	 * @param owner
	 */
	public SelectMessagesEditPartTracker(ConnectionEditPart owner) {
		super(owner);
		PlatformUI.getWorkbench().getDisplay().addFilter(SWT.KeyDown, KeyDownListener);
		PlatformUI.getWorkbench().getDisplay().addFilter(SWT.KeyUp, KeyUPListener);
	}
	private boolean allowReoder=false;



	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.gef.Tool#deactivate()
	 */
	public void deactivate() {
		PlatformUI.getWorkbench().getDisplay().removeFilter(SWT.KeyUp, KeyDownListener);
		PlatformUI.getWorkbench().getDisplay().removeFilter(SWT.KeyUp, KeyUPListener);
		super.deactivate();
	}
	/**
	 * @see org.eclipse.gef.tools.SimpleDragTracker#updateSourceRequest()
	 */
	protected void updateSourceRequest() {
		if(!allowReoder){
			Dimension computedDelta =  getLocation().getDifference(getStartLocation());
			delta=null;
			if( computedDelta.height<0){
				System.out.println("Move "+computedDelta.height+" MinDistancetop"+MinDistancetop);
				if( MinDistancetop+computedDelta.height<0){
					computedDelta.height=-MinDistancetop;
					delta=computedDelta.getCopy();
				}
			}
			else{
				System.out.println("Move "+computedDelta.height+" MinDistancebottom"+MinDistancebottom);
				if( MinDistancebottom-computedDelta.height-10<0){
					computedDelta.height=MinDistancebottom-10;
					delta=computedDelta.getCopy();
				}

			}
			
		}
		super.updateSourceRequest();
	}

	protected Dimension getDragMoveDelta() {
		if( delta==null){
			return getLocation().getDifference(getStartLocation());}
		else{
			return delta;
		}
	}
	/**
	 * Walks up the editpart hierarchy to find and return the
	 * <code>TopGraphicEditPart</code> instance.
	 */
	public  DiagramEditPart getDiagramEditPart(EditPart editPart) {
		while (editPart instanceof IGraphicalEditPart) {
			if (editPart instanceof DiagramEditPart){
				return (DiagramEditPart) editPart;
			}
			
			editPart = editPart.getParent();
		}
		if(editPart instanceof DiagramRootEditPart){
			return (DiagramEditPart)((DiagramRootEditPart)editPart).getChildren().get(0);
		}
		return null;
	}
}

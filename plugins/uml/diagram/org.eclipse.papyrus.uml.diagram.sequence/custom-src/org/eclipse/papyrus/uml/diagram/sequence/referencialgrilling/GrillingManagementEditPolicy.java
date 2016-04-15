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

package org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AutomaticNotationEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.sequence.command.CreateCoordinateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CreateGrillingStructureCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author PT202707
 *
 */
public class GrillingManagementEditPolicy extends GraphicalEditPolicyEx implements AutomaticNotationEditPolicy, NotificationListener, IGrillingEditpolicy{ 


	public static final String GRILL_CONNECTION = "Grill Connection";


	protected GrillingEditpart grillingCompartment=null;


	public static String GRILLING_MANAGEMENT="GRILLING_MANAGEMENT";
	public static String COLUMN="COLUMN_"; 
	public static String ROW="ROW_"; 

	public int threshold=10;
	public int margin=50;
	public int firstY=30;
	public int firstX=100;
	public boolean respectMargin=true;
	/**
	 * @return the respectMargin
	 */
	public boolean isRespectMargin() {
		return respectMargin;
	}

	/**
	 * @param respectMargin the respectMargin to set
	 */
	public void setRespectMargin(boolean respectMargin) {
		this.respectMargin = respectMargin;
	}



	public boolean strictRespectMargin=true;

	public int getNextY(){
		if(rows.size()>0){
			DecorationNode row=	rows.last();
			LayoutConstraint layoutConstraint=row.getLayoutConstraint();
			return ((Location)layoutConstraint).getY()+margin;
		}
		return firstY;
	}



	public Comparator<DecorationNode> RowComparator =new Comparator<DecorationNode>(){

		@Override
		public int compare(DecorationNode o1, DecorationNode o2) {
			LayoutConstraint layoutConstrainto1=((Node)o1).getLayoutConstraint();
			LayoutConstraint layoutConstrainto2=((Node)o2).getLayoutConstraint();
			if( layoutConstrainto1!=null && layoutConstrainto2!=null){
				return ((Integer)((Location)layoutConstrainto1).getY()).compareTo(((Integer)((Location)layoutConstrainto2).getY()));
			}
			return 0;
		}
	};

	public Comparator<DecorationNode> ColumnComparator =new Comparator<DecorationNode>(){

		@Override
		public int compare(DecorationNode o1, DecorationNode o2) {
			LayoutConstraint layoutConstrainto1=((Node)o1).getLayoutConstraint();
			LayoutConstraint layoutConstrainto2=((Node)o2).getLayoutConstraint();
			if( layoutConstrainto1!=null && layoutConstrainto2!=null){
				return ((Integer)((Location)layoutConstrainto1).getX()).compareTo(((Integer)((Location)layoutConstrainto2).getX()));
			}
			return 0;
		}
	};

	public TreeSet<DecorationNode> rows= new TreeSet<DecorationNode>(RowComparator);
	public TreeSet<DecorationNode> columns= new TreeSet<DecorationNode>(ColumnComparator);

	//ok if the creation a X is free
	public boolean CREATION_X_FREE=true;
	/**if the CREATION_X_FREE == false COLUMN are created at fixed position**/ 
	public int X_SPACING=100;


	/**
	 * Constructor.
	 *
	 */
	public GrillingManagementEditPolicy() {
	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 *
	 */
	@Override
	public void activate() {
		super.activate();
		getDiagramEventBroker().addNotificationListener(((EObject)getHost().getModel()), this);
		ContentDiagramListener contentDiagramListener=new ContentDiagramListener(this);
		((EObject)getHost().getModel()).eResource().eAdapters().add(contentDiagramListener);
		refreshGrillingStructure();
	}
	/**
	 * 
	 */
	private void refreshGrillingStructure() {
		EditPart host= getHost();
		int i=0;
		while( grillingCompartment==null && i <host.getChildren().size()){
			if( host.getChildren().get(i) instanceof GrillingEditpart){
				grillingCompartment=(GrillingEditpart) (host.getChildren().get(i));
			}
			i++;
		}
		if( grillingCompartment==null){
			CreateGrillingStructureCommand createGrillingStructureCommand= new CreateGrillingStructureCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), (View)getHost().getModel());
			// Record for undo if possible, otherwise unprotected
			execute(createGrillingStructureCommand);


		}
		while( grillingCompartment==null && i <host.getChildren().size()){
			if( host.getChildren().get(i) instanceof GrillingEditpart){
				grillingCompartment=(GrillingEditpart) (host.getChildren().get(i));
			}
			i++;
		}
		cleanUnusedRowAndColumn();
		updateRowsAndColumns();
	}

	/**
	 * update the list of romw and colmumn
	 */
	public void updateRowsAndColumns() {


		rows.clear();
		columns.clear();
		if(grillingCompartment!=null){
			for (int j=0;j<grillingCompartment.getNotationView().getChildren().size(); j++){
				if(grillingCompartment.getNotationView().getChildren().get(j) instanceof DecorationNode ){
					DecorationNode  decorationNode=(DecorationNode)grillingCompartment.getNotationView().getChildren().get(j);
					if(decorationNode.getType().startsWith(ROW) ){
						rows.add(decorationNode);

					}
					if(decorationNode.getType().startsWith(COLUMN) ){
						columns.add(decorationNode);
					}
				}
			}
		}
		Collections.sort(new ArrayList<>(rows),RowComparator );
		Collections.sort(new ArrayList<>(columns),ColumnComparator );
	}
	/** this class is very specific the the sequence diagram
	 * this purpose of this method is to ensure the consistency of event in the the represented diagram**/
	public void updateSemanticAfterUpdate(){
		//1. look for all Lifelines
		//There are columns.
		HashSet<Lifeline> lifelineList= new HashSet<Lifeline>();
		for (DecorationNode column : columns) {
			if ((getRef(column))!=null){
				for (EObject referedElement : getRef(column)) {
					if( referedElement instanceof Lifeline){
						lifelineList.add((Lifeline)referedElement);
					}
				}
			}

		}
		//for each lifeline recreat the list of covered element
		for (Lifeline lifeline : lifelineList) {
			ArrayList<InteractionFragment> covered= new ArrayList<InteractionFragment>();
			for (DecorationNode row : rows) {
				if ((getRef(row))!=null){
					for (EObject referedElement : getRef(row)) {
						if( referedElement instanceof InteractionFragment){
							InteractionFragment interactionFragment=(InteractionFragment)(referedElement);
							if( lifeline.getCoveredBys().contains(interactionFragment)){
								covered.add(interactionFragment);

							}
						}

					}
				}

			}
			if(covered.size()== lifeline.getCoveredBys().size()){
				System.err.println("equality");
				execute(new SetCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), lifeline, UMLPackage.eINSTANCE.getLifeline_CoveredBy(), covered));
			}
			else if( covered.size()<lifeline.getCoveredBys().size()){
				System.err.println("Event not managed or in being created");
				covered.addAll(lifeline.getCoveredBys());
				execute(new SetCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), lifeline, UMLPackage.eINSTANCE.getLifeline_CoveredBy(), covered));
			}
			else if( covered.size()>lifeline.getCoveredBys().size()){
				System.err.println("more event that in the lifeline");
			}
		}

	}

	public void cleanUnusedRowAndColumn(){
		ArrayList<DecorationNode> unusedDcorationNode= new ArrayList<DecorationNode>();
		
		if(grillingCompartment!=null){
			List  persistedChildren=grillingCompartment.getNotationView().getPersistedChildren();
			for (int i=0;i<persistedChildren.size(); i++){
				if(persistedChildren.get(i) instanceof DecorationNode ){
					DecorationNode  decorationNode=(DecorationNode)persistedChildren.get(i);
					EAnnotation eAnnotation =decorationNode.getEAnnotation(GRILL_CONNECTION);
					if(eAnnotation==null){
						unusedDcorationNode.add(decorationNode);
					}
					if( eAnnotation!=null){
						if(eAnnotation.getReferences().size()==0){
							unusedDcorationNode.add(decorationNode);
						}
					}
				}
			}
			if(unusedDcorationNode.size()>0){
				execute(new RemoveCommand(((IGraphicalEditPart) getHost()).getEditingDomain(),
						grillingCompartment.getNotationView(),NotationPackage.eINSTANCE.getView_PersistedChildren(),unusedDcorationNode));
			}
		}
	}

	/* Gets the diagram event broker from the editing domain.
	 *
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (null != theEditingDomain) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}
	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#deactivate()
	 *
	 */
	@Override
	public void deactivate() {
		getDiagramEventBroker().removeNotificationListener(((EObject)getHost().getModel()), this);
		super.deactivate();
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notifications
	 */
	@Override
	public void notifyChanged(Notification notification) {
		//		if( notification.getEventType()==Notification.UNSET ){
		//			updateSemanticAfterUpdate();
		//		}

		if( notification.getEventType()==Notification.ADD){
			updateRowsAndColumns();
			updateSemanticAfterUpdate();
		}
		if( notification.getEventType()==Notification.REMOVE && (!(notification.getNotifier() instanceof EAnnotation))&&(!(notification.getNotifier().equals(grillingCompartment.getNotationView())))){
			cleanUnusedRowAndColumn();
			updateRowsAndColumns();
			updateSemanticAfterUpdate();
		}
		if( notification.getEventType()==Notification.SET ){
			cleanUnusedRowAndColumn();
			updateRowsAndColumns();
			updateSemanticAfterUpdate();
		}

	}

	/**
	 * the get row to listen form the semanntic and the node 
	 * @param graphic the notation representation of the semantic element
	 * @param notationObject
	 * @return
	 */
	public View getRowTolisten(Node graphic, Element semantic) throws NoGrillElementFound{
		LayoutConstraint layoutConstraint=((Node)graphic).getLayoutConstraint();
		if(layoutConstraint instanceof Bounds){
			return getRowTolisten(((Bounds) layoutConstraint).getY(),semantic);
		}
		throw new NoGrillElementFound();
	}


	/**
	 * get the decoration node that represents a column from a position (absolute)
	 * @param x the position x for the column
	 * @return the decoration node
	 */
	public DecorationNode getColumnTolisten( int x, Element semantic) throws NoGrillElementFound{
		try{
			DecorationNode column=existCoulumnAtPosition(x);
		}
		catch (NoGrillElementFound e) {
			execute(new CreateCoordinateCommand(((IGraphicalEditPart) getHost()).getEditingDomain(),((BasicCompartment)grillingCompartment.getNotationView()),COLUMN+columns.size(), semantic,x));
		}	

		return	existCoulumnAtPosition(x);
	}
	/**
	 * This method allow toadd in teh the notation which object listen column or row 
	 * @param grillElement a row or a column
	 * @param source the graphical representation
	 */
	protected void associateViewToGrill(View grillElement, EObject source){
		if( grillElement.getEAnnotation(GRILL_CONNECTION)==null){
			EAnnotation eAnnotation =EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(GRILL_CONNECTION);

			ArrayList<EAnnotation> arrayList= new  ArrayList<EAnnotation>();
			arrayList.add(eAnnotation);
			execute(new SetCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), grillElement, EcorePackage.eINSTANCE.getEModelElement_EAnnotations(), arrayList));

		}

		EAnnotation eAnnotation=grillElement.getEAnnotation(GRILL_CONNECTION);
		ArrayList<EObject> refs= new  ArrayList<EObject>();
		refs.addAll(eAnnotation.getReferences());
		refs.add(source);
		execute(new SetCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), eAnnotation, EcorePackage.eINSTANCE.getEAnnotation_References(), refs));


	}
	/**
	 * This method allow toadd in teh the notation which object listen column or row 
	 * @param grillElement a row or a column
	 * @param source the graphical representation
	 */
	public void dissociateViewToGrill(View grillElement, EObject source){
		if( grillElement.getEAnnotation(GRILL_CONNECTION)==null){
			return;
		}

		EAnnotation eAnnotation=grillElement.getEAnnotation(GRILL_CONNECTION);
		ArrayList<EObject> refs= new  ArrayList<EObject>();
		refs.addAll(eAnnotation.getReferences());
		refs.remove(source);
		execute(new SetCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), eAnnotation, EcorePackage.eINSTANCE.getEAnnotation_References(), refs));


	}
	/**
	 * get the decoration node that represents a line from a position (absolute)
	 * @param y the position y for the line
	 * @return the decoration node
	 */
	public DecorationNode getRowTolisten( int y, Element semantic) throws NoGrillElementFound{
		try{
			return existRowAtPosition(y, semantic);
		}
		catch (NoGrillElementFound e) {
			execute(new CreateCoordinateCommand(((IGraphicalEditPart) getHost()).getEditingDomain(),((BasicCompartment)grillingCompartment.getNotationView()),ROW+rows.size(), semantic,y));
			DecorationNode row= existRowAtPosition(y, semantic);
			updateYpositionForRow(row, y);
			return row;
		}

	}



	/**
	 * the get the Column to listen by taking account the  semantic and the Node 
	 * @param graphic the graphical element 
	 * @return
	 */
	public View getColumnTolisten( Node graphic, Element semantic ) throws NoGrillElementFound{
		LayoutConstraint layoutConstraint=((Node)graphic).getLayoutConstraint();
		if(layoutConstraint instanceof Bounds){
			return getColumnTolisten(((Bounds)layoutConstraint).getX(),semantic);
		}
		throw new NoGrillElementFound();

	}





	/**
	 * 
	 * @param x the position y where we look for a column
	 * @return the column that exists at the position [x- threshold, x+threshold]
	 */
	public DecorationNode existCoulumnAtPosition(int x) throws NoGrillElementFound{
		for (Iterator<DecorationNode> iterator = columns.iterator(); iterator.hasNext();) {
			DecorationNode currentColumn =  iterator.next();
			int Xposition=getPositionX(currentColumn);
			if( Xposition-threshold<=x&& x<=Xposition+threshold){
				return currentColumn;
			}

		}
		throw new NoGrillElementFound();
	}


	/**
	 * 
	 * @param y the position y where we look for a row
	 * @return the row that exists at the position [y- threshold, y+threshold]s
	 */
	public DecorationNode existRowAtPosition(int y,EObject source) throws NoGrillElementFound{
		for (Iterator<DecorationNode> iterator = rows.iterator(); iterator.hasNext();) {
			DecorationNode currentRow =  iterator.next();
			int Yposition=getPositionY(currentRow);
			if( Yposition-threshold<=y&& y<=Yposition+threshold){
				associateViewToGrill(currentRow, source);
				return currentRow;
			}

		}
		throw new NoGrillElementFound();
	}

	/**
	 * 
	 * @param y the position y where we look for a row
	 * @return the row that exists at the position [y- threshold, y+threshold]s
	 */
	public DecorationNode existRowAtPosition(int y) throws NoGrillElementFound{
		for (Iterator<DecorationNode> iterator = rows.iterator(); iterator.hasNext();) {
			DecorationNode currentRow =  iterator.next();
			int Yposition=getPositionY(currentRow);
			if( Yposition-threshold<=y&& y<=Yposition+threshold){
				return currentRow;
			}

		}
		throw new NoGrillElementFound();
	}
	/**
	 * @param decorationNode
	 * @return the postion X for a decoration Node
	 */
	public int getPositionX(DecorationNode  decorationNode){
		LayoutConstraint constraint=decorationNode.getLayoutConstraint();
		if( constraint instanceof Location){
			return ((Location)constraint).getX();
		}
		return 0;
	}
	/**
	 * @param decorationNode
	 * @return the Position Y for a decoration node
	 */
	public int getPositionY(DecorationNode  decorationNode){
		LayoutConstraint constraint=decorationNode.getLayoutConstraint();
		if( constraint instanceof Location){
			return((Location)constraint).getY();
		}
		return 0;
	}
	public  void updateYpositionForRow(DecorationNode  decorationNode, int y){

		LayoutConstraint constraint=decorationNode.getLayoutConstraint();


		int nextdistance=getDistanceWithNextRow(decorationNode,y);
		int margin = getGridSpacing();
		if( constraint instanceof Location){
			execute(new SetCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), constraint, NotationPackage.eINSTANCE.getLocation_Y(), y));
		}
		if(respectMargin){
			if( nextdistance<margin){
				boolean after=false;
				for (DecorationNode currentRow : rows) {
					if( after){

						LayoutConstraint currentConstraint=currentRow.getLayoutConstraint();
						if( constraint instanceof Location){
							execute(new SetCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), currentConstraint, NotationPackage.eINSTANCE.getLocation_Y(), ((Location)currentConstraint).getY()+margin));
						}
					}
					if( currentRow.equals(decorationNode)){
						after=true;
					}

				}
			}
		}
	}

	public int getDistanceWithNextRow(DecorationNode currentRow, int currentRowPosition){
		Object[] arrayRow= rows.toArray();
		List<Object> orderedRows= Arrays.asList(arrayRow);
		int index=orderedRows.indexOf(currentRow);
		if(index==orderedRows.size()-1){
			return 0;
		}
		else{

			LayoutConstraint currentConstraint=currentRow.getLayoutConstraint();
			LayoutConstraint nextConstraint=((DecorationNode)orderedRows.get(index+1)).getLayoutConstraint();
			if( currentConstraint instanceof Location){
				return ((Location)nextConstraint).getY()-currentRowPosition;
			}

		}
		return 0;
	}

	protected int getGridSpacing(){
		if(DiagramEditPartsUtil.isSnapToGridActive(getHost())){	

			RootEditPart drep=getHost().getRoot();
			if( drep instanceof DiagramRootEditPart){
				return (int) ((DiagramRootEditPart)drep).getGridSpacing();
			}
		}
		return margin;
	}
	public static Point getLocation(DecorationNode current) throws NoGrillElementFound{
		LayoutConstraint currentConstraint=current.getLayoutConstraint();
		if( currentConstraint instanceof Location){
			return  new Point (((Location)currentConstraint).getX(), ((Location)currentConstraint).getY());
		}
		else{
			throw new NoGrillElementFound();
		}
	}

	public static List<EObject> getRef(DecorationNode current){
		EAnnotation eAnnotation =current.getEAnnotation(GRILL_CONNECTION);
		if(eAnnotation==null){
			return null;
		}
		else{
			if(eAnnotation.getReferences().size()!=0){
				return eAnnotation.getReferences();
			}
			return null;
		}
	}

}
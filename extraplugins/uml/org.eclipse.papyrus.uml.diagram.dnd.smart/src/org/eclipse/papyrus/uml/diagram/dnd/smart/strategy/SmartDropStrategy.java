/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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
package org.eclipse.papyrus.uml.diagram.dnd.smart.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalCommandsDropStrategy;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.dnd.smart.Activator;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.EdgeEReference;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.model.Path;
import org.eclipse.papyrus.uml.diagram.dnd.smart.graph.service.GenericUml2GraphServices;
import org.eclipse.papyrus.uml.diagram.dnd.smart.messages.Messages;
import org.eclipse.swt.graphics.Image;

/**
 * A DropStrategy to "Signal" a Class.
 * Drop a signal on a Class operation section to type it.
 * This will create a new Reception operation in the interaction, typed by the dropped classifier.
 *
 * @author Francois Le Fevre
 *
 */
public class SmartDropStrategy extends TransactionalCommandsDropStrategy {

	GenericUml2GraphServices genericUml2GraphServices;
	
	public SmartDropStrategy(){
		genericUml2GraphServices = new GenericUml2GraphServices();
	}
	
	public String getLabel() {
		return Messages.SmartDropStrategy_Label;
	}

	public String getDescription() {
		return Messages.SmartDropStrategy_Description;
	}

	public Image getImage() {
		return null;
	}

	public String getID() {
		return Activator.PLUGIN_ID + ".smart.represents"; //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy#getPriority()
	 *
	 * @return
	 * @deprecated
	 */
	public int getPriority() {
		return 0;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalCommandsDropStrategy#doGetCommands(org.eclipse.gef.Request, org.eclipse.gef.EditPart)
	 *
	 * @param request
	 * @param targetEditPart
	 * @return
	 */
	@Override
	protected List<Command> doGetCommands(Request request, final EditPart targetEditPart) {
		List<EObject> sourceElements = getSourceEObjects(request);
		// The only supported case is "Drop a single signal on a single Operation of a Classifier"
		if (sourceElements.size() != 1) {
			return null;
		}
		final EObject sourceElement = sourceElements.get(0);
		
		final EObject targetElement = getTargetSemanticElement(targetEditPart);

		final Set<Path> paths = genericUml2GraphServices.proposedActionsFromDnd(sourceElement.eClass(), targetElement.eClass());
		if(Activator.log.isDebugEnabled()){
			Activator.log.debug("paths size "+paths.size());
		}
		
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(sourceElement);
		if(provider == null) {
			return null;
		}

		List<Command> myCommands = new ArrayList<Command>();

		for(final Path p : paths){

			CompositeCommand cc = new CompositeCommand(getLabel());

			Command resultCommand = new Command(getLabel()) {
				@SuppressWarnings("unchecked")
				@Override
				public void execute() {
					EObject container= targetElement;

					//Filter to have only one command
					//Doing the initial cascade from Target to Source
					for(int i=0; i< p.getWay().size()-1 ; i++){
						EdgeEReference er = p.getWay().get(i);
						if(Activator.log.isDebugEnabled()){
							Activator.log.debug("creation of "+er.geteReference().getName()+"\tin "+container.toString()+"\twith "+ er.getTargetConcretEclasse().getInstanceTypeName());
						}

						// Creates the slot
						EObject newlyIntermediateEObject = EMFCoreUtil.create(container, er.geteReference(), er.getTargetConcretEclasse());
						
						//set name
						if(newlyIntermediateEObject.eClass().getEStructuralFeature("name")!=null){
							newlyIntermediateEObject.eSet(newlyIntermediateEObject.eClass().getEStructuralFeature("name"), er.geteReference().getName());//$NON-NLS-1$	
						}
						
						container=newlyIntermediateEObject;
					}
					//Finally the set the final intermediate with the Source
					EReference er = p.getWay().get(p.getWay().size()-1).geteReference();
					if (FeatureMapUtil.isMany(container,er)) {
						((Collection) container.eGet(er)).add(sourceElement);
					} else {
						container.eSet(er, sourceElement);
					}

					//Graphical command: key question on which element
					DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
					ArrayList<EObject> list = new ArrayList<EObject>();
					if(Activator.log.isDebugEnabled()){
						Activator.log.debug("will display "+container);
					}

					list.add(container);
					dropObjectsRequest.setObjects(list);
					dropObjectsRequest.setLocation(new Point(-1,-1));
					Command command = targetEditPart.getCommand(dropObjectsRequest);
					if( command!=null){
						command.execute();
					}
				}
			};
			cc.add(new CommandProxy(resultCommand));


			if(cc.canExecute()){
				ICommandProxy ic = new ICommandProxy(cc.reduce());
				String[] shortty = p.getName().split(" _ ");
				String name = new String();
				String splitter = new String("");

				if(shortty.length>1){

					name = name.concat("create a ");
					int n=0;
					for(String s : shortty){
						String[] t = s.split("@");

						if(n==shortty.length-1){
							splitter = " with your dropped element referenced as ";
							name = name.concat(splitter+ t[0].replace("org.eclipse.uml2.uml.", "")+"("+t[3].replace("org.eclipse.uml2.uml.", "")+")");
						}
						else{
							name = name.concat(splitter+ t[0].replace("org.eclipse.uml2.uml.", "")+"("+t[3].replace("org.eclipse.uml2.uml.", "")+")");
							splitter = " with ";
						}
						n++;
					}
				}
				else{
					String[] t = shortty[0].split("@");
					name = name.concat("create a reference of your dropped element as ("+t[3].replace("org.eclipse.uml2.uml.", "")+")");
				}
				
				ic.setLabel("SmartDrop "+(shortty.length-1)+": "+name);
				myCommands.add(ic);
			}

		}

		return myCommands;
	}

}

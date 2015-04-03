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
package org.eclipse.papyrus.uml.diagram.dnd.signal2reception;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.tools.uml.graph.uml2pseudograph.api.Uml2GraphServices;
import org.eclipse.papyrus.uml.diagram.dnd.Activator;
import org.eclipse.papyrus.uml.diagram.dnd.messages.Messages;
//import org.eclipse.papyrus.tools.uml.graph.uml2pseudograph.api.Uml2GraphServices;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * A DropStrategy to "Signal" a Class.
 * Drop a signal on a Class operation section to type it.
 * This will create a new Reception operation in the interaction, typed by the dropped classifier.
 *
 * @author Francois Le Fevre
 *
 */
public class SignalToReceptionDropStrategy extends TransactionalDropStrategy {

	public String getLabel() {
		return Messages.SignalToReceptionDropStrategy_Label;
	}

	public String getDescription() {
		return Messages.SignalToReceptionDropStrategy_Description;
	}

	public Image getImage() {
		return null;
	}

	public String getID() {
		return Activator.PLUGIN_ID + ".signal.represents"; //$NON-NLS-1$
	}

	@Override
	protected Command doGetCommand(Request request, EditPart targetEditPart) {
		final UMLFactory umlFactory = UMLFactory.eINSTANCE;

		List<EObject> sourceElements = getSourceEObjects(request);
		// The only supported case is "Drop a single signal on a single Operation of a Classifier"
		if (sourceElements.size() != 1) {
			return null;
		}
		final EObject sourceElement = sourceElements.get(0);

		final String sourceClassPackaged = sourceElement.eClass().getInstanceTypeName();
		final String sourceClass = sourceClassPackaged.substring(sourceClassPackaged.lastIndexOf(".")+1);

		final EObject targetElement = getTargetSemanticElement(targetEditPart);

		final String targetClassPackaged = targetElement.eClass().getInstanceTypeName();
		if(Activator.log.isDebugEnabled()){
			Activator.log.debug("targetelement="+targetElement);//$NON-NLS-1$
		}

		List<String> potentialActions = Uml2GraphServices.guessMyPotentialDirectActions(sourceClassPackaged, targetClassPackaged);
		if(potentialActions.size()!=1){
			if(Activator.log.isDebugEnabled()){
				Activator.log.debug("multiple actions are not take into account="+potentialActions);//$NON-NLS-1$
			}
			return null;
		}
		else{
			if(Activator.log.isDebugEnabled()){
				Activator.log.debug("potentialActions "+potentialActions);//$NON-NLS-1$
			}
			String eclass2Create = potentialActions.get(0);

			//Extracting class short name to create
			final String todo = new String(eclass2Create.substring(eclass2Create.lastIndexOf(".")+1));

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(sourceElement);
			if(provider == null) {
				return null;
			}

			Command resultCommand = new Command(getLabel()) {
				@SuppressWarnings("unchecked")
				@Override
				public void execute() {

					Method m;
					try {

						//Creation of new Object that respects Source x Target
						m = umlFactory.getClass().getMethod("create"+todo);//$NON-NLS-1$
						Object myTodo = m.invoke(umlFactory, null);

						//Association of the new Object with the Source
						Method m2;
						Class[] parameterTypes2 = new Class[1];

						parameterTypes2[0] = Class.forName(sourceClassPackaged);
						m2 = myTodo.getClass().getMethod("set"+sourceClass, parameterTypes2);//$NON-NLS-1$
						m2.invoke(myTodo, new Object[] {sourceElement});

						//TRACE
						if(Activator.log.isDebugEnabled()){
							Activator.log.debug(("((Reception)myTodo).getSignal()="+((Reception)myTodo).getSignal().getName()));//$NON-NLS-1$
							Activator.log.debug("targetElement="+((org.eclipse.uml2.uml.Class)targetElement).getOwnedReceptions());//$NON-NLS-1$
						}

						//Setting the name of the new Object
						parameterTypes2[0] = Class.forName("java.lang.String");//$NON-NLS-1$
						m2 = myTodo.getClass().getMethod("setName", parameterTypes2);//$NON-NLS-1$
						if(m2!=null){
							String name = todo+"From"+sourceClass;
							m2.invoke(myTodo, new Object[] {name});
						}

						//Adding the new Object to the Target 
						EStructuralFeature esfOwned = targetElement.eClass().getEStructuralFeature("owned"+todo);//$NON-NLS-1$
						if(esfOwned.getUpperBound()==-1){
							if ( targetElement.eGet(esfOwned) instanceof Collection){
								((Collection<Object>)targetElement.eGet(esfOwned)).add(myTodo);
							}
							else{
								targetElement.eSet(esfOwned, myTodo);
							}
						}


					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}

				}
			};
			return resultCommand;
		}
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

}

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
package org.eclipse.papyrus.uml.diagram.dnd.smart;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalCommandsDropStrategy;
import org.eclipse.papyrus.tools.uml.graph.uml2pseudograph.api.Uml2GraphServices;
import org.eclipse.papyrus.tools.uml.graph.uml2pseudograph.model.LinkedEClazz;
import org.eclipse.papyrus.uml.diagram.dnd.Activator;
import org.eclipse.papyrus.uml.diagram.dnd.messages.Messages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * A SmartDrop strategy of a Source to A target.
 * Drop a source element from the model explorer to a target element in the diagram view.
 * This will create a proposition of commands to be executed.
 * It will find any relationship from the target to the source with a lenght path of one given by the meta uml model
 * Source x SmartElement X Target.
 *
 * @author Francois Le Fevre
 *
 */
public class SmartDropStrategy extends TransactionalCommandsDropStrategy {

	public String getLabel() {
		return new String(Messages.SmartDropStrategy_Label);
	}

	public String getDescription() {
		return new String(Messages.SmartDropStrategy_Description);
	}

	public Image getImage() {
		return null;
	}

	public String getID() {
		return Activator.PLUGIN_ID + ".smart.represents"; //$NON-NLS-1$
	}

	protected List<Command> doGetCommands(Request request, EditPart targetEditPart) {
		List<Command> commands = new ArrayList<Command>();

		final UMLFactory umlFactory = UMLFactory.eINSTANCE;

		List<EObject> sourceElements = getSourceEObjects(request);

		// The only supported case is "Drop a single signal on a single Operation of a Classifier"
		if (sourceElements.size() != 1) {
			return null;
		}

		//Dealing with only one source
		final EObject sourceElement = sourceElements.get(0);
		final String nameSourceElement;
		if (sourceElement instanceof NamedElement){
			nameSourceElement=((NamedElement)sourceElement).getName();
		}
		else{
			nameSourceElement=sourceElement.toString();
		}
		final String sourceClassPackaged = sourceElement.eClass().getInstanceTypeName();

		//Dealing with target
		final EObject targetElement = getTargetSemanticElement(targetEditPart);
		final String targetClassPackaged = targetElement.eClass().getInstanceTypeName();

		//Retrieve potential actions
		final List<LinkedEClazz> potentialActions = Uml2GraphServices.guessActions(sourceClassPackaged, targetClassPackaged);

		//Filter actions
		final List<LinkedEClazz> filterActions = filterActions(potentialActions);

		//If no action availabel, return null for the command
		if(filterActions.size()==0){
			return null;
		}
		else{
			//Loop over the action to build the command and add them
			for(LinkedEClazz lec : filterActions){
				Command resultCommand = buildCommand(lec,  umlFactory ,  sourceElement,  nameSourceElement,  targetElement);
				commands.add(resultCommand);
			}
		}

		return commands;
	}   

	private Command buildCommand(LinkedEClazz lec, final UMLFactory umlFactory , final EObject sourceElement, final String nameSourceElement, final EObject targetElement){
		final String eRelation = lec.getName();
		//Extracting class short name to create
		final String eclassPackage2Create = lec.getRelationName();
		final String eclassName2Create = new String(eclassPackage2Create.substring(eclassPackage2Create.lastIndexOf(".")+1)); //$NON-NLS-1$

		Command resultCommand = new Command(Messages.SmartDropStrategy_As +eRelation) {
			@Override
			public void execute() {

				Method m;
				try {

					//Creation of new Object that respects Source x Target
					m = umlFactory.getClass().getMethod("create"+eclassName2Create);//$NON-NLS-1$
					Object myTodo = m.invoke(umlFactory, null);

					//Association of the new Object with the Source by reference
					Activator.log.warn("TODO manage the cardinality for new element to source");//$NON-NLS-1$
					Method m2;
					Class[] parameterTypes2 = new Class[1];

					Method matchMethod = null;
					for(Method method : myTodo.getClass().getMethods()){
						if(method.getParameterTypes().length==1 
								&& method.getName().startsWith("set")){ //$NON-NLS-1$

							Uml2GraphServices.isMyQueryClassAChildrenOfMyParentClass((method.getParameterTypes()[0]).getName(),eclassPackage2Create);
							matchMethod=method;
							break;
						}

					}
					if(matchMethod!=null){
						parameterTypes2[0] = Class.forName((matchMethod.getParameterTypes()[0]).getName());
						m2 = myTodo.getClass().getMethod(matchMethod.getName(), parameterTypes2);
						m2.invoke(myTodo, new Object[] {sourceElement});
					}

					//Setting the name of the new Object given the source
					parameterTypes2[0] = Class.forName("java.lang.String");//$NON-NLS-1$
					m2 = myTodo.getClass().getMethod("setName", parameterTypes2);//$NON-NLS-1$
					if(m2!=null){
						String name = eclassName2Create+"From"+nameSourceElement; //$NON-NLS-1$
						m2.invoke(myTodo, new Object[] {name});
					}


					//Adding the new Object to the Target 
					Activator.log.warn("TODO manage the cardinality for target to new element"); //$NON-NLS-1$
					EStructuralFeature esfOwned = targetElement.eClass().getEStructuralFeature(eRelation);//$NON-NLS-1$

					if(esfOwned.getUpperBound()==-1){
						if ( targetElement.eGet(esfOwned) instanceof Collection){
							((Collection)targetElement.eGet(esfOwned)).add(myTodo);
						}
						else{
							targetElement.eSet(esfOwned, myTodo);
						}
					}
				} catch (NoSuchMethodException e) {
					Activator.log.error(e);
				} catch (SecurityException e) {
					Activator.log.error(e);
				} catch (IllegalAccessException e) {
					Activator.log.error(e);
				} catch (IllegalArgumentException e) {
					Activator.log.error(e);
				} catch (InvocationTargetException e) {
					Activator.log.error(e);
				} catch (ClassNotFoundException e) {
					Activator.log.error(e);
				}

			}
		};

		return resultCommand;

	}

	/**
	 * Utils method to filter the potential actions
	 * Here we never want to be able to associate to the drop a Comment element, because it is really too generic
	 * @param potentialActions
	 * @return
	 */
	private List<LinkedEClazz> filterActions(List<LinkedEClazz> potentialActions) {
		List<LinkedEClazz> result = new ArrayList<LinkedEClazz>();
		for(LinkedEClazz pa : potentialActions){
			if(pa.getRelationName().compareTo("org.eclipse.uml2.uml.Comment")!=0 ){ //$NON-NLS-1$
				result.add(pa);
			}
		}
		return result;
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

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

package org.eclipse.papyrus.propertylifecycle.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;
import org.eclipse.papyrus.propertylifecycle.AbstractValueProcessor;
import org.eclipse.papyrus.propertylifecycle.ElementProperty;
import org.eclipse.papyrus.propertylifecycle.JavaProcessor;
import org.eclipse.papyrus.propertylifecycle.utils.CommandValueProcessor;

/**
 * The command retrieved from the applicable strategies
 */
public class LifeCycleEditElementCommand extends EditElementCommand {

	private String featureLabel;
	private ElementProperty featureStrategy;
	// private Map<String, Object> accessedProcessors;
	private AbstractEditCommandRequest request;
	// private EObject elementToEdit;

	/**
	 * Constructor.
	 *
	 * @param commandLabel
	 *            The label of the command
	 * @param elementToEdit
	 *            The element to edit
	 * @param request
	 *            The request to edit the element
	 * @param featureLabel
	 *            The key used to sort through the possible strategies (the feature to edit)
	 * @param featureStrategy
	 *            The {@link org.eclipse.papyrus.propertylifecycle.ElementProperty informations} used to calculate the new value
	 * @param accessedProcessors
	 *            The accessed processors
	 */
	public LifeCycleEditElementCommand(String commandLabel, EObject elementToEdit, AbstractEditCommandRequest request,
			String featureLabel, ElementProperty featureStrategy, Map<String, Object> accessedProcessors) {
		super(commandLabel, elementToEdit, request);
		// this.elementToEdit = elementToEdit;
		this.request = request;
		this.featureLabel = featureLabel;
		this.featureStrategy = featureStrategy;
		// this.accessedProcessors = accessedProcessors == null ? new HashMap<String, Object>() : accessedProcessors;
	}

	/**
	 * Constructor.
	 *
	 * @param commandLabel
	 *            The label of the command
	 * @param elementToEdit
	 *            The element to edit
	 * @param request
	 *            The request to edit the element
	 * @param featureLabel
	 *            The key used to sort through the possible strategies (the feature to edit)
	 * @param featureStrategy
	 *            The {@link org.eclipse.papyrus.propertylifecycle.ElementProperty informations} used to calculate the new value
	 */
	public LifeCycleEditElementCommand(String commandLabel, EObject elementToEdit, AbstractEditCommandRequest request,
			String featureLabel, ElementProperty featureStrategy) {
		this(commandLabel, elementToEdit, request, featureLabel, featureStrategy, null);
	}

	/**
	 * Constructor.
	 *
	 * @param commandLabel
	 *            The label of the command
	 * @param request
	 *            The request to edit the element
	 * @param featureLabel
	 *            The key used to sort through the possible strategies (the feature to edit)
	 * @param featureStrategy
	 *            The {@link org.eclipse.papyrus.propertylifecycle.ElementProperty informations} used to calculate the new value
	 */
	public LifeCycleEditElementCommand(String commandLabel, AbstractEditCommandRequest request,
			String featureLabel, ElementProperty featureStrategy) {
		this(commandLabel, (EObject) request.getElementsToEdit().get(0), request, featureLabel, featureStrategy, null);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		// Get the ICommand built in the processor and execute them in order to build the CommandResult
		ICommand cmd = setProcessorValue(featureLabel, featureStrategy);
		if (cmd == null || cmd instanceof UnexecutableCommand) {
			throw new OperationCanceledException();
		}

		cmd.execute(monitor, info);

		return cmd.getCommandResult();
	}

	/**
	 * Filter the processors to return the correct {@link org.eclipse.gmf.runtime.common.core.command.Commandresult}
	 * 
	 * @param property
	 *            The {@link org.eclipse.papyrus.propertylifecycle.ElementProperty property} of the strategy
	 * @param elementType
	 *            The element type of the element
	 * @return
	 * 		The {@link org.eclipse.gmf.runtime.common.core.command.Commandresult} of the element's edition
	 */
	private ICommand setProcessorValue(String featureLabel, ElementProperty property) {
		AbstractValueProcessor propertyProcessor = property.getValueProcessor();

		if (propertyProcessor instanceof JavaProcessor) {
			// Cache the processor in order to limit the number of calls to the loader
			Object processor;
			String className = ((JavaProcessor) (property.getValueProcessor())).getClassName();
			// if (!accessedProcessors.containsKey(className)) {
			processor = ClassLoaderHelper.newInstance(className);
			// accessedProcessors.put(className, processor);
			// } else {
			// processor = accessedProcessors.get(className);
			// }

			if (processor instanceof CommandValueProcessor) {
				boolean isImmutable = property.getPriority() < 0 ? true : false;
				return ((CommandValueProcessor) processor).setValueFromRequest(featureLabel, isImmutable, request);
			}
		}

		return null;
	}

}

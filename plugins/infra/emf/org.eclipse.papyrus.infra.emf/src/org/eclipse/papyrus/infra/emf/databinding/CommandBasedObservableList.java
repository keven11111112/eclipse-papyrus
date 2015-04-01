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
package org.eclipse.papyrus.infra.emf.databinding;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ObservableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Camille Letavernier
 *
 */
public class CommandBasedObservableList extends ObservableList implements IChangeListener, IObserving {

	/**
	 * The editing domain on which the commands will be executed
	 */
	protected EditingDomain editingDomain;

	/**
	 * The edited EObject
	 */
	protected EObject source;

	/**
	 * The feature being edited
	 */
	protected EStructuralFeature feature;

	/**
	 *
	 * Constructor.
	 *
	 * @param wrappedList
	 *            The list to be edited when #commit() is called
	 * @param domain
	 *            The editing domain on which the commands will be executed
	 * @param source
	 *            The EObject from which the list will be retrieved
	 * @param feature
	 *            The feature from which the list will be retrieved
	 */
	public CommandBasedObservableList(List<?> wrappedList, EditingDomain domain, EObject source, EStructuralFeature feature) {
		super(wrappedList, Object.class);

		this.editingDomain = domain;
		this.source = source;
		this.feature = feature;

		if (wrappedList instanceof IObservableList) {
			((IObservableList) wrappedList).addChangeListener(this);
		}
	}

	@Override
	public Object getObserved() {
		return source;
	}

	@Override
	public synchronized void dispose() {
		if (wrappedList instanceof IObservableList) {
			((IObservableList) wrappedList).removeChangeListener(this);
		}
		super.dispose();
	}

	@Override
	public void add(int index, Object value) {
		Command command = getAddCommand(index, value);
		execute(command);
	}

	protected void execute(Command emfCommand) {
		editingDomain.getCommandStack().execute(emfCommand);
		fireListChange(null);
	}

	@Override
	public void clear() {
		Command command = getClearCommand();
		execute(command);
	}

	@Override
	public boolean add(Object o) {
		Command command = getAddCommand(o);
		execute(command);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		boolean result = contains(o);
		Command command = getRemoveCommand(o);
		execute(command);
		return result;
	}

	@Override
	public boolean addAll(Collection c) {
		Command command = getAddAllCommand(c);
		execute(command);
		return true;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		Command command = getAddAllCommand(index, c);
		execute(command);
		return true;
	}

	@Override
	public boolean removeAll(Collection c) {
		Command command = getRemoveCommand(c);
		execute(command);
		return true;
	}

	@Override
	public boolean retainAll(Collection c) {
		Command command = getRetainAllCommand(c);
		execute(command);
		return true;
	}

	@Override
	public Object set(int index, Object element) {
		Object result = index < size() ? get(index) : null;
		Command command = getSetCommand(index, element);
		execute(command);
		return result;
	}

	@Override
	public Object move(int oldIndex, int newIndex) {
		Object value = get(oldIndex);
		for (Command command : getMoveCommands(oldIndex, newIndex)) {
			execute(command);
		}
		return value;
	}

	@Override
	public Object remove(int index) {
		Object value = get(index);
		if (value != null) {
			Command command = getRemoveCommand(index);
			execute(command);
		}
		return value;
	}

	public Command getAddCommand(int index, Object value) {
		return AddCommand.create(editingDomain, source, feature, value, index);
	}

	public Command getAddCommand(Object value) {
		return AddCommand.create(editingDomain, source, feature, value);
	}

	public Command getAddAllCommand(Collection<?> values) {
		return AddCommand.create(editingDomain, source, feature, values);
	}

	public Command getAddAllCommand(int index, Collection<?> values) {
		return AddCommand.create(editingDomain, source, feature, values, index);
	}

	public Command getClearCommand() {
		return getRemoveAllCommand(new LinkedList<Object>(this));
	}

	public Command getRemoveCommand(int index) {
		Object value = get(index);
		return getRemoveCommand(value);
	}

	public Command getRemoveCommand(Object value) {
		Command cmd = RemoveCommand.create(editingDomain, source, feature, value);
		if (value instanceof EObject && feature instanceof EReference && ((EReference) feature).isContainment()) {
			addDestroyCommand(cmd, (EObject) value);
		}
		return cmd;
	}

	public Command getRemoveAllCommand(Collection<?> values) {
		CompoundCommand cc = new CompoundCommand("Edit list");

		if (feature instanceof EReference && ((EReference) feature).isContainment() && values != null) {
			for (Object o : values) {
				if (o instanceof EObject) {
					addDestroyCommand(cc, (EObject) o);
				}
			}
		}

		cc.append(RemoveCommand.create(editingDomain, source, feature, values));
		return cc;
	}

	public List<Command> getMoveCommands(int oldIndex, int newIndex) {
		Object value = get(oldIndex);
		List<Command> commands = new LinkedList<Command>();
		commands.add(getRemoveCommand(value));
		commands.add(getAddCommand(newIndex, value));
		return commands;
	}

	public Command getRetainAllCommand(Collection<?> values) {
		List<Object> objectsToRemove = new LinkedList<Object>();
		for (Object object : values) {
			if (!contains(object)) {
				objectsToRemove.add(object);
			}
		}
		if (!objectsToRemove.isEmpty()) {
			return getRemoveAllCommand(objectsToRemove);
		} else {
			return null;
		}
	}

	public Command getSetCommand(int index, Object value) {
		Object oldValue = get(index);
		Command command = SetCommand.create(editingDomain, source, feature, value, index);
		if (oldValue instanceof EObject && feature instanceof EReference && ((EReference) feature).isContainment()) {
			addDestroyCommand(command, (EObject) oldValue);
		}
		return command;
	}

	protected void addDestroyCommand(Command cmd, EObject objToDestroy) {
		Command destroyCmd = DeleteCommand.create(editingDomain, objToDestroy);

		if (cmd instanceof CompoundCommand) {
			((CompoundCommand) cmd).append(destroyCmd);
		} else {
			cmd.chain(destroyCmd);
		}
	}

	/**
	 * @see org.eclipse.core.databinding.observable.IChangeListener#handleChange(org.eclipse.core.databinding.observable.ChangeEvent)
	 *
	 * @param event
	 */
	@Override
	public void handleChange(ChangeEvent event) {
		fireListChange(null);
	}

}

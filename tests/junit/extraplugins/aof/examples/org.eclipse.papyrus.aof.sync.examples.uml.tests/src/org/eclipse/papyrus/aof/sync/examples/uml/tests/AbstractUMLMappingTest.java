/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.aof.sync.examples.uml.tests;



import java.util.function.Consumer;

import javax.inject.Inject;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.papyrus.aof.sync.tests.AbstractBaseMappingTest;
import org.eclipse.papyrus.aof.sync.tests.ModelFixtureRuleModule;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;
import org.eclipse.papyrus.junit.utils.rules.ResourceSetFixture;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.junit.Rule;

/**
 * Common structure of UML example mapping tests.
 */
@InjectWith({ ModelFixtureRuleModule.class, TestModelModule.class })
public abstract class AbstractUMLMappingTest<T extends EObject> extends AbstractBaseMappingTest<T, T> {

	@Rule
	public final ResourceSetFixture rset = new ResourceSetFixture();

	@Inject
	protected UMLFactory uml;

	public AbstractUMLMappingTest() {
		super();
	}

	//
	// Test framework
	//

	protected CommandBuilder exec() {
		return new CommandBuilder();
	}

	protected void add(Object owner, Object feature, Object element) {
		exec().add(owner, feature, element).execute();
	}

	protected void set(Object owner, Object feature, Object value) {
		exec().set(owner, feature, value).execute();
	}

	public <N extends NamedElement> N create(Object owner, EReference feature, java.lang.Class<N> type, String name) {
		return create(owner, feature, type, name, null);
	}

	public <N extends NamedElement> N create(Object owner, EReference feature, java.lang.Class<N> type, String name, Consumer<? super N> initializer) {
		N result = type.cast(uml.create((EClass) uml.getEPackage().getEClassifier(type.getSimpleName())));
		result.setName(name);

		if (initializer != null) {
			initializer.accept(result);
		}

		add(owner, feature, result);
		return result;
	}

	//
	// Nested types
	//

	protected class CommandBuilder {
		private Command command = null;

		private CommandBuilder() {
			super();
		}

		private CommandBuilder append(Command command) {
			if (this.command == null) {
				this.command = command;
			} else {
				this.command = this.command.chain(command);
			}
			return this;
		}

		public CommandBuilder add(Object owner, Object feature, Object element) {
			return append(AddCommand.create(rset.getEditingDomain(), owner, feature, element));
		}

		public CommandBuilder set(Object owner, Object feature, Object value) {
			return append(SetCommand.create(rset.getEditingDomain(), owner, feature, value));
		}

		public void execute() {
			rset.getEditingDomain().getCommandStack().execute(command);
			command = null;
		}
	}

}

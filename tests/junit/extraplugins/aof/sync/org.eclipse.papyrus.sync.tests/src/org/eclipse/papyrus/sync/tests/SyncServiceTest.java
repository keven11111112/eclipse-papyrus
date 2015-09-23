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

package org.eclipse.papyrus.sync.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceSet;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.eclipse.papyrus.junit.utils.rules.JavaResource;
import org.eclipse.papyrus.junit.utils.rules.ModelSetFixture;
import org.eclipse.papyrus.junit.utils.rules.ServiceRegistryModelSetFixture;
import org.eclipse.papyrus.sync.ISyncListener;
import org.eclipse.papyrus.sync.ISyncService;
import org.eclipse.papyrus.sync.SyncEvent;
import org.eclipse.papyrus.sync.internal.SyncMappingModel;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test cases for the {@link SyncMappingModel} class.
 */
@JavaResource("capsules-with-machines.di")
public class SyncServiceTest extends AbstractPapyrusTest {
	@ClassRule
	public static final TestSyncDelegateRule delegateRule = new TestSyncDelegateRule();

	@Rule
	public final HouseKeeper houseKeeper = new HouseKeeper();

	@Rule
	public final ModelSetFixture model = new ServiceRegistryModelSetFixture();

	private ServicesRegistry serviceRegistry;

	private ISyncService fixture;

	private Class capsule1;

	private Class capsule2;

	public SyncServiceTest() {
		super();
	}

	@Test
	public void canSynchronize() {
		assertThat(fixture.canSynchronize(capsule1, capsule2), is(true));
		assertThat(fixture.canSynchronize(capsule1.getClassifierBehavior(), capsule2), is(false));
	}

	@Test
	public void synchronize() {
		Object reference = synchronize(capsule1, capsule2);

		assertThat(capsule2.getClassifierBehavior(), notNullValue());
		assertThat(capsule2.getClassifierBehavior().getName(), is(capsule1.getClassifierBehavior().getName()));

		assertThat(fixture.getSource(reference), is(capsule1));
		assertThat(fixture.getTarget(reference), is(capsule2));

		// Make a change and verify that it was propagated
		model.execute(SetCommand.create(model.getEditingDomain(), capsule1.getClassifierBehavior(), UMLPackage.Literals.NAMED_ELEMENT__NAME, "Foo"));
		assertThat(capsule2.getClassifierBehavior().getName(), is(capsule1.getClassifierBehavior().getName()));
	}

	@Test
	public void unsynchronize() {
		Object reference = synchronize(capsule1, capsule2);

		assumeThat(capsule2.getClassifierBehavior(), notNullValue());
		assumeThat(capsule2.getClassifierBehavior().getName(), is(capsule1.getClassifierBehavior().getName()));

		unsynchronize(reference);

		// Make a change and verify that it wasn't propagated
		model.execute(SetCommand.create(model.getEditingDomain(), capsule1.getClassifierBehavior(), UMLPackage.Literals.NAMED_ELEMENT__NAME, "Foo"));
		assertThat(capsule2.getClassifierBehavior().getName(), not(capsule1.getClassifierBehavior().getName()));
	}

	@Test
	public void getSynchronizations() {
		Object reference = synchronize(capsule1, capsule2);

		assertThat(reference, notNullValue());

		assertThat(fixture.getSynchronizationReferences().size(), is(1));
		assertThat(fixture.getSynchronizationReferences().contains(reference), is(true));
	}

	@Test
	public void listener() {
		List<SyncEvent.SyncEventKind> events = new ArrayList<>();
		ISyncListener listener = new ISyncListener() {

			@Override
			public void synchronizationChanged(SyncEvent event) {
				assertThat(event.getSource(), is(fixture));
				assertThat(event.getSynchronizationReference(), notNullValue());
				assertThat(event.getSyncSource(), is(capsule1));
				assertThat(event.getSyncTarget(), is(capsule2));

				events.add(event.getEventType());
			}
		};

		fixture.addSyncListener(listener);

		Object reference = synchronize(capsule1, capsule2);
		assertThat(events, is(Arrays.asList(SyncEvent.SyncEventKind.SYNCHRONIZATION_ADDED)));

		unsynchronize(reference);
		assertThat(events, is(Arrays.asList(SyncEvent.SyncEventKind.SYNCHRONIZATION_ADDED,
				SyncEvent.SyncEventKind.SYNCHRONIZATION_REMOVED)));
	}

	//
	// Test framework
	//

	@Before
	public void initServiceRegistry() throws ServiceException {
		serviceRegistry = ServiceUtilsForResourceSet.getInstance().getServiceRegistry(model.getResourceSet());
		fixture = serviceRegistry.getService(ISyncService.class);

		assumeThat("No sync service", fixture, notNullValue());

		capsule1 = (Class) model.getModel().getOwnedType("Capsule1");
		capsule2 = (Class) model.getModel().getOwnedType("Capsule2");
	}

	Object synchronize(Object source, Object target) {
		Object[] result = { null };

		model.execute(new RecordingCommand(model.getEditingDomain(), "Synchronize") {

			@Override
			protected void doExecute() {
				result[0] = fixture.synchronize(source, target);
			}
		});

		return result[0];
	}

	void unsynchronize(Object synchReference) {
		model.execute(new RecordingCommand(model.getEditingDomain(), "Unsynchronize") {

			@Override
			protected void doExecute() {
				fixture.unsynchronize(synchReference);
			}
		});
	}
}

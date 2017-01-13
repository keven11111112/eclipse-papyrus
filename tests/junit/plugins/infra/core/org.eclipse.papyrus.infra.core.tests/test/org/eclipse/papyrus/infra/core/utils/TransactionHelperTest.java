/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.core.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.tools.util.IProgressCallable;
import org.eclipse.papyrus.infra.tools.util.IProgressRunnable;
import org.eclipse.papyrus.junit.utils.PrintingProgressMonitor;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

/**
 * Automated tests for the {@link TransactionHelper} class.
 */
public class TransactionHelperTest {

	private static ExecutorService exec;

	@Rule
	public final HouseKeeper houseKeeper = new HouseKeeper();

	private TransactionalEditingDomain domain;
	private EClass eclass;

	/**
	 * Initializes me.
	 */
	public TransactionHelperTest() {
		super();
	}

	@Test
	public void testPrivilegedProgressRunnable() {
		IProgressRunnable runnable = monitor -> {
			monitor.beginTask("Test privileged runnable", 2);

			eclass.setAbstract(true);
			monitor.worked(1);
			eclass.setName("Foo");
			monitor.worked(1);

			monitor.done();
		};

		FailureAssertion failure = new FailureAssertion();
		domain.getCommandStack().execute(new RecordingCommand(domain, "Test") {

			@Override
			protected void doExecute() {
				IProgressRunnable privileged = TransactionHelper.createPrivilegedRunnable(domain, runnable);
				Future<?> future = submit(privileged);

				// And synchronize with it
				try {
					future.get();
				} catch (Exception e) {
					failure.accept(e);
				}
			}
		});

		failure.verify();

		assertThat(eclass.isAbstract(), is(true));
		assertThat(eclass.getName(), is("Foo"));
	}

	@Test
	public void testPrivilegedProgressCallable() {
		IProgressCallable<String> callable = monitor -> {
			monitor.beginTask("Test privileged callable", 2);

			eclass.setAbstract(true);
			monitor.worked(1);
			eclass.setName("Foo");
			monitor.worked(1);

			monitor.done();

			return eclass.getName();
		};

		FailureAssertion failure = new FailureAssertion();
		domain.getCommandStack().execute(new RecordingCommand(domain, "Test") {

			@Override
			protected void doExecute() {
				IProgressCallable<String> privileged = TransactionHelper.createPrivilegedCallable(domain, callable);
				Future<String> future = submit(privileged);

				// And synchronize with it
				try {
					String newName = future.get();
					assertThat(newName, is("Foo"));
				} catch (Exception e) {
					failure.accept(e);
				}
			}
		});

		failure.verify();

		assertThat(eclass.isAbstract(), is(true));
		assertThat(eclass.getName(), is("Foo"));
	}

	//
	// Test framework
	//

	@BeforeClass
	public static void createExecutorService() {
		exec = Executors.newSingleThreadExecutor();
	}

	@Before
	public void createFixture() throws Exception {
		domain = houseKeeper.createSimpleEditingDomain();
		Resource res = domain.createResource("file:bogus.ecore");

		TransactionHelper.run(domain, () -> {
			EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
			res.getContents().add(epackage);
			eclass = EcoreFactory.eINSTANCE.createEClass();
			epackage.getEClassifiers().add(eclass);
		});
	}

	@AfterClass
	public static void shutdownExecutorService() {
		exec.shutdown();
		exec = null;
	}

	<V> Future<V> submit(IProgressCallable<V> callable) {
		return exec.submit(() -> callable.call(new PrintingProgressMonitor()));
	}

	Future<?> submit(IProgressRunnable runnable) {
		return exec.submit(() -> runnable.run(new PrintingProgressMonitor()));
	}

	//
	// Nested types
	//

	private static final class FailureAssertion implements Consumer<Throwable> {
		private Throwable thrown;

		@Override
		public void accept(Throwable t) {
			// Take only the first one
			if (thrown == null) {
				thrown = t;
			}
		}

		void verify() {
			if (thrown != null) {
				thrown.printStackTrace();
				fail("Synchronization on future result failed: " + thrown.getMessage());
			}
		}
	}
}

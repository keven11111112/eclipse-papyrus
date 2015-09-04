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

package org.eclipse.papyrus.aof.sync.tests.runners;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.eclipse.papyrus.junit.framework.classification.ClassificationRunner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * <p>
 * A test runner that injects dependencies into tests using Google Guice.
 * <b>Note</b> that
 * <p>
 * <ul>
 * <li>an {@link InjectWith @InjectWith} annotation on a method overrides the modules
 * specified by an annotation, if any, on the suite class. It does not add to them</li>
 * <li>the injector created as the default for test cases (as specified by the
 * {@link InjectWith @InjectWith} annotation on the class) is shared by all test cases.
 * They do not get each their own injector</li>
 * <li>because of the way that the extended runner infrastructure creates test instances,
 * the test constructor cannot be injected. Only member injection is supported</li>
 * </ul>
 */
public class GuiceRunner extends ClassificationRunner {
	private final AtomicReference<Injector> suiteInjector = new AtomicReference<>();
	private final ThreadLocal<Injector> testInjector = new ThreadLocal<>();

	public GuiceRunner(Class<?> class_) throws InitializationError {
		super(class_);
	}

	/**
	 * @see org.eclipse.papyrus.junit.framework.classification.ClassificationRunner#classBlock(org.junit.runner.notification.RunNotifier)
	 *
	 * @param notifier
	 * @return
	 */
	@Override
	protected Statement classBlock(RunNotifier notifier) {
		Statement base = super.classBlock(notifier);
		Statement result = base;

		InjectWith injectWith = getTestClass().getAnnotation(InjectWith.class);
		if (injectWith != null) {
			suiteInjector.set(createInjector(injectWith));
			result = new Statement() {

				@Override
				public void evaluate() throws Throwable {
					Injector injector = createInjector(injectWith);
					suiteInjector.set(injector);
					try {
						base.evaluate();
					} finally {
						suiteInjector.compareAndSet(injector, null);
					}
				}
			};
		}

		return result;
	}

	@Override
	protected void runChild(FrameworkMethod method, RunNotifier notifier) {
		InjectWith injectWith = method.getAnnotation(InjectWith.class);
		if (injectWith != null) {
			testInjector.set(createInjector(injectWith));
		} else {
			testInjector.set(suiteInjector.get());
		}

		try {
			super.runChild(method, notifier);
		} finally {
			testInjector.remove();
		}
	}

	@Override
	protected Object createTest() throws Exception {
		Object result = super.createTest();
		inject(result);
		return result;
	}

	protected void inject(Object test) {
		Injector injector = testInjector.get();
		if (injector != null) {
			injector.injectMembers(test);
		}
	}

	protected Injector createInjector(InjectWith injectWith) {
		List<AbstractModule> modules = Arrays.asList(injectWith.value()).stream()
				.map(this::createModule).collect(Collectors.toList());
		return Guice.createInjector(modules);
	}

	private AbstractModule createModule(Class<? extends AbstractModule> class_) {
		try {
			return class_.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Could not instantiate test's injector module: " + e.getMessage());
			return null; // Unreachable
		}
	}
}

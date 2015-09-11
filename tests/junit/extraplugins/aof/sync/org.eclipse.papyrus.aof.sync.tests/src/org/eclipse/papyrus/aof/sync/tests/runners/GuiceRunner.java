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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.papyrus.junit.framework.classification.ClassificationRunner;
import org.eclipse.papyrus.junit.utils.JUnitUtils;
import org.eclipse.papyrus.junit.utils.rules.AbstractHouseKeeperRule;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper.Disposer;
import org.junit.Rule;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.Scope;

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
 * <p>
 * The modules the configure the test execution may bind dependencies to test-scoped
 * singletons using the {@link TestScoped @TestScoped} annotation. These dependencies
 * are created as necessary for each test, at most once, and are forgotten at the
 * conclusion of the test.
 * </p>
 * 
 * @see TestScoped {@literal @TestScoped}
 * @see InjectWith {@literal @InjectWith}
 */
public class GuiceRunner extends ClassificationRunner {
	private final AtomicReference<Injector> suiteInjector = new AtomicReference<>();
	private final ThreadLocal<Injector> testInjector = new ThreadLocal<>();
	private final ThreadLocal<Object> testInstance = new ThreadLocal<>();
	private final ThreadLocal<TestScope> testScope = new ThreadLocal<>();

	private Description suiteDescription;

	public GuiceRunner(Class<?> class_) throws InitializationError {
		super(class_);
	}

	@Override
	public Description getDescription() {
		if (suiteDescription == null) {
			suiteDescription = super.getDescription();
		}
		return suiteDescription;
	}

	@Override
	protected Statement classBlock(RunNotifier notifier) {
		Statement base = super.classBlock(notifier);
		Statement result = base;

		InjectWith injectWith = getTestClass().getAnnotation(InjectWith.class);
		if (injectWith != null) {
			result = new Statement() {

				@Override
				public void evaluate() throws Throwable {
					Injector injector = createInjector(injectWith, getDescription());
					suiteInjector.set(injector);
					try {
						base.evaluate();
					} finally {
						suiteInjector.compareAndSet(injector, null);
						suiteDescription = null;
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
			testInjector.set(createInjector(injectWith, describeChild(method)));
		} else {
			testInjector.set(suiteInjector.get());
		}

		TestScope scope = new TestScope();
		testScope.set(scope);

		try {
			super.runChild(method, notifier);
		} finally {
			testInstance.remove();
			testInjector.remove();

			testScope.remove();
			scope.dispose();
		}
	}

	@Override
	protected Object createTest() throws Exception {
		Object result = super.createTest();
		inject(result);

		// If case the test has a housekeeper rule, let it clean up our injector
		handleHouseKeeperRule(result);

		return result;
	}

	protected void inject(Object test) {
		Injector injector = testInjector.get();
		if (injector != null) {
			testInstance.set(test);
			injector.injectMembers(test);
		}
	}

	protected Injector createInjector(InjectWith injectWith, Description description) {
		List<Module> modules = Stream.of(injectWith.value())
				.map(this::createModule).collect(Collectors.toList());

		modules.add(new TestMetadataModule(description));

		return Guice.createInjector(modules);
	}

	private Module createModule(Class<? extends Module> class_) {
		try {
			return class_.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Could not instantiate test's injector module: " + e.getMessage());
			return null; // Unreachable
		}
	}

	private void handleHouseKeeperRule(Object test) {
		for (Field next : test.getClass().getFields()) {
			if (next.isAnnotationPresent(Rule.class)) {
				if (((next.getModifiers() & Modifier.STATIC) == 0) && AbstractHouseKeeperRule.class.isAssignableFrom(next.getType())) {
					try {
						AbstractHouseKeeperRule housekeeper = (AbstractHouseKeeperRule) next.get(test);
						housekeeper.cleanUpLater(testScope, new Disposer<ThreadLocal<TestScope>>() {
							@Override
							public void dispose(ThreadLocal<TestScope> object) throws Exception {
								TestScope scope = object.get();
								if (scope != null) {
									scope.dispose();
								}
							}
						});
					} catch (Exception e) {
						// Really shouldn't happen with this public field
						throw new AssertionError("Reflection error on JUnit rule field", e);
					}
				}
			}
		}
	}

	//
	// Nested types
	//

	/**
	 * A Guice module that provides injection of test metadata, including
	 * <ul>
	 * <li>the test {@link Description}</li>
	 * <li>any {@link Annotation}s applied to the test or its containing suite class</li>
	 * <li>the test instance, itself, for any injection of the test class type or some
	 * supertype thereof (to support abstract test classes)</li>
	 * <li>the test instance, itself, for any injection of type {@link Object} qualified
	 * by {@link TestInstance @TestInstance}</li>
	 * </ul>
	 */
	private class TestMetadataModule extends AbstractModule {
		private final Description description;

		TestMetadataModule(Description description) {
			super();

			this.description = description;
		}

		@Override
		protected void configure() {
			// Bind the description
			bind(Description.class).toInstance(description);

			// And its annotations
			for (Annotation next : JUnitUtils.getAnnotations(description)) {
				bindAnnotation(next.annotationType(), next);
			}

			// Link the test-instance type bindings to the test instance
			if (description.getTestClass() != null) {
				for (Class<?> class_ = description.getTestClass(); (class_ != null) && (class_ != Object.class); class_ = class_.getSuperclass()) {
					bind(class_).toProvider(getTestInstanceProvider());
				}
			}

			// And the annotated object
			bind(Object.class).annotatedWith(TestInstance.class).toProvider(getTestInstanceProvider());

			// Bind the test scope, which is only plausibly defined for test cases
			bindScope(TestScoped.class, new Scope() {

				@Override
				public <T> Provider<T> scope(Key<T> key, Provider<T> unscoped) {
					return new Provider<T>() {
						@Override
						public T get() {
							// Delegate to whatever is the currently active test scope
							return testScope.get().scope(key, unscoped).get();
						}
					};
				}
			});
		}

		private <A extends Annotation> void bindAnnotation(Class<? extends Annotation> type, A annotation) {
			@SuppressWarnings("unchecked")
			Class<A> key = (Class<A>) type;
			bind(key).toInstance(annotation);
		}

		private <T> Provider<T> getTestInstanceProvider() {
			return new Provider<T>() {
				@SuppressWarnings("unchecked")
				@Override
				public T get() {
					return (T) testInstance.get();
				}
			};
		}
	}

	/**
	 * Implementation of the {@link TestScoped @TestScoped} scope.
	 */
	class TestScope implements Scope {
		private final Map<Key<?>, Optional<?>> scope = new HashMap<>();

		TestScope() {
			super();
		}

		@Override
		public <T> Provider<T> scope(Key<T> key, Provider<T> unscoped) {
			return new Provider<T>() {
				@Override
				public T get() {
					@SuppressWarnings("unchecked")
					Optional<T> result = (Optional<T>) scope.get(key);

					if (result == null) {
						result = Optional.ofNullable(unscoped.get());
						scope.put(key, result);
					}

					return result.orElse(null);
				}
			};
		}

		void dispose() {
			scope.clear();
		}
	}
}

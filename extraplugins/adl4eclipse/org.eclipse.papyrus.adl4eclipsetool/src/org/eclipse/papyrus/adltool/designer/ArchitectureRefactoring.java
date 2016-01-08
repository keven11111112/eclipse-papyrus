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

package org.eclipse.papyrus.adltool.designer;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_StereotypesUtils;
import org.eclipse.papyrus.adltool.Activator;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.osgi.profile.OSGIStereotypesUtils;
import org.eclipse.papyrus.uml.tools.namereferences.NameReferencesHelper;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Handler that refactors the model to be more human-readable.
 */
public class ArchitectureRefactoring {

	/**
	 * Computes and return the command to refactor the model, eg move features and bundles to specific folders, simplifies name, create dependencies between features
	 * 
	 * @param rootModel
	 *            the model to refactor
	 * @param monitor
	 *            the progres monitor
	 * @return the command to refacotr, or <code>null</code> if there were some issues to get the editing domain for the command
	 */
	public static Command getRefactoringCommand(Package rootModel, IProgressMonitor monitor) {
		TransactionalEditingDomain transactionalEditingDomain;
		try {
			transactionalEditingDomain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(rootModel);
			return new RefactoringCommand(transactionalEditingDomain, rootModel, monitor);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return null;

	}

	/**
	 * Command executed to refactor the model
	 */
	public static class RefactoringCommand extends RecordingCommand {

		private Package model;
		private Package featuresPackage;
		private Package bundlesPackage;
		private Package bundleDependenciesPackage;
		private IProgressMonitor monitor;
		private Package internalBundleDependenciesPackage;
		private Package externalDependenciesPackage;
		private Package papyrusToExternalsDependenciesPackage;
		private Package externalsToPapyrusDependenciesPackage;

		public RefactoringCommand(TransactionalEditingDomain domain, Package rootModel, IProgressMonitor monitor) {
			super(domain, "Refactoring " + rootModel.getName(),
					"Refactoring of the architecture model to be human readable");
			this.model = rootModel;
			this.monitor = monitor;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void doExecute() {
			moveFeaturesAndBundles();
			createFeatureDependencies();

			// simplify names
			simplifyNames();

		}

		protected void simplifyNames() {
			simplifyFeatureNames();
			simplifyBundleNames();
			simplifyFeatureDependenciesNames();
		}

		protected void simplifyFeatureDependenciesNames() {
			for (Package dependencyPackage : bundleDependenciesPackage.getNestedPackages()) {
				for (PackageableElement dependency : dependencyPackage.getPackagedElements()) {
					simplifyName(dependency);
				}
			}
		}

		protected void simplifyBundleNames() {
			for (PackageableElement bundle : bundlesPackage.getPackagedElements()) {
				if (isBundle(bundle)) {
					simplifyName(bundle);
					// simplifies also dependencies and property of the component
					for (Property property : ((Component) bundle).getAttributes()) {
						simplifyName(property);
					}

					// simplify dependencies
					for (Dependency dependency : ((Component) bundle).getClientDependencies()) {
						simplifyName(dependency);
					}
				}
			}

		}

		protected void simplifyFeatureNames() {
			for (PackageableElement feature : featuresPackage.getPackagedElements()) {
				if (isFeature(feature)) {
					simplifyName(feature);
					// simplifies also dependencies and property of the component
					for (Property property : ((Component) feature).getAttributes()) {
						simplifyName(property);
					}

					// simplify dependencies
					for (Dependency dependency : ((Component) feature).getClientDependencies()) {
						simplifyName(dependency);
					}
				}
			}

		}

		protected void moveFeaturesAndBundles() {
			monitor.subTask("Moving Features & Bundles");
			featuresPackage = (Package) model.createNestedPackage("Features");
			bundlesPackage = (Package) model.createNestedPackage("Bundles");
			bundleDependenciesPackage = (Package) model.createNestedPackage("BundleDependencies");
			internalBundleDependenciesPackage = (Package) bundleDependenciesPackage.createNestedPackage("Internals");
			externalDependenciesPackage = (Package) bundleDependenciesPackage.createNestedPackage("Externals");
			papyrusToExternalsDependenciesPackage = (Package) bundleDependenciesPackage
					.createNestedPackage("PapyrusToExternals");
			externalsToPapyrusDependenciesPackage = (Package) bundleDependenciesPackage
					.createNestedPackage("ExternalsToPapyrus");

			List<PackageableElement> packageableElements = new ArrayList<>(model.getPackagedElements());
			for (PackageableElement packageableElement : packageableElements) {
				if (isBundle(packageableElement)) {
					bundlesPackage.getPackagedElements().add(packageableElement);
				} else if (isFeature(packageableElement)) {
					featuresPackage.getPackagedElements().add(packageableElement);
				}
				monitor.worked(1);
			}
		}

		protected void initMapPluginsToFeatures(Map<Component, Set<Component>> mapPluginToFeatures) {
			monitor.subTask("Initializing Plugins to Features cache");
			Assert.isNotNull(bundlesPackage, "Bundles Package should not be null here");
			Assert.isNotNull(featuresPackage, "Features Package should not be null here");

			for (PackageableElement element : featuresPackage.getPackagedElements()) {
				if (isFeature(element)) {
					for (Property ownedPlugin : ((Component) element).getOwnedAttributes()) {
						Type type = ownedPlugin.getType();
						if (isBundle(type)) {
							// now insert it in the map or complete the map if
							// this
							// entry already exists
							if (!mapPluginToFeatures.containsKey(type)) {
								mapPluginToFeatures.put((Component) type, new HashSet<Component>());
							} else {
								Activator.log.debug("Warning: the plugin " + type.getName() + "[" + element.getName()
										+ "] has been found in several other features: "
										+ mapPluginToFeatures.get(type));
							}
							Set<Component> features = mapPluginToFeatures.get(type);
							features.add((Component) element);
						}
					}
				}
				monitor.worked(1);
			}

			// pretty print for debug
			for (Component plugin : mapPluginToFeatures.keySet()) {
				PrintStream stream = System.out;
				if (mapPluginToFeatures.get(plugin).size() != 1) {
					stream = System.err;
				}
				stream.print(plugin.getName() + ": ");
				Iterator<Component> featureIt = mapPluginToFeatures.get(plugin).iterator();
				while (featureIt.hasNext()) {
					Component feature = featureIt.next();
					stream.print(feature.getName());
					if (featureIt.hasNext()) {
						stream.print(", ");
					}
				}
				stream.println();
			}

		}

		protected boolean isInternalFeature(Component feature) {
			String name = feature.getName();
			return (name != null) ? name.indexOf("org.eclipse.papyrus") == 0 : false;
		}

		protected void createFeatureDependencies() {
			Map<Component, Set<Component>> mapPluginToFeatures = new HashMap<>();
			initMapPluginsToFeatures(mapPluginToFeatures);

			NameReferencesHelper helper = new NameReferencesHelper(model.eResource());

			monitor.subTask("Creating Feature dependencies");
			// browse all features
			for (Element member : featuresPackage.getOwnedMembers()) {
				if (isFeature(member)) {
					Component feature = (Component) member;
					// for all plugins contained in this feature ==> get the dependents plugins, and from these plugins, their containing feature and create a dependency if not already existing between the 2 features
					for (Property child : feature.getOwnedAttributes()) {
						// type of the child is the plugin (feature?) we want to
						// check
						Type plugin = child.getType();

						// see the dependencies of that plugin, and get their owning features
						if (isBundle(plugin)) {
							for (Property property : ((Component) plugin).getOwnedAttributes()) {
								Type referencedPlugin = property.getType();
								if (isBundle(referencedPlugin)) {
									// check the feature that ships this plugin
									Set<Component> referencedFeatures = mapPluginToFeatures.get(referencedPlugin);
									// there should be a dependency created from the current features to all these containing features
									if (referencedFeatures != null && referencedFeatures.size() > 0
											&& !referencedFeatures.contains(feature)) {
										for (Component referencedFeature : referencedFeatures) {
											if (!feature.equals(referencedFeature) && referencedFeature != null) {
												// check if dependency already exists. If not, create it
												Dependency dependency = feature
														.getClientDependency(referencedFeature.getName());
												if (dependency == null) {
													dependency = createDependency(referencedFeature.getName(), feature,
															referencedFeature);

													// move it to the right folder check client (is internal or external)
													boolean isClientInternal = isInternalFeature(feature);

													// check supplier
													boolean isSupplierInternal = isInternalFeature(referencedFeature);

													/*
													 * 4 possibilities:
													 * - Papyrus internals: client & supplier are Papyrus features
													 * - Papyrus to external component: client is Papyrus feature, supplier is not
													 * - External To External: client & supplier are external features
													 * - External to Papyrus (shall not exist yet): client is external, supplier is Papyrus
													 */
													if (isClientInternal) {
														if (isSupplierInternal) {
															internalBundleDependenciesPackage.getPackagedElements()
																	.add(dependency);
														} else {
															papyrusToExternalsDependenciesPackage.getPackagedElements()
																	.add(dependency);
														}
													} else {
														if (isSupplierInternal) {
															externalsToPapyrusDependenciesPackage.getPackagedElements()
																	.add(dependency);
														} else {
															externalDependenciesPackage.getPackagedElements()
																	.add(dependency);
														}
													}
												}

												List<Comment> comments = dependency.getOwnedComments();
												Comment comment = null;
												if (comments.isEmpty()) {
													comment = dependency.createOwnedComment();
													comment.setBody("");
													comment.getAnnotatedElements().add(dependency);
												} else {
													comment = comments.get(0);
												}
												String body = comment.getBody();
												body = body + plugin.getName() + " -> " + referencedPlugin.getName() + "</p>\n";
												comment.setBody(body);
											}
										}
									}
								}
							}
						}
					}
				}
				monitor.worked(1);
			}

		}

		/**
		 * Creates a dependency link between two
		 * {@link org.eclipse.uml2.uml.NamedElement NamedElement}s
		 *
		 * @param name
		 *            the name of the dependency
		 * @param client
		 *            the client NamedElement
		 * @param supplier
		 *            the supplier NamedElement
		 * @return the created dependency
		 */
		private Dependency createDependency(String name, NamedElement client, NamedElement supplier) {
			Dependency dependency = UMLFactory.eINSTANCE.createDependency();

			dependency.setName(name);
			dependency.getClients().add(client);
			dependency.getSuppliers().add(supplier);

			return dependency;
		}

	}

	/**
	 * Returns <code>true</code> if the specified element represents an Eclipse
	 * feature (instanceof Component & stereotyped by "Feature")
	 * 
	 * @param element
	 *            the element to test
	 * @return <code>true</code> if the specified element represents an Eclipse
	 *         feature (instanceof Component & stereotyped by "Feature")
	 */
	public static boolean isFeature(Element element) {
		return element instanceof Component && ADL4Eclipse_StereotypesUtils.isFeature(element);
	}

	/**
	 * Returns <code>true</code> if the specified element represents an Eclipse
	 * plugin (instanceof Component & stereotyped by "Plugin")
	 * 
	 * @param element
	 *            the element to test
	 * @return <code>true</code> if the specified element represents an Eclipse
	 *         plugin (instanceof Component & stereotyped by "Plugin")
	 */
	public static boolean isBundle(Element element) {
		return element instanceof Component && OSGIStereotypesUtils.isBundle(element);
	}

	/**
	 * Changes the name of the specified {@link NamedElement} if it can be
	 * simplified.
	 * 
	 * @see #getSimplifiedName(String)
	 * @param namedElement
	 *            the named element to be modified
	 */
	public static void simplifyName(NamedElement namedElement) {
		String name = namedElement.getName();
		String simplifiedName = getSimplifiedName(name);
		if (simplifiedName != name) {
			namedElement.setName(simplifiedName);
		}
	}

	/**
	 * Computes and returns a simplified name from the given String. Basically,
	 * it removes the "org.eclipse." at the beginning of the name.
	 * 
	 * @param name
	 *            the name to be simplified, can be <code>null</code>
	 * @return the simplified name or the exact same string if it could not be
	 *         simplified
	 */
	public static String getSimplifiedName(String name) {
		if (name != null && name.indexOf("org.eclipse.") == 0) {
			return name.substring("org.eclipse.".length());
		}
		return name;
	}

}

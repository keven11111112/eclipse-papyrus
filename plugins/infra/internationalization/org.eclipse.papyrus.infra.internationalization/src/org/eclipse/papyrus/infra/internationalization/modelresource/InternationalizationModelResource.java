/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.internationalization.modelresource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.commands.AddToResourceCommand;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.internationalization.Activator;
import org.eclipse.papyrus.infra.internationalization.InternationalizationEntry;
import org.eclipse.papyrus.infra.internationalization.InternationalizationFactory;
import org.eclipse.papyrus.infra.internationalization.InternationalizationLibrary;
import org.eclipse.papyrus.infra.internationalization.InternationalizationPackage;
import org.eclipse.papyrus.infra.internationalization.commands.ResetNameCommand;
import org.eclipse.papyrus.infra.internationalization.commands.ResetNameTransactionalCommand;
import org.eclipse.papyrus.infra.internationalization.common.editor.IInternationalizationEditor;
import org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesConstants;
import org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils;
import org.eclipse.papyrus.infra.internationalization.common.utils.LocaleNameResolver;
import org.eclipse.papyrus.infra.internationalization.utils.EntryPartLabelSynchronizer;
import org.eclipse.papyrus.infra.internationalization.utils.PreferencePartLabelSynchronizer;
import org.eclipse.papyrus.infra.internationalization.utils.PropertiesFilesUtils;
import org.eclipse.papyrus.infra.internationalization.utils.QualifiedNameUtils;
import org.eclipse.papyrus.infra.internationalization.utils.ResourceBundleAndURI;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;

/**
 * This allows to manage the internationalization resource.
 */
public class InternationalizationModelResource extends AbstractModelWithSharedResource<InternationalizationLibrary>
		implements IModel {

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.infra.internationalization.resource.InternationalizationModel"; //$NON-NLS-1$

	/**
	 * The '_labelDiagram_' prefix of each diagram entry.
	 */
	protected static final String LABEL_DIAGRAM_PREFIX_QN = "_labelDiagram_"; //$NON-NLS-1$

	/**
	 * The '_labelTable_' prefix of each table entry.
	 */
	protected static final String LABEL_TABLE_PREFIX_QN = "_labelTable_"; //$NON-NLS-1$

	/**
	 * The '_label_' prefix of each entry.
	 */
	public static final String LABEL_PREFIX = "_label_"; //$NON-NLS-1$

	/**
	 * The notation extension file (cannot use the
	 * NotationModel.NOTATION_FILE_EXTENSION because of dependencies cycle).
	 */
	protected static final String NOTATION_FILE_EXTENSION = "notation"; //$NON-NLS-1$

	/**
	 * The map of the loaded resource by the initial URI and by locale.
	 */
	protected Map<URI, Map<Locale, Resource>> propertiesByLocale = null;

	/**
	 * Set to keep deleted objects. Those ones must be ignored at the
	 * {{@link #saveModel()} to avoid exceptions.
	 * 
	 * The delete of objects does not remove the entries corresponding because
	 * at the undo, the internationalization values must be not retrieve.
	 */
	protected Set<EObject> deletedObjects = null;

	/**
	 * The adapter for the object (to avoid multiple creation for the same
	 * object).
	 */
	protected Map<EObject, Adapter> adapters = null;

	/**
	 * This map allows to keep the editor part for an EObject when it is needed
	 * to create the InternationalizationEntry and finally the
	 * PartLabelSynchronizer.
	 */
	protected Map<EObject, IInternationalizationEditor> editorPartByEObject = null;

	/**
	 * Save of the created PartLabelSynchronizer to manage the dispose of those
	 * ones.
	 */
	protected Map<EObject, Map<InternationalizationEntry, EntryPartLabelSynchronizer>> entriesLabelSynchronizerByEObject = null;

	/**
	 * Save the preference part label synchronizer corresponding to the object
	 * of editor part.
	 */
	protected Map<EObject, PreferencePartLabelSynchronizer> preferencePartLabelSynchronizers = null;

	/**
	 * Constructor.
	 */
	public InternationalizationModelResource() {
		super();
		propertiesByLocale = new HashMap<URI, Map<Locale, Resource>>();

		Activator.getDefault().getPreferenceStore().addPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(final PropertyChangeEvent event) {
				if (event.getProperty().equals(InternationalizationPreferencesConstants.LANGUAGE_PREFERENCE)) {
					Iterator<Resource> resourcesIterator = new HashSet<Resource>(getResources()).iterator();
					while (resourcesIterator.hasNext()) {
						final Resource resource = resourcesIterator.next();
						loadModel(getInitialURIForResource(resource).trimFileExtension());
					}
				}
			}

		});
		deletedObjects = new HashSet<EObject>();
		adapters = new HashMap<EObject, Adapter>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#loadModel(org.eclipse.emf.common.util.URI)
	 */
	@Override
	public void loadModel(final URI uriWithoutExtension) {
		loadModel(uriWithoutExtension, true);
	}

	/**
	 * Attach the model to its resource if this is not already done.
	 * 
	 * @param uriWithoutExtension
	 *            The uri of the resource to manage.
	 * @param needToLoadOtherProperties
	 *            Boolean to determinate if the other properties in the project
	 *            have to bo loaded or not.
	 */
	public void loadModel(final URI uriWithoutExtension, final boolean needToLoadOtherProperties) {
		// Compute model URI
		final URI uri = uriWithoutExtension.appendFileExtension(getModelFileExtension());

		if (needToBeLoaded(uri)) {

			resourceURI = uri;

			final Locale locale = InternationalizationPreferencesUtils.getLocalePreference(uriWithoutExtension);

			try {

				resource = loadResource(uri, locale);

				// We need to do even if the resource is null
				if (needToLoadOtherProperties) {
					resourceURI = uri;

					String existingResourceLoadedName = "";
					if (null != resource) {
						existingResourceLoadedName = resource.getURI().lastSegment();
					}

					// We need to load other properties files in the same
					// folders
					loadOthersPropertiesFiles(uri, existingResourceLoadedName);
				}

			} catch (final Exception ex) {
				Activator.log.error(ex);
			}
		}
	}

	/**
	 * This allows to define if the uri file was already loaded.
	 * 
	 * @param uri
	 *            The uri of the file to load.
	 * @return <code>true</code> if the file was already loaded.
	 *         <code>false</code> otherwise.
	 */
	protected boolean needToBeLoaded(final URI uri) {
		return !propertiesByLocale.containsKey(uri);
	}

	/**
	 * This allows to add the resource in parameter in the model resources.
	 * 
	 * @param uri
	 *            The uri of the resource.
	 * @param resource
	 *            The resource to add.
	 * @param locale
	 *            The locale to use.
	 */
	public void addResourceToModel(final URI uri, final Resource resource, final Locale locale) {
		resourceURI = uri.trimFileExtension().appendFileExtension(getModelFileExtension());
		configureResource(resource, locale);
	}

	/**
	 * This allows to load others properties files in the project.
	 * 
	 * @param uri
	 *            The {@link URI}.
	 * @param loadedResourceFile
	 *            The properties file already loaded.
	 */
	protected void loadOthersPropertiesFiles(final URI uri, final String loadedResourceFile) {
		final URI uriWithoutExtension = uri.trimFileExtension();
		final String modelName = uriWithoutExtension.segment(uriWithoutExtension.segmentCount() - 1);
		final URI folderURI = uriWithoutExtension.trimSegments(1);

		// Calculate the project folder
		IContainer parentFolder = null;
		if (folderURI.isPlatformResource()) {
			final String uriPlatformString = folderURI.toPlatformString(true);
			try{
				parentFolder = ResourcesPlugin.getWorkspace().getRoot().getProject(uriPlatformString);
			}catch(Exception exception){
				parentFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(uriPlatformString));
			}
		}

		if (null != parentFolder) {
			final String extension = "." + getModelFileExtension(); //$NON-NLS-1$
			try {
				// Loop on project resources to check about other properties
				// file
				for (final IResource resourceEntry : parentFolder.members()) {
					// Check if the file starts with the name of the model and
					// finish with properties
					if (resourceEntry.getName().startsWith(modelName) && resourceEntry.getName().endsWith(extension)) { // $NON-NLS-1$

						// Remove the extension of the file
						final String fileNAmeWithoutExtension = resourceEntry.getName().substring(0,
								resourceEntry.getName().length() - extension.length());
						// Remove the model name
						String possibleLocale = fileNAmeWithoutExtension.substring(modelName.length());

						// Check this is not the current loaded file of locale
						if (!resourceEntry.getName().equals(loadedResourceFile) || possibleLocale.isEmpty()) {

							// This is modelName.properties
							if (possibleLocale.isEmpty() && null == getResourceForURIAndLocale(uri, new Locale(""))) { //$NON-NLS-1$
								final URI newURI = folderURI.appendSegment(fileNAmeWithoutExtension)
										.appendFileExtension(getModelFileExtension());
								loadResource(newURI, new Locale("")); //$NON-NLS-1$
								// This can be a possible properties locale file
							} else if (possibleLocale.startsWith(LocaleNameResolver.UNDERSCORE)) { // $NON-NLS-1$
								possibleLocale = possibleLocale.substring(1);
								Locale localeFound = null;

								// Check about possible locale in available
								// locales
								final Iterator<Locale> availableLocales = Arrays.asList(Locale.getAvailableLocales())
										.iterator();
								while (availableLocales.hasNext() && null == localeFound) {
									final Locale currentAvailableLocale = availableLocales.next();

									if (currentAvailableLocale.toString().equals(possibleLocale)) {
										localeFound = currentAvailableLocale;
									}
								}

								// The file contains a locale, load it
								if (null != localeFound) {
									loadResource(uri, localeFound);
								}
							}

						}
					}
				}
			} catch (final CoreException e) {
				Activator.log.error(e);
			}
		}
	}

	/**
	 * This method allows to load the resource (or create it if necessary) and
	 * load the internationalization content.
	 * 
	 * @param uri
	 *            The {@link URI}.
	 * @param locale
	 *            The current locale to use.
	 * @return The resource loaded.
	 */
	protected Resource loadResource(final URI uri, final Locale locale) {
		Resource resource = null;

		final ResourceBundleAndURI resourceBundleAndURI = PropertiesFilesUtils.getResourceBundle(uri, locale);
		if (null != resourceBundleAndURI) {

			// Look for the resource
			resource = getResourceSet().getResource(resourceBundleAndURI.getUri(), false);

			// Check if model is loaded.
			if (null != resource) {
				configureResource(resource, locale);
			} else {
				// model is not loaded, do it.
				// Create Resource of appropriate type
				resource = modelSet.createResource(resourceBundleAndURI.getUri());

				configureResource(resource, locale);

				// call registered snippets
				startSnippets();
			}

			loadInternationalizationContent(uri, locale);
		}

		return resource;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#createModel(org.eclipse.emf.common.util.URI)
	 */
	@Override
	public void createModel(final URI uriWithoutExtension) {
		super.createModel(uriWithoutExtension);

		final URI uri = uriWithoutExtension.appendFileExtension(getModelFileExtension());
		final Locale locale = InternationalizationPreferencesUtils.getLocalePreference(this.resource.getURI());
		final Resource resource = this.resource;

		// Fill the properties by locale map
		if (null == propertiesByLocale.get(resourceURI)) {
			propertiesByLocale.put(resourceURI, new HashMap<Locale, Resource>());
		}
		propertiesByLocale.get(resourceURI).put(locale, resource);

		// Calculate the internationalization content
		loadInternationalizationContent(uri, locale);

		resource.setModified(true);

		try {
			saveResource(resource);
		} catch (final IOException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * This allows to configure the resource.
	 * 
	 * @param resourceToConfigure
	 *            The resource to configure.
	 * @param locale
	 *            The locale to manage.
	 */
	protected void configureResource(final Resource resourceToConfigure, final Locale locale) {
		super.configureResource(resourceToConfigure);
		// Add the resource to the resource properties classified by their
		// locale
		if (null == propertiesByLocale.get(resourceURI)) {
			propertiesByLocale.put(resourceURI, new HashMap<Locale, Resource>());
		}
		propertiesByLocale.get(resourceURI).put(locale, resourceToConfigure);
	}

	/**
	 * This allows to load internationalization content of properties file into
	 * the current resource.
	 * 
	 * @param uri
	 *            The URI of the properties file with the extension.
	 * @param locale
	 *            The locale to use.
	 */
	protected void loadInternationalizationContent(final URI uri, final Locale locale) {
		final Resource resource = getResourceForURIAndLocale(uri, locale);

		if (null != resource && resource.getContents().isEmpty()) {
			final ResourceBundleAndURI resourceBundleAndURI = PropertiesFilesUtils
					.getResourceBundle(uri.trimFileExtension().appendFileExtension(getModelFileExtension()), locale);
			if (null != resourceBundleAndURI && null != resourceBundleAndURI.getResourceBundle()) {
				// Create the internationalization library to set to the
				// resource contents
				final InternationalizationLibrary library = InternationalizationFactory.eINSTANCE
						.createInternationalizationLibrary();
				final Enumeration<String> keys = resourceBundleAndURI.getResourceBundle().getKeys();

				// Loop on existing keys
				while (keys.hasMoreElements()) {
					// Create an entry for each key
					final InternationalizationEntry entry = InternationalizationFactory.eINSTANCE
							.createInternationalizationEntry();
					String key = (String) keys.nextElement();
					if (key.startsWith(LABEL_DIAGRAM_PREFIX_QN)) {
						final String keyWithoutPrefix = key.substring(LABEL_DIAGRAM_PREFIX_QN.length());
						final String qualifiedName = keyWithoutPrefix.substring(0,
								keyWithoutPrefix.indexOf(LABEL_PREFIX));
						final String diagramName = keyWithoutPrefix
								.substring(keyWithoutPrefix.indexOf(LABEL_PREFIX) + LABEL_PREFIX.length());

						final Resource notationResource = modelSet.getResource(
								uri.trimFileExtension().appendFileExtension(NOTATION_FILE_EXTENSION), true);

						if (null != notationResource && null != notationResource.getContents()
								&& !notationResource.getContents().isEmpty()) {
							final Diagram foundDiagram = QualifiedNameUtils.getDiagram(notationResource, diagramName,
									qualifiedName);
							entry.setKey(foundDiagram);
							addModifiedAdapter(foundDiagram, resource);
						}

					} else if (key.startsWith(LABEL_TABLE_PREFIX_QN)) {
						final String keyWithoutPrefix = key.substring(LABEL_TABLE_PREFIX_QN.length());
						final String qualifiedName = keyWithoutPrefix.substring(0,
								keyWithoutPrefix.indexOf(LABEL_PREFIX));
						final String tableName = keyWithoutPrefix
								.substring(keyWithoutPrefix.indexOf(LABEL_PREFIX) + LABEL_PREFIX.length());

						final Resource umlResource = modelSet.getResource(
								uri.trimFileExtension().appendFileExtension(NOTATION_FILE_EXTENSION), true);

						if (null != umlResource && null != umlResource.getContents()
								&& !umlResource.getContents().isEmpty()) {
							final Table foundTable = QualifiedNameUtils.getTable(umlResource, tableName, qualifiedName);
							entry.setKey(foundTable);
							addModifiedAdapter(foundTable, resource);
						}
					} else {
						entry.setKey(key);
					}
					entry.setValue(resourceBundleAndURI.getResourceBundle().getString(key));
					// Add the entry to the library
					library.getEntries().add(entry);
				}

				final GMFtoEMFCommandWrapper command = new GMFtoEMFCommandWrapper(new AddToResourceCommand(
						((ModelSet) resource.getResourceSet()).getTransactionalEditingDomain(), resource, library));
				command.execute();
			}
			resource.setModified(false);
		}
	}

	/**
	 * This allows to create the properties resource corresponding to the uri in
	 * parameter.
	 * 
	 * @param uri
	 *            The URI of the properties resource to create.
	 * @param locale
	 *            The locale to manage.
	 * @return The created resource.
	 */
	protected Resource createResource(final URI uri, final Locale locale) {
		// The properties uri (cast the file extension to the needed one)
		URI propertiesURI = uri.trimFileExtension().appendFileExtension(getModelFileExtension());
		resourceURI = propertiesURI;

		// The created properties resource need to have the locale in last
		// segment (example: test_en_EN.properties)
		String lastSegment = propertiesURI.trimFileExtension().lastSegment();
		lastSegment = lastSegment + LocaleNameResolver.UNDERSCORE + locale.toString();
		propertiesURI = propertiesURI.trimSegments(1);
		propertiesURI = propertiesURI.appendSegment(lastSegment);
		propertiesURI = propertiesURI.appendFileExtension(getModelFileExtension());

		// Create the resource needed
		final Resource resultResource = modelSet.createResource(propertiesURI);
		configureResource(resultResource, locale);

		// Create the internationalization library in the resource content
		createInternationalizationContent(resultResource);

		// call registered snippets
		startSnippets();

		resource = resultResource;

		return resultResource;
	}

	/**
	 * This allows to create the internationalization library for the resource
	 * content.
	 * 
	 * @param resource
	 *            The resource where add the internationalization library.
	 */
	protected void createInternationalizationContent(final Resource resource) {
		if (null != resource) {
			// Create the library
			final InternationalizationLibrary library = InternationalizationFactory.eINSTANCE
					.createInternationalizationLibrary();

			// Create the resource content command and execute it
			final GMFtoEMFCommandWrapper command = new GMFtoEMFCommandWrapper(new AddToResourceCommand(
					((ModelSet) resource.getResourceSet()).getTransactionalEditingDomain(), resource, library));
			command.execute();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#saveModel()
	 */
	@Override
	public void saveModel() throws IOException {
		// Save into the properties files

		for (final Resource resource : getResources()) {
			saveResource(resource);
		}
	}

	/**
	 * This allows to save the resource.
	 * 
	 * @param resource
	 *            The resource to save.
	 * @throws IOException
	 *             The input output file exception.
	 */
	protected void saveResource(final Resource resource) throws IOException {
		final ModelSet set = getModelManager();
		if (null != resource && set.shouldSave(resource) && !resource.getContents().isEmpty()) {
			// It is needed to manage the save of properties by a simple output
			// stream because the resource bundle cannot be modified
			final Properties properties = new Properties();

			final InternationalizationLibrary library = (InternationalizationLibrary) resource.getContents().get(0);

			// Add all the entries into properties (need this properties to save
			// easier the properties file)
			for (final InternationalizationEntry entry : library.getEntries()) {
				if (!deletedObjects.contains(entry.getKey()) && !entry.getValue().isEmpty()) {
					properties.setProperty(getKey(entry), entry.getValue());
				}
			}

			final Locale locale = getLocaleForResource(resource);

			// Get the URI of properties file used (with locale or not)
			final URI resourceURI = PropertiesFilesUtils.getResourceBundleURIFromResourceURI(resource.getURI(), locale);

			// This allows to save the properties into the properties file
			final URIConverter uriConverter = new ExtensibleURIConverterImpl();
			properties.store(uriConverter.createOutputStream(resourceURI), null);
			resource.setModified(false);
		}
	}

	/**
	 * This allows to add an adapter to the EOBject to modified the properties
	 * resource when the EObject has changed.
	 * 
	 * @param eObject
	 *            The EObject.
	 * @param resource
	 *            The associated resource.
	 */
	protected void addModifiedAdapter(final EObject eObject, final Resource resource) {
		if (!adapters.containsKey(eObject)) {
			Adapter modifiedAdapter = new Adapter() {

				@Override
				public void setTarget(final Notifier newTarget) {
					// Do nothing
				}

				@Override
				public void notifyChanged(final Notification notification) {
					// If this is a remove, add the old value to the deleted
					// objects
					if (Notification.REMOVE == notification.getEventType()
							|| Notification.REMOVE_MANY == notification.getEventType()) {
						Object oldValue = notification.getOldValue();

						if (oldValue instanceof EObject) {
							deletedObjects.add((EObject) oldValue);
						}
						// If this is an add, remove the new value from the
						// deleted objects if existing
					} else if (Notification.ADD == notification.getEventType()
							|| Notification.ADD_MANY == notification.getEventType()) {
						Object newValue = notification.getNewValue();

						if (newValue instanceof EObject && deletedObjects.contains(newValue)) {
							deletedObjects.remove((EObject) newValue);
						}
					}

					// The resource is modified (not directly but need to be
					// saved)
					if (null != eObject.eResource()
							&& null != getLocalesAndResourcesForURI(eObject.eResource().getURI())) {
						for (final Resource res : getLocalesAndResourcesForURI(eObject.eResource().getURI()).values()) {
							res.setModified(true);
						}
					} else {
						resource.setModified(true);
					}
				}

				@Override
				public boolean isAdapterForType(Object type) {
					return false;
				}

				@Override
				public Notifier getTarget() {
					return null;
				}
			};
			eObject.eAdapters().add(modifiedAdapter);
			adapters.put(eObject, modifiedAdapter);
		}
	}

	/**
	 * This allows to get the entry key (can be override to get element string
	 * identifier instead of string key).
	 * 
	 * @param entry
	 *            The internationalization entry.
	 * @return The key as String.
	 */
	protected String getKey(final InternationalizationEntry entry) {
		final StringBuilder result = new StringBuilder();
		if (entry.getKey() instanceof Diagram) {
			result.append(LABEL_DIAGRAM_PREFIX_QN);
			final Diagram diagram = (Diagram) entry.getKey();
			final EObject diagramContainer = diagram.getElement();
			result.append(QualifiedNameUtils.getQualifiedName(diagramContainer));
			result.append(LABEL_PREFIX);
			result.append(diagram.getName());
		} else if (entry.getKey() instanceof Table) {
			result.append(LABEL_TABLE_PREFIX_QN);
			final Table table = (Table) entry.getKey();
			final EObject tableContainer = table.getOwner();
			result.append(QualifiedNameUtils.getQualifiedName(tableContainer));
			result.append(LABEL_PREFIX);
			result.append(table.getName());
		} else {
			result.append((String) entry.getKey());
		}
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#isModelRoot(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected boolean isModelRoot(final EObject object) {
		return object instanceof InternationalizationLibrary;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getModelFileExtension()
	 */
	@Override
	public String getModelFileExtension() {
		return PropertiesFilesUtils.PROPERTIES_FILE_EXTENSION;
	}

	/**
	 * Open this method. {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractModel#getModelManager()
	 */
	@Override
	public ModelSet getModelManager() {
		return super.getModelManager();
	}

	/**
	 * Open this method. {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.EMFLogicalModel#isRelatedResource(org.eclipse.emf.ecore.resource.Resource)
	 */
	@Override
	public boolean isRelatedResource(final Resource resource) {
		return super.isRelatedResource(resource);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractModel#getIdentifier()
	 */
	@Override
	public String getIdentifier() {
		return MODEL_ID;
	}

	/**
	 * Get the value for the key in parameter.
	 * 
	 * @param uri
	 *            The uri of the resource where search the key.
	 * @param key
	 *            The key to search.
	 * @param locale
	 *            The locale of which to get value.
	 * @return The value of the key.
	 */
	public String getValueForEntryKey(final URI uri, final Object key, final Locale locale) {
		InternationalizationEntry entry = getEntryForKey(uri, key, locale);
		return null != entry ? entry.getValue() : null;
	}

	/**
	 * Get the value for the key in parameter.
	 * 
	 * @param uri
	 *            The uri of the resource where search the key.
	 * @param key
	 *            The key to search.
	 * @return The value of the key.
	 */
	public String getValueForEntryKey(final URI uri, final EObject key) {
		InternationalizationEntry entry = getEntryForKey(uri, key,
				InternationalizationPreferencesUtils.getLocalePreference(key));
		return null != entry ? entry.getValue() : null;
	}

	/**
	 * Get the entry for the key in parameter.
	 * 
	 * @param uri
	 *            The uri of the resource where search the key.
	 * @param key
	 *            The key to search.
	 * @param locale
	 *            The locale of which to get value.
	 * @return The entry of the key.
	 */
	public InternationalizationEntry getEntryForKey(final URI uri, final Object key, final Locale locale) {
		InternationalizationEntry result = null;

		Resource resource = getResourceForURIAndLocale(uri, locale);

		// If the resource for the locale is not found, search for a properties
		// without locale
		if (null == resource) {
			resource = getResourceForURIAndLocale(uri, new Locale("")); //$NON-NLS-1$
		}

		if (null != resource) {
			final InternationalizationLibrary library = getModelRoot(resource);

			if (null != library) {
				final Iterator<InternationalizationEntry> entries = library.getEntries().iterator();

				// Iterate on entries to get the value of the key in parameter
				while (entries.hasNext() && null == result) {
					final InternationalizationEntry entry = entries.next();
					if (entry.getKey().equals(key)) {
						result = entry;
					}
				}
			}
		}

		return result;
	}

	/**
	 * This allows to get the command to set internationalization value.
	 * 
	 * @param domain
	 *            The current editing domain.
	 * @param uri
	 *            The uri of the resource where search the key.
	 * @param key
	 *            The key to search.
	 * @param value
	 *            The new value.
	 * @param locale
	 *            The locale for which to set the value.
	 * @return The command to set the internationalization value.
	 */
	public Command getSetValueCommand(final EditingDomain domain, final URI uri, final EObject key, final String value,
			final Locale locale) {
		Command resultCommand = null;

		// Get the resource where add/modify the entry corresponding to the key
		final Resource resource = getResourceForURIAndLocale(uri, locale);
		final InternationalizationLibrary library = getModelRoot(resource);

		if (null != library) {
			final Iterator<InternationalizationEntry> entries = library.getEntries().iterator();

			// Search on existing entries if the key already exists.
			// In this case, just modify the value
			while (entries.hasNext() && null == resultCommand) {
				final InternationalizationEntry entry = entries.next();
				if (entry.getKey().equals(key)) {
					if (null == value || value.isEmpty()) {
						// If the value is null or empty, remove the entry
						resultCommand = new CompoundCommand("Remove entry"); //$NON-NLS-1$
						((CompoundCommand) resultCommand).append(new RemoveCommand(domain, library,
								InternationalizationPackage.eINSTANCE.getInternationalizationLibrary_Entries(), entry));
						if (entry.getKey() instanceof EObject) {
							Command setNameValueCommand = getSetNameValueCommand(domain, (EObject) entry.getKey());
							if (null != setNameValueCommand) {
								((CompoundCommand) resultCommand).append(setNameValueCommand);
							}
						}
						resource.setModified(true);
					} else {
						resultCommand = new CompoundCommand("Set entry value"); //$NON-NLS-1$
						((CompoundCommand) resultCommand).append(new SetCommand(domain, entry,
								InternationalizationPackage.eINSTANCE.getInternationalizationEntry_Value(), value));
						if (entry.getKey() instanceof EObject) {
							Command setNameValueCommand = getSetNameValueCommand(domain, (EObject) entry.getKey());
							if (null != setNameValueCommand) {
								((CompoundCommand) resultCommand).append(setNameValueCommand);
							}
						}
						resource.setModified(true);
					}
				}
			}
		}

		// If the key does not exist, create an entry
		if (null == resultCommand && null != value && !value.isEmpty()) {
			final InternationalizationEntry entry = InternationalizationFactory.eINSTANCE
					.createInternationalizationEntry();
			entry.setKey(key);
			entry.setValue(value);

			if (null == resource) {
				// If the resource does not exist, create it and add entry to
				// the library
				resultCommand = new CompoundCommand("Create entry"); //$NON-NLS-1$
				((CompoundCommand) resultCommand).append(new CreatePropertiesResourceCommand(uri, entry,
						InternationalizationPreferencesUtils.getLocalePreference(key)));
				Command setNameValueCommand = getSetNameValueCommand(domain, (EObject) entry.getKey());
				if (null != setNameValueCommand) {
					((CompoundCommand) resultCommand).append(setNameValueCommand);
				}
			} else {
				resultCommand = new CompoundCommand("Create entry"); //$NON-NLS-1$
				((CompoundCommand) resultCommand).append(new AddCommand(domain, library,
						InternationalizationPackage.eINSTANCE.getInternationalizationLibrary_Entries(), entry));
				Command setNameValueCommand = getSetNameValueCommand(domain, (EObject) entry.getKey());
				if (null != setNameValueCommand) {
					((CompoundCommand) resultCommand).append(setNameValueCommand);
				}
				resource.setModified(true);
			}

			// If the created entry is an entry corresponding to an object who's
			// depending to Editor part, we need to create the
			// PartLabelSynchronizer
			if (null != editorPartByEObject && editorPartByEObject.containsKey(key)) {
				if (null != resultCommand) {
					final Command tmpCommand = resultCommand;
					resultCommand = new CompoundCommand("Change label value"); //$NON-NLS-1$
					((CompoundCommand) resultCommand).append(tmpCommand);
					((CompoundCommand) resultCommand).append(new AbstractCommand() {

						@Override
						public void execute() {
							addPartLabelSynchronizerForEntry(key, entry);
						}

						@Override
						protected boolean prepare() {
							return true;
						}

						@Override
						public void undo() {
							// Do nothing
						}

						@Override
						public void redo() {
							// Do nothing
						}
					});
				}
			}
		}

		return resultCommand;
	}

	/**
	 * This allows to add or update value of property with key in parameter.
	 * 
	 * @param uri
	 *            The uri of the resource where search the key.
	 * @param key
	 *            The key to search.
	 * @param value
	 *            The new value.
	 * @param locale
	 *            The locale for which set the value.
	 */
	public void setValue(final URI uri, final EObject key, final String value, final Locale locale) {

		// Get the resource where add/modify the entry corresponding to the key
		Resource resource = getResourceForURIAndLocale(uri, locale);
		if (null == resource) {
			// If the resource does not exist, create it
			resource = createResource(uri, InternationalizationPreferencesUtils.getLocalePreference(key));
		}

		final InternationalizationLibrary library = getModelRoot(resource);

		final Iterator<InternationalizationEntry> entries = library.getEntries().iterator();
		boolean hasFound = false;

		// Search on existing entries if the key already exists.
		// In this case, just modify the value
		while (entries.hasNext() && !hasFound) {
			final InternationalizationEntry entry = entries.next();
			if (entry.getKey().equals(key)) {
				if (null == value || value.isEmpty()) {
					// If the value is null or empty, remove the entry
					entries.remove();
				} else {
					entry.setValue(value);
					if (entry.getKey() instanceof EObject) {
						setNameValue((EObject) entry.getKey());
					}
				}
				hasFound = true;
			}
		}

		// If the key does not exist, create an entry
		if (!hasFound && null != value && !value.isEmpty()) {
			final InternationalizationEntry entry = InternationalizationFactory.eINSTANCE
					.createInternationalizationEntry();
			entry.setKey(key);
			entry.setValue(value);
			library.getEntries().add(entry);
			setNameValue(entry);

			// If the created entry is an entry corresponding to an object who's
			// depending to Editor part, we need to create the
			// PartLabelSynchronizer
			if (editorPartByEObject.containsKey(key)) {
				addPartLabelSynchronizerForEntry(key, entry);
			}
		}
		resource.setModified(true);
	}

	/**
	 * This allows to modify the name of the entry object when the label value
	 * is modified to notify all the name listeners. When the label change, all
	 * the name listeners need to be called.
	 * 
	 * @param domain
	 *            The current editing domain.
	 * @param eObject
	 *            The eObject of the label to modify.
	 * @return The command modifying the name value.
	 */
	protected Command getSetNameValueCommand(final EditingDomain domain, final EObject eObject) {
		Command result = null;

		// Change name for diagram
		if (domain instanceof TransactionalEditingDomain) {
			if (eObject instanceof Diagram) {
				result = new GMFtoEMFCommandWrapper(new ResetNameTransactionalCommand(
						(TransactionalEditingDomain) domain, eObject, NotationPackage.eINSTANCE.getDiagram_Name()));

				// Change name for table
			} else if (eObject instanceof Table) {
				result = new GMFtoEMFCommandWrapper(
						new ResetNameTransactionalCommand((TransactionalEditingDomain) domain, eObject,
								NattableconfigurationPackage.eINSTANCE.getTableNamedElement_Name()));
			}
		} else {
			if (eObject instanceof Diagram) {
				result = new ResetNameCommand(domain, eObject, NotationPackage.eINSTANCE.getDiagram_Name());

				// Change name for table
			} else if (eObject instanceof Table) {
				result = new ResetNameCommand(domain, eObject,
						NattableconfigurationPackage.eINSTANCE.getTableNamedElement_Name());
			}
		}

		return result;
	}

	/**
	 * This allows to modify the name of the entry object when the label value
	 * is modified to notify all the name listeners. When the label change, all
	 * the name listeners need to be called.
	 * 
	 * @param eObject
	 *            The eObject of the label to modify.
	 */
	protected void setNameValue(final EObject eObject) {

		// Change name for diagram
		if (eObject instanceof Diagram) {
			final String oldName = ((Diagram) eObject).getName();
			((Diagram) eObject).setName(""); //$NON-NLS-1$
			((Diagram) eObject).setName(oldName);

			// Change name for table
		} else if (eObject instanceof Table) {
			final String oldName = ((Table) eObject).getName();
			((Table) eObject).setName(""); //$NON-NLS-1$
			((Table) eObject).setName(oldName);
		}
	}

	/**
	 * Get the root of this model. Lookup in the associated {@link Resource} for
	 * the root.
	 *
	 * @param resource
	 *            The resource to search.
	 * @return The root of the model, or null if no root exist.
	 */
	public InternationalizationLibrary getModelRoot(final Resource resource) {
		if (null != resource) {
			for (final EObject object : resource.getContents()) {

				if (isModelRoot(object)) {
					return (InternationalizationLibrary) object;
				}
			}
		}

		// Not found
		return null;
	}

	/**
	 * This allows to determinate the properties locales files loaded for the
	 * uri.
	 * 
	 * @param uri
	 *            The [{@link URI} to search.
	 * @return The set of the locales.
	 */
	public Set<Locale> getAvailablePropertiesLocales(final URI uri) {
		final URI uriWithCorrectExtension = uri.trimFileExtension().appendFileExtension(getModelFileExtension());
		return propertiesByLocale.containsKey(uriWithCorrectExtension)
				? propertiesByLocale.get(uriWithCorrectExtension).keySet()
				: new HashSet<Locale>(0);
	}

	/**
	 * Get the locales and resources corresponding to the uri.
	 * 
	 * @param uri
	 *            The uri to search.
	 * @return The collection of the resources corresponding to the uri or
	 *         <code>null</code>.
	 */
	public Map<Locale, Resource> getLocalesAndResourcesForURI(final URI uri) {
		Map<Locale, Resource> result = null;

		final URI propertiesURI = uri.trimFileExtension().appendFileExtension(getModelFileExtension());

		if (propertiesByLocale.containsKey(propertiesURI)) {
			result = propertiesByLocale.get(propertiesURI);
		}

		return result;
	}

	/**
	 * Get the resource corresponding to the URI and the locale.
	 * 
	 * @param uri
	 *            The initial URI.
	 * @param locale
	 *            The locale to use.
	 * @return The resource corresponding.
	 */
	public Resource getResourceForURIAndLocale(final URI uri, final Locale locale) {
		Resource resultResource = null;

		final URI propertiesURI = uri.trimFileExtension().appendFileExtension(getModelFileExtension());

		if (propertiesByLocale.containsKey(propertiesURI)) {
			final Map<Locale, Resource> resourceByLocale = propertiesByLocale.get(propertiesURI);
			if (resourceByLocale.containsKey(locale)) {
				resultResource = resourceByLocale.get(locale);
			}
		}

		return resultResource;
	}

	/**
	 * Get the resource corresponding to the URI and the locale.
	 * 
	 * @param uri
	 *            The initial URI.
	 * @param Resource
	 *            The resource to search.
	 * @return The resource corresponding.
	 */
	public Locale getLocaleForResource(final Resource resource) {
		Locale resultLocale = null;

		for (final URI uri : propertiesByLocale.keySet()) {
			final Map<Locale, Resource> resourceByLocale = propertiesByLocale.get(uri);
			for (Entry<Locale, Resource> entry : resourceByLocale.entrySet()) {
				if (entry.getValue().equals(resource)) {
					resultLocale = entry.getKey();
				}
			}
		}

		return resultLocale;
	}

	/**
	 * Get the initial URI for the resource in parameter.
	 * 
	 * @param resource
	 *            The resource to search.
	 * @return The initial URI of the resource in parameter.
	 */
	protected URI getInitialURIForResource(final Resource resource) {
		URI initialURI = null;

		for (final Iterator<URI> uriIterator = propertiesByLocale.keySet().iterator(); uriIterator.hasNext()
				&& null == initialURI;) {
			final URI uri = uriIterator.next();
			if (propertiesByLocale.get(uri).values().contains(resource)) {
				initialURI = uri;
			}
		}

		return initialURI;
	}

	/**
	 * Returns <code>true</code> if the URI was already loaded,
	 * <code>false</code> otherwise.
	 * 
	 * @param uri
	 *            The URI to search.
	 * @return <code>true</code> if the URI was already loaded,
	 *         <code>false</code> otherwise.
	 */
	public boolean isLoadedResourcesForURI(final URI uri) {
		return propertiesByLocale.containsKey(uri.trimFileExtension().appendFileExtension(getModelFileExtension()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.EMFLogicalModel#unload()
	 */
	@Override
	public void unload() {
		for (final Resource resource : getResources()) {
			final URI initialUri = getInitialURIForResource(resource);
			if (null != initialUri) {
				unload(initialUri);
			}
			resource.unload();
		}

		// Remove adapters
		for (final EObject eObject : adapters.keySet()) {
			Adapter adapter = adapters.get(eObject);
			eObject.eAdapters().remove(adapter);
			adapter = null;
		}
		adapters.clear();

		// Remove the editor parts
		if (null != editorPartByEObject) {
			editorPartByEObject.clear();
			editorPartByEObject = null;
		}

		// Dispose and remove the part label synchronizer
		if (null != entriesLabelSynchronizerByEObject) {
			for (final Entry<EObject, Map<InternationalizationEntry, EntryPartLabelSynchronizer>> entry : entriesLabelSynchronizerByEObject
					.entrySet()) {
				for (final EntryPartLabelSynchronizer partLabelSynchronizer : entry.getValue().values()) {
					partLabelSynchronizer.dispose();
				}
			}
			entriesLabelSynchronizerByEObject.clear();
			entriesLabelSynchronizerByEObject = null;
		}

		// Dispose and remove the preference part label synchronizer
		if (null != preferencePartLabelSynchronizers) {
			for (final PreferencePartLabelSynchronizer preferenceStynchronizer : preferencePartLabelSynchronizers
					.values()) {
				preferenceStynchronizer.dispose();
			}
			preferencePartLabelSynchronizers.clear();
			preferencePartLabelSynchronizers = null;
		}

		super.unload();
	}

	/**
	 * This allows to unload the resource of the URI in parameter.
	 * 
	 * @param uri
	 *            The URI of the resource.
	 */
	public void unload(final URI uri) {
		PropertiesFilesUtils.removeResourceBundle(uri);
		if (propertiesByLocale.containsKey(uri)) {
			propertiesByLocale.remove(uri);
		}
	}

	/**
	 * This allows to unload the resource from the properties by locale.
	 * 
	 * @param resource
	 *            The resource to unload.
	 */
	public void unload(final Resource resource) {
		PropertiesFilesUtils.removeResourceBundle(resource.getURI());
		final URI initialUri = getInitialURIForResource(resource);

		if (propertiesByLocale.containsKey(initialUri)) {
			Iterator<Entry<Locale, Resource>> entriesIterator = propertiesByLocale.get(initialUri).entrySet()
					.iterator();
			while (entriesIterator.hasNext()) {
				final Entry<Locale, Resource> entry = entriesIterator.next();
				if (entry.getValue().equals(resource)) {
					entriesIterator.remove();
				}
			}
		}
	}

	/**
	 * This allows to create a properties resource by command.
	 */
	private class CreatePropertiesResourceCommand extends AbstractCommand {

		/**
		 * The URI of the resource to create.
		 */
		protected URI uri;

		/**
		 * The entry to add to the resource internationalization library if not
		 * <code>null</code>.
		 */
		protected InternationalizationEntry entryToAdd;

		/**
		 * The created resource result.
		 */
		protected Resource createdResource;

		/**
		 * The locale of the file to create.
		 */
		protected Locale locale;

		/**
		 * Constructor.
		 *
		 * @param uri
		 *            The URI of the resource to create.
		 * @param entry
		 *            The entry to add to the resource internationalization
		 *            library if not <code>null</code>.
		 */
		public CreatePropertiesResourceCommand(final URI uri, final InternationalizationEntry entry,
				final Locale locale) {
			super("Create properties resource"); //$NON-NLS-1$
			this.uri = uri.trimFileExtension().appendFileExtension(getModelFileExtension());
			this.entryToAdd = entry;
			this.locale = locale;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.common.command.AbstractCommand#prepare()
		 */
		@Override
		protected boolean prepare() {
			return uri.fileExtension().equals(PropertiesFilesUtils.PROPERTIES_FILE_EXTENSION);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.common.command.Command#execute()
		 */
		@Override
		public void execute() {
			createdResource = createResource(uri, locale);

			if (null != entryToAdd) {
				final InternationalizationLibrary library = getModelRoot(createdResource);
				library.getEntries().add(entryToAdd);
			}

			if (modelSet.getResourcesToDeleteOnSave().contains(createdResource.getURI())) {
				modelSet.getResourcesToDeleteOnSave().remove(createdResource.getURI());
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.common.command.AbstractCommand#undo()
		 */
		@Override
		public void undo() {
			unload(uri);
			createdResource.unload();
			getResources().remove(createdResource);
			modelSet.getResourcesToDeleteOnSave().add(createdResource.getURI());
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.common.command.Command#redo()
		 */
		@Override
		public void redo() {
			execute();
		}
	}

	/**
	 * This must be called when an Editor Part that contains the label
	 * internationalization will be opened. This allows to add the object and
	 * the editor part corresponding to the object.
	 * 
	 * @param eObject
	 *            The object corresponding to a part which manage the label
	 *            modification.
	 * @param editorPart
	 *            The editor part corresponding to the object.
	 */
	public void addEditorPartForEObject(final EObject eObject, final IInternationalizationEditor editorPart) {
		// Create the map if not existing
		if (null == editorPartByEObject) {
			editorPartByEObject = new HashMap<EObject, IInternationalizationEditor>();
		}

		// Add the eObject and editor part correspondance if not already
		// existing
		if (!editorPartByEObject.containsKey(eObject)) {
			editorPartByEObject.put(eObject, editorPart);
		}

		// Call the part label synchronizer for the entries corresponding to the
		// object
		final URI uri = eObject.eResource().getURI();
		for (final Locale locale : getAvailablePropertiesLocales(uri)) {
			final InternationalizationEntry entry = getEntryForKey(uri, eObject, locale);
			addPartLabelSynchronizerForEntry(eObject, entry);
		}

		// Create the part label synchronizer for the preference store
		// modification for the object
		addPartLabelSynchronizerForPreferenceStore(eObject);
	}

	/**
	 * This allows to add a {@link EntryPartLabelSynchronizer} for the
	 * {@link EObject} in parameter.
	 * 
	 * @param eObject
	 *            The object corresponding to a part which manage the label
	 *            modification.
	 * @param entry
	 *            The entry corresponding to the {@link EObject} which be called
	 *            for the label modification.
	 */
	protected void addPartLabelSynchronizerForEntry(final EObject eObject, final InternationalizationEntry entry) {
		// Create the map if not existing
		if (null == entriesLabelSynchronizerByEObject) {
			entriesLabelSynchronizerByEObject = new HashMap<EObject, Map<InternationalizationEntry, EntryPartLabelSynchronizer>>();
		}

		// Get the map of entries and part label synchronizer for the
		// corresponding object
		Map<InternationalizationEntry, EntryPartLabelSynchronizer> entriesLabelSynchronizer = null;
		if (entriesLabelSynchronizerByEObject.containsKey(eObject)) {
			entriesLabelSynchronizer = entriesLabelSynchronizerByEObject.get(eObject);
		} else {
			entriesLabelSynchronizer = new HashMap<InternationalizationEntry, EntryPartLabelSynchronizer>();
			entriesLabelSynchronizerByEObject.put(eObject, entriesLabelSynchronizer);
		}

		// If the entry if not already managed, create the part label
		// synchronizer
		if (!entriesLabelSynchronizer.containsKey(entry)) {
			entriesLabelSynchronizer.put(entry,
					new EntryPartLabelSynchronizer(entry, editorPartByEObject.get(eObject), this));
		}
	}

	/**
	 * This allows to manage a part label synchronizer for the object label when
	 * the internationalization preference change.
	 * 
	 * @param eObject
	 *            The {@link EObject} corresponding to a part which manage the
	 *            label modification.
	 */
	protected void addPartLabelSynchronizerForPreferenceStore(final EObject eObject) {
		// Create the map if not existing
		if (null == preferencePartLabelSynchronizers) {
			preferencePartLabelSynchronizers = new HashMap<EObject, PreferencePartLabelSynchronizer>();
		}

		// If the object is not already managed, create the part label
		// synchronizer for the preference
		if (!preferencePartLabelSynchronizers.containsKey(eObject)) {
			final IPreferenceStore preferenceStore = InternationalizationPreferencesUtils.getPreferenceStore(eObject);

			if (null != preferenceStore) {
				preferencePartLabelSynchronizers.put(eObject, new PreferencePartLabelSynchronizer(preferenceStore,
						eObject, editorPartByEObject.get(eObject), this));
			}
		}
	}
}

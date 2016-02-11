/*****************************************************************************
 * Copyright (c) 2009, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Rewrite the sash model - store in the plugin's PreferenceStore (Bug 429239)
 *  Christian W. Damus (CEA) - bugs 429242, 436468
 * 	Christian W. Damus - bugs 434983, 469188, 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource.sasheditor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.EMFLogicalModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;

import com.google.common.base.Objects;

/**
 * <p>
 * Model for the sash system.
 * </p>
 * <p>
 * It may be stored in the *.di file (Legacy mode) or in a *.sash file in the user
 * preference space (~workspace/.metadata/.plugins/org.eclipse.papyrus.infra.core/)
 * </p>
 * <p>
 * The following properties are observable via Java Beans {@linkplain #addPropertyChangeListener(String, PropertyChangeListener) listeners}:
 * </p>
 * <ul>
 * <li>{@link #isLegacyMode() legacyMode}</li>
 * <li>{@link #getPrivateResourceURI() privateResourceURI}</li>
 * <li>{@link #getSharedResourceURI() sharedResourceURI}</li>
 * </ul>
 *
 * @author Cedric Dumoulin
 * @author Camille Letavernier
 *
 */
public class SashModel extends EMFLogicalModel implements IModel {

	/**
	 * @since 2.0
	 */
	public static final String PROPERTY_PRIVATE_RESOURCE_URI = "privateResourceURI"; //$NON-NLS-1$
	/**
	 * @since 2.0
	 */
	public static final String PROPERTY_SHARED_RESOURCE_URI = "sharedResourceURI"; //$NON-NLS-1$
	/**
	 * @since 2.0
	 */
	public static final String PROPERTY_LEGACY_MODE = "legacyMode"; //$NON-NLS-1$

	private final PropertyChangeSupport bean = new PropertyChangeSupport(this);

	private SashModelProviderManager providerManager;

	private Adapter sashModelStorageAdapter;

	private volatile Boolean legacyMode;

	/**
	 * File extension.
	 *
	 * @deprecated Use {@link DiModel#MODEL_FILE_EXTENSION} instead. The SashModel has been moved to a separate file
	 */
	@Deprecated
	public static final String MODEL_FILE_EXTENSION = "di"; //$NON-NLS-1$

	/**
	 * File extension for the Sash model
	 */
	public static final String SASH_MODEL_FILE_EXTENSION = "sash"; //$NON-NLS-1$

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel"; //$NON-NLS-1$

	/**
	 *
	 * Constructor.
	 *
	 */
	public SashModel() {
		super();

		sashModelStorageAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (getResources().contains(msg.getNotifier())) {
					switch (msg.getFeatureID(Resource.class)) {
					case Resource.RESOURCE__CONTENTS:
						invalidateLegacyMode();
						break;
					}
				}
			}
		};
	}

	/**
	 * Get the file extension used for this model.
	 *
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getModelFileExtension()
	 *
	 * @return
	 */
	@Override
	protected String getModelFileExtension() {
		if (isLegacy((resourceURI == null) ? resourceURI : resourceURI.trimFileExtension())) {
			return DiModel.MODEL_FILE_EXTENSION;
		} else {
			return SASH_MODEL_FILE_EXTENSION;
		}
	}

	@Override
	public void init(ModelSet modelSet) {
		super.init(modelSet);

		this.providerManager = new SashModelProviderManager(modelSet);
	}

	@Override
	public void unload() {
		if (providerManager != null) {
			providerManager.dispose();
			providerManager = null;
		}

		getResources().forEach(res -> res.eAdapters().remove(sashModelStorageAdapter));

		super.unload();
	}

	@Override
	protected boolean isRelatedResource(Resource resource) {
		boolean result = false;

		if (resource != null) {
			// We only handle the main Sash resource. Imported *.sash are not relevant
			if (resource == getResource()) {
				result = true;
			} else {
				// We can only calculate these related URIs if the ModelSet is initialized
				result = resource.getURI().equals(getPrivateResourceURI()) || resource.getURI().equals(getSharedResourceURI());
			}
		}

		return result;
	}

	@Override
	protected void configureResource(Resource resourceToConfigure) {
		super.configureResource(resourceToConfigure);

		if (resourceToConfigure != null) {
			resourceToConfigure.eAdapters().add(sashModelStorageAdapter);
		}
	}

	/**
	 * Get the identifier used to register this model.
	 *
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getIdentifier()
	 *
	 * @return
	 */
	@Override
	public String getIdentifier() {
		return MODEL_ID;
	}

	@Override
	public void loadModel(URI uriWithoutExtension) {

		URI sashModelURI = getSashModelURI(uriWithoutExtension);

		this.resourceURI = sashModelURI;

		try {
			super.loadModel(sashModelURI.trimFileExtension());
		} catch (Exception ex) {
			createModel(sashModelURI.trimFileExtension());
		}

		if (resource == null) {
			createModel(sashModelURI.trimFileExtension());
		}
	}

	@Override
	public void createModel(URI uriWithoutExtension) {
		if (isLegacy(uriWithoutExtension)) {
			super.createModel(getSashModelStoreURI(uriWithoutExtension).trimFileExtension());
		} else {
			super.createModel(uriWithoutExtension);
		}
	}

	@Override
	public void setModelURI(URI uriWithoutExtension) {
		URI oldPrivateURI = getPrivateResourceURI();
		URI oldSharedURI = getSharedResourceURI();

		URI newURI;
		if ((resourceURI != null) && isLegacy(resourceURI.trimFileExtension())) {
			newURI = getLegacyURI(uriWithoutExtension);
		} else {
			newURI = getSashModelStoreURI(uriWithoutExtension);
		}

		super.setModelURI(newURI.trimFileExtension());

		bean.firePropertyChange(PROPERTY_PRIVATE_RESOURCE_URI, oldPrivateURI, getPrivateResourceURI());
		bean.firePropertyChange(PROPERTY_SHARED_RESOURCE_URI, oldSharedURI, getSharedResourceURI());
	}

	protected boolean isLegacy(URI uriWithoutExtension) {
		if (uriWithoutExtension == null) {
			return false;
		}
		return Objects.equal(uriWithoutExtension, getModelManager().getURIWithoutExtension());
	}

	/**
	 * Returns the sash model URI (With file extension)
	 *
	 * It may be either the Legacy URI (platform:/resource/model/model.di)
	 * or the 1.0.0 URI (file:/~workspace/.metadata/.plugins/org.eclipse.papyrus.infra.core/model/model.sash)
	 *
	 * @param uriWithoutExtension
	 * @return
	 *
	 */
	protected URI getSashModelURI(URI uriWithoutExtension) {
		URIConverter converter = getModelManager().getURIConverter();
		URI legacyURI = getLegacyURI(uriWithoutExtension);

		// If the DI file exists and contains a SashWindowsMngr, this is a legacy model
		if (converter.exists(legacyURI, Collections.emptyMap())) {
			try {
				Resource diResource = getModelManager().getResource(legacyURI, true);
				if (DiUtils.lookupSashWindowsMngr(diResource) != null) {
					return legacyURI;
				}
			} catch (Exception ex) {
				// Temporary workaround: the DI file may exist and be empty
				// (DiModel is currently disabled and doesn't properly init the di file)
				// Log the error and continue
				Activator.log.error(ex);
			}
		}

		URI preferenceStoreURI = getSashModelStoreURI(uriWithoutExtension);

		return preferenceStoreURI;
	}

	protected URI getLegacyURI(URI uriWithoutExtension) {
		return uriWithoutExtension.appendFileExtension(DiModel.MODEL_FILE_EXTENSION);
	}

	protected URI getSashModelStoreURI(URI uriWithoutExtension) {
		URI fullURI = uriWithoutExtension.appendFileExtension(SASH_MODEL_FILE_EXTENSION);
		return providerManager.getSashModelProvider(fullURI).getSashModelURI(fullURI);
	}

	@Override
	protected Map<Object, Object> getSaveOptions() {
		Map<Object, Object> saveOptions = super.getSaveOptions();

		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.FALSE);
		saveOptions.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.FALSE);
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		return saveOptions;
	}

	/**
	 * @since 2.0
	 */
	public boolean isLegacyMode() {
		if (legacyMode == null) {
			legacyMode = false; // Assume not

			// Does the shared DI resource contain the sash layout?
			URI sharedURI = getSharedResourceURI();
			if (sharedURI != null) {
				for (Resource next : getResources()) {
					if (sharedURI.equals(next.getURI())) {
						legacyMode = DiUtils.lookupSashWindowsMngr(next) != null;
						break;
					}
				}
			}
		}

		return legacyMode;
	}

	void invalidateLegacyMode() {
		boolean oldValue = isLegacyMode();

		legacyMode = null;

		boolean newValue = isLegacyMode();

		if (oldValue != newValue) {
			bean.firePropertyChange(PROPERTY_LEGACY_MODE, oldValue, newValue);
		}
	}

	/**
	 * Gets the URI of the sash-model resource in the user private area, irrespective
	 * of whether that actually is the resource that currently stores the sash model.
	 * 
	 * @return the private sash-model resource URI
	 * @since 2.0
	 */
	public URI getPrivateResourceURI() {
		URI modelURI = (getModelManager() == null) ? null : getModelManager().getURIWithoutExtension();
		return (modelURI == null) ? null : getSashModelStoreURI(modelURI);
	}

	/**
	 * Gets the URI of the sash-model resource in the shared (collocated with the user model)
	 * area, irrespective of whether that actually is the resource that currently stores the
	 * sash model.
	 * 
	 * @return the shared sash-model resource URI
	 * @since 2.0
	 */
	public URI getSharedResourceURI() {
		URI modelURI = (getModelManager() == null) ? null : getModelManager().getURIWithoutExtension();
		return (modelURI == null) ? null : modelURI.appendFileExtension(DiModel.MODEL_FILE_EXTENSION);
	}

	@Override
	protected boolean isRootElement(EObject object) {
		return super.isRootElement(object) && (object instanceof SashWindowsMngr);
	}

	@Override
	protected boolean isSupportedRoot(EObject object) {
		return DiPackage.Literals.SASH_WINDOWS_MNGR.isInstance(object);
	}

	//
	// Bean API
	//

	/**
	 * @since 2.0
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		bean.addPropertyChangeListener(listener);
	}

	/**
	 * @since 2.0
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		bean.removePropertyChangeListener(listener);
	}

	/**
	 * @since 2.0
	 */
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		bean.addPropertyChangeListener(propertyName, listener);
	}

	/**
	 * @since 2.0
	 */
	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		bean.removePropertyChangeListener(propertyName, listener);
	}
}

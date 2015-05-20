/*****************************************************************************
 * Copyright (c) 2018 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.service;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.decoration.DecorationService;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.decoration.UndefinedProfileMarker;
import org.eclipse.papyrus.uml.tools.model.ExtendedUmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.profile.definition.IPapyrusVersionConstants;
import org.eclipse.papyrus.uml.tools.profile.definition.PapyrusDefinitionAnnotation;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Implementation of Profile Definition service.
 * 
 * @author Gabriel Pascual
 * @since 4.1
 */
public class ProfileDefinitionService implements IService, IProfileDefinitionService {


	/** The model set. */
	private ModelSet modelSet = null;

	/** The map instance. */
	private static Map<Profile, IPapyrusMarker> mapInstance = new HashMap<Profile, IPapyrusMarker>();

	/**
	 * Constructor.
	 *
	 */
	public ProfileDefinitionService() {
	}


	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 *
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	@Override
	public void init(final ServicesRegistry servicesRegistry) throws ServiceException {
		modelSet = servicesRegistry.getService(ModelSet.class);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 *
	 * @throws ServiceException
	 */
	@Override
	public void startService() throws ServiceException {

		UmlModel umlModel = (UmlModel) modelSet.getModel(ExtendedUmlModel.MODEL_ID);
		try {
			EObject rootElement = umlModel.lookupRoot();


			if (rootElement instanceof Profile) {
				EAnnotation umlAnnotation = ((Profile) rootElement).getEAnnotation(UMLUtil.UML2_UML_PACKAGE_2_0_NS_URI);
				if (null != umlAnnotation && !umlAnnotation.getEAnnotations().isEmpty()) {
					EAnnotation emptyAnnotation = umlAnnotation.getEAnnotation(IPapyrusVersionConstants.PAPYRUS_EANNOTATION_SOURCE);
					if (null != emptyAnnotation) {
						PapyrusDefinitionAnnotation parsedAnnotation = PapyrusDefinitionAnnotation.parseEAnnotation(emptyAnnotation);
						if (PapyrusDefinitionAnnotation.UNDEFINED_ANNOTATION.equals(parsedAnnotation)) {
							DecorationService decorationService = ServiceUtilsForEObject.getInstance().getService(DecorationService.class, rootElement);
							decorationService.addDecoration(getMarker((Profile) rootElement), rootElement);
						}
					}

				}
			}
		} catch (NotFoundException e) {
			Activator.log.error(e);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}




	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 *
	 * @throws ServiceException
	 */
	@Override
	public void disposeService() throws ServiceException {
		mapInstance.clear();
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.tools.service.IProfileDefinitionService#getMarker(org.eclipse.uml2.uml.Profile)
	 *
	 * @param profile
	 * @return
	 */
	@Override
	public IPapyrusMarker getMarker(final Profile profile) {

		IPapyrusMarker marker = mapInstance.get(profile);
		if (marker == null) {
			marker = new UndefinedProfileMarker(profile);
			mapInstance.put(profile, marker);
		}

		return marker;
	}


	/**
	 * {@inheritDoc }
	 * 
	 * @see org.eclipse.papyrus.uml.tools.service.IProfileDefinitionService#disposeMarker(org.eclipse.uml2.uml.Profile)
	 *
	 * @param profile
	 */
	@Override
	public void disposeMarker(final Profile profile) {
		mapInstance.remove(profile);
	}

}

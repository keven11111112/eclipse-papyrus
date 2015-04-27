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

package org.eclipse.papyrus.umlrt.ui.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.papyrus.umlrt.custom.IUMLRTElementTypes;
import org.eclipse.papyrus.umlrt.custom.UMLRTElementTypesEnumerator;
import org.eclipse.papyrus.umlrt.ui.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;

/**
 * Label provider used by the label provider service
 */
public class UMLRTFilteredLabelProvider implements IFilteredLabelProvider {

	public final Map<String, String> typeIdtoIconPath;

	/** path to the icons in the plugin */
	protected static String ICON_PATH = "/icons/";

	protected static String RT_MESSAGE_IN_ICON = ICON_PATH + "rt_message_in.gif";//$NON-NLS-1$
	protected static String RT_MESSAGE_IN_OUT_ICON = ICON_PATH + "rt_message_inout.gif";//$NON-NLS-1$
	protected static String RT_MESSAGE_OUT_ICON = ICON_PATH + "rt_message_out.gif";//$NON-NLS-1$
	protected static String RT_MESSAGE_UNDEFINED_ICON = ICON_PATH + "rt_message_undefined.gif";//$NON-NLS-1$

	/**
	 * Default constructor
	 */
	public UMLRTFilteredLabelProvider() {
		typeIdtoIconPath = new HashMap<String, String>();
		typeIdtoIconPath.put(IUMLRTElementTypes.CAPSULE_ID, ICON_PATH + "capsule.png"); //$NON-NLS-1$
		typeIdtoIconPath.put(IUMLRTElementTypes.CAPSULE_PART_ID, ICON_PATH + "capsule_part.png");//$NON-NLS-1$
		typeIdtoIconPath.put(IUMLRTElementTypes.PROTOCOL_CONTAINER_ID, ICON_PATH + "protocol_container.png");//$NON-NLS-1$
		typeIdtoIconPath.put(IUMLRTElementTypes.PROTOCOL_ID, ICON_PATH + "protocol.png");//$NON-NLS-1$
		typeIdtoIconPath.put(IUMLRTElementTypes.RT_CONNECTOR_ID, ICON_PATH + "rt_connector.png");//$NON-NLS-1$
		typeIdtoIconPath.put(IUMLRTElementTypes.RT_EXCLUDED_ELEMENT_ID, ICON_PATH + "rt_excludedElement.gif");//$NON-NLS-1$
		typeIdtoIconPath.put(IUMLRTElementTypes.RT_MESSAGE_SET_ID, ICON_PATH + "rt_messageset.png");//$NON-NLS-1$
		typeIdtoIconPath.put(IUMLRTElementTypes.RT_PORT_ID, ICON_PATH + "rt_port.png");//$NON-NLS-1$
		typeIdtoIconPath.put(IUMLRTElementTypes.RT_MESSAGE_IN_ID, RT_MESSAGE_IN_ICON);
		typeIdtoIconPath.put(IUMLRTElementTypes.RT_MESSAGE_INOUT_ID, RT_MESSAGE_IN_OUT_ICON);
		typeIdtoIconPath.put(IUMLRTElementTypes.RT_MESSAGE_OUT_ID, RT_MESSAGE_OUT_ICON);
		typeIdtoIconPath.put(IUMLRTElementTypes.RT_MESSAGE_ID, RT_MESSAGE_UNDEFINED_ICON);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean accept(Object element) {
		EObject semanticObject = EMFHelper.getEObject(element);

		// element should be an UML element at least. UML-RT profile should be present.
		if (!(semanticObject instanceof Element)) {
			return false;
		}

		for (IElementType type : UMLRTElementTypesEnumerator.getAllRTTypes()) {
			if (type instanceof ISpecializationType) {
				IElementMatcher matcher = ((ISpecializationType) type).getMatcher();
				if (matcher != null) {
					if (((ISpecializationType) type).getMatcher().matches(semanticObject)) {
						return true;
					}
				} else {
					Activator.log.debug("no matcher for this element type: " + type);
				}

			}
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		EObject semanticObject = EMFHelper.getEObject(element);

		if (!(semanticObject instanceof Element)) {
			Activator.log.debug("Trying to display an UMLRT image for a non UML-RT element");
			return null;
		}

		// depending on the element type that matches, return a different icon
		String matchingTypeMatcher = getMatchingType(semanticObject);
		
		if( matchingTypeMatcher ==null) {
			return null;
		}
		
		Image image = null;
		// a match was done. give a different icon given the value
		switch (matchingTypeMatcher) {
//		case IUMLRTElementTypes.RT_MESSAGE_SET_ID:
//			// for RT message, direction can give different icons
//
//			// the element has the RT messageset stereotype applied. It should be possible to retrieve it and even better the direction
//			RTMessageKind kind = MessageSetUtils.getMessageKind(semanticObject);
//			if (kind != null) {
//				switch (kind) {
//				case IN:
//					image = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, RT_MESSAGE_SET_IN_ICON);
//					break;
//				case OUT:
//					image = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, RT_MESSAGE_SET_OUT_ICON);
//					break;
//				case IN_OUT:
//					image = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, RT_MESSAGE_SET_IN_OUT_ICON);
//					break;
//				default:
//					image = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, RT_MESSAGE_SET_UNDEFINED_ICON);
//					break;
//				}
//				break;
//			}
//			image = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, RT_MESSAGE_SET_UNDEFINED_ICON);
//			break;
		case IUMLRTElementTypes.RT_MESSAGE_IN_ID:
			image = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, RT_MESSAGE_IN_ICON);
			break;
		case IUMLRTElementTypes.RT_MESSAGE_OUT_ID:
			image = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, RT_MESSAGE_OUT_ICON);
			break;
		case IUMLRTElementTypes.RT_MESSAGE_INOUT_ID:
			image = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, RT_MESSAGE_IN_OUT_ICON);
			break;

			//
			// // for RT message, direction can give different icons
			//
			// RTMessageKind kind = RTMessageUtils.getMessageKind(semanticObject);
			// if (kind != null) {
			// switch (kind) {
			// case IN:
			// image = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, RT_MESSAGE_IN_ICON);
			// break;
			// case OUT:
			// image = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, RT_MESSAGE_OUT_ICON);
			// break;
			// case IN_OUT:
			// image = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, RT_MESSAGE_IN_OUT_ICON);
			// break;
			// default:
			// image = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, RT_MESSAGE_UNDEFINED_ICON);
			// break;
			// }
			// break;
			// }
		default:
			image = getElementImage(matchingTypeMatcher, semanticObject);
			break;
		}

		return image;
	}

	/**
	 * Return the element type identifier for the given semantic EObject, given the predefined UML-RT list
	 * 
	 * @param semanticObject
	 *            the element to display
	 * @return the unique UML-RT element type identifier or <code>null</code>
	 */
	protected String getMatchingType(EObject semanticObject) {
		for (IElementType type : UMLRTElementTypesEnumerator.getAllRTTypes()) {
			if (type instanceof ISpecializationType) {
				if (((ISpecializationType) type).getMatcher().matches(semanticObject)) {
					return type.getId();
				}
			}
		}
		return null;
	}

	/**
	 * @param type
	 * @param element
	 * @return
	 */
	protected Image getElementImage(String id, EObject semanticObject) {
		String iconPath = typeIdtoIconPath.get(id);
		if (iconPath != null) {
			return org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, iconPath);
		}
		return null;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		return new UMLLabelProvider().getText(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addListener(ILabelProviderListener listener) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeListener(ILabelProviderListener listener) {

	}

}

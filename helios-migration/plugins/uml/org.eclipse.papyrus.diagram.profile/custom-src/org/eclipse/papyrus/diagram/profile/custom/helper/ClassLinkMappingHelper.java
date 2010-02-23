/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - 
 *  	refactor common behavior between diagrams, define only specific behavior
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from the class diagram 
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.papyrus.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper.CommonSourceUMLSwitch;
import org.eclipse.papyrus.diagram.common.helper.LinkMappingHelper.CommonTargetUMLSwitch;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * The Class LinkMappingHelper is specialization of the link mapping helper for the Class diagram
 */
public class ClassLinkMappingHelper implements ILinkMappingHelper {

	/**
	 * SingletonHolder is loaded at the first execution of getInstance() method
	 */
	private static class SingletonHolder {

		private final static ClassLinkMappingHelper instance = new ClassLinkMappingHelper();
	}

	/**
	 * Gets the single instance of ClassLinkMappingHelper.
	 * 
	 * @return single instance of ClassLinkMappingHelper
	 */
	public static ClassLinkMappingHelper getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * private constructor
	 */
	private ClassLinkMappingHelper() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getSource(Element link) {
		return LinkMappingHelper.getSource(link, new CommonSourceUMLSwitch() {

			@Override
			public java.util.Collection<?> caseAssociationClass(org.eclipse.uml2.uml.AssociationClass object) {
				return object.getEndTypes();
			};

			@Override
			public java.util.Collection<?> caseElementImport(org.eclipse.uml2.uml.ElementImport object) {
				ArrayList result = new ArrayList();
				result.add(object.getImportingNamespace());
				return result;
			};

			@Override
			public java.util.Collection<?> caseGeneralizationSet(org.eclipse.uml2.uml.GeneralizationSet object) {
				return object.getGeneralizations();
			};

			@Override
			public java.util.Collection<?> caseInterfaceRealization(org.eclipse.uml2.uml.InterfaceRealization object) {
				ArrayList result = new ArrayList();
				result.add(object.getImplementingClassifier());
				return result;

			};

			@Override
			public java.util.Collection<?> caseProfileApplication(org.eclipse.uml2.uml.ProfileApplication object) {
				ArrayList result = new ArrayList();
				result.add(object.getApplyingPackage());
				return result;
			};

			@Override
			public java.util.Collection<?> caseTemplateBinding(org.eclipse.uml2.uml.TemplateBinding object) {
				ArrayList result = new ArrayList();
				result.add(object.getBoundElement());
				return result;
			};

			@Override
			public java.util.Collection<?> caseExtension(org.eclipse.uml2.uml.Extension object) {
				ArrayList<Type> result = new ArrayList<Type>();
				//it's possible don't have ownedEnd...
				if(object.getOwnedEnds().size() != 0) {
					Iterator<Property> iterator = object.getOwnedEnds().iterator();
					while(iterator.hasNext()) {
						result.add(iterator.next().getType());
					}


				}
				return result;
			};

		});
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getTarget(Element link) {
		return LinkMappingHelper.getTarget(link, new CommonTargetUMLSwitch() {

			@Override
			public java.util.Collection<?> caseExtension(org.eclipse.uml2.uml.Extension object) {
				ArrayList result = new ArrayList();
				if(object.getMemberEnds().size() != 0) {
					for(int i = 0; i < object.getMemberEnds().size(); i++) {
						if(!(object.getMemberEnds().get(i) instanceof ExtensionEnd)) {
							result.add((object.getMemberEnds().get(i)).getType());
						}
					}
				}
				return result;
			};


			@Override
			public java.util.Collection<?> caseAssociationClass(org.eclipse.uml2.uml.AssociationClass object) {
				return object.getEndTypes();
			};

			@Override
			public java.util.Collection<?> caseElementImport(org.eclipse.uml2.uml.ElementImport object) {
				ArrayList result = new ArrayList();
				result.add(object.getImportedElement());
				return result;
			};

			@Override
			public java.util.Collection<?> caseGeneralizationSet(org.eclipse.uml2.uml.GeneralizationSet object) {
				return object.getGeneralizations();
			};

			@Override
			public java.util.Collection<?> caseInterfaceRealization(org.eclipse.uml2.uml.InterfaceRealization object) {
				ArrayList result = new ArrayList();
				result.add(object.getContract());
				return result;
			};

			@Override
			public java.util.Collection<?> caseProfileApplication(org.eclipse.uml2.uml.ProfileApplication object) {
				ArrayList result = new ArrayList();
				result.add(object.getAppliedProfile());
				return result;
			};

			@Override
			public java.util.Collection<?> caseTemplateBinding(org.eclipse.uml2.uml.TemplateBinding object) {
				return object.getTargets();
			};

		});
	}
}

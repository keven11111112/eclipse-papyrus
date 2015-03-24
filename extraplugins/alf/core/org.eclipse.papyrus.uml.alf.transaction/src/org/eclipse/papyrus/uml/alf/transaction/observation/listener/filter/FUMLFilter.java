/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Jeremie Tatibouet (CEA LIST)
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.transaction.observation.listener.filter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CommunicationPath;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

public class FUMLFilter extends NotificationFilter.Custom {

	public FUMLFilter() {
	}

	/**
	 * Filter starting point
	 */
	public boolean matches(Notification notification) {
		Object notifier = notification.getNotifier();
		if (!this.isNotifierAllowed(notifier)) {
			return false;
		}
		Object feature = notification.getFeature();
		if (notifier != null && feature != null) {
			if (this.isEnumeration(notifier)) {
				return this.isEnumerationFeatureListened((EStructuralFeature) feature);
			} else if (this.isDataType(notifier)) {
				return this.isDatatypeFeatureListened((EStructuralFeature) feature);
			} else if (this.isPackage(notifier)) {
				return this.isPackageFeatureListened((EStructuralFeature) feature);
			} else if (this.isAssociation(notifier)) {
				return this.isAssociationFeatureListener((EStructuralFeature) feature);
			} else if (this.isSignal(notifier)) {
				return this.isSignalFeatureListened((EStructuralFeature) feature);
			} else if (this.isClass(notifier)) {
				return this.isClassFeatureListened((EStructuralFeature) feature);
			} else if (this.isGeneralization(notifier)) {
				return this.isGeneralizationtFeatureListened((EStructuralFeature) feature);
			}
		}
		return false;
	}

	private boolean isNotifierAllowed(Object notifier) {
		boolean allowed = false;
		if (notifier instanceof Element) {
			EObject target = (EObject) notifier;
			if (target.eResource() != null && target.eResource() instanceof UMLResource) {
				allowed = target.eResource().isTrackingModification();
			}
		}
		return allowed;
	}

	/*----------------------------------------------------------------------------*/
	/* Enforce the filter to respect the fUML subset */
	/*----------------------------------------------------------------------------*/

	private boolean isGeneralization(Object notifier) {
		return notifier instanceof Generalization;
	}

	/**
	 * 
	 * @param notifier
	 * @return
	 */
	private boolean isClass(Object notifier) {
		if (notifier instanceof Class &&
				(!(notifier instanceof AssociationClass) &&
						!(notifier instanceof Component) &&
						!(notifier instanceof Node) &&
						!(notifier instanceof Stereotype) &&
				!(notifier instanceof Behavior))) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param notifier
	 * @return
	 */
	private boolean isSignal(Object notifier) {
		return notifier instanceof Signal;
	}

	/**
	 * 
	 * @param notifier
	 * @return
	 */
	private boolean isDataType(Object notifier) {
		if (notifier instanceof DataType
				&& !(notifier instanceof Enumeration)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param notifier
	 * @return
	 */
	private boolean isPackage(Object notifier) {
		if (notifier != null
				&& notifier instanceof Package
				&& !(notifier instanceof Model)
				&& !(notifier instanceof Profile)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param notifier
	 * @return
	 */
	private boolean isEnumeration(Object notifier) {
		return notifier instanceof Enumeration;
	}

	/**
	 * 
	 * @param notifier
	 * @return
	 */
	private boolean isAssociation(Object notifier) {
		if (notifier instanceof Association
				&& !(notifier instanceof AssociationClass)
				&& !(notifier instanceof Extension)
				&& !(notifier instanceof CommunicationPath)) {
			return true;
		}
		return false;
	}

	/*----------------------------------------------------------------------------*/
	/* Low level checks encoding the UML meta-model hierarchy */
	/*----------------------------------------------------------------------------*/

	private boolean isGeneralizationtFeatureListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getGeneralization_General() == feature
				|| UMLPackage.eINSTANCE.getGeneralization_Specific() == feature) {
			return true;
		}
		return false;
	}

	private boolean isNamedElementFeatureListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getNamedElement_Name() == feature
				|| UMLPackage.eINSTANCE.getNamedElement_QualifiedName() == feature
				|| UMLPackage.eINSTANCE.getNamedElement_Namespace() == feature
				|| UMLPackage.eINSTANCE.getNamedElement_Visibility() == feature
				|| UMLPackage.eINSTANCE.getNamedElement_Namespace() == feature) {
			return true;
		}
		return false;
	}

	private boolean isTypeFeatureListened(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getType_Package() == feature || this.isPackageableElementFeatureListened(feature);
	}

	private boolean isNamespaceFeatureListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getNamespace_ElementImport() == feature
				|| UMLPackage.eINSTANCE.getNamespace_ImportedMember() == feature
				|| UMLPackage.eINSTANCE.getNamespace_Member() == feature
				|| UMLPackage.eINSTANCE.getNamespace_OwnedMember() == feature
				|| UMLPackage.eINSTANCE.getNamespace_PackageImport() == feature
				|| this.isNamedElementFeatureListened(feature)) {
			return true;
		}
		return false;
	}

	private boolean isPackageableElementFeatureListened(EStructuralFeature feature) {
		return this.isNamedElementFeatureListened(feature);
	}

	private boolean isPackageFeatureListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getPackage_URI() == feature
				|| UMLPackage.eINSTANCE.getPackage_NestedPackage() == feature
				|| UMLPackage.eINSTANCE.getPackage_NestingPackage() == feature
				|| UMLPackage.eINSTANCE.getPackage_OwnedType() == feature
				|| UMLPackage.eINSTANCE.getPackage_PackagedElement() == feature
				|| this.isPackageableElementFeatureListened(feature)
				|| this.isNamespaceFeatureListened(feature)) {
			return true;
		}
		return false;
	}

	private boolean isClassifierFeatureListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getClassifier_IsFinalSpecialization() == feature
				|| UMLPackage.eINSTANCE.getClassifier_IsAbstract() == feature
				|| UMLPackage.eINSTANCE.getClassifier_Attribute() == feature
				|| UMLPackage.eINSTANCE.getClassifier_Feature() == feature
				|| UMLPackage.eINSTANCE.getClassifier_General() == feature
				|| UMLPackage.eINSTANCE.getClassifier_Generalization() == feature
				|| this.isNamespaceFeatureListened(feature)
				|| this.isTypeFeatureListened(feature)) {
			return true;
		}
		return false;
	}

	private boolean isStructuredClassifierFeatureListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute() == feature
				|| this.isClassifierFeatureListened(feature)) {
			return true;
		}
		return false;
	}

	private boolean isEncapsulatedClassifierFeatureListened(EStructuralFeature feature) {
		return this.isStructuredClassifierFeatureListened(feature);
	}

	private boolean isBehavioredClassifierListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getBehavioredClassifier_ClassifierBehavior() == feature
				|| UMLPackage.eINSTANCE.getBehavioredClassifier_OwnedBehavior() == feature
				|| this.isClassifierFeatureListened(feature)) {
			return true;
		}
		return false;
	}

	private boolean isClassFeatureListened(EStructuralFeature feature) {
		if (UMLPackage.eINSTANCE.getClass_IsActive() == feature
				|| UMLPackage.eINSTANCE.getClass_NestedClassifier() == feature
				|| UMLPackage.eINSTANCE.getClass_OwnedOperation() == feature
				|| UMLPackage.eINSTANCE.getClass_OwnedReception() == feature
				|| UMLPackage.eINSTANCE.getClass_SuperClass() == feature
				|| this.isEncapsulatedClassifierFeatureListened(feature)
				|| this.isBehavioredClassifierListened(feature)) {
			return true;
		}
		return false;
	}

	private boolean isAssociationFeatureListener(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getAssociation_OwnedEnd() == feature || this.isClassifierFeatureListened(feature);
	}

	private boolean isSignalFeatureListened(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getSignal_OwnedAttribute() == feature || this.isClassifierFeatureListened(feature);
	}

	private boolean isDatatypeFeatureListened(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getDataType_OwnedAttribute() == feature || this.isClassifierFeatureListened(feature);
	}

	private boolean isEnumerationFeatureListened(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getEnumeration_OwnedLiteral() == feature || this.isDatatypeFeatureListened(feature);
	}
}

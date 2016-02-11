/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Mauricio Alférez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation based on UML2 tutorials.
 *
 *****************************************************************************/
package org.eclipse.papyrus.requirements.languagecreationtools.domainModel2Profile.utils;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Utility methods to create a profile
 *
 */
/**
 * @author MA244259
 *
 */
public class Utils {
	/**
	 * Creates a new UML model with a specific name
	 * 
	 * @param name
	 *            The name of the model
	 * @return the UML model
	 */
	public static Model createModel(String name) {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName(name);
		return model;
	}

	/**
	 * Refresh the project that contains a file without user intervention (e.g.,
	 * by using the F5 key)
	 * 
	 * @param file
	 *            The file contained in the project to be refreshed
	 */
	public static void refreshProject(File file) {
		IProject iproject = ResourcesPlugin.getWorkspace().getRoot().getProject(file.getParentFile().getName());
		try {
			iproject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates an enumeration in a UML package
	 * 
	 * @param package_
	 *            The UML package that will owns the enumeration
	 * @param name
	 *            The name of the enumeration contained in package_
	 * @return a new Enumeration
	 */
	public static Enumeration createEnumeration(org.eclipse.uml2.uml.Package package_, String name) {
		Enumeration enumeration = package_.createOwnedEnumeration(name);
		return enumeration;
	}

	/**
	 * Creates an enumeration literal
	 * 
	 * @param enumeration
	 *            The enumeration that will own the literal
	 * @param name
	 *            The name of the literal
	 * @return a new enumeration literal
	 */
	public static EnumerationLiteral createEnumerationLiteral(Enumeration enumeration, String name) {
		EnumerationLiteral enumerationLiteral = enumeration.createOwnedLiteral(name);
		return enumerationLiteral;
	}

	/**
	 * Creates a extension of the specified metaclass with this stereotype.
	 * 
	 * @param metaclass
	 *            The UML metaclass that will be extended, for example Class or
	 *            Association
	 * @param stereotype
	 *            The stereotype that will extend the metaclass
	 * @param required
	 *            Whether the new extension should be required
	 * @return the new extension
	 */
	public static Extension createExtension(org.eclipse.uml2.uml.Class metaclass, Stereotype stereotype,
			boolean required) {
		Extension extension = stereotype.createExtension(metaclass, required);
		return extension;
	}

	/**
	 * Creates a new {@link org.eclipse.uml2.uml.Generalization}, with the
	 * specified '<em><b>General</b></em>', and appends it to the
	 * '<em><b>Generalization</b></em>' containment reference list.
	 * 
	 * @param specificClassifier
	 *            The '<em><b>Specific</b></em>' for the new
	 *            {@link org.eclipse.uml2.uml.Generalization}
	 * @param generalClassifier
	 *            The '<em><b>General</b></em>' for the new
	 *            {@link org.eclipse.uml2.uml.Generalization}
	 * @return the new generalization
	 */
	public static Generalization createGeneralization(Classifier specificClassifier, Classifier generalClassifier) {
		Generalization generalization = specificClassifier.createGeneralization(generalClassifier);
		return generalization;
	}

	/**
	 * Creates a new UML package inside another package
	 * 
	 * @param nestingPackage
	 *            The package that will contain the new package
	 * @param name
	 *            The name of the new package
	 * @return the new UML package
	 */
	public static org.eclipse.uml2.uml.Package createPackage(org.eclipse.uml2.uml.Package nestingPackage, String name) {
		org.eclipse.uml2.uml.Package package_ = nestingPackage.createNestedPackage(name);
		return package_;
	}

	/**
	 * Creates a new primitive type inside a Package
	 * 
	 * @param package_
	 *            The name of the package
	 * @param name
	 *            The name of the primitive type
	 * @return the primitive type
	 */
	public static PrimitiveType createPrimitiveType(org.eclipse.uml2.uml.Package package_, String name) {
		PrimitiveType primitiveType = package_.createOwnedPrimitiveType(name);
		return primitiveType;
	}

	/**
	 * Creates a UML profile with a specific name and nsURI
	 * 
	 * @param name
	 *            The new of the new profile
	 * @param nsURI
	 *            The nsURI of the new package
	 * @return the new UML profile
	 */
	public static Profile createProfile(String name, String nsURI) {
		Profile profile = UMLFactory.eINSTANCE.createProfile();
		profile.setName(name);
		profile.setURI(nsURI);
		return profile;
	}

	/**
	 * Creates a new stereotype in a specific profile
	 * 
	 * @param profile
	 *            The profile that will contain the stereotype
	 * @param name
	 *            The name of the stereotype
	 * @param isAbstract
	 *            Whether the stereotype is abstract
	 * @return
	 */
	public static Stereotype createStereotype(Profile profile, String name, boolean isAbstract) {
		Stereotype stereotype = profile.createOwnedStereotype(name, isAbstract);
		return stereotype;
	}

	/**
	 * Defines a profile
	 * 
	 * @param profile
	 *            the profile to be defined
	 */
	public static void defineProfile(Profile profile) {
		profile.define();
	}

	/**
	 * Applies a profile to a package
	 * 
	 * @param package_
	 *            The package where the profile will be applied
	 * @param profile
	 *            The profile that will be applied to the package
	 */
	protected static void applyProfile(org.eclipse.uml2.uml.Package package_, Profile profile) {
		package_.applyProfile(profile);
	}

	/**
	 * Creates a property with the specified name, type, lower bound, upper
	 * bound and default value as an owned attribute of a class
	 * 
	 * @param class_
	 *            The class that will have the attribute
	 * @param name
	 *            The name of the attribute
	 * @param type
	 *            The type of the attribute
	 * @param lowerBound
	 *            The lower bound for the new attribute
	 * @param upperBound
	 *            The upper bound for the new attribute
	 * @param defaultValue
	 *            The default value of the new attribute
	 * @return the new attribute
	 */
	public static Property createAttribute(org.eclipse.uml2.uml.Class class_, String name, Type type, int lowerBound,
			int upperBound, Object defaultValue) {
		Property attribute = class_.createOwnedAttribute(name, type, lowerBound, upperBound);
		if (defaultValue instanceof Boolean) {
			LiteralBoolean literal = (LiteralBoolean) attribute.createDefaultValue(null, null,
					UMLPackage.Literals.LITERAL_BOOLEAN);
			literal.setValue(((Boolean) defaultValue).booleanValue());
		} else if (defaultValue instanceof String) {
			if (type instanceof Enumeration) {
				InstanceValue value = (InstanceValue) attribute.createDefaultValue(null, null,
						UMLPackage.Literals.INSTANCE_VALUE);
				value.setInstance(((Enumeration) type).getOwnedLiteral((String) defaultValue));
			} else {
				LiteralString literal = (LiteralString) attribute.createDefaultValue(null, null,
						UMLPackage.Literals.LITERAL_STRING);
				literal.setValue((String) defaultValue);
			}
		}
		return attribute;
	}

	/**
	 * Obtains a java.io.File in a workspace based on a URI
	 * @param uri The URI
	 * @return the file
	 */
	public static File getFileFromURI(URI uri) {
		if (uri != null) {
			IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			IPath path = new Path(uri.toPlatformString(true));
			IFile file = myWorkspaceRoot.getFile(path);
			if (file != null && file.getLocation() != null) {
				File f = file.getLocation().toFile();
				return f;
			}
		}
		return null;
	}
	
	/**
	 * Creates an interface to call the createAssociation method of Type.class.
	 * In other words, it creates a(n) (binary) association between this type
	 * and the specified other type, with the specified navigabilities,
	 * aggregations, names, lower bounds, and upper bounds, and owned by this
	 * type's nearest package.
	 * 
	 * @param end1IsNavigable The navigability for the first end of the new
	 * association.
	 * 
	 * @param end1Aggregation The aggregation for the first end of the new
	 * association.
	 * 
	 * @param end1Name The name for the first end of the new association.
	 * 
	 * @param end1Lower The lower bound for the first end of the new
	 * association.
	 * 
	 * @param end1Upper The upper bound for the first end of the new
	 * association.
	 * 
	 * @param end1Type The type for the first end of the new association.
	 * 
	 * @param end2IsNavigable The navigability for the second end of the new
	 * association.
	 * 
	 * @param end2Aggregation The aggregation for the second end of the new
	 * association.
	 * 
	 * @param end2Name The name for the second end of the new association.
	 * 
	 * @param end2Lower The lower bound for the second end of the new
	 * association.
	 * 
	 * @param end2Upper The upper bound for the second end of the new
	 * association.
	 */
	public static Association createAssociation(Type type1,
			boolean end1IsNavigable, AggregationKind end1Aggregation,
			String end1Name, int end1LowerBound, int end1UpperBound,
			Type type2, boolean end2IsNavigable,
			AggregationKind end2Aggregation, String end2Name,
			int end2LowerBound, int end2UpperBound) {
		Association association = type1.createAssociation(end1IsNavigable,
			end1Aggregation, end1Name, end1LowerBound, end1UpperBound, type2,
			end2IsNavigable, end2Aggregation, end2Name, end2LowerBound,
			end2UpperBound);
		return association;
	}
	


	/**
	 * Obtains the source end of an association
	 * @param association
	 * @return The member end
	 */
	public static Property getSourceEnd(Association association) {
		return getMemberEnd(association, true);
	}

	/**
	 * Obtains the target end of an association
	 * @param association
	 * @return The member end
	 */
	public static Property getTargetEnd(Association association) {
		return getMemberEnd(association, false);
	}
	
	/**
	 * Obtains the source or target ends of an association
	 * @param association
	 * @param sourceNotTarget
	 * @return
	 */
	public static Property getMemberEnd(Association association, boolean sourceNotTarget) {
		if (sourceNotTarget && association.getMemberEnds().size() > 0) {
			return (Property) association.getMemberEnds().get(0);
		}
		if (!sourceNotTarget && association.getMemberEnds().size() > 1) {
			return (Property) association.getMemberEnds().get(1);
		}
		return null;
	}
	
}
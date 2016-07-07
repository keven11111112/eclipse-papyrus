/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.requirements.languagecreationtools.domainModel2Profile.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.requirements.languagecreationtools.domainModel2Profile.utils.Utils;
import org.eclipse.papyrus.requirements.preferences.Activator;
import org.eclipse.papyrus.requirements.preferences.PreferenceConstants;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

/**
 * Generates an UML profile based on a UML domain model
 *
 */
public class ProfileGenerator {
	protected static ResourceSet resourceSet;
	// Output profile created based on the domain model
	protected Profile profile;
	// Input package representing the domain model
	protected Package sourcePackage;
	// File of the sourcePackage
	protected File sourceModelFile;
	// Generation options
	private static String NSURI_PREFIX = "https://www.eclipse.org/papyrus/";
	private static boolean GENERATE_ABSTRACTIONS_MODEL = false;
	private static boolean FROM_ASSOCIATIONS_TO_STEREOTYPES = false;
	private static boolean FROM_ASSOCIATIONS_TO_ASSOCIATIONS = false;
	private static String METACLASS_EXTENDED_BY_NODES = "none"; //UMLPackage.Literals.CLASS.getName();
	private static String METACLASS_EXTENDED_BY_EDGES = "none";//= UMLPackage.Literals.ASSOCIATION.getName();
	// Debug=true will automatically refresh the project to show the output
	// files.
	private static boolean DEBUG = true;
	protected Stereotype baseNodeStereotype;
	protected Stereotype baseEdgeStereotype;
	protected Map<Element, Element> mapClassNodes = new HashMap<Element, Element>();
	protected Map<Element, Element> mapAssociationsEdges = new HashMap<Element, Element>();
	protected Map<Element, Element> mapProfileAssociations2MMAssociations = new HashMap<Element, Element>();
	protected Map<Element, Element> mapPrimitiveTypesNodes = new HashMap<Element, Element>();
	protected Map<Element, Element> mapEnumerationsNodes = new HashMap<Element, Element>();
	protected Map<Element, Element> mapPackagesNodes = new HashMap<Element, Element>();
	protected List<PrimitiveType> listStandardPrimitiveTypes = new ArrayList<PrimitiveType>();
	protected String outputDirectoryPath;
	protected List<Generalization> listInternalGeneralizations = new ArrayList<Generalization>();
	protected List<Association> listAssociations = new ArrayList<Association>();
	protected Model abstractionsModel;
	

	/**
	 * Constructor to be called by Eclipse, takes into account generation
	 * preferences in the Papyrus for Requirements preference page.
	 * 
	 * @param selectedPackage The UML domain model
	 */
	public ProfileGenerator(Package selectedPackage) {
		DEBUG = false;
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		NSURI_PREFIX = store.getString(PreferenceConstants.NSURI_PREFIX);
		GENERATE_ABSTRACTIONS_MODEL = store.getBoolean(PreferenceConstants.GENERATE_ABSTRACTIONS_MODEL);
		FROM_ASSOCIATIONS_TO_STEREOTYPES = store.getBoolean(PreferenceConstants.FROM_ASSOCIATIONS_TO_STEREOTYPES);
		FROM_ASSOCIATIONS_TO_ASSOCIATIONS =store.getBoolean(PreferenceConstants.FROM_ASSOCIATIONS_TO_ASSOCIATIONS);
		// METACLASS_EXTENDED_BY_NODES =
		// store.getString(PreferenceConstants.METACLASS_EXTENDED_BY_NODES);
		// //by default "none"
		// METACLASS_EXTENDED_BY_EDGES =
		// store.getString(PreferenceConstants.METACLASS_EXTENDED_BY_EDGES);
		// //by default "none"
		sourcePackage = selectedPackage;
		URI uri = sourcePackage.eResource().getURI();
		sourceModelFile = Utils.getFileFromURI(uri);
		outputDirectoryPath = sourceModelFile.getParent();
		setResourceSet();
	}

	/**
	 * Constructor to be used in an standalone Java application. It does not takes
	 * into account preferences in the Papyrus for Requirements preference page.
	 * 
	 * @param _inputModelPath The path of the input model
	 * @param _outputDirectoryPath The path to save the profile and if the abstractions model
	 * @param _prefix the NSURI prefix used in the profile
	 */
	public ProfileGenerator(String _inputModelPath, String _outputDirectoryPath, String _prefix) {
		DEBUG = true;
		NSURI_PREFIX = _prefix;
		ResourceSet resourceSetSourceModel = new ResourceSetImpl();
		UMLResourcesUtil.init(resourceSetSourceModel);
		URI _inputModelURI = URI.createFileURI(new File(_inputModelPath).getAbsolutePath());
		Resource r = resourceSetSourceModel.getResource(_inputModelURI, true);
		sourcePackage = (Package) EcoreUtil.getObjectByType(r.getContents(), UMLPackage.Literals.PACKAGE);
		sourceModelFile = new File(_inputModelPath).getAbsoluteFile();
		outputDirectoryPath = new File(_outputDirectoryPath).getAbsolutePath();
		setResourceSet();
	}

	protected void setResourceSet() {
		resourceSet = new ResourceSetImpl();
		UMLResourcesUtil.init(resourceSet);
	}

	public void generate() {
		String nameOfAbstractionsModel = sourcePackage.getName() + "_refinement";
		String nameOfProfile = sourcePackage.getName();
		setProfile(Utils.createProfile(nameOfProfile, NSURI_PREFIX + sourcePackage.getName()));

		if (!METACLASS_EXTENDED_BY_NODES.contentEquals("none")) {
			METACLASS_EXTENDED_BY_NODES= UMLPackage.Literals.CLASS.getName();
			baseNodeStereotype = Utils.createStereotype(profile, "baseNodeStereotype", true);
		}
		if (!METACLASS_EXTENDED_BY_EDGES.contentEquals("none")) {
			METACLASS_EXTENDED_BY_EDGES= UMLPackage.Literals.ASSOCIATION.getName();
			baseEdgeStereotype = Utils.createStereotype(profile, "baseEdgeStereotype", true);
		}

		visitPackagedElements(sourcePackage);

		String[] requiredPrimitiveTypes = { "Boolean", "Real", "String", "Integer", "UnlimitedNatural" };
		createStandardPrimitiveTypes(requiredPrimitiveTypes);

		createProfiles(mapClassNodes);
		createProfiles(mapPrimitiveTypesNodes);
		createProfiles(mapEnumerationsNodes);
		if (FROM_ASSOCIATIONS_TO_STEREOTYPES) {
			createProfiles(mapAssociationsEdges);
		}
		if (FROM_ASSOCIATIONS_TO_ASSOCIATIONS) {
			createAssociations();
		}
		createEnumerationLiterals();
		createTagDefinitions();
		createInternalGeneralizations();

		if (!METACLASS_EXTENDED_BY_NODES.contentEquals("none")
				&& referenceMetaclass(profile, METACLASS_EXTENDED_BY_NODES) != null) {
			createGeneralizations(mapClassNodes.keySet(), baseNodeStereotype);
			Utils.createExtension(referenceMetaclass(profile, METACLASS_EXTENDED_BY_NODES), baseNodeStereotype, false);
		}
		if (!METACLASS_EXTENDED_BY_EDGES.contentEquals("none")
				&& referenceMetaclass(profile, METACLASS_EXTENDED_BY_NODES) != null) {
			createGeneralizations(mapAssociationsEdges.keySet(), baseEdgeStereotype);
			Utils.createExtension(referenceMetaclass(profile, METACLASS_EXTENDED_BY_EDGES), baseEdgeStereotype, false);
		}

		Utils.defineProfile(profile);

		for (Element element : mapPackagesNodes.keySet()) {
			if (element instanceof Profile) {
				Utils.defineProfile((Profile) element);
			}
		}

		save(profile, outputDirectoryPath, nameOfProfile, UMLResource.PROFILE_FILE_EXTENSION);

		if (GENERATE_ABSTRACTIONS_MODEL) {
			abstractionsModel = Utils.createModel(nameOfAbstractionsModel);
			createAbstractionsModel(mapClassNodes);
			createAbstractionsModel(mapProfileAssociations2MMAssociations);
			abstractionsModel.setURI(NSURI_PREFIX + nameOfAbstractionsModel);
			save(abstractionsModel, outputDirectoryPath, nameOfAbstractionsModel, UMLResource.FILE_EXTENSION);
		}
		// Debug=true will automatically refresh the project to show the
		// generated ...profile.uml file.
		if (!DEBUG) {
			Utils.refreshProject(sourceModelFile);
		}
	}

	/**
	 * Creates associations between stereotypes in a profile, based on the
	 * associations in a domain model
	 */
	protected void createAssociations() {
		Stereotype targetEndInProfile = null;
		Stereotype sourceEndInProfile = null;
		for (Association assocInMM : listAssociations) {
			Property targetEndInMM = Utils.getTargetEnd(assocInMM);
			// Property sourceEndInMM = targetEndInMM.getOtherEnd();
			Property sourceEndInMM = Utils.getSourceEnd(assocInMM);
			targetEndInProfile = getStereotypeByName(targetEndInMM.getType().getName());
			sourceEndInProfile = getStereotypeByName(sourceEndInMM.getType().getName());
			if (targetEndInProfile != null) {
				Association assocInProfile = Utils.createAssociation(sourceEndInProfile, true,
						AggregationKind.NONE_LITERAL, targetEndInMM.getName(), targetEndInMM.getLower(),
						targetEndInMM.getUpper(), targetEndInProfile, true, AggregationKind.NONE_LITERAL,
						sourceEndInMM.getName(), sourceEndInMM.getLower(), sourceEndInMM.getUpper());
				assocInProfile.setName(assocInMM.getName());
				mapProfileAssociations2MMAssociations.put(assocInProfile, assocInMM);
			}
		}
	}

	/**
	 * @param stereotypeName
	 *            The not qualified name of a stereotype
	 * @return stereotype The stereotype with the stereotypeName in the
	 *         Stereotypes - Class map (ex. key: Stereotype named Focus, value:
	 *         Class named Focus).
	 */
	protected Stereotype getStereotypeByName(String stereotypeName) {
		Stereotype stereotype=null;
		for (Map.Entry<Element, Element> entry : mapClassNodes.entrySet()) {
			if (entry.getKey() instanceof Stereotype && entry.getValue() instanceof Class) {
				stereotype = (Stereotype) entry.getKey();
				if (stereotype.getName().contentEquals(stereotypeName)){
					return stereotype;
				}
			}
		}
		return null;
	}

	/**
	 * Generates the mapping model between source elements and produced
	 * elements. Each abstraction relationship can have many sources and many
	 * targets which is ideal to allow N 2 M mappings.
	 * 
	 * @param map
	 *            containing the element (value) in the domain model that
	 *            originated the element (key) in the profile
	 */
	protected void createAbstractionsModel(Map<Element, Element> map) {
		for (Map.Entry<Element, Element> entry : map.entrySet()) {
			NamedElement key = (NamedElement) entry.getKey();
			NamedElement value = (NamedElement) entry.getValue();
			Abstraction _abstraction = UMLFactory.eINSTANCE.createAbstraction();
			_abstraction.getSuppliers().add(key);
			_abstraction.getClients().add(value);
			_abstraction.setName(key.getName() + "-" + value.getName());
			abstractionsModel.getPackagedElements().add(_abstraction);
		}
	}

	protected void visitPackagedElements(Element element) {
		if (element instanceof org.eclipse.uml2.uml.Package) {
			org.eclipse.uml2.uml.Package packageInMetamodel = (org.eclipse.uml2.uml.Package) element;
			for (Element e : packageInMetamodel.getPackagedElements()) {
				visitPackagedElements(e);
			}
		} else if (element instanceof org.eclipse.uml2.uml.Class) {
			mapClassNodes.put((Element) Utils.createStereotype(profile, ((NamedElement) element).getName(),
					((Class) element).isAbstract()), element);
			if (((Classifier) element).getGeneralizations() != null) {
				for (Generalization generalization : ((Classifier) element).getGeneralizations()) {
					listInternalGeneralizations.add(generalization);
				}
			}
		} else if (element instanceof PrimitiveType) {
			mapPrimitiveTypesNodes.put((Element) Utils.createPrimitiveType(profile, ((NamedElement) element).getName()),
					element);
		} else if (element instanceof Enumeration) {
			mapEnumerationsNodes.put((Element) Utils.createEnumeration(profile, ((NamedElement) element).getName()),
					element);
		} else if (element instanceof Association) {
			if (FROM_ASSOCIATIONS_TO_STEREOTYPES) {
				mapAssociationsEdges.put(
						(Element) Utils.createStereotype(profile, ((NamedElement) element).getName(), false), element);
			}
			listAssociations.add((Association)element);
		}
	}

	protected void createInternalGeneralizations() {
		for (Generalization generalizationInMM : listInternalGeneralizations) {
			Classifier specificInMM = generalizationInMM.getSpecific();
			Classifier generalInMM = generalizationInMM.getGeneral();
			Stereotype specificInProfile = null;
			Stereotype generalInProfile = null;
			Set<Element> classNodesStereotypesInProfile = mapClassNodes.keySet();
			for (Element e : classNodesStereotypesInProfile) {
				Stereotype classNodeStereotypeInProfile = (Stereotype) e;
				if (classNodeStereotypeInProfile.getName().contentEquals(specificInMM.getName())) {
					specificInProfile = classNodeStereotypeInProfile;
				} else if (classNodeStereotypeInProfile.getName().contentEquals(generalInMM.getName())) {
					generalInProfile = classNodeStereotypeInProfile;
				}
			}
			if (specificInProfile != null && generalInProfile != null) {
				Utils.createGeneralization(specificInProfile, generalInProfile);
			}
		}
	}

	protected static org.eclipse.uml2.uml.Package load(URI uri) {
		org.eclipse.uml2.uml.Package package_ = null;
		try {
			// Load the requested resource
			Resource resource = resourceSet.getResource(uri, true);
			// Get the first (should be only) package from it
			package_ = (org.eclipse.uml2.uml.Package) EcoreUtil.getObjectByType(resource.getContents(),
					UMLPackage.Literals.PACKAGE);
		} catch (WrappedException we) {
			System.err.println();
			System.exit(1);
		}
		return package_;
	}

	public static PrimitiveType importPrimitiveType(org.eclipse.uml2.uml.Package package_, String name) {
		org.eclipse.uml2.uml.Package umlLibrary = load(URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI));
		PrimitiveType primitiveType = (PrimitiveType) umlLibrary.getOwnedType(name);
		package_.createElementImport(primitiveType);
		return primitiveType;
	}

	protected static org.eclipse.uml2.uml.Class referenceMetaclass(Profile profile, String metaclassName) {
		Model umlMetamodel = (Model) load(URI.createURI(UMLResource.UML_METAMODEL_URI));
		// my hack
		Class metaclass = null;
		if (umlMetamodel.getOwnedType(metaclassName) instanceof Class) {
			metaclass = (Class) umlMetamodel.getOwnedType(metaclassName);
			if (metaclass != null) {
				profile.createMetaclassReference(metaclass);
			}
		}
		return metaclass;
	}

	/**
	 * @param stereotypeInProfile
	 * @param propertyInClass
	 */
	protected void addEnumerationProperty(Stereotype stereotypeInProfile, Property propertyInClass) {
		Set<Element> enumerationsInProfile = mapEnumerationsNodes.keySet();
		for (Element e : enumerationsInProfile) {
			Enumeration enumerationInProfile = (Enumeration) e;
			if (enumerationInProfile.getName().contentEquals(propertyInClass.getType().getName())) {
				Utils.createAttribute((Class) stereotypeInProfile, propertyInClass.getName(), enumerationInProfile, 0,
						1, null);
			}
		}
	}

	/**
	 * @param stereotypeInProfile
	 * @param propertyInClass
	 */
	protected void addPrimitiveTypeProperty(Stereotype stereotypeInProfile, Property propertyInClass) {
		boolean foundStandardPrimitiveType = false;
		for (PrimitiveType standardPrimitiveType : listStandardPrimitiveTypes) {
			if (standardPrimitiveType.getName().contentEquals(propertyInClass.getType().getName())) {
				foundStandardPrimitiveType = true;

				Utils.createAttribute((Class) stereotypeInProfile, propertyInClass.getName(), standardPrimitiveType,
						propertyInClass.getLower(), propertyInClass.getUpper(), null);
				break;
			}
		}
		if (!foundStandardPrimitiveType) {
			Set<Element> primitiveTypesInProfile = mapPrimitiveTypesNodes.keySet();
			for (Element e : primitiveTypesInProfile) {
				PrimitiveType primitiveTypeInProfile = (PrimitiveType) e;
				if (primitiveTypeInProfile.getName().contentEquals(propertyInClass.getType().getName())) {
					Utils.createAttribute((Class) stereotypeInProfile, propertyInClass.getName(),
							primitiveTypeInProfile, propertyInClass.getLower(), propertyInClass.getUpper(), null);
				}
			}
		}
	}

	protected void createEnumerationLiterals() {
		for (Map.Entry<Element, Element> entry : mapEnumerationsNodes.entrySet()) {
			Element key = entry.getKey();
			Element value = entry.getValue();
			if (key instanceof Enumeration && value instanceof Enumeration) {
				Enumeration enumInProfile = (Enumeration) key;
				Enumeration enumInMetamodel = (Enumeration) value;
				for (EnumerationLiteral literalInMM : enumInMetamodel.getOwnedLiterals()) {
					Utils.createEnumerationLiteral(enumInProfile, literalInMM.getName().replaceAll("\\s", ""));
				}
			}
		}
	}

	protected void createGeneralizations(Set<Element> specificStereotypes, Stereotype generalStereotype) {
		for (Element element : specificStereotypes) {
			if (element instanceof Stereotype) {
				Stereotype specificStereotype = (Stereotype) element;
				if (specificStereotype.getGeneralizations().size() == 0) {
					Utils.createGeneralization(specificStereotype, generalStereotype);
				}
			}
		}
	}

	/**
	 * Creates a profile and sub-profiles based on the packages structure of the
	 * domain model. Each Package becomes a new profile.
	 * 
	 * @param map
	 *            in the map, the key is an Stereotype, PrimitiveType, Profile,
	 *            etc. and the value is the Element that originated the creation
	 *            of the key. For example, a Class X (the key) originated an
	 *            Stereotype X (the value)
	 * 
	 */
	protected void createProfiles(Map<Element, Element> map) {
		boolean foundPackage;
		for (Map.Entry<Element, Element> entry : map.entrySet()) {
			Element key = entry.getKey();
			Element value = entry.getValue();
			Package package_ = value.getNearestPackage();
			foundPackage = false;
			for (Package nestedPackage : profile.getNestedPackages()) {
				if (nestedPackage.getName().contentEquals(package_.getName())) {
					foundPackage = true;
					nestedPackage.getPackagedElements().add((PackageableElement) key);
					break;
				}
			}
			if (!foundPackage) {
				Profile newSubProfile = Utils.createProfile(package_.getName(), NSURI_PREFIX + package_.getName());
				mapPackagesNodes.put(newSubProfile, package_);
				profile.getNestedPackages().add(newSubProfile);
				newSubProfile.getPackagedElements().add((PackageableElement) key);
			}
		}
	}

	protected void createStandardPrimitiveTypes(String[] requiredPrimitiveTypes) {
		for (String primitiveTypeName : requiredPrimitiveTypes) {
			listStandardPrimitiveTypes.add(importPrimitiveType(profile, primitiveTypeName));
		}
	}

	protected void createTagDefinitions() {
		for (Map.Entry<Element, Element> entry : mapClassNodes.entrySet()) {
			Element key = entry.getKey();
			Element value = entry.getValue();
			if (key instanceof Stereotype && value instanceof Class) {
				Stereotype stereotypeInProfile = (Stereotype) key;
				Class classInMetamodel = (Class) value;
				for (Property propertyInClass : classInMetamodel.getOwnedAttributes()) {
					if (propertyInClass.getType() instanceof PrimitiveType) {
						addPrimitiveTypeProperty(stereotypeInProfile, propertyInClass);
					} else if (propertyInClass.getType() instanceof Enumeration) {
						addEnumerationProperty(stereotypeInProfile, propertyInClass);
					}
				}
			}
		}
	}

	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * Save our refinement model to a file in the user-specified output
	 * directory
	 * 
	 */
	protected void save(Package model, String outputDirectoryPath, String fileName, String fileExtension) {
		URI outputURI = URI.createFileURI(outputDirectoryPath).appendSegment(fileName)
				.appendFileExtension(fileExtension);
		save(model, outputURI);
	}

	protected static void save(org.eclipse.uml2.uml.Package package_, URI uri) {
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(package_);
		try {
			resource.save(null);
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}

	/**
	 * @param profile
	 *            the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}

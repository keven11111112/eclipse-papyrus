/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.req.reqif.transformation;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.req.reqif.I_SysMLStereotype;
import org.eclipse.papyrus.req.reqif.assistant.CreateOrSelectProfilDialog;
import org.eclipse.papyrus.req.reqif.assistant.SelectProfilDialog;
import org.eclipse.papyrus.req.reqif.integration.assistant.ChooseAttributeEnumerationDialog;
import org.eclipse.papyrus.req.reqif.user.User;
import org.eclipse.papyrus.req.reqif.user.UserRegistry;
import org.eclipse.papyrus.req.reqif.util.BasicRequirementMerger;
import org.eclipse.papyrus.req.reqif.util.IRequirementMerger;
import org.eclipse.papyrus.req.reqif.util.ReqIFUtil;
import org.eclipse.papyrus.uml.extensionpoints.profile.IRegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.rmf.reqif10.AttributeDefinition;
import org.eclipse.rmf.reqif10.AttributeDefinitionBoolean;
import org.eclipse.rmf.reqif10.AttributeDefinitionEnumeration;
import org.eclipse.rmf.reqif10.AttributeDefinitionInteger;
import org.eclipse.rmf.reqif10.AttributeDefinitionReal;
import org.eclipse.rmf.reqif10.AttributeDefinitionString;
import org.eclipse.rmf.reqif10.AttributeDefinitionXHTML;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.AttributeValueBoolean;
import org.eclipse.rmf.reqif10.AttributeValueEnumeration;
import org.eclipse.rmf.reqif10.AttributeValueInteger;
import org.eclipse.rmf.reqif10.AttributeValueReal;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.AttributeValueXHTML;
import org.eclipse.rmf.reqif10.DatatypeDefinitionEnumeration;
import org.eclipse.rmf.reqif10.EnumValue;
import org.eclipse.rmf.reqif10.Identifiable;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.rmf.reqif10.SpecElementWithAttributes;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecObject;
import org.eclipse.rmf.reqif10.SpecObjectType;
import org.eclipse.rmf.reqif10.SpecRelation;
import org.eclipse.rmf.reqif10.SpecRelationType;
import org.eclipse.rmf.reqif10.SpecType;
import org.eclipse.rmf.reqif10.Specification;
import org.eclipse.rmf.reqif10.SpecificationType;
import org.eclipse.rmf.reqif10.XhtmlContent;
import org.eclipse.rmf.reqif10.common.util.ReqIF10Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * this class is used to realize the import of ReqIF file to UML
 *
 */
public abstract class ReqIFImporter extends ReqIFBaseTransformation {

	protected Shell shellLogger;

	protected Profile impactedProfile;

	protected IRequirementMerger merger = null;

	protected String attributeNameForPatternEnumeration = null;

	public void setAttributeNameForPatternEnumeration(String attributeNameForPatternEnumeration) {
		this.attributeNameForPatternEnumeration = attributeNameForPatternEnumeration;
	}

	public Profile getImpactedProfile() {
		return impactedProfile;
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param domain
	 *        the domain in order to execute command
	 * @param reqIFModel
	 *        the reqIF model that is imported
	 * @param UMLModel
	 *        the UML model that will contain the importation
	 */
	public ReqIFImporter(TransactionalEditingDomain domain, ReqIF reqIFModel, org.eclipse.uml2.uml.Package UMLModel) {
		super(domain, UMLModel);
		this.reqIFModel = reqIFModel;
		//initiate Hashmap
		//mapping for the list of  specObjectTypes
		objectTypeMap = new HashMap<String, SpecType>();
		objectTypeStereotypesMap = new HashMap<String, Stereotype>();
		//mapping stereotype for specification
		specificationTypeMap = new HashMap<String, SpecificationType>();
		specificationTypeSterotypeMap = new HashMap<String, Stereotype>();
		//mapping SpecRelationType
		specRelationTypeMap = new HashMap<String, SpecType>();
		specRelationTypeSterotypeMap = new HashMap<String, Stereotype>();
		profileEnumeration = new HashMap<String, Enumeration>();
	}

	/**
	 * this method could be overloaded, it is used to make a pre-processing on ReqIFModel
	 * 
	 * @param reqIFModel
	 */
	public void preProcess(ReqIF reqIFModel) {
		//1. first make sure that all reqIFelement have a name
		normalizeNames(reqIFModel);
		//2.set ReqIF_ForeignID as ID
		normalizeID(reqIFModel);
		//3. patterns, if 1 type, maybe there is an enumeration?
		if(UserRegistry.instance.canUseEnumerationPattern()) {
			transformPatternEnumeration(reqIFModel, attributeNameForPatternEnumeration);
		}
	}

	/**
	 * set a name of all type of the ReqIF model if there is no name
	 * 
	 * @param reqIFModel
	 */
	protected void normalizeNames(ReqIF reqIFModel) {
		Iterator<EObject> reqIFElementIterator = reqIFModel.eAllContents();
		int index = 0;
		while(reqIFElementIterator.hasNext()) {
			EObject eObject = reqIFElementIterator.next();
			if(eObject instanceof Identifiable) {
				Identifiable identifiable = (Identifiable)eObject;
				if(identifiable.getLongName() == null || identifiable.getLongName().trim().equals("")) {
					identifiable.setLongName(eObject.getClass().getSimpleName() + "_" + index);
					index++;
				}
				identifiable.setLongName(ReqIFUtil.getNormalName(identifiable.getLongName()));
			}
		}
	}

	/**
	 * set a name of all type of the ReqIF model if there is no name
	 * 
	 * @param reqIFModel
	 */
	protected void normalizeID(ReqIF reqIFModel) {
		Iterator<EObject> reqIFElementIterator = reqIFModel.eAllContents();
		int index = 0;
		while(reqIFElementIterator.hasNext()) {
			EObject eObject = reqIFElementIterator.next();
			if(eObject instanceof SpecObject) {
				SpecObject specObject = (SpecObject)eObject;
				EList<AttributeValue> values = specObject.getValues();
				for(Iterator iterator = values.iterator(); iterator.hasNext();) {
					AttributeValue attributeValue = (AttributeValue)iterator.next();
					if(attributeValue instanceof AttributeValueInteger) {
						if(((AttributeValueInteger)attributeValue).getDefinition().getLongName().equals("ReqIF_ForeignID")) {
							specObject.setIdentifier("" + ((AttributeValueInteger)attributeValue).getTheValue());
						}
					}
				}
			}
		}
	}

	/**
	 * this method transform type with enumeration to set of types
	 * 
	 * @param reqIFModel
	 * @param attributeEnumeration
	 *        the name of attribute definition if the type in order to transform. (in this case no UI)
	 */
	protected void transformPatternEnumeration(ReqIF reqIFModel, String attributeEnumeration) {
		ArrayList<SpecObjectType> specObjectTypes = new ArrayList<SpecObjectType>();
		if(reqIFModel.getCoreContent().getSpecTypes() != null && reqIFModel.getCoreContent().getSpecTypes().size() > 0) {
			for(SpecType reqIFType : reqIFModel.getCoreContent().getSpecTypes()) {
				if(reqIFType instanceof SpecObjectType) {
					specObjectTypes.add((SpecObjectType)reqIFType);
				}
			}
		}
		//maybe the topology of element is coded by an enumeration
		if(specObjectTypes.size() == 1) {
			SpecObjectType theType = specObjectTypes.get(0);
			//find enumeration
			ArrayList<AttributeDefinitionEnumeration> attEnumeration = new ArrayList<AttributeDefinitionEnumeration>();
			AttributeDefinitionEnumeration patternEnumerationAtt = null;
			for(AttributeDefinition attDefinition : theType.getSpecAttributes()) {
				if(attDefinition instanceof AttributeDefinitionEnumeration) {
					attEnumeration.add((AttributeDefinitionEnumeration)attDefinition);
					if(attributeEnumeration != null && attDefinition.getLongName().equals(attributeEnumeration)) {
						patternEnumerationAtt = (AttributeDefinitionEnumeration)attDefinition;
					}
				}
			}
			if(patternEnumerationAtt == null) {
				if(attEnumeration.size() > 1) {
					ChooseAttributeEnumerationDialog assistedDialog = new ChooseAttributeEnumerationDialog(new Shell(), attEnumeration);
					assistedDialog.open();
					ArrayList<Object> result = assistedDialog.getSelectedElements();
					patternEnumerationAtt = (AttributeDefinitionEnumeration)result.get(0);
				} else if((attEnumeration.size() == 1)) {
					patternEnumerationAtt = attEnumeration.get(0);
				}
			}
			if(patternEnumerationAtt != null) {
				//transform pseudo type from enumeration
				DatatypeDefinitionEnumeration enumeration = patternEnumerationAtt.getType();
				HashMap<String, SpecObjectType> newTypes = new HashMap<String, SpecObjectType>();
				for(EnumValue enumValue : enumeration.getSpecifiedValues()) {
					SpecObjectType specObjectType = EcoreUtil.copy(theType);
					specObjectType.setLongName(enumValue.getLongName());
					specObjectType.setLastChange((GregorianCalendar)GregorianCalendar.getInstance());
					reqIFModel.getCoreContent().getSpecTypes().add(specObjectType);
					newTypes.put(enumValue.getLongName(), specObjectType);
				}
				for(SpecObject specObject : reqIFModel.getCoreContent().getSpecObjects()) {
					//get Attribute Value
					AttributeValueEnumeration attValue = (AttributeValueEnumeration)getAttributeValue(specObject, patternEnumerationAtt);
					if(attValue != null) {
						if(attValue.getValues().size() > 0) {
							specObject.setType(newTypes.get(attValue.getValues().get(0).getLongName()));
						}
					}
				}
			}
		}
	}

	public static AttributeValue getAttributeValue(SpecElementWithAttributes specElement, AttributeDefinition attributeDefinition) {
		for(AttributeValue value : specElement.getValues()) {
			AttributeDefinition definition = ReqIF10Util.getAttributeDefinition(value);
			if(attributeDefinition.getLongName().equals(definition.getLongName())) {
				return value;
			}
		}
		//maybe it has a default value in the definition.
		if(attributeDefinition instanceof AttributeDefinitionEnumeration) {
			return ((AttributeDefinitionEnumeration)attributeDefinition).getDefaultValue();
		}
		//maybe it has a default value in the definition.
		if(attributeDefinition instanceof AttributeDefinitionBoolean) {
			return ((AttributeDefinitionBoolean)attributeDefinition).getDefaultValue();
		}
		//maybe it has a default value in the definition.
		if(attributeDefinition instanceof AttributeDefinitionInteger) {
			return ((AttributeDefinitionInteger)attributeDefinition).getDefaultValue();
		}
		//maybe it has a default value in the definition.
		if(attributeDefinition instanceof AttributeDefinitionReal) {
			return ((AttributeDefinitionReal)attributeDefinition).getDefaultValue();
		}
		//maybe it has a default value in the definition.
		if(attributeDefinition instanceof AttributeDefinitionString) {
			return ((AttributeDefinitionString)attributeDefinition).getDefaultValue();
		}
		//maybe it has a default value in the definition.
		if(attributeDefinition instanceof AttributeDefinitionXHTML) {
			return ((AttributeDefinitionXHTML)attributeDefinition).getDefaultValue();
		}
		return null;
	}

	protected Text initLogger() {
		shellLogger = new Shell();
		shellLogger.setLayout(new FillLayout());
		shellLogger.setSize(300, 100);
		// Create a multiple-line text field
		Text message = new Text(shellLogger, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		message.setLayoutData(new GridData(GridData.FILL_BOTH));
		shellLogger.open();
		return message;
	}

	/**
	 * 
	 * @return the list that must be deleted during merge
	 */
	public ArrayList<Element> getElementToDelete() {
		if(merger == null) {
			return new ArrayList<Element>();
		}
		return merger.getElementToDelete();
	}

	/**
	 * 
	 * @return the list of added element during merge
	 */
	public ArrayList<Element> getAddedElements() {
		if(merger == null) {
			return new ArrayList<Element>();
		}
		return merger.getAddedElements();
	}

	public HashSet<Element> getModifiedElement() {
		if(merger == null) {
			return new HashSet<Element>();
		}
		return merger.getModifiedElement();
	}

	/**
	 * re-import selected SpecObjectType and their instances into UML Model
	 * 
	 * @param interactive
	 *        open GUI for user if true
	 * @param matchProperty
	 *        is the stereotype's property name used to determine if one
	 *        element in reqif is the same than other element in imported. For
	 *        example, "id" is a good matchProperty when comparing SysML
	 *        Requirements
	 * @param deleteElement
	 *        indicate if element has to be deleted
	 * @return true
	 */
	public boolean reImportReqIFModel(boolean interactive, String matchProperty, boolean deleteElement) {
		Model reImportModel = UMLFactory.eINSTANCE.createModel();
		reImportModel.setName("Re-ImportModel" + GregorianCalendar.getInstance().getTimeInMillis());
		Package firstVersion = targetUMLModel;
		firstVersion.eResource().getContents().add(reImportModel);
		ArrayList<Profile> appliedProfiles = getAllAppliedProfiles(firstVersion);
		for(Profile profile : appliedProfiles) {
			reImportModel.applyProfile(profile);
		}
		targetUMLModel = reImportModel;
		boolean importResult = importReqIFModel(interactive);
		merger = new BasicRequirementMerger(firstVersion, targetUMLModel, matchProperty, deleteElement, domain);
		merger.merge();
		ArrayList<Profile> reImportappliedProfiles = getAllAppliedProfiles(targetUMLModel);
		for(Profile profile : reImportappliedProfiles) {
			if(!(appliedProfiles.contains(profile))) {
				firstVersion.applyProfile(profile);
			}
		}
		firstVersion.eResource().getContents().remove(targetUMLModel);
		if(interactive) {
			Comment comment = UMLFactory.eINSTANCE.createComment();
			String txt = "AddedElements\n";
			for(Element element : merger.getAddedElements()) {
				txt = txt + element.toString() + "\n";
			}
			txt = txt + "RemovedElements\n";
			for(Element element : merger.getElementToDelete()) {
				txt = txt + element.toString() + "\n";
			}
			txt = txt + "ModifiedElements\n";
			for(Element element : merger.getModifiedElement()) {
				txt = txt + element.toString() + "\n";
			}
			comment.setBody(txt);
			firstVersion.getOwnedComments().add(comment);
		}
		return importResult;
	}

	/**
	 * import selected SpecObjectType and their instances into UML Model
	 * 
	 * @param interactive
	 *        open GUI for user if true
	 * @return true
	 */
	public boolean importReqIFModel(boolean interactive) {
		Text message = initLogger();
		User currentUser = UserRegistry.instance.getCurrentUser();
		message.setText("Preprocessing...");
		preProcess(reqIFModel);
		//look for all Stereotype that inherits of Requirements
		//import ReqIFHeader
		importReqIFHeader(reqIFModel, targetUMLModel);
		//getAll  stereotypes that represents types in profiles
		getAllStereotypesRepresentingTypes(getRootModel(targetUMLModel));
		//map between SpecObject and Element
		SpecObject_UMLElementMap = new HashMap<SpecObject, Element>();
		message.setText("Import types...");
		//get all types of ReqIF and SpecificationType
		getAllTypesFromReqIFFiles(reqIFModel);
		objectTypeMap = filterReqifAvailableType(objectTypeMap);
		//ask to the User all specObjectTypes to import
		if(currentUser.canChooseTypeToImportInProfile()) {
			objectTypeMap = selectReqIFType(objectTypeMap.values());
		}
		//analyze the list of existing stereotypes and the list of specObject Types to import 
		ArrayList<SpecType> specObjectTypesToCreate = new ArrayList<SpecType>();
		ArrayList<SpecificationType> specificationTypesToCreate = new ArrayList<SpecificationType>();
		ArrayList<SpecType> specRelationTypesToCreate = new ArrayList<SpecType>();
		ArrayList<DatatypeDefinitionEnumeration> dataTypeDefinitionToCreate = new ArrayList<DatatypeDefinitionEnumeration>();
		lookForTypesWihtouStereotypes(specObjectTypesToCreate, specificationTypesToCreate, specRelationTypesToCreate, dataTypeDefinitionToCreate);
		//test if a profile must be updated or created
		if(specObjectTypesToCreate.size() > 0 || specificationTypesToCreate.size() > 0 || specRelationTypesToCreate.size() > 0 || dataTypeDefinitionToCreate.size() > 0) {
			//stereotype must be created
			if(currentUser.canCreateProfile()) {
				String profileName = currentUser.getDefaultProfileName();
				if(currentUser.canChooseProfile()) {
					CreateOrSelectProfilDialog profilDialog = new CreateOrSelectProfilDialog(new Shell(), getAllLocalProfiles(getRootModel(targetUMLModel)));
					profilDialog.open();
					profileName = profilDialog.getProfileName();
				}
				Profile profile = getProfile(getRootModel(targetUMLModel), profileName);
				importReqIFHeader(reqIFModel, profile);
				importDataTypeDefinition(profile, dataTypeDefinitionToCreate);
				importReqIFSpecificationType(profile, specificationTypesToCreate);
				importReqIFSpecObjectTypes(profile, specObjectTypesToCreate);
				importReqIFspecRelationTypes(profile, specRelationTypesToCreate);
				postProcessProfile(profile);
				this.impactedProfile = profile;
				defineProfile(profile);
				getRootModel(targetUMLModel).applyProfile(profile);
			} else {
				//propose a list of profile from registered profiles
				List<IRegisteredProfile> registeredProfiles = RegisteredProfile.getRegisteredProfiles();
				ArrayList<Profile> profilelist = new ArrayList<Profile>();
				for(Iterator<IRegisteredProfile> iterator = registeredProfiles.iterator(); iterator.hasNext();) {
					IRegisteredProfile iRegisteredProfile = iterator.next();
					ResourceSet resourceSet = targetUMLModel.eResource().getResourceSet();
					Resource resource = resourceSet.getResource(iRegisteredProfile.getUri(), true);
					if(resource.getContents().size() == 1 && resource.getContents().get(0) instanceof Profile) {
						profilelist.add((Profile)resource.getContents().get(0));
					}
				}
				String profileName = currentUser.getDefaultProfileName();
				if(currentUser.canChooseProfile()) {
					SelectProfilDialog profilDialog = new SelectProfilDialog(new Shell(), profilelist);
					profilDialog.open();
					profileName = profilDialog.getProfileName();
				}
				Profile profileToApply = null;
				for(Iterator<Profile> iterator = profilelist.iterator(); iterator.hasNext();) {
					Profile profileTmp = iterator.next();
					if(profileTmp.getName().equals(profileName)) {
						profileToApply = profileTmp;
					}
				}
				getRootModel(targetUMLModel).applyProfile(profileToApply);
				message.setText("Import objects...");
				//getAll  stereotypes that represents types in profiles
				getAllStereotypesRepresentingTypes(getRootModel(targetUMLModel));
				specObjectTypesToCreate = new ArrayList<SpecType>();
				specificationTypesToCreate = new ArrayList<SpecificationType>();
				specRelationTypesToCreate = new ArrayList<SpecType>();
				dataTypeDefinitionToCreate = new ArrayList<DatatypeDefinitionEnumeration>();
				lookForTypesWihtouStereotypes(specObjectTypesToCreate, specificationTypesToCreate, specRelationTypesToCreate, dataTypeDefinitionToCreate);
				if(specObjectTypesToCreate.size() > 0 || specificationTypesToCreate.size() > 0 || specRelationTypesToCreate.size() > 0 || dataTypeDefinitionToCreate.size() > 0) {
					createMessageForTypewithoutStereotypes(specObjectTypesToCreate, specificationTypesToCreate, specRelationTypesToCreate, dataTypeDefinitionToCreate);
					return false;
				}
			}
		}
		//all types has been created so import elspecifications and specObjects
		objectTypeStereotypesMap = getAllPossibleRequirementType(getRootModel(targetUMLModel));
		HashMap<String, Stereotype> filteredreqStereotypes = new HashMap<String, Stereotype>();
		//filter Type to import, because reqstereotype may be too large
		for(SpecType specObjectType : objectTypeMap.values()) {
			if(objectTypeStereotypesMap.containsKey(specObjectType.getLongName())) {
				filteredreqStereotypes.put(specObjectType.getLongName(), objectTypeStereotypesMap.get(specObjectType.getLongName()));
			}
		}
		objectTypeStereotypesMap = filteredreqStereotypes;
		specificationTypeSterotypeMap = getAllPossibleSpecificationType(getRootModel(targetUMLModel));
		specRelationTypeSterotypeMap = getAllPossibleSpecRelationType(getRootModel(targetUMLModel));
		if(currentUser.canImportModel()) {
			importReqIFspecification(reqIFModel, targetUMLModel, objectTypeStereotypesMap);
			importSpecRelation(reqIFModel, targetUMLModel, specRelationTypeSterotypeMap);
			postProcess(targetUMLModel);
		}
		shellLogger.close();
		shellLogger.dispose();
		return true;
	}

	protected void createMessageForTypewithoutStereotypes(ArrayList<SpecType> specObjectTypesToCreate, ArrayList<SpecificationType> specificationTypesToCreate, ArrayList<SpecType> specRelationTypesToCreate, ArrayList<DatatypeDefinitionEnumeration> dataTypeDefinitionToCreate) {
		Comment comment = targetUMLModel.createOwnedComment();
		String messageTodisplay = "";
		for(Iterator<SpecType> iterator = specObjectTypesToCreate.iterator(); iterator.hasNext();) {
			SpecType type = iterator.next();
			messageTodisplay = messageTodisplay + "\n " + type.getLongName();
		}
		for(Iterator<SpecificationType> iterator = specificationTypesToCreate.iterator(); iterator.hasNext();) {
			SpecificationType type = iterator.next();
			messageTodisplay = messageTodisplay + "\n " + type.getLongName();
		}
		for(Iterator<SpecType> iterator = specRelationTypesToCreate.iterator(); iterator.hasNext();) {
			SpecType type = iterator.next();
			messageTodisplay = messageTodisplay + "\n " + type.getLongName();
		}
		for(Iterator<DatatypeDefinitionEnumeration> iterator = dataTypeDefinitionToCreate.iterator(); iterator.hasNext();) {
			DatatypeDefinitionEnumeration type = iterator.next();
			messageTodisplay = messageTodisplay + "\n " + type.getLongName();
		}
		messageTodisplay = "No Stereotype found for:" + messageTodisplay;
		comment.setBody(messageTodisplay);
		displayShell(messageTodisplay);
	}

	protected void displayShell(String message) {
		NotificationBuilder warm = NotificationBuilder.createErrorPopup("The choosen profile does not contain types that have to be imported!");
		warm.run();
	}

	/**
	 * look for in the list of types if it exist a corresponding stereotypes
	 * 
	 * @param specObjectTypesToCreate
	 *        list of specObjectType that has no stereotypes
	 * @param specificationTypesToCreate
	 *        list of specificationType that has no stereotypes
	 * @param specRelationTypesToCreate
	 *        list of specRelationTypes that has no stereotypes
	 * @param dataTypeDefinitionToCreate
	 *        list of dataTypeDefinition that has no stereotypes
	 */
	protected void lookForTypesWihtouStereotypes(ArrayList<SpecType> specObjectTypesToCreate, ArrayList<SpecificationType> specificationTypesToCreate, ArrayList<SpecType> specRelationTypesToCreate, ArrayList<DatatypeDefinitionEnumeration> dataTypeDefinitionToCreate) {
		//find spec Object Types to create
		for(SpecType specObjectType : objectTypeMap.values()) {
			if(!objectTypeStereotypesMap.containsKey(specObjectType.getLongName())) {
				specObjectTypesToCreate.add(specObjectType);
			}
		}
		//find specificationTypess to create
		for(SpecificationType specificationType : specificationTypeMap.values()) {
			if(!specificationTypeSterotypeMap.containsKey(specificationType.getLongName())) {
				specificationTypesToCreate.add(specificationType);
			}
		}
		//find specRelationTypes to create
		for(SpecType specRelationType : specRelationTypeMap.values()) {
			if(!specRelationTypeSterotypeMap.containsKey(specRelationType.getLongName())) {
				specRelationTypesToCreate.add(specRelationType);
			}
		}
		//find dataTypeDefinition Enumeration to create
		for(DatatypeDefinitionEnumeration definitionEnumeration : reqifDatatTypeEnumeration.values()) {
			if(!profileEnumeration.containsKey(definitionEnumeration.getLongName())) {
				dataTypeDefinitionToCreate.add(definitionEnumeration);
			}
		}
	}

	/**
	 * load all types that are represented in the ReqFiles
	 * 
	 * @param reqIFModel
	 *        given ReqIFModel
	 */
	protected void getAllTypesFromReqIFFiles(ReqIF reqIFModel) {
		objectTypeMap = new HashMap<String, SpecType>();
		specificationTypeMap = new HashMap<String, SpecificationType>();
		specRelationTypeMap = new HashMap<String, SpecType>();
		reqifDatatTypeEnumeration = new HashMap<String, DatatypeDefinitionEnumeration>();
		if(reqIFModel.getCoreContent().getSpecTypes() != null && reqIFModel.getCoreContent().getSpecTypes().size() > 0) {
			for(SpecType reqIFType : reqIFModel.getCoreContent().getSpecTypes()) {
				if(reqIFType instanceof SpecObjectType) {
					objectTypeMap.put(reqIFType.getLongName(), reqIFType);
				}
				if(reqIFType instanceof SpecificationType) {
					specificationTypeMap.put(reqIFType.getLongName(), (SpecificationType)reqIFType);
				}
				if(reqIFType instanceof SpecRelationType) {
					specRelationTypeMap.put(reqIFType.getLongName(), reqIFType);
				}
			}
		}
		getAllDataTypeDefinitionEnumeration();
	}

	/**
	 * get all stereotypes form applied profiles that represent type inside ReqIF file
	 * 
	 * @param UMLModel
	 *        the current UML model
	 */
	protected void getAllStereotypesRepresentingTypes(Package UMLModel) {
		//specObject Types
		objectTypeStereotypesMap = new HashMap<String, Stereotype>();
		objectTypeStereotypesMap = getAllPossibleRequirementType(UMLModel);
		//specificationType
		specificationTypeSterotypeMap = new HashMap<String, Stereotype>();
		specificationTypeSterotypeMap = getAllPossibleSpecificationType(UMLModel);
		//SpecRelation
		specRelationTypeSterotypeMap = new HashMap<String, Stereotype>();
		specRelationTypeSterotypeMap = getAllPossibleSpecRelationType(UMLModel);
		//get All DataTypeEnumeration
		profileEnumeration = new HashMap<String, Enumeration>();
		profileEnumeration = getAllPossibleEnumeration(UMLModel);
	}

	/**
	 * this method is used to reduce the set of all ReqIF types that you want to import bt UI or not
	 * 
	 * @param reqiFTypeMap
	 *        the given list of of REQIF type availbale
	 * @return the new hashmap of reqif available. <string, specObjectype> the string is th elong name of the SpecObjectType
	 */
	public HashMap<String, SpecType> filterReqifAvailableType(HashMap<String, SpecType> reqiFTypeMap) {
		return reqiFTypeMap;
	}

	/**
	 * this action is used to add last action or transformation on the UML model after importing all things.
	 * 
	 * @param UMLModel
	 *        the obtained UML model after importing reqIF Model
	 */
	public void postProcess(Package UMLModel) {
	}

	/**
	 * this agoal of this method is do add action before serialize, define and apply profile.
	 * Pay attention: Make sure that the profile could be define at the end of this action
	 * 
	 * @param profile
	 *        the current profile
	 * 
	 */
	public void postProcessProfile(Profile profile) {
	}

	/**
	 * define the given profile in order to apply it
	 * 
	 * @param profile
	 *        the given profile
	 */
	protected abstract void defineProfile(Profile profile);

	/**
	 * This method is used to get the list of wanted ReqIFType to import
	 * 
	 * @param values
	 *        list of Spec Type
	 * @return subset of Spec types
	 */
	protected abstract HashMap<String, SpecType> selectReqIFType(Collection<SpecType> values);

	/**
	 * from a list of DatatypedefinitionEnumeration create Enumeration in a given profile
	 * 
	 * @param profile
	 *        the profile where Enumeration will be created
	 * @param dataTypeDefinitionToCreate
	 *        list of enumeration definition
	 */
	protected void importDataTypeDefinition(Profile profile, ArrayList<DatatypeDefinitionEnumeration> dataTypeDefinitionToCreate) {
		for(DatatypeDefinitionEnumeration definitionEnumeration : dataTypeDefinitionToCreate) {
			if(definitionEnumeration.getLongName() != null && (!(definitionEnumeration.getLongName().trim().equals("")))) {
				Enumeration enumeration = profile.createOwnedEnumeration(ReqIFUtil.getNormalName(definitionEnumeration.getLongName()));
				//import enumerationLiteral
				profileEnumeration.put(ReqIFUtil.getNormalName(definitionEnumeration.getLongName()), enumeration);
				for(EnumValue enumValue : definitionEnumeration.getSpecifiedValues()) {
					if(enumValue.getLongName() != null) {
						EnumerationLiteral enumerationLiteral = enumeration.createOwnedLiteral(ReqIFUtil.getNormalName(enumValue.getLongName()));
						if(enumValue.getDesc() != null) {
							Comment comment = enumerationLiteral.createOwnedComment();
							comment.setBody(enumValue.getDesc());
						}
					}
				}
				//create Comments
				if(definitionEnumeration.getDesc() != null) {
					Comment comment = enumeration.createOwnedComment();
					comment.setBody(definitionEnumeration.getDesc());
				}
			}
		}
	}

	/**
	 * from a list of SpecRelation create stereotypes in a given profile
	 * 
	 * @param profile
	 *        the profile where stereotypes will be created
	 * @param specRelationTypesToCreate
	 *        the list of relationTypes that will be created in the UML file
	 */
	protected void importReqIFspecRelationTypes(Profile profile, ArrayList<SpecType> specRelationTypesToCreate) {
		for(SpecType specRelationType : specRelationTypesToCreate) {
			if(specRelationType.getLongName() != null && (!(specRelationType.getLongName().trim().equals("")))) {
				Stereotype stereotype = profile.createOwnedStereotype(specRelationType.getLongName(), false);
				importSpecAttribute(specRelationType, stereotype);
				//create Comments
				if(specRelationType.getDesc() != null) {
					Comment comment = stereotype.createOwnedComment();
					comment.setBody(specRelationType.getDesc());
				}
				Class metaclass = (Class)umlMetamodel.getOwnedType("Dependency");
				profile.createMetaclassReference(metaclass);
				stereotype.createExtension(metaclass, false);
			}
		}
	}

	/**
	 * This method is used to import specification from ReqIF model
	 * 
	 * @param reqIFModel
	 *        the REQIF model
	 * @param UMLModel
	 *        the UML model
	 * @param reqStereotypes
	 *        the list of stereotypes
	 */
	protected void importReqIFspecification(ReqIF reqIFModel, Package UMLModel, HashMap<String, Stereotype> reqStereotypes) {
		for(Specification specif : reqIFModel.getCoreContent().getSpecifications()) {
			Package apackage = UMLModel.createNestedPackage(specif.getLongName());
			if(specificationTypeSterotypeMap.get(specif.getType().getLongName()) != null) {
				apackage.applyStereotype(specificationTypeSterotypeMap.get(specif.getType().getLongName()));
				importSpecAttributesValue(specificationTypeSterotypeMap, specif, apackage, specif.getType());
			}
			for(SpecHierarchy specHierarchy : specif.getChildren()) {
				importReqIFHyerarchy(specHierarchy, apackage, reqStereotypes);
			}
			importRootUMLPackage = apackage;
		}
	}

	/**
	 * get the property from a stereotype
	 * 
	 * @param stereotype
	 * @param propertyName
	 * @return the property from a stereotype maybe null
	 */
	public Property getProperty(Stereotype stereotype, String propertyName) {
		Property property = null;
		for(Property attribute : stereotype.getAllAttributes()) {
			if(attribute.getName().equals(propertyName)) {
				return attribute;
			}
		}
		return property;
	}

	/**
	 * fill properties of stereotypes form the SpecElementWithAttributes and the map of stereotypes
	 * 
	 * @param reqStereotypesMap
	 *        map of stereotypes (specificationType, SpecObjectTypes)
	 * @param specif
	 *        SpecElementWithAttributes that contains attributes
	 * @param umlElement
	 *        the UmlElement that is stereotypes and where properties will be filled
	 * @param specType
	 *        the type of the SpecElementWithAttributes
	 */
	protected void importSpecAttributesValue(HashMap<String, Stereotype> reqStereotypesMap, SpecElementWithAttributes specif, Element umlElement, SpecType specType) {
		if(specType != null) {
			for(AttributeDefinition attDefinition : specType.getSpecAttributes()) {
				AttributeValue att = getAttributeValue(specif, attDefinition);
				if(att != null) {
					if(att instanceof AttributeValueString) {
						String attributeName = ((AttributeValueString)att).getDefinition().getLongName().trim();
						attributeName = ReqIFUtil.getNormalName(attributeName);
						Stereotype stereotype = reqStereotypesMap.get(specType.getLongName());
						if(stereotype != null) {
							Property aProperty = getProperty(stereotype, attributeName);
							if(aProperty != null) {
								umlElement.setValue(reqStereotypesMap.get(specType.getLongName()), attributeName, ((AttributeValueString)att).getTheValue());
								if(attributeName.equals(I_SysMLStereotype.REQUIREMENT_ID_ATT)) {
									if(umlElement instanceof NamedElement) {
										((NamedElement)umlElement).setName(((AttributeValueString)att).getTheValue());
									}
								}
							}
						}
					}
					if(att instanceof AttributeValueBoolean) {
						String attributeName = ((AttributeValueBoolean)att).getDefinition().getLongName().trim();
						attributeName = ReqIFUtil.getNormalName(attributeName);
						Stereotype stereotype = reqStereotypesMap.get(specType.getLongName());
						if(stereotype != null) {
							Property aProperty = getProperty(stereotype, attributeName);
							if(aProperty != null) {
								umlElement.setValue(reqStereotypesMap.get(specType.getLongName()), attributeName, ((AttributeValueBoolean)att).isTheValue());
							}
						}
					}
					if(att instanceof AttributeValueInteger) {
						String attributeName = ((AttributeValueInteger)att).getDefinition().getLongName().trim();
						attributeName = ReqIFUtil.getNormalName(attributeName);
						Stereotype stereotype = reqStereotypesMap.get(specType.getLongName());
						if(stereotype != null) {
							Property aProperty = getProperty(stereotype, attributeName);
							if(aProperty != null) {
								umlElement.setValue(reqStereotypesMap.get(specType.getLongName()), attributeName, ((AttributeValueInteger)att).getTheValue().intValue());
							}
						}
					}
					if(att instanceof AttributeValueReal) {
						String attributeName = ((AttributeValueReal)att).getDefinition().getLongName().trim();
						attributeName = ReqIFUtil.getNormalName(attributeName);
						Stereotype stereotype = reqStereotypesMap.get(specType.getLongName());
						if(stereotype != null) {
							Property aProperty = getProperty(stereotype, attributeName);
							if(aProperty != null) {
								umlElement.setValue(reqStereotypesMap.get(specType.getLongName()), attributeName, ((AttributeValueReal)att).getTheValue());
							}
						}
					}
					if(att instanceof AttributeValueEnumeration) {
						String attributeName = ((AttributeValueEnumeration)att).getDefinition().getLongName().trim();
						attributeName = ReqIFUtil.getNormalName(attributeName);
						Stereotype stereotype = reqStereotypesMap.get(specType.getLongName());
						if(stereotype != null) {
							Property aProperty = getProperty(stereotype, attributeName);
							if(aProperty != null) {
								if(((AttributeValueEnumeration)att).getValues().size() > 0) {
									String EnumerationValue = ReqIFUtil.getNormalName(((AttributeValueEnumeration)att).getValues().get(0).getLongName());
									//look for Enumeration literal
									Enumeration aEnumeration = null;
									//look for attribute
									Stereotype referedStereotype = reqStereotypesMap.get(specType.getLongName());
									Property referedAttribute = null;
									for(Property property : referedStereotype.getAllAttributes()) {
										if(property.getName().equals(attributeName)) {
											referedAttribute = property;
										}
									}
									aEnumeration = (Enumeration)referedAttribute.getType();
									EnumerationLiteral aEnumerationLiteral = null;
									for(EnumerationLiteral aLiteral : aEnumeration.getOwnedLiterals()) {
										if(EnumerationValue.equals(aLiteral.getName())) {
											aEnumerationLiteral = aLiteral;
										}
									}
									if(aEnumerationLiteral != null) {
										umlElement.setValue(reqStereotypesMap.get(specType.getLongName()), attributeName, aEnumerationLiteral);
									}
								}
							}
						}
					}
					if(att instanceof AttributeValueXHTML) {
						String attributeName = ((AttributeValueXHTML)att).getDefinition().getLongName().trim();
						attributeName = ReqIFUtil.getNormalName(attributeName);
						Stereotype stereotype = reqStereotypesMap.get(specType.getLongName());
						if(stereotype != null) {
							Property aProperty = getProperty(stereotype, attributeName);
							if(aProperty != null) {
								if((((AttributeValueXHTML)att).getTheValue()) != null) {
									if((((AttributeValueXHTML)att).getTheValue().getXhtmlSource()) != null) {
										umlElement.setValue(reqStereotypesMap.get(specType.getLongName()), attributeName, ((AttributeValueXHTML)att).getTheValue().getXhtmlSource());
									} else {
										try {
											umlElement.setValue(reqStereotypesMap.get(specType.getLongName()), attributeName, ReqIFUtil.getXmlOnlyString(((AttributeValueXHTML)att).getTheValue()));
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
								}
							}
						}
					}
				} else {
					//set Null value
					String attributeName = (attDefinition).getLongName().trim();
					attributeName = ReqIFUtil.getNormalName(attributeName);
					Stereotype stereotype = reqStereotypesMap.get(specType.getLongName());
					if(stereotype != null) {
						Property aProperty = getProperty(stereotype, attributeName);
						if(aProperty != null) {
							umlElement.setValue(reqStereotypesMap.get(specType.getLongName()), attributeName, null);
						}
					}
				}
			}
		}
	}

	/**
	 * This static method generates the string representation of the given {@link XhtmlContent} and returns it.
	 * 
	 * @param xhtmlContent
	 *        , the ReqIF container that holds the xhtml content (See also: {@link XhtmlContent})
	 * @return the string representation of the given {@link XhtmlContent} or null if no root element exists.
	 * @throws IOException
	 */
	public static String getXmlOnlyString(XhtmlContent xhtmlContent) throws IOException {
		StringWriter str = new StringWriter();
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_DECLARE_XML, Boolean.FALSE);
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.FALSE);
		options.put(XMLResource.OPTION_FORMATTED, Boolean.FALSE);
		options.put(XMLResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.FALSE);
		options.put(XMLResource.OPTION_ROOT_OBJECTS, Collections.singletonList(xhtmlContent.getXhtml()));
		//		options.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.FALSE);
		//		options.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);
		XMLResourceImpl ri = new XMLResourceImpl();
		ri.save(str, options);
		String out = str.toString();
		if(out.toLowerCase().contains("<html") || out.toLowerCase().contains("<xhtml")) {
			out = out.replaceAll("</xhtml:XhtmlDivType>", "");
			out = out.replaceAll("<xhtml:XhtmlDivType xmlns:xhtml=\"http://www.w3.org/1999/xhtml\">", "");
			out = out.replaceAll("<xhtml:XhtmlDivType>", "");
		}
		return out.toString();
	}

	/**
	 * Import a hyerarchy that comes from a specification
	 * 
	 * @param specHierarchy
	 * @param UMLElement
	 * @param reqStereotypes
	 */
	protected void importReqIFHyerarchy(SpecHierarchy specHierarchy, Element UMLElement, HashMap<String, Stereotype> reqStereotypes) {
		Element createdChild = importReqIFSpecObjects(specHierarchy.getObject(), UMLElement, reqStereotypes);
		if(createdChild == null) {
			createdChild = UMLElement;
		}
		for(SpecHierarchy specHierarchyChild : specHierarchy.getChildren()) {
			importReqIFHyerarchy(specHierarchyChild, createdChild, reqStereotypes);
		}
	}

	/**
	 * this method transform specification type to stereotypes based on package
	 * 
	 * @param profile
	 *        that contains stereotypes
	 * @param reqiFSpecificationTypetoImport
	 *        the list of specification type to import
	 */
	protected void importReqIFSpecificationType(Profile profile, List<SpecificationType> reqiFSpecificationTypetoImport) {
		Stereotype requirement = getRequirementStereotype(sysMLprofile);
		int index = 0;
		for(SpecificationType specificationType : reqiFSpecificationTypetoImport) {
			Stereotype stereotype = profile.createOwnedStereotype("stereotypeSpecification" + index, false);
			index++;
			if(specificationType.getLongName() != null && (!(specificationType.getLongName().trim().equals("")))) {
				stereotype.setName(specificationType.getLongName());
			}
			stereotype.createGeneralization(requirement);
			importSpecAttribute(specificationType, stereotype);
			//create Comments
			if(specificationType.getDesc() != null) {
				Comment comment = stereotype.createOwnedComment();
				comment.setBody(specificationType.getDesc());
			}
			Class metaclass = (Class)umlMetamodel.getOwnedType("Package");
			profile.createMetaclassReference(metaclass);
			stereotype.createExtension(metaclass, false);
		}
	}

	/**
	 * import attribute definition form the specType, it create property in the stereotype
	 * 
	 * @param specificationType
	 *        the specType
	 * @param stereotype
	 *        the stereotype
	 */
	protected void importSpecAttribute(SpecType specificationType, Stereotype stereotype) {
		//create attributes
		for(AttributeDefinition attributeDef : specificationType.getSpecAttributes()) {
			Property attribute = null;
			String attributeName = attributeDef.getLongName().trim();
			attributeName = ReqIFUtil.getNormalName(attributeName);
			if(attributeDef instanceof AttributeDefinitionString) {
				if((!attributeName.equals("text")) && (!(attributeName.equals("id"))) && (!(stereotype.getName().equals("Requirement")))) {
					attribute = stereotype.createOwnedAttribute(attributeName, umlPrimitiveTypes.getOwnedType("String"));
				}
			}
			if(attributeDef instanceof AttributeDefinitionInteger) {
				attribute = stereotype.createOwnedAttribute(attributeName, umlPrimitiveTypes.getOwnedType("Integer"));
			}
			if(attributeDef instanceof AttributeDefinitionBoolean) {
				attribute = stereotype.createOwnedAttribute(attributeName, umlPrimitiveTypes.getOwnedType("Boolean"));
			}
			if(attributeDef instanceof AttributeDefinitionReal) {
				attribute = stereotype.createOwnedAttribute(attributeName, umlPrimitiveTypes.getOwnedType("Real"));
			}
			if(attributeDef instanceof AttributeDefinitionXHTML) {
				attribute = stereotype.createOwnedAttribute(attributeName, umlPrimitiveTypes.getOwnedType("String"));
			}
			if(attributeDef instanceof AttributeDefinitionEnumeration) {
				String name = ReqIFUtil.getNormalName(((AttributeDefinitionEnumeration)attributeDef).getType().getLongName());
				attribute = stereotype.createOwnedAttribute(attributeName, profileEnumeration.get(name));
			}
			//each attribute of the generated stereotype is 0..1
			if(attribute != null) {
				attribute.setLower(0);
			}
			if(attributeDef.getDesc() != null && attribute != null) {
				Comment comment = attribute.createOwnedComment();
				comment.setBody(attributeDef.getDesc());
			}
		}
	}

	/**
	 * add comment to explain the origin of this model
	 * 
	 * @param reqIFModel
	 *        the reqIF model
	 * @param thePackage
	 *        that will contain the comment
	 */
	protected void importReqIFHeader(ReqIF reqIFModel, Package thePackage) {
		Comment headerComment = thePackage.createOwnedComment();
		String body = "This model has been generated " + GregorianCalendar.getInstance().getTime() + " ";
		body += "from ReqIF file: " + reqIFModel.eResource().getURI().lastSegment() + ".\n";
		body += "" + reqIFModel.getTheHeader().getComment();
		if(reqIFModel.getTheHeader().getTitle() != null) {
			body += "" + reqIFModel.getTheHeader().getTitle();
		}
		headerComment.setBody(body);
	}

	/**
	 * Create stereotyped Class from SpecObject defined in the ReqIF model
	 * 
	 * @param reqIFObject
	 *        the ReqIF object that will be imported
	 * @param owner
	 *        the owner of the imported element in the UML hierarchy
	 * @param reqStereotypes
	 *        list of stereotypes that represent a requirement
	 * @return the a requirement with a good stereotype or null if no object is created (it depends if the type of specObject could be imported)
	 */
	protected Element importReqIFSpecObjects(SpecObject reqIFObject, org.eclipse.uml2.uml.Element owner, HashMap<String, Stereotype> reqStereotypes) {
		//test of the the specObject could be imported
		if(reqIFObject == null) {
			return null;
		}
		if(reqIFObject.getType() == null) {
			System.out.println(reqIFObject.getLongName() + " type is null");
			return null;
		}
		if(reqStereotypes.get(reqIFObject.getType().getLongName()) != null) {
			Class reqClass = null;
			reqClass = createClassWithRequirementName(owner);
			reqClass.applyStereotype(reqStereotypes.get(reqIFObject.getType().getLongName()));
			//setID
			reqClass.setValue(reqStereotypes.get(reqIFObject.getType().getLongName()), I_SysMLStereotype.REQUIREMENT_ID_ATT, reqIFObject.getIdentifier());
			//setText
			reqClass.setValue(reqStereotypes.get(reqIFObject.getType().getLongName()), I_SysMLStereotype.REQUIREMENT_TEXT_ATT, reqIFObject.getDesc());
			importSpecAttributesValue(reqStereotypes, reqIFObject, reqClass, reqIFObject.getType());
			SpecObject_UMLElementMap.put(reqIFObject, reqClass);
			return reqClass;
		}
		return null;
	}

	/**
	 * create a class with requirement name
	 * 
	 * @param owner
	 *        the container of the requirement
	 * @return a class that begin with Requirement
	 */
	protected abstract Class createClassWithRequirementName(Element owner);

	/**
	 * Create stereotyped Class from SpecRealtion defined in the ReqIF model
	 * 
	 * @param reqIFModel
	 *        the ReqIF model
	 * @param UMLModel
	 *        the UMl model
	 * @param reqstereotypeSpecRelation
	 *        list of stereotypes that represent a dependency
	 */
	protected void importSpecRelation(ReqIF reqIFModel, Package UMLModel, HashMap<String, Stereotype> reqstereotypeSpecRelation) {
		for(SpecRelation specRelation : reqIFModel.getCoreContent().getSpecRelations()) {
			if(reqstereotypeSpecRelation.get(specRelation.getType().getLongName()) != null) {
				if((SpecObject_UMLElementMap.get(specRelation.getSource()) != null) && (SpecObject_UMLElementMap.get(specRelation.getTarget())) != null) {
					Dependency reqDependency = null;
					reqDependency = createDependency(UMLModel);
					reqDependency.applyStereotype(reqstereotypeSpecRelation.get(specRelation.getType().getLongName()));
					importSpecAttributesValue(reqstereotypeSpecRelation, specRelation, reqDependency, specRelation.getType());
					reqDependency.getClients().add((NamedElement)SpecObject_UMLElementMap.get(specRelation.getSource()));
					reqDependency.getSuppliers().add((NamedElement)SpecObject_UMLElementMap.get(specRelation.getTarget()));
					if(specRelation.getLongName() != null) {
						reqDependency.setName(ReqIFUtil.getNormalName(specRelation.getLongName()));
					}
				}
			}
		}
	}

	/**
	 * create aDependency UML in the UML Model
	 * 
	 * @param UMLModel
	 * @return the created dependency
	 */
	protected abstract Dependency createDependency(Package UMLModel);

	/**
	 * from a list of SpecObject create stereotypes in a given profile
	 * 
	 * @param profile
	 *        the profile where stereotypes will be created
	 * @param specObjectTypesToCreate
	 */
	protected void importReqIFSpecObjectTypes(Profile profile, ArrayList<SpecType> specObjectTypesToCreate) {
		Stereotype requirement = getRequirementStereotype(sysMLprofile);
		int index = 0;
		for(SpecType specObjectType : specObjectTypesToCreate) {
			Stereotype stereotype = profile.createOwnedStereotype(specObjectType.getLongName(), false);
			if(specObjectType.getLongName() == null || (specObjectType.getLongName().trim().equals(""))) {
				stereotype.setName("StereotypeSpecObjectType" + index);
			}
			index++;
			stereotype.createGeneralization(requirement);
			importSpecAttribute(specObjectType, stereotype);
			//create Comments
			if(specObjectType.getDesc() != null) {
				Comment comment = stereotype.createOwnedComment();
				comment.setBody(specObjectType.getDesc());
			}
		}
	}

	/**
	 * this method is use to get the instance of a profile thanks to its name
	 * 
	 * @param UMLmodel
	 *        the UML model on which the profile will be applied
	 * @param profileName
	 *        the name of the profile
	 * @return a profile (created or found)
	 */
	protected Profile getProfile(org.eclipse.uml2.uml.Package UMLmodel, String profileName) {
		Profile foundProfile = null;
		ArrayList<Profile> localProfiles = getAllLocalProfiles(UMLmodel);
		for(Profile profile : localProfiles) {
			if(profileName.equals(profile.getName())) {
				foundProfile = profile;
			}
		}
		ResourceSet resourceSet = Util.createTemporaryResourceSet();
		if(foundProfile == null) {
			URI umlModel_URI = UMLmodel.eResource().getURI();
			String tmpURI = umlModel_URI.toString().replaceAll(umlModel_URI.lastSegment().toString(), profileName + ".profile.uml");
			URI profileURI = URI.createURI(tmpURI);
			Resource resource = resourceSet.createResource(profileURI);
			foundProfile = UMLFactory.eINSTANCE.createProfile();
			foundProfile.setName(profileName);
			resource.getContents().add(foundProfile);
			Resource resourceprimitiveType = resourceSet.getResource(URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI), true);
			umlPrimitiveTypes = (org.eclipse.uml2.uml.Package)(resourceprimitiveType.getContents().get(0));
			foundProfile.createPackageImport(umlPrimitiveTypes);
			Resource umlMetamodelResource = resourceSet.getResource(URI.createURI(UMLResource.UML_METAMODEL_URI), true);
			umlMetamodel = (org.eclipse.uml2.uml.Package)(umlMetamodelResource.getContents().get(0));
			foundProfile.createMetamodelReference(umlMetamodel);
			foundProfile.createPackageImport(sysMLprofile.getNestedPackage("Requirements"));
			foundProfile.createPackageImport(sysMLprofile);
			try {
				resource.save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return foundProfile;
	}
	//	protected void compare(ReqIF REQIFResource, ReqIF REQIFResource2) {
	//		IComparisonScope scope = new DefaultComparisonScope(REQIFResource,REQIFResource2,null);
	//		Comparison comparison = EMFCompare.builder().build().compare(scope);
	//		List<Diff> differences = comparison.getDifferences();
	//		for (Diff diff : differences) {
	//			System.out.println(diff);
	//		}
	//	}
}

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
 *  Sebastien Revol (CEA LIST) sebastien.revol@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.migration.rhapsody.importer.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.migration.rhapsody.Activator;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyContent;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeature;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeatureValue;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNode;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNodeList;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySimpleValueElement;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxFactory;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * Provides convenient functions to read {@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile} abstract tree
 * 
 * @author sr246418
 *
 */
public class RpyUtil {

	public static final Object RAW_CONTAINER_NAME = "IRPYRawContainer";
	public static final String RAW_CONTAINER_VALUE_FEATURE_NAME = "value";

	private static final String ID_FEATURE_NAME = "_id";
	private static final String IHANDLE_NAME = "IHandle";
	private static final String ISUBSYSTEM_HANDLE_NAME = "ISubsystemHandle";
	private static final String INOBJECT_HANDLE_NAME ="INObjectHandle";
	private static final String ICLASSIFIER_HANDLE_NAME = "IClassifierHandle";

	private static final String HANDLE_FILE_NAME_REF = "_filename";
	private static final String ELEMENT_FILE_NAME_REF = "fileName";
	private static final String ELEMENT_PERSIST_AT = "_persistAs";
	private static final String OWNER_HANDLE_FEATURE_NAME = "_ownerHandle";
	private static final String NAME_FEATURE_NAME = "_name";
	private static final String SUBSYSTEM_FEATURE_NAME="_subsystem";
	private static final String ISUBSYSTEM_NODE_NAME = "ISubsystem";
	private static final String CLASS_FEATURE_NAME = "_class";
	private static final String M2_CLASS_FEATURE_NAME = "_m2Class";

	public static  List<String> SUPPORTED_EXTENSIONS = new ArrayList<String>();
	public static Map<String, String> nodeTypeToExtensionMap = new HashMap<String, String>() ;
	private static final String FILE_EXTENSION_PROPERTIES = "fileextension.properties";
	private static final String NULL_STRING = "NULL";
	
	public static final String OWNED_ELEMENT_FEATURE_NAME = "graphElements";
	public static final String UNKNWON_CLASS_NAME = "UnknownType";

	static {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = RpyUtil.class.getResourceAsStream(FILE_EXTENSION_PROPERTIES);

			prop.load(input);
			for (Map.Entry<Object, Object> entry: prop.entrySet()){
				SUPPORTED_EXTENSIONS.add((String) entry.getKey());
				String valueString = (String) entry.getValue();
				String[] valueTable = valueString.split(",");
				for (String value : valueTable){
					nodeTypeToExtensionMap.put(value, (String) entry.getKey());
				}
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}



	/**
	 * Returs a feature value obtained from a given context at the given period-separated feature path.
	 * If an intermediate feature is a collection, the specific index should be specified
	 * with the following syntax: <code>featureName[index]</code>.
	 * @param context the context from which to compute the path
	 * @param featurePath the path to access to a given feature
	 * @return the feature of null if the path is incorrect
	 */
	public static RpyFeatureValue getFeatureValueFromPath(EObject context, String featurePath) {
		String[] path = featurePath.split(".");

		//TODO Implement it if needed 

		return  null;

	}


	public static List<RpyFeature> getNodeFeatures(RpyNode context){
		List<RpyFeature> ret = new ArrayList<RpyFeature>();
		for (RpyContent content : context.getContents()){
			if (content instanceof RpyFeature){
				ret.add((RpyFeature) content);
			}
		}
		return ret;
	}

	/**
	 * Returns the value of a given feature, simplifying the case when the value
	 * is an IRPYRawContainer. In that case if directly return the "value" subfeature
	 * @param feature the feature owning the desired value
	 * @return the feature value of the <code>IRPYRawContainer.value</code> subfeature 
	 */
	public static RpyFeatureValue getFeatureValue(RpyFeature feature){
		RpyFeatureValue value = feature.getValue();
		if (value instanceof RpyNodeList && ((RpyNodeList) value).getValues().size()==1){
			RpyNode node = ((RpyNodeList) value).getValues().get(0);
			if (RAW_CONTAINER_NAME.equals(node.getName())){
				return getNodeFeatureValue(node, RAW_CONTAINER_VALUE_FEATURE_NAME);
			}
		}		
		return value;
	}

	public static RpyFeatureValue getNodeFeatureValue(RpyNode context, String featureName){
		for (RpyFeature feature : getNodeFeatures(context)){
			if (featureName.equals(feature.getName())){
				return getFeatureValue(feature);
			}
		}
		return null;
	}

	public static String getID(RpyNode node){
		if (!isRpyIHandle(node) ){
			return getNodeFeatureValueAsString(node,ID_FEATURE_NAME );
		}
		return null;

	}

	public static String getNodeFeatureValueAsString(RpyNode context, String featureName){
		RpyFeatureValue value = getNodeFeatureValue(context, featureName);
		if (value instanceof SimpleValueList){
			return getStringValue((SimpleValueList) value);
		}
		return null;
	}


	/**
	 * @param value
	 * @return
	 */
	public static String getStringValue(SimpleValueList value) {

		if (!value.getValueElements().isEmpty()) {

			String ret = "";
			for (RpySimpleValueElement simpleValueElem : value.getValueElements()){
				for (String val : simpleValueElem.getValues()){
					ret += val;
				}
			}

			return ret;
		}
		return null;
	}


	public static boolean containsHandle(RpyNodeList nodeList){
		for(RpyNode node : nodeList.getValues()){
			if (isRpyIHandle(node)){
				return true;
			}
		}
		return false;
	}

	/**
	 * @param node
	 * @return
	 */
	public static boolean isRpyIHandle(RpyNode node) {
		return IHANDLE_NAME.equals(node.getName()) || ISUBSYSTEM_HANDLE_NAME.equals(node.getName())|| INOBJECT_HANDLE_NAME.equals(node.getName()) || ICLASSIFIER_HANDLE_NAME.equals(node.getName());
	}

	public static String getIHandleFileRef(RpyNode node) {
		return getPathStringInFeature(node, HANDLE_FILE_NAME_REF);
	}

	public static String getElementFileRef(RpyNode node) {
		//we are looking for the "fileName" feature
		String fileName = getPathStringInFeature(node, ELEMENT_FILE_NAME_REF);
		if (fileName != null){
		
			String nodeType = node.getName();
			String extension = nodeTypeToExtensionMap.get(nodeType);
			if (extension != null){
				fileName +="."+extension;
				return fileName;
			}else {
				Activator.log.error(NLS.bind(Messages.UnknownExtension,  new String[]{nodeType, fileName, getNodeIndexInFile(node), node.eResource().getURI().toFileString()}), null);
			}



		}
		return null;
	}


	public static String getElementPersistAt(RpyNode node) {
		return getPathStringInFeature(node, ELEMENT_PERSIST_AT);
	}



	private static String getPathStringInFeature(RpyNode node, String featurePath) {
		String stringValue = getNodeFeatureValueAsString(node, featurePath);
		if (stringValue != null && stringValue.startsWith("\"")){
			stringValue = stringValue.replaceAll("\"", "");
		}
		return  stringValue;
	}


	public static boolean isDirectReference(RpyFeature feature){
		if (feature.getValue() instanceof SimpleValueList) {
			SimpleValueList simpleValueList = (SimpleValueList) feature.getValue();
			return (simpleValueList.isIsGUID() || simpleValueList.isIsOldID()) && !feature.getName().equals(ID_FEATURE_NAME);
		}
		return false;
	}

	public static String getReferencedID(RpyNode handleOrReference){
		if (isElementRef(handleOrReference) || isRpyIHandle(handleOrReference)){
			return  getNodeFeatureValueAsString(handleOrReference, ID_FEATURE_NAME);
		}
		return null;
	}

	public static boolean isElementRef(RpyNode node) {
		return getElementFileRef(node) != null;
	}


	/**
	 * @param node
	 * @return
	 */
	public static String getNodeIndexInFile(RpyNode node) {
		ICompositeNode xtextNode = NodeModelUtils.getNode(node);
		String index ="-";
		if (xtextNode != null){
			index=Integer.toString(xtextNode.getStartLine());
		}
		return index;
	}


	/**
	 * @param node
	 * @return
	 */
	public static String getReferencedSubsystemFromHandle(RpyNode node) {
		String subSystemName = getPathStringInFeature(node, SUBSYSTEM_FEATURE_NAME);
		if (subSystemName != null && ! subSystemName.isEmpty()){
			return subSystemName;
		}

		else{
			return null;
		}

	}

	public static String getReferencedClassFromHandle(RpyNode node) {
		String className = getPathStringInFeature(node, CLASS_FEATURE_NAME);
		if (className != null && ! className.isEmpty()){
			return className;
		}

		else{
			return null;
		}

	}


	/**
	 * @param node
	 * @return
	 */
	public static String getReferencedNameFromHandle(RpyNode node) {
		String name = getPathStringInFeature(node, NAME_FEATURE_NAME);
		if (name != null && ! name.isEmpty()){
			return name;
		}

		else{
			return null;
		}
	}


	/**
	 * @param rpyFeatureValue
	 * @return
	 */
	public static boolean isNull(SimpleValueList rpyFeatureValue) {
		
		return NULL_STRING.equals(getStringValue(rpyFeatureValue));
	}


	public static RpyNode createProxyNodeFromHandler(RpyNode handlerNode) {
		
		String m2Class = getNodeFeatureValueAsString(handlerNode, M2_CLASS_FEATURE_NAME);
		if (m2Class != null){
			RpyNode ret= RpySyntaxFactory.eINSTANCE.createRpyNode();
			ret.setName(m2Class.replaceAll("\"", ""));
			for (RpyFeature feature : getNodeFeatures(handlerNode)){
				if (ID_FEATURE_NAME.equals(feature.getName()) || NAME_FEATURE_NAME.equals(feature.getName())){
					ret.getContents().add(EcoreUtil.copy(feature));
				}
			}
			return ret;
		}
		return null;
	}



}

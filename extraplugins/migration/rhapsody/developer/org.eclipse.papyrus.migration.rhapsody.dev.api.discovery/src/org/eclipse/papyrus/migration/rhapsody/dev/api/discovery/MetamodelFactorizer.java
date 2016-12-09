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
package org.eclipse.papyrus.migration.rhapsody.dev.api.discovery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RpyUtil;

/**
 * @author sr246418
 *
 */
public class MetamodelFactorizer {

	public static void factorizeMetamodel(EPackage metamodel){

		fixStateCharts(metamodel);
		fixIDs(metamodel);

		List<EClassifier> classifiers = new ArrayList<EClassifier>(metamodel.getEClassifiers());
		for(EClassifier eClassifier : classifiers){
			factorizeEClass((EClass)eClassifier);
		}

		factorizeFeaturesInSuperClass(metamodel);
		
		fixEAttributesNotUnique(metamodel);
		fixHyperLinks(metamodel);

	}

	/**
	 * @param metamodel
	 */
	private static void fixEAttributesNotUnique(EPackage metamodel) {
		for (Iterator<EObject> iterator = metamodel.eResource().getAllContents(); iterator.hasNext();) {
			EObject obj = iterator.next();
			if (obj instanceof EAttribute ){
				EAttribute attr = (EAttribute) obj; 
				if (attr.isMany()){
					attr.setUnique(false);
				}
			}
			
		}
		
	}

	/**
	 * @param metamodel
	 */
	private static void fixHyperLinks(EPackage metamodel) {
		EClass hyperLinksType = (EClass) metamodel.getEClassifier("HyperLinksType");
		EClass hyperlinksType = (EClass) metamodel.getEClassifier("HyperlinksType");

		if (hyperLinksType != null && hyperlinksType != null){
			for (Iterator<EObject> iterator = metamodel.eResource().getAllContents(); iterator.hasNext();) {
				EObject obj = iterator.next();
				if (obj instanceof EClass && ((EClass) obj).getESuperTypes().contains(hyperlinksType)){
					((EClass) obj).getESuperTypes().remove(hyperlinksType);
					((EClass) obj).getESuperTypes().add(hyperLinksType);
				}else if (obj instanceof EReference && ((EReference)obj).getEType() == hyperlinksType){
					((EReference)obj).setEType(hyperLinksType);
				}
				
			}
		
			EcoreUtil.delete(hyperlinksType);

		}
		
		
	}

	/**
	 * @param metamodel
	 */
	private static void fixIDs(EPackage metamodel) {
		for (EClassifier eClassifier : metamodel.getEClassifiers()){
			EClass eClass= (EClass) eClassifier;
			for (EAttribute eAttr : eClass.getEAllAttributes()){
				if ("id".equals(eAttr.getName())){
					eAttr.setUpperBound(1);
				}
			}
		}

	}

	/**
	 * @param metamodel
	 */
	private static void fixStateCharts(EPackage metamodel) {
		EClass iStatechart = (EClass) metamodel.getEClassifier("IStatechart");
		EClass iStateChart = (EClass) metamodel.getEClassifier("IStateChart");

		if (iStatechart != null){
			iStateChart.getESuperTypes().addAll(iStatechart.getESuperTypes());
			EcoreUtil.delete(iStatechart);

			EClass iStatechartDiagram = (EClass) metamodel.getEClassifier("IStatechartDiagram");
			EClass iStateChartDiagram = (EClass) metamodel.getEClassifier("IStateChartDiagram");

			iStateChartDiagram.getESuperTypes().addAll(iStatechartDiagram.getESuperTypes());
			EcoreUtil.delete(iStatechartDiagram);
		}
		
	}

	/**
	 * @param metamodel
	 */
	private static void factorizeFeaturesInSuperClass(EPackage metamodel) {

		//we create a first list of Classes that have structural features
		List<EClass> eClassWithFeatures = new ArrayList<EClass>();
		for (EClassifier eClassifier : metamodel.getEClassifiers()){
			EClass eClass = (EClass) eClassifier;
			if (!eClass.getEStructuralFeatures().isEmpty()){
				eClassWithFeatures.add(eClass);
			}
		}



		//we also create a map which provides all the classe owning a given feature, identified with Name + Type
		while (!eClassWithFeatures.isEmpty()){
			//we collect all the super classes of the classes with structural features
			Set<EClass> l1SuperTypes = collectL1SuperTypes(eClassWithFeatures);

			Map<String, List<EStructuralFeature>> featureMap = new HashMap<>();	

			for (EClass eClass: eClassWithFeatures){
				for (EStructuralFeature attr : eClass.getEStructuralFeatures()){
					List<EStructuralFeature> attrs = featureMap.get(getKey(attr));
					if (attrs== null){
						attrs = new ArrayList<EStructuralFeature>();
						featureMap.put(getKey(attr), attrs);
					}
					attrs.add(attr);
				}	
			}

			Set<EClass> superClassWithFactorizedFeatures = new HashSet<EClass>();
			//now we iterate on the super types.
			for (EClass l1SuperType : l1SuperTypes){
				List<EClass> specializations = collectL1Specializations(l1SuperType);
				if (specializations.size() >1){
					for(List<EStructuralFeature> featuresList : featureMap.values()){
						//owning classes is the list of the classes that owns a given structural feature
						List<EClass> owningClasses = new ArrayList<EClass>();
						for (EStructuralFeature feature : featuresList){
							owningClasses.add(feature.getEContainingClass());
						}

						// if all the specialization of the current super type have a given feature
						//we factorize this feature
						if (owningClasses.containsAll(specializations)){
							List<EStructuralFeature> featuresToDelete = new ArrayList<EStructuralFeature>();

							String featureName = featuresList.get(0).getName();
							EStructuralFeature factorizedFeature = EcoreUtil.<EStructuralFeature>copy(specializations.get(0).getEStructuralFeature(featureName));
							for (int i=0; i< specializations.size(); i++){
									featuresToDelete.add(specializations.get(i).getEStructuralFeature(featureName));
								}
							
							for(EStructuralFeature featureToDelete : featuresToDelete){
								EcoreUtil.delete(featureToDelete);
							}
							featuresList.removeAll(featuresToDelete);
							
							l1SuperType.getEStructuralFeatures().add(factorizedFeature);
							superClassWithFactorizedFeatures.add(l1SuperType);
							List<String> names = new ArrayList<>();
							for (EClass specialization: specializations){
								names.add(specialization.getName());
							}
							System.out.println("Factorizing " + factorizedFeature.getName() +":"+ factorizedFeature.getEType().getName()+ " from Classes " + names + " to Class " + l1SuperType.getName());

							
						}
					}
				}	
			}

			//we have now iterated on all the L1 superTypes. We will restart the loop at L1 +1.
			eClassWithFeatures.clear();
			//eClassWithFeatures.addAll(superClassWithFactorizedFeatures);


		}



	}


	private static String capitalize(String str){
		String firstLetter= str.substring(0,1);
		return firstLetter.toUpperCase()+ str.substring(1);
	}

	/**
	 * @param features
	 * @return
	 */
	private static List<EClass> collectContainingClasses(List<EStructuralFeature> features) {
		List<EClass> ret = new ArrayList<>();
		for (EStructuralFeature feat: features) {
			ret.add(feat.getEContainingClass());
		}
		return ret;
	}

	private static EClass findCommonSuperType(List<EClass> types) {
		Iterator<EClass> typeIter = types.iterator();
		EClass firstType = typeIter.next();
		List<EClass> ret = new ArrayList<>(firstType.getESuperTypes());

		while (typeIter.hasNext() && !ret.isEmpty()){
			EClass nextType = typeIter.next();
			ret.retainAll(nextType.getEAllSuperTypes());
		}
		if (!ret.isEmpty()){
			return ret.get(0);
		}

		return null;
	}

	/**
	 * @param attr
	 * @return
	 */
	private static String getKey(EStructuralFeature attr) {
		return attr.getName()+attr.getEType()+attr.getUpperBound();
	}

	/**
	 * @param eClassifier
	 */
	private static void factorizeEClass(EClass eClass) {
		Map<String, List<EStructuralFeature>> multipleFeaturesMap = collectMultipleFeaturesLists(eClass);	
		for (List<EStructuralFeature> featList : multipleFeaturesMap.values()){
			if (featList.size()>1) {
				factorizeDuplicatedFeatures(eClass, featList);
			}
		}
	}

	/**
	 * @param eClass
	 * @param featList
	 */
	private static void factorizeDuplicatedFeatures(EClass eClass, List<EStructuralFeature> featList) {
		
		List<EClass> types = new ArrayList<EClass>();
		List<EStructuralFeature> featToRemove =new ArrayList<>();

		List<EStructuralFeature> inheritedFeatures = new ArrayList<>(eClass.getEAllStructuralFeatures());
		inheritedFeatures.retainAll(featList);
		
		
		List<EStructuralFeature> unknownsToRemove = new ArrayList<EStructuralFeature>();
		EStructuralFeature unknownFeature = null;
		boolean allUnknowns = true;
		
		for (EStructuralFeature feature : featList){
			if (RpyUtil.UNKNWON_CLASS_NAME.equals(feature.getEType().getName())){
				if (unknownFeature == null){
					unknownFeature = feature;
				}else {
					//we keep only one unknown feature
					unknownsToRemove.add(feature);
				}
			}else {
				allUnknowns = false;
			}
		}
		for (EStructuralFeature unknown : unknownsToRemove){
			featList.remove(unknown);
			EcoreUtil.remove(unknown);
		}
		//if there is another kind of feature than unknown, priority to it, we remove unknwon
		if (! allUnknowns && unknownFeature != null){
			featList.remove(unknownFeature);
			EcoreUtil.remove(unknownFeature);
		}
		
		//We also check if all the remaing features are EAttributes
		//since we won't perform type factorization for EAttributes
		boolean allEAttributes = true;
		Iterator<EStructuralFeature> featListIterator = featList.iterator();
		while (featListIterator.hasNext()){
			EStructuralFeature next = featListIterator.next();
			if (next instanceof EReference){
				allEAttributes = false;
			}
		}
		
	

		boolean isMultiple = false;

		EStructuralFeature finalRef = null;
		ListIterator<EStructuralFeature> refIter = featList.listIterator();
		while (refIter.hasNext()) {
			EStructuralFeature feat = refIter.next();
			if (allEAttributes || feat instanceof EReference){
				if (finalRef == null && (inheritedFeatures.isEmpty() || inheritedFeatures.contains(feat)) ) {
					finalRef = feat;
				}
				if (!allEAttributes){
					types.add((EClass) feat.getEType());
				}

				if (feat.getUpperBound() == -1){
					isMultiple = true;
				}
			}
			if (finalRef != feat){
				featToRemove.add(feat);
			}



		}

		if (isMultiple && finalRef.getUpperBound() != -1){
			finalRef.setUpperBound(-1);
		}

		for(EStructuralFeature refToRemove: featToRemove){
			EcoreUtil.delete(refToRemove);
		}

		if (!allEAttributes){
			EClass finalType = findOrCreateCommonFeatureType(finalRef, types);
			finalRef.setEType(finalType);
		}

	}

	/**
	 * @param finalRef
	 * @param types
	 * @return
	 */
	private static EClass findOrCreateCommonFeatureType(EStructuralFeature finalRef, List<EClass> types) {

		EClass commonSuperType = findCommonSuperType(types);
		if (commonSuperType != null){
			return commonSuperType;
		}
		//		List<EClass> commonSuperTypes = collectCommonL1SuperTypes(types);
		//		
		//		//in this implem, we reuse an existing type only if the list of existing types is exactly the list of the subtypes of a common ancestor
		//		for (EClass superType : commonSuperTypes){
		//			List<EClass> specializations = collectCommonL1Specializations(superType);
		//			if (specializations.size() == types.size()){
		//				return superType;
		//			}
		//		}

		EPackage targetEPack = finalRef.getEContainingClass().getEPackage();
		String eClassName = capitalize(finalRef.getName())+"Type";
		//eClassName = finalRef.getEContainingClass().getName() + "_"+ eClassName;


		EClass ret = (EClass) targetEPack.getEClassifier(eClassName);
		if (ret == null){
			ret = EcoreFactory.eINSTANCE.createEClass();
			ret.setName(eClassName);
			ret.setAbstract(true);
		}

		for (EClass type : types){
			if (!type.getESuperTypes().contains(ret) && type != ret){
				type.getESuperTypes().add(ret);
			}
		}

		targetEPack.getEClassifiers().add(ret);



		return ret;
	}


	private static List<EClass> collectCommonL1SuperTypes(List<EClass> types) {

		Iterator<EClass> typeIter = types.iterator();
		EClass firstType = typeIter.next();
		List<EClass> ret = new ArrayList<>(firstType.getESuperTypes());

		while (typeIter.hasNext() && !ret.isEmpty()){
			EClass nextType = typeIter.next();
			ret.retainAll(nextType.getESuperTypes());
		}

		return ret;
	}

	private static Set<EClass> collectL1SuperTypes(List<EClass> types) {
		Set<EClass> ret = new HashSet<EClass>();
		for (EClass type : types){
			ret.addAll(type.getESuperTypes());
		}
		return ret;
	}


	private static List<EClass> collectL1Specializations(EClass superType) {
		List<EClass> ret = new ArrayList<>();
		EPackage pack = superType.getEPackage();
		for (EClassifier eClassifier : pack.getEClassifiers()){
			if (((EClass)eClassifier).getESuperTypes().contains(superType)){
				ret.add((EClass)eClassifier);
			}
		}

		return ret;
	}

	/**
	 * @param eClass
	 * @return
	 */
	private static Map<String, List<EStructuralFeature>> collectMultipleFeaturesLists(EClass eClass) {
		Map<String, List<EStructuralFeature>> ret = new HashMap<String, List<EStructuralFeature>>();
		for (EStructuralFeature feat : eClass.getEAllStructuralFeatures()){
			List<EStructuralFeature> list = ret.get(feat.getName());
			if (list == null){
				list = new ArrayList<EStructuralFeature>();
				ret.put(feat.getName(), list);
			}
			list.add(feat);
		}
		return ret;
	}

}

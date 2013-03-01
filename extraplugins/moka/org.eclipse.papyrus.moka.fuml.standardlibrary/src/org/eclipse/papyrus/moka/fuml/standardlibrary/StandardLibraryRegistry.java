/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.standardlibrary;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.fuml.registry.AbstractOpaqueBehaviorExecutionRegistry;


public class StandardLibraryRegistry extends AbstractOpaqueBehaviorExecutionRegistry {

	protected final static String FUML_LIBRARY_NAME = "FoundationalModelLibrary";

	@Override
	public void registerOpaqueBehaviorExecutions(Locus locus) {
		this.locus = locus;
		this.buildOpaqueBehaviorsMap(FUML_LIBRARY_NAME);
		// TODO Only the PrimitiveBehaviors package is implemented. Common and BasicInputOutput need to be implemented.
		try {
			// ////////////////////
			// Integer functions
			// Neg
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Neg(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Neg");
			// +
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Add(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::+");
			// -
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Minus(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::-");
			// *
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Times(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::*");
			// Abs
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Abs(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Abs");
			// Div
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Div(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Div");
			// Mod
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Mod(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Mod");
			// Max
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Max(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Max");
			// Min
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Min(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Min");
			// <
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Lower(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::<");
			// >
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Greater(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::>");
			// <=
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.LowerOrEqual(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::<=");
			// >=
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.GreaterOrEqual(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::>=");
			// ToString
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.ToString(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::ToString");
			// ToUnlimitedNatural
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.ToUnlimitedNatural(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::ToUnlimitedNatural");
			// ToInteger
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.ToInteger(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::ToInteger");
			//  '/' is missing TODO

			// ////////////////////
			// Unlimited natural functions
			// >
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.Greater(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::>");
			// >=
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.GreaterOrEqual(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::>=");
			// <
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.Lower(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::<");
			// <=
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.LowerOrEqual(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::<=");
			// Max
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.Max(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::Max");
			// Min
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.Min(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::Min");
			// ToInteger
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.ToInteger(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::ToInteger");
			// ToString
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.ToString(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::ToString");
			// ToUnlimitedNatural
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural.ToUnlimitedNatural(), "FoundationalModelLibrary::PrimitiveBehaviors::UnlimitedNaturalFunctions::ToUnlimitedNatural");

			// ////////////////////
			// Boolean functions
			// Or
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Or(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Or");
			// Xor
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Xor(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Xor");
			// And
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.And(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::And");
			// Not
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Not(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Not");
			// Implies
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Implies(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Implies");
			// ToString
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.ToString(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::ToString");
			// ToBoolean
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.ToBoolean(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::ToBoolean");
			// ////////////////////
			// String functions
			// Concat
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.string.Concat(), "FoundationalModelLibrary::PrimitiveBehaviors::StringFunctions::Concat");
			// Size
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.string.Size(), "FoundationalModelLibrary::PrimitiveBehaviors::StringFunctions::Size");
			// Substring
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.string.Substring(), "FoundationalModelLibrary::PrimitiveBehaviors::StringFunctions::Substring");
			// ////////////////////
			// List functions
			// ListSize
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.list.ListSize(), "FoundationalModelLibrary::PrimitiveBehaviors::ListFunctions::ListSize");
			// ListGet
			this.registerOpaqueBehaviorExecution(new org.eclipse.papyrus.moka.fuml.standardlibrary.library.list.ListGet(), "FoundationalModelLibrary::PrimitiveBehaviors::ListFunctions::ListGet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TODO This overriding should not be necessary
	// The fUML standard library just needs to be a registered library
	//	@Override
	//	protected void buildOpaqueBehaviorsMap(String libraryName) {
	//		opaqueBehaviorsMap = new HashMap<String, OpaqueBehavior>();
	//		RegisteredLibrary[] libraries = RegisteredLibrary.getRegisteredLibraries();
	//		RegisteredLibrary alfLibrary = null;
	//		for(RegisteredLibrary l : libraries) {
	//			if(l.getName().equals("AlfLibrary"))
	//				alfLibrary = l;
	//		}
	//		if(alfLibrary != null) {
	//			URI libraryUri = alfLibrary.uri;
	//			ResourceSet resourceSet = contextEObject.eResource().getResourceSet();
	//			Resource libraryResource = resourceSet.getResource(libraryUri, true);
	//			Package libraryObject = (Package)libraryResource.getContents().get(0);
	//			Package fumlPackage = null;
	//			for(Element e : libraryObject.getOwnedElements()) {
	//				if(e instanceof PackageImport) {
	//					if(((PackageImport)e).getImportedPackage().getName().equals(libraryName))
	//						fumlPackage = ((PackageImport)e).getImportedPackage();
	//				}
	//			}
	//			if(fumlPackage != null) {
	//				List<Package> packagesForCurrentIteration = new ArrayList<Package>();
	//				packagesForCurrentIteration.add(fumlPackage);
	//				List<Package> packagesForNextIteration = new ArrayList<Package>();
	//				while(!packagesForCurrentIteration.isEmpty()) {
	//					for(Package p : packagesForCurrentIteration) {
	//						for(Element e : p.getOwnedElements()) {
	//							if(e instanceof Package) {
	//								packagesForNextIteration.add((Package)e);
	//							} else if(e instanceof FunctionBehavior) {
	//								FunctionBehavior f = (FunctionBehavior)e;
	//								opaqueBehaviorsMap.put(f.getQualifiedName(), f);
	//								System.out.println(f.getQualifiedName());
	//							}
	//						}
	//					}
	//					packagesForCurrentIteration.clear();
	//					packagesForCurrentIteration.addAll(packagesForNextIteration);
	//					packagesForNextIteration.clear();
	//				}
	//			}
	//		}
	//	}

	protected void registerOpaqueBehaviorExecution(OpaqueBehaviorExecution behaviorExecution, String behaviorQualifiedName) {
		behaviorExecution.types.add(this.opaqueBehaviorsMap.get(behaviorQualifiedName));
		locus.factory.primitiveBehaviorPrototypes.add(behaviorExecution);
	}
}

/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thomas Daniellou (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.adltool.reversible.packages;

import org.eclipse.osgi.service.resolver.ExportPackageDescription;
import org.eclipse.papyrus.adltool.reversible.AbstractReversible;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.papyrus.osgi.profile.OSGIStereotypes;
import org.eclipse.pde.core.project.IPackageExportDescription;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

public class ExportPackage extends AbstractReversible<Package> implements ReversiblePackage {

	private String id;
	private ReversibleProject parent;

	public ExportPackage(String id) {
		this.id = id;
	}

	public ExportPackage(ExportPackageDescription exportPackage) {
		id = exportPackage.getName();
		/*
		Version version = exportPackage.getVersion();

		if (version != null) {
			dependencyVersion = new DependencyVersion(version);
		}
		 */
	}

	public ExportPackage(IPackageExportDescription exportPackage) {
		id = exportPackage.getName();
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getStereotypeName() {
		return OSGIStereotypes.EXPORTED_PACKAGE_STEREOTYPE;
	}

	@Override
	public Type getType() {
		return Type.EXPORT_PACKAGE;
	}

	@Override
	public String getDependencyStereotypeName() {
		return OSGIStereotypes.PACKAGE_REFERENCE;
	}

	@Override
	protected Package createRepresentation() {
		return UMLFactory.eINSTANCE.createPackage();
	}

	@Override
	public void fillStereotype() {
		// Empty: no stereotypes values to set
	}

	@Override
	public ReversibleProject getParent() {
		return parent;
	}

	@Override
	public void setParent(ReversibleProject parent) {
		this.parent = parent;
	}

}

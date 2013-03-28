/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.editorsfactory.anytype;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.papyrus.infra.core.extension.diagrameditor.AbstractEditorFactory;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IComponentModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * An EditorFactory for "AnyType", i.e. EObject deserialized from unknown Packages
 * 
 * Allows recovery and manipulation of models containing optional EMF components
 * 
 * @author Camille Letavernier
 */
public class AnyTypeEditorFactory extends AbstractEditorFactory {

	public AnyTypeEditorFactory() {
		super(null, "AnyTypeHandler");
	}

	public IPageModel createIPageModel(Object pageIdentifier) {

		final AnyType anyTypeModel = (AnyType)pageIdentifier;

		return new IComponentModel() {

			private AnyType anyType = anyTypeModel;

			public String getTabTitle() {
				return "Missing component";
			}

			public Image getComponentIcon() {
				return Display.getDefault().getSystemImage(SWT.ICON_WARNING);
			}

			public Image getTabIcon() {
				return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_WARN_TSK);
			}

			public Object getRawModel() {
				return anyType;
			}

			public String getErrorText() {
				EClass eClass = anyTypeModel.eClass();
				String className = eClass == null ? "None" : eClass.getName();
				EPackage ePackage = eClass == null ? null : eClass.getEPackage();
				String ePackageName = ePackage == null ? "None" : ePackage.getNsURI();
				String message = "A component is missing. The following Model cannot be loaded: " + className + " (from " + ePackageName + ")\n";
				message += "";
				return message;
			}

			public Composite createPartControl(Composite parent) {
				Composite tabComposite = new Composite(parent, SWT.NONE);
				tabComposite.setLayout(new GridLayout(2, false));

				Image componentIcon = getComponentIcon();
				if(componentIcon != null) {
					Label errorImageLabel = new Label(tabComposite, SWT.NONE);
					errorImageLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
					errorImageLabel.setImage(componentIcon);
				}

				Label label = new Label(tabComposite, SWT.NONE);
				label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
				label.setText(getErrorText());

				return tabComposite;
			}
		};
	}

	public boolean isPageModelFactoryFor(Object pageIdentifier) {
		return pageIdentifier instanceof AnyType;
	}

}

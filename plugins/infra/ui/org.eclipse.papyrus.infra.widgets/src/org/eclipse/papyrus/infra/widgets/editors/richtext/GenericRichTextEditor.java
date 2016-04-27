/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors.richtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.richtext.RichTextEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * 
 * The richtext editor with the {@link SpellCheckToolbarButton}
 * 
 * @since 2.0
 *
 */
public class GenericRichTextEditor extends RichTextEditor {

	/**
	 * 
	 * 
	 * Methods to enabled all HTML tags.
	 * Later, contribute to Nebula so we can create
	 * a org.eclipse.nebula.widgets.richtext.RichTextEditor with
	 * CKEDITOR.config.allowContent=true;
	 */
	private boolean tagsEnabled;

	/**
	 * the string used to allows all contents in the ckeditor
	 */
	private static final String CKEDITOR_ALLOWED_CONTENT = "CKEDITOR.config.allowedContent=true;"; //$NON-NLS-1$

	/**
	 * the edited eobject
	 */
	private EObject editedObject;

	/**
	 * the edited feature for the edited eobject
	 */
	private EStructuralFeature editedFeature;

	/**
	 * 
	 * Constructor.
	 *
	 * @param parent
	 * @param toolbarConfig
	 * @param style
	 */
	public GenericRichTextEditor(Composite parent, GenericToolbarConfiguration toolbarConfig, int style) {
		super(parent, toolbarConfig, style);
		toolbarConfig.setRichTextEditor(this);
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param parent
	 * @param toolbarConfig
	 */
	public GenericRichTextEditor(Composite parent, GenericToolbarConfiguration toolbarConfig) {
		this(parent, toolbarConfig, SWT.NONE);
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param parent
	 */
	public GenericRichTextEditor(Composite parent) {
		this(parent, SWT.NONE);
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param parent
	 * @param style
	 */
	public GenericRichTextEditor(Composite parent, int style) {
		this(parent, new GenericToolbarConfiguration(), style);
	}

	/**
	 * 
	 * @return <code>true</code> if the tag have been enabled
	 */
	public boolean isTagsEnabled() {
		return tagsEnabled;
	}

	/**
	 * 
	 * @return
	 */
	public boolean enableTags() {
		if (!tagsEnabled) {
			try {
				tagsEnabled = executeJavascript(CKEDITOR_ALLOWED_CONTENT);
				// updateToolbar();
			} catch (Exception e) {
				tagsEnabled = false;
			}
		}
		return tagsEnabled;
	}



	/**
	 * 
	 * @param editedEObject
	 *            the edited element
	 * @param editedFeature
	 *            the edited feature for the element
	 */
	public void configureEdition(final EObject editedEObject, final EStructuralFeature editedFeature) {
		this.editedObject = editedEObject;
		this.editedFeature = editedFeature;
	}

	/**
	 * 
	 * @return
	 * 		the edited eobject
	 */
	public EObject getEditedObject() {
		return editedObject;
	}

	/**
	 * 
	 * @return
	 * 		the edited feature of the edited eobject
	 */
	public EStructuralFeature getEditedFeature() {
		return editedFeature;
	}


}

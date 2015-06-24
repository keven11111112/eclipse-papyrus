/*******************************************************************************
 * Copyright (c) 2012 Original authors and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Vincent Lorenzo (CEA-LIST)  - duplicated and adapted code from nattable project.
 *
 ******************************************************************************/
package org.eclipse.papyrus.uml.nattable.manager.cell.editor;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.IEditErrorHandler;
import org.eclipse.papyrus.infra.nattable.celleditor.AbstractPapyrusStyledTextCellEditor;
import org.eclipse.papyrus.infra.nattable.converter.StringResolutionProblemPapyrusConverter;
import org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.CrossAxisWrapper;
import org.eclipse.papyrus.infra.widgets.editors.StringEditorWithCompletionWrapper;
import org.eclipse.papyrus.infra.widgets.util.INameResolutionHelper;
import org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter;
import org.eclipse.papyrus.infra.widgets.util.ISetPapyrusConverter;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.papyrus.uml.tools.util.UMLReferenceConverter;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionHelper;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Element;



/**
 * {@link ICellEditor} implementation that wraps a SWT {@link Text} control to
 * support text editing. This is also the default editor in NatTable if you
 * didn't configure something else.
 *
 * duplicated and adapted code from nattable project. Add the method {@link #keyPressed(Composite, KeyEvent)} to allow to ovveride it
 */
public class UMLReferenceTextWithCompletionCellEditor extends AbstractPapyrusStyledTextCellEditor {

	/**
	 * The Text control which is the editor wrapped by this TextCellEditor.
	 */
	private StringEditorWithCompletionWrapper textCompletion = null;

	/**
	 * The name resolution helper to use to find UML Element from a string
	 */
	private INameResolutionHelper helper;

	/**
	 * the papyrus parser to use
	 */
	private IPapyrusConverter parser;
	/**
	 * boolean indicating if we are editing a multivalued field
	 */
	private boolean isMultiValued = false;

	/**
	 * 
	 * Constructor.
	 *
	 * @param table
	 * @param axisElement
	 * @param elementProvider
	 * @param commitOnUpDown
	 * @param moveSelectionOnEnter
	 */
	public UMLReferenceTextWithCompletionCellEditor(Table table, Object axisElement, ITableAxisElementProvider elementProvider, boolean commitOnUpDown, boolean moveSelectionOnEnter) {
		super(table, axisElement, elementProvider, commitOnUpDown, moveSelectionOnEnter);
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param table
	 * @param axisElement
	 * @param elementProvider
	 * @param commitOnUpDown
	 */
	public UMLReferenceTextWithCompletionCellEditor(Table table, Object axisElement, ITableAxisElementProvider elementProvider, boolean commitOnUpDown) {
		super(table, axisElement, elementProvider, commitOnUpDown);
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param table
	 * @param axisElement
	 * @param elementProvider
	 */
	public UMLReferenceTextWithCompletionCellEditor(Table table, Object axisElement, ITableAxisElementProvider elementProvider) {
		super(table, axisElement, elementProvider);
	}

	/**
	 * 
	 * @param isMultivalued
	 */
	public void setIsMultiValued(boolean isMultivalued) {
		this.isMultiValued = isMultivalued;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.AbstractStyledTextCellEditor#activateCell(org.eclipse.swt.widgets.Composite, java.lang.Object)
	 *
	 * @param parent
	 * @param originalCanonicalValue
	 * @return
	 */
	@Override
	protected Control activateCell(Composite parent, Object originalCanonicalValue) {
		this.helper = createNameResolutionHelper();
		parser = new StringResolutionProblemPapyrusConverter(new UMLReferenceConverter(this.helper, isMultiValued));
		setPapyrusConverter(parser);
		return super.activateCell(parent, originalCanonicalValue);
	}

	/**
	 * 
	 * @param parser
	 *            the parser to use to find the references
	 */
	private void setPapyrusConverter(IPapyrusConverter parser) {
		if (this.displayConverter instanceof ISetPapyrusConverter) {
			((ISetPapyrusConverter) this.displayConverter).setPapyrusConverter(parser);
		}
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public Control getEditorControl() {
		return super.getEditorControl();
	}

	/**
	 * 
	 * @param parent
	 * @param style
	 * @return
	 */
	@Override
	protected StyledText createStyledText(Composite parent, int style) {
		this.textCompletion = new StringEditorWithCompletionWrapper(parent, this.parser);
		return this.textCompletion.getTextViewer().getTextWidget();
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.AbstractStyledTextCellEditor#keyPressed(org.eclipse.swt.events.KeyEvent)
	 *
	 * @param event
	 */
	@Override
	public void keyPressed(KeyEvent event) {
		if (isMultiValued && textCompletion.isContentAssistOpened()) {
			return;
		}
		super.keyPressed(event);
	}


	/**
	 * 
	 * @return
	 *         the created name resolution helper
	 */
	protected INameResolutionHelper createNameResolutionHelper() {
		CrossAxisWrapper<EObject, EStructuralFeature> editedElement = UMLTableUtils.getRealEditedObject(layerCell, elementProvider);
		EObject element = editedElement.getFirstAxis();
		Element scope;
		if (element instanceof Element) {
			scope = (Element) element;
		} else {
			// it could be a stereotype application
			scope = org.eclipse.uml2.uml.util.UMLUtil.getBaseElement(element);
		}

		EStructuralFeature feature = editedElement.getSecondAxis();
		EClassifier eType = feature.getEType();
		if (eType instanceof EClass) {
			INameResolutionHelper helper = new NameResolutionHelper(scope, (EClass) eType);
			return helper;
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.AbstractCellEditor#getCanonicalValue(org.eclipse.nebula.widgets.nattable.edit.editor.IEditErrorHandler)
	 *
	 * @param conversionErrorHandler
	 * @return
	 */
	@Override
	public Object getCanonicalValue(IEditErrorHandler conversionErrorHandler) {
		Object canonnicalValue = super.getCanonicalValue(conversionErrorHandler);
		if (canonnicalValue instanceof Collection<?>) {
			return canonnicalValue;
		}
		if (isMultiValued) {
			Collection<Object> coll = new ArrayList<Object>();
			coll.add(canonnicalValue);
			return coll;
		} else {
			return canonnicalValue;
		}
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.AbstractCellEditor#getCanonicalValue()
	 *
	 * @return
	 */
	@Override
	public Object getCanonicalValue() {
		return super.getCanonicalValue();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.AbstractStyledTextCellEditor#close()
	 *
	 */
	@Override
	public void close() {
		this.textCompletion.getTextWidget().dispose();
		super.close();
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.AbstractPapyrusStyledTextCellEditor#getEditedEObject()
	 *
	 * @return
	 */
	protected EObject getEditedEObject() {
		return null;
	}
}

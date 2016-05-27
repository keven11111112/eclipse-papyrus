/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.dd.dg.presentation;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.dd.dg.Definition;
import org.eclipse.papyrus.dd.dg.RootCanvas;
import org.eclipse.papyrus.dd.dg.util.DGSwitch;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * This class converts a DG model resource into a SVG document
 */
public class DGToSVGConverter extends DGSwitch<Object> {

	/**
	 * This is the CSS background-color property
	 */
	public static final String SVG_BACKGROUND_COLOR_ATTRIBUTE = "background-color";

	/**
	 * This is the CSS text-decoration property
	 */
	public static final String SVG_TEXT_DECORATION_ATTRIBUTE = "text-decoration";

	/**
	 * This is the CSS marker-start property
	 */
	public static final String SVG_MARKER_START_ATTRIBUTE = "marker-start";

	/**
	 * This is the CSS marker-mid property
	 */
	public static final String SVG_MARKER_MID_ATTRIBUTE = "marker-mid";

	/**
	 * This is the CSS marker-end property
	 */
	public static final String SVG_MARKER_END_ATTRIBUTE = "marker-end";

	/**
	 * This is the layout property
	 */
	public static final String SVG_LAYOUT_ATTRIBUTE = "layout";

	/**
	 * This is the layout data property
	 */
	public static final String SVG_LAYOUT_DATA_ATTRIBUTE = "layoutData";

	/**
	 * This is the DG model resource
	 */
	private Resource resource;

	/**
	 * This is the created SVG document
	 */
	private Document svgDocument;

	/**
	 * This is a cache used in the conversion process
	 */
	private Map<EObject, Object> cache = new HashMap<EObject, Object>();

	/**
	 * Constructs a new DG to SVG converter instance
	 */
	public DGToSVGConverter() {
		super();
	}

	/**
	 * Converts a given DG model resource to a corresponding SVG document
	 * 
	 * @param resource
	 *        The DG model resource
	 * @return The SVG document
	 */
	public Document convert(RootCanvas canvas) {
		if(canvas == null)
			return null;
		// set the DG model resource
		this.resource = canvas.eResource();
		// create a new SVG document
		final DOMImplementation impl = getDOMImplementation();
		// svgDocument = (Document)impl.createDocument(SVG_NAMESPACE_URI, SVG_SVG_TAG, null);
		// establish a base URL for the SVG document to resolve relative links
		svgDocument.setDocumentURI(resource.getURI().toString());
		// iterate over all contents and convert them
		for(TreeIterator<EObject> iterator = canvas.eAllContents(); iterator.hasNext();)
			doSwitch(iterator.next());
		return svgDocument;
	}

	/**
	 * @return an instance of the DOM Implementation
	 */
	protected DOMImplementation getDOMImplementation() {
		return null;
//		return SVGDOMImplementation.getDOMImplementation();
	}

	/**
	 * Converts a <code>Color</code> to a string
	 * 
	 * @param c
	 *        The color to convert
	 * @return The string encoding of the color
	 */
	protected String convertColorToString(Color c) {
		return String.format("#%02X%02X%02X", c.getRed(), c.getGreen(), c.getBlue());
	}

	/**
	 * Converts a <code>Double</code> to a string
	 * 
	 * @param d
	 *        The double value
	 * @return The string encoding of the double
	 */
	protected String convertDoubleToString(Double d) {
		return String.valueOf(d);
	}

	/**
	 * Converts a <code>Reference</code> to a URI string
	 * 
	 * @param reference
	 *        The EObject reference
	 * @return The URI encoding of the reference
	 */
	protected String convertReferenceToURI(Definition referenced) {
		Resource referencedResource = referenced.eResource();
		URI uri = referencedResource.getURI();
		String uriFragment = referenced.getId();
		if(resource.equals(referencedResource))
			return '#' + uriFragment;
		return uri.appendFragment(uriFragment).toString();
	}

	/**
	 * Converts a <code>Reference</code> to a URL string
	 * 
	 * @param reference
	 *        The EObject reference
	 * @return The URL encoding of the reference
	 */
	protected String convertReferenceToURL(Definition reference) {
		return "url(" + convertReferenceToURI(reference) + ")";
	}

	/**
	 * Stores in the cache a mapping from theEObject to object
	 * 
	 * @param theEObject
	 *        The key of the mapping
	 * @param object
	 *        The value of the mapping
	 * @return the value of the mapping
	 */
	protected <S> S map(EObject theEObject, S object) {
		cache.put(theEObject, object);
		return object;
	}

	/**
	 * Looks up in the cache a mapping from theEObject to object
	 * 
	 * @param theEObject
	 *        The key of the mapping
	 * @return the value of the mapping
	 */
	protected Object lookup(EObject theEObject) {
		return cache.get(theEObject);
	}

	/**
	 * Get the SVG parent element that corresponds to the given DG child element
	 * 
	 * @param member
	 *        The child element
	 * @return The parent element
	 */
	protected Element getParentElement(EObject child) {
		return (Element)doSwitch(child.eContainer());
	}

	@Override
	public Object doSwitch(EObject theEObject) {
		Object value;
		if(cache.containsKey(theEObject))
			value = cache.get(theEObject);
		else
			value = super.doSwitch(theEObject);
		return (value instanceof StringBuffer) ? value.toString() : value;
	}

	@Override
	public Object defaultCase(EObject object) {
		return cache.get(object);
	}

	
}

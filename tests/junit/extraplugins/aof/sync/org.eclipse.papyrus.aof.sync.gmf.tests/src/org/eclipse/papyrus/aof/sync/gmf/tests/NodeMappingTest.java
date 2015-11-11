/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.aof.sync.gmf.tests;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.DescriptionStyle;
import org.eclipse.gmf.runtime.notation.ImageStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.papyrus.aof.sync.gmf.internal.NodeMapping;
import org.junit.Test;

/**
 * Test cases for the {@link NodeMapping} class.
 */
public class NodeMappingTest extends AbstractMappingTest<Node> {

	public NodeMappingTest() {
		super();
	}

	@Test
	public void mapElement() {
		assertFeature(NotationPackage.Literals.VIEW__ELEMENT,
				EcorePackage.Literals.EMODEL_ELEMENT,
				EcorePackage.Literals.EATTRIBUTE);
	}

	@Test
	public void mapChildren() {
		EStructuralFeature feature = NotationPackage.Literals.VIEW__PERSISTED_CHILDREN;

		List<Node> children = Arrays.asList(
				createAttrNode(EcorePackage.Literals.EDATA_TYPE__SERIALIZABLE),
				createAttrNode(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME));

		assumeThat(getFrom().eGet(feature), is(Collections.EMPTY_LIST));
		assumeThat(getTo().eGet(feature), is(getFrom().eGet(feature)));

		getFrom().eSet(feature, children);

		@SuppressWarnings("unchecked")
		List<Node> toChildren = (List<Node>) getTo().eGet(feature);
		assertThat(toChildren.size(), is(2));
		assertThat(toChildren.get(0).getType(), is("3001"));
		assertThat(toChildren.get(0).getElement(), is(EcorePackage.Literals.EDATA_TYPE__SERIALIZABLE));
		assertThat(toChildren.get(1).getType(), is("3001"));
		assertThat(toChildren.get(1).getElement(), is(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME));

		// But, they are not actually the same nodes!
		assertThat(toChildren, not(children));

		// The reverse direction does not sync

		toChildren.add(createAttrNode(EcorePackage.Literals.ECLASSIFIER__DEFAULT_VALUE));

		assertThat(getFrom().eGet(feature), is(children));
	}

	Node createAttrNode(EObject element) {
		Node result = notation.createNode();
		result.setType("3001");
		result.setElement(element);
		result.setLayoutConstraint(notation.createBounds());
		return result;
	}

	@Test
	public void mapLocation() {
		Location fromLoc = (Location) getFrom().getLayoutConstraint();
		Location toLoc = (Location) getTo().getLayoutConstraint();

		// Not the same object
		assertThat(toLoc, not(fromLoc));

		// Don't override target side first time because that breaks synchronization for the other
		assertFeature(fromLoc, toLoc, NotationPackage.Literals.LOCATION__X, 42, null);
		assertFeature(fromLoc, toLoc, NotationPackage.Literals.LOCATION__Y, 42, 17);
	}

	@Test
	public void mapSize() {
		Size fromSize = (Size) getFrom().getLayoutConstraint();
		Size toSize = (Size) getTo().getLayoutConstraint();

		// Not the same object
		assertThat(toSize, not(fromSize));

		// Don't override target side first time because that breaks synchronization for the other
		assertFeature(fromSize, toSize, NotationPackage.Literals.SIZE__WIDTH, 42, null);
		assertFeature(fromSize, toSize, NotationPackage.Literals.SIZE__HEIGHT, 42, 17);
	}

	@Test
	public void breakSyncOnLocationOverride() {
		Location fromLoc = (Location) getFrom().getLayoutConstraint();
		Location toLoc = (Location) getTo().getLayoutConstraint();
		Size fromSize = (Size) getFrom().getLayoutConstraint();
		Size toSize = (Size) getTo().getLayoutConstraint();

		// Not the same object
		assertThat(toLoc, not(fromLoc));

		// This first one overrides the target side, breaking synchronization
		assertFeature(fromLoc, toLoc, NotationPackage.Literals.LOCATION__X, 42, 17);
		assertNotFeature(fromLoc, toLoc, NotationPackage.Literals.LOCATION__Y, 42);
		assertNotFeature(fromSize, toSize, NotationPackage.Literals.SIZE__WIDTH, 42);
		assertNotFeature(fromSize, toSize, NotationPackage.Literals.SIZE__HEIGHT, 42);
	}

	@Test
	public void breakSyncOnSizeOverride() {
		Size fromSize = (Size) getFrom().getLayoutConstraint();
		Size toSize = (Size) getTo().getLayoutConstraint();
		Location fromLoc = (Location) getFrom().getLayoutConstraint();
		Location toLoc = (Location) getTo().getLayoutConstraint();

		// Not the same object
		assertThat(toSize, not(fromSize));

		// This first one overrides the target side, breaking synchronization
		assertFeature(fromSize, toSize, NotationPackage.Literals.SIZE__WIDTH, 42, 17);
		assertNotFeature(fromSize, toSize, NotationPackage.Literals.SIZE__HEIGHT, 42);
		assertNotFeature(fromLoc, toLoc, NotationPackage.Literals.LOCATION__X, 42);
		assertNotFeature(fromLoc, toLoc, NotationPackage.Literals.LOCATION__Y, 42);
	}

	@Test
	public void mapInheritedStyleAttributes() {
		assertFeature(NotationPackage.Literals.FONT_STYLE__FONT_NAME, "Garamond", "Futura");
		assertFeature(NotationPackage.Literals.FONT_STYLE__FONT_HEIGHT, 10, 18);
	}

	@Test
	public void mapAttachedDiscreteStyles() {
		EStructuralFeature feature = NotationPackage.Literals.VIEW__STYLES;

		CanonicalStyle fromCanonicalStyle = notation.createCanonicalStyle();
		fromCanonicalStyle.setCanonical(false);
		ImageStyle fromImageStyle = notation.createImageStyle();
		fromImageStyle.setMaintainAspectRatio(false);

		List<Style> styles = Arrays.asList(fromCanonicalStyle, fromImageStyle);

		assumeThat(getFrom().eGet(feature), is(Collections.EMPTY_LIST));
		assumeThat(getTo().eGet(feature), is(getFrom().eGet(feature)));

		getFrom().eSet(feature, styles);

		@SuppressWarnings("unchecked")
		List<Style> toStyles = (List<Style>) getTo().eGet(feature);
		assertThat(toStyles.size(), is(2));
		assertThat(toStyles.get(0), instanceOf(CanonicalStyle.class));
		assertThat(((CanonicalStyle) toStyles.get(0)).isCanonical(), is(false));
		assertThat(toStyles.get(1), instanceOf(ImageStyle.class));
		assertThat(((ImageStyle) toStyles.get(1)).getMaintainAspectRatio(), is(false));

		// But, they are not actually the same style instances!
		assertThat(toStyles, not(styles));

		// The reverse direction does not sync

		toStyles.add(notation.createFilteringStyle());

		assertThat(getFrom().eGet(feature), is(styles));
	}

	@Test
	public void ignoreAttachedNamedStyles() {
		EStructuralFeature feature = NotationPackage.Literals.VIEW__STYLES;

		CanonicalStyle fromCanonicalStyle = notation.createCanonicalStyle();
		fromCanonicalStyle.setCanonical(false);
		BooleanValueStyle okStyle = notation.createBooleanValueStyle();
		okStyle.setName("ok");
		okStyle.setBooleanValue(true);
		ImageStyle fromImageStyle = notation.createImageStyle();
		fromImageStyle.setMaintainAspectRatio(false);

		List<Style> styles = Arrays.asList(fromCanonicalStyle, okStyle, fromImageStyle);

		assumeThat(getFrom().eGet(feature), is(Collections.EMPTY_LIST));
		assumeThat(getTo().eGet(feature), is(getFrom().eGet(feature)));

		getFrom().eSet(feature, styles);

		// The named style is invisible to synchronization
		@SuppressWarnings("unchecked")
		List<Style> toStyles = (List<Style>) getTo().eGet(feature);
		assertThat(toStyles.size(), is(2));
		assertThat(toStyles.get(0), instanceOf(CanonicalStyle.class));
		assertThat(toStyles.get(1), instanceOf(ImageStyle.class));

		// Add a named style to the target
		getTo().createStyle(NotationPackage.Literals.STRING_VALUE_STYLE);

		// Because named styles are invisible, they don't stop forward synchronization
		((DescriptionStyle) getFrom().createStyle(NotationPackage.Literals.DESCRIPTION_STYLE)).setDescription("This is a test");
		assertThat(toStyles.size(), is(4));
		// The new style is inserted after the last that is visible to synchronization
		assertThat(toStyles.get(2), instanceOf(DescriptionStyle.class));
		assertThat(((DescriptionStyle) toStyles.get(2)).getDescription(), is("This is a test"));
	}
}

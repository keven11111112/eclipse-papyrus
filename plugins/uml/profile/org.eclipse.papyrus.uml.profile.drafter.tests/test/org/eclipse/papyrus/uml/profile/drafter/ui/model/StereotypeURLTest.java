/*****************************************************************************
 * Copyright (c) 2014 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.profile.drafter.ui.model;

import static org.junit.Assert.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class StereotypeURLTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#StereotypeURL()}.
	 */
	@Test
	public void testStereotypeURL() {
		
		StereotypeURL url = new StereotypeURL();
		assertNotNull("url created", url);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#StereotypeURL(String)}.
	 */
	@Test
	public void testStereotypeURLString() {
		
		String stereotypeName = "Town";
		StereotypeURL url = new StereotypeURL(stereotypeName);
		assertNotNull("url created", url);
		assertNotNull("stereotype set", url.getStereotypeName());
		assertNotNull("qualifiedName set", url.getQualifiedName());
		assertEquals("stereotype set", stereotypeName, url.getStereotypeName());
		assertEquals("qualifiedName set", stereotypeName, url.getQualifiedName());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#StereotypeURL(String)}.
	 */
	@Test
	public void testStereotypeURLStringString() {
		
		String profileName = "profile";
		String stereotypeName = "Town";
		StereotypeURL url = new StereotypeURL(profileName, stereotypeName);
		assertNotNull("url created", url);
		assertNotNull("stereotype set", url.getStereotypeName());
		assertNotNull("qualifiedName set", url.getQualifiedName());
		
		assertEquals("stereotype set", stereotypeName, url.getStereotypeName());
		assertEquals("qualifiedName set", profileName + "::" + stereotypeName, url.getQualifiedName());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#getQualifiedName()}.
	 */
	@Test
	public void testGetQualifiedName() {
		String qualifiedName = "Town";
		StereotypeURL url = new StereotypeURL();
		url.setQualifiedName(qualifiedName);
		
		assertNotNull("stereotype set", url.getStereotypeName());
		assertNotNull("qualifiedName set", url.getQualifiedName());
		assertEquals("stereotype set", qualifiedName, url.getStereotypeName());
		assertEquals("qualifiedName set", qualifiedName, url.getQualifiedName());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#setQualifiedName(java.lang.String)}.
	 */
	@Test
	public void testSetQualifiedNameComplex() {
		String profileName = "profile";
		String stereotypeName = "Town";
		String qualifiedName = profileName + "::" + stereotypeName;
		StereotypeURL url = new StereotypeURL();
		
		url.setQualifiedName(qualifiedName);
		
		assertNotNull("stereotype set", url.getStereotypeName());
		assertNotNull("qualifiedName set", url.getQualifiedName());
		assertEquals("stereotype set", stereotypeName, url.getStereotypeName());
		assertEquals("qualifiedName set", qualifiedName, url.getQualifiedName());
		assertEquals("path set", 1, url.getProfileNames().size());
		assertEquals("paths", profileName, url.getProfileNames().get(0) );
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#setQualifiedName(java.lang.String)}.
	 */
	@Test
	public void testSetQualifiedNameSimple() {
		String qualifiedName = "Town";
		StereotypeURL url = new StereotypeURL();
		url.setQualifiedName(qualifiedName);
		
		assertNotNull("stereotype set", url.getStereotypeName());
		assertNotNull("qualifiedName set", url.getQualifiedName());
		assertEquals("stereotype set", qualifiedName, url.getStereotypeName());
		assertEquals("qualifiedName set", qualifiedName, url.getQualifiedName());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#clear()}.
	 */
	@Test
	public void testClear() {
		String profileName = "profile";
		String stereotypeName = "Town";
		StereotypeURL url = new StereotypeURL(profileName, stereotypeName);
		
		url.clear();
		
		assertNull("stereotype set", url.getStereotypeName());
		assertNull("qualifiedName set", url.getQualifiedName());
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#getStereotypeName()}.
	 */
	@Test
	public void testGetStereotypeName() {
		String stereotypeName = "Town";
		StereotypeURL url = new StereotypeURL();
		url.setStereotypeName(stereotypeName);
		
		assertNotNull("stereotype set", url.getStereotypeName());
		assertNotNull("qualifiedName set", url.getQualifiedName());
		assertEquals("stereotype set", stereotypeName, url.getStereotypeName());
		assertEquals("qualifiedName set", stereotypeName, url.getQualifiedName());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#setStereotypeName(java.lang.String)}.
	 */
	@Test
	public void testSetStereotypeName() {
		String stereotypeName = "Town";
		StereotypeURL url = new StereotypeURL();
		url.setStereotypeName(stereotypeName);
		
		assertNotNull("stereotype set", url.getStereotypeName());
		assertNotNull("qualifiedName set", url.getQualifiedName());
		assertEquals("stereotype set", stereotypeName, url.getStereotypeName());
		assertEquals("qualifiedName set", stereotypeName, url.getQualifiedName());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#getProfileNames()}.
	 */
	@Test
	public void testGetProfileNames() {
		String profile1 = "profile1";
		String profile2 = "profile2";
		String profile3 = "profile3";
		String profileNames = profile1 + "::" + profile2 + "::"+ profile3;
		String stereotypeName = "Town";
		String qualifiedName = profileNames + "::" + stereotypeName;
		StereotypeURL url = new StereotypeURL();
		
		url.setQualifiedName(qualifiedName);
		
		assertNotNull("stereotype set", url.getStereotypeName());
		assertNotNull("qualifiedName set", url.getQualifiedName());
		assertEquals("stereotype set", stereotypeName, url.getStereotypeName());
		assertEquals("qualifiedName set", qualifiedName, url.getQualifiedName());
		assertEquals("path set", 3, url.getProfileNames().size());
		int index = 0;
		assertEquals("paths", profile1, url.getProfileNames().get(index++) );
		assertEquals("paths", profile2, url.getProfileNames().get(index++) );
		assertEquals("paths", profile3, url.getProfileNames().get(index++) );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#addProfilePath(java.lang.String)}.
	 */
	@Test
	public void testAddProfilePath() {
		String profile1 = "profile1";
		String profile2 = "profile2";
		String profile3 = "profile3";
		String profileNames = profile1 + "::" + profile2 ;
		String stereotypeName = "Town";
		String qualifiedName = profileNames + "::" + stereotypeName;
		String expectedQualifiedName = profileNames + "::" + profile3 + "::" + stereotypeName;
		StereotypeURL url = new StereotypeURL();
		
		url.setQualifiedName(qualifiedName);
		url.addProfilePath(profile3);
		
		assertNotNull("stereotype set", url.getStereotypeName());
		assertNotNull("qualifiedName set", url.getQualifiedName());
		assertEquals("stereotype set", stereotypeName, url.getStereotypeName());
		assertEquals("qualifiedName set", expectedQualifiedName, url.getQualifiedName());
		assertEquals("path set", 3, url.getProfileNames().size());
		int index = 0;
		assertEquals("paths", profile1, url.getProfileNames().get(index++) );
		assertEquals("paths", profile2, url.getProfileNames().get(index++) );
		assertEquals("paths", profile3, url.getProfileNames().get(index++) );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#setProfilePath(int, java.lang.String)}.
	 */
	@Test
	public void testSetProfilePath() {
		String profile1 = "profile1";
		String profile2 = "profile2";
		String profile3 = "profile3";
		String profile4 = "profile4";
		String profileNames = profile1 + "::" + profile2+ "::" + profile3 ;
		String stereotypeName = "Town";
		String qualifiedName = profileNames + "::" + stereotypeName;
		String expectedQualifiedName = profile1 + "::" + profile2+ "::" + profile4 + "::" + stereotypeName;
		StereotypeURL url = new StereotypeURL();
		
		url.setQualifiedName(qualifiedName);
		url.setProfilePath(2, profile4);
		
		assertNotNull("stereotype set", url.getStereotypeName());
		assertNotNull("qualifiedName set", url.getQualifiedName());
		assertEquals("stereotype set", stereotypeName, url.getStereotypeName());
		assertEquals("qualifiedName set", expectedQualifiedName, url.getQualifiedName());
		assertEquals("path set", 3, url.getProfileNames().size());
		int index = 0;
		assertEquals("paths", profile1, url.getProfileNames().get(index++) );
		assertEquals("paths", profile2, url.getProfileNames().get(index++) );
		assertEquals("paths", profile4, url.getProfileNames().get(index++) );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#computeQualifiedName()}.
	 */
	@Test
	public void testComputeQualifiedName() {
		String profileName = "profile";
		String stereotypeName = "Town";
		String qualifiedName = profileName + "::" + stereotypeName;
		StereotypeURL url = new StereotypeURL();
		
		url.setQualifiedName(qualifiedName);
		
		assertEquals("stereotype set", qualifiedName, url.computeQualifiedName());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#toString()}.
	 */
	@Test
	public void testToString() {
		String profileName = "profile";
		String stereotypeName = "Town";
		String qualifiedName = profileName + "::" + stereotypeName;
		StereotypeURL url = new StereotypeURL();
		
		url.setQualifiedName(qualifiedName);
		
		assertEquals("stereotype set", qualifiedName, url.toString());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#addPropertyChangeListener(java.beans.PropertyChangeListener)}.
	 */
	@Test
	public void testAddPropertyChangeListenerPropertyChangeListener() {
		
		PropertyChangeListener listener = new DummyPropertyChangeListener();
		
		StereotypeURL url = new StereotypeURL();

		url.addPropertyChangeListener(listener);
		
		assertEquals("listener added to list", 1, url.getChangeSupport().getPropertyChangeListeners().length);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#removePropertyChangeListener(java.beans.PropertyChangeListener)}.
	 */
	@Test
	public void testRemovePropertyChangeListenerPropertyChangeListener() {
		PropertyChangeListener listener = new DummyPropertyChangeListener();
		
		StereotypeURL url = new StereotypeURL();

		url.addPropertyChangeListener(listener);
		url.removePropertyChangeListener(listener);
		
		assertEquals("listener added to list", 0, url.getChangeSupport().getPropertyChangeListeners().length);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#addPropertyChangeListener(java.lang.String, java.beans.PropertyChangeListener)}.
	 */
	@Test
	public void testAddPropertyChangeListenerStringPropertyChangeListener() {
		PropertyChangeListener listener = new DummyPropertyChangeListener();
		
		StereotypeURL url = new StereotypeURL();

		url.addPropertyChangeListener(StereotypeURL.QUALIFIED_NAME, listener);
		
		assertEquals("listener added to list", 1, url.getChangeSupport().getPropertyChangeListeners().length);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.uml.profile.drafter.ui.model.StereotypeURL#removePropertyChangeListener(java.lang.String, java.beans.PropertyChangeListener)}.
	 */
	@Test
	public void testRemovePropertyChangeListenerStringPropertyChangeListener() {
		PropertyChangeListener listener = new DummyPropertyChangeListener();
		
		StereotypeURL url = new StereotypeURL();

		url.addPropertyChangeListener(StereotypeURL.QUALIFIED_NAME, listener);
		url.removePropertyChangeListener(StereotypeURL.QUALIFIED_NAME, listener);
		
		assertEquals("listener added to list", 0, url.getChangeSupport().getPropertyChangeListeners().length);
	}

	/**
	 * Fake listener for tests.
	 *
	 */
	public class DummyPropertyChangeListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			
		}
		
	}
}

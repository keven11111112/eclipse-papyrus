/*******************************************************************************
 *  Copyright (c) 2015 ESEO, Christian W. Damus, and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *     Christian W. Damus - bug 476683
 *******************************************************************************/
package org.eclipse.papyrus.aof.core.tests.population;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Person2 {

	private String name;

	private int age;

	private LinkedHashSet<String> emails = new LinkedHashSet<>();

	private Person2 parent;

	private Set<Person2> children = new HashSet<>();

	private List<Integer> lockerCombination = new ArrayList<>();

	public Person2() {
		this(null);
	}

	public Person2(String name) {
		super();

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LinkedHashSet<String> getEmails() {
		return emails;
	}

	public boolean isAddressable() {
		return !getEmails().isEmpty();
	}

	public Person2 getParent() {
		return parent;
	}

	public void setParent(Person2 parent) {
		this.parent = parent;
	}

	public Set<Person2> getChildren() {
		return children;
	}

	public List<Integer> getLockerCombination() {
		return lockerCombination;
	}

	@Override
	public String toString() {
		return (name == null) ? "<Person>" : name;
	}

}

/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */

package org.eclipse.papyrus.infra.emf.expressions.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.EObjectBooleanExpressionsFactory;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.LiteralFalseExpression;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.LiteralTrueExpression;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.OrExpression;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author VL222926
 *
 */
public class OrExpressionTests {

	private EObject dummyObject = EcoreFactory.eINSTANCE.createEClass();

	/**
	 * {@link OrExpression} must return <code>false</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li>not <code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>empty</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>empty</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test1() {
		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		Assert.assertFalse(orExp.evaluate(this.dummyObject));
	}

	/**
	 * {@link OrExpression} must return <code>false</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li><code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>empty</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>empty</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test2() {
		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		Assert.assertFalse(orExp.evaluate(null));
	}

	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li>not <code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>empty</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test3() {
		final LiteralTrueExpression ownedTrueExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(ownedTrueExp);
		Assert.assertTrue(orExp.evaluate(this.dummyObject));
	}

	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li><code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>empty</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test4() {
		final LiteralTrueExpression ownedTrueExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(ownedTrueExp);
		Assert.assertTrue(orExp.evaluate(null));
	}

	/**
	 * {@link OrExpression} must return <code>false</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li>not <code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>empty</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test5() {
		final LiteralFalseExpression ownedFalseExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(ownedFalseExp);
		Assert.assertFalse(orExp.evaluate(this.dummyObject));
	}

	/**
	 * {@link OrExpression} must return <code>false</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li><code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li> 
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>empty</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test6() {
		final LiteralFalseExpression ownedFalseExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(ownedFalseExp);
		Assert.assertFalse(orExp.evaluate(null));
	}


	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li>not <code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test7() {
		final LiteralTrueExpression ownedTrueExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression refTrueExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(ownedTrueExp);
		orExp.getReferencedExpressions().add(refTrueExp);
		Assert.assertTrue(orExp.evaluate(this.dummyObject));
	}

	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li><code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test8() {
		final LiteralTrueExpression ownedTrueExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression refTrueExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(ownedTrueExp);
		orExp.getReferencedExpressions().add(refTrueExp);
		Assert.assertTrue(orExp.evaluate(null));
	}


	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li>not <code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test9() {
		final LiteralFalseExpression ownedFalseExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralTrueExpression refTrueExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(ownedFalseExp);
		orExp.getReferencedExpressions().add(refTrueExp);
		Assert.assertTrue(orExp.evaluate(this.dummyObject));
	}

	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li><code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test10() {
		final LiteralFalseExpression ownedFalseExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralTrueExpression refTrueExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(ownedFalseExp);
		orExp.getReferencedExpressions().add(refTrueExp);
		Assert.assertTrue(orExp.evaluate(null));
	}

	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li>not <code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test11() {
		final LiteralTrueExpression ownedTrueExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralFalseExpression refFalseExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(ownedTrueExp);
		orExp.getReferencedExpressions().add(refFalseExp);
		Assert.assertTrue(orExp.evaluate(this.dummyObject));
	}

	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li><code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test12() {
		final LiteralTrueExpression ownedTrueExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralFalseExpression refFalseExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(ownedTrueExp);
		orExp.getReferencedExpressions().add(refFalseExp);
		Assert.assertTrue(orExp.evaluate(null));
	}



	/**
	 * {@link OrExpression} must return <code>false</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li>not <code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test13() {
		final LiteralFalseExpression refFalseExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralFalseExpression ownedFalseExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(ownedFalseExp);
		orExp.getReferencedExpressions().add(refFalseExp);
		Assert.assertFalse(orExp.evaluate(this.dummyObject));
	}

	/**
	 * {@link OrExpression} must return <code>false</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li><code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test14() {
		final LiteralFalseExpression refFalseExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralFalseExpression ownedFalseExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(ownedFalseExp);
		orExp.getReferencedExpressions().add(refFalseExp);
		Assert.assertFalse(orExp.evaluate(null));
	}

	// ----Tests with 2 owned or 2 referenced expressions-----


	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li>not <code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test15() {
		final LiteralTrueExpression firstOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression secondOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression firstRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression secondRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();

		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(firstOwnedExp);
		orExp.getOwnedExpressions().add(secondOwnedExp);
		orExp.getReferencedExpressions().add(firstRefExp);
		orExp.getReferencedExpressions().add(secondRefExp);

		Assert.assertTrue(orExp.evaluate(this.dummyObject));
	}

	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li><code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test16() {
		final LiteralTrueExpression firstOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression secondOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression firstRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression secondRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();

		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(firstOwnedExp);
		orExp.getOwnedExpressions().add(secondOwnedExp);
		orExp.getReferencedExpressions().add(firstRefExp);
		orExp.getReferencedExpressions().add(secondRefExp);

		Assert.assertTrue(orExp.evaluate(null));
	}


	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li>not <code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test17() {
		final LiteralFalseExpression firstOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralTrueExpression secondOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression firstRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression secondRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();

		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(firstOwnedExp);
		orExp.getOwnedExpressions().add(secondOwnedExp);
		orExp.getReferencedExpressions().add(firstRefExp);
		orExp.getReferencedExpressions().add(secondRefExp);

		Assert.assertTrue(orExp.evaluate(this.dummyObject));
	}

	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li><code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test18() {
		final LiteralFalseExpression firstOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralTrueExpression secondOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression firstRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression secondRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();

		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(firstOwnedExp);
		orExp.getOwnedExpressions().add(secondOwnedExp);
		orExp.getReferencedExpressions().add(firstRefExp);
		orExp.getReferencedExpressions().add(secondRefExp);

		Assert.assertTrue(orExp.evaluate(null));
	}

	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li>not <code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test19() {
		final LiteralTrueExpression firstOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralFalseExpression secondOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralTrueExpression firstRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression secondRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();

		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(firstOwnedExp);
		orExp.getOwnedExpressions().add(secondOwnedExp);
		orExp.getReferencedExpressions().add(firstRefExp);
		orExp.getReferencedExpressions().add(secondRefExp);

		Assert.assertTrue(orExp.evaluate(this.dummyObject));
	}

	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li><code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test20() {
		final LiteralTrueExpression firstOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralFalseExpression secondOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralTrueExpression firstRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression secondRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();

		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(firstOwnedExp);
		orExp.getOwnedExpressions().add(secondOwnedExp);
		orExp.getReferencedExpressions().add(firstRefExp);
		orExp.getReferencedExpressions().add(secondRefExp);

		Assert.assertTrue(orExp.evaluate(null));
	}


	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li>not <code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test21() {
		final LiteralTrueExpression firstOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression secondOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralFalseExpression firstRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralTrueExpression secondRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();

		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(firstOwnedExp);
		orExp.getOwnedExpressions().add(secondOwnedExp);
		orExp.getReferencedExpressions().add(firstRefExp);
		orExp.getReferencedExpressions().add(secondRefExp);

		Assert.assertTrue(orExp.evaluate(this.dummyObject));
	}


	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li><code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test22() {
		final LiteralTrueExpression firstOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression secondOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralFalseExpression firstRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralTrueExpression secondRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();

		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(firstOwnedExp);
		orExp.getOwnedExpressions().add(secondOwnedExp);
		orExp.getReferencedExpressions().add(firstRefExp);
		orExp.getReferencedExpressions().add(secondRefExp);

		Assert.assertTrue(orExp.evaluate(null));
	}


	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li>not <code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test23() {
		final LiteralTrueExpression firstOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression secondOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression firstRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralFalseExpression secondRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();

		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(firstOwnedExp);
		orExp.getOwnedExpressions().add(secondOwnedExp);
		orExp.getReferencedExpressions().add(firstRefExp);
		orExp.getReferencedExpressions().add(secondRefExp);

		Assert.assertTrue(orExp.evaluate(this.dummyObject));
	}


	/**
	 * {@link OrExpression} must return <code>true</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li><code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralTrueExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralTrueExpression}</li>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test24() {
		final LiteralTrueExpression firstOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression secondOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralTrueExpression firstRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression();
		final LiteralFalseExpression secondRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();

		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(firstOwnedExp);
		orExp.getOwnedExpressions().add(secondOwnedExp);
		orExp.getReferencedExpressions().add(firstRefExp);
		orExp.getReferencedExpressions().add(secondRefExp);

		Assert.assertTrue(orExp.evaluate(null));
	}
	
	/**
	 * {@link OrExpression} must return <code>false</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li>not <code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test25() {
		final LiteralFalseExpression firstOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralFalseExpression secondOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralFalseExpression firstRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralFalseExpression secondRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();

		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(firstOwnedExp);
		orExp.getOwnedExpressions().add(secondOwnedExp);
		orExp.getReferencedExpressions().add(firstRefExp);
		orExp.getReferencedExpressions().add(secondRefExp);

		Assert.assertFalse(orExp.evaluate(this.dummyObject));
	}

	/**
	 * {@link OrExpression} must return <code>false</code> when
	 * <ul>
	 * <li>object to evaluate is</li>
	 * <ul>
	 * <li><code>null</code></li>
	 * </ul>
	 * <li>ownedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * <li>referencedExpressions</li>
	 * <ul>
	 * <li>{@link LiteralFalseExpression}</li>
	 * <li>{@link LiteralFalseExpression}</li>
	 * </ul>
	 * </ul>
	 */
	@Test
	public void OrExpression_Test26() {
		final LiteralFalseExpression firstOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralFalseExpression secondOwnedExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralFalseExpression firstRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();
		final LiteralFalseExpression secondRefExp = EObjectBooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression();

		final OrExpression orExp = EObjectBooleanExpressionsFactory.eINSTANCE.createOrExpression();
		orExp.getOwnedExpressions().add(firstOwnedExp);
		orExp.getOwnedExpressions().add(secondOwnedExp);
		orExp.getReferencedExpressions().add(firstRefExp);
		orExp.getReferencedExpressions().add(secondRefExp);

		Assert.assertFalse(orExp.evaluate(null));
	}
}

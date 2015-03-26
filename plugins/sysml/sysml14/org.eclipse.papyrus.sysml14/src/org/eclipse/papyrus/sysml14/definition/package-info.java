/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

/**
 * This package is used to manually define the root of the profile 
 * since emfgen is not able to generate element for empty package/profile
 * (The only other solution is to use a <<Dummy>> element, we want to avoid this solution 
 * since the profile is provided by the OMG)
 * @author Benoit Maggi (CEA LIST) benoit.maggi@cea.fr
 *
 */
package org.eclipse.papyrus.sysml14.definition;
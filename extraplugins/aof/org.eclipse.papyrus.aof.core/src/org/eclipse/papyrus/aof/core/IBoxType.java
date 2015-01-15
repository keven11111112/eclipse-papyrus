/*******************************************************************************
 *  Copyright (c) 2015 ESEO.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.aof.core;

import org.eclipse.papyrus.aof.core.impl.BoxType;

// TODO to be replaced by Java metaclass Class<T> => add interfaces Ordered<T>, Unique<T>,  Optional<T>, and Singleton<T> (already here)

public interface IBoxType extends IConstrained {

	IBoxType OPTION = new BoxType(true, true, true, true);
	IBoxType ONE = new BoxType(false, true, true, true);
	IBoxType SET = new BoxType(true, false, false, true);
	IBoxType ORDERED_SET = new BoxType(true, false, true, true);
	IBoxType SEQUENCE = new BoxType(true, false, true, false);
	IBoxType BAG = new BoxType(true, false, false, false);

	boolean satisfies(IConstrained constraints);

}

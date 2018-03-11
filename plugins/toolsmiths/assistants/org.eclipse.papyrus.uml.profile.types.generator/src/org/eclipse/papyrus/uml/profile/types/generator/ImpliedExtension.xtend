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

package org.eclipse.papyrus.uml.profile.types.generator

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.Stereotype

/**
 * An analogue of the UML {@code Extension} metaclass that represents an implied metaclass extension.
 * This may be modeled in the profile either directly, via an extension, or indirectly, via an
 * inherited extension.
 */
@Data class ImpliedExtension {
    Stereotype stereotype
    Class metaclass
}

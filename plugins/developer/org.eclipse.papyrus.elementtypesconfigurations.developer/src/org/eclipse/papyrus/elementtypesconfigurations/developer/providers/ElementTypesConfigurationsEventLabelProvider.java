/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.elementtypesconfigurations.developer.providers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.ElementTypesConfigurationsEventsChain;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.ElementTypesConfigurationsEventType;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.events.IElementTypesConfigurationsEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;


public class ElementTypesConfigurationsEventLabelProvider extends org.eclipse.jface.viewers.LabelProvider implements IColorProvider {

	@Override
	public Image getImage(Object element) {

		return null;
	}

	@Override
	public String getText(Object element) {
		String result = "";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd - hh:mm:ss:SSS");
		if (element instanceof IElementTypesConfigurationsEvent) {
			calendar.setTimeInMillis(((IElementTypesConfigurationsEvent) element).getTimestamp());
			result += "[" + formater.format(calendar.getTime()) + "] " + ((IElementTypesConfigurationsEvent) element).getEventName();
		} else if (element instanceof ElementTypesConfigurationsEventsChain) {
			calendar.setTimeInMillis(((ElementTypesConfigurationsEventsChain) element).getTimestamp());
			result += "[" + formater.format(calendar.getTime()) + "] " + ((ElementTypesConfigurationsEventsChain) element).getName();
		} else if (element instanceof Map.Entry) {
			result += ((Map.Entry<?, ?>) element).getKey().toString();
		} else {
			result += element.toString();
		}
		return result;
	}

	Color yellow = new Color(Display.getCurrent(), new RGB(255, 200, 0));
	Color green = new Color(Display.getCurrent(), new RGB(0, 128, 0));
	Color red = new Color(Display.getCurrent(), new RGB(255, 0, 0));
	Color black = new Color(Display.getCurrent(), new RGB(0, 0, 0));
	Color blue = new Color(Display.getCurrent(), new RGB(0, 0, 255));


	/**
	 * @see org.eclipse.jface.viewers.IColorProvider#getForeground(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public Color getForeground(Object element) {
		if (element instanceof IElementTypesConfigurationsEvent) {
			if (((IElementTypesConfigurationsEvent) element).getEventType().equals(ElementTypesConfigurationsEventType.Disapproved)) {
				return red;
			} else if (((IElementTypesConfigurationsEvent) element).getEventType().equals(ElementTypesConfigurationsEventType.Unexecutable)) {
				return red;
			} else if (((IElementTypesConfigurationsEvent) element).getEventType().equals(ElementTypesConfigurationsEventType.Executable)) {
				return green;
			} else if (((IElementTypesConfigurationsEvent) element).getEventType().equals(ElementTypesConfigurationsEventType.Approved)) {
				return green;
			} else if (((IElementTypesConfigurationsEvent) element).getEventType().equals(ElementTypesConfigurationsEventType.Identity)) {
				return yellow;
			} else if (((IElementTypesConfigurationsEvent) element).getEventType().equals(ElementTypesConfigurationsEventType.RequestConfiguration)) {
				return blue;
			}
		} else if (element instanceof Map.Entry) {
			Object value = ((Map.Entry<?, ?>) element).getValue();
			if (value instanceof Collection) {
				return checkWorst((Collection<?>) value, true);
			}
		} else if (element instanceof ElementTypesConfigurationsEventsChain) {
			return checkWorst(((ElementTypesConfigurationsEventsChain) element).getAllEvents(), false);
		}
		return black;
	}

	/**
	 * @param value
	 */
	private Color checkWorst(Collection<?> value, boolean considerRequestConfiguration) {
		Color result = green;
		for (Object object : value) {
			if (((IElementTypesConfigurationsEvent) object).getEventType().equals(ElementTypesConfigurationsEventType.Disapproved)) {
				return red;
			} else if (((IElementTypesConfigurationsEvent) object).getEventType().equals(ElementTypesConfigurationsEventType.Unexecutable)) {
				return red;
			} else if (((IElementTypesConfigurationsEvent) object).getEventType().equals(ElementTypesConfigurationsEventType.Identity)) {
				if (result == green) {
					result = yellow;
				}
			} else if (((IElementTypesConfigurationsEvent) object).getEventType().equals(ElementTypesConfigurationsEventType.RequestConfiguration)) {
				if (considerRequestConfiguration) {
					if (result != yellow && result != red) {
						result = blue;
					}
				}
			}
		}
		return result;
	}

	/**
	 * @see org.eclipse.jface.viewers.IColorProvider#getBackground(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

}

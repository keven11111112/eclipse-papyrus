/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.fillhandle.utils;

/**
 * The papyrus fill handle utils.
 */
public class PapyrusFillHandleUtils {
	
	/**
	 * The negative char.
	 */
	private static String NEGATIVE_CHAR = "-"; //$NON-NLS-1$
	
	/**
	 * Get the template string from a string (without beginning and ending number).
	 * 
	 * @param initialString The initial string.
	 * @return The modified string (without beginning and ending number).
	 */
	public static String getTemplateString(final String initialString){
		return getTemplateWithoutEndingNumber(getTemplateWithoutBeginningNumber(initialString));
	}
	
	/**
	 * Get the template string from a string (without beginning number).
	 * 
	 * @param initialString The initial string.
	 * @return The modified string (without beginning number).
	 */
	public static String getTemplateWithoutBeginningNumber(final String initialString){
		String result = initialString;
		
		// The number must be a negative number
		try{
			if(2 <= result.length() && NEGATIVE_CHAR.equals(result.substring(0, 1))){
				Integer.parseInt(result.substring(1, 2));
				result = result.substring(2);
			}
		}catch(Exception e){
			// Continue
		}
		
		// Try to remove beginning number
		try{
			while(!result.isEmpty()){
				final String firstChar = result.substring(0, 1);
				Integer.parseInt(firstChar);
				result = result.substring(1);
			}
		}catch(Exception e){
			// Continue
		}
		
		return result;
	}
	
	/**
	 * Get the template string from a string (without ending number).
	 * 
	 * @param initialString The initial string.
	 * @return The modified string (without ending number).
	 */
	public static String getTemplateWithoutEndingNumber(final String initialString){
		String result = initialString;
		
		boolean hasNumber = false;
		
		// Try to remove ending number
		try{
			while(!result.isEmpty()){
				final String lastChar = result.substring(result.length()-1);
				Integer.parseInt(lastChar);
				hasNumber = true;
				result = result.substring(0, result.length()-1);
			}
		}catch(Exception e){
			// Continue
		}
		
		// If a number is found, check if this is not a negative number
		if(hasNumber && NEGATIVE_CHAR.equals(result.substring(result.length()-1))){
			result = result.substring(0, result.length()-1);
		}
		
		return result;
	}
	
	/**
	 * Check if a string is starting with the template string.
	 * 
	 * @param initialString The initial string to check.
	 * @param templateString The template string.
	 * @return <code>true</code> if the initial string starts with template string, <code>false</code> otherwise.
	 */
	public static boolean isBeginningByNumber(final String initialString, final String templateString){
		return !templateString.isEmpty() && !initialString.startsWith(templateString);
	}
	
	/**
	 * Check if a string is ending with the template string.
	 * 
	 * @param initialString The initial string to check.
	 * @param templateString The template string.
	 * @return <code>true</code> if the initial string ends with template string, <code>false</code> otherwise.
	 */
	public static boolean isEndingBNumber(final String initialString, final String templateString){
		return templateString.isEmpty() || !initialString.endsWith(templateString);
	}
	
}

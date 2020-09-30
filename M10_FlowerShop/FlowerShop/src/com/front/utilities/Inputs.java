/**
 * 
 */
package com.front.utilities;

import com.crud.controller.BusinessController.Color;
import com.crud.controller.BusinessController.Material;

/**
 * class with methods of using user data entry treatments.
 * @author FaunoGuazina & pierorepp90
 *
 */
public final class Inputs {
	
	/**
	 * method that converts a string to TitleCase, 
	 * that is, each of the words in the string 
	 * will have the first capital letter 
	 * and all other lower case letters.
	 * @param input string you want to convert
	 * @return this same string capitalized only the first letters of each word
	 */
	public static String toTitleCase(String input) {
	    StringBuilder titleCase = new StringBuilder(input.length());
	    boolean nextTitleCase = true;
	    for (Character c : input.toCharArray()) {
    		if (c.equals(' ') || c.equals('-') || c.equals('\'')) {
    			nextTitleCase = true;
    		} else if (nextTitleCase) {
    			c = Character.toUpperCase(c);
    			nextTitleCase = false;
    		} else {
    			c = Character.toLowerCase(c);
    		}
    		titleCase.append(c);
    	}
	    return titleCase.toString();
	}

	/**
	 * validates if a Enum Color contains the string
	 * @param input string
	 * @return Enum Material object
	 */
	public static boolean validColor(String input) {
		try {
			return Color.valueOf(toTitleCase(input)) != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * convert string to Enum Color
	 * @param input string
	 * @return Enum Color object
	 */
	public static Color toColor(String input) {
		return Color.valueOf(toTitleCase(input));
	}

	
	
	/**
	 * validates if a Enum Material contains the string
	 * @param input string
	 * @return Enum Color object
	 */
	public static boolean validMaterial(String input) {
		try {
			return Material.valueOf(toTitleCase(input)) != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * convert string to Enum Material
	 * @param input string
	 * @return Enum Material object
	 */
	public static Material toMaterial(String input) {
		return Material.valueOf(toTitleCase(input));
	}
	
	
	
	/**
	 * Converts a string to a double value.
	 * remove all commas and validate with regex 
	 * "\\d+\\.?\\d*"
	 * @param input string
	 * @return
	 * Value >=0 if the string is only numeric.
	 * Value -1.0 if the string is not just numeric.
	 */
	public static double toDouble(String input) {
		input = input.replaceAll(",", "");
		if (!input.matches("\\d+\\.?\\d*")) {
			return -1.0;
		}
		return Double.parseDouble(input);
	}
	
}

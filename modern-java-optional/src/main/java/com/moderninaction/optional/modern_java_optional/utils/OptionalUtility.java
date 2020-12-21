package com.moderninaction.optional.modern_java_optional.utils;

import java.util.Optional;

/**
 * With Optional you can build better Api's to return an empty or the value.
 * 
 * @author ainacio
 *
 */
public class OptionalUtility {
	
	public static Optional<Integer> stringToInt(String s){
		try {
			return Optional.of(Integer.parseInt(s));
		} catch(NumberFormatException e) {
			return Optional.empty();
		}
	}

}

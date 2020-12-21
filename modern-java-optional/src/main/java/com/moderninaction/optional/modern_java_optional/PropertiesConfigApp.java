package com.moderninaction.optional.modern_java_optional;

import java.util.Optional;
import java.util.Properties;

import com.moderninaction.optional.modern_java_optional.utils.OptionalUtility;

public class PropertiesConfigApp {
	
	public Properties createProperties() {
		Properties properties = new Properties();
		properties.setProperty("a", "5");
		properties.setProperty("b", "true");
		properties.setProperty("c", "-3");
		
		return properties;
	}
	
	public int readDurationWithoutOptional(Properties properties, String name) {
		String value = properties.getProperty(name);
		if(value != null) {
			try {
				int i = Integer.parseInt(value);
				if(i > 0) {
					return i;
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
			} 
		}
		return 0;
	}
	
	
	/**
	 * In just one setence you can do all using filter and map from Optional
	 * 
	 * @param properties
	 * @param name
	 * @return
	 */
	public int readDuration(Properties properties, String name) {
		return Optional.ofNullable(properties.getProperty(name)).flatMap(OptionalUtility::stringToInt).filter(i -> i > 0).orElse(0);
	}

}

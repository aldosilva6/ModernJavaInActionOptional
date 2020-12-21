package com.moderninaction.optional.modern_java_optional;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import org.junit.jupiter.api.Test;

public class PropertiesConfigAppTest{
	
	@Test
	public void testReadDuration() {
		PropertiesConfigApp config = new PropertiesConfigApp();
		Properties properties = config.createProperties();
		assertEquals(5, config.readDurationWithoutOptional(properties, "a"));
		assertEquals(0, config.readDurationWithoutOptional(properties, "b"));
		assertEquals(0, config.readDurationWithoutOptional(properties, "c"));
		assertEquals(0, config.readDurationWithoutOptional(properties, "d"));
		
	}
	
	@Test
	public void testReadDurationOptional() {
		PropertiesConfigApp config = new PropertiesConfigApp();
		Properties properties = config.createProperties();
		assertEquals(5, config.readDuration(properties, "a"));
		assertEquals(0, config.readDuration(properties, "b"));
		assertEquals(0, config.readDuration(properties, "c"));
		assertEquals(0, config.readDuration(properties, "d"));
		
	}

}

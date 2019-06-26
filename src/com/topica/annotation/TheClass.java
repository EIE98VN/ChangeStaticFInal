package com.topica.annotation;

import java.lang.reflect.Field;

public class TheClass{
	private static final String CONSTANT_STRING = "Constant String !";
	public static final Integer CONSTANT_INTEGER = 3;
	
	public static String getConstantString() {
		return CONSTANT_STRING;
	}
	
	public static Integer getConstantInteger() {
		return CONSTANT_INTEGER;
	}

	public static String getConstantReflection() {
		try {
			final Field field = TheClass.class.getDeclaredField("CONSTANT_STRING");
			return (String) field.get(null);
		}catch (NoSuchFieldException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}catch (IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}

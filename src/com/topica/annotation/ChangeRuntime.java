package com.topica.annotation;

import java.lang.reflect.*;

public class ChangeRuntime {
	public static void main(String[] args) {
		Field field;

		// update String field
		try {
			field = TheClass.class.getDeclaredField("CONSTANT_STRING");
			field.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
			field.set(null, "Constant string updated !");

			System.out.println("Change static final string during runtime ");
			System.out.println(TheClass.getConstantString());
			System.out.println(TheClass.getConstantReflection());
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// update Integer field
		try {
			field = TheClass.class.getDeclaredField("CONSTANT_INTEGER");
			field.setAccessible(true);
			
			System.out.println("Change static final Integer during runtime ");
			System.out.println("Before change: " + TheClass.getConstantInteger());

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

			field.set(null, 10);
			
			System.out.println("After change: " + TheClass.getConstantInteger());
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

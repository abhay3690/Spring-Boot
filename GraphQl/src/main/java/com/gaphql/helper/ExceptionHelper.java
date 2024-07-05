package com.gaphql.helper;

public class ExceptionHelper {
	public static RuntimeException throwResourceNotFoundException() {
		return new RuntimeException("REsource not found");
	}
}	

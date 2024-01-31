package com.junit5.exceptionHandling;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Junit5Test {

	Junit5 j5=new Junit5();
	
	@Test
	public void lengthOfStringTest() {
	
		String str=null;
		assertThrows(NullPointerException.class,()-> j5.lengthOfString(str));
	}
	
	@Test
	public void arithmaticExceptionTest() {
		
		assertThrows(ArithmeticException.class, ()->j5.arithmaticException(10, 0));
	}

}

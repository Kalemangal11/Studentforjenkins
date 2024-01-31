package com.bikkadIt.RestApiCurdOperation.junit4;

import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


class Junit4Test {

	Junit4Class junit4cs=new Junit4Class();
	@Test
	public void stringLengthCheckPositiveTest() {
		int actualResult = junit4cs.stringLengthCheck("Mangal");
		int expectedResult=6;
		assertEquals(expectedResult, actualResult);
		}
	
	@Test(expected = NullPointerException.class)//purana tarika
	public void stringLengthCheckNegativeTest() {
		String str=null;
		junit4cs.stringLengthCheck(str);
		}
	
	@Test
	public void divisionOpePositiveTest() {
		int divisionOpe = junit4cs.divisionOpe(12, 2);
		assertEquals(6, divisionOpe);
		}

	@Test(expected = ArithmeticException.class)
	public void divisionOpeNegativeTest() {
		junit4cs.divisionOpe(12, 0);
	
		}

	}

package com.sanjeeb.java.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sanjeeb.java.concepts.SumOfDigitsInANumber;

public class SumOfDigitsInANumberTest {

	int[] numArray;
	int[] expectedValArray; 
	
	public SumOfDigitsInANumberTest() {
	}
	
	@Before
	public void setUp() throws Exception {
		numArray = new int[] {1, 00, 123, 456, 7666, 8, 666}; 
		expectedValArray = new int[] {1, 0, 6, 15, 25, 8, 18};
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSum() {
		for(int i = 0; i < numArray.length; ++i) {
			assertEquals(expectedValArray[i], SumOfDigitsInANumber.getSum(numArray[i]));
		}
	}

}

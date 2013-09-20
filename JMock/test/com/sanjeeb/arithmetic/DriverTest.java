package com.sanjeeb.arithmetic;

import static org.junit.Assert.*;

import javax.jws.Oneway;

import junit.framework.TestCase;

import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.jmock.Expectations;

public class DriverTest extends TestCase{
	Operation operation;
	Mockery mockery;
	@Before
	public void setUp() throws Exception {
		mockery = new Mockery();
		operation = mockery.mock(Operation.class);
	}

	@Test
	public void test_method() {
		final int i = 4;
		final int j = 5;
		final int result = 9;
		mockery.checking(new Expectations() {{
			oneOf(operation).add(with(any(int.class)), with(any(int.class)));
//			oneOf(operation).add(i, j);
			will(returnValue(result));
		}});
		
		assertEquals(operation.add(i, j), result);
		mockery.assertIsSatisfied();
	}
}
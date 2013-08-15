package com.sanjeeb.java.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CopyOfSumOfDigitsInANumberTest2.class, SumOfDigitsInANumberTest.class })
public class AllTests {

}

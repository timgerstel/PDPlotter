package com.thetimg.pdp.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.thetimg.errors.ErrorLog;

public class ErrorLogTest {
	
	@Rule
	public Timeout globalTimeout = new Timeout(1000L, TimeUnit.MILLISECONDS);
	
	@Test
	public void testAddAndWriteout(){
		ErrorLog.add("critical", "Test", "This is a test of error logging.");
		ErrorLog.add("important", "Test2", "This is test 2 of error logging.");
		ErrorLog.writeout("errors/", "ErrorLog");
		assertEquals(2, ErrorLog.getNumberOfErrors());
	}

}

package com.thetimg.pdp.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.thetimg.pdp.structures.Matrix;
import com.thetimg.pdp.structures.SquareMatrix;

public class MatrixTest {
	@Rule
	public Timeout globalTimeout = new Timeout(500L, TimeUnit.MILLISECONDS);
	
	private SquareMatrix sqMat;
	private Matrix mat;
	double[][] square = new double[][]{
		{ 1,2,3,4 },
		{ 5,6,7,8 },
		{ 9,10,11,12 },
		{ 13,14,15,16 },
	};
	double[][] vals = new double[][]{
		{ 11,22,33,44 },
		{ 55,66,77,88 },
	};
	String values = "89, 90, 91, 92, 93, 94, 95, 96";
	
	@Before
	public void before(){
		sqMat = new SquareMatrix(square);
		mat = new Matrix(vals);
	}
	
	@Test
	public void testSetValue(){
		mat.setValue(1, 1, 6.6);
		assertEquals(6.6, mat.getValue(1, 1), 0);
	}
	
	@Test
	public void testSetValues(){
		mat.setValues(values, ", ");
		assertEquals(90.0, mat.getValue(0, 1), 0);
	}
	
	@Test
	public void testGetTraceAndSize(){
		assertEquals(34.0, sqMat.getTrace(), 0);
		assertEquals(16, sqMat.getSize());
	}
	
	@Test
	public void testToConsole(){
		sqMat.toConsole();
	}
}

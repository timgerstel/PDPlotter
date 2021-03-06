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
	public Timeout globalTimeout = new Timeout(1000L, TimeUnit.MILLISECONDS);
	
	private SquareMatrix sqMat;
	private Matrix mat;
	private double[][] square = new double[][]{ //det(square) = 0.0
		{ 1,2,3,4 },
		{ 5,6,7,8 },
		{ 9,10,11,12 },
		{ 13,14,15,16 },
	};
	private double[][] vals = new double[][]{
		{ 11,22,33,44 },
		{ 55,66,77,88 },
	};
	private double[][] vals1 = new double[][]{ //det(vals1) = 6116526.0
		{ 12,15,19,-20 },
		{ 16,-20,40,10 },
		{ 31,22,-76,2  },
		{ 5,65,82,7    }
	};
	private String values = "89, 90, 91, 92, 93, 94, 95, 96";
	
	@Before
	public void before(){
		sqMat = new SquareMatrix(square);
		mat = new Matrix(vals);
	}
	
	@Test
	public void testGetValue(){
		mat = new Matrix(2,2);
		assertEquals(0, mat.getValue(0, 0), 0);
		mat.setValue(0, 0, 1);
		assertEquals(1, mat.getValue(0, 0), 0);
	}
	
	@Test
	public void testSetValue(){
		mat.setValue(1, 1, 6.6);
		sqMat.setValue(3, 3, 6.2);
		assertEquals(6.6, mat.getValue(1, 1), 0);
		assertEquals(6.2, sqMat.getValue(3, 3), 0);
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
	public void testGetRowsAndCols(){
		assertEquals(4, sqMat.getCols());
		assertEquals(4, sqMat.getRows());
		assertEquals(2, mat.getRows());
		double[][] vals1 = new double[][]{
			{ 11,22,33,44 },
			{ 55,66,77,88 },
			{ 99,11,22,33 },
		};
		mat = new Matrix(vals1);	
		assertEquals(3, mat.getRows());
	}
	
	@Test
	public void testGetSubmatrix(){
		Matrix newmat = mat.getSubmatrix(1, 3);
		assertEquals(3, newmat.getCols());
		assertEquals(1, newmat.getRows());
		newmat.toConsole();
	}
	
	@Test
	public void testGetDet(){
		assertEquals(0.0, sqMat.getDet(), 0);
		sqMat = new SquareMatrix(vals1);
		assertEquals(6116526.0, sqMat.getDet(), 0);
	}
	
	@Test
	public void testEquals(){
		Matrix eqMat = new Matrix(vals);
		assertTrue(mat.equals(eqMat));
		assertFalse(mat.equals(sqMat));
		Matrix eqSq = new SquareMatrix(square);
		assertTrue(eqSq.equals(sqMat));
	}
	
	@Test
	public void testToConsole(){
		sqMat.toConsole();
	}
}

package com.thetimg.pdp.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.thetimg.pdp.math.MatrixMath;
import com.thetimg.pdp.structures.Matrix;
import com.thetimg.pdp.structures.SquareMatrix;

public class MatrixMathTest {
	@Rule
	public Timeout globalTimeout = new Timeout(1000L, TimeUnit.MILLISECONDS);
	
	private Matrix A, B, E;
	private SquareMatrix C,D;
	
	private double[][] valsA = new double[][]{
		{ 11,22,33,44 },
		{ 55,66,77,88 },
	};
	private double[][] valsB = new double[][]{
		{ 12,15,19,-20 },
		{ 16,-20,40,10 },
		{ 31,22,-76,2  },
		{ 5,65,82,7    }
	};
	private double[][] valsC = new double[][]{
		{ 1,2 },
		{ 3,4 }
	};
	private double[][] valsD = new double[][]{
		{ 5,6 },
		{ 7,8 }
	};
	private double[][] valsE = new double[][]{
		{ 11,22,33,44 },
		{ 55,66,77,88 }, 
	};
	
	@Before
	public void before(){
		A = new Matrix(valsA);
		B = new Matrix(valsB);
		C = new SquareMatrix(valsC);
		D = new SquareMatrix(valsD);
		E = new Matrix(valsE);
	}
	
	@Test
	public void testAdd(){
		SquareMatrix CD = MatrixMath.add(C, D);
		assertEquals(6, CD.getValue(0, 0), 0);
		assertEquals(8, CD.getValue(0, 1), 0);
		assertEquals(10, CD.getValue(1, 0), 0);
		assertEquals(12, CD.getValue(1, 1), 0);
		Matrix AE = MatrixMath.add(A, E);
		assertEquals(22, AE.getValue(0, 0), 0);
		assertEquals(44, AE.getValue(0, 1), 0);
		assertEquals(110, AE.getValue(1, 0), 0);
		assertEquals(132, AE.getValue(1, 1), 0);
	}

}

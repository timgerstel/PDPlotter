package com.thetimg.pdp.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.thetimg.pdp.structures.Matrix;
import com.thetimg.pdp.structures.SquareMatrix;

public class MatrixMathTest {
	@Rule
	public Timeout globalTimeout = new Timeout(1000L, TimeUnit.MILLISECONDS);
	
	private Matrix A, B;
	private SquareMatrix C,D;
	
	double[][] valsA = new double[][]{
		{ 11,22,33,44 },
		{ 55,66,77,88 },
	};
	double[][] valsB = new double[][]{
		{ 12,15,19,-20 },
		{ 16,-20,40,10 },
		{ 31,22,-76,2  },
		{ 5,65,82,7    }
	};
	double[][] valsC = new double[][]{
		{ 1,2 },
		{ 3,4 }
	};
	double[][] valsD = new double[][]{
		{ 5,6 },
		{ 7,8 }
	};
	
	@Before
	public void before(){
		A = new Matrix(valsA);
		B = new Matrix(valsB);
		C = new SquareMatrix(valsC);
		D = new SquareMatrix(valsD);
	}

}

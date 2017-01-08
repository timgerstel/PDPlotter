package com.thetimg.pdp.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.thetimg.pdp.math.CharEqnSolver;
import com.thetimg.pdp.math.MatrixMath;
import com.thetimg.pdp.structures.Matrix;
import com.thetimg.pdp.structures.SquareMatrix;

public class CharEqnSolverTest {	
	@Rule
	public Timeout globalTimeout = new Timeout(1000L, TimeUnit.MILLISECONDS);
	
	private SquareMatrix A;
	private CharEqnSolver solver;
	
	private double[][] saddle = new double[][]{
		{ 1.0, 1.0 },
		{ 4.0, -2.0 }
	};
	
	@Before
	public void before(){
		A = new SquareMatrix(saddle);
		solver = new CharEqnSolver(A);
	}
	
	@Test
	public void testSaddleTraceAndDet(){
		assertEquals(-1.0, A.getTrace(), 0.0);
		assertEquals(-6.0, A.getDet(), 0.0);
	}
	
	@Test
	public void testSaddleEvals(){
		assertEquals(2.0, solver.getEval1(), 0.0);
		assertEquals(-3.0, solver.getEval2(), 0.0);
	}
	
	@Test
	public void testSaddleEvects(){
		double[][] vect1 = new double[][]{
			{ 1 },
			{ 1 }
		};
		double[][] vect2 = new double[][]{
			{ 1 },
			{ -4 }
		};
		Matrix evect1 = new Matrix(vect1);
		Matrix evect2 = new Matrix(vect2);
		assertTrue(evect1.equals(solver.getEvect1()));
		assertTrue(evect2.equals(solver.getEvect2()));
		evect1.toConsole();
		evect2.toConsole();
	}

}

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
	
	private SquareMatrix saddle, node_stable;
	private CharEqnSolver solver;
	
	private double[][] saddlev = new double[][]{
		{ 1.0, 1.0 },
		{ 4.0, -2.0 }
	};
	
	private double[][] nodev = new double[][]{
		{ -5, 1 },
		{ 4, -2 }
	};
	
	@Before
	public void before(){
		saddle = new SquareMatrix(saddlev);
		node_stable = new SquareMatrix(nodev);
	}
	
	@Test
	public void testTraceAndDet(){
		assertEquals(-1.0, saddle.getTrace(), 0.0);
		assertEquals(-6.0, saddle.getDet(), 0.0);
		assertEquals(-7, node_stable.getTrace(), 0.0);
		assertEquals(6, node_stable.getDet(), 0.0);
	}
	
	@Test
	public void testEvals(){
		solver = new CharEqnSolver(saddle);
		assertEquals(2.0, solver.getEval1(), 0.0);
		assertEquals(-3.0, solver.getEval2(), 0.0);
		solver = new CharEqnSolver(node_stable);
		assertEquals(-1, solver.getEval1(), 0.0);
		assertEquals(-6, solver.getEval2(), 0.0);
	}
	
	@Test
	public void testSaddleEvects(){
		solver = new CharEqnSolver(saddle);
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
	
	@Test
	public void testNodeEvects(){
		double[][] vect1 = new double[][]{
			{ 1 },
			{ 4 }
		};
		double[][] vect2 = new double[][]{
			{ 1 },
			{ -1 }
		};
		Matrix evect1 = new Matrix(vect1);
		Matrix evect2 = new Matrix(vect2);
		solver = new CharEqnSolver(node_stable);
		assertTrue(evect1.equals(solver.getEvect1()));
		assertTrue(evect2.equals(solver.getEvect2()));
		evect1.toConsole();
		evect2.toConsole();
	}

}

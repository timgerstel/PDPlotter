package com.thetimg.pdp.math;

import com.thetimg.pdp.structures.Matrix;
import com.thetimg.pdp.structures.SquareMatrix;

public class CharEqnSolver {
	
	private SquareMatrix m;
	private double det = 0.0;
	private double trace = 0.0;
	private SquareMatrix identity;
	
	public CharEqnSolver(SquareMatrix m){
		this.m = m;
		det = this.m.getDet();
		trace = this.m.getTrace();
		identity = MatrixMath.getIdentityMatrix(m.getRows());
	}
	
	public double getEval1(){
		return (trace + Math.sqrt(Math.pow(trace, 2) - 4*(det)))/2;
	}
	
	public double getEval2(){
		return (trace - Math.sqrt(Math.pow(trace, 2) - 4*(det)))/2;
	}
	
	public Matrix getEvect1(){
		double v1 = 1, v2 = 1;
		double[][] vect = new double[][]{
			{ v1 },
			{ v2 }
		};
		Matrix vector = new Matrix(vect);
		SquareMatrix lambda1 = MatrixMath.sub(m, MatrixMath.scale(identity, getEval1()));
		Matrix evect1 = MatrixMath.multiply(lambda1, vector);
		return evect1;
	}

}

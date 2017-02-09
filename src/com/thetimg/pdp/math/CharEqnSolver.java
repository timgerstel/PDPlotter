package com.thetimg.pdp.math;

import com.thetimg.pdp.errors.ErrorLog;
import com.thetimg.pdp.structures.Matrix;
import com.thetimg.pdp.structures.SquareMatrix;

public class CharEqnSolver {
	
	private SquareMatrix m;
	private double trace = 0.0;
	private double det = 0.0;
	private SquareMatrix identity;
	
	public CharEqnSolver(double trace, double det){
		this.trace = trace;
		this.det = det;
	}
	
	public CharEqnSolver(SquareMatrix m){
		if(m == null){
			//Error cannot initialize a null matrix
			ErrorLog.add("null", "Null Matrix", "Cannot initialize solver with a null matrix");
			System.out.println("Cannot initialize solver with a null matrix");
		} else {
			this.m = m;
			det = this.m.getDet();
			trace = this.m.getTrace();
			identity = MatrixMath.getIdentityMatrix(m.getRows());
		}
	}
	
	public SquareMatrix getMatrix(){
		return m;
	}
	
	public SquareMatrix getIdentity(){
		return identity;
	}
	
	public double getEval1(){
		return (trace + Math.sqrt(Math.pow(trace, 2) - 4*(det)))/2;
	}
	
	public double getEval2(){
		return (trace - Math.sqrt(Math.pow(trace, 2) - 4*(det)))/2;
	}
	
	public Matrix getEvect1(){
		double[][] vect = new double[m.getRows()][1];
		Matrix evect = new Matrix(vect);
		SquareMatrix lambda = MatrixMath.sub(m, MatrixMath.scale(identity, getEval1()));
		double[][] firstRow = new double[1][lambda.getCols()];
		firstRow[0] = lambda.getArray()[0];
		Matrix fRow = new Matrix(firstRow);
		//will only work for 2x2 matrix for testing purposes
		double cons = -fRow.getValue(0, 0)/fRow.getValue(0, 1);
		evect.setValue(0, 0, 1);
		evect.setValue(1, 0, cons);
		return evect;
	}
	
	public Matrix getEvect2(){
		double[][] vect = new double[m.getRows()][1];
		Matrix evect = new Matrix(vect);
		SquareMatrix lambda = MatrixMath.sub(m, MatrixMath.scale(identity, getEval2()));
		double[][] firstRow = new double[1][lambda.getCols()];
		firstRow[0] = lambda.getArray()[0];
		Matrix fRow = new Matrix(firstRow);
		//will only work for 2x2 matrix for testing purposes
		double cons = -fRow.getValue(0, 0)/fRow.getValue(0, 1);
		evect.setValue(0, 0, 1);
		evect.setValue(1, 0, cons);
		return evect;
	}

}

package com.thetimg.pdp.math;

import com.thetimg.pdp.structures.SquareMatrix;

public class CharEqnSolver {
	
	private SquareMatrix m;
	private double det = 0.0;
	private double trace = 0.0;
	
	public CharEqnSolver(SquareMatrix m){
		this.m = m;
		det = this.m.getDet();
		trace = this.m.getTrace();
	}
	
	public double getEval1(){
		return (trace + Math.sqrt(Math.pow(trace, 2) - 4*(det)))/2;
	}
	
	public double getEval2(){
		return (trace - Math.sqrt(Math.pow(trace, 2) - 4*(det)))/2;
	}

}

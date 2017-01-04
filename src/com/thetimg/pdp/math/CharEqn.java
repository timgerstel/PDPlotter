package com.thetimg.pdp.math;

import com.thetimg.pdp.structures.SquareMatrix;

public class CharEqn {
	
	private SquareMatrix m;
	private double det = 0.0;
	private double trace = 0.0;
	
	public CharEqn(SquareMatrix m){
		this.m = m;
		det = m.getDet();
		trace = m.getTrace();
	}
	
	public void solve(){
		
	}

}

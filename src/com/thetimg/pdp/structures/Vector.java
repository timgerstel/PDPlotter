package com.thetimg.pdp.structures;

public class Vector extends Matrix{

	//If row is true, create row vector, else column vector
	public Vector(int a, boolean row) {
		super(a);
		if(row){
			mat = new double[1][a];
			rows = 1;
			cols = a;
		} else {
			mat = new double[a][1];
			rows = a;
			cols = 1;
		}
		size = a;
	}

}

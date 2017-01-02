package com.thetimg.pdp.structures;

public class SquareMatrix extends Matrix{
	
	public SquareMatrix(double[][] mat){
		super(mat);
	}

	public SquareMatrix(int a) {
		super(a);
	}
	
	public double getTrace(){
		double ret = 0;
		for(int i = 0; i < rows; i++){
			ret = ret + mat[i][i];
		}
		return ret;
	}

}

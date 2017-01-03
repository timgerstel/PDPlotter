package com.thetimg.pdp.structures;

public class SquareMatrix extends Matrix{
	
	public SquareMatrix(double[][] mat){
		super(mat);
		if(rows != cols){
			//Error - Cannot be defined as square matrix
		}
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
	
	public double getDet(){
		return getDet(this);
	}
	
	private double getDet(Matrix m){
		if(m.getCols() == 1){
			return m.getValue(0, 0);
		} else {
			double ret = 0;
			int sign = 1;
			for(int i = 0; i < m.getCols(); i++){
				Matrix sub = m.getSubmatrix(0, i);
				if(i%2 == 0){
					sign = 1;
				} else {
					sign = -1;
				}
				ret += sign * m.getValue(0, i) * getDet(sub);
			}
			return ret;
		}
	}

}

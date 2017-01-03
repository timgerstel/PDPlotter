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
	
	public SquareMatrix getSubmatrix(int rowIndex, int colIndex){
		StringBuilder vals = new StringBuilder();
		double[][] sub = new double[rows-1][cols-1];
		SquareMatrix ret = new SquareMatrix(sub);
		for(int i = 0; i < rows; i++){
			if(i != rowIndex){
				for(int j = 0; j < cols; j++){
					if(j != colIndex){
						vals.append(mat[i][j] + ",");
					}
				}
			}
		}
		ret.setValues(vals.toString(), ",");
		return ret;
	}
	
	public double getTrace(){
		double ret = 0;
		for(int i = 0; i < rows; i++){
			ret = ret + mat[i][i];
		}
		return ret;
	}
	
	//return determinant of matrix
	public double getDet(){
		return getDet(this);
	}
	
	//Recursive determinant helper
	private double getDet(SquareMatrix m){
		if(m.getCols() == 1){
			return m.getValue(0, 0);
		} else {
			double ret = 0;
			int sign = 1;
			for(int i = 0; i < m.getCols(); i++){
				SquareMatrix sub = m.getSubmatrix(0, i);
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

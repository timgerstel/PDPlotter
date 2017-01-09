package com.thetimg.pdp.structures;

import com.thetimg.pdp.errors.ErrorLog;

public class SquareMatrix extends Matrix{
	
	public SquareMatrix(double[][] mat){
		super(mat);
		if(rows != cols){
			//Error - Cannot be defined as square matrix
			ErrorLog.add("Matrix dimensions are not square");
			System.out.println("Matrix dimensions are not square");
		}
	}

	public SquareMatrix(int a) {
		super(a);
	}
	
	public SquareMatrix getSubmatrix(int rowIndex, int colIndex){
		if(rowIndex > rows-1 || colIndex > cols-1){
			//Error - index out of bounds
			ErrorLog.add("ArrayIndexOutOfBounds", "Submatrix could not be returned, index is out of bounds @ " + rowIndex + ", " + colIndex);
			System.out.println("Submatrix could not be returned, index is out of bounds @ " + rowIndex + ", " + colIndex);
			return this;
		} else {
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
	}
	
	public boolean equals(SquareMatrix m){
		if(m == null){
			ErrorLog.add("null", "Null Matrix", "Parameter cannot be a null matrix");
			System.out.println("Parameter cannot be a null matrix");
			return false;
		} else if(rows != m.getRows() || cols != m.getCols()){
			return false;
		} else {
			for(int i = 0; i < rows; i++){
				for(int j = 0; j < rows; j++){
					if(getValue(i, j) != m.getValue(i, j)){
						return false;
					}
				}
			}
			return true;
		}
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

package com.thetimg.pdp.math;

import com.thetimg.pdp.structures.Matrix;
import com.thetimg.pdp.structures.SquareMatrix;

public class MatrixMath {
	
	//returns new matrix equal to m1+m2
	public static Matrix add(Matrix m1, Matrix m2){
		if(m1.getRows() != m2.getRows() && m1.getCols() != m2.getCols()){
			//Error - Matricies must be same dimensions
			return new Matrix(null);
		} else {
			double[][] ret = new double[m1.getRows()][m1.getCols()];
			for(int i = 0; i < m1.getRows(); i++){
				for(int j = 0; j < m2.getCols(); j++){
					ret[i][j] = m1.getValue(i, j) + m2.getValue(i, j);
				}
			}
			return new Matrix(ret);
		}
	}
	
	//returns new matrix equal to m1+m2
	public static SquareMatrix add(SquareMatrix m1, SquareMatrix m2){
		if(m1.getRows() != m2.getRows() && m1.getCols() != m2.getCols()){
			//Error - Matricies must be same dimensions
			return new SquareMatrix(null);
		} else {
			double[][] ret = new double[m1.getRows()][m1.getCols()];
			for(int i = 0; i < m1.getRows(); i++){
				for(int j = 0; j < m2.getCols(); j++){
					ret[i][j] = m1.getValue(i, j) + m2.getValue(i, j);
				}
			}
			return new SquareMatrix(ret);
		}
	}
	
	//Returns new matrix equal to m1-m2
	public static Matrix sub(Matrix m1, Matrix m2){
		if(m1.getRows() != m2.getRows() && m1.getCols() != m2.getCols()){
			//Error - Matricies must be same dimensions
			return new Matrix(null);
		} else {
			double[][] ret = new double[m1.getRows()][m1.getCols()];
			for(int i = 0; i < m1.getRows(); i++){
				for(int j = 0; j < m2.getCols(); j++){
					ret[i][j] = m1.getValue(i, j) - m2.getValue(i, j);
				}
			}
			return new Matrix(ret);
		}
	}
	
	//Returns new matrix equal to m1-m2
	public static SquareMatrix sub(SquareMatrix m1, SquareMatrix m2){
		if(m1.getRows() != m2.getRows() && m1.getCols() != m2.getCols()){
			//Error - Matricies must be same dimensions
			return new SquareMatrix(null);
		} else {
			double[][] ret = new double[m1.getRows()][m1.getCols()];
			for(int i = 0; i < m1.getRows(); i++){
				for(int j = 0; j < m2.getCols(); j++){
					ret[i][j] = m1.getValue(i, j) - m2.getValue(i, j);
				}
			}
			return new SquareMatrix(ret);
		}
	}

}

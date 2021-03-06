package com.thetimg.pdp.math;

import com.thetimg.pdp.errors.ErrorLog;
import com.thetimg.pdp.structures.Matrix;
import com.thetimg.pdp.structures.SquareMatrix;

public class MatrixMath {
	
	//returns new matrix equal to m1+m2
	public static Matrix add(Matrix m1, Matrix m2){
		if(m1 == null || m2 == null){
			//Error - matricies cannot be null
			ErrorLog.add("null", "Null Matrix", "Cannot add null matricies");
			System.out.println("Cannot add null matricies");
			return new Matrix(1);
		} else if(m1.getRows() != m2.getRows() || m1.getCols() != m2.getCols()){
			//Error - Matricies must be same dimensions
			ErrorLog.add("Addition error", "Matricies must have same dimensions");
			System.out.println("Added matricies must have same dimensions");
			return m1;
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
		if(m1 == null || m2 == null){
			//Error - matricies cannot be null
			ErrorLog.add("null", "Null Matrix", "Cannot add null matricies");
			System.out.println("Cannot add null matricies");
			return new SquareMatrix(1);
		} else if(m1.getRows() != m2.getRows() || m1.getCols() != m2.getCols()){
			//Error - Matricies must be same dimensions
			ErrorLog.add("Addition error", "Matricies must have same dimensions");
			System.out.println("Added matricies must have same dimensions");
			return m1;
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
		if(m1 == null || m2 == null){
			//Error - matricies cannot be null
			ErrorLog.add("null", "Null Matrix", "Cannot subtract null matricies");
			System.out.println("Cannot subtract null matricies");
			return new Matrix(1);
		} else if(m1.getRows() != m2.getRows() || m1.getCols() != m2.getCols()){
			//Error - Matricies must be same dimensions
			ErrorLog.add("Subtraction error", "Matricies must have same dimensions");
			System.out.println("Subtracted matricies must have same dimensions");
			return m1;
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
		if(m1 == null || m2 == null){
			//Error - matricies cannot be null
			ErrorLog.add("null", "Null Matrix", "Cannot subtract null matricies");
			System.out.println("Cannot subtract null matricies");
			return new SquareMatrix(1);
		} else if(m1.getRows() != m2.getRows() || m1.getCols() != m2.getCols()){
			//Error - Matricies must be same dimensions
			ErrorLog.add("Subtraction error", "Matricies must have same dimensions");
			System.out.println("Subtracted matricies must have same dimensions");
			return m1;
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
	
	public static Matrix scale(Matrix m, double scalar){
		if(m == null){
			//Error - null matrix
			ErrorLog.add("null", "Null Matrix", "Cannot scale a null matrix");
			System.out.println("Cannot scale a null matrix");
			return new Matrix(1);
		} else if(scalar == 0){
			return new Matrix(m.getRows(), m.getCols());
		} else {
			double[][] ret = new double[m.getRows()][m.getCols()];
			for(int i = 0; i < m.getRows(); i++){
				for(int j = 0; j < m.getCols(); j++){
					ret[i][j] = m.getValue(i, j) * scalar;
				}
			}
			return new Matrix(ret);
		}
	}
	
	public static SquareMatrix scale(SquareMatrix m, double scalar){
		if(m == null){
			//Error - null matrix
			ErrorLog.add("null", "Null Matrix", "Cannot scale a null matrix");
			System.out.println("Cannot scale a null matrix");
			return new SquareMatrix(1);
		} else if(scalar == 0){
			return new SquareMatrix(m.getRows());
		} else {
			double[][] ret = new double[m.getRows()][m.getCols()];
			for(int i = 0; i < m.getRows(); i++){
				for(int j = 0; j < m.getCols(); j++){
					ret[i][j] = m.getValue(i, j) * scalar;
				}
			}
			return new SquareMatrix(ret);
		}
	}
	
	public static Matrix multiply(Matrix m1, Matrix m2){
		if(m1 == null || m2 == null){
			//Error - matricies cannot be null
			ErrorLog.add("null", "Null Matrix", "Cannot add null matricies");
			System.out.println("Cannot add null matricies");
			return new Matrix(1);
		} else if(m1.getCols() != m2.getRows()){
			ErrorLog.add("Multiplication error", "Number of columns in first matrix must equal number of rows in second matrix");
			System.out.println("Number of columns in first matrix must equal number of rows in second matrix");
			return m1;
		} else {
			double[][] ret = new double[m1.getRows()][m2.getCols()];
			int count = 0; //row counter for first matrix
			for(int i = 0; i < m2.getCols(); i++){
				double dotProd = 0;
				for(int j = 0; j < m1.getCols(); j++){
					dotProd += m1.getValue(count, j) * m2.getValue(j, i);
					ret[count][i] = dotProd;
				}
				if(i == m2.getCols()-1){
					count++;
					if(count == m1.getRows()-1){
						i = -1;
					}
				}
			}
			return new Matrix(ret);
		}
	}
	
	public static SquareMatrix multiply(SquareMatrix m1, SquareMatrix m2){
		if(m1 == null || m2 == null){
			//Error - matricies cannot be null
			ErrorLog.add("null", "Null Matrix", "Cannot add null matricies");
			System.out.println("Cannot add null matricies");
			return new SquareMatrix(1);
		} else if(m1.getCols() != m2.getRows()){
			ErrorLog.add("Multiplication error", "Number of columns in first matrix must equal number of rows in second matrix");
			System.out.println("Number of columns in first matrix must equal number of rows in second matrix");
			return m1;
		} else {
			double[][] ret = new double[m1.getRows()][m2.getCols()];
			int count = 0; //row counter for first matrix
			for(int i = 0; i < m2.getCols(); i++){
				double dotProd = 0;
				for(int j = 0; j < m1.getCols(); j++){
					dotProd += m1.getValue(count, j) * m2.getValue(j, i);
					ret[count][i] = dotProd;
				}
				if(i == m2.getCols()-1){
					count++;
					if(count == m1.getRows()-1){
						i = -1;
					}
				}
			}
			return new SquareMatrix(ret);
		}
	}
	
	public static SquareMatrix getIdentityMatrix(int n){
		if(n == 0){
			//Error - size zero matrix
			ErrorLog.add("Identity Matrix size 0", "Cannot create an identity matrix of size 0");
			System.out.println("Cannot create an identity matrix of size 0");
			return new SquareMatrix(1);
		} else {
			double[][] ident = new double[n][n];
			for(int i = 0; i < n; i++){
				ident[i][i] = 1;
			}
			return new SquareMatrix(ident);
		}
	}

}

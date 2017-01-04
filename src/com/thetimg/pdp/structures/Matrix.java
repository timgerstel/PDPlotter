package com.thetimg.pdp.structures;

public class Matrix {
	
	protected double[][] mat;
	protected int size = 0;
	protected int rows = 0;
	protected int cols = 0;
	
	//empty square matrix
	//Param: integer matrix dimensions
	public Matrix(int a){
		if(a == 0){
			//Error - cannot have size 0 matrix
		}
		mat = new double[a][a];
		size = a*a;
		rows = a;
		cols = a;
	}
	
	//empty a * b sized matrix
	//Params: row size, column size
	public Matrix(int a, int b){
		if(a == 0 || b == 0){
			//Error - cannot have size 0 matrix
		}
		mat = new double[a][b];
		size = a * b;
		rows = a;
		cols = b;
	}
	
	//generate matrix from existing array
	//Param: Array of values
	public Matrix(double[][] mat){
		if(mat == null){
			//Error - null matrix
			throw new NullPointerException();
		}
		this.mat = mat;
		rows = mat.length;
		cols = mat[0].length;
		size = rows * cols;
	}
	
	//set single value in matrix.
	//Params: row index, column index, value to insert
	public void setValue(int rowIndex, int colIndex, double value){
		if(rowIndex > rows-1 || colIndex > cols-1){
			//Error - index out of bound
			throw new ArrayIndexOutOfBoundsException();
		}
		mat[rowIndex][colIndex] = value;
	}
	
	//Set ALL values via regex separated string
	//Params: values of matrix as string, regex separator string
	public void setValues(String input, String regex){
		String[] vals = input.split(regex);
		if(vals.length != size || input == null || regex == null){
			//Error - Number of inputs is not equal to size of matrix
		} else {
			int valInd = 0;
			for(int i = 0; i < rows; i++){
				for(int j = 0; j < cols; j++){
					mat[i][j] = Double.parseDouble(vals[valInd++]);
				}
			}
		}
	}
	
	//return value @params
	//Params: row index, column index
	public double getValue(int rowIndex, int colIndex){
		if(rowIndex > rows-1 || colIndex > cols-1){
			//Error - array index out of bounds
			return 0;
		} else {
			return mat[rowIndex][colIndex];
		}
	}
	
	public int getSize(){
		return size;
	}
	
	public int getRows(){
		return rows;
	}
	
	public int getCols(){
		return cols;
	}
	
	//return a submatrix of current matrix
	//Params: row index to exclude from submatrix, column index to exclude submatrix
	public Matrix getSubmatrix(int rowIndex, int colIndex){
		if(rowIndex > rows-1 || colIndex > cols-1){
			//Error - array index out of bounds
			return this;
		} else {
			StringBuilder vals = new StringBuilder();
			double[][] sub = new double[rows-1][cols-1];
			Matrix ret = new Matrix(sub);
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
	
	//print matrix to console
	public void toConsole(){
		for(int i = 0; i < rows; i++){
			System.out.print("|");
			for(int j = 0; j < cols; j++){
				System.out.printf("%8.3f", mat[i][j]);
			}
			System.out.printf("%3s%n", "|");
		}
	}
	

}

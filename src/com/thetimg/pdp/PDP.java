package com.thetimg.pdp;

import java.util.Scanner;

import com.thetimg.pdp.math.CharEqnSolver;
import com.thetimg.pdp.structures.Matrix;
import com.thetimg.pdp.structures.SquareMatrix;

public class PDP {
	
	public static void main(String[] args){
		System.out.println("Menu:");
		System.out.println("1: Enter character equation");
		System.out.println("2: Enter matrix");
		System.out.println("3: Exit");
		Scanner s = new Scanner(System.in);
		int op = s.nextInt();
		if(op == 1){
			double t, d;
			System.out.println("Enter trace: ");
			t = s.nextDouble();
			System.out.println("Enter determinant: ");
			d = s.nextDouble();
			CharEqnSolver c = new CharEqnSolver(t, d);
		} else if(op == 2){
			String matrix = "";
			int rows = 0, cols = 0;
			System.out.println("Enter number of rows:");
			rows = s.nextInt();
			System.out.println("Enter number of cols:");
			cols = s.nextInt();
			System.out.println("Enter matrix rows as comma separate lists.");
			int rowInd = 0;
			while(s.hasNext()){
				String row = s.next();
				rowInd++;
				String[] vals = row.split(",");
				if(vals.length != cols){
					System.out.println("All rows must be the same length");
					break;
				}
				matrix += row + ",";
				if(rowInd == rows){
					break;
				}
			}
			if(rows == cols){
				SquareMatrix m = new SquareMatrix(rows);
				m.setValues(matrix, ",");
				m.toConsole();
			} else {
				Matrix m = new Matrix(rows, cols);
				m.setValues(matrix, ",");
				m.toConsole();
			}
		}
		s.close();
	}
	
//	public Matrix newMatrix(){
//		
//	}
//	
//	public SquareMatrix newMatrix(){
//		
//	}

}

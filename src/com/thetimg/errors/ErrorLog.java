package com.thetimg.errors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ErrorLog {
	
	private static List<String> errors = new ArrayList<String>();
	
	public static void add(String type, String title, String message){
		String error = type.toUpperCase() + " " + title + ": " + message;
		errors.add(error);
	}
	
	public static void writeout(String location, String filename){
		File f = new File(location);
		if (!f.exists()){
		    f.mkdir();
		}
		try {
			LocalDateTime currentTime = LocalDateTime.now();
			Files.write(Paths.get(location + filename + currentTime.toLocalDate() + ".txt"), errors);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int getNumberOfErrors(){
		return errors.size();
	}

}

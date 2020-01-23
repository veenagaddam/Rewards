/*package com.rewards.calculator.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {

	public static void main(String[] args) {
		
		readFile();

	}
	
	private static void readFile() throws URISyntaxException, IOException{
		 Path path = Paths.get(getClass().getClassLoader()
			      .getResource("Rewards.txt").toURI());
			          
			    Stream<String> lines = Files.lines(path);
			    String data = lines.collect(Collectors.joining("\n"));
			    System.out.println("Data ::" + data);
				//return null;
		// TODO Auto-generated method stub
	}

}
*/
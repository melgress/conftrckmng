package main;
import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ctm_main {



	public static void main(String[] args) throws ParseException {
		
 
		try {

           BufferedReader in = new BufferedReader(new FileReader("file"));

           ConferencePlanner conferencePlanner = new ConferencePlanner();
           conferencePlanner.readFile(in);
				
			
		        
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		
		
		
	}

		
}

	
	

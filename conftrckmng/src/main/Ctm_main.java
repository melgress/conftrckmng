package main;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ctm_main {

	public static void main(String[] args) {
		
		      
		try {

			BufferedReader in = new BufferedReader(new FileReader("test3"));

			StringBuilder sb = new StringBuilder();
			
			String line;
			String title = null;
			String time = null;


			 while ((line = in.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
				

				//lightning rausnehmen
		        Pattern p1 = Pattern.compile("(^(?!(min|lightning)$)[a-z.A-Z-:()\\s]+)");
		        Matcher m1 = p1.matcher(line);
				Pattern p2 = Pattern.compile("((\\d+))");
		        Matcher m2 = p2.matcher(line);
				

		        while(m1.find()) {
		        	title = m1.group(1);
		        	
		            //System.out.println(title);
		            
		            
		        }
		        while(m2.find()) {
		        	time = m2.group(2);
		          
		        	
		          //  System.out.println(time);
		            
		            }
		        int timeInt = Integer. parseInt(time);
		        String min = "min";
		        Talks event = new Talks (title, timeInt, min);
		       // Session slot = new Session (0, 0);
		        //slot.addTalk(event);
			 }
				

			in.close();
				
				
			
		        
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
}


		    
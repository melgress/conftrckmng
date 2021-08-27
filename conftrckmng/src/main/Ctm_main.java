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
	        int totalMinutes = 0;

			
			String line;
			String title = null;
			String time = null;
		//	String timeLightning = null;
			Boolean nextExists = null;
			 Session slot = null;


			


			 while ((line = in.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
				

				//lightning aus Titel rausnehmen
		        Pattern p1 = Pattern.compile("(^(?!(min)$)[a-z.A-Z-:()\\s]+)");
		        Matcher m1 = p1.matcher(line);
				Pattern p2 = Pattern.compile("((\\d+))");
		        Matcher m2 = p2.matcher(line);
		        Pattern p3 = Pattern.compile("(((\\blightning\\b)))");
		        Matcher m3 = p3.matcher(line);
				

		        while(m1.find()) {
		        	title = m1.group(1);
		        	nextExists = true;
		        	
		        	if (m2.find()) {
		        		time = m2.group(2);
		        		} else 
		        			time = "5";
		        	
		            
		            
		        }

		            
		            
		        int timeInt = Integer. parseInt(time);
		        totalMinutes = totalMinutes + timeInt;
		        //System.out.println(totalMinutes);
		        String min = "min";
		        Talks event = new Talks (title, timeInt, min);

		        
		       
		      	
			 }
			
			
			calculateNumberTracks(totalMinutes);
			in.close();
			
			
				
				
			
		        
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		
		
		
	}
	public static void calculateNumberTracks (int totalMinutes) {
		double availableTrackMins = 480;
		//int tracksNeeded = 0;
		double tracksNeeded = totalMinutes/availableTrackMins;
		int total = (int) Math.ceil((double)tracksNeeded);
		System.out.println(totalMinutes);
		System.out.println(tracksNeeded);
		System.out.println(total);
		
	}
}


		    

package main;
import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ctm_main {
	public static List <Talks> eventList = new ArrayList<Talks>();	
	public static List <Talks> sorted = new ArrayList<Talks>();	
	public static Talks event;
	 public static int id = 0;
	 public static int count = 0;
	 public static int totalMinutes = 0;
	 public static int timeLeft = 0;
	 public static int maxs1Mins = 180;
	 public static int maxs2Mins = 300;



	public static void main(String[] args) throws ParseException {
		
 
		try {

           BufferedReader in = new BufferedReader(new FileReader("test3"));

			StringBuilder sb = new StringBuilder();
	        int totalMinutes = 0;

			
			String line;
			String title = null;
			String time = null;


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
		        	
		        	if (m2.find()) {
		        		time = m2.group(2);
		        		} else 
		        			time = "5";
		        	
		            
		            
		        }

		            
		            
		        int timeInt = Integer. parseInt(time);
		        totalMinutes = totalMinutes + timeInt;
		        //System.out.println(totalMinutes);
		        String min = "min";
		        event = new Talks (title, timeInt, min);
		        addToList(event);
		        count++;

		        
		       
		      	
			 }
			
			 sortTalks(count, eventList);
			in.close();	
				
			
		        
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		
		
		
	}

	public static void addToList (Talks events) {
		eventList.add(events);
		
	}
	
	public void getList () {
		String eventListString = null;
		for(int i = 0; i < id; i++) {
			 eventListString = eventList.get(i).toString();
		    System.out.print(eventListString);
		}
		
	}
	public static void sortTalks (int count, List<Talks> eventlist) throws ParseException {
       
		Collections.sort(eventList);
		  int  totalmin = 0;
		   
			for (Iterator<Talks> iter = eventlist.iterator(); iter.hasNext();) {
					
	            Talks talk = iter.next();
	            	sorted.add(talk);
	            	if (totalmin < maxs1Mins) {
		            	talk.setValue(1);
		            	totalmin = totalmin + talk.getDuration();

		            } else if (totalmin >= maxs1Mins && totalmin < maxs1Mins + maxs2Mins) {
		            	talk.setValue(2);
		            	totalmin = totalmin + talk.getDuration();

		            }
	            	
	          
	            }  event.setStartTime(sorted, totalmin, count);
			
	}

	
	
}
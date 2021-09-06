package main;
import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ctm_main {
	public static List <Talks> eventList = new ArrayList<Talks>();	
//	public static List <Talks> s2 = new ArrayList<Talks>();	
//	public static List <Talks> s1 = new ArrayList<Talks>();	
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
		        	id = id+1;
		        	//nextExists = true;
		        	
		        	if (m2.find()) {
		        		time = m2.group(2);
		        		} else 
		        			time = "5";
		        	
		            
		            
		        }

		            
		            
		        int timeInt = Integer. parseInt(time);
		        totalMinutes = totalMinutes + timeInt;
		        //System.out.println(totalMinutes);
		        String min = "min";
		        event = new Talks (id, title, timeInt, min);
		        addToList(event);
		        count++;

		        
		       
		      	
			 }
			
			
			//calculateNumberTracks(totalMinutes);
			// getList();
			// System.out.println(totalMinutes);
			 //System.out.println(count);
			 sortTalks(count, eventList);
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
		//System.out.println(totalMinutes);
		//System.out.println(tracksNeeded);
		//System.out.println(total);
		//sortTalks(total);
		
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
		 // total = total*2;
		 // System.out.println(count);
		  int i = 0;	 
		   
			for (Iterator<Talks> iter = eventlist.iterator(); iter.hasNext();) {
					
	            Talks talk = iter.next();
	            	sorted.add(talk);
	            	if (totalmin < maxs1Mins) {
		            	talk.setValue(1);
		            	totalmin = totalmin + talk.getDuration();
		            	//talk.setStartTime(talk, totalmin);
		            	//continue;
		            } else if (totalmin >= maxs1Mins && totalmin < maxs1Mins + maxs2Mins) {
		            	talk.setValue(2);
		            	totalmin = totalmin + talk.getDuration();
		            	//talk.setStartTime(talk, totalmin);
		            	//continue;
		            }
	            	
	          
	            }  event.setStartTime(sorted, totalmin);
			
		//	System.out.println("sorted " + sorted);
			int totalmins = 0;
			List <Talks> s2 = new ArrayList<Talks>();	
			List <Talks> s1 = new ArrayList<Talks>();
			for (Iterator<Talks> itera = sorted.iterator(); itera.hasNext();) {
				
				//System.out.println("hi2");
	            Talks talk = itera.next();
	            
	            if (totalmins < maxs1Mins) {
	            	s1.add(talk);
	            	talk.setValue(1);
	            	totalmins = totalmins + talk.getDuration();
	            	//talk.setStartTime(talk, totalmins);
	            	
	            //	System.out.println(totalmins);
	            	//System.out.println(s1);
	            	continue;
	            } else if (totalmins >= maxs1Mins && totalmins < maxs1Mins + maxs2Mins) {
	            	s2.add(talk);
	            	talk.setValue(2);
	            	totalmins = totalmins + talk.getDuration();
	            //	System.out.println(totalmins);
	            	//System.out.println(s2);
	            	continue;
	            }
	                //totalmins = 0;
	           
	            
	          
	              //else {
	        //System.out.println("morning: " + s1);
	         //System.out.println("afternoon: " + s2);
			//Session morning = new Session(s1);
			//Session afternoon = new Session (s2);
	            	  
			s1.clear();
			s2.clear();
		   //Tracks track = new Tracks (morning, afternoon);
			totalmins = 0;
			//System.out.println("hier");
			if (itera.hasNext()) {
				continue;
			} 
			break;
	        //    }
			}
	}
	public static void addToSession () {
	
         
	}
	
	
}

/*   for(Talks t: eventList ){
			 //  for (int i=0; i<count; i++) {

			   if (totalmin < 180) {
				   s1.add(t);
				//String newLine = System.getProperty("line.separator");
				//System.out.print(morningSession + newLine);

				totalmin = t.getDuration() + totalmin;
				//System.out.print(totalmin);

				i++;
			    continue;
					
			   } else if (totalmin >= 180 && totalmin <=480) {
					//System.out.print(totalmin);
                   
				   
				   s2.add(t);
				   String newLine = System.getProperty("line.separator");
					//System.out.print(afternoonSession + newLine);
				 
				   totalmin = t.getDuration() + totalmin;
				   i++;
				   //System.out.println(i);
				    continue;
			   }  
			   
				   System.out.println("done");
				   totalmin = 0;
				  // System.out.println(s1);
				   Session morningSession = new Session (s1);
				   Session afternoonSession = new Session (s2);
				   //Tracks track = new Tracks (morningSession, afternoonSession);
				  // System.out.println(s2);
				  
				  break;
			  // } 
 * 
 */

		    

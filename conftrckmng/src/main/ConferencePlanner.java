package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConferencePlanner {
	public static List <Talks> eventList = new ArrayList<Talks>();	
	public static List <Talks> sorted = new ArrayList<Talks>();	
	public static Talks event;
	public static int count = 0;
	public static String title = null;
	public static String time = null;
	public static String startTime;
	public static String name;
	public static int duration;
	public static String durationUnit;
	public static int value; //1 = s1, 2 = s2
	public boolean isLunch;
	public boolean isNetworkingEvent;
	//boolean NEsetted;
	public static Talks talk;
	public static double lastTimeSave = 0;
	public static int talkMins = 0;



	
	
	public static void addToList (Talks events) {
		eventList.add(events);
		
	}
	
	public void readFile (BufferedReader in) throws ParseException, NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
        int totalMinutes = 0;

		
		String line;
		
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
	        ConferencePlanner.addToList(event);
	        count++;

	        
	       
	      	
		 }

		sortTalks(count, eventList);
		in.close();	
	}
	
	public void sortTalks (int count, List<Talks> eventlist) throws ParseException {
	       
		Collections.sort(eventlist);
		  int  totalmin = 0;
		   
			for (Iterator<Talks> iter = eventlist.iterator(); iter.hasNext();) {
				
	            Talks talk = iter.next();
	            	sorted.add(talk);
					totalmin = totalmin + talk.getDuration();
		          
	            	
	          
	            }  
			
			setStartTime(sorted, totalmin, count);
			
	}
	
	public void setStartTime (List<Talks> sorted , double totalmins, int count) throws ParseException {
		int countTracks = 1;
		int totalmin = 0;
	    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
	    symbols.setDecimalSeparator('.');
	    
	    String dateString3 = "22.30";
    	SimpleDateFormat sdf1 = new SimpleDateFormat("HH.mm");
    	Date date3 = sdf1.parse(dateString3);
    	SimpleDateFormat sdf2 = new SimpleDateFormat("hh.mm aa");
    	
	    DecimalFormat formatter = new DecimalFormat("00.00", symbols);

		    Date start = sdf1.parse("09.00");
		    Date NetworkingEvent = sdf1.parse("16.00");
		    Date lunch = sdf1.parse("12.00");
		    String time = sdf1.format(start);
            
		    double lastTime = 9;
			String startTime = null;
			Talks talk = null;
			 Session session = new Session (startTime, talk);
			 ListIterator<Talks> iter = sorted.listIterator();
			 String lastTimeStr = null;
			 
		for (int i = -1; i<count; i++) {
			
		//	System.out.println(iter.hasNext());

			if (!iter.hasPrevious()) {
				System.out.println("Track " + countTracks + ":");
			}
			if (iter.hasNext()) {
		       talk = iter.next();

			}
			
			else {
				setIsNE(true);
			}
		
		
            totalmin = totalmin + talk.getDuration();
           

	   
	    double talkDu = talk.getDuration();
		double totalHours = talkDu/60;
		
		 

		if (talk.getDuration() >= 60) {
			
			talkMins = talk.getDuration();
			lastTimeSave = lastTime;			

		    lastTimeStr = formatter.format(lastTimeSave);
		   
		   start = sdf1.parse(lastTimeStr);
			lastTimeStr = sdf2.format(start);
			 time =sdf2.format(start);
			 
			 
			if (start.after(lunch) && isLunch == false || start.equals(lunch) && isLunch == false) {

				 Talks lunchTime = new Talks (" lunch ", 60, "min");
				 time =sdf2.format(start);
				 //talk = talkSave;
				 session.setTalks(lunchTime);
				 session.setStartTime(time);
				 //System.out.println(iter.next());
				 setIsLunch(true);	
				 count++;
				 talk = iter.previous();
			 }
			else if (start.after(NetworkingEvent) || isNetworkingEvent == true) {
				Talks NEtalk = new Talks (" Networking Event ", 60, "min");
				String startNE = "05:00 PM";
				 session.setTalks(NEtalk);
				 session.setStartTime(startNE);
				System.out.println(session.toString());
				if (iter.hasNext()) {
					System.out.println("");
					System.out.println("Track " + countTracks + ":");
					}
				countTracks++;
				Tracks track = new Tracks (session);
				lastTime = 9;
				setIsLunch(false);
				setIsNE(false);
				count++;
				if (iter.hasNext()) {
				talk =  iter.previous();
				} else if (!iter.hasNext()) {
					break;
				}
				
			}

			else {
		session.setTalks(talk);
		session.setStartTime(time +  " ");
			}
			
		lastTime = totalHours + lastTime;
		
		

		
		} 
		else if (talk.getDuration() < 60) {
			
			String total = null;
			int lastTimeMins = (int) (lastTime*60);
			int fullHours = lastTimeMins/60;
			int fullMins = lastTimeMins%60;
			
			if (fullMins == 0) {
				total = fullHours + "." + fullMins + fullMins;
			} else {
				total = fullHours + "." + fullMins;
			}
			
			start = sdf1.parse(total);
			
			time =sdf2.format(start);

			if (start.after(lunch) && isLunch == false || start.equals(lunch) && isLunch == false) {

				 Talks lunchTime = new Talks (" lunch ", 60, "min");
				 time =sdf2.format(start);
				 //talk = talkSave;
				 session.setTalks(lunchTime);
				 session.setStartTime(time);
				 //System.out.println(iter.next());
				 setIsLunch(true);	
				 talk = iter.previous();
				 count++;
			 }
			
			
			else if (start.after(NetworkingEvent) || isNetworkingEvent == true ) {
				Talks NEtalk = new Talks (" Networking Event ", 60, "min");
				String startNE = "05:00 PM";
				 session.setTalks(NEtalk);
				 session.setStartTime(startNE);
				 countTracks++;
				System.out.println(session.toString());
				if (iter.hasNext()) {
				System.out.println("");
				System.out.println("Track " + countTracks + ":");
				}
				Tracks track = new Tracks (session);
				lastTime = 9;
				setIsLunch(false);
				count++;
				if (iter.hasNext()) {
				talk =  iter.previous();
				continue;
				} else if (!iter.hasNext()) {
					break;
				}
				
			}
			else {
			session.setTalks(talk);
			session.setStartTime(time +  " ");
			}
			
			lastTime = lastTime + totalHours;
 			
			
		
		}

		System.out.println(session.toString());
		
		}
		
		


}
	
	 public boolean isLunch() {
	        return isLunch;
	    }
	 public void setIsLunch (boolean isLunch) {
	        this.isLunch = isLunch;
	    }
	 
	 public boolean isNE() {
	        return isNetworkingEvent;
	    }
	 public void setIsNE (boolean isNE) {
	        this.isNetworkingEvent= isNE;
	        
	        
	    }
	
}

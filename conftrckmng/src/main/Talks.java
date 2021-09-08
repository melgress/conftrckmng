package main;
import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
//Erzeugt ein Objekt Talk mit Name und Dauer des Talks
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

public class Talks implements Comparable <Talks> {
	
	String startTime;
	String name;
	int duration;
	String durationUnit;
	int id;
	int value; //1 = s1, 2 = s2
	boolean isLunch;
	boolean isNetworkingEvent;
	boolean NEsetted;
	Talks talk;



	public Talks (int id,String name, int duration, String durationUnit) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.durationUnit = durationUnit;
		//System.out.println(id + " Name: " + name + "Duration: " + duration + " DurationUnit: " + durationUnit);
			}
	
	
	@Override 
	public String toString () {
		return id + name + duration + durationUnit;
	}
	
    public boolean isLunch() {
	        return isLunch;
	    }
	 public void setIsLunch (boolean isLunch) {
	        this.isLunch = isLunch;
	    }
	 
	
	public String getName() {
	//	System.out.println("Name :" + name );
	      return name;
	}
	
	public void setName( String title ) {
	      name = title;
	   }
	
	public int getValue() {
		System.out.println("value :" + value );
	      return value;
	}
	
	public void setValue( int v ) {
	      value = v;
	   }
	
	public int getDuration() {
		//System.out.println(duration );
	      return duration;
	}
	
	public void setDuration( int time ) {
	      duration = time;
	   }
	
	public String getDurationUnit() {
		System.out.println("Unit :" + name );
	      return durationUnit;
	}
	
	public void setDurationUnit( String unit ) {
	      durationUnit = unit;
	   }

	@Override
    public int compareTo(Talks comparestu) {
        int compareDur=((Talks)comparestu).getDuration();
       
        return compareDur-this.duration;
    }
	
	public void setStartTime (List<Talks> sorted , double totalmins, int count) throws ParseException {
		int lastTimeMinutes = 0;
		int minutes = 0;
		int totalmin = 0;
	    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
	    symbols.setDecimalSeparator(':');
	    DecimalFormat formatter = new DecimalFormat("00.00", symbols);
	    //System.out.println(formatter.format(45.45889));
	    String datumString = "09:00";
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		    Date start = sdf.parse("09:00");
		    Date startSave = sdf.parse("09:00");
		    Date NetworkingEvent = sdf.parse("16:00");
		   String time=sdf.format(start);
            
		    double lastTime = 9;
			String startTime = null;
			Talks talk = null;
			 Session session = new Session (startTime, talk);
			 int count2 = -1;
			 Iterator<Talks> iter = sorted.iterator();
		for (int i = -2; i<count; i++) {
			//System.out.println(start);
		
			if (start.after(NetworkingEvent) || count == count2) {
				talk = new Talks (100, "Networking Event", 60, "min");
				String startNE = "17:00";
				session.setTalks(talk);
				session.setStartTime(startNE);
				System.out.println(session.toString());
				Tracks track = new Tracks (session);
				lastTime = 9;
				if (iter.hasNext()) {
				talk =  iter.next();
				lastTime = (lastTime*60 - talk.getDuration())/60;
				System.out.println(lastTime);
				} else if (!iter.hasNext()) {
					break;
				}
				
			}

			else if (isLunch == true) {
			 talk = new Talks (99, "lunch", 60, "min");
			 //count2++;
			 setIsLunch(false);
			}
			
			 
			else {
	          talk = iter.next();
			}
            totalmin = totalmin + talk.getDuration();
           

            //System.out.println(time + " " + talk);
            //System.out.println("hier");
            
		//Integer.toString(123)
		String AM = "AM";
		String PM = "PM";
	    
	    //System.out.println(totalmin);
	   
	    double talkDu = talk.getDuration();
		double totalHours = talkDu/60;
		 if (totalmin == 180) {
		    	setIsLunch(true);		
		    	
		    }
		 
		//System.out.println(totalmin);
		
		//System.out.println(time + " " + talk)
		if (talk.getDuration() >= 60) {
			
			double lastTimeSave = lastTime;
			lastTime = totalHours + lastTime;
		String lastTimeStr = formatter.format(lastTimeSave);
		
		startSave = start;
		start = sdf.parse(lastTimeStr);
		time =sdf.format(start);
		//System.out.println(time);
		session.setTalks(talk);
		session.setStartTime(time);
		 count2++;
		

		
		} 
		else if (talk.getDuration() < 60) {
			//System.out.println(lastTime);
			
			double lastTimeSave = lastTime;
			lastTime = lastTimeSave;
			lastTime = lastTime + totalHours;
			int lastTimeMins = (int) (lastTime*60);
			int fullHours = lastTimeMins/60;
			int fullMins = lastTimeMins%60;
		
			String total = fullHours + ":" + fullMins;
			
			startSave = start;
			start = sdf.parse(total);
			//System.out.println(start);
			time =sdf.format(start);
			
			session.setTalks(talk);
			session.setStartTime(time);
			count2++;

		
		}
		
		//System.out.println("hier");
		System.out.println(session.toString());
		}

	}
}

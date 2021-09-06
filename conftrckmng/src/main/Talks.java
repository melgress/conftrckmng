package main;
import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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



	public Talks (int id,String name, int duration, String durationUnit) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.durationUnit = durationUnit;
		//System.out.println(id + " Name: " + name + "Duration: " + duration + " DurationUnit: " + durationUnit);
			}
	
	public Talks (int value, int id,String name, int duration, String durationUnit) {
		this.value = value;
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
	/*public void testPrint () {
		System.out.println("hier" + name + ": " + duration);

	}*/

	
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
	
	public void setStartTime (List<Talks> sorted , double totalmins) throws ParseException {
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
		   String time=sdf.format(start);
            
		    double lastTime = 9;
		   // System.out.println(sdf.format(start) + " to " + sdf.format(end));
		for (Iterator<Talks> iter = sorted.iterator(); iter.hasNext();) {
				
            Talks talk = iter.next();
            System.out.println(time + " " + talk);
		//Integer.toString(123)
		String AM = "AM";
		String PM = "PM";
	    totalmin = totalmin + talk.getDuration();
	    double talkDu = talk.getDuration();
		double totalHours = talkDu/60;
		//System.out.println(totalmin);
//		if (time.equals("12:00")) {
//			System.out.println(time + " " + "lunch");
//			totalHours = 1;
//			lastTime = totalHours + lastTime;
//			
//			String lastTimeStr = formatter.format(lastTime);
//			startTime = String.valueOf(lastTimeStr);
//			start = sdf.parse(lastTimeStr);
//			time =sdf.format(start);
//		}
//		else if (time.equals("05:00")) {
//			System.out.println(time + " " + "Networking Event");
//			time = "06:00";
//		}
		//System.out.println(time + " " + talk)
		if (talk.getDuration() >= 60) {
		lastTime = totalHours + lastTime;
		//double modu = 6%2;
	//	System.out.println(lastTime);
		
		String lastTimeStr = formatter.format(lastTime);
		//System.out.println(lastTimeStr);
		
		//startTime = String.valueOf(lastTimeStr);
		start = sdf.parse(lastTimeStr);
		time =sdf.format(start);
		//System.out.println(time);
		} else if (talk.getDuration() < 60) {
			lastTime = lastTime + totalHours;
			//System.out.println(lastTime);
			int lastTimeMins = (int) (lastTime*60);
			int fullHours = lastTimeMins/60;
			int fullMins = lastTimeMins%60;
			String total = fullHours + ":" + fullMins;
			//System.out.println(total);
			
			//String lastTimeStr = formatter.format(total);
			//startTime = String.valueOf(lastTimeStr);
			start = sdf.parse(total);
			time =sdf.format(start);
		}
		
		}
	}
}

/*
 * //double lastTimeMinutes;
			//lastTimeMinutes = (int) (lastTime * 60);
			
			
			//double save = lastTime + totalHours - lastTime;
			//double convert = (save * 60)/100;
			int lastTimeHours = (int) (lastTimeMinutes/60);
			//System.out.println(lastTimeHours);
			minutes = talk.getDuration()%60;
			//System.out.println(minutes);
			//int hours = talk.getDuration()/60;
			//int minutes = talk.getDuration()%60;
			//int total = hours + minutes;
			//int lastTimeInt = (int) lastTime;
			//System.out.println(lastTimeInt);
			double mins = lastTimeMinutes + minutes;
			double minss = mins/60;
			double total = lastTimeHours + minss;
			System.out.println(total);
			String last = lastTimeHours + ":" + minutes;
			//System.out.println(total);
			//System.out.println(last);
			//System.out.println(convert);
			//lastTime = convert + lastTime;
			//double wup = lastTime - totalHours + convert;
			//String test = lastTime + ":" + convert;
			 //System.out.println(wup);
			
			String lastTimeStr = formatter.format(total);
			//System.out.println(lastTimeStr);
			
			//String lastTimeString = String.valueOf(lastTimeStr);
			start = sdf.parse(lastTimeStr);
			time =sdf.format(start);
			lastTime = totalHours + lastTime;
			//System.out.println(lastTime);
			lastTimeMinutes = talk.getDuration()%60;
 */
	


	
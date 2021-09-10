package main;
import java.text.*;
import java.util.*;


public class Talks implements Comparable <Talks> {
	
	String startTime;
	String name;
	int duration;
	String durationUnit;
	int value; //1 = s1, 2 = s2
	boolean isLunch;
	boolean isNetworkingEvent;
	boolean NEsetted;
	Talks talk;
	double lastTimeSave = 0;
	int talkMins = 0;



	public Talks (String name, int duration, String durationUnit) {
		this.name = name;
		this.duration = duration;
		this.durationUnit = durationUnit;
		//System.out.println(id + " Name: " + name + "Duration: " + duration + " DurationUnit: " + durationUnit);
			}
	
	
	@Override 
	public String toString () {
		return  name + duration + durationUnit;
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
		int countTracks = 1;
		int totalmin = 0;
	    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
	    symbols.setDecimalSeparator(':');
	    DecimalFormat formatter = new DecimalFormat("00.00", symbols);
	    //System.out.println(formatter.format(45.45889));
	    DateFormat sdf = new SimpleDateFormat("hh:mm", Locale.ENGLISH);
		//SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
		    Date start = sdf.parse("09:00");
		    Date NetworkingEvent = sdf.parse("15:30");
		    Date lunch = sdf.parse("12:00");
		   String time=sdf.format(start);
            
		    double lastTime = 9;
			String startTime = null;
			Talks talk = null;
			 Session session = new Session (startTime, talk);
			 int count2 = 1;
			 Iterator<Talks> iter = sorted.iterator();
			 
		for (int i = 0; i<count; i++) {
			//System.out.println(start);
			
	
			if (start.after(NetworkingEvent) || count == count2) {
				talk = new Talks (" Networking Event ", 60, "min");
				String startNE = "05:00PM";
				session.setTalks(talk);
				session.setStartTime(startNE);
				System.out.println(session.toString());
				System.out.println("");
				countTracks++;
				Tracks track = new Tracks (session);
				lastTime = 9;
				if (iter.hasNext()) {
				talk =  iter.next();
				} else if (!iter.hasNext()) {
					break;
				}
				
			}
					
	          talk = iter.next();
	          
			
            totalmin = totalmin + talk.getDuration();
           

	   
	    double talkDu = talk.getDuration();
		double totalHours = talkDu/60;
		 if (lastTime == 12.0 ) {
		    	setIsLunch(true);	
		    	talk = new Talks ("lunch ", 60, "min");
				 //count2++;
				 setIsLunch(false);
		    	
		    }
		 

		if (talk.getDuration() >= 60) {
			
			talkMins = talk.getDuration();
			lastTimeSave = lastTime;
			lastTime = totalHours + lastTime;
		String lastTimeStr = formatter.format(lastTimeSave);
		start = sdf.parse(lastTimeStr);
	
		if (lastTimeSave < 12) {
			 time =sdf.format(start) + "AM ";
			}
		else if (lastTimeSave == 12 || lastTimeSave > 12) {
			time =sdf.format(start) + "PM ";
			}
	   
		session.setTalks(talk);
		session.setStartTime(time);
		 count2++;
		

		
		} 
		else if (talk.getDuration() < 60) {

			int lastTimeMins = (int) (lastTime*60);
			int fullHours = lastTimeMins/60;
			int fullMins = lastTimeMins%60;
		
			String total = fullHours + ":" + fullMins;
			if (fullHours < 12) {
				total = fullHours + ":" + fullMins + "AM ";
				} 
			
			
			start = sdf.parse(total);
			if (fullHours < 12) {
				time =sdf.format(start) + "AM ";
				} 
			else if (fullHours == 12) {
				time =sdf.format(start) + "PM ";
			} 
			else if (fullHours > 12) {
				time =sdf.format(start) + "PM ";

			} 
			
			lastTime = lastTime + totalHours;
			session.setTalks(talk);
			session.setStartTime(time);
			count2++;

		
		}
		if (time.equals("09:00AM ")) {
			System.out.println("Track " + countTracks + ":");
			System.out.println(session.toString());
			continue;
		}
		System.out.println(session.toString());
		}

	}
}
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
	//boolean NEsetted;
	Talks talk;
	double lastTimeSave = 0;
	int talkMins = 0;



	public Talks (String name, int duration, String durationUnit) {
		this.name = name;
		this.duration = duration;
		this.durationUnit = durationUnit;
		//System.out.println(id + " Name: " + name + "Duration: " + duration + " DurationUnit: " + durationUnit);
			}
	
	public Talks () {
			}
	
	public Talks (String name) {
		this.name = name;
	}
	
	
	@Override 
	public String toString () {
		return  name + duration + durationUnit;
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
	
	


}
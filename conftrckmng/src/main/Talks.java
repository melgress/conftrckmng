package main;
import java.io.*;
//Erzeugt ein Objekt Talk mit Name und Dauer des Talks

public class Talks {
	
	String name;
	int duration;
	String durationUnit;

	public Talks (String name, int duration, String durationUnit) {
		this.name = name;
		this.duration = duration;
		this.durationUnit = durationUnit;
		System.out.println("Name: " + name + "Duration: " + duration + " DurationUnit: " + durationUnit);
			}
	
	
	/*public void testPrint () {
		System.out.println("hier" + name + ": " + duration);

	}*/
	
	public String getName() {
		System.out.println("Name :" + name );
	      return name;
	}
	
	public void setName( String title ) {
	      name = title;
	   }
	
	public int getDuration() {
		System.out.println(duration );
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
	

}
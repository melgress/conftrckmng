package main;
import java.io.*;
//Erzeugt ein Objekt Talk mit Name und Dauer des Talks

public class Talks implements Comparable <Talks> {
	
	String name;
	int duration;
	String durationUnit;
	int id;

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
	
//	 public int compareTo(Talks m) {
//		 return this.getDuration() < m.getDuration() ? -1 : (this.getDuration() == m.getDuration() ? 0 : 1);
//	    }
	@Override
    public int compareTo(Talks comparestu) {
        int compareDur=((Talks)comparestu).getDuration();
       
        return compareDur-this.duration;
    }

	

}

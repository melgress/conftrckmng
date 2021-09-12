package main;

import java.util.*;

public class Session {
	 
	List <Talks> events;
    Talks talks;
	Talks event;
	int id = 0;
	String eventListString;
	String startTime;
	String title;
		
	
	public Session (String startTime, Talks talks)  {
		this.talks = talks;
		this.startTime = startTime;
		
		}
	public Session (String startTime, String title)  {
		this.title = title;
		this.startTime = startTime;
		
	
		}
	
	@Override 
	public String toString () {
		return startTime + talks;
	}
	

	
	public Talks getTalk() {
		//	System.out.println("Name :" + name );
		      return talks;
		}
		
	public void setTalks( Talks talk ) {
		      talks = talk;
		   }
	
	public void setTalkName( String name ) {
	      title = name;
	   }
	
	public String getstartTime() {
			//	System.out.println("Name :" + name );
			      return startTime;
			}
			
	public void setStartTime( String time ) {
			      startTime = time;
			   }
	
	
}


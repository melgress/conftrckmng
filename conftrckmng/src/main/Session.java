package main;
//Hier wird ein Session Objekt erzeugt, welches Talks und Zeiten enth�lt

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

public class Session {
	 
	List <Talks> events;
    Talks talks;
	Talks event;
	int id = 0;
	String eventListString;
	String startTime;
		
	
	public Session (String startTime, Talks talks)  {
		this.talks = talks;
		this.startTime = startTime;
		//events = new ArrayList<Talks>();
		/*for(Talks event: eventList) {
		    System.out.println(event);  // Will invoke overrided `toString()` method
		}	*/
		//System.out.println(startTime + ": "+ talks);
	
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
	public String getstartTime() {
			//	System.out.println("Name :" + name );
			      return startTime;
			}
			
	public void setStartTime( String time ) {
			      startTime = time;
			   }
	
	
}


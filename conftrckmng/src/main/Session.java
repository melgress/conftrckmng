package main;
//Hier wird ein Session Objekt erzeugt, welches Talks und Zeiten enth�lt

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

public class Session {
	 
	List <Talks> events;
	Talks event;
	int id = 0;
	String eventListString;
		
	
	public Session (List <Talks> eventList)  {
		//events = new ArrayList<Talks>();
		for(Talks event: eventList) {
		    System.out.println(event);  // Will invoke overrided `toString()` method
		}
		//System.out.println(events);
		}
	
	
	
	    public void doMorning() {
	    	
		System.out.println("hi");
		
	}
	
	
}
	
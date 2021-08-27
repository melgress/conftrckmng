package main;
//Hier wird ein Session Objekt erzeugt, welches Talks und Zeiten enthält

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

public class Session {
	 
	List <Talks> events;
	Talks event;
	int startTime;
	int timeNeeded;
	int durationLeft;
	int duration;
	//Talks event;
	
	
	public Session (List <Talks> events)  {
		events = new ArrayList<Talks>();
		
		
		
	}
	
	
	/*Session morningSession = new Session(events, 9, 180);
	Session lunch = new Session (events, 12, 60);
	Session afternoonSession = new Session (events, 13, 300);*/
	
	public void addTalk (Talks event, Boolean nextExists) {

				events.add(event);
				//durationLeft = durationLeft-timeNeeded;
				System.out.println("hinzugefügt");
				
			} 
	
	/*@Override
	  public String toString() {
		String eventsString = events.toString();
	    return event.name;
	  }*/
		
		public void printList () {
			System.out.println(events.toString());
		}
	}
	
	



/*
 * 		durationLeft = 180;
		timeNeeded = event.getDuration();
		while (nextExists == true)
			if (timeNeeded < durationLeft) {
				//System.out.println(durationLeft);
 */

/*Data objt = new Data(name, address, contact); // Creating a new object
Contacts.add(objt); // Adding it to the list*/
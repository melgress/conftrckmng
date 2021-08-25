package main;
//Hier wird ein Session Objekt erzeugt, welches Talks und Zeiten enth�lt

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

public class Session {
	 
	List <Talks> events;
	int startTime;
	int timeNeeded;
	int durationLeft;
	Talks event;
	
	
	public Session (int start, int duration)  {
		events = new ArrayList<Talks>();
		this.startTime = start;
		this.durationLeft = duration;	
		
	}
	
	/*Session morningSession = new Session(events, 9, 180);
	Session lunch = new Session (events, 12, 60);
	Session afternoonSession = new Session (events, 13, 300);*/
	
	public void addTalk (Talks event) {
		durationLeft = 180;
		timeNeeded = event.getDuration();
		while (durationLeft != 0) {
			if (timeNeeded < durationLeft) {
				events.add(event);
				durationLeft = durationLeft-timeNeeded;
				System.out.println(events);
			} else  {
				System.out.println("Session voll");
				break;
			}
		}
		
		
	}
	
	

}


/*Data objt = new Data(name, address, contact); // Creating a new object
Contacts.add(objt); // Adding it to the list*/
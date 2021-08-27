package main;
//Hier wird ein Track Objekt erzeugt, welches aus zwei Sessions besteht

import java.util.List;

public class Tracks {
	List <Talks> events;
	Session afterNoonSession = new Session(events);
	Session morningSession = new Session(events);
	
	
	public Tracks (Session morningSession, Session afternoonSession) {
		this.morningSession = morningSession;
		this.afterNoonSession = afternoonSession;
		
	}

}

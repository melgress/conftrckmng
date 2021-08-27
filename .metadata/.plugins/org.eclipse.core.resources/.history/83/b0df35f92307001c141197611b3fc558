package main;

import java.util.List;

//Hier wird ein Konferenz Objekt erzeugt, zu welchem Tracks hinzugefügt werden können

public class Conference {
	Talks events;
	Session session1 = new Session ((List<Talks>) events);
	Session session2 = new Session ((List<Talks>) events);
	
	Tracks tracks = new Tracks(session1, session2);
	
	public Conference (Tracks tracks) {
		this.tracks = tracks;
	}

}

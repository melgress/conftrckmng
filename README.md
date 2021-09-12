# conftrckmng

Folgendes habe ich umgesetzt:
1.	Die Events werden eingelesen 
2.	Mithilfe eines Regex Patterns werden Name, Dauer und der Zusatz „min“ getrennt
3.	Mithilfe von Name, Dauer und Zusatz wird ein Talk-Objekt erzeugt
4.	Die Talk-Objekte werden in die Liste „eventList“ gelegt.
5.	Sobald alle Events in der Liste sind, wird mit dieser Liste die Methode sortTalks aufgerufen, die mithilfe von Collections die Liste absteigend sortiert.
6.	Mit der sortierten Liste wird die Methode „setStartTime“ aufgerufen. Hier werden die Events mit Ihrer Startzeit versehen und in einem Session-Objekt abgelegt. Am Ende eines Tages (nach dem Networking Event, wird mit dieser Session ein Track-Objekt erstellt).

Anmerkungen:
-	Es fehlt an einigen Stellen die Auslagerung in andere Methoden oder Klassen 
-	Das Ganze wurde nur lokal aufgesetzt 


Eingabe:  
Writing Fast Tests Against Enterprise Rails 60min  
Overdoing it in Python 45min  
Lua for the Masses 30min  
Ruby Errors from Mismatched Gem Versions 45min  
Common Ruby Errors 45min  
Rails for Python Developers lightning  
Communicating Over Distance 60min  
Accounting-Driven Development 45min  
Woah 30min  
Sit Down and Write 30min  
Pair Programming vs Noise 45min  
Rails Magic 60min  
Ruby on Rails: Why We Should Move On 60min  
Clojure Ate Scala (on my project) 45min  
Programming in the Boondocks of Seattle 30min  
Ruby vs. Clojure for Back-End Development 30min  
Ruby on Rails Legacy App Maintenance 60min  
A World Without HackerNews 30min  
User Interface CSS in Rails Apps 30min  
  
Augabe:  
Track 1:  
09.00 AM Writing Fast Tests Against Enterprise Rails 60min  
10.00 AM Communicating Over Distance 60min  
11.00 AM Rails Magic 60min  
12.00 PM Lunch 60min  
01.00 PM Ruby on Rails: Why We Should Move On 60min  
02.00 PM Ruby on Rails Legacy App Maintenance 60min  
03.00 PM Overdoing it in Python 45min  
03.45 PM Ruby Errors from Mismatched Gem Versions 45min  
05:00 PM Networking Event 60min  
  
Track 2:  
09.00 AM Common Ruby Errors 45min  
09.45 AM Accounting-Driven Development 45min  
10.30 AM Pair Programming vs Noise 45min  
11.15 AM Clojure Ate Scala (on my project) 45min  
12.00 PM Lunch 60min  
12.30 PM Lua for the Masses 30min  
01.00 PM Woah 30min  
01.30 PM Sit Down and Write 30min  
02.00 PM Programming in the Boondocks of Seattle 30min  
02.30 PM Ruby vs. Clojure for Back-End Development 30min  
03.00 PM A World Without HackerNews 30min  
03.30 PM User Interface CSS in Rails Apps 30min  
04.00 PM Rails for Python Developers lightning5min  
05:00 PM Networking Event 60min  


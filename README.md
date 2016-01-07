# LanguageDetect
A simple JavaFX program that detects the given texts language. Includes some OOP design patterns.
This project is an assignment for the OOP class.

#Libraries
- Jsoup-1.8.3 -- to get the context of the given link.(for now, only wikipedia links work.)
- JUnit-4.12 -- for testing.
- MongoDB Java Driver -- for connecting to the db.

#Database
MongoDB was used to hold the sample lists.

#Adding samples
- Click the add sample button.
- Write the language of the samples you want to add.
- Write the special characters of the language.
- Write the wikipedia links that you want to add as samples.
- Click add button and wait for the "done" message.

If the language you specified is already in the database as a sample language, links  that you have
given will be added to that language as samples.
If it is not in the database, it will be added as a new language.

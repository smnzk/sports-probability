Spring Boot application.

GET endpoints:

/results 
(optional query parameters: amount, competitionName)

/competitors 
(optional query parameters: competitionName)

/results returns most probable results
/competitors shows all competitors of the chosen event sorted alphabetically

By default competition name is UEFA Champions League, since it was specifically requested in the task.
However, if another name is passed in query parameter and the JSON file contains events with that name, the results for that event will be displayed.

Amount means how many results should be returned. Default value is 10.

Endpoints return JSON data and print results on the console, so for example GET request like:

http://localhost:8080/results?amount=1

will return JSON data:

[
    {
        "startDate": "2021-06-22 18:00:00",
        "matchDescription": "SS Folgore Falciano Calcio (San Marino) vs FC Prishtina (Kosovo)",
        "venueName": "Elbasan Arena",
        "higestProbableResult": "DRAW (88.1)"
    }
]

and will print on the console:

StartDate: 2021-06-22 18:00:00, 
SS Folgore Falciano Calcio (San Marino) vs FC Prishtina (Kosovo), 
Venue: Elbasan Arena, 
Highest probable result: DRAW (88.1)

Same goes for competitors endpoint

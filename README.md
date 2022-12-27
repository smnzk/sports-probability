Spring Boot application.

How to run: Open the project in the editor and run, check for the assigned port and start making requests, for example: http://localhost:8080/results?amount=2

GET endpoints:

<b>/results</b>\
(optional query parameters: amount, competitionName)

<b>/competitors</b>\
(optional query parameters: competitionName)

<b>/results</b> returns most probable results\
<b>/competitors</b> shows all competitors of the chosen event sorted alphabetically

By default <b>"competition name"</b> parameter is UEFA Champions League, since it was specifically requested in the task.\
However, if another name is passed in query parameter and the JSON file contains events with that name, the results for that event will be displayed.

<b>"amount"</b> parameter means how many results should be returned. Default value is 10.

Endpoints return JSON data and print results on the console, since printing was requested in the task.

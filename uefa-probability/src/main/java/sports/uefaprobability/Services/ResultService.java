package sports.uefaprobability.Services;

import org.springframework.stereotype.Service;
import sports.uefaprobability.Models.Event;
import sports.uefaprobability.Models.Result;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {

    public List<Result> getMostProbableResults(List<Event> events) {

        ArrayList<Result> results = new ArrayList<>();

        for (Event e : events) {
            String startDate = e.getStartDate().replace("T", " ").substring(0, e.getStartDate().length() - 6);
            String matchDescription = e.getCompetitors().get(0).getName() +
                    " (" + e.getCompetitors().get(0).getCountry() +") " +"vs " +
                    e.getCompetitors().get(1).getName() + " (" + e.getCompetitors().get(1).getCountry() +")";

            String venueName = e.getVenue().getName();
            String winner = "";

            if (e.getProbabilityHomeTeamWinner().equals(e.getHighestProbability())) {
                winner = "HOME_TEAM_WIN";
            } else if (e.getProbabilityAwayTeamWinner().equals(e.getHighestProbability())) {
                winner = "AWAY_TEAM_WIN";
            } else {
                winner = "DRAW";
            }
            String highestProbableResult = winner + " (" + e.getHighestProbability() + ")";

            results.add(new Result(
                startDate,
                matchDescription,
                venueName,
                highestProbableResult
            ));
        }

        for(Result r : results) {
            System.out.println();
            System.out.println(
                    "StartDate: " + r.getStartDate() + ", \n"
                    + r.getMatchDescription() + ", \n"
                    + "Venue: " + r.getVenueName() + ", \n"
                    + "Highest probable result: " + r.getHigestProbableResult()
            );
        }
        return results;
    }
}

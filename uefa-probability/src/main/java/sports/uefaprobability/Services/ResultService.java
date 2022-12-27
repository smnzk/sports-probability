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
            String matchDescription = e.getCompetitors().get(0).getName() +
                    " (" + e.getCompetitors().get(0).getCountry() +") " +"vs " +
                    e.getCompetitors().get(1).getName() + " (" + e.getCompetitors().get(1).getCountry() +") ";
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
                e.getStartDate(),
                matchDescription,
                venueName,
                highestProbableResult
            ));
        }
        return results;
    }
}

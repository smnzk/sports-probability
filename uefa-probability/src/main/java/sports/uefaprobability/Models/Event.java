package sports.uefaprobability.Models;

import java.util.ArrayList;
import java.util.stream.DoubleStream;

public class Event {

    private String id;
    private String startDate;
    private String sportName;
    private String competitionName;
    private String competitionId;
    private String seasonName;
    private ArrayList<Competitor> competitors;
    private Venue venue;
    private Double probabilityHomeTeamWinner;
    private Double probabilityDraw;
    private Double probabilityAwayTeamWinner;
    private Double highestProbability;

    public Event() {
    }

    public Event(String id, String startDate, String sportName, String competitionName, String competitionId, String seasonName, ArrayList<Competitor> competitors, Venue venue, Double probabilityHomeTeamWinner, Double probabilityDraw, Double probabilityAwayTeamWinner) {
        this.id = id;
        this.startDate = startDate;
        this.sportName = sportName;
        this.competitionName = competitionName;
        this.competitionId = competitionId;
        this.seasonName = seasonName;
        this.competitors = competitors;
        this.venue = venue;
        this.probabilityHomeTeamWinner = probabilityHomeTeamWinner;
        this.probabilityDraw = probabilityDraw;
        this.probabilityAwayTeamWinner = probabilityAwayTeamWinner;
        this.highestProbability = DoubleStream.of(probabilityHomeTeamWinner, probabilityDraw, probabilityAwayTeamWinner).max().getAsDouble();
    }

    public Double getHighestProbability() {
        return highestProbability;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public ArrayList<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(ArrayList<Competitor> competitors) {
        this.competitors = competitors;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Double getProbabilityHomeTeamWinner() {
        return probabilityHomeTeamWinner;
    }

    public void setProbabilityHomeTeamWinner(Double probabilityHomeTeamWinner) {
        this.probabilityHomeTeamWinner = probabilityHomeTeamWinner;
    }

    public Double getProbabilityDraw() {
        return probabilityDraw;
    }

    public void setProbabilityDraw(Double probabilityDraw) {
        this.probabilityDraw = probabilityDraw;
    }

    public Double getProbabilityAwayTeamWinner() {
        return probabilityAwayTeamWinner;
    }

    public void setProbabilityAwayTeamWinner(Double probabilityAwayTeamWinner) {
        this.probabilityAwayTeamWinner = probabilityAwayTeamWinner;
    }
}

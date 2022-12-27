package sports.uefaprobability.Models;

public class Result {
    private String startDate;
    private String matchDescription;
    private String venueName;
    private String higestProbableResult;

    public Result() {
    }

    public Result(String startDate, String matchDescription, String venueName, String higestProbableResult) {
        this.startDate = startDate;
        this.matchDescription = matchDescription;
        this.venueName = venueName;
        this.higestProbableResult = higestProbableResult;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getMatchDescription() {
        return matchDescription;
    }

    public void setMatchDescription(String matchDescription) {
        this.matchDescription = matchDescription;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getHigestProbableResult() {
        return higestProbableResult;
    }

    public void setHigestProbableResult(String higestProbableResult) {
        this.higestProbableResult = higestProbableResult;
    }
}

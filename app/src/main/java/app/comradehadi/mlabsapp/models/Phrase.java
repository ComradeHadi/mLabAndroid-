package app.comradehadi.mlabsapp.models;

public class Phrase {
    String summary;
    String performance;
    String winner;
    String delta;

    public Phrase(String summary, String performance, String winner, String delta){

        this.summary = summary;
        this.performance = performance;
        this.winner = winner;
        this.delta = delta;
    }

    public String getSummary() {
        return summary;
    }

    public String getPerformance() {
        return performance;
    }

    public String getWinner() {
        return winner;
    }

    public String getDelta() {
        return delta;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setDelta(String delta) {
        this.delta = delta;
    }
}

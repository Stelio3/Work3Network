package a.benri.work3_network.ForniteTracker;

public class StatsSon {
    private StatsSonData score;
    private StatsSonData scorePerMatch;
    private StatsSonData matches;
    private StatsSonData kills;

    public StatsSonData getScore() {
        return score;
    }

    public void setScore(StatsSonData score) {
        this.score = score;
    }

    public StatsSonData getScorePerMatch() {
        return scorePerMatch;
    }

    public void setScorePerMatch(StatsSonData scorePerMatch) {
        this.scorePerMatch = scorePerMatch;
    }

    public StatsSonData getMatches() {
        return matches;
    }

    public void setMatches(StatsSonData matches) {
        this.matches = matches;
    }

    public StatsSonData getKills() {
        return kills;
    }

    public void setKills(StatsSonData kills) {
        this.kills = kills;
    }
}

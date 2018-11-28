package a.benri.work3_network.ForniteTracker;

//modelo 3º fila
public class StatsSon {
    private StatsSonData score;
    private StatsSonData scorePerMatch;
    private StatsSonData matches;
    private StatsSonData kills;

    public StatsSonData getScore() {
        return score;
    }
    public StatsSonData getScorePerMatch() {
        return scorePerMatch;
    }
    public StatsSonData getMatches() {
        return matches;
    }
    public StatsSonData getKills() {
        return kills;
    }
}

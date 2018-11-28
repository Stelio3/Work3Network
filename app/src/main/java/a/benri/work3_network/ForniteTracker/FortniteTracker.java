package a.benri.work3_network.ForniteTracker;

//modelo 1º fila
public class FortniteTracker {
    private String accountId;
    private String platformId;
    private String platformName;
    private String platformNameLong;
    private String epicUserHandle;
    private Stats stats;

    //Solo me hace falta hacer el stats que es la propiedad que voy a usar
    public Stats getStats() {
        return stats;
    }
}

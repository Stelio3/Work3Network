package a.benri.work3_network.ForniteTracker;

import io.reactivex.Observable;

public class FortniteTrackerRepository {

    private static volatile FortniteTrackerRepository mInstance = new FortniteTrackerRepository();
    //Intancia de la interfaz que llama a su método Factory que contiene el retrofit
    private FortniteTrackerApi fortniteTrackerApi = FortniteTrackerApi.Factory();

    public FortniteTrackerRepository() {
    }

    static FortniteTrackerRepository getInstance() {
        if (mInstance == null) {
            synchronized (FortniteTrackerRepository.class) {
                if (mInstance == null) {
                    mInstance = new FortniteTrackerRepository();
                }
            }
        }
        return mInstance;
    }
    // recoge los valores de plataforma en la que juega el jugador y su nickname
    public Observable<FortniteTracker> getFortniteUser(String platform, String playerName){
        return fortniteTrackerApi.getFortniteUser(platform,playerName);
    }
}

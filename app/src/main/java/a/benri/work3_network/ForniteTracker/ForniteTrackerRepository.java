package a.benri.work3_network.ForniteTracker;

import java.util.List;

import io.reactivex.Observable;

public class ForniteTrackerRepository {

    private static volatile ForniteTrackerRepository mInstance = new ForniteTrackerRepository();

    static ForniteTrackerRepository getInstance() {
        if (mInstance == null) {
            synchronized (ForniteTrackerRepository.class) {
                if (mInstance == null) {
                    mInstance = new ForniteTrackerRepository();
                }
            }
        }
        return mInstance;
    }

    public ForniteTrackerRepository() {
    }

    private ForniteTrackerApi forniteTrackerApi = ForniteTrackerApi.Factory();


    public Observable<ForniteTracker> getInfoFornite(String platform, String epic_nickname){
        //return gerritAPI.loadChanges(status);
        return forniteTrackerApi.getInfoFornite(platform,epic_nickname);
    }
}

package a.benri.work3_network.ForniteTracker;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ForniteTrackerViewModel extends ViewModel {
    private ForniteTrackerRepository forniteTrackerRepository = ForniteTrackerRepository.getInstance();
    public MutableLiveData<List<StatsSonData>> dataForniteTracker = new MutableLiveData<>();
    public List<StatsSonData> dataList = new ArrayList<>();


    public void getData(String platform, String epic_nickname){

        forniteTrackerRepository.getInfoFornite(platform,epic_nickname)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ForniteTracker>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ForniteTracker forniteObject) {
                        //liveData.postValue(forniteObjects);
                        if(forniteObject!=null) {
                            dataList.clear();
                            StatsSon data = forniteObject.getStats().getP2();
                            dataList.add(data.getScore());
                            dataList.add(data.getScorePerMatch());
                            dataList.add(data.getMatches());
                            dataList.add(data.getKills());
                            dataForniteTracker.postValue(dataList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("errorService","err: "+e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

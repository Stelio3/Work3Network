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
                        //Si la información no es nula meto los datos en la lista
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
                        //Creo el log para saber que está fallando en caso de no funcionar correctamente
                        Log.d("errorService","err: "+e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

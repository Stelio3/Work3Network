package a.benri.work3_network.ForniteTracker;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

//Servicio
public interface FortniteTrackerApi {
    @Headers("TRN-Api-Key: 1b947de5-1e90-4cd5-902a-d5e9e123d9b2")
    @GET("profile/{platform}/{playerName}")
    //Metodo observable que recoge la plataforma de juego y el nombre de usuario
    Observable<FortniteTracker> getFortniteUser(@Path("platform") String platform ,
                                                @Path("playerName") String epic_nickname);

    static FortniteTrackerApi Factory(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" https://api.fortnitetracker.com/v1/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit.create(FortniteTrackerApi.class);
    }
}

package a.benri.work3_network;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import a.benri.work3_network.ForniteTracker.ForniteTracker;
import a.benri.work3_network.ForniteTracker.ForniteTrackerViewModel;
import a.benri.work3_network.ForniteTracker.StatsSon;
import a.benri.work3_network.ForniteTracker.StatsSonData;

public class MainActivity extends AppCompatActivity {

    private EditText etNickName;
    private Spinner spinnerPlatform;
    private MyAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton btnFind;
    private ForniteTrackerViewModel forniteViewModel;
    private String mconsole;
    private String epicNickName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNickName = findViewById(R.id.etforniteNickName);
        spinnerPlatform = findViewById(R.id.spinner_platform);
        btnFind = findViewById(R.id.buttonFind);

        changeData("","");

        //llamada al método del onclicklistener
        clickbtnFind();
    }

    //Datos de las listas
    private void changeData(String mconsole,String nickName){
        forniteViewModel = ViewModelProviders.of(this).get(ForniteTrackerViewModel.class);
        //Observador que escucha del View Model para meter los datos en el recyclerView
        forniteViewModel.dataForniteTracker.observe(this, StatsSonData -> {
            if(StatsSonData!=null){
                Log.d("ServiceFornite","Changes: "+StatsSonData);
                generateForniteList(StatsSonData);
            }
        });
        forniteViewModel.getData(mconsole, nickName);
    }

    private void generateForniteList(List<StatsSonData> listForniteTracker) {
        recyclerView = findViewById(R.id.recycleview_fornite);
        adapter = new MyAdapter(listForniteTracker);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void clickbtnFind(){
        btnFind.setOnClickListener(v -> {
            //Obtiene el dato que aparece en el spinner y el editText y se los pasa al view model para meterlos en la lista
            mconsole = spinnerPlatform.getSelectedItem().toString();
            epicNickName = etNickName.getText().toString();
            Log.d("Change","platform "+mconsole+" epic_name "+epicNickName);
            forniteViewModel.getData(mconsole, epicNickName);
        });

    }
}


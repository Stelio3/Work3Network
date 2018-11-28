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

import a.benri.work3_network.ForniteTracker.FortniteTrackerViewModel;
import a.benri.work3_network.ForniteTracker.StatsSonData;

public class MainActivity extends AppCompatActivity {

    private EditText etNickName;
    private Spinner spinnerPlatform;
    private MyAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton btnFind;
    private FortniteTrackerViewModel forniteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        resetDataUser();
        //llamada al método del onclicklistener
        clickbtnFind();
    }

    public void findViewById(){
        //findView de los valores que voy a meter en mi cardView
        etNickName = findViewById(R.id.etforniteNickName);
        spinnerPlatform = findViewById(R.id.spinner_platform);
        btnFind = findViewById(R.id.buttonFind);
    }
    //Método del onclick del boton
    private void clickbtnFind(){
        btnFind.setOnClickListener(v -> {
            //Obtiene el dato que aparece en el spinner y el editText y se los pasa al view model para meterlos en la lista
            forniteViewModel.getData(spinnerPlatform.getSelectedItem().toString(), etNickName.getText().toString());
        });
    }

    //Datos de las listas
    private void resetDataUser(){
        forniteViewModel = ViewModelProviders.of(this).get(FortniteTrackerViewModel.class);
        //Observador que escucha del View Model para meter los datos en el recyclerView
        forniteViewModel.mldataForniteTracker.observe(this, StatsSonData -> {
            if(StatsSonData!=null){
                recyclerView = findViewById(R.id.recycleview_fornite);
                adapter = new MyAdapter(StatsSonData);
                layoutManager = new GridLayoutManager(this, 2);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}


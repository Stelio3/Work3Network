package a.benri.work3_network;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import a.benri.work3_network.ForniteTracker.FortniteTrackerViewHolder;
import a.benri.work3_network.ForniteTracker.StatsSonData;
import io.reactivex.annotations.NonNull;

public class MyAdapter extends RecyclerView.Adapter<FortniteTrackerViewHolder>{
    private List<StatsSonData> dataStats;

    //Constructor del adapter al que se le pasa la lista de datos desde el main
    public MyAdapter(List<StatsSonData> dataObject) {
        this.dataStats = dataObject;
    }

    @Override
    public FortniteTrackerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_cardview, viewGroup, false);
        FortniteTrackerViewHolder myfortniteHolder = new FortniteTrackerViewHolder(view);
        return myfortniteHolder;
    }


    @Override
    public void onBindViewHolder(FortniteTrackerViewHolder fortniteTrackerViewHolder, int i) {
        final StatsSonData item = dataStats.get(i);
        fortniteTrackerViewHolder.setTxtForniteTrackerTitle(item.getLabel());
        fortniteTrackerViewHolder.setTxtForniteTrackerValue(item.getRank());
        fortniteTrackerViewHolder.setTxtForniteTrackerRank(item.getDisplayValue());
    }

    @Override
    public int getItemCount() {
        return dataStats.size();
    }
}


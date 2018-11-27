package a.benri.work3_network;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import a.benri.work3_network.ForniteTracker.StatsSonData;
import io.reactivex.annotations.NonNull;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ForniteViewHolder>{
    private List<StatsSonData> dataStats;

    //Constructor del adapter al que se le pasa la lista de datos desde el main
    public MyAdapter(List<StatsSonData> dataObject) {
        this.dataStats = dataObject;
    }

    @Override
    public ForniteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.content_cardview, viewGroup, false);
        return new ForniteViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ForniteViewHolder forniteViewHolder, int i) {
        final StatsSonData item = dataStats.get(i);
        forniteViewHolder.txtForniteTrackerTitle.setText(item.getLabel());
        forniteViewHolder.txtForniteTrackerValue.setText(item.getDisplayValue());
        forniteViewHolder.txtForniteTrackerRank.setText(item.getRank());
    }

    @Override
    public int getItemCount() {
        return dataStats.size();
    }

    public class ForniteViewHolder extends RecyclerView.ViewHolder {

        private TextView txtForniteTrackerTitle, txtForniteTrackerValue, txtForniteTrackerRank;

        public ForniteViewHolder(View itemView) {
            super(itemView);
            txtForniteTrackerTitle = itemView.findViewById(R.id.tvTitle);
            txtForniteTrackerValue = itemView.findViewById(R.id.tvValue);
            txtForniteTrackerRank = itemView.findViewById(R.id.tvRank);
        }
    }
}


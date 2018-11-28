package a.benri.work3_network.ForniteTracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import a.benri.work3_network.R;

public class FortniteTrackerViewHolder extends RecyclerView.ViewHolder {

    private TextView txtForniteTrackerTitle, txtForniteTrackerValue, txtForniteTrackerRank;

    //Constructor del Holder
    public FortniteTrackerViewHolder(@NonNull View itemView) {
        super(itemView);
        txtForniteTrackerTitle = itemView.findViewById(R.id.tvTitle);
        txtForniteTrackerValue = itemView.findViewById(R.id.tvValue);
        txtForniteTrackerRank = itemView.findViewById(R.id.tvRank);
    }
    //Setter de los datos que voy a meter en el cardView
    public void setTxtForniteTrackerTitle(String txtForniteTrackerTitle) {
        this.txtForniteTrackerTitle.setText(txtForniteTrackerTitle);
    }

    public void setTxtForniteTrackerValue(String txtForniteTrackerValue) {
        this.txtForniteTrackerValue.setText(txtForniteTrackerValue);
    }

    public void setTxtForniteTrackerRank(String txtForniteTrackerRank) {
        this.txtForniteTrackerRank.setText(txtForniteTrackerRank);
    }
}

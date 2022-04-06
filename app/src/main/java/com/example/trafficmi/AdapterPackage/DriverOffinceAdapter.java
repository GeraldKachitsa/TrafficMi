package com.example.trafficmi.AdapterPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trafficmi.Model.AccidentSceneModel;
import com.example.trafficmi.Model.DriversOffenceModel;
import com.example.trafficmi.R;

import java.util.ArrayList;

public class DriverOffinceAdapter extends RecyclerView.Adapter<DriverOffinceAdapter.ViewHolder> {
    ArrayList<DriversOffenceModel> data;
    Context context;

    public DriverOffinceAdapter(Context context, ArrayList<DriversOffenceModel> data ) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public DriverOffinceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.display_theft_cases_layout_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverOffinceAdapter.ViewHolder holder, int position) {
        DriversOffenceModel accidentScene= data.get(position);
        holder.disPayName.setText(accidentScene.getDisPayName().toString());
        holder.driverOffenceLocation.setText(accidentScene.getDriverOffenceLocation().toString());
        holder.lisenceNumber.setText(accidentScene.getLisenceNumber().toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void filterList(ArrayList<DriversOffenceModel> models){
        data = models;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView disPayName;
        TextView driverOffenceLocation;
        TextView lisenceNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            disPayName = itemView.findViewById(R.id.car_name_id);
            driverOffenceLocation = itemView.findViewById(R.id.car_reg_num_id);
            lisenceNumber = itemView.findViewById(R.id.car_color_id);
        }
    }
}

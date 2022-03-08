package com.example.trafficmi.AdapterPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trafficmi.Model.ModelClass;
import com.example.trafficmi.R;

import java.util.ArrayList;

public class VehicleTheftAdapter extends RecyclerView.Adapter<VehicleTheftAdapter.ViewHolder> {
    private ArrayList<ModelClass>  arrayList;
    private Context appContext;

    public VehicleTheftAdapter(Context appContext, ArrayList<ModelClass> arrayList) {
        this.arrayList = arrayList;
        this.appContext = appContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(appContext).inflate(R.layout.display_theft_cases_layout_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass vehicleTheftReport = arrayList.get(position);
        holder.car_color.setText(vehicleTheftReport.getCarColor());
        holder.car_reg.setText(vehicleTheftReport.getVehicleRegNumber());
        holder.carname.setText(vehicleTheftReport.getCarName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView carname;
        TextView car_reg;
        TextView car_color;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carname = itemView.findViewById(R.id.car_name_id);
            car_reg = itemView.findViewById(R.id.car_reg_num_id);
            car_color = itemView.findViewById(R.id.car_color_id);
        }
    }
}

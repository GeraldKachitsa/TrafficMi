package com.example.trafficmi.AdapterPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trafficmi.R;
import com.example.trafficmi.UpdatedVehicleRecords;
import com.example.trafficmi.VehicleTheftReport;

import java.util.ArrayList;

public class VehicleTheftAdapter extends RecyclerView.Adapter<VehicleTheftAdapter.ViewHolder> {
    private ArrayList<VehicleTheftReport>  arrayList = new ArrayList<VehicleTheftReport>();
    private Context appContext;

    public VehicleTheftAdapter(Context appContext, ArrayList<VehicleTheftReport> arrayList) {
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
        holder.car_color.setText(arrayList.get(position).getCarColor().toString());
        holder.car_reg.setText(arrayList.get(position).getVehicleRegNumber().toString());
        holder.carname.setText(arrayList.get(position).getCarName().toString());
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

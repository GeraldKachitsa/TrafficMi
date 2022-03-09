package com.example.trafficmi.AdapterPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trafficmi.Model.AccidentSceneModel;
import com.example.trafficmi.R;

import java.util.ArrayList;

public class AccidentAdapter extends RecyclerView.Adapter<AccidentAdapter.ViewHolder> {
    ArrayList<AccidentSceneModel> accidentSceneModels;
    Context context;

    public AccidentAdapter(Context context, ArrayList<AccidentSceneModel> accidentSceneModels ) {
        this.accidentSceneModels = accidentSceneModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.display_theft_cases_layout_model,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AccidentSceneModel accidentSceneModel = accidentSceneModels.get(position);

        holder.name.setText(accidentSceneModel.getName().toString());
        holder.regnum.setText(accidentSceneModel.getRegNum().toString());
        holder.color.setText(accidentSceneModel.getColor().toString());

    }

    @Override
    public int getItemCount() {
        return accidentSceneModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView regnum,color,name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            regnum = itemView.findViewById(R.id.car_color_id);
            color = itemView.findViewById(R.id.car_reg_num_id);
            name = itemView.findViewById(R.id.car_name_id);
        }
    }
}

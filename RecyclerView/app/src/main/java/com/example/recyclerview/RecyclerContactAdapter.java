package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.viewHolder> {
    Context context;
    ArrayList<controlModel> arrayList;

    public RecyclerContactAdapter(Context context, ArrayList<controlModel> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        viewHolder viewHolder=new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.nameText.setText(arrayList.get(position).name);
        holder.rollText.setText(arrayList.get(position).roll);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView nameText,rollText;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            nameText=itemView.findViewById(R.id.nameId);
            rollText=itemView.findViewById(R.id.rollId);
        }
    }
}

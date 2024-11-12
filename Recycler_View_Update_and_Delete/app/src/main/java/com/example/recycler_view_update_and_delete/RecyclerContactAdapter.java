package com.example.recycler_view_update_and_delete;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.viewHolder> {

    Context context;
    ArrayList<control_model> arrayList;
    public RecyclerContactAdapter(Context context, ArrayList<control_model> arrayList){
        this.context=context;
        this.arrayList=arrayList;


    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contect_row,parent,false);
       viewHolder viewHolder=new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.nameText.setText(arrayList.get(position).name);
        holder.numberText.setText(arrayList.get(position).number);

        //update korar janno jodi kono item e click kora hoy tahole eita kaj korbe
        holder.click_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog updateDialog =new Dialog(context);
                updateDialog.setContentView(R.layout.update_layout);
                EditText updateName=updateDialog.findViewById(R.id.updateNameId);
                EditText updateNumber=updateDialog.findViewById(R.id.updateNumberId);
                Button updateButton= updateDialog.findViewById(R.id.updateId);

                // layout er opore click korar pore dialog box e EditText er  modhe name r Number select hobe
                updateName.setText(arrayList.get(position).name);
                updateNumber.setText(arrayList.get(position).number);
                // update button e click korar pore cicher code ti kaj korbe
                updateButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name="";
                        String number="";
                        if(!updateName.getText().equals("")){
                            name=updateName.getText().toString();
                        }else{
                            Toast.makeText(context,"please enter contact name ",Toast.LENGTH_SHORT).show();
                        }
                        if(!updateNumber.getText().equals("")){
                            number=updateNumber.getText().toString();
                        }else{
                            Toast.makeText(context,"please enter contact number ",Toast.LENGTH_SHORT).show();
                        }
                        // eita arrayList er nirdisto thane modhe thaka data update kore
                        // update korar kaj set() kore ,
                        arrayList.set(position,new control_model(name,number));
                        //notifyItemChanged Layout setkora notun item prodorson koranor kaj kore
                        notifyItemChanged(position);
                        updateDialog.dismiss();


                    }
                });
                updateDialog.show();
            }
        });
        // layout( click_row) er opore click korle ei clickListener kaj korbe
        holder.click_row.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(context)
                        .setTitle("Delete contact! ")
                        .setMessage("Are you sure want to delete")
                        .setIcon(R.drawable.warning_signs_svgrepo_com)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //remove() ukto arrayList a position er item remove kore dibe
                                arrayList.remove(position);
                                // notifyItemRemoved() layout hote item remove kore dibe
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                alertDialog.show();
                return true;
            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView nameText,numberText;
        LinearLayout click_row;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nameText=itemView.findViewById(R.id.nameId);
            numberText=itemView.findViewById(R.id.numberId);
            click_row=itemView.findViewById(R.id.click_row);


        }
    }
}

package com.sliit.madproject;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Pre_Adapter extends FirebaseRecyclerAdapter<Pre_Event, Pre_Adapter.myviewholder>{

    public Pre_Adapter(@NonNull FirebaseRecyclerOptions<Pre_Event> options)
    {
        super(options);
    }

    EditText edit_date,edit_event,edit_details,edit_remark,edit_plan,edit_title;

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlepre,parent,false);

       return new myviewholder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myviewholder holder,@SuppressLint("RecyclerView") final int position, @NonNull @NotNull Pre_Event pre_event) {
        holder.date.setText(pre_event.getDate());
        holder.event.setText(pre_event.getEvent());
        holder.details.setText(pre_event.getDetails());
        holder.remark.setText(pre_event.getRemark());
        holder.plan.setText(pre_event.getPlan());
        holder.title.setText(pre_event.getTitle());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(view.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialogcontentpre))
                        .setExpanded(true,1500)
                        .create();

                View myview=dialogPlus.getHolderView();
                edit_date= myview.findViewById(R.id.txtDateEditM);
                edit_event= myview.findViewById(R.id.txtEventEditM);
                edit_details= myview.findViewById(R.id.txtDetailEditM);
                edit_remark= myview.findViewById(R.id.txtRemarkEditM);
                edit_plan= myview.findViewById(R.id.txtPlanEditM);
                edit_title= myview.findViewById(R.id.txtTitleEditM);
                Button submit= myview.findViewById(R.id.editPreM);

                edit_date.setText(pre_event.getDate());
                edit_event.setText(pre_event.getEvent());
                edit_title.setText(pre_event.getTitle());
                edit_remark.setText(pre_event.getRemark());
                edit_plan.setText(pre_event.getPlan());
                edit_details.setText(pre_event.getDetails());

                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (vali()==""){

                            HashMap<String,Object> map= new HashMap<>();
                            map.put("plan",edit_plan.getText().toString());
                            map.put("date",edit_date.getText().toString());
                            map.put("title",edit_title.getText().toString());
                            map.put("event",edit_event.getText().toString());
                            map.put("details",edit_details.getText().toString());
                            map.put("remark",edit_remark.getText().toString());

                            FirebaseDatabase.getInstance().getReference().child("pre_event").child(getRef(position).getKey()).updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    dialogPlus.dismiss();
                                }
                            })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            dialogPlus.dismiss();
                                        }
                                    });


                        }else {
                            Toast.makeText(view.getContext(),vali(),Toast.LENGTH_LONG).show();
                        }

                    }
                });

            }
        });


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                builder.setTitle("Delete DATA!");
                builder.setMessage("Delete ?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("pre_event")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        Button edit,delete;
        TextView date,event,title,remark,details,plan;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            date=(TextView)itemView.findViewById(R.id.datePreView);
            event=(TextView)itemView.findViewById(R.id.eventPreView);
            plan=(TextView)itemView.findViewById(R.id.planPreView);
            remark=(TextView)itemView.findViewById(R.id.remarkPreView);
            details=(TextView)itemView.findViewById(R.id.detailsPreView);
            title=(TextView)itemView.findViewById(R.id.titlePreView);

            edit=(Button)itemView.findViewById(R.id.editpre1);
            delete=(Button)itemView.findViewById(R.id.deletepre1);

        }

    }


    private String vali(){

        if(edit_details.getText().toString().equals("")){
            return "Details Required!";
        }

        if(edit_plan.getText().toString().equals("")){
            return "Plan Required!";
        }

        if(edit_date.getText().toString().equals("")){
            return "Date Required!";
        }

        if(edit_event.getText().toString().equals("")){
            return "event Required!";
        }

        if(edit_title.getText().toString().equals("")){
            return "Title Required!";
        }

        if(edit_remark.getText().toString().equals("")){
            return "remark Required!";
        }

        return "";
    }
}

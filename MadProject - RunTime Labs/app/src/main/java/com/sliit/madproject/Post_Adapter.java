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

public class Post_Adapter extends FirebaseRecyclerAdapter<Post_Event,Post_Adapter.myviewholder>{

    public Post_Adapter(@NonNull FirebaseRecyclerOptions<Post_Event> options)
    {
        super(options);
    }

    EditText edit_date,edit_event,edit_list,edit_remark,edit_task,edit_todo;

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlepost,parent,false);

       return new myviewholder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myviewholder holder,@SuppressLint("RecyclerView") final int position, @NonNull @NotNull Post_Event post_Event) {
        holder.date.setText(post_Event.getDate());
        holder.event.setText(post_Event.getEvent());
        holder.list.setText(post_Event.getList());
        holder.remark.setText(post_Event.getRemark());
        holder.task.setText(post_Event.getTask());
        holder.todo.setText(post_Event.getTodolist());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(view.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialogcontentposts))
                        .setExpanded(true,1500)
                        .create();

                View myview=dialogPlus.getHolderView();
                edit_date= myview.findViewById(R.id.txtDateEdit);
                edit_event= myview.findViewById(R.id.txtEventEdit);
                edit_list= myview.findViewById(R.id.txtListEdit);
                edit_remark= myview.findViewById(R.id.txtRemarkEdit);
                edit_task= myview.findViewById(R.id.txtTaskEdit);
                edit_todo= myview.findViewById(R.id.txtTodolistEdit);
                Button submit= myview.findViewById(R.id.editPost);

                edit_date.setText(post_Event.getDate());
                edit_event.setText(post_Event.getEvent());
                edit_list.setText(post_Event.getList());
                edit_remark.setText(post_Event.getRemark());
                edit_task.setText(post_Event.getTask());
                edit_todo.setText(post_Event.getTodolist());

                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (vali()==""){

                                HashMap<String,Object> map= new HashMap<>();
                                map.put("todolist",edit_todo.getText().toString());
                                map.put("date",edit_date.getText().toString());
                                map.put("list",edit_list.getText().toString());
                                map.put("event",edit_event.getText().toString());
                                map.put("task",edit_task.getText().toString());
                                map.put("remark",edit_remark.getText().toString());

                                FirebaseDatabase.getInstance().getReference().child("post_event").child(getRef(position).getKey()).updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
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
                        FirebaseDatabase.getInstance().getReference().child("post_event")
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
        TextView date,event,list,remark,task,todo;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            date=(TextView)itemView.findViewById(R.id.datePostView);
            event=(TextView)itemView.findViewById(R.id.eventPostView);
            list=(TextView)itemView.findViewById(R.id.listPostView);
            remark=(TextView)itemView.findViewById(R.id.remarkPostView);
            task=(TextView)itemView.findViewById(R.id.taskPostView);
            todo=(TextView)itemView.findViewById(R.id.todolistPostView);

            edit=(Button)itemView.findViewById(R.id.editicon);
            delete=(Button)itemView.findViewById(R.id.deleteicon);

        }

    }


    private String vali(){

        if(edit_todo.getText().toString().equals("")){
            return "To Do List Required!";
        }

        if(edit_list.getText().toString().equals("")){
            return "List Required!";
        }

        if(edit_date.getText().toString().equals("")){
            return "Date Required!";
        }

        if(edit_event.getText().toString().equals("")){
            return "event Required!";
        }

        if(edit_task.getText().toString().equals("")){
            return "task Required!";
        }

        if(edit_remark.getText().toString().equals("")){
            return "remark Required!";
        }

        return "";
    }
}

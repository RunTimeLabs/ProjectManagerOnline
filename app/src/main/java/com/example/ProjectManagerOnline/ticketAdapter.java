package com.example.ProjectManagerOnline;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class ticketAdapter extends FirebaseRecyclerAdapter <Category, ticketAdapter.ticketViewHolder>{
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ticketAdapter(@NonNull FirebaseRecyclerOptions<Category> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ticketViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull Category model) {

        holder.ticketCat.setText(model.getTicketCategory());
        holder.ticketPrice.setText(model.getTicketPrice());

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.ticketCat.getContext())
                        .setContentHolder(new ViewHolder(R.layout.ticket_popup))
                        .setExpanded(true,800)
                        .create();

                View view = dialogPlus.getHolderView();

                EditText cat = view.findViewById(R.id.textcat);
                EditText price = view.findViewById(R.id.textprice);

                Button btnUpdate = view.findViewById(R.id.btnUpdate);

                cat.setText(model.getTicketCategory());
                price.setText(model.getTicketPrice());

                dialogPlus.show();
                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("ticketCategory", cat.getText().toString());
                        map.put("ticketPrice", price.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Category")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.ticketCat.getContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(Exception e) {
                                Toast.makeText(holder.ticketCat.getContext(), "Error While Updating", Toast.LENGTH_SHORT).show();
                                dialogPlus.dismiss();
                            }
                        });
                    }
                });
            }
        });

        //holder.btnDel.setOnClickListener();

    }

    @NonNull
    @Override
    public ticketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ticket_cat_item, parent, false);

        return new ticketViewHolder(view);
    }

    class ticketViewHolder extends RecyclerView.ViewHolder{

        TextView ticketCat,ticketPrice;

        Button btnEdit, btnDel;

        public ticketViewHolder(@NonNull View itemView) {
            super(itemView);

            ticketCat = (TextView) itemView.findViewById(R.id.cattext);
            ticketPrice = (TextView) itemView.findViewById(R.id.ticketPrice);

            btnEdit = (Button) itemView.findViewById(R.id.btnEdit);
            btnDel = (Button) itemView.findViewById(R.id.btnDel);
        }
    }
}

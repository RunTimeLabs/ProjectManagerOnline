package com.example.ProjectManagerOnline;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

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
    protected void onBindViewHolder(@NonNull ticketViewHolder holder, int position, @NonNull Category model) {

        holder.ticketCat.setText(model.getTicketCategory());
        holder.ticketPrice.setText(model.getTicketPrice());

    }

    @NonNull
    @Override
    public ticketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ticket_cat_item, parent, false);

        return new ticketViewHolder(view);
    }

    class ticketViewHolder extends RecyclerView.ViewHolder{

        TextView ticketCat,ticketPrice;

        public ticketViewHolder(@NonNull View itemView) {
            super(itemView);

            ticketCat = (TextView) itemView.findViewById(R.id.cattext);
            ticketPrice = (TextView) itemView.findViewById(R.id.ticketPrice);
        }
    }
}

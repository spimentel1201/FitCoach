package com.idnp.fitcoach.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idnp.fitcoach.R;
import com.idnp.fitcoach.models.Coach;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CoachsAdapter extends RecyclerView.Adapter<CoachsAdapter.CoachViewHolder> {
    ArrayList<Coach> listaCoachs;
    ArrayList<Coach> listaOriginal;
    ImageView imageViewCoach;
    String imageCoach = "";

    public CoachsAdapter(ArrayList<Coach> listaCoachsx, Context context) {
        this.listaCoachs = listaCoachsx;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaCoachsx);
    }

    @NonNull
    @Override
    public CoachViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_gym_trainer, null, false);
        return new CoachViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoachsAdapter.CoachViewHolder holder, int position) {
        String rating = Integer.toString(listaCoachs.get(position).getRating());
        holder.textCoachName.setText(rating);
        Picasso.get().load(listaCoachs.get(position).getImgUrlC()).into(imageViewCoach);
        //holder.cardTrainerName.setText(listaCoachs.get(position).getFecha().toString());
    }

    @Override
    public int getItemCount() {
        return listaCoachs.size();
    }

    public class CoachViewHolder extends RecyclerView.ViewHolder {

        TextView textCoachName;

        public CoachViewHolder(@NonNull View itemView) {
            super(itemView);


            imageViewCoach = (ImageView) itemView.findViewById(R.id.imageCoach);
            //Picasso.get().load(String.valueOf(imageCoach)).centerCrop().into(imageViewCoach);
            textCoachName = itemView.findViewById(R.id.cardTrainerName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                }
            });
        }
    }
}

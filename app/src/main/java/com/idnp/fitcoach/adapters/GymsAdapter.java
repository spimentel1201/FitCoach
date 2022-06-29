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
import com.idnp.fitcoach.models.Gym;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GymsAdapter extends RecyclerView.Adapter<GymsAdapter.GymViewHolder> {
    ArrayList<Gym> listaGyms;
    ArrayList<Gym> listaOriginal;
    ImageView imageViewGym;
    String imageGym = "";

    public GymsAdapter(ArrayList<Gym> listaGymsx) {
        this.listaGyms = listaGymsx;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaGymsx);
    }

    @NonNull
    @Override
    public GymViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_gym, null, false);
        return new GymViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GymsAdapter.GymViewHolder holder, int position) {
        holder.textGymName.setText(listaGyms.get(position).getName());
        Picasso.get().load(listaGyms.get(position).getImgUrl()).into(imageViewGym);
        //holder.imageGym.setText(listaGyms.get(position).getFecha().toString());
    }

    @Override
    public int getItemCount() {
        return listaGyms.size();
    }

    public class GymViewHolder extends RecyclerView.ViewHolder {

        TextView textGymName;

        public GymViewHolder(@NonNull View itemView) {
            super(itemView);


            imageViewGym = (ImageView) itemView.findViewById(R.id.imageGym);
            //Picasso.get().load(String.valueOf(imageGym)).centerCrop().into(imageViewGym);
            textGymName = itemView.findViewById(R.id.textGymName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                }
            });
        }
    }
}

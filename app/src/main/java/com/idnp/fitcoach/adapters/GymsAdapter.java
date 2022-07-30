package com.idnp.fitcoach.adapters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.idnp.fitcoach.GymProfileFragment;
import com.idnp.fitcoach.ItemClickListener;
import com.idnp.fitcoach.R;
import com.idnp.fitcoach.models.Gym;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GymsAdapter extends RecyclerView.Adapter<GymsAdapter.GymViewHolder> {
    ArrayList<Gym> listaGyms;
    ArrayList<Gym> listaOriginal;
    ImageView imageViewGym;
    String imageGym = "";
    CardView cardView;
    private Context mcontext;
    private onTestClickListener onTestClickListener;

    public GymsAdapter(ArrayList<Gym> listaGymsx, Context context, onTestClickListener testClickListener) {
        this.listaGyms = listaGymsx;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaGymsx);
        this.mcontext = context;
        this.onTestClickListener = testClickListener;
    }

    @NonNull
    @Override
    public GymViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_gym, null, false);
        //final GymViewHolder holder = new GymViewHolder(view);
        /*holder.itemView.setOnClickListener(new onTestClickListener() {
            @Override
            public void onClick(int position) {
                Log.d("debud", "position = " + holder.getAdapterPosition());
            }
        });*/
        return new GymViewHolder(view, new onTestClickListener() {
            @Override
            public void onClick(int position) {
                onTestClickListener.onClick(position);
            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull GymsAdapter.GymViewHolder holder, int position) {
        holder.textGymName.setText(listaGyms.get(position).getName());
        Picasso.get().load(listaGyms.get(position).getImgUrl()).into(holder.imageViewGym);
        //holder.imageGym.setText(listaGyms.get(position).getFecha().toString());
    }

    @Override
    public int getItemCount() {
        return listaGyms.size();
    }

    public class GymViewHolder extends RecyclerView.ViewHolder{

        TextView textGymName;
        ImageView imageViewGym;
        CardView cardView;

        public GymViewHolder(@NonNull View itemView, final onTestClickListener testClickListener) {
            super(itemView);
            imageViewGym = (ImageView) itemView.findViewById(R.id.imageGym);
            //Picasso.get().load(String.valueOf(imageGym)).centerCrop().into(imageViewGym);
            textGymName = itemView.findViewById(R.id.textGymName);
            cardView = itemView.findViewById(R.id.card_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    testClickListener.onClick(getAdapterPosition());

                }
            });
        }
    }

    public interface onTestClickListener{
        void onClick(int position);
    }
}

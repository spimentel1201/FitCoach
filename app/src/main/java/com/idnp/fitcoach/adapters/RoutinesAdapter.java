package com.idnp.fitcoach.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.idnp.fitcoach.R;
import com.idnp.fitcoach.models.Routine;

import java.util.ArrayList;

public class RoutinesAdapter extends RecyclerView.Adapter<RoutinesAdapter.RoutineViewHolder> {
    ArrayList<Routine> listaRoutines;
    ArrayList<Routine> listaOriginal;
    CardView cardView;
    private Context mcontext;
    private onTestClickListener onTestClickListener;

    public RoutinesAdapter(ArrayList<Routine> listaRoutinesx, Context context) {
        this.listaRoutines = listaRoutinesx;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaRoutinesx);
        this.mcontext = context;
    }

    @NonNull
    @Override
    public RoutineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_routine, null, false);
        return new RoutineViewHolder(view, new onTestClickListener() {
            @Override
            public void onClick(int position) {
                onTestClickListener.onClick(position);
            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull RoutinesAdapter.RoutineViewHolder holder, int position) {
        holder.textItemRoutineDescription.setText(listaRoutines.get(position).getDescription());
        holder.textTrack1.setText("- " + listaRoutines.get(position).getTrack1());
        holder.textTrack2.setText("- " + listaRoutines.get(position).getTrack2());
        holder.textTrack3.setText("- " + listaRoutines.get(position).getTrack3());
        holder.textTrack4.setText("- " + listaRoutines.get(position).getTrack4());
        holder.textTrack5.setText("- " + listaRoutines.get(position).getTrack5());
        holder.textTrack6.setText("- " + listaRoutines.get(position).getTrack6());
    }

    @Override
    public int getItemCount() {
        return listaRoutines.size();
    }

    public class RoutineViewHolder extends RecyclerView.ViewHolder{

        TextView textItemRoutineDescription;
        TextView textTrack1;
        TextView textTrack2;
        TextView textTrack3;
        TextView textTrack4;
        TextView textTrack5;
        TextView textTrack6;

        public RoutineViewHolder(@NonNull View itemView, final onTestClickListener testClickListener) {
            super(itemView);
            textItemRoutineDescription = itemView.findViewById(R.id.textItemRoutineDescription);
            textTrack1 = itemView.findViewById(R.id.textTrack1);
            textTrack2 = itemView.findViewById(R.id.textTrack2);
            textTrack3 = itemView.findViewById(R.id.textTrack3);
            textTrack4 = itemView.findViewById(R.id.textTrack4);
            textTrack5 = itemView.findViewById(R.id.textTrack5);
            textTrack6 = itemView.findViewById(R.id.textTrack6);
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
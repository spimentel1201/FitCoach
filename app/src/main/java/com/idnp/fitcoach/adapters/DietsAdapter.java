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
import com.idnp.fitcoach.models.Diet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DietsAdapter extends RecyclerView.Adapter<DietsAdapter.DietViewHolder> {
    ArrayList<Diet> listaDiets;
    ArrayList<Diet> listaOriginal;
    ImageView imageDietItemB;
    ImageView imageDietItemMM;
    ImageView imageDietItemL;
    ImageView imageDietItemMA;
    ImageView imageDietItemD;
    String imageDiet = "";
    private Context mcontext;

    public DietsAdapter(ArrayList<Diet> listaDietsx, Context context) {
        this.listaDiets = listaDietsx;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaDietsx);
        this.mcontext = context;
    }

    @NonNull
    @Override
    public DietViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_diet, null, false);
        return new DietViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DietsAdapter.DietViewHolder holder, int position) {
        holder.textDietNameB.setText(listaDiets.get(position).getBreakfast());
        holder.textDietNameMM.setText(listaDiets.get(position).getMidMorning());
        holder.textDietNameL.setText(listaDiets.get(position).getLunch());
        holder.textDietNameMA.setText(listaDiets.get(position).getMidAfternoon());
        holder.textDietNameD.setText(listaDiets.get(position).getDinner());
        Picasso.get().load(listaDiets.get(position).getImgURLD()).into(imageDietItemB);
        Picasso.get().load(listaDiets.get(position).getImgURLMM()).into(imageDietItemMM);
        Picasso.get().load(listaDiets.get(position).getImgURLL()).into(imageDietItemL);
        Picasso.get().load(listaDiets.get(position).getImgURLMA()).into(imageDietItemMA);
        Picasso.get().load(listaDiets.get(position).getImgURLDD()).into(imageDietItemD);
        //holder.imageDiet.setText(listaDiets.get(position).getFecha().toString());
    }

    @Override
    public int getItemCount() {
        return listaDiets.size();
    }

    public class DietViewHolder extends RecyclerView.ViewHolder {

        TextView textDietNameB;
        TextView textDietNameMM;
        TextView textDietNameL;
        TextView textDietNameMA;
        TextView textDietNameD;

        public DietViewHolder(@NonNull View itemView) {
            super(itemView);


            imageDietItemB= (ImageView) itemView.findViewById(R.id.imageDietItemB);
            imageDietItemMM= (ImageView) itemView.findViewById(R.id.imageDietItemMM);
            imageDietItemL= (ImageView) itemView.findViewById(R.id.imageDietItemL);
            imageDietItemMA= (ImageView) itemView.findViewById(R.id.imageDietItemMA);
            imageDietItemD= (ImageView) itemView.findViewById(R.id.imageDietItemD);
            //Picasso.get().load(String.valueOf(imageDiet)).centerCrop().into(imageViewDiet);
            textDietNameB = itemView.findViewById(R.id.textItemDietFoodB);
            textDietNameMM = itemView.findViewById(R.id.textItemDietFoodB);
            textDietNameL = itemView.findViewById(R.id.textItemDietFoodB);
            textDietNameMA = itemView.findViewById(R.id.textItemDietFoodB);
            textDietNameD = itemView.findViewById(R.id.textItemDietFoodB);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                }
            });
        }
    }
}

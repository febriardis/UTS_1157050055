package com.example.febriardis.soccerleague;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class KlasemenAdapter extends RecyclerView.Adapter<KlasemenAdapter.KlasemenViewHolder>{

    private Context context;
    private List<Klasemen> klasemenList;

    public KlasemenAdapter(Context context, List<Klasemen> klasemenList) {
        this.context = context;
        this.klasemenList = klasemenList;
    }

    @NonNull
    @Override
    public KlasemenViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_klasemen, viewGroup, false);
        return new KlasemenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KlasemenViewHolder klasemenViewHolder, int i) {
        Klasemen klasemen = klasemenList.get(i);
        klasemenViewHolder.id.setText(String.valueOf(klasemen.getId()));
        klasemenViewHolder.nmklub.setText(klasemen.getClub());
        klasemenViewHolder.skor.setText(String.valueOf(klasemen.getSkor()));
        klasemenViewHolder.logoClub.setImageDrawable(context.getResources().getDrawable(klasemen.getLogoClub()));
    }

    @Override
    public int getItemCount() {
        return klasemenList.size();
    }

    class KlasemenViewHolder extends RecyclerView.ViewHolder {
        TextView id, nmklub, skor;
        ImageView logoClub;
        public KlasemenViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idClub);
            nmklub = itemView.findViewById(R.id.nmclub);
            skor = itemView.findViewById(R.id.skor);
            logoClub = itemView.findViewById(R.id.logoClub);
        }
    }
}

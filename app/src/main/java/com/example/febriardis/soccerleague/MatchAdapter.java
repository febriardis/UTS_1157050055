package com.example.febriardis.soccerleague;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {

    private Context context;
    private List<Match> matchList;

    Dialog myDialog;

    public MatchAdapter(Context context, List<Match> matchList) {
        this.context = context;
        this.matchList = matchList;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_match, viewGroup, false);
        final MatchViewHolder viewHolder = new MatchViewHolder(view);

        return viewHolder; //new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MatchViewHolder matchViewHolder, int i) {
        final Match match = matchList.get(i);
        matchViewHolder.namaClub1.setText(match.getNamaclub1());
        Picasso.get().load(match.getLogo1()).error(R.mipmap.ic_launcher).into(matchViewHolder.logo1);
        matchViewHolder.namaClub2.setText(match.getNamaclub2());
        Picasso.get().load(match.getLogo2()).error(R.mipmap.ic_launcher).into(matchViewHolder.logo2);
        matchViewHolder.card.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Here goes your desired onClick behaviour. Like:
                Toast.makeText(view.getContext(), "Show details match" , Toast.LENGTH_SHORT).show();

                Bundle bundle = new Bundle();
                bundle.putInt("logo1", match.getLogo1());
                bundle.putString("namacb1", match.getNamaclub1());//
                bundle.putString("score1", String.valueOf(match.getScore1()));

                bundle.putInt("logo2", match.getLogo2());
                bundle.putString("namacb2", match.getNamaclub2());//
                bundle.putString("score2", String.valueOf(match.getScore2()));

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                DetailMatchFragment myFragment = new DetailMatchFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, myFragment).addToBackStack(null).commit();

                myFragment.setArguments(bundle);/////
            }
        });

    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView namaClub1, namaClub2;
        ImageView logo1, logo2;
        CardView card;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            namaClub1 = itemView.findViewById(R.id.club1);
            logo1 = itemView.findViewById(R.id.logoClub1);
            namaClub2 = itemView.findViewById(R.id.club2);
            logo2 = itemView.findViewById(R.id.logoClub2);
            card = itemView.findViewById(R.id.cardMatch);
        }
    }

}

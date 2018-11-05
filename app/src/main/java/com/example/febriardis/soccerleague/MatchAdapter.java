package com.example.febriardis.soccerleague;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.fragment_detail_match);

//        AppCompatActivity activity = (AppCompatActivity) view.getContext();
//        DetailMatchFragment myFragment = new DetailMatchFragment();
//        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, myFragment).addToBackStack(null).commit();

        viewHolder.card.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ImageView logoClub1 = myDialog.findViewById(R.id.logoClub1);
                TextView nmCLub1 = myDialog.findViewById(R.id.nmClub1);
                TextView skorClub1 = myDialog.findViewById(R.id.skorClub1);
                ImageView logoClub2 = myDialog.findViewById(R.id.logoClub2);
                TextView nmCLub2 = myDialog.findViewById(R.id.nmClub2);
                TextView skorClub2 = myDialog.findViewById(R.id.skorClub2);

                logoClub1.setImageResource(matchList.get(viewHolder.getAdapterPosition()).getLogo1());
                nmCLub1.setText(matchList.get(viewHolder.getAdapterPosition()).getNamaclub1());
                skorClub1.setText(String.valueOf(matchList.get(viewHolder.getAdapterPosition()).getScore1()));
                logoClub2.setImageResource(matchList.get(viewHolder.getAdapterPosition()).getLogo2());
                nmCLub2.setText(matchList.get(viewHolder.getAdapterPosition()).getNamaclub2());
                skorClub2.setText(String.valueOf(matchList.get(viewHolder.getAdapterPosition()).getScore2()));

                //Here goes your desired onClick behaviour. Like:
                Toast.makeText(view.getContext(), "show details match" , Toast.LENGTH_SHORT).show();
                myDialog.show();

//                AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                DetailMatchFragment myFragment = new DetailMatchFragment();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, myFragment).addToBackStack(null).commit();
            }
        });

        return viewHolder; //new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MatchViewHolder matchViewHolder, int i) {
        final Match match = matchList.get(i);
        matchViewHolder.namaClub1.setText(match.getNamaclub1());
        matchViewHolder.logo1.setImageDrawable(context.getResources().getDrawable(match.getLogo1()));
        matchViewHolder.namaClub2.setText(match.getNamaclub2());
        matchViewHolder.logo2.setImageDrawable(context.getResources().getDrawable(match.getLogo2()));
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

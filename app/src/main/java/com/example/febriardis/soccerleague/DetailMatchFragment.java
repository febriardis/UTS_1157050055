package com.example.febriardis.soccerleague;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailMatchFragment extends Fragment {

    ImageView logo1, logo2;
    TextView namaclub1, skor1, namaclub2, skor2;

    String getLogo1, getNmclub1,  getLogo2, getNmclub2;
    int getSkor1, getSkor2;

    public DetailMatchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail_match, container, false);

        //initial Id
        logo1 = view.findViewById(R.id.logoClub1);
        namaclub1 = view.findViewById(R.id.nmClub1);
        skor1 = view.findViewById(R.id.skorClub1);

        logo2 = view.findViewById(R.id.logoClub2);
        namaclub2 = view.findViewById(R.id.nmClub2);
        skor2 = view.findViewById(R.id.skorClub2);

        //setData
        Bundle b = getArguments();
        logo1.setImageResource(b.getInt("logo1"));
        namaclub1.setText(b.getString("namacb1"));
        skor1.setText(b.getString("score1"));

        logo2.setImageResource(b.getInt("logo2"));
        namaclub2.setText(b.getString("namacb2"));
        skor2.setText(b.getString("score2"));

        return view;
    }

}

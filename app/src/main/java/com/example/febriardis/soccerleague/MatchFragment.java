package com.example.febriardis.soccerleague;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchFragment extends Fragment {
    RecyclerView recyclerView2;
    MatchAdapter matchAdapter;
    List<Match> matchList;

    public MatchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_match, container, false);

        //menampilkan recycler view klasemen
        recyclerView2 = view.findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));

        matchList = new ArrayList<>();
        matchList.add(new Match(R.drawable.perselalamongan, " Persela Lamongan", 3,R.drawable.sriwijayafc, "Sriwijaya FC", 0));
        matchList.add(new Match(R.drawable.bhayangkarafc, " Bhayangkara Fc", 1,R.drawable.persibbandung, "Persib Bandung", 2));
        matchList.add(new Match(R.drawable.baliunited, "Bali United", 5,R.drawable.maduraunited, "Madura United", 0));
        matchList.add(new Match(R.drawable.perspura, "Persipura Jayapura", 2,R.drawable.persijajakarta, "Persija Jakarta", 1));
        matchList.add(new Match(R.drawable.aremafc, "Arema Fc", 3,R.drawable.sriwijayafc, "Sriwijaya", 4));
        matchList.add(new Match(R.drawable.persebaya, "Persebaya", 0,R.drawable.perspura, "Persipura", 0));
        matchList.add(new Match(R.drawable.perseru, "Perseru", 2,R.drawable.psms, "PSMS", 1));
        matchList.add(new Match(R.drawable.pstira, "PS Tira", 1,R.drawable.bhayangkarafc, "Bhayangkara FC", 0));

        matchAdapter = new MatchAdapter(this.getContext(),matchList);
        recyclerView2.setAdapter(matchAdapter);
        //end menampilkan recycler view klasemen

        return view;
    }

}

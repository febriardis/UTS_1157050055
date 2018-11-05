package com.example.febriardis.soccerleague;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.gambar1, R.drawable.gambar2, R.drawable.gambar3, R.drawable.gambar4};
    RecyclerView recyclerView1;
    KlasemenAdapter klasemenAdapter;
    List<Klasemen> klasemenList;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        carouselView = view.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        //menampilkan recycler view klasemen
        recyclerView1 = view.findViewById(R.id.recyclerView1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));

        klasemenList = new ArrayList<>();
        klasemenList.add(new Klasemen(1, "Sriwijaya FC", 60, R.drawable.sriwijayafc));
        klasemenList.add(new Klasemen(2, "Persib Bandung", 58, R.drawable.persibbandung));
        klasemenList.add(new Klasemen(3, "Madura United", 54, R.drawable.maduraunited));
        klasemenList.add(new Klasemen(4, "Arema FC", 51, R.drawable.aremafc));
        klasemenList.add(new Klasemen(5, "Persija Jakarta", 50, R.drawable.persijajakarta));
        klasemenList.add(new Klasemen(6, "Persipura Jayapura", 49, R.drawable.perspura));
        klasemenList.add(new Klasemen(7, "Bali United", 45, R.drawable.baliunited));
        klasemenList.add(new Klasemen(8, "Bhayangkara FC", 38, R.drawable.bhayangkarafc));

        klasemenAdapter = new KlasemenAdapter(this.getContext(),klasemenList);
        recyclerView1.setAdapter(klasemenAdapter);
        //end menampilkan recycler view klasemen

        return view;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}

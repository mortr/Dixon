package com.mikchaelsoloviev.dixon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainGameActivityFragment extends Fragment {
public static String TAG="Dix";

    @InjectView(R.id.container_for_cards)
    LinearLayout container;

    public MainGameActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_cards_container, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.inject(this, view);

        View cardView1=getLayoutInflater(savedInstanceState).inflate(R.layout.card_train, container);
        Log.d(TAG, "Inflate cards1");
//        ((SimpleDraweeView)cardView1.findViewById(R.id.container_for_cards_1)).setImageURI(Uri.parse("http://static.classistatic.de/imagegallery/audi/a4/audi-a4-aud_a4_01_a_4.jpg"));
        Log.d(TAG, "Load image");

//        View cardView5=getLayoutInflater(savedInstanceState).inflate(R.layout.card, container);
//        Log.d(TAG, "Inflate cards5");
//        ((SimpleDraweeView)cardView5.findViewById(R.id.container_for_cards_1)).setImageURI(Uri.parse("http://static.classistatic.de/imagegallery/audi/a4/audi-a4-aud_a4_01_a_4.jpg"));
//        Log.d(TAG, "Load image");
//
//        View cardView2=getLayoutInflater(savedInstanceState).inflate(R.layout.card, container);
//        Log.d(TAG, "Inflate cards2");
//        ((SimpleDraweeView)cardView2.findViewById(R.id.container_for_cards_1)).setImageURI(Uri.parse("http://static.classistatic.de/imagegallery/audi/a4/audi-a4-aud_a4_01_a_4.jpg"));
//        Log.d(TAG, "Load image");
//
//        View cardView3=getLayoutInflater(savedInstanceState).inflate(R.layout.card, container);
//        Log.d(TAG, "Inflate cards3");
//        ((SimpleDraweeView)cardView3.findViewById(R.id.container_for_cards_1)).setImageURI(Uri.parse("http://static.classistatic.de/imagegallery/audi/a4/audi-a4-aud_a4_01_a_4.jpg"));
//        Log.d(TAG, "Load image");
//
//        View cardView4=getLayoutInflater(savedInstanceState).inflate(R.layout.card, container);
//        Log.d(TAG, "Inflate cards4");
//        ((SimpleDraweeView)cardView4.findViewById(R.id.container_for_cards_1)).setImageURI(Uri.parse("http://static.classistatic.de/imagegallery/audi/a4/audi-a4-aud_a4_01_a_4.jpg"));
//        Log.d(TAG, "Load image");
    }
}

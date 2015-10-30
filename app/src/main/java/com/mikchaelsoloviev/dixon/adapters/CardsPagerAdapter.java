package com.mikchaelsoloviev.dixon.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.mikchaelsoloviev.dixon.Network.BaseNetworkActivity;
import com.mikchaelsoloviev.dixon.Response.CardsResponse;

import java.util.List;

import static com.mikchaelsoloviev.dixon.fragments.CardFragment.newInstance;

/**
 * Created by USER on 25.10.2015.
 */
public class CardsPagerAdapter extends FragmentStatePagerAdapter {

    private List<CardsResponse.Card> mCards;


    public CardsPagerAdapter(FragmentManager fm,List<CardsResponse.Card> data) {
        super(fm);
        mCards=data;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=newInstance(position+1);
        Log.d(BaseNetworkActivity.TAG,"position "+position +" id "+mCards.get(position).getId());
        return fragment;
    }

    @Override
    public int getCount() {
        return mCards.size();
    }


}

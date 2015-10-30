package com.mikchaelsoloviev.dixon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.mikchaelsoloviev.dixon.Response.CardsResponse;
import com.mikchaelsoloviev.dixon.adapters.CardsPagerAdapter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by USER on 25.10.2015.
 */
public class PagerActivity extends BaseActivity<CardsResponse> {

    @InjectView(R.id.pager)
    ViewPager mViewPager;
    @InjectView(R.id.pager_definition)
    TextView definition;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        ButterKnife.inject(this);
        definition.setText("bc стоит принять и закрыть--она");
        setData((CardsResponse) getIntent().getSerializableExtra("Data"));
        CardsPagerAdapter cardsPagerAdapter = new CardsPagerAdapter(getSupportFragmentManager(), getList());
        mViewPager.setAdapter(cardsPagerAdapter);
        mViewPager.setCurrentItem(getPosition() - 1);

    }


    public List<CardsResponse.Card> getList() {

        return getData().getCards();
    }


    public int getPosition() {
        return getIntent().getIntExtra("Position", 1);
    }

    public static Intent createIntentPagerActivity(Context context, CardsResponse cardsResponse, int position) {

        Intent intent = new Intent(context, PagerActivity.class);
        intent.putExtra("Data", cardsResponse);
        intent.putExtra("Position", position);
        return intent;
    }

    ;
}

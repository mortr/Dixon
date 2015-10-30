package com.mikchaelsoloviev.dixon;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mikchaelsoloviev.dixon.Network.BaseNetworkActivity;
import com.mikchaelsoloviev.dixon.Response.CardsResponse;
import com.mikchaelsoloviev.dixon.fragments.CardFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainGameActivity extends BaseNetworkActivity<CardsResponse> {

    public static final String CARD_PLACE_N1 = "card place N1";
    public static final String CARD_PLACE_N2 = "card place N2";
    public static final String CARD_PLACE_N3 = "card place N3";
    public static final String CARD_PLACE_N4 = "card place N4";
    public static final String CARD_PLACE_N5 = "card place N5";
    public static final String CARD_PLACE_N6 = "card place N6";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        loadData();

        List<CardsResponse.Card> cardList =((CardsResponse) getData()).getCards();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        CardFragment fragment = CardFragment.newInstance(1);
        fragmentTransaction.add(R.id.container_for_card_N1, fragment, CARD_PLACE_N1);

        fragment = CardFragment.newInstance(2);
        fragmentTransaction.add(R.id.container_for_card_N2, fragment, CARD_PLACE_N2);

        fragment = CardFragment.newInstance(3);
        fragmentTransaction.add(R.id.container_for_card_N3, fragment, CARD_PLACE_N3);

        fragment = CardFragment.newInstance(4);
        fragmentTransaction.add(R.id.container_for_card_N4, fragment, CARD_PLACE_N4);

        fragment = CardFragment.newInstance(5);
        fragmentTransaction.add(R.id.container_for_card_N5, fragment, CARD_PLACE_N5);

        fragment = CardFragment.newInstance(6);
        fragmentTransaction.add(R.id.container_for_card_N6, fragment, CARD_PLACE_N6);

        fragmentTransaction.commit();
    }
//"http://static.classistatic.de/imagegallery/audi/a4/audi-a4-aud_a4_01_a_4.jpg"
//"http://dixiton.azurewebsites.net/Content/images/progress.png"
// fragment = CardFragment.newInstance(cardList.get(5).getReference(), cardList.get(5).getId());


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loadData() {
        List<CardsResponse.Card> cards=new ArrayList<>(6);

        for (int i =0;i<6;i++){
            CardsResponse.Card card=new CardsResponse.Card("http://dixiton.azurewebsites.net/Content/images/progress.png",new Random().nextLong());
            cards.add(card);

        }
         data=new CardsResponse(cards);
        setData(data);
    }
}

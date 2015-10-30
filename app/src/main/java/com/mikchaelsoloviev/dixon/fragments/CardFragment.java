package com.mikchaelsoloviev.dixon.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mikchaelsoloviev.dixon.BaseActivity;
import com.mikchaelsoloviev.dixon.MainGameActivity;
import com.mikchaelsoloviev.dixon.Network.BaseNetworkFragment;
import com.mikchaelsoloviev.dixon.PagerActivity;
import com.mikchaelsoloviev.dixon.R;
import com.mikchaelsoloviev.dixon.Response.CardsResponse;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static com.mikchaelsoloviev.dixon.PagerActivity.createIntentPagerActivity;

/**
 * Created by USER on 24.10.2015.
 */
public class CardFragment extends BaseNetworkFragment implements View.OnClickListener {
    public final static String CARD_REFERENCE = "card reference";
    public final static String CARD_ID = "card id";
    public final static String GAMER_ID = "gamer id";
    public final static String GAME_ID = "game id";
    public static final String CARD_POSITION = "card position";

    @InjectView(R.id.card_image)
    SimpleDraweeView cardImage;

    @InjectView(R.id.select_card)
    Button select_card;

    private CardsResponse mCardsResponse;
    private CardsResponse.Card mCard;
    private int position;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View card = inflater.inflate(R.layout.card, container, false);
        ButterKnife.inject(this, card);
        definePosition();
        mCardsResponse = (CardsResponse) ((BaseActivity) getActivity()).getData();
        mCard = mCardsResponse.getCards().get(position - 1);
        cardImage.setImageURI(Uri.parse(mCard.getReference()));
        cardImage.setOnClickListener(this);
        select_card.setOnClickListener(this);


        return card;
    }


    public static CardFragment newInstance(String reference, long cardId) {

        Bundle args = new Bundle(2);

        args.putString(CARD_REFERENCE, reference);

        args.putLong(CARD_ID, cardId);

        CardFragment fragment = new CardFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public static CardFragment newInstance(int position) {
        Bundle args = new Bundle(1);
        args.putInt(CARD_POSITION, position);
        CardFragment fragment = new CardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    void definePosition() {

        if (getArguments().containsKey(CARD_POSITION)) {
            setPosition(position = getArguments().getInt(CARD_POSITION));
        } else {

            definePositionByTag();
        }
    }

    private void definePositionByTag() {

        switch (getTag()) {

            case MainGameActivity.CARD_PLACE_N1: {
                setPosition(1);
                break;
            }
            case MainGameActivity.CARD_PLACE_N2: {
                setPosition(2);
                break;
            }
            case MainGameActivity.CARD_PLACE_N3: {
                setPosition(3);
                break;
            }
            case MainGameActivity.CARD_PLACE_N4: {
                setPosition(4);
                break;
            }
            case MainGameActivity.CARD_PLACE_N5: {
                setPosition(5);
                break;
            }
            case MainGameActivity.CARD_PLACE_N6: {
                setPosition(6);
                break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.select_card: {
                Toast.makeText(getActivity(), position + "You select card with Id" + mCard.getId(), Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.card_image: {
                if (getActivity() instanceof PagerActivity){
                    Toast.makeText(getActivity(), "this max size. That show selectbutton -- scroll down", Toast.LENGTH_SHORT).show();
                    break;
                }
                Toast.makeText(getActivity(), "to Pager", Toast.LENGTH_SHORT).show();

                startActivity(createIntentPagerActivity(getActivity(), mCardsResponse, position));
                break;
            }
        }
    }
}

package com.mikchaelsoloviev.dixon.Response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by USER on 24.10.2015.
 */

/*TODO Parcelable*/
public class CardsResponse implements Serializable {
    List<Card> cards;

    public CardsResponse(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public static   class Card implements Serializable{
        private String reference;
        private long id;

        public Card(String reference, long id) {
            this.reference = reference;
            this.id = id;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }
}

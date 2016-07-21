package com.jhy.androidcarduilibrary.database;

import android.widget.LinearLayout;

import com.jhy.androidcarduilibrary.database.model.Card;
import com.jhy.androidcarduilibrary.database.model.Item;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhy on 08-Jul-16.
 */
public class Retrieval {

    public List<Card> getDBCard() {
        List<Card> cards = SQLite.select().from(Card.class).queryList();

        List<Card> cardsToRemove = new ArrayList<>();
        for (Card c : cards) {
            List<Item> items = c.getMyItems();

            List<Item> itemToRemove = new ArrayList<>();
            for (Item i : items) {
                //rdts flag check-----
                if (!i.getRdts().isEmpty()) itemToRemove.add(i);
                //end ------
            }

            items.removeAll(itemToRemove);

            if (items.size() == 0) cardsToRemove.add(c);
        }

        cards.removeAll(cardsToRemove);

        return cards;
    }
}

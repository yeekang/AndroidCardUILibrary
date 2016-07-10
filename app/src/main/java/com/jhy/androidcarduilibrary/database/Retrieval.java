package com.jhy.androidcarduilibrary.database;

import com.jhy.androidcarduilibrary.database.model.Card;
import com.jhy.androidcarduilibrary.database.model.Item;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by jhy on 08-Jul-16.
 */
public class Retrieval {

    public List<Card> getDBCard() {
        List<Card> cards = SQLite.select().from(Card.class).queryList();

        for (Card c : cards) {
            List<Item> items = c.getMyItems();
            for (Item i : items) {
                //rdts flag check-----
                if(!i.getRdts().isEmpty()) {
                    items.remove(i);
                }
                //end ------
            }
        }

        return cards;
    }
}

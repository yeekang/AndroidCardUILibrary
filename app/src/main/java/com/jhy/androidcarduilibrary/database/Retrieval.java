package com.jhy.androidcarduilibrary.database;

import com.jhy.androidcarduilibrary.database.model.Card;
import com.jhy.androidcarduilibrary.database.model.Item;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by jhyha on 08-Jul-16.
 */
public class Retrieval {

    public List<Card> getDBCard() {
        List<Card> cards = SQLite.select().from(Card.class).queryList();

        //-----for checking use-----
        //String s = "";
        for (Card c : cards) {
            //s += c.getType() + "  " + c.getSubtype() + "\n";
            List<Item> items = c.getMyItems();
            for (Item i : items) {
                try {
                    //parse back body as json
                    JSONObject bdJSON = new JSONObject(i.getBd());
                } catch (JSONException e) {
                    System.out.println(e);
                }
                //s += "\t" + i.getCdid() + " " + i.getImgid() + " " + i.getBd() + " " + i.getRmb() + " " + i.getCrts() + " " + i.getRdts() + "\n";
            }
        }
        //System.out.println(s);
        //--------end--------

        return cards;
    }


}

package com.jhy.androidcarduilibrary.network;

import android.widget.TextView;

import com.jhy.androidcarduilibrary.database.model.Card;
import com.jhy.androidcarduilibrary.database.model.Item;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by jhyha on 29-Jun-16.
 */
public class ParseJSON {

    public void parseJSON(String json) {


        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("result");

            for(int i=0; i<jsonArray.length(); i++) {
                JSONObject jo = jsonArray.getJSONObject(i);

                //insert into database
                Card card = new Card();
                card.setType(jo.getString("tp"));
                card.setSubtype(jo.getString("subtp"));
                card.save();

                JSONArray cardItem = jo.getJSONArray("itm");

                for(int j =0; j < cardItem.length(); j++) {
                    JSONObject itm = cardItem.getJSONObject(j);

                    Item item = new Item();
                    item.setCdid(itm.getString("cdid"));
                    item.setImgid(itm.getString("imgid"));
                    item.setBd(itm.getString("bd"));
                    item.setRmb(itm.getString("rmb"));
                    item.setCrts(itm.getString("crts"));
                    item.setRdts(itm.getString("rdts"));
                    item.associateCard(card);
                    item.save();
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

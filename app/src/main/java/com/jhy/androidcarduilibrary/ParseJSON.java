package com.jhy.androidcarduilibrary;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
                card.setItm(jo.getString("itm"));
                card.save();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

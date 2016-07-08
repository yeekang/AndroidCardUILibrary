package com.jhy.androidcarduilibrary.view;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.jhy.androidcarduilibrary.Bulletin;
import com.jhy.androidcarduilibrary.Opportunitymap;
import com.jhy.androidcarduilibrary.R;
import com.jhy.androidcarduilibrary.adapter.RVAdapter;
import com.jhy.androidcarduilibrary.database.CardDB;
import com.jhy.androidcarduilibrary.database.Retrieval;
import com.jhy.androidcarduilibrary.database.model.Card;
import com.jhy.androidcarduilibrary.database.model.Item;
import com.jhy.androidcarduilibrary.network.Connection;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FlowManager.init(new FlowConfig.Builder(this).openDatabasesOnInit(true).build());
        FlowManager.getDatabase(CardDB.class).getWritableDatabase();
        //new Connection().getJSON(this);
        //new Retrieval().getDBCard();

        setContentView(R.layout.recycler_view);

        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeAdapter();
    }

    private ArrayList<Object> getSampleArrayList() {
        ArrayList<Object> items = new ArrayList<>();

        List<Card> cards = new Retrieval().getDBCard();
        for (Card c : cards) {
            switch (c.getType()) {
                case "BULLETIN" : {
                    for (Item item : c.getMyItems()) {
                        try {
                            JSONObject body = new JSONObject(item.getBd());
                            items.add(new Bulletin(body.getString("Title"),body.getString("PublishTS"),
                                    body.getString("Snippet"), body.getString("NewsId"),body.getString("SourceUrl"),
                                    body.getString("ImageId"),body.getString("ShowContent")));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    break ;
                }
                case "OPPORTUNITYMAP" : {
                    for (Item item : c.getMyItems()) {
                        try {
                            JSONObject body = new JSONObject(item.getBd());
                            items.add(new Opportunitymap(body.getString("Title"),body.getString("Desc"),
                                    body.getString("Url"), body.getInt("SeriesCount")));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
                case "TRANSACTION" : {
                    break;
                }
                default: break;
            }
        }
        //items.add(new Bulletin("Quick Bites - Malaysia Airports Holdings", "2016-06-13T00:17:00", "May’s Passenger Traffic Snapshot", "3B10776F-4539-4398-AE78-1E682A121D06", "http://www.kenanga.com.my/general/kenanga-today", "A3B799E3-16F0-4637-BB88-79268D8EA79E", "Y"));
        //items.add(new Opportunitymap("New opportunity map is available!", "", "", 117));

        return items;
    }

    private void initializeAdapter() {
        // Bind adapter to recycler view object
        RVAdapter adapter = new RVAdapter(getSampleArrayList());
        rv.setAdapter(adapter);
    }
}
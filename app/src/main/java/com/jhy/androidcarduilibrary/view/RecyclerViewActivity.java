package com.jhy.androidcarduilibrary.view;



import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.jhy.androidcarduilibrary.R;
import com.jhy.androidcarduilibrary.adapter.RVAdapter;
import com.jhy.androidcarduilibrary.database.CardDB;
import com.jhy.androidcarduilibrary.database.Retrieval;
import com.jhy.androidcarduilibrary.network.Connection;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;


public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rv;
    SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FlowManager.init(new FlowConfig.Builder(this).openDatabasesOnInit(true).build());
        FlowManager.getDatabase(CardDB.class).getWritableDatabase();


        //pls make refresh function for tis
        //new Connection().getJSON(this);


        //new Retrieval().getDBCard();
        setContentView(R.layout.recycler_view);

        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        //initializeAdapter();
        new Setup().setUpItemTouchHelp(rv);

        //find swipe container
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        //setup for refresh listener
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Connection().getJSON(RecyclerViewActivity.this, rv, swipeContainer);
            }
        });
    }


    private void initializeAdapter() {
        // Bind adapter to recycler view object
        RVAdapter adapter = new RVAdapter(new Retrieval().getDBCard());
        rv.setAdapter(adapter);
    }
}
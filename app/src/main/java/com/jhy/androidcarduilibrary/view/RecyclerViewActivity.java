package com.jhy.androidcarduilibrary.view;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jhy.androidcarduilibrary.R;
import com.jhy.androidcarduilibrary.adapter.RVAdapter;
import com.jhy.androidcarduilibrary.database.CardDB;
import com.jhy.androidcarduilibrary.database.Retrieval;
import com.jhy.androidcarduilibrary.network.Connection;
import com.jhy.androidcarduilibrary.toolbox.RecyclerItemClickListener;
import com.jhy.androidcarduilibrary.toolbox.RecyclerViewInterface;
import com.jhy.androidcarduilibrary.toolbox.SwipeDismissRecyclerViewTouchListener;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rv;
    private RVAdapter adapter;
    SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FlowManager.init(new FlowConfig.Builder(this).openDatabasesOnInit(true).build());
        FlowManager.getDatabase(CardDB.class).getWritableDatabase();

        //original recyclerview is tis
        setContentView(R.layout.recycler_view);

        //find swipe container
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        //setup for refresh listener
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {//refresh data get from internet
                new Connection().getJSON(RecyclerViewActivity.this, adapter, swipeContainer);
            }
        });

        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        //initializeAdapter();
        adapter = new RVAdapter(new Retrieval().getDBCard(), this, rv);

        List<String> itemViewTypes = new ArrayList<String>(Arrays.asList("BULLETIN","OPPORTUNITYMAP", "TRANSACTION", "RESEARCHREPORT",
                "QUICKBITES", "CORPACTION", "INDEX", "LEADERVOTE" ));
        adapter.setItemViewTypes(itemViewTypes);

        rv.setAdapter(adapter);

        /*
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.onCardRemove((RVAdapter.ViewHolder) viewHolder,rv);
            }
        };

        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        //mItemTouchHelper.attachToRecyclerView(rv);//make card in RV swipe-able
        */

        // Assign swipe listener to cards.
//        SwipeDismissRecyclerViewTouchListener swipeListener = new SwipeDismissRecyclerViewTouchListener(
//                rv,
//                new SwipeDismissRecyclerViewTouchListener.DismissCallbacks() {
//                    @Override
//                    public boolean canDismiss(View view, int position) {
//                        Log.d("", "Master dismiss");
//                        System.out.println("Master dismiss");
//                        return true;
//                    }
//
//                    @Override
//                    public void onDismiss(RecyclerView recyclerView, int[] reverseSortedPositions, View removedView) {
//                        Log.d("", "On master dismiss");
//                        System.out.println("On master dismiss");
//                        for (int i : reverseSortedPositions) {
//                            adapter.onCardRemove(i, removedView, recyclerView);
//                        }
//
//                    }
//                }
//        );
        rv.setOnTouchListener(adapter.getCardTouchListener());//getCardTouchListener contain onCardRemove funtionc
        //rv.setOnTouchListener(swipeListener);
        //rv.addOnScrollListener(swipeListener.makeScrollListener());

        // Assign on click listener to cards.
        rv.addOnItemTouchListener(new RecyclerItemClickListener(
                rv,
                new RecyclerViewInterface() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO: Disable for when card is a multi list.
                        // TODO: Or only enable for when single card.

                        if (adapter.getItemViewType(position) == 0 || adapter.getItemViewType(position) == 1 || adapter.getItemViewType(position) == 2 || adapter.getItemViewType(position) == 7) {
                            // Click logic here for each main card (row) in list.
                            Log.d("", "Card click here.");
                            //view.setOnTouchListener(null);
                            Toast.makeText(RecyclerViewActivity.this, "Clicked on " + position, Toast.LENGTH_SHORT).show();
                        } else {
                            //view.setClickable(false);
                        }

                    }

                    @Override
                    public void onItemLongPress(View view, int position) {

                    }
                }
        ));
    }
}
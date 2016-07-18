package com.jhy.androidcarduilibrary.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.jhy.androidcarduilibrary.adapter.RVAdapter;
import com.jhy.androidcarduilibrary.database.Retrieval;

/**
 * Created by jhyha on 11-Jul-16.
 */
public class Setup {
    public void setUpItemTouchHelp(final RecyclerView rv, Context context) {
        final RVAdapter adapter = new RVAdapter(new Retrieval().getDBCard(), context, rv);
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.onItemRemove((RVAdapter.ViewHolder) viewHolder,rv);
            }
        };

        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        mItemTouchHelper.attachToRecyclerView(rv);
        rv.setAdapter(adapter);
    }
}

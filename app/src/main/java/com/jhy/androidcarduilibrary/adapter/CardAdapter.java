package com.jhy.androidcarduilibrary.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jhy.androidcarduilibrary.viewholder.CardViewHolder;

import java.util.List;

/**
 * Created by jhyha on 18-Jul-16.
 */
public abstract class CardAdapter<VH extends CardViewHolder> extends RecyclerView.Adapter<VH> {

    private RecyclerView recyclerView;

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public int getItemViewType(int position) {
        /*
        String type = cards.get(position).getType();

        for (int i = 0 ; i < itemViewTypes.size() ; i++) {
            if (type.equalsIgnoreCase(itemViewTypes.get(i)))
                return i;
        }
*/
        return -1;

    }


}

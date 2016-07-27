package com.jhy.uselesslibrary.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jhyha on 18-Jul-16.
 */
public abstract class CardViewHolder extends RecyclerView.ViewHolder {

    public CardViewHolder(View itemView) {
        super(itemView);
    }

    public void setData() {}

}

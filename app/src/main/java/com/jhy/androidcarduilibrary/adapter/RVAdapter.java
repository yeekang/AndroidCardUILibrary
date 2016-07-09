package com.jhy.androidcarduilibrary.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jhy.androidcarduilibrary.Bulletin;
import com.jhy.androidcarduilibrary.Opportunitymap;
import com.jhy.androidcarduilibrary.R;
import com.jhy.androidcarduilibrary.database.model.Item;


import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>{

    private static List<Object> items;

    private final int BULLETIN = 0, OPPORTUNITYMAP = 1;

    public RVAdapter(ArrayList<Object> items) {
        this.items = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch(getPosition()){
                case 0:
                    Log.d("aa","First one tapped!");
                    break;
                case 1:
                    Log.d("aa","Second one tapped!");
                    break;
                case 2:
                    Log.d("aa","Third one tapped!");
                    break;
                default:
                    break;
            }
        }
    }

    public class ViewHolder1 extends RVAdapter.ViewHolder {

        private TextView label1, label2, label3, label4, label5, label6, label7;

        public ViewHolder1(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.item1);
            label2 = (TextView) v.findViewById(R.id.item2);
            label3 = (TextView) v.findViewById(R.id.item3);
            label4 = (TextView) v.findViewById(R.id.item4);
            label5 = (TextView) v.findViewById(R.id.item5);
            label6 = (TextView) v.findViewById(R.id.item6);
            label7 = (TextView) v.findViewById(R.id.item7);
        }

        public TextView getLabel1() {
            return label1;
        }

        public TextView getLabel2() {
            return label2;
        }

        public TextView getLabel3() {
            return label3;
        }

        public TextView getLabel4() {
            return label4;
        }

        public TextView getLabel5() {
            return label5;
        }

        public TextView getLabel6() {
            return label6;
        }

        public TextView getLabel7() {
            return label7;
        }

    }

    public class ViewHolder2 extends RVAdapter.ViewHolder {

        private TextView label1, label2, label3, label4;

        public ViewHolder2(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.item8);
            label2 = (TextView) v.findViewById(R.id.item9);
            label3 = (TextView) v.findViewById(R.id.item10);
            label4 = (TextView) v.findViewById(R.id.item11);
        }

        public TextView getLabel1() {
            return label1;
        }

        public TextView getLabel2() {
            return label2;
        }

        public TextView getLabel3() {
            return label3;
        }

        public TextView getLabel4() {
            return label4;
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public int getItemViewType(int position){
        if(items.get(position) instanceof Bulletin){
            return BULLETIN;
        }else if(items.get(position) instanceof Opportunitymap){
            return OPPORTUNITYMAP;
        }
        return -1;
    }

    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int viewType){
        RVAdapter.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch(viewType){
            case BULLETIN:
                View v1 = inflater.inflate(R.layout.item1, viewGroup, false);
                viewHolder = new ViewHolder1(v1);
                break;
            case OPPORTUNITYMAP:
                View v2 = inflater.inflate(R.layout.item2, viewGroup, false);
                viewHolder = new ViewHolder2(v2);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RVAdapter.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case BULLETIN:
                ViewHolder1 vh1 = (ViewHolder1) viewHolder;
                configureViewHolder1(vh1, position);
                break;
            case OPPORTUNITYMAP:
                ViewHolder2 vh2 = (ViewHolder2) viewHolder;
                configureViewHolder2(vh2, position);
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    private void configureViewHolder1(ViewHolder1 vh1, int position) {
        Bulletin bulletin = (Bulletin) items.get(position);
        if (bulletin != null) {
            vh1.getLabel1().setText("Title: " + bulletin.title);
            vh1.getLabel2().setText("PublishTS: " + bulletin.publishTS);
            vh1.getLabel3().setText("Snippet: " + bulletin.snippet);
            vh1.getLabel4().setText("NewsId: " + bulletin.newsId);
            vh1.getLabel5().setText("SourceUrl: " + bulletin.sourceUrl);
            vh1.getLabel6().setText("ImageId: " + bulletin.imageId);
            vh1.getLabel7().setText("ShowContent: " + bulletin.showContent);
        }
    }

    @SuppressLint("SetTextI18n")
    private void configureViewHolder2(ViewHolder2 vh2, int position) {
        Opportunitymap opportunitymap = (Opportunitymap) items.get(position);
        if(opportunitymap != null) {
            vh2.getLabel1().setText("Title: " + Opportunitymap.title);
            vh2.getLabel2().setText("Desc: " + Opportunitymap.desc);
            vh2.getLabel3().setText("Url: " + Opportunitymap.url);
            vh2.getLabel4().setText("SeriesCount: " + Opportunitymap.seriesCount);
        }
    }

    public void onItemRemove(final ViewHolder viewHolder, final RecyclerView rv) {
        int adapterPosition = viewHolder.getAdapterPosition();
        final Object mItem = items.get(adapterPosition);
        Snackbar snackbar = Snackbar
                .make(rv, "Archieved", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        int mAdapterPosition = viewHolder.getAdapterPosition();
                        items.add(mAdapterPosition,mItem);
                        notifyItemInserted(mAdapterPosition);
                        rv.scrollToPosition(mAdapterPosition);
                    }
                });
        snackbar.show();
        items.remove(adapterPosition);
        rv.removeViewAt(adapterPosition);
        this.notifyItemRemoved(adapterPosition);
    }
}
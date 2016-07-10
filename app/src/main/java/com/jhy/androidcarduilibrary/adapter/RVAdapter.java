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

import com.jhy.androidcarduilibrary.R;
import com.jhy.androidcarduilibrary.database.model.Card;
import com.jhy.androidcarduilibrary.database.model.Item;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>{

    private final int BULLETIN = 0, OPPORTUNITYMAP = 1;

    private static List<Card> cards;//by jhy
    public RVAdapter(List<Card> cards) {this.cards = cards;} //by jhy

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
        return cards.size();
    }

    public int getItemViewType(int position) {  //by jhy
        if(cards.get(position).getType().equals("BULLETIN")) {
            return 0;
        } else if(cards.get(position).getType().equals("OPPORTUNITYMAP")) {
            return 1;
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
        List<Item> itms = cards.get(position).getMyItems();//should use it ?

        if (!cards.get(position).getMyItems().isEmpty()) {
            for(int i = 0; i < cards.get(position).getMyItems().size(); i++) {
                try {
                    JSONObject body = new JSONObject(cards.get(position).getMyItems().get(i).getBd());
                    vh1.getLabel1().setText("Title: " +  body.getString("Title"));
                    vh1.getLabel2().setText("PublishTS: " + body.getString("PublishTS"));
                    vh1.getLabel3().setText("Snippet: " + body.getString("Snippet"));
                    vh1.getLabel4().setText("NewsId: " + body.getString("NewsId"));
                    vh1.getLabel5().setText("SourceUrl: " + body.getString("SourceUrl"));
                    vh1.getLabel6().setText("ImageId: " + body.getString("ImageId"));
                    vh1.getLabel7().setText("ShowContent: " + body.getString("ShowContent"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void configureViewHolder2(ViewHolder2 vh2, int position) {
        List<Item> itms = cards.get(position).getMyItems();//should use it ?

        if (!cards.get(position).getMyItems().isEmpty()) {
            for (int i = 0; i < cards.get(position).getMyItems().size(); i++) {
                try {
                    JSONObject body = new JSONObject(cards.get(position).getMyItems().get(i).getBd());
                    vh2.getLabel1().setText("Title: " + body.getString("Title"));
                    vh2.getLabel2().setText("Desc: " + body.getString("Desc"));
                    vh2.getLabel3().setText("Url: " + body.getString("Url"));
                    vh2.getLabel4().setText("SeriesCount: " + body.getString("SeriesCount"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void onItemRemove(final ViewHolder viewHolder, final RecyclerView rv) {
        int adapterPosition = viewHolder.getAdapterPosition();
        final Card cItem = cards.get(adapterPosition);
        Snackbar snackbar = Snackbar
                .make(rv, "Archieved", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        int mAdapterPosition = viewHolder.getAdapterPosition();
                        cards.add(mAdapterPosition,cItem);
                        notifyItemInserted(mAdapterPosition);
                        rv.scrollToPosition(mAdapterPosition);
                    }
                });
        snackbar.show();
        cards.remove(adapterPosition);
        rv.removeViewAt(adapterPosition);
        this.notifyItemRemoved(adapterPosition);
    }
}
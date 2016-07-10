package com.jhy.androidcarduilibrary.adapter;

import android.annotation.SuppressLint;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jhy.androidcarduilibrary.R;
import com.jhy.androidcarduilibrary.database.FlagingRDTS;
import com.jhy.androidcarduilibrary.database.model.Card;
import com.jhy.androidcarduilibrary.database.model.Item;


import org.json.JSONException;
import org.json.JSONObject;


import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>{

    private final int BULLETIN = 0, OPPORTUNITYMAP = 1, TRANSACTION = 2;

    private static List<Card> cards;

    public RVAdapter(List<Card> cards) {
        this.cards = cards;
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
    }

    public class ViewHolder3 extends RVAdapter.ViewHolder {

        private TextView label1, label2, label3, label4, label5, label6, label7;

        public ViewHolder3(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.item1);
            label2 = (TextView) v.findViewById(R.id.item2);
            label3 = (TextView) v.findViewById(R.id.item3);
            label4 = (TextView) v.findViewById(R.id.item4);
            label5 = (TextView) v.findViewById(R.id.item5);
            label6 = (TextView) v.findViewById(R.id.item6);
            label7 = (TextView) v.findViewById(R.id.item7);
        }

    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public int getItemViewType(int position) {
        if(cards.get(position).getType().equals("BULLETIN")) {
            return 0;
        } else if(cards.get(position).getType().equals("OPPORTUNITYMAP")) {
            return 1;
        } else if(cards.get(position).getType().equals("TRANSACTION")){
            return 2;
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
            case TRANSACTION:
                View v3 = inflater.inflate(R.layout.item3, viewGroup, false);
                viewHolder = new ViewHolder3(v3);
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
            case TRANSACTION:
                ViewHolder3 vh3 = (ViewHolder3) viewHolder;
                configureViewHolder3(vh3, position);
        }
    }

    @SuppressLint("SetTextI18n")
    private void configureViewHolder1(ViewHolder1 vh1, int position) {
        List<Item> itms = cards.get(position).items;

        if (!itms.isEmpty()) {
            for(int i = 0; i < itms.size(); i++) {
                try {
                    JSONObject body = new JSONObject(itms.get(i).getBd());
                    vh1.label1.setText("Title: " +  body.getString("Title"));
                    vh1.label2.setText("PublishTS: " + body.getString("PublishTS"));
                    vh1.label3.setText("Snippet: " + body.getString("Snippet"));
                    vh1.label4.setText("NewsId: " + body.getString("NewsId"));
                    vh1.label5.setText("SourceUrl: " + body.getString("SourceUrl"));
                    vh1.label6.setText("ImageId: " + body.getString("ImageId"));
                    vh1.label7.setText("ShowContent: " + body.getString("ShowContent"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void configureViewHolder2(ViewHolder2 vh2, int position) {
        List<Item> itms = cards.get(position).items;

        if (!itms.isEmpty()) {
            for (int i = 0; i < itms.size(); i++) {
                try {
                    JSONObject body = new JSONObject(itms.get(i).getBd());
                    vh2.label1.setText("Title: " + body.getString("Title"));
                    vh2.label2.setText("Desc: " + body.getString("Desc"));
                    vh2.label3.setText("Url: " + body.getString("Url"));
                    vh2.label4.setText("SeriesCount: " + body.getString("SeriesCount"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void configureViewHolder3(ViewHolder3 vh3, int position) {
        List<Item> itms = cards.get(position).items;

        if (!itms.isEmpty()) {
            for(int i = 0; i < itms.size(); i++) {
                try {
                    JSONObject body = new JSONObject(itms.get(i).getBd());
                    vh3.label1.setText("AccountId: " +  body.getString("AccountId"));
                    vh3.label2.setText("AccountNo: " + body.getString("AccountNo"));
                    vh3.label3.setText("TotalOrder: " + body.getString("TotalOrder"));
                    vh3.label4.setText("OpenOrder: " + body.getString("OpenOrder"));
                    vh3.label5.setText("FilledOrder: " + body.getString("FilledOrder"));
                    vh3.label6.setText("Currency: " + body.getString("Currency"));
                    vh3.label7.setText("AvailableLimit: " + body.getString("AvailableLimit"));
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
                        new FlagingRDTS().resetRDTS(cItem.items.get(0));//need to make change for multi list do not use get(0)
                    }
                });
        snackbar.show();
        cards.remove(adapterPosition);
        rv.removeViewAt(adapterPosition);
        this.notifyItemRemoved(adapterPosition);

        new FlagingRDTS().saveRDTS(cItem.items.get(0));//need to make change for multi list
    }
}
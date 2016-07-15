package com.jhy.androidcarduilibrary.adapter;

import android.annotation.SuppressLint;

import android.content.Intent;
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
import com.jhy.androidcarduilibrary.view.ScreenA;
import com.jhy.androidcarduilibrary.view.ScreenB;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>{

    private final int BULLETIN = 0, OPPORTUNITYMAP = 1, TRANSACTION = 2;
    private final int RESEARCHREPORT = 3;

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
                    Intent intent1 = new Intent(view.getContext(),ScreenA.class);
                    (view.getContext()).startActivity(intent1);
                    break;
                case 1:
                    Log.d("aa","Second one tapped!");
                    Intent intent2 = new Intent(view.getContext(),ScreenB.class);
                    (view.getContext()).startActivity(intent2);
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
            label1 = (TextView) v.findViewById(R.id.text1);
            label2 = (TextView) v.findViewById(R.id.text2);
            label3 = (TextView) v.findViewById(R.id.text3);
            label4 = (TextView) v.findViewById(R.id.text4);
            label5 = (TextView) v.findViewById(R.id.text5);
            label6 = (TextView) v.findViewById(R.id.text6);
            label7 = (TextView) v.findViewById(R.id.text7);
        }

    }

    public class ViewHolder2 extends RVAdapter.ViewHolder {

        private TextView label1, label2, label3, label4;

        public ViewHolder2(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.text1);
            label2 = (TextView) v.findViewById(R.id.text2);
            label3 = (TextView) v.findViewById(R.id.text3);
            label4 = (TextView) v.findViewById(R.id.text4);
        }
    }

    public class ViewHolder3 extends RVAdapter.ViewHolder {

        private TextView label1, label2, label3, label4, label5, label6, label7;

        public ViewHolder3(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.text1);
            label2 = (TextView) v.findViewById(R.id.text2);
            label3 = (TextView) v.findViewById(R.id.text3);
            label4 = (TextView) v.findViewById(R.id.text4);
            label5 = (TextView) v.findViewById(R.id.text5);
            label6 = (TextView) v.findViewById(R.id.text6);
            label7 = (TextView) v.findViewById(R.id.text7);
        }
    }

    public class ViewHolder4 extends RVAdapter.ViewHolder {

        private TextView label1, label2, label3, label4, label5, label6, label7,label8,label9,label10;
        private TextView label11, label12, label13, label14, label15, label16, label17,label18,label19,label20;
        private TextView label21, label22, label23, label24, label25, label26, label27,label28,label29,label30;

        public ViewHolder4(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.text1);
            label2 = (TextView) v.findViewById(R.id.text2);
            label3 = (TextView) v.findViewById(R.id.text3);
            label4 = (TextView) v.findViewById(R.id.text4);
            label5 = (TextView) v.findViewById(R.id.text5);
            label6 = (TextView) v.findViewById(R.id.text6);
            label7 = (TextView) v.findViewById(R.id.text7);
            label8 = (TextView) v.findViewById(R.id.text8);
            label9 = (TextView) v.findViewById(R.id.text9);
            label10 = (TextView) v.findViewById(R.id.text10);
            label11 = (TextView) v.findViewById(R.id.text11);
            label12 = (TextView) v.findViewById(R.id.text12);
            label13 = (TextView) v.findViewById(R.id.text13);
            label14 = (TextView) v.findViewById(R.id.text14);
            label15 = (TextView) v.findViewById(R.id.text15);
            label16 = (TextView) v.findViewById(R.id.text16);
            label17 = (TextView) v.findViewById(R.id.text17);
            label18 = (TextView) v.findViewById(R.id.text18);
            label19 = (TextView) v.findViewById(R.id.text19);
            label20 = (TextView) v.findViewById(R.id.text20);
            label21 = (TextView) v.findViewById(R.id.text21);
            label22 = (TextView) v.findViewById(R.id.text22);
            label23 = (TextView) v.findViewById(R.id.text23);
            label24 = (TextView) v.findViewById(R.id.text24);
            label25 = (TextView) v.findViewById(R.id.text25);
            label26 = (TextView) v.findViewById(R.id.text26);
            label27 = (TextView) v.findViewById(R.id.text27);
            label28 = (TextView) v.findViewById(R.id.text28);
            label29 = (TextView) v.findViewById(R.id.text29);
            label30 = (TextView) v.findViewById(R.id.text30);
        }
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public int getItemViewType(int position) {
//        String type = cards.get(position).getType();
//
//        for (int i = 0 ; i < itemViewTypes.size() ; i++) {
//            if (type.equalsIgnoreCase(itemViewTypes.get(i)))
//                return i;
//        }
//
//        return -1;

        if(cards.get(position).getType().equals("BULLETIN")) {
            return 0;
        } else if(cards.get(position).getType().equals("OPPORTUNITYMAP")) {
            return 1;
        } else if(cards.get(position).getType().equals("TRANSACTION")){
            return 2;
        }else if(cards.get(position).getType().equals("RESEARCHREPORT")){
            return 3;
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
            case RESEARCHREPORT:
                View v4 = inflater.inflate(R.layout.item4, viewGroup, false);
                viewHolder = new ViewHolder4(v4);
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
                break;
            case RESEARCHREPORT:
                ViewHolder4 vh4 = (ViewHolder4) viewHolder;
                configureViewHolder4(vh4, position);
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    private void configureViewHolder1(ViewHolder1 vh1, int position) {
        List<Item> itms = cards.get(position).items;

        if (!itms.isEmpty()) {
            for(int i = 0; i < itms.size(); i++) {
                try {
                    JSONObject body = new JSONObject(itms.get(i).getBd());

                        vh1.label1.setText("Title: " + body.getString("Title"));
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

    @SuppressLint("SetTextI18n")
    private void configureViewHolder4(ViewHolder4 vh4, int position) {
        List<Item> itms = cards.get(position).items;

        if (!itms.isEmpty()) {
            for(int i = 0; i < itms.size(); i++) {
                switch(i){
                    case 0:
                        try {
                            JSONObject body = new JSONObject(itms.get(i).getBd());
                            vh4.label1.setText("SeriesId: " +  body.getString("SeriesId"));
                            vh4.label2.setText("SeriesCode: " + body.getString("SeriesCode"));
                            vh4.label3.setText("ShortName: " + body.getString("ShortName"));
                            vh4.label4.setText("SeriesName: " + body.getString("SeriesName"));
                            vh4.label5.setText("ResearchTitle: " + body.getString("ResearchTitle"));
                            vh4.label6.setText("ResearchHouse: " + body.getString("ResearchHouse"));
                            vh4.label7.setText("TargetPrice: " + body.getString("TargetPrice"));
                            vh4.label8.setText("LastPrice: " + body.getString("LastPrice"));
                            vh4.label9.setText("Recommendation: " + body.getString("Recommendation"));
                            vh4.label10.setText("Url: " + body.getString("Url"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 1:
                        try {
                            JSONObject body = new JSONObject(itms.get(i).getBd());
                            vh4.label11.setText("SeriesId: " +  body.getString("SeriesId"));
                            vh4.label12.setText("SeriesCode: " + body.getString("SeriesCode"));
                            vh4.label13.setText("ShortName: " + body.getString("ShortName"));
                            vh4.label14.setText("SeriesName: " + body.getString("SeriesName"));
                            vh4.label15.setText("ResearchTitle: " + body.getString("ResearchTitle"));
                            vh4.label16.setText("ResearchHouse: " + body.getString("ResearchHouse"));
                            vh4.label17.setText("TargetPrice: " + body.getString("TargetPrice"));
                            vh4.label18.setText("LastPrice: " + body.getString("LastPrice"));
                            vh4.label19.setText("Recommendation: " + body.getString("Recommendation"));
                            vh4.label20.setText("Url: " + body.getString("Url"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            JSONObject body = new JSONObject(itms.get(i).getBd());
                            vh4.label21.setText("SeriesId: " +  body.getString("SeriesId"));
                            vh4.label22.setText("SeriesCode: " + body.getString("SeriesCode"));
                            vh4.label23.setText("ShortName: " + body.getString("ShortName"));
                            vh4.label24.setText("SeriesName: " + body.getString("SeriesName"));
                            vh4.label25.setText("ResearchTitle: " + body.getString("ResearchTitle"));
                            vh4.label26.setText("ResearchHouse: " + body.getString("ResearchHouse"));
                            vh4.label27.setText("TargetPrice: " + body.getString("TargetPrice"));
                            vh4.label28.setText("LastPrice: " + body.getString("LastPrice"));
                            vh4.label29.setText("Recommendation: " + body.getString("Recommendation"));
                            vh4.label30.setText("Url: " + body.getString("Url"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                    default :
                        break;



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
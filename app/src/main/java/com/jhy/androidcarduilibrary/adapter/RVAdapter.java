package com.jhy.androidcarduilibrary.adapter;

import android.annotation.SuppressLint;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jhy.androidcarduilibrary.R;
import com.jhy.androidcarduilibrary.database.FlagingRDTS;
import com.jhy.androidcarduilibrary.database.model.Card;
import com.jhy.androidcarduilibrary.database.model.Item;
import com.jhy.uselesslibrary.adapter.CardAdapter;
import com.jhy.uselesslibrary.toolbox.SwipeDismissRecyclerViewTouchListener;
import com.jhy.uselesslibrary.viewholder.CardViewHolder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RVAdapter extends CardAdapter<CardViewHolder> {

    private final int BULLETIN = 0, OPPORTUNITYMAP = 1, TRANSACTION = 2;
    private final int RESEARCHREPORT = 3, QUICKBITES = 4, CORPACTION = 5;
    private final int INDEX = 6, LEADERVOTE = 7;
    private Context context;
    private RecyclerView recyclerView;

    private static List<Card> cards;
    private static List<Item> itms;

    public RVAdapter(List<Card> cards) {
        this.cards = cards;
    }

    public RVAdapter(List<Item> items, RecyclerView recyclerView) {
        this.itms = items;
        this.recyclerView = recyclerView;
    }

    public RVAdapter(List<Card> cards, Context context, RecyclerView recyclerView) {
        this.cards = cards;
        this.context = context;
        this.recyclerView = recyclerView;
        setRecyclerView(recyclerView);
    }

    public class ViewHolder extends CardViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

    }

    public class ViewHolder1 extends CardViewHolder {

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

    public class ViewHolder2 extends CardViewHolder {

        private TextView label1, label2, label3, label4;

        public ViewHolder2(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.text1);
            label2 = (TextView) v.findViewById(R.id.text2);
            label3 = (TextView) v.findViewById(R.id.text3);
            label4 = (TextView) v.findViewById(R.id.text4);
        }
    }

    public class ViewHolder3 extends CardViewHolder {

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

    public class ViewHolder4 extends CardViewHolder {

        private LinearLayout card4innerContainer, card4;
        private TextView card4label;
        private Button viewmore;

        public ViewHolder4(View v) {
            super(v);
            card4 = (LinearLayout) v.findViewById(R.id.card4);
            card4innerContainer = (LinearLayout) card4.findViewById(R.id.innerCardContainer);
            card4label = (TextView) card4.findViewById(R.id.text1);
            viewmore = (Button) card4.findViewById(R.id.button1);
        }
    }

    public class ViewHolder5 extends CardViewHolder {

        private LinearLayout card5innerContainer, card5;
        private TextView card5label;
        private Button viewmore;

        public ViewHolder5(View v) {
            super(v);
            card5 = (LinearLayout) v.findViewById(R.id.card5);
            card5innerContainer = (LinearLayout) card5.findViewById(R.id.innerCardContainer);
            card5label = (TextView) card5.findViewById(R.id.text1);
            viewmore = (Button) card5.findViewById(R.id.button1);
        }
    }

    public class ViewHolder6 extends CardViewHolder {

        private LinearLayout card6innerContainer, card6;
        private TextView card6label;
        private Button viewmore;

        public ViewHolder6(View v) {
            super(v);
            card6 = (LinearLayout) v.findViewById(R.id.card6);
            card6innerContainer = (LinearLayout) card6.findViewById(R.id.innerCardContainer);
            card6label = (TextView) card6.findViewById(R.id.text1);
            viewmore = (Button) card6.findViewById(R.id.button1);
        }
    }

    public class ViewHolder7 extends CardViewHolder {

        private LinearLayout card7innerContainer, card7;
        private TextView card7label;
        private Button viewmore;

        public ViewHolder7(View v) {
            super(v);
            card7 = (LinearLayout) v.findViewById(R.id.card7);
            card7innerContainer = (LinearLayout) card7.findViewById(R.id.innerCardContainer);
            card7label = (TextView) card7.findViewById(R.id.text1);
            viewmore = (Button) card7.findViewById(R.id.button1);
        }
    }

    public class ViewHolder8 extends CardViewHolder {

        private TextView label1, label2, label3, label4;

        public ViewHolder8(View v) {
            super(v);
            label1 = (TextView) v.findViewById(R.id.text1);
            label2 = (TextView) v.findViewById(R.id.text2);
            label3 = (TextView) v.findViewById(R.id.text3);
            label4 = (TextView) v.findViewById(R.id.text4);
        }
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public int getItemViewType(int position) {

        List<String> itemViewTypes = new ArrayList<String>(Arrays.asList("BULLETIN","OPPORTUNITYMAP", "TRANSACTION", "RESEARCHREPORT",
                                     "QUICKBITES", "CORPACTION", "INDEX", "LEADERVOTE" ));
           String type = cards.get(position).getType();

        for (int i = 0 ; i < itemViewTypes.size() ; i++) {
            if (type.equalsIgnoreCase(itemViewTypes.get(i)))
                return i;
        }

        return -1;

        /*if (cards.get(position).getType().equals("BULLETIN")) {
            return 0;
        } else if (cards.get(position).getType().equals("OPPORTUNITYMAP")) {
            return 1;
        } else if (cards.get(position).getType().equals("TRANSACTION")) {
            return 2;
        } else if (cards.get(position).getType().equals("RESEARCHREPORT")) {
            return 3;
        } else if (cards.get(position).getType().equals("QUICKBITES")) {
            return 4;
        } else if (cards.get(position).getType().equals("CORPACTION")) {
            return 5;
        } else if (cards.get(position).getType().equals("INDEX")) {
            return 6;
        } else if (cards.get(position).getType().equals("LEADERVOTE")) {
            return 7;
        }
        return -1;*/
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, final int viewType) {
        CardViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
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
                View v4 = inflater.inflate(R.layout.maincard_item_4, viewGroup, false);
                viewHolder = new ViewHolder4(v4);
                break;
            case QUICKBITES:
                View v5 = inflater.inflate(R.layout.maincard_item_5, viewGroup, false);
                viewHolder = new ViewHolder5(v5);
                break;
            case CORPACTION:
                View v6 = inflater.inflate(R.layout.maincard_item_6, viewGroup, false);
                viewHolder = new ViewHolder6(v6);
                break;
            case INDEX:
                View v7 = inflater.inflate(R.layout.maincard_item_7, viewGroup, false);
                viewHolder = new ViewHolder7(v7);
                break;
            case LEADERVOTE:
                View v8 = inflater.inflate(R.layout.item8, viewGroup, false);
                viewHolder = new ViewHolder8(v8);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case BULLETIN:
                ViewHolder1 vh1 = (ViewHolder1) holder;
                configureViewHolder1(vh1, position);
                break;
            case OPPORTUNITYMAP:
                ViewHolder2 vh2 = (ViewHolder2) holder;
                configureViewHolder2(vh2, position);
                break;
            case TRANSACTION:
                ViewHolder3 vh3 = (ViewHolder3) holder;
                configureViewHolder3(vh3, position);
                break;
            case RESEARCHREPORT:
                ViewHolder4 vh4 = (ViewHolder4) holder;
                configureViewHolder4(vh4, position);
                break;
            case QUICKBITES:
                ViewHolder5 vh5 = (ViewHolder5) holder;
                configureViewHolder5(vh5, position);
                break;
            case CORPACTION:
                ViewHolder6 vh6 = (ViewHolder6) holder;
                configureViewHolder6(vh6, position);
                break;
            case INDEX:
                ViewHolder7 vh7 = (ViewHolder7) holder;
                configureViewHolder7(vh7, position);
                break;
            case LEADERVOTE:
                ViewHolder8 vh8 = (ViewHolder8) holder;
                configureViewHolder8(vh8, position);
                break;
        }
    }

    /**
     * Click listener for items in list card.
     */
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // TODO: Item click listener logic here.
            Log.d("", "Clicked here.");
            Toast.makeText(context, "Clicked on inner item.", Toast.LENGTH_SHORT).show();
        }
    };

    @SuppressLint("SetTextI18n")
    private void configureViewHolder1(ViewHolder1 vh1, int position) {
        List<Item> itms = cards.get(position).items;

        if (!itms.isEmpty()) {
            for (int i = 0; i < itms.size(); i++) {
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
            for (int i = 0; i < itms.size(); i++) {
                try {
                    JSONObject body = new JSONObject(itms.get(i).getBd());
                    vh3.label1.setText("AccountId: " + body.getString("AccountId"));
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
        if (vh4.card4.getChildCount() > 4) {
            return;
        }

        List<Item> itms = cards.get(position).items;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        vh4.card4label.setText("research report");

        for (int i = 0; i < itms.size(); i++) {
            if (vh4.card4innerContainer.getChildCount() > 2) {
                vh4.viewmore.setVisibility(View.VISIBLE);
                vh4.viewmore.setText("View More");
                return;
            } else {
                View x = inflater.inflate(R.layout.item4, vh4.card4innerContainer, false);
                boolean swipeable ;
                if (itms.get(i).getRmb().equalsIgnoreCase("false")) {
                    swipeable = false;
                } else { swipeable = true; }
                x.setOnTouchListener(getItemTouchListener(swipeable ,x, i, position));
                x.setOnClickListener(onItemClickListener);

                TextView label1 = (TextView) x.findViewById(R.id.text1);
                TextView label2 = (TextView) x.findViewById(R.id.text2);
                TextView label3 = (TextView) x.findViewById(R.id.text3);
                TextView label4 = (TextView) x.findViewById(R.id.text4);
                TextView label5 = (TextView) x.findViewById(R.id.text5);
                TextView label6 = (TextView) x.findViewById(R.id.text6);
                TextView label7 = (TextView) x.findViewById(R.id.text7);
                TextView label8 = (TextView) x.findViewById(R.id.text8);
                TextView label9 = (TextView) x.findViewById(R.id.text9);
                TextView label10 = (TextView) x.findViewById(R.id.text10);

                try {
                    JSONObject body = new JSONObject(itms.get(i).getBd());

                    label1.setText("SeriesId: " + body.getString("SeriesId"));
                    label2.setText("SeriesCode: " + body.getString("SeriesCode"));
                    label3.setText("ShortName: " + body.getString("ShortName"));
                    label4.setText("SeriesName: " + body.getString("SeriesName"));
                    label5.setText("ResearchTitle: " + body.getString("ResearchTitle"));
                    label6.setText("ResearchHouse: " + body.getString("ResearchHouse"));
                    label7.setText("TargetPrice: " + body.getString("TargetPrice"));
                    label8.setText("LastPrice: " + body.getString("LastPrice"));
                    label9.setText("Recommendation: " + body.getString("Recommendation"));
                    label10.setText("Url: " + body.getString("Url"));

                    vh4.card4innerContainer.addView(x);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void configureViewHolder5(ViewHolder5 vh5, int position) {
        if (vh5.card5.getChildCount() > 4) {
            return;
        }

        List<Item> itms = cards.get(position).items;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        vh5.card5label.setText("QuickBites");
        for (int i = 0; i < itms.size(); i++) {

            if (vh5.card5innerContainer.getChildCount() > 2) {
                vh5.viewmore.setVisibility(View.VISIBLE);
                vh5.viewmore.setText("View More");
                return;
            } else {
                View x = inflater.inflate(R.layout.item5, vh5.card5innerContainer, false);
                boolean swipeable ;
                if (itms.get(i).getRmb().equalsIgnoreCase("false")) {
                    swipeable = false;
                } else { swipeable = true; }
                x.setOnTouchListener(getItemTouchListener(swipeable ,x, i, position));
                x.setOnClickListener(onItemClickListener);

                TextView label1 = (TextView) x.findViewById(R.id.text1);
                TextView label2 = (TextView) x.findViewById(R.id.text2);
                TextView label3 = (TextView) x.findViewById(R.id.text3);
                TextView label4 = (TextView) x.findViewById(R.id.text4);
                TextView label5 = (TextView) x.findViewById(R.id.text5);
                TextView label6 = (TextView) x.findViewById(R.id.text6);
                TextView label7 = (TextView) x.findViewById(R.id.text7);
                TextView label8 = (TextView) x.findViewById(R.id.text8);
                TextView label9 = (TextView) x.findViewById(R.id.text9);
                TextView label10 = (TextView) x.findViewById(R.id.text10);
                TextView label11 = (TextView) x.findViewById(R.id.text11);

                try {
                    JSONObject body = new JSONObject(itms.get(i).getBd());

                    label1.setText("Title: " + body.getString("Title"));
                    label2.setText("PublishTS: " + body.getString("PublishTS"));
                    label3.setText("Snippet: " + body.getString("Snippet"));
                    label4.setText("NewsId: " + body.getString("NewsId"));
                    label5.setText("SourceUrl: " + body.getString("SourceUrl"));
                    label6.setText("ImageId: " + body.getString("ImageId"));
                    label7.setText("ShowContent: " + body.getString("ShowContent"));
                    label8.setText("SeriesId: " + body.getString("SeriesId"));
                    label9.setText("SeriesCode: " + body.getString("SeriesCode"));
                    label10.setText("ShortName: " + body.getString("ShortName"));
                    label11.setText("SeriesName: " + body.getString("SeriesName"));

                    vh5.card5innerContainer.addView(x);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void configureViewHolder6(ViewHolder6 vh6, int position) {
        if (vh6.card6.getChildCount() > 4) {
            return;
        }

        List<Item> itms = cards.get(position).items;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        vh6.card6label.setText("CORPACTION");
        for (int i = 0; i < itms.size(); i++) {

            if (vh6.card6innerContainer.getChildCount() > 2) {
                vh6.viewmore.setVisibility(View.VISIBLE);
                vh6.viewmore.setText("View More");
                return;
            } else {
                View x = inflater.inflate(R.layout.item6, vh6.card6innerContainer, false);
                boolean swipeable ;
                if (itms.get(i).getRmb().equalsIgnoreCase("false")) {
                    swipeable = false;
                } else { swipeable = true; }
                x.setOnTouchListener(getItemTouchListener(swipeable ,x, i, position));
                x.setOnClickListener(onItemClickListener);

                TextView label1 = (TextView) x.findViewById(R.id.text1);
                TextView label2 = (TextView) x.findViewById(R.id.text2);
                TextView label3 = (TextView) x.findViewById(R.id.text3);
                TextView label4 = (TextView) x.findViewById(R.id.text4);
                TextView label5 = (TextView) x.findViewById(R.id.text5);
                TextView label6 = (TextView) x.findViewById(R.id.text6);
                TextView label7 = (TextView) x.findViewById(R.id.text7);
                TextView label8 = (TextView) x.findViewById(R.id.text8);
                TextView label9 = (TextView) x.findViewById(R.id.text9);
                TextView label10 = (TextView) x.findViewById(R.id.text10);

                try {
                    JSONObject body = new JSONObject(itms.get(i).getBd());

                    label1.setText("Type: " + body.getString("Type"));
                    label2.setText("SeriesId: " + body.getString("SeriesId"));
                    label3.setText("SeriesCode: " + body.getString("SeriesCode"));
                    label4.setText("ShortName: " + body.getString("ShortName"));
                    label5.setText("SeriesName: " + body.getString("SeriesName"));
                    label6.setText("Title: " + body.getString("Title"));
                    label7.setText("Desc: " + body.getString("Desc"));
                    label8.setText("ExDate: " + body.getString("ExDate"));
                    label9.setText("EntitlementDate: " + body.getString("EntitlementDate"));
                    label10.setText("Url: " + body.getString("Url"));

                    vh6.card6innerContainer.addView(x);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void configureViewHolder7(ViewHolder7 vh7, int position) {
        if (vh7.card7.getChildCount() > 4) {
            return;
        }

        List<Item> itms = cards.get(position).items;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        vh7.card7label.setText("Index");
        for (int i = 0; i < itms.size(); i++) {

            if (vh7.card7innerContainer.getChildCount() > 2) {
                vh7.viewmore.setVisibility(View.VISIBLE);
                vh7.viewmore.setText("View More");
                return;
            } else {
                View x = inflater.inflate(R.layout.item7, vh7.card7innerContainer, false);
                boolean swipeable ;
                if (itms.get(i).getRmb().equalsIgnoreCase("false")) {
                    swipeable = false;
                } else { swipeable = true; }
                x.setOnTouchListener(getItemTouchListener(swipeable ,x, i, position));
                x.setOnClickListener(onItemClickListener);

                TextView label1 = (TextView) x.findViewById(R.id.text1);
                TextView label2 = (TextView) x.findViewById(R.id.text2);
                TextView label3 = (TextView) x.findViewById(R.id.text3);
                TextView label4 = (TextView) x.findViewById(R.id.text4);
                TextView label5 = (TextView) x.findViewById(R.id.text5);
                TextView label6 = (TextView) x.findViewById(R.id.text6);
                TextView label7 = (TextView) x.findViewById(R.id.text7);
                TextView label8 = (TextView) x.findViewById(R.id.text8);
                TextView label9 = (TextView) x.findViewById(R.id.text9);
                TextView label10 = (TextView) x.findViewById(R.id.text10);

                try {
                    JSONObject body = new JSONObject(itms.get(i).getBd());

                    label1.setText("SeriesId: " + body.getString("SeriesId"));
                    label2.setText("SeriesCode: " + body.getString("SeriesCode"));
                    label3.setText("SeriesType: " + body.getString("SeriesType"));
                    label4.setText("ShortName: " + body.getString("ShortName"));
                    label5.setText("LastClose: " + body.getString("LastClose"));
                    label6.setText("ChangePrice: " + body.getString("ChangePrice"));
                    label7.setText("ChangePtg: " + body.getString("ChangePtg"));
                    label8.setText("LastDate: " + body.getString("LastDate"));
                    label9.setText("PrevDate: " + body.getString("PrevDate"));
                    label10.setText("UpdateTS: " + body.getString("UpdateTS"));

                    vh7.card7innerContainer.addView(x);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void configureViewHolder8(ViewHolder8 vh8, int position) {
        List<Item> itms = cards.get(position).items;
        if (!itms.isEmpty()) {
            for (int i = 0; i < itms.size(); i++) {
                try {
                    JSONObject body = new JSONObject(itms.get(i).getBd());
                    vh8.label1.setText("CIFId: " + body.getString("CIFId"));
                    vh8.label2.setText("ImageId: " + body.getString("ImageId"));
                    vh8.label3.setText("Pseudonym: " + body.getString("Pseudonym"));
                    vh8.label4.setText("Voted: " + body.getString("Voted"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void update(List<Card> newCards) {
        notifyItemRangeInserted(cards.size(), cards.size() + newCards.size());
        cards.addAll(newCards);
    }

    public void deleteAll() {
        notifyItemRangeRemoved(0, cards.size());
        cards.clear();
    }

    @Override
    public void onCardRemove(final int position, final View cardView, RecyclerView recyclerView) {

        super.onCardRemove(position, cardView, recyclerView);
        final Card cItem = cards.get(position);
////        final FlagingRDTS rdts = new FlagingRDTS();
//
//        final ViewGroup parent = ((ViewGroup) cardView.getParent());
//        parent.removeView(cardView);
//
        cards.remove(cItem); // << statement that remove card
//
////        for (Item item : cItem.items) {
////            rdts.updateRDTS(item);
////        }
//
//        //notifyDataSetChanged();
//
        Snackbar snackbar = Snackbar
                .make(recyclerView, "Archieved", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cards.add(position, cItem);
//                        for (Item item : cItem.items) {
//                            rdts.resetRDTS(item);
//                        }

                        //parent.addView(cardView, position);

                        notifyDataSetChanged();
                    }
                });
        snackbar.show();
    }

    @Override   //method overrided to make data manipulation
    public void onItemRemove(final View itemView,final int pos, final int cardPos) {
        final ViewGroup parent = (ViewGroup) itemView.getParent();

        parent.removeView(itemView);

        //override with data logic
        final Item item = cards.get(cardPos).items.get(pos);
        FlagingRDTS.updateRDTS(item);
        cards.get(cardPos).items.remove(item);

        Snackbar snackbar = Snackbar
                .make(recyclerView, "Archieved", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        parent.addView(itemView,pos);

                        //override with data logic
                        FlagingRDTS.resetRDTS(item);
                        cards.get(cardPos).items.add(pos, item);
                    }
                });
        snackbar.show();
    }
}
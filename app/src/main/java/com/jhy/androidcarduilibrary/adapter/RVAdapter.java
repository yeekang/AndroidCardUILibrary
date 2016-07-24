package com.jhy.androidcarduilibrary.adapter;

import android.annotation.SuppressLint;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jhy.androidcarduilibrary.R;
import com.jhy.androidcarduilibrary.database.FlagingRDTS;
import com.jhy.androidcarduilibrary.database.model.Card;
import com.jhy.androidcarduilibrary.database.model.Item;
import com.jhy.androidcarduilibrary.toolbox.SwipeDismissRecyclerViewItemTouchListener;
import com.jhy.androidcarduilibrary.view.ScreenA;
import com.jhy.androidcarduilibrary.view.ScreenB;
import com.jhy.androidcarduilibrary.viewholder.CardViewHolder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

//public class RVAdapter extends CardAdapter<RVAdapter.ViewHolder extends CardViewHolder> {
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

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


    public RVAdapter(List<Item>items, RecyclerView recyclerView){
        this.itms = items;
        this.recyclerView = recyclerView;
    }

    public RVAdapter(List<Card> cards, Context context, RecyclerView recyclerView) {
        this.cards = cards;
        this.context = context;
        this.recyclerView = recyclerView;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
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

        private LinearLayout ll4;
        private TextView label1;

        public ViewHolder4(View v) {
            super(v);
            ll4 = (LinearLayout) v.findViewById(R.id.card4);
            label1 = (TextView) ll4.findViewById(R.id.text1);
        }
    }

    public class ViewHolder5 extends RVAdapter.ViewHolder {

        private LinearLayout ll5;
        private TextView label1;

        public ViewHolder5(View v) {
            super(v);
            ll5 = (LinearLayout) v.findViewById(R.id.card5);
            label1 = (TextView) ll5.findViewById(R.id.text1);
        }
    }

    public class ViewHolder6 extends RVAdapter.ViewHolder {

        private LinearLayout ll6;
        private TextView label1;

        public ViewHolder6(View v) {
            super(v);
            ll6 = (LinearLayout) v.findViewById(R.id.card6);
            label1 = (TextView) ll6.findViewById(R.id.text1);
        }
    }

    public class ViewHolder7 extends RVAdapter.ViewHolder {

        private LinearLayout ll7;
        private TextView label1;

        public ViewHolder7(View v) {
            super(v);
            ll7 = (LinearLayout) v.findViewById(R.id.card7);
            label1 = (TextView) ll7.findViewById(R.id.text1);
        }
    }

    public class ViewHolder8 extends RVAdapter.ViewHolder {

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
//        String type = cards.get(position).getType();
//
//        for (int i = 0 ; i < itemViewTypes.size() ; i++) {
//            if (type.equalsIgnoreCase(itemViewTypes.get(i)))
//                return i;
//        }
//
//        return -1;

        if (cards.get(position).getType().equals("BULLETIN")) {
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
        }else if (cards.get(position).getType().equals("LEADERVOTE")) {
            return 7;
        }
        return -1;
    }

    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int viewType) {
        RVAdapter.ViewHolder viewHolder = null;
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
            case QUICKBITES:
                ViewHolder5 vh5 = (ViewHolder5) viewHolder;
                configureViewHolder5(vh5, position);
                break;
            case CORPACTION:
                ViewHolder6 vh6 = (ViewHolder6) viewHolder;
                configureViewHolder6(vh6, position);
                break;
            case INDEX:
                ViewHolder7 vh7 = (ViewHolder7) viewHolder;
                configureViewHolder7(vh7, position);
                break;
            case LEADERVOTE:
                ViewHolder8 vh8 = (ViewHolder8) viewHolder;
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

    /**
     * Swipe touch listener for items in list card.
     * @param view View of item.
     * @param pos Pos of item in list.
     * @return Touch listener.
     */
    private SwipeDismissRecyclerViewItemTouchListener getItemTouchListener(View view, final int pos) {
        return new SwipeDismissRecyclerViewItemTouchListener(
                recyclerView,
                view,
                pos,
                new SwipeDismissRecyclerViewItemTouchListener.DismissCallbacks() {
                    @Override
                    public boolean canDismiss(Object token) {
                        // TODO: Allow item to be dismissed or not.

                        System.out.println("SwipeDismissRecyclerViewItemTouchListener canDismiss clicked");
                        return true;
                    }

                    @Override
                    public void onDismiss(View view, Object token) {
                        // TODO: Dismiss logic here.

                        System.out.println("SwipeDismissRecyclerViewItemTouchListener onDismiss clicked");
                        //Able to swipe away the item
                        ((ViewManager)view.getParent()).removeView(view);

                        /*
                        Snackbar snackbar = Snackbar.make(view, "test", Snackbar.LENGTH_LONG)
                                .setAction("UNDO", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        System.out.println("undo click");
                                        ((ViewManager)view.getParent()).removeView(view);
                                        ((ViewManager)view.getParent()).addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT) );
                                    }
                                });
                        snackbar.show();*/

                    }
                }
        );
    }

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
        if (vh4.ll4.getChildCount() > 4) {
            return;
        }

        List<Item> itms = cards.get(position).items;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        vh4.label1.setText("research report");

        for (int i = 0; i < itms.size(); i++) {
            if (vh4.ll4.getChildCount() > 3) {
                Button b = new Button(context);
                b.setText("View More");
                b.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT));
                // b.setId(MY_BUTTON);
                //b.setOnClickListener();
                vh4.ll4.addView(b);
                return;
            } else {
                View x = inflater.inflate(R.layout.item4, vh4.ll4, false);

                x.setOnTouchListener(getItemTouchListener(x, i));
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

                    vh4.ll4.addView(x);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void configureViewHolder5(ViewHolder5 vh5, int position) {
        if(vh5.ll5.getChildCount() > 4) {
            return;
        }

        List<Item> itms = cards.get(position).items;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        vh5.label1.setText("QuickBites");
            for (int i = 0; i < itms.size(); i++) {

                if(vh5.ll5.getChildCount() > 3) {
                    Button b = new Button(context);
                    b.setText("View More");
                    b.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT));
                    // b.setId(MY_BUTTON);
                    //b.setOnClickListener();
                    vh5.ll5.addView(b);
                    return;
                } else {
                    View x = inflater.inflate(R.layout.item5, vh5.ll5, false);

                    x.setOnTouchListener(getItemTouchListener(x, i));
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

                        vh5.ll5.addView(x);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
    }

    @SuppressLint("SetTextI18n")
    private void configureViewHolder6(ViewHolder6 vh6, int position) {
        if (vh6.ll6.getChildCount() > 4) {
            return;
        }

        List<Item> itms = cards.get(position).items;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        vh6.label1.setText("QuickBites");
        for (int i = 0; i < itms.size(); i++) {

            if (vh6.ll6.getChildCount() > 3) {
                Button b = new Button(context);
                b.setText("View More");
                b.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT));
                // b.setId(MY_BUTTON);
                //b.setOnClickListener();
                vh6.ll6.addView(b);
                return;
            } else {
                View x = inflater.inflate(R.layout.item6, vh6.ll6, false);

                x.setOnTouchListener(getItemTouchListener(x, i));
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

                    vh6.ll6.addView(x);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void configureViewHolder7(ViewHolder7 vh7, int position) {
        if (vh7.ll7.getChildCount() > 4) {
            return;
        }

        List<Item> itms = cards.get(position).items;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        vh7.label1.setText("QuickBites");
        for (int i = 0; i < itms.size(); i++) {

            if (vh7.ll7.getChildCount() > 3) {
                Button b = new Button(context);
                b.setText("View More");
                b.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT));
                // b.setId(MY_BUTTON);
                //b.setOnClickListener();
                vh7.ll7.addView(b);
                return;
            } else {
                View x = inflater.inflate(R.layout.item7, vh7.ll7, false);

                x.setOnTouchListener(getItemTouchListener(x, i));
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

                    vh7.ll7.addView(x);

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

    public void onItemRemove(final int position, View cardView, RecyclerView recyclerView) {
        //int adapterPosition = viewHolder.getLayoutPosition();

        final Card cItem = cards.get(position);
        
        Snackbar snackbar = Snackbar
                .make(recyclerView, "Archieved", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        //int mAdapterPosition = viewHolder.getLayoutPosition();

                        //rv.addView(viewHolder.itemView);
                        cards.add(position, cItem);
                        //notifyItemInserted(mAdapterPosition);
                        //rv.scrollToPosition(mAdapterPosition);
                        //new FlagingRDTS().resetRDTS(cItem.items.get(0));//need to make change for multi list do not use get(0)
                        notifyDataSetChanged();
                    }
                });
        snackbar.show();

        cards.remove(cItem);

        notifyDataSetChanged();

        //rv.removeView(viewHolder.itemView);
      //rv.removeViewAt(adapterPosition);
        //this.notifyItemRemoved(adapterPosition);

        //new FlagingRDTS().saveRDTS(cItem.items.get(0));//need to make change for multi list
    }

    public void update(List<Card> newCards) {
        notifyItemRangeInserted(cards.size(), cards.size() + newCards.size());
        cards.addAll(newCards);
    }

    public void deleteAll() {
        notifyItemRangeRemoved(0, cards.size());
        cards.clear();
    }

}
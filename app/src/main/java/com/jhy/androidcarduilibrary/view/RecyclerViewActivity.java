package com.jhy.androidcarduilibrary.view;

/**
 * Created by jhyha on 30-Jun-16.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.jhy.androidcarduilibrary.Idol;
import com.jhy.androidcarduilibrary.R;
import com.jhy.androidcarduilibrary.adapter.RVAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Idol> Idols;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycler_view);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        Idols = new ArrayList<>();
        Idols.add(new Idol("Alaina", "23 years old", R.mipmap.p1));
        Idols.add(new Idol("AngelaBaby", "25 years old", R.mipmap.p2));
        Idols.add(new Idol("Alexandra", "27 years old", R.mipmap.p3));
        Idols.add(new Idol("Ann Marie", "24 years old", R.mipmap.p4));
        Idols.add(new Idol("Christina", "22 years old", R.mipmap.p5));
        Idols.add(new Idol("Diana", "23 years old", R.mipmap.p6));
        Idols.add(new Idol("Gina", "25 years old", R.mipmap.p7));
        Idols.add(new Idol("Joanne", "26 years old", R.mipmap.p8));
        Idols.add(new Idol("Julia", "28 years old", R.mipmap.p9));
        Idols.add(new Idol("Karen", "21 years old", R.mipmap.p10));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(Idols);
        rv.setAdapter(adapter);
    }
}

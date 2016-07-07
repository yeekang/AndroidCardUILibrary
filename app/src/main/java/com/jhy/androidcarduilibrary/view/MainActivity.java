package com.jhy.androidcarduilibrary.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jhy.androidcarduilibrary.database.CardDB;
import com.jhy.androidcarduilibrary.network.Connection;
import com.jhy.androidcarduilibrary.R;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlowManager.init(new FlowConfig.Builder(this).openDatabasesOnInit(true).build());
        FlowManager.getDatabase(CardDB.class).getWritableDatabase();

        new Connection().getJSON(this);
    }
}

package com.jhy.androidcarduilibrary.view;

/**
 * Created by jhyha on 30-Jun-16.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.jhy.androidcarduilibrary.R;

public class CardViewActivity extends AppCompatActivity {

    TextView idolName;
    TextView idolAge;
    ImageView idolPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.card_view);
        idolName = (TextView)findViewById(R.id.idol_name);
        idolAge = (TextView)findViewById(R.id.idol_age);
        idolPhoto = (ImageView)findViewById(R.id.idol_photo);


    }
}

package com.jhy.androidcarduilibrary;

/**
 * Created by jhyha on 30-Jun-16.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

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

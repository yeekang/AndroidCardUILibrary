package com.jhy.uselesslibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jhyha on 14-Jul-16.
 */
public class TestThis extends LinearLayout {

    public TestThis(Context context) {
        super(context);
        TextView text1, text2, text3, text4;

        inflate(context, R.layout.some, this);
        text1 = (TextView) findViewById(R.id.item8);
        text2 = (TextView) findViewById(R.id.item9);
        text3 = (TextView) findViewById(R.id.item10);
        text4 = (TextView) findViewById(R.id.item11);
        text1.setText("this");
        text2.setText("is");
        text3.setText("from");
        text4.setText("library");
    }

    public TestThis(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}

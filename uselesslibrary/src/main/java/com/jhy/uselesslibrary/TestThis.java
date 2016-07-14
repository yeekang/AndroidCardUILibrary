package com.jhy.uselesslibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by jhyha on 14-Jul-16.
 */
public class TestThis extends LinearLayout {

    public TestThis(Context context) {
        super(context);
        inflate(context, R.layout.some, this);
    }

    public TestThis(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}

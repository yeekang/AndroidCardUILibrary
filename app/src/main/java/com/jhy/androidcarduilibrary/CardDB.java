package com.jhy.androidcarduilibrary;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by jhyha on 29-Jun-16.
 */
@Database(name = CardDB.NAME, version = CardDB.VERSION)
public class CardDB {
    public static final String NAME = "CardDB";

    public static final int VERSION = 1;
}

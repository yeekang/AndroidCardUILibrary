package com.jhy.androidcarduilibrary.database;

import com.jhy.androidcarduilibrary.database.model.Item;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by jhyha on 08-Jul-16.
 */
public class SaveRDTS {

    //on swipe will call this, any parameter ?
    public void saveRDTS(Item item) { // pass in Item
        Date currentTS = new Date();

        item.setRdts(currentTS.toString());
        item.save();
        //need to push back to server
    }
}

package com.jhy.androidcarduilibrary.database;

import com.jhy.androidcarduilibrary.database.model.Item;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by jhyha on 08-Jul-16.
 */
public class FlagingRDTS {

    //on swipe will call this, any parameter ?
    public void updateRDTS(Item item) { // pass in Item if can
        Date currentTS = new Date();

        item.setRdts(currentTS.toString());
        item.update();
        //need to push back to server ?
    }


    //when undo is pressed
    public void resetRDTS(Item item) {
        item.setRdts("");
        item.update();
    }
}

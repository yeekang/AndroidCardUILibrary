package com.jhy.androidcarduilibrary;

import com.android.volley.toolbox.StringRequest;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by jhyha on 29-Jun-16.
 */
@Table(database = CardDB.class)
public class Card extends BaseModel{

    @Column
    @PrimaryKey
    String type; //will make enum

    @Column
    String subtype;

    @Column
    String itm; // will make into class

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getItm() {
        return itm;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public void setItm(String itm) {
        this.itm = itm;
    }
}

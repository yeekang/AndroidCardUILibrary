package com.jhy.androidcarduilibrary.database.model;

import com.jhy.androidcarduilibrary.database.CardDB;
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

class Item extends BaseModel{

    @Column
    @PrimaryKey
    String cdid;

    @Column
    String imgid;

    @Column
    String bd;

    @Column
    String rmb;

    @Column
    String crts;

    @Column
    String rdts;

    public String getRdts() {
        return rdts;
    }

    public String getCrts() {
        return crts;
    }

    public String getRmb() {
        return rmb;
    }

    public String getBd() {
        return bd;
    }

    public String getCdid() {
        return cdid;
    }

    public String getImgid() {
        return imgid;
    }

    public void setRdts(String rdts) {
        this.rdts = rdts;
    }

    public void setCrts(String crts) {
        this.crts = crts;
    }

    public void setRmb(String rmb) {
        this.rmb = rmb;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid;
    }

    public void setCdid(String cdid) {
        this.cdid = cdid;
    }

}


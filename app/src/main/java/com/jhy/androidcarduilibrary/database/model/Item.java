package com.jhy.androidcarduilibrary.database.model;

import com.jhy.androidcarduilibrary.database.CardDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by jhyha on 07-Jul-16.
 */
@ModelContainer
@Table(database = CardDB.class)
public class Item extends BaseModel {

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

    public String getRdts() {return rdts;}
    public String getCrts() {return crts;}
    public String getRmb() {return rmb;}
    public String getBd() {return bd;}
    public String getCdid() {return cdid;}
    public String getImgid() {return imgid;}

    public void setRdts(String rdts) {this.rdts = rdts;}
    public void setCrts(String crts) {this.crts = crts;}
    public void setRmb(String rmb) {this.rmb = rmb;}
    public void setBd(String bd) {this.bd = bd;}
    public void setImgid(String imgid) {this.imgid = imgid;}
    public void setCdid(String cdid) {this.cdid = cdid;}

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    CardForeignKeyContainer cardForeignKeyContainer;

    public void associateCard(Card card) {
        cardForeignKeyContainer = new CardForeignKeyContainer(FlowManager
        .getContainerAdapter(Card.class).toForeignKeyContainer(card));
    }
}
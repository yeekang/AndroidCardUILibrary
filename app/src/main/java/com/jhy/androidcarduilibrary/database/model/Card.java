package com.jhy.androidcarduilibrary.database.model;

import com.jhy.androidcarduilibrary.database.CardDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by jhyha on 29-Jun-16.
 */
@ModelContainer
@Table(database = CardDB.class)
public class Card extends BaseModel{

    @Column
    @PrimaryKey
    String type; //will make enum

    @Column
    String subtype;

    public List<Item> items;

    public String getType() {return type;}
    public String getSubtype() {return subtype;}

    public void setType(String type) {this.type = type;}
    public void setSubtype(String subtype) {this.subtype = subtype;}

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "items", isVariablePrivate = true)
    public List<Item> getMyItems() {
        if (items == null || items.isEmpty()) {
            items = SQLite.select().from(Item.class)
                    .where(Item_Table.cardForeignKeyContainer_type.eq(type)).queryList();
        }
        return items;
    }

    public void setItems(List<Item> items) {this.items = items;}
}
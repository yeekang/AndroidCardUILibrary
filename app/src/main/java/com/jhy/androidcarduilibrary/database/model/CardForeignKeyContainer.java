package com.jhy.androidcarduilibrary.database.model;

import android.support.annotation.NonNull;

import com.raizlabs.android.dbflow.structure.container.ForeignKeyContainer;
import com.raizlabs.android.dbflow.structure.container.ModelContainer;

import java.util.Map;

/**
 * Created by jhyha on 07-Jul-16.
 */
public class CardForeignKeyContainer extends ForeignKeyContainer<Card>{

    public CardForeignKeyContainer() {
        super(Card.class);
    }

    public CardForeignKeyContainer(Map<String, Object> data) {
        super(Card.class, data);
    }

    public CardForeignKeyContainer(Class<Card> cardClass) {
        super(cardClass);
    }

    public CardForeignKeyContainer(@NonNull ModelContainer<Card, ?> existingContainer) {
        super(existingContainer);
    }
}

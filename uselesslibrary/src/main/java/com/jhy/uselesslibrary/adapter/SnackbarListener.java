package com.jhy.uselesslibrary.adapter;

import android.view.View;

/**
 * Created by jhyha on 03-Aug-16.
 */
public interface SnackbarListener {

    void onSnackbarShow(View v);
    void onSnackbarDismiss(View v);
    void onSnackbarUndo(View v);
    void onSnackbarUndo(View v, Object data, int removedPos);

}

package com.jhy.androidcarduilibrary.toolbox;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Barry on 19/07/2016.
 */
public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private RecyclerViewInterface mListener;

    private static final long DELAY_MILLIS = 100;

    private RecyclerView mRecyclerView;
    private GestureDetector mGestureDetector;
    private boolean mIsPrepressed = false;
    private boolean mIsShowPress = false;
    private View mPressedView = null;

    public RecyclerItemClickListener(RecyclerView recyclerView, RecyclerViewInterface listener) {
        mListener = listener;
        mRecyclerView = recyclerView;
        mGestureDetector = new GestureDetector(recyclerView.getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                mIsPrepressed = true;
                mPressedView = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
                super.onDown(e);
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                if (mIsPrepressed && mPressedView != null) {
                    mPressedView.setPressed(true);
                    mIsShowPress = true;
                }
                super.onShowPress(e);
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                if (mIsPrepressed && mPressedView != null) {
                    mPressedView.setPressed(true);
                    final View pressedView = mPressedView;
                    pressedView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pressedView.setPressed(false);
                        }
                    }, DELAY_MILLIS);
                    mIsPrepressed = false;
                    mPressedView = null;
                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                if (mIsPrepressed && mPressedView != null) {
                    mListener.onItemLongPress(mPressedView, mRecyclerView.getChildPosition(mPressedView));
                }

                super.onLongPress(e);
            }
        });
    }

    private static final int NONE = 0;
    private static final int SWIPE = 1;
    private int mode = NONE;
    private float startY;
    private float stopY;

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, view.getChildPosition(childView));
        } else if (e.getActionMasked() == MotionEvent.ACTION_UP && mPressedView != null && mIsShowPress) {

            mPressedView.setPressed(false);
            mIsShowPress = false;
            mIsPrepressed = false;
            mPressedView = null;
        }

        if (e.getActionMasked() == MotionEvent.ACTION_POINTER_DOWN) {
            mode = SWIPE;
            startY = e.getY(0);
        } else if (e.getActionMasked() == MotionEvent.ACTION_POINTER_UP) {
            mode = NONE;
            if(Math.abs(startY - stopY) > 100)
            {
                if(startY > stopY)
                {
                    // Swipe up
                }
                else
                {
                    //Swipe down
                }
            }
        } else if (e.getActionMasked() == MotionEvent.ACTION_MOVE) {
            if(mode == SWIPE) {
                stopY = e.getY(0);
            }
        }


        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {}

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {}

}


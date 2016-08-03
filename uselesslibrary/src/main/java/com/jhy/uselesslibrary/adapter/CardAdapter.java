package com.jhy.uselesslibrary.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.jhy.uselesslibrary.toolbox.RecyclerItemClickListener;
import com.jhy.uselesslibrary.toolbox.SwipeDismissRecyclerViewItemTouchListener;
import com.jhy.uselesslibrary.toolbox.SwipeDismissRecyclerViewTouchListener;
import com.jhy.uselesslibrary.viewholder.CardViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhyha on 18-Jul-16.
 */
public abstract class CardAdapter<VH extends CardViewHolder> extends RecyclerView.Adapter<VH>
            implements SnackbarListener {

    private RecyclerView recyclerView;
    private List<String> itemViewTypes;

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public int getItemViewType(int position) {
        if (itemViewTypes == null || getDataType(position) == null)
            return -1;

        String type = getDataType(position);

        return itemViewTypes.indexOf(type);

        /*
        String type = cards.get(position).getType();

        for (int i = 0 ; i < itemViewTypes.size() ; i++) {
            if (type.equalsIgnoreCase(itemViewTypes.get(i)))
                return i;
        }
*/
        //return -1;
    }

    public abstract String getDataType(int position);

    public void setItemViewTypes(List<String> itemViewTypes) {
        if (this.itemViewTypes == null)
            this.itemViewTypes = new ArrayList<>();

        this.itemViewTypes.clear();
        this.itemViewTypes.addAll(itemViewTypes);
    }

    /**
     * Swipe touch listener for items in list card.
     *
     * @param swipeAble return true if null
     * @param view    View of item.
     * @param pos     Pos of item in list.
     * @param cardPos Position of card
     * @return Touch listener.
     */
    public SwipeDismissRecyclerViewItemTouchListener getItemTouchListener
    (final boolean swipeAble, View view, final int pos, final int cardPos) {
        return new SwipeDismissRecyclerViewItemTouchListener(
                recyclerView,
                view,
                pos,
                new SwipeDismissRecyclerViewItemTouchListener.DismissCallbacks() {
                    @Override
                    public boolean canDismiss(Object token) {
                        // TODO: Allow item to be dismissed or not.

                        System.out.println("SwipeDismissRecyclerViewItemTouchListener canDismiss clicked");
                        //swipeable decide by user
                        return swipeAble;
                    }

                    @Override
                    public void onDismiss(final View itemView, Object token) {
                        // TODO: Dismiss logic here.

                        System.out.println("SwipeDismissRecyclerViewItemTouchListener onDismiss clicked");

                        //call method that can be edit by user;
                        //Able to swipe away the item
                        final ViewGroup parent = ((ViewGroup) itemView.getParent());

                        parent.removeView(itemView);

                        Snackbar snackbar = Snackbar
                                .make(recyclerView, "11vArchieved", Snackbar.LENGTH_LONG)
                                .setAction("UNDO", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        parent.addView(itemView, pos);
                                        onSnackbarUndo(view);
                                    }
                                });

                        snackbar.getView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                            @Override
                            public void onViewAttachedToWindow(View view) {
                                System.out.println("111 bar showed");
                                onSnackbarShow(view);
                            }

                            @Override
                            public void onViewDetachedFromWindow(View view) {
                                System.out.println("111 bar showed");
                                onSnackbarDismiss(view);
                            }
                        });
                        snackbar.show();

                        onItemRemove(itemView, pos, cardPos);
                    }
                }
        );
    }

    public abstract void onItemRemove(final View itemView, final int pos, final int cardPos);

    /*
    public void onItemRemove(final View itemView, final int pos, final int cardPos) {
        Snackbar snackbar = Snackbar
                .make(recyclerView, "11vArchieved", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        parent.addView(itemView, pos);
                    }
                });

        snackbar.getView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View view) {
                System.out.println("111 bar showed");
                onSnackbarShow(view);
            }

            @Override
            public void onViewDetachedFromWindow(View view) {
                System.out.println("111 bar showed");
                onSnackbarDismiss(view);
            }
        });
        snackbar.show();
    }
    */

    public SwipeDismissRecyclerViewTouchListener getCardTouchListener() {
        return new SwipeDismissRecyclerViewTouchListener(recyclerView,
                new SwipeDismissRecyclerViewTouchListener.DismissCallbacks() {
                    @Override
                    public boolean canDismiss(View view, int position) {
                        return true;
                    }

                    @Override
                    public void onDismiss(RecyclerView recyclerView,
                            final int[] reverseSortedPositions, final View swipedView) {

                        for (final int i : reverseSortedPositions) {
                            final Object removedData = onCardRemove(i, swipedView);
                            notifyDataSetChanged();

                            Snackbar snackbar = Snackbar
                                    .make(recyclerView, "Archieved", Snackbar.LENGTH_LONG)
                                    .setAction("UNDO", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            onSnackbarUndo(view, removedData, i);
                                        }
                                    });

                            snackbar.getView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                                @Override
                                public void onViewAttachedToWindow(View view) {
                                    onSnackbarShow(view);
                                }

                                @Override
                                public void onViewDetachedFromWindow(View view) {
                                    onSnackbarDismiss(view);
                                }
                            });

                            snackbar.show();
                        }
                    }
                });
    }

    public abstract Object onCardRemove(final int position, final View cardView);

}

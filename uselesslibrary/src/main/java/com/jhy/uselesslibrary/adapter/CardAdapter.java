package com.jhy.uselesslibrary.adapter;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.jhy.uselesslibrary.toolbox.SwipeDismissRecyclerViewItemTouchListener;
import com.jhy.uselesslibrary.viewholder.CardViewHolder;

/**
 * Created by jhyha on 18-Jul-16.
 */
public abstract class CardAdapter<VH extends CardViewHolder> extends RecyclerView.Adapter<VH> {

    private RecyclerView recyclerView;

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public int getItemViewType(int position) {
        /*
        String type = cards.get(position).getType();

        for (int i = 0 ; i < itemViewTypes.size() ; i++) {
            if (type.equalsIgnoreCase(itemViewTypes.get(i)))
                return i;
        }
*/
        return -1;
    }

    /**
     * Swipe touch listener for items in list card.
     * @param view View of item.
     * @param pos Pos of item in list.
     * @param cardPos  Position of card
     * @return Touch listener.
     */
    public SwipeDismissRecyclerViewItemTouchListener getItemTouchListener(View view, final int pos, final int cardPos) {
        return new SwipeDismissRecyclerViewItemTouchListener(
                recyclerView,
                view,
                pos,
                new SwipeDismissRecyclerViewItemTouchListener.DismissCallbacks() {
                    @Override
                    public boolean canDismiss(Object token) {
                        // TODO: Allow item to be dismissed or not.

                        System.out.println("SwipeDismissRecyclerViewItemTouchListener canDismiss clicked");
                        return true;
                    }

                    @Override
                    public void onDismiss(final View itemView, Object token) {
                        // TODO: Dismiss logic here.

                        System.out.println("SwipeDismissRecyclerViewItemTouchListener onDismiss clicked");

                        //Able to swipe away the item
                        final ViewGroup parent = ((ViewGroup)itemView.getParent());
//                        final FlagingRDTS rdts = new FlagingRDTS();

                        parent.removeView(itemView);
//                        rdts.updateRDTS(cards.get(cardPos).items.get(pos));

                        Snackbar snackbar = Snackbar
                                .make(recyclerView, "Archieved", Snackbar.LENGTH_LONG)
                                .setAction("UNDO", new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view){
                                        parent.addView(itemView, pos);
//                                        rdts.resetRDTS(cards.get(cardPos).items.get(pos));
                                    }
                                });
                        snackbar.show();
                    }
                }
        );
    }


}

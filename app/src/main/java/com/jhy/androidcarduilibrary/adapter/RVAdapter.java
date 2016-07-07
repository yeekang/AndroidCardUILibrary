package com.jhy.androidcarduilibrary.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
<<<<<<< HEAD:app/src/main/java/com/jhy/androidcarduilibrary/adapter/RVAdapter.java
import com.jhy.androidcarduilibrary.R;
import com.jhy.androidcarduilibrary.view.Idol;
=======

import com.jhy.androidcarduilibrary.Idol;
import com.jhy.androidcarduilibrary.R;

>>>>>>> da50a8dfe2133bc3619b07caaaff3098e56596c7:app/src/main/java/com/jhy/androidcarduilibrary/adapter/RVAdapter.java
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.IdolViewHolder> {

    public static class IdolViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CardView cv;
        TextView idolName;
        TextView idolAge;
        ImageView idolPhoto;


        IdolViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            cv = (CardView)itemView.findViewById(R.id.cv);
            idolName = (TextView)itemView.findViewById(R.id.idol_name);
            idolAge = (TextView)itemView.findViewById(R.id.idol_age);
            idolPhoto = (ImageView)itemView.findViewById(R.id.idol_photo);
        }

        @Override
        public void onClick(View view) {
            Log.d("IdolViewHolder", "onClick --> position = " + getAdapterPosition());
        }
    }

    List<Idol> Idols;

    public RVAdapter(List<Idol> Idols){
        this.Idols = Idols;
    }


    @Override
    public IdolViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = null;
        switch (viewType) {
            case 0:
<<<<<<< HEAD:app/src/main/java/com/jhy/androidcarduilibrary/adapter/RVAdapter.java

                break;
            case 1:

=======
                view = ...;
                break;
            case 1:
                view = ..;
>>>>>>> da50a8dfe2133bc3619b07caaaff3098e56596c7:app/src/main/java/com/jhy/androidcarduilibrary/adapter/RVAdapter.java
                break;
        }

        if (view != null)
<<<<<<< HEAD:app/src/main/java/com/jhy/androidcarduilibrary/adapter/RVAdapter.java
            return new IdolViewHolder(view);
=======
            reutrn new IdolViewHolder(view);
>>>>>>> da50a8dfe2133bc3619b07caaaff3098e56596c7:app/src/main/java/com/jhy/androidcarduilibrary/adapter/RVAdapter.java

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new IdolViewHolder(v);
    }

    @Override
    public void onBindViewHolder(IdolViewHolder idolViewHolder, int position) {
        switch ( getItemViewType(position) ) {
            case 0:
                break;

            case 1:

                break;
        }


<<<<<<< HEAD:app/src/main/java/com/jhy/androidcarduilibrary/adapter/RVAdapter.java
        idolViewHolder.idolName.setText(Idols.get(position).name);
        idolViewHolder.idolAge.setText(Idols.get(position).age);
        idolViewHolder.idolPhoto.setImageResource(Idols.get(position).photoId);
=======
        idolViewHolder.idolName.setText(Idols.get(i).name);
        idolViewHolder.idolAge.setText(Idols.get(i).age);
        idolViewHolder.idolPhoto.setImageResource(Idols.get(i).photoId);
>>>>>>> da50a8dfe2133bc3619b07caaaff3098e56596c7:app/src/main/java/com/jhy/androidcarduilibrary/adapter/RVAdapter.java
    }

    @Override
    public int getItemCount() {
        return Idols.size();
    }

<<<<<<< HEAD:app/src/main/java/com/jhy/androidcarduilibrary/adapter/RVAdapter.java
    /*
=======
>>>>>>> da50a8dfe2133bc3619b07caaaff3098e56596c7:app/src/main/java/com/jhy/androidcarduilibrary/adapter/RVAdapter.java
    @Override
    public int getItemViewType(int position) {
        if (Idols.get(position).type == "TYPE_1")
            return 0;
        else if (Idols.get(position).type == "TYPE_2")
            return 1;
<<<<<<< HEAD:app/src/main/java/com/jhy/androidcarduilibrary/adapter/RVAdapter.java
    }*/
=======
    }
>>>>>>> da50a8dfe2133bc3619b07caaaff3098e56596c7:app/src/main/java/com/jhy/androidcarduilibrary/adapter/RVAdapter.java
}
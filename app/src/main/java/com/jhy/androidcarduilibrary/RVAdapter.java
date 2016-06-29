package com.jhy.androidcarduilibrary;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

    RVAdapter(List<Idol> Idols){
        this.Idols = Idols;
    }


    @Override
    public IdolViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new IdolViewHolder(v);
    }

    @Override
    public void onBindViewHolder(IdolViewHolder idolViewHolder, int i) {
        idolViewHolder.idolName.setText(Idols.get(i).name);
        idolViewHolder.idolAge.setText(Idols.get(i).age);
        idolViewHolder.idolPhoto.setImageResource(Idols.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return Idols.size();
    }
}
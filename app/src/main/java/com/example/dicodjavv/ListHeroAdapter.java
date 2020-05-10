package com.example.dicodjavv;

import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {

    private ArrayList<Hero> listHero;

    public ListHeroAdapter(ArrayList<Hero> list){
        this.listHero = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_hero, viewGroup, false);
       return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Hero hero = listHero.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgphoto);
        holder.tvname.setText(hero.getName());
        holder.tvdetail.setText(hero.getDetail());

    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView imgphoto;
        TextView tvname, tvdetail;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgphoto = itemView.findViewById(R.id.img_item_photo);
            tvname = itemView.findViewById(R.id.tv_item_name);
            tvdetail = itemView.findViewById(R.id.tv_item_detail);

        }
    }
}

package com.example.orangestatus.ui.market;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orangestatus.R;

import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {
    List<items> itemlist;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName1;
        TextView itemName2;
        TextView itemName3;

        public ViewHolder(View view) {
            super(view);
            itemImage = (ImageView) view.findViewById(R.id.item_image);
            itemName1 = (TextView) view.findViewById(R.id.item_name1);
            itemName2 = (TextView) view.findViewById(R.id.item_name2);
            itemName3 = (TextView) view.findViewById(R.id.item_name3);
        }

    }

    public itemAdapter(List<items> Itemlist) {
        itemlist = Itemlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        //将之前写好的list_view封装到一个View中
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        items items = itemlist.get(position);
        holder.itemImage.setImageResource(items.getImageId());
        holder.itemName1.setText(items.getName());
        holder.itemName2.setText(items.getName());
        holder.itemName2.setText(items.getName());
    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

}



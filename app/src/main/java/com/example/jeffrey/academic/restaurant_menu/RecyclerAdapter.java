package com.example.jeffrey.academic.restaurant_menu;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jeffrey.academic.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Item>arrayList;
    public RecyclerAdapter(ArrayList<Item>arrayList){
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.resturant_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(arrayList.get(i).getName());
        viewHolder.price.setText(""+arrayList.get(i).getPrice());
        Glide.with(viewHolder.imageView).load(arrayList.get(i).getImageId())
                        .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private ImageView imageView;
        private TextView price;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            price=itemView.findViewById(R.id.price_of_resturant_item);
            imageView=itemView.findViewById(R.id.image_item_resturant);
            name=itemView.findViewById(R.id.name_of_item_resturant);
        }
    }
}

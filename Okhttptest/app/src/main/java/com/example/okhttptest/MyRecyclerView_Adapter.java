package com.example.okhttptest;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyRecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Holder> {
    ArrayList<Post> Json_data;
    MainActivity mainActivity;

    public MyRecyclerView_Adapter(ArrayList<Post> json_data, MainActivity mainActivity) {
        Json_data = json_data;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public RecyclerView_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(mainActivity.getBaseContext());
        View view=layoutInflater.inflate(R.layout.recycler_view_layout,parent,false);
        return new RecyclerView_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView_Holder holder, int position) {
    holder.textView_Name.setText(Json_data.get(position).getName());
    Glide.with(mainActivity).load(Uri.parse(Json_data.get(position).getPhoto())).into(holder.Product_Image);
    holder.textView_Title.setText(Json_data.get(position).getTitle());
    holder.textView_Price.setText(Json_data.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return Json_data.size();
    }
}

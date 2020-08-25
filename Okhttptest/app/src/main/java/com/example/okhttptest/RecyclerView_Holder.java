package com.example.okhttptest;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerView_Holder extends RecyclerView.ViewHolder {
     ImageView Product_Image;
     TextView textView_Name;
    TextView textView_Title;
    TextView textView_Price;
    public RecyclerView_Holder(@NonNull View itemView) {
        super(itemView);
        Product_Image=itemView.findViewById(R.id.imageView);
        textView_Name=itemView.findViewById(R.id.textView_Name);
        textView_Title=itemView.findViewById(R.id.textView_Title);
        textView_Price=itemView.findViewById(R.id.textView_Price);
    }
}

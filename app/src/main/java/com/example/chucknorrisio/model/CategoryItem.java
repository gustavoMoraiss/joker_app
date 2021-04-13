package com.example.chucknorrisio.model;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.chucknorrisio.R;
import com.xwray.groupie.GroupieViewHolder;
import com.xwray.groupie.Item;

public class CategoryItem extends Item<GroupieViewHolder> {

    private final String categoryName;
    private final int bgColor;

    public CategoryItem(String categoryName, int bgColor){
        this.categoryName = categoryName;
        this.bgColor = bgColor;
    }

    @Override
    public void bind(@NonNull GroupieViewHolder viewHolder, int position) {
        TextView txtCategory = viewHolder.itemView.findViewById(R.id.txt_category);
        txtCategory.setText(categoryName);
        viewHolder.itemView.setBackgroundColor(bgColor);
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public int getLayout() {
        return R.layout.card_category;
    }
}

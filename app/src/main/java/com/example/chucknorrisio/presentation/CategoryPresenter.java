package com.example.chucknorrisio.presentation;

import android.os.Handler;

import com.example.chucknorrisio.Colors;
import com.example.chucknorrisio.MainActivity;
import com.example.chucknorrisio.datasource.CategoryDataSource;
import com.example.chucknorrisio.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryPresenter implements CategoryDataSource.ListCategoriesCallback {

    private static List<CategoryItem> fakeResponse = new ArrayList<>();

    private final CategoryDataSource dataSource;

    private final MainActivity view;

    public CategoryPresenter(MainActivity mainActivity, CategoryDataSource dataSource) {
        this.view = mainActivity;
        this.dataSource = dataSource;
    }

    public void requestAll() {
        this.view.showProgressBar();
        this.dataSource.findAll(this);
    }

    @Override
    public void onSuccess(List<String> response) {
        List<CategoryItem> categoryItems = new ArrayList<>();
        for(String val : response){
            categoryItems.add(new CategoryItem(val, Colors.randomColor()));
        }
        view.showCategories(categoryItems);
    }

    @Override
    public void onComplete() {
        view.hideProgressBar();
    }

    @Override
    public void onError(String message) {
        this.view.showFailure(message);
    }

}

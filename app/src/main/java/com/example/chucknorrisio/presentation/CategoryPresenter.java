package com.example.chucknorrisio.presentation;

import android.os.Handler;

import com.example.chucknorrisio.MainActivity;
import com.example.chucknorrisio.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryPresenter {

    private static List<CategoryItem> fakeResponse = new ArrayList<>();
    private final MainActivity view;

    static {
        fakeResponse.add(new CategoryItem("cat1", 0xFF00FFFF));
        fakeResponse.add(new CategoryItem("cat2", 0xFFA0FFFF));
        fakeResponse.add(new CategoryItem("cat3", 0xFF00FFFF));
        fakeResponse.add(new CategoryItem("cat4", 0xFFA0FFFF));
        fakeResponse.add(new CategoryItem("cat5", 0xFF00FFFF));
        fakeResponse.add(new CategoryItem("cat6", 0xFFA0FFFF));
        fakeResponse.add(new CategoryItem("cat7", 0xFF00FFFF));
        fakeResponse.add(new CategoryItem("cat8", 0xFFA0FFFF));
        fakeResponse.add(new CategoryItem("cat9", 0xFF00FFFF));
        fakeResponse.add(new CategoryItem("cat10", 0xFFA0FFFF));
    }

    public CategoryPresenter(MainActivity mainActivity) {
        this.view = mainActivity;
    }

    public void requestAll() {
        this.view.showProgressBar();
        this.request();
    }

    public void onSuccess(List<CategoryItem> items){
        view.showCategories(items);
    }

    public void onComplete(){
        view.hideProgressBar();
    }

    public void onError(String message){
        this.view.showFailure(message);
    }

    public void request() {
        new Handler().postDelayed(() -> {
            try {
                onSuccess(fakeResponse);
            } catch (Exception e) {
                onError(e.getMessage());
            }finally {
                onComplete();
            }
        }, 5000);
    }
}

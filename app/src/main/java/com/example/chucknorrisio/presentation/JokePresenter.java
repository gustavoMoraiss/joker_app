package com.example.chucknorrisio.presentation;

import com.example.chucknorrisio.JokenActivity;
import com.example.chucknorrisio.datasource.JokeDataSource;
import com.example.chucknorrisio.model.Joke;

public class JokePresenter implements JokeDataSource.JokeCallback {


    private final JokenActivity view;
    private final JokeDataSource dataSource;

    public JokePresenter(JokenActivity jokenActivity, JokeDataSource dataSource) {
        this.view = jokenActivity;
        this.dataSource = dataSource;
    }

    public void findJokeBy(String category) {
        this.view.showProgressBar();
        this.dataSource.findJokeBy(this, category);
    }

    @Override
    public void onSuccess(Joke response) {
        this.view.showJoke(response);
    }

    @Override
    public void onError(String message) {
        this.view.showFailure(message);
    }

    @Override
    public void onComplete() {
        this.view.hideProgressBar();
    }
}

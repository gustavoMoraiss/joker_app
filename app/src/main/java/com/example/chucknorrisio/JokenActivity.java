package com.example.chucknorrisio;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.chucknorrisio.datasource.JokeDataSource;
import com.example.chucknorrisio.model.Joke;
import com.example.chucknorrisio.presentation.JokePresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class JokenActivity extends AppCompatActivity {

    static final String CATEGORY_KEY = "category_key";
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joken);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getIntent().getExtras() != null) {
            String category = getIntent().getExtras().getString(CATEGORY_KEY);
            Log.i("TESTE", category);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(category);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                JokeDataSource dataSource = new JokeDataSource();
                final JokePresenter presenter = new JokePresenter(this, dataSource);
                presenter.findJokeBy(category);



                FloatingActionButton fab = findViewById(R.id.fab);
                fab.setOnClickListener(view -> {
                    presenter.findJokeBy(category);
                });
            }
        }

    }

    public void showJoke(Joke joke){
        TextView txtJoke = findViewById(R.id.txt_joken);
        txtJoke.setText(joke.getValue());
    }

    public void showFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return true;
        }
    }

    public void hideProgressBar() {
        if (progress != null) {
            progress.hide();
        }
    }

    public void showProgressBar() {
        if (progress == null) {
            progress = new ProgressDialog(this);
            progress.setMessage(getString(R.string.load));
            progress.setIndeterminate(true);
            progress.setCancelable(false);
        }
        progress.show();
    }

}
package com.example.chucknorrisio;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.chucknorrisio.model.CategoryItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.xwray.groupie.GroupAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private GroupAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        RecyclerView rv_main = findViewById(R.id.rv_main);
        adapter = new GroupAdapter();
        rv_main.setAdapter(adapter);
        rv_main.setLayoutManager(new LinearLayoutManager(this));
        populateItems();
    }

    private void populateItems(){
        List<CategoryItem> items = new ArrayList<>();
        items.add( new CategoryItem("cat1", 0xFF00FFFF));
        items.add( new CategoryItem("cat2", 0xFFA0FFFF));
        items.add( new CategoryItem("cat3", 0xFF00FFFF));
        items.add( new CategoryItem("cat4", 0xFFA0FFFF));
        items.add( new CategoryItem("cat5", 0xFF00FFFF));
        items.add( new CategoryItem("cat6", 0xFFA0FFFF));
        items.add( new CategoryItem("cat7", 0xFF00FFFF));
        items.add( new CategoryItem("cat8", 0xFFA0FFFF));
        items.add( new CategoryItem("cat9", 0xFF00FFFF));
        items.add( new CategoryItem("cat10", 0xFFA0FFFF));
        adapter.addAll(items);
        adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
package com.abhishek.interiit2016.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.abhishek.interiit2016.R;
import com.abhishek.interiit2016.adapters.GridListAdapter;
import com.abhishek.interiit2016.model.ItemObject;

import java.util.ArrayList;
import java.util.List;

public class Teams extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final List<ItemObject> rowListItem = getAllItemList();
        GridLayoutManager gridLayout = new GridLayoutManager(Teams.this, 2);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayout);
        GridListAdapter adapter = new GridListAdapter(Teams.this,rowListItem);
        recyclerView.setAdapter(adapter);
    }

    private List<ItemObject> getAllItemList() {
        List<ItemObject> allItems = new ArrayList<>();
        allItems.add(new ItemObject("Badminton", R.drawable.india));
        allItems.add(new ItemObject("Cricket", R.drawable.india));
        allItems.add(new ItemObject("Aquatics", R.drawable.india));
        allItems.add(new ItemObject("BasketBall", R.drawable.india));
        allItems.add(new ItemObject("Football", R.drawable.india));
        allItems.add(new ItemObject("TableTennis", R.drawable.india));
        allItems.add(new ItemObject("Coco", R.drawable.india));
        allItems.add(new ItemObject("VolleyBall", R.drawable.india));
        allItems.add(new ItemObject("game1", R.drawable.india));
        allItems.add(new ItemObject("game2", R.drawable.india));
        allItems.add(new ItemObject("game3", R.drawable.india));
        return allItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_teams, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

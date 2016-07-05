package com.abhishek.interiit2016.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.abhishek.interiit2016.R;
import com.abhishek.interiit2016.adapters.StandingsAdapter;
import com.abhishek.interiit2016.model.StandingsDTO;

import java.util.ArrayList;
import java.util.List;

public class Points extends AppCompatActivity {
    StandingsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.dummy_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Points.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        List<StandingsDTO> standingsDTOList=new ArrayList<>();
        for (int i =1;i<=19;i++){
            standingsDTOList.add(new StandingsDTO(String.valueOf(i),"IIT KANPUR","92"));
        }
        adapter = new StandingsAdapter(this,standingsDTOList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_points, menu);
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

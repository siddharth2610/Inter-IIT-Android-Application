package com.abhishek.interiit2016.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.abhishek.interiit2016.R;
import com.abhishek.interiit2016.adapters.SimpleRecyclerAdapter;
import com.abhishek.interiit2016.model.ScheduleDTO;

import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {
    private SimpleRecyclerAdapter simpleRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(ResultsActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        List<ScheduleDTO> resultsList=new ArrayList<>();
        resultsList.add(new ScheduleDTO("KANPUR","CHENNAI","6:30PM","SUNDAY 30 JUNE","CRICKET GROUND","MATCH 26, SEMI-FINALS","143/10","154/0","KANPUR WIN BY 10 RUNS"));
        resultsList.add(new ScheduleDTO("MUMBAI","CHENNAI","6:30PM","THURSDAY 30 DEC","CRICKET GROUND","MATCH 26, FINALS","143/10","154/0","KANPUR WIN BY 10 RUNS"));
        resultsList.add(new ScheduleDTO("MANDI","DELHI","6:30PM","SUNDAY 30 JUNE","CRICKET GROUND","MATCH 26, SEMI-FINALS","143/10","154/0","KANPUR WIN BY 10 RUNS"));
        resultsList.add(new ScheduleDTO("KANPUR","HYDERABAD","6:30PM","SUNDAY 30 JUNE","CRICKET GROUND","MATCH 26, SEMI-FINALS","143/10","154/0","KANPUR WIN BY 10 RUNS"));
        resultsList.add(new ScheduleDTO("VARANASI", "PATNA", "6:30PM", "SUNDAY 30 JUNE", "CRICKET GROUND", "MATCH 26, SEMI-FINALS","143/10","154/0","KANPUR WIN BY 10 RUNS"));
        resultsList.add(new ScheduleDTO("KANPUR", "CHENNAI", "6:30PM", "SUNDAY 30 JUNE", "CRICKET GROUND", "MATCH 26, SEMI-FINALS","143/10","154/0","KANPUR WIN BY 10 RUNS"));
        simpleRecyclerAdapter =new SimpleRecyclerAdapter(ResultsActivity.this,resultsList);
        recyclerView.setAdapter(simpleRecyclerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
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

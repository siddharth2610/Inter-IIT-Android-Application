package com.abhishek.interiit2016.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.abhishek.interiit2016.R;
import com.abhishek.interiit2016.adapters.StandingsAdapter;
import com.abhishek.interiit2016.model.APIResponse;
import com.abhishek.interiit2016.model.StandingsDTO;
import com.abhishek.interiit2016.utils.DataService;
import com.abhishek.interiit2016.utils.GsonFactory;
import com.abhishek.interiit2016.utils.Utils;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Points extends AppCompatActivity {
    private StandingsAdapter adapter;
    private RecyclerView recyclerView;
    private List<StandingsDTO> standingsDTOList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
        recyclerView = (RecyclerView)findViewById(R.id.dummy_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Points.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new StandingsAdapter(this,standingsDTOList);
        recyclerView.setAdapter(adapter);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://www.interiit.com/php")
                .build();
        DataService dataService =restAdapter.create(DataService.class);

        Callback callback = new Callback() {

            @Override
            public void success(Object o, Response response) {
                APIResponse ticketids = (APIResponse)o;
                try {
                    JSONArray jsonArray =new JSONArray(ticketids.getData());
                    Type type = new TypeToken<List<StandingsDTO>>(){}.getType();
                    standingsDTOList = GsonFactory.getISOFormatInstance().fromJson(jsonArray.toString(), type);
                    adapter = new StandingsAdapter(Points.this,standingsDTOList);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                standingsDTOList= new ArrayList<>();
            }
        };
        if (Utils.isInterNetUp(Points.this)){
            dataService.getEvents("Male", callback);
        }

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

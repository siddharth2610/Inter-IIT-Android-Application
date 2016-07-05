package com.abhishek.interiit2016.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.abhishek.interiit2016.R;
import com.abhishek.interiit2016.adapters.GridListAdapter;
import com.abhishek.interiit2016.model.ItemObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends NavDrawerActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_main,mContentFrame);
        final List<ItemObject> rowListItem = getAllItemList();
        GridLayoutManager gridLayout = new GridLayoutManager(MainActivity.this, 3);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayout);
        GridListAdapter adapter = new GridListAdapter(MainActivity.this,rowListItem);
        recyclerView.setAdapter(adapter);
        adapter.SetOnItemClickListener(new GridListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent =new Intent(MainActivity.this,HomeActivity.class);
                intent.putExtra("eventName",rowListItem.get(position).getName());
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<>();
        allItems.add(new ItemObject("Badminton", R.drawable.four));
        allItems.add(new ItemObject("Cricket", R.drawable.five));
        allItems.add(new ItemObject("Aquatics", R.drawable.four));
        allItems.add(new ItemObject("BasketBall", R.drawable.four));
        allItems.add(new ItemObject("Football", R.drawable.five));
        allItems.add(new ItemObject("TableTennis", R.drawable.four));
        allItems.add(new ItemObject("Coco", R.drawable.five));
        allItems.add(new ItemObject("VolleyBall", R.drawable.eight));
        allItems.add(new ItemObject("game1", R.drawable.four));
        allItems.add(new ItemObject("game2", R.drawable.eight));
        allItems.add(new ItemObject("game3", R.drawable.eight));
       /* allItems.add(new ItemObject("Germany", R.drawable.four));
        allItems.add(new ItemObject("Sweden", R.drawable.five));
        allItems.add(new ItemObject("United Kingdom", R.drawable.four));
        allItems.add(new ItemObject("Germany", R.drawable.five));
        allItems.add(new ItemObject("Sweden", R.drawable.eight));
*/
        return allItems;
    }
}

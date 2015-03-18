package com.lnunno.musicapp;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lnunno.musicapp.adapters.ArtistAdapter;
import com.lnunno.musicapp.adapters.DrawerAdapter;
import com.lnunno.musicapp.tasks.RetrieveArtistsTask;
import com.lnunno.musicapp.views.DrawerElement;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeDrawer();
        initializeTopArtistsList();
    }

    private void initializeTopArtistsList() {
        ListView hot_artist_view = (ListView) findViewById(R.id.hotartists_listview);
        ArtistAdapter artistAdapter = new ArtistAdapter(this);
        hot_artist_view.setAdapter(artistAdapter);
        new RetrieveArtistsTask(artistAdapter).execute(EchoNestParameterSets.hotArtistsParams(20));
    }

    private void initializeDrawer() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.setDrawerListener(drawerToggle);
        Resources resources = getResources();
        String[] drawerItems = resources.getStringArray(R.array.drawer_items_array);
        List<DrawerElement> drawerElementList = new ArrayList<>();
        for(String s : drawerItems){
            Drawable drawable = resources.getDrawable(R.drawable.ic_personify);
            drawerElementList.add(new DrawerElement(s,drawable));
        }
        ListView drawerList = (ListView) findViewById(R.id.left_drawer);
        drawerList.setAdapter(new ArrayAdapter<String>(this,R.layout.drawer_element, R.id.drawer_item_text, drawerItems));
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
}

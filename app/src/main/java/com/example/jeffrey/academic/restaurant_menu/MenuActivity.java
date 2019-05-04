package com.example.jeffrey.academic.restaurant_menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jeffrey.academic.R;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    static ArrayList<Item>alcohol=new ArrayList<>();
    static ArrayList<Item>coctail=new ArrayList<>();
    static ArrayList<Item>coldDrink=new ArrayList<>();
    static ArrayList<Item>hamburger=new ArrayList<>();
    static ArrayList<Item>hotDrink=new ArrayList<>();
    static ArrayList<Item>main=new ArrayList<>();
    static ArrayList<Item>pickedList=new ArrayList<>();
    static Fragment selectedFragmant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        loadListWithImage();



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void loadListWithImage() {
        alcohol=createItems(0,R.array.alcoholDesc,R.array.alcoholName,R.array.alcoholPrice);

    }

    private ArrayList<Item> createItems(int numberToAdd, int desc, int name, int price){
        ArrayList<Item> arrayList=new ArrayList();
        for (int i = 0; i <10 ; i++) {
            arrayList.add(new Item(getResources()
                    .getIdentifier(
                            "a"+(i+numberToAdd+1),
                            "drawable", this.getPackageName()),
                    getResources().getStringArray(desc)[i],getResources()
                    .getIntArray(price)[i],getResources().getStringArray(name)[i]));
        }
        return arrayList;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id)
        {
            case R.id.main_course:
                pickedList=main;
                break;

        }
        selectedFragmant=new ShowItems();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,selectedFragmant).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

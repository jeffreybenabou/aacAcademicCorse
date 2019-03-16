package com.example.jeffrey.academic.fragment_example.transfer_data_between_fragmant_from_class;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
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

public class MyDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AddNewUsers.ChangeDestData {

    private ShowUsers showUsers=new ShowUsers();
    private AddNewUsers AddUsers=new AddNewUsers();
    private ArrayList<UserNameExample>userNameExamples;
    private TopFragment topFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_drawer);
        userNameExamples=new ArrayList<>();
        topFragment=(TopFragment)getSupportFragmentManager().findFragmentById(R.id.top_fragment);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_change,AddUsers).commit();
        toolBarAndDrawerLayoutMethod();

    }

    private void toolBarAndDrawerLayoutMethod() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.my_drawer, menu);
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

        if (id == R.id.users_fragments) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_change,showUsers).commit();

        }else if(id == R.id.register_fragment){

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_change,AddUsers).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void changeData(UserNameExample userNameExample) {
        userNameExamples.add(userNameExample);
        topFragment.changeTheData(userNameExample.getFirstName()+" "+userNameExample.getLastName());
        showUsers.setUserNameExamples(userNameExamples);
    }


}

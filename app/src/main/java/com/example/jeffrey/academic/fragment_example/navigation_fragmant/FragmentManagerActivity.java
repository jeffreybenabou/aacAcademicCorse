package com.example.jeffrey.academic.fragment_example.navigation_fragmant;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.jeffrey.academic.R;

public class FragmentManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmant_navegation);
        setTheNavigation();

    }

    private void setTheNavigation() {
        BottomNavigationView bottomNavigationView=findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragmant=null;
                switch (item.getItemId())
                {
                    case R.id.home:
                        selectedFragmant=new HomeFragmant();
                        break;
                    case R.id.search:
                        selectedFragmant=new SearchFragmant();
                        break;
                    case R.id.favorite:
                        selectedFragmant=new FavoriteFragmant();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmant_contiener,selectedFragmant).commit();
                return true;
            }
        });
    }


}

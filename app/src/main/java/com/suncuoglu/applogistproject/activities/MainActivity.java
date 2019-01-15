package com.suncuoglu.applogistproject.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.suncuoglu.applogistproject.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNavigationView =findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.movie:
                                Intent movieIntent= new Intent(MainActivity.this,MovieActivity.class);
                                startActivity(movieIntent);
                                break;
                            case R.id.profile:
                                Intent profileIntent= new Intent(MainActivity.this,ProfileActivity.class);
                                startActivity(profileIntent);
                                break;
                            case R.id.tv:
                                Intent tvIntent= new Intent(MainActivity.this,TvActivity.class);
                                startActivity(tvIntent);
                                break;
                        }
                        return false;
                    }
                });
    }
}

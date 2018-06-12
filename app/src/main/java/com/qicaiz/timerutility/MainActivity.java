package com.qicaiz.timerutility;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Fragment mTimerFragment;
    private Fragment mUartFragment;
    private Fragment mAboutFragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_timer:
                    fragmentTransaction.replace(R.id.content,mTimerFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_uart:
                    fragmentTransaction.replace(R.id.content,mUartFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_about:
                    fragmentTransaction.replace(R.id.content,mAboutFragment);
                    fragmentTransaction.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mTimerFragment = new TimerFragment();
        mUartFragment = new UartFragment();
        mAboutFragment = new AboutFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content,mTimerFragment);
        fragmentTransaction.commit();
    }

}

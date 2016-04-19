package com.igo.ucpr.igo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {




    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        String fragmentTag = MainFragment.TAG;
        if (savedInstanceState == null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            fragment = new MainFragment();
            ft.add(R.id.activity_main_container, fragment, fragmentTag);
            ft.commit();
        }


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

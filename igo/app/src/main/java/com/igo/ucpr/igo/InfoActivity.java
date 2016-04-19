package com.igo.ucpr.igo;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InfoActivity extends AppCompatActivity  implements InfoFragment.OnFragmentInteractionListener {
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        FragmentManager fragmentManager = getSupportFragmentManager();
        String fragmentTag = InfoFragment.TAG;
        if (savedInstanceState == null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            fragment = new InfoFragment();
            ft.add(R.id.activity_info_container, fragment, fragmentTag);
            ft.commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

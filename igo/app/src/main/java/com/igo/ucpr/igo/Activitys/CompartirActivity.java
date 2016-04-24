package com.igo.ucpr.igo.Activitys;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.igo.ucpr.igo.R;

public class CompartirActivity extends AppCompatActivity  implements CompartirFragment.OnFragmentInteractionListener {
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartir);

        FragmentManager fragmentManager = getSupportFragmentManager();
        String fragmentTag = CompartirFragment.TAG;
        if (savedInstanceState == null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            fragment = new CompartirFragment();
            ft.add(R.id.activity_compartir_container, fragment, fragmentTag);
            ft.commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

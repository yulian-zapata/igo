package com.igo.ucpr.igo.Utils;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.widget.ExpandableListView;

import com.igo.ucpr.igo.R;

/**
 * Created by Frank on 22/04/2016.
 */
public class MainActivityList  extends Activity {

    SparseArray<GrupoDeItems> grupos = new SparseArray<GrupoDeItems>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crearDatos();
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listViewexp);
        adaptador adapter = new adaptador(this, grupos);
        listView.setAdapter(adapter);
    }
    public void crearDatos() {
        GrupoDeItems grupo0 = new GrupoDeItems("Lechon");
        grupo0.children.add("Al horno");
        grupo0.children.add("A la parrilla");
        grupos.append(0, grupo0);
        GrupoDeItems grupo1 = new GrupoDeItems("Pescado");
        grupo1.children.add("Paella");
        grupo1.children.add("A la parrilla");
        grupo1.children.add("Frito");
        grupos.append(1, grupo1);
        GrupoDeItems grupo2 = new GrupoDeItems("Sandwichs");
        grupo2.children.add("Jamón, queso y ananá");
        grupo2.children.add("Pollo, morrones y aceitunas");
        grupo2.children.add("Carlitos");
        grupos.append(2, grupo2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }




}

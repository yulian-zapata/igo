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
        setContentView(R.layout.activity_main_list);
        crearDatos();
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listViewexp);
        adaptador adapter = new adaptador(this, grupos);
        listView.setAdapter(adapter);
    }
    public void crearDatos() {
        GrupoDeItems grupo0 = new GrupoDeItems("Grupo 0");
        grupo0.children.add("Chorro de la guerra");
        grupo0.children.add("Cerro Batero");
        grupos.append(0, grupo0);
        GrupoDeItems grupo1 = new GrupoDeItems("Grupo 1");
        grupo1.children.add("Cascade de la guerra");
        grupo1.children.add("Minas del chaquiro");
        grupo1.children.add("Cascada de termales");
        grupos.append(1, grupo1);
        GrupoDeItems grupo2 = new GrupoDeItems("Grupo 2");
        grupo2.children.add("La suiza");
        grupo2.children.add("Pendiente...");
        grupo2.children.add("Pendiente...");
        grupos.append(2, grupo2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }




}

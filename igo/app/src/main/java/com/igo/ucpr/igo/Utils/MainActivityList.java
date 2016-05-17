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
        grupo0.children.add("Frailejones en la Laguna del Otún, es un género de la familia Asteraceae, " +
                "nativas de Colombia, Venezuela y Ecuador ");
        grupo0.children.add("Hermosa vista de La Perla del Otún, esta vista de Pereira," +
                "se puede apreciar desde el alto del Nudo en el municipio de Dosquebradas.");
        grupo0.children.add("Llegando a la estación Pereira, desde carretera," +
                "se aprecia este hermoso valle, donde el río Otún desemboca en el Cauca.");
        grupos.append(0, grupo0);

        GrupoDeItems grupo1 = new GrupoDeItems("Grupo 1");
        grupo1.children.add("Chorro de don Lolo, en el municipio de Santa Rosa de Cabal podemos visitar " +
                "este hermoso sitio depués de 40min.de caminata.");
        grupo1.children.add("Vista Cerro de Batero, se puede apreciar a lo lejos " +
                "desde la carretera que conduce de Pereira al municipio de Quinchía en Risaralda");
        grupo1.children.add("Laguna del Otún,es un " +
                " embalse natural el cual pertenece al parque nacional natural Los Nevados. ");
        grupos.append(1, grupo1);

        GrupoDeItems grupo2 = new GrupoDeItems("Grupo 2");
        grupo2.children.add("Llegando al Chorro, despues de una larga caminata...  por fín la cascada");
        grupo2.children.add("Montañas desde lo alto, en la  carretera que conduce de Apía hacia Pereira, el verde florece al fondo cimas...");
        grupo2.children.add("Antes de llegar a la Pastora, podemos desviarnos 15min y visitar la cascada de la Suiza. ");
        grupos.append(2, grupo2);

        GrupoDeItems grupo3 = new GrupoDeItems("Grupo 3");
        grupo3.children.add("La suiza");
        grupo3.children.add("Pendiente...");
        grupo3.children.add("Pendiente...");
        grupos.append(3, grupo3);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }




}

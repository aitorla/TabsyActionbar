package com.example.aitor.tabs;

import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private boolean bCambiarIcono = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources res = getResources();

        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("TAB1",
                ContextCompat.getDrawable(this, android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("TAB2",
                ContextCompat.getDrawable(this, android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("TAB3",
                ContextCompat.getDrawable(this, android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);


        tabs.setCurrentTab(0);

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {


            @Override
            public void onTabChanged(String tabId) {


                Toast.makeText(getApplicationContext(),tabId,Toast.LENGTH_LONG).show();
                Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);

                if (tabId == "mitab3") {
                    bCambiarIcono = true;
                    invalidateOptionsMenu();
                   // MenuItem menuItem = (MenuItem) findViewById(R.id.action_buscar);
                    //menuItem.setIcon(R.drawable.ic_launcher);
                }
                else {
                    bCambiarIcono = false;
                    invalidateOptionsMenu();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_nuevo:
                Log.i("ActionBar", "Nuevo!");
                return true;
            case R.id.action_buscar:
                Log.i("ActionBar", "Buscar!");;
                return true;
            case R.id.action_settings:
                Log.i("ActionBar", "Settings!");;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if (bCambiarIcono == true ) {
            menu.getItem(2).setIcon(R.drawable.ic_launcher);
            // Ejemplo añadir un nuevo icono
            //menu.getItem(0).setIcon(R.drawable.find);
            //MenuItem mi = menu.add("Buscar");
            //mi.setIcon(R.drawable.find);
            //mi.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
        else {
            menu.getItem(2).setIcon(R.drawable.find);
        }


        return super.onPrepareOptionsMenu(menu);
    }




}

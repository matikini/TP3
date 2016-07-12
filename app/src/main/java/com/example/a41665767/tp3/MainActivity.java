package com.example.a41665767.tp3;

/**
 * Created by 41665767 on 11/5/2016.
 */

    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.os.Bundle;
    import android.support.design.widget.NavigationView;
    import android.support.v4.app.FragmentManager;
    import android.support.v4.app.FragmentTabHost;
    import android.support.v4.view.GravityCompat;
    import android.support.v4.widget.DrawerLayout;
    import android.support.v7.app.ActionBarDrawerToggle;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.util.Log;
    import android.view.MenuItem;
    import android.widget.TextView;
    import android.widget.Toast;

    import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

        private DrawerLayout drawerLayout;
        private FragmentTabHost tabHost;
        private String userName="";
        private TextView navUserName;
        public ArrayList<Jugada> listajug;
        Base accesobase;
        SQLiteDatabase basedatos;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            inicializarToolbar(); // Setear Toolbar como action bar
            inicializarTabs(); // Crear los tabs
            listajug = new ArrayList<>();
            if (!abrirbase()){
                Toast toast = Toast.makeText(this, "Error accediendo a la base", Toast.LENGTH_SHORT);
                toast.show();
            }
            Cursor conjuntoDeRegistros;
            conjuntoDeRegistros=basedatos.rawQuery("select nombre, secuencia, cantmov from jugadas", null);
            if(conjuntoDeRegistros.moveToFirst()== true){
                int cantidadRegistros=0;
                do{
                    cantidadRegistros++;
                    Jugada j = new Jugada(conjuntoDeRegistros.getString(0),conjuntoDeRegistros.getString(1),conjuntoDeRegistros.getInt(2));
                    listajug.add(j);
                } while (conjuntoDeRegistros.moveToNext() == true);
            }

        }
        boolean abrirbase()
        {
            Boolean responder;
            accesobase=new Base(this, "baseTP3", null,1);
            basedatos=accesobase.getWritableDatabase();
            if(basedatos != null)
            {
                responder =true;
            }
            else
            {
                responder =false;
            }
            return responder;
        }

    public void setColor(int color){
        switch (color){
            case 0:
                tabHost.getTabContentView().getChildAt(0).setBackgroundColor(getResources().getColor(R.color.Rojo));
                break;
            case 1:
                tabHost.getTabContentView().getChildAt(0).setBackgroundColor(getResources().getColor(R.color.Azul));
                break;
            case 2:
                tabHost.getTabContentView().getChildAt(0).setBackgroundColor(getResources().getColor(R.color.Verde));
                break;
        }
    }

        private void inicializarToolbar() {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            setearListener(navigationView);
            navUserName = (TextView)navigationView.getHeaderView(0).findViewById(R.id.nav_username);

        }

        private void inicializarTabs() {
            tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
            tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
            tabHost.addTab(
                    tabHost.newTabSpec("tab1").setIndicator("Tab 1", null),
                    FirstFragment.class, null);
            tabHost.addTab(
                    tabHost.newTabSpec("tab2").setIndicator("Tab 2", null),
                    SecondFragment.class, null);
        }


        // Listener de los clicks en el drawer
        private void setearListener(NavigationView navigationView) {
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    item.setChecked(true);
                    switch(item.getItemId()) {
                        case R.id.nav_view:
                            Log.d("Choose:","Background");
                            FragmentManager fm = getSupportFragmentManager();
                            ColoresDialog coloresDialog = new ColoresDialog();
                            coloresDialog.show(fm, "fragment_colores");
                            break;
                        case R.id.nav_user:
                            Log.d("Choose:","Send");
                            FragmentManager frm = getSupportFragmentManager();
                            UserNameDialog userNameDialog = new UserNameDialog();
                            userNameDialog.show(frm, "fragment_edit_name");
                            break;
                    }

                    drawerLayout.closeDrawers();
                    return true;
                }
            });

        }


        // Abre el drawer al clickear el burger
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home:
                    drawerLayout.openDrawer(GravityCompat.START);
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }

        public void setUserName (String userName) {
            this.userName = userName;  // Setear variable de clase
            navUserName.setText(userName); // Setear el texto en la cabecera del drawer
        }

        public String getUserName() {
            return userName;

        }
            public ArrayList<Jugada> getJugadas(){
                return listajug;
            }
        public SQLiteDatabase getBasedatos() {return basedatos;}

    }


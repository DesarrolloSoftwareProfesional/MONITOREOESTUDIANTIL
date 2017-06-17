package pe.edu.sise.appsgmonitoreoestudiantil;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

import pe.edu.sise.model.Alumno;
import pe.edu.sise.model.Usuario;
import pe.edu.sise.utils.Attributes;
import pe.edu.sise.utils.SessionManager;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String TAG="MainActivity";

    protected NavigationView navigationView;
    protected TextView nav_head_tvi_usuario;
    protected TextView nav_head_tvi_email;

    // Usuario Logeado
    protected SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"Tocken: "+ FirebaseInstanceId.getInstance().getToken());

        String id= getIntent().getStringExtra(Attributes.MSG_ID);

        if(!"".equals(id)){
            Log.d(TAG,"id: "+id);
        }

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        this.sessionManager = new SessionManager(this);

        iniciarUI();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                new AlumnoRecyclerViewFragment()).addToBackStack(null).commit();

    }

    private void iniciarUI() {
        floatingActionButton();
        navigationView();
        verSessionUsuario();
    }

    private void floatingActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void navigationView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void verSessionUsuario() {
        //Asociar un la cabecera con una vista
        View view = navigationView.getHeaderView(0);

        nav_head_tvi_usuario = (TextView) view.findViewById(R.id.nav_head_tvi_usuario);
        nav_head_tvi_email = (TextView) view.findViewById(R.id.nav_head_tvi_email);

        if (sessionManager.existsAlumno()) {
            //consume de la sesion
            Alumno alumno = this.sessionManager.getAlumnoSession();
            nav_head_tvi_usuario.setText(alumno.getNomCompleto());
            nav_head_tvi_email.setText(alumno.getUsuario());
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_alumno) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                    new AlumnoRecyclerViewFragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_log_out) {
            this.sessionManager.closeSession();
            finish();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            Intent intt =  new Intent(this,NotificandoActivity.class);
            startActivity(intt);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

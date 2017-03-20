package pe.edu.sise.appsgmonitoreoestudiantil;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pe.edu.sise.adapter.DetalleAlumnoSectionsPageAdapter;

public class DetalleAlumnoActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_detalle_alumno);
        iniciarUI();
    }

    private void iniciarUI() {
        mViewPager = (ViewPager) findViewById(R.id.container);
        mTabLayout = (TabLayout)findViewById(R.id.tabs);
            /*mTabLayout.addTab(mTabLayout.newTab().setText("Desempeño"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Actividades"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Datos Generales"));*/
        DetalleAlumnoSectionsPageAdapter adapter = new DetalleAlumnoSectionsPageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

}

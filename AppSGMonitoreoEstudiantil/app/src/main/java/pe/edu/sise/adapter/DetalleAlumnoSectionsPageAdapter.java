package pe.edu.sise.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import pe.edu.sise.appsgmonitoreoestudiantil.AlumnoDatosGeneralesFragment;
import pe.edu.sise.appsgmonitoreoestudiantil.AlumnoGraficosFragment;
import pe.edu.sise.appsgmonitoreoestudiantil.AlumnoLstActvFragment;
import pe.edu.sise.appsgmonitoreoestudiantil.FragmentoPrueba01;
import pe.edu.sise.appsgmonitoreoestudiantil.FragmentoPrueba02;
import pe.edu.sise.appsgmonitoreoestudiantil.FragmentoPrueba03;

/**
 * Created by ASUS on 19/03/2017.
 */

public class DetalleAlumnoSectionsPageAdapter  extends FragmentPagerAdapter {

    public DetalleAlumnoSectionsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AlumnoDatosGeneralesFragment();
            case 1:
                return new AlumnoLstActvFragment();
            case 2:
                return new AlumnoGraficosFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Datos Generales";
            case 1:
                return "Actividades";
            case 2:
                return "Desempeño";
        }
        return null;
    }
}

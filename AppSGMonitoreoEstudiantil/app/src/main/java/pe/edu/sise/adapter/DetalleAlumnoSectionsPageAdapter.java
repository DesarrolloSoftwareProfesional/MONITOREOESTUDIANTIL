package pe.edu.sise.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

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
                return new FragmentoPrueba01();
            case 1:
                return new FragmentoPrueba02();
            case 2:
                return new FragmentoPrueba03();
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
                return "Desempeño";
            case 1:
                return "Actividades";
            case 2:
                return "Datos Generales";
        }
        return null;
    }
}

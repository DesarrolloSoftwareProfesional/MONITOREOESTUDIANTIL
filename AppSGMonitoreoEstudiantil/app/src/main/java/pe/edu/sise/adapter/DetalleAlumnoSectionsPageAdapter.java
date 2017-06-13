package pe.edu.sise.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import pe.edu.sise.appsgmonitoreoestudiantil.AlumnoDatosGeneralesFragment;
import pe.edu.sise.appsgmonitoreoestudiantil.AlumnoGraficosFragment;
import pe.edu.sise.appsgmonitoreoestudiantil.AlumnoLstActvFragment;
import pe.edu.sise.appsgmonitoreoestudiantil.FragmentoPrueba01;
import pe.edu.sise.appsgmonitoreoestudiantil.FragmentoPrueba02;
import pe.edu.sise.appsgmonitoreoestudiantil.FragmentoPrueba03;

import static pe.edu.sise.utils.Attributes.*;

/**
 * Created by ASUS on 19/03/2017.
 */

public class DetalleAlumnoSectionsPageAdapter  extends FragmentPagerAdapter {
    int idAlumno,trimeste;
    public DetalleAlumnoSectionsPageAdapter(FragmentManager fm,int idAlumno,int trimeste) {
        super(fm);
        this.idAlumno = idAlumno;
        this.trimeste = trimeste;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bnd =  new Bundle();
        bnd.putInt(KEY_IDALUMNO,this.idAlumno);
        bnd.putInt(KEY_PROMEDIO,this.trimeste);
        switch (position) {
            case 0:
                AlumnoDatosGeneralesFragment datosGenerales  = new AlumnoDatosGeneralesFragment();
                datosGenerales.setArguments(bnd);
                return datosGenerales;
            case 1:
                AlumnoLstActvFragment alumnoActvFrag = new AlumnoLstActvFragment();
                alumnoActvFrag.setArguments(bnd);
                return alumnoActvFrag;
            case 2:
                AlumnoGraficosFragment alumnoGraf = new AlumnoGraficosFragment();
                alumnoGraf.setArguments(bnd);
                return alumnoGraf;
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

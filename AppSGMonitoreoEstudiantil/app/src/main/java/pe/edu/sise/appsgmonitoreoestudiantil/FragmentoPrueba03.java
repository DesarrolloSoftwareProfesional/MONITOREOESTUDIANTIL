package pe.edu.sise.appsgmonitoreoestudiantil;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

/**
 * Created by ASUS on 19/03/2017.
 */

public class FragmentoPrueba03 extends Fragment {
    public FragmentoPrueba03() {

    }

    private  BarChart alum_graf_chart_prom;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_prueba,container,false);


        return mview;
    }
}

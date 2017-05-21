package pe.edu.sise.appsgmonitoreoestudiantil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ASUS on 19/03/2017.
 */

public class FragmentoPrueba02 extends Fragment{
    public FragmentoPrueba02() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_prueba,container,false);
//        TextView textView = (TextView) mview.findViewById(R.id.tvitextoprueba);
//        textView.setText("Fragmento 2");
        return mview;
    }
}

package pe.edu.sise.appsgmonitoreoestudiantil;


import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DetalleActividad extends AppCompatActivity {


    private TextView txtFecha, txtHora;

    Calendar datetime = Calendar.getInstance();
    int year = datetime.get(Calendar.YEAR);
    int month = datetime.get(Calendar.MONTH);
    int day = datetime.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad);

        txtFecha = (TextView) findViewById(R.id.txtFecha);
        txtHora = (TextView) findViewById(R.id.txtHora);


    }



}

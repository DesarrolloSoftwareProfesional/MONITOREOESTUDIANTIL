package pe.edu.sise.appsgmonitoreoestudiantil;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONObject;

import java.util.HashMap;

import pe.edu.sise.controller.AlumnoController;
import pe.edu.sise.controller.ApoderadoController;
import pe.edu.sise.model.Alumno;
import pe.edu.sise.model.Apoderado;
import pe.edu.sise.model.Usuario;
import pe.edu.sise.utils.Attributes;
import pe.edu.sise.utils.FcmTokenAsyncTask;
import pe.edu.sise.utils.JSONObjectValue;
import pe.edu.sise.utils.SessionManager;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    protected static final String TAG = "LoginActivity";

    private EditText log_etx_usu;
    private EditText log_etx_pass;
    private Button log_btn_entrar;
    private Button log_btn_reg;
    private TextView log_tv_registrate;
    private CheckBox log_chb_recUser;
    private Spinner log_sp_TipoUsuario;


    //Session Usuario

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.sessionManager = new SessionManager(this);

        //log_sp_TipoUsuario = (Spinner) findViewById(R.id.log_sp_TipoUsuario);



//        if (sessionManager.isLoggedAlumno()) {
//            irFormularioMain();
//        }
        if (sessionManager.isLoggedApoderado()) {
            irFormularioMain();
        }

        iniciarUI();
    }

    private void iniciarUI() {
        log_etx_usu = (EditText) findViewById(R.id.log_etx_usu);
        log_etx_pass = (EditText) findViewById(R.id.log_etx_pass);
        log_btn_entrar = (Button) findViewById(R.id.log_btn_entrar);
        //log_btn_reg = (Button) findViewById(R.id.log_btn_reg);
        //log_tvi_recuPass = (TextView) findViewById(R.id.log_txv_recupPass);
        log_chb_recUser = (CheckBox) findViewById(R.id.log_chb_recUser);
        log_sp_TipoUsuario = (Spinner) findViewById(R.id.log_sp_TipoUsuario);
        log_tv_registrate = (TextView) findViewById(R.id.log_tv_reg);

        //Listener
        log_etx_pass.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((keyEvent != null
                        && (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (i == EditorInfo.IME_ACTION_DONE)) {
                    ingresarSistema();
                }
                return false;
            }
        });

        log_tv_registrate.setOnClickListener(LoginActivity.this);
        log_btn_entrar.setOnClickListener(LoginActivity.this);

        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( this, R.array.TipoSession , android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        log_sp_TipoUsuario.setAdapter(spinner_adapter);

       // this.tipoSesionUser();
    }


    //VER TIPO DE INICIO DE SESION

    private void tipoSesionUser(){
//
//        log_sp_TipoUsuario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Object o = parent.getSelectedItem();
//                Log.d(TAG, "onItemClick: " + o.toString());
//            }
//        });

//        log_sp_TipoUsuario.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }



    //Implements Listener
    private void mostrarDialogoRegistro() {
        new UsuarioAddDialogFragment().show(getSupportFragmentManager(), "dialogo");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.log_tv_reg:
                mostrarDialogoRegistro();
                break;
            case R.id.log_btn_entrar:
                ingresarSistema();
                break;
        }
    }

    private void ingresarSistema() {
        validasCamposDeEntrad();
    }

    private void validasCamposDeEntrad() {
        log_etx_usu.setError(null);
        log_etx_pass.setError(null);
        String usu = log_etx_usu.getText().toString();
        String pass = log_etx_pass.getText().toString();
        boolean cancel = false;
        View focusView = null;


        if (TextUtils.isEmpty(usu)) {
            log_etx_usu.setError(getString(R.string.err_field_required));
            focusView = log_etx_usu;
            cancel = true;
        }
        if (TextUtils.isEmpty(pass)) {
            log_etx_pass.setError(getString(R.string.err_field_required));
            focusView = log_etx_pass;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();
        } else {
            //new AlumnoLoginAsyncTask().execute(getLoginJsonObject(usu, pass));
            new ApoderadoLoginAsyncTask().execute(getLoginApoderadoJsonObject(usu,pass));
        }
    }

    private  void validarLogin(Alumno alumno){
        if (alumno != null) {
            if (alumno.isEstadoRegistro()) {
                if (log_chb_recUser.isChecked()) {
                    alumno.setLogged(true);
                }
                sessionManager.createAlumnoSession(alumno);
                irFormularioMain();

            }else{
                Toast.makeText(getBaseContext(), getString(R.string.err_invalid_access), Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),(getString(R.string.err_login)), Toast.LENGTH_LONG).show();
        }
    }

    private  void validarLoginApoderado(Apoderado apoderado){
        if (apoderado != null) {
            if (apoderado.isEstadoRegistro()) {
                if (log_chb_recUser.isChecked()) {
                    apoderado.setLogged(true);
                }
                sessionManager.createApoderadoSession(apoderado);

                //Actualizar token.
                new FcmTokenAsyncTask().execute(JSONObjectValue.fcmToken("1", FirebaseInstanceId.getInstance().getToken()));
                
                irFormularioMain();

            }else{
                Toast.makeText(getBaseContext(), getString(R.string.err_invalid_access), Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),(getString(R.string.err_login)), Toast.LENGTH_LONG).show();
        }
    }


    private void irFormularioMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    //EMAIL AND PASSWORD - JSONOBJET
    protected JSONObject getLoginJsonObject(String usu, String pass) {
        JSONObject jsonObject = null;

        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Attributes.ALUM_USUARIO, usu);
            hashMap.put(Attributes.ALUM_PASSWORD, pass);

            jsonObject = new JSONObject(hashMap);

        } catch (Exception e) {
            Log.d(TAG, "Error getLoginJsonObject " + Log.getStackTraceString(e));
        }

        return jsonObject;
    }

    protected JSONObject getLoginApoderadoJsonObject(String usu, String pass) {
        JSONObject jsonObject = null;

        try {
            HashMap<String, String> hashMap = new HashMap<>();
           hashMap.put(Attributes.APOD_USUARIO, usu);
            hashMap.put(Attributes.APOD_PASSWORD, pass);

            jsonObject = new JSONObject(hashMap);

        } catch (Exception e) {
            Log.d(TAG, "Error getLoginJsonObject " + Log.getStackTraceString(e));
        }

        return jsonObject;
    }

    //LOGIN - SERVICIO WEB

    private class AlumnoLoginAsyncTask extends AsyncTask<JSONObject, Void, Alumno> {

        @Override
        protected Alumno doInBackground(JSONObject... params) {
            return AlumnoController.login(params[0]);
        }

        @Override
        protected void onPostExecute(Alumno alumno) {
            super.onPostExecute(alumno);
            validarLogin(alumno);
        }

    }

    private class ApoderadoLoginAsyncTask extends AsyncTask<JSONObject, Void, Apoderado> {

        @Override
        protected Apoderado doInBackground(JSONObject... params) {
            return ApoderadoController.login(params[0]);
        }

        @Override
        protected void onPostExecute(Apoderado apoderado) {
            super.onPostExecute(apoderado);
            validarLoginApoderado(apoderado);
        }

    }


}

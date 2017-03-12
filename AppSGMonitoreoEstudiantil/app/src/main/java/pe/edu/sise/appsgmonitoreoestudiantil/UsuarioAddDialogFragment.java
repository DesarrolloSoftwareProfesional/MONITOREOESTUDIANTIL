package pe.edu.sise.appsgmonitoreoestudiantil;

import android.support.v7.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class UsuarioAddDialogFragment extends DialogFragment implements View.OnClickListener {
    //constante - nombre del la clase para imprimir las excepciones
    protected static final String TAG = "UsuarioAddDialog";

    // Variables
    Container container = new Container();

    public UsuarioAddDialogFragment() {
        // Required empty public constructor
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Creacion de la vista
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_usuario_add_dialog, null);
        container.usu_add_etx_nom = (EditText) view.findViewById(R.id.usu_add_etx_nom);
        container.usu_add_etx_ape = (EditText) view.findViewById(R.id.usu_add_etx_ape);
        container.usu_add_etx_dni_alum = (EditText) view.findViewById(R.id.usu_add_etx_dni_alum);
        container.usu_add_etx_email = (EditText) view.findViewById(R.id.usu_add_etx_email);
        container.usu_add_etx_pass = (EditText) view.findViewById(R.id.usu_add_etx_pass);
        container.usu_add_etx_pass_conf = (EditText) view.findViewById(R.id.usu_add_etx_pass_conf);
        container.usu_add_btn_reg = (Button) view.findViewById(R.id.usu_add_btn_reg);
        view.setTag(container);


        //Listeners
        container.usu_add_btn_reg.setOnClickListener(UsuarioAddDialogFragment.this);

        //Creacion del dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.Theme_Dialog);
        builder.setView(view);


        return builder.create();
    }


    private void registrarUsuario() {
        this.validarCamposDeEntrada();
    }

    //Validar campos (vacios, tipos)
    private void validarCamposDeEntrada(){
        //inicializamos errores
        container.usu_add_etx_nom.setError(null);
        container.usu_add_etx_ape.setError(null);
        container.usu_add_etx_dni_alum.setError(null);
        container.usu_add_etx_email.setError(null);
        container.usu_add_etx_pass.setError(null);
        container.usu_add_etx_pass_conf.setError(null);

        //Cacturamos valores de los componentes
        String nombres = container.usu_add_etx_nom.getText().toString();
        String apellidos = container.usu_add_etx_ape.getText().toString();
        String dniAlum = container.usu_add_etx_dni_alum.getText().toString();
        String email = container.usu_add_etx_email.getText().toString();
        String password = container.usu_add_etx_pass.getText().toString();
        String passConf = container.usu_add_etx_pass_conf.getText().toString();


        boolean cancel = false;
        View focusView = null;

        //verificar nombre
        if (TextUtils.isEmpty(nombres)) {
            container.usu_add_etx_nom.setError(getString(R.string.err_field_required));
            focusView = container.usu_add_etx_nom;
            cancel = true;
        }

        //Verificar apellidos
        if (TextUtils.isEmpty(apellidos)) {
            container.usu_add_etx_ape.setError(getString(R.string.err_field_required));
            focusView = container.usu_add_etx_ape;
            cancel = true;
        }

        //Verificar dni
        if (TextUtils.isEmpty(dniAlum)) {
            container.usu_add_etx_dni_alum.setError(getString(R.string.err_field_required));
            focusView = container.usu_add_etx_dni_alum;
            cancel = true;
        } else if (!isDniValid(dniAlum)) {
            container.usu_add_etx_dni_alum.setError(getString(R.string.err_incorrect_dni));
            focusView = container.usu_add_etx_dni_alum;
            cancel = true;
        }

        //Verificar Email
        if (TextUtils.isEmpty(email)) {
            container.usu_add_etx_email.setError(getString(R.string.err_field_required));
            focusView = container.usu_add_etx_email;
            cancel = true;
        } else if (!isEmailValid(email)) {
            container.usu_add_etx_email.setError(getString(R.string.err_invalid_email));
            focusView = container.usu_add_etx_email;
            cancel = true;
        }


        //Verificar Password
        if (TextUtils.isEmpty(password)) {
            container.usu_add_etx_pass.setError(getString(R.string.err_field_required));
            focusView = container.usu_add_etx_pass;
            cancel = true;
        } else if (!isPasswordValid(password)) {
            container.usu_add_etx_pass.setError(getString(R.string.err_invalid_password));
            focusView = container.usu_add_etx_pass;
            cancel = true;
        }

        //Verificar que los password concuerden
        if (TextUtils.isEmpty(passConf)) {
            container.usu_add_etx_pass_conf.setError(getString(R.string.err_field_required));
            focusView = container.usu_add_etx_pass_conf;
            cancel = true;
        } else if (!password.equals(passConf)) {
            container.usu_add_etx_pass_conf.setError(getString(R.string.err_incorrect_pass_conf));
            focusView = container.usu_add_etx_pass_conf;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {

        }


    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    private boolean isDniValid(String dni) {
        return dni.length() > 7;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.usu_add_btn_reg:
                registrarUsuario();
                break;
        }
    }


    //Clase privada para contener los controles
    private class Container {
        protected EditText usu_add_etx_nom;
        protected EditText usu_add_etx_ape;
        protected EditText usu_add_etx_dni_alum;
        protected EditText usu_add_etx_email;
        protected EditText usu_add_etx_pass;
        protected EditText usu_add_etx_pass_conf;
        protected Button usu_add_btn_reg;
    }

}

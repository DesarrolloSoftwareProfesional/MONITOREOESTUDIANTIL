package pe.edu.sise.appsgmonitoreoestudiantil;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
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
        container.edtxNombres = (EditText) view.findViewById(R.id.edtx_usu_add_nombres);
        container.edtxApellidos = (EditText) view.findViewById(R.id.edtx_usu_add_apellidos);
        container.edtxDniAlumno = (EditText) view.findViewById(R.id.edtx_usu_add_dni_alumno);
        container.edtxEmail = (EditText) view.findViewById(R.id.edtx_usu_add_email);
        container.edtxPassword = (EditText) view.findViewById(R.id.edtx_usu_add_password);
        container.edtxPassConf = (EditText) view.findViewById(R.id.edtx_usu_add_pass_conf);
        container.btnRegistrarse = (Button) view.findViewById(R.id.btn_usu_add_registarse);
        view.setTag(container);

        //Creacion del dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

        //Listeners
        container.btnRegistrarse.setOnClickListener(this);

        return builder.create();
    }



    private void registrarUsuario() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_usu_add_registarse:
                registrarUsuario();
                break;
        }
    }


    //Clase privada para contener los controles
    private class Container {
        protected EditText edtxNombres;
        protected EditText edtxApellidos;
        protected EditText edtxDniAlumno;
        protected EditText edtxEmail;
        protected EditText edtxPassword;
        protected EditText edtxPassConf;
        protected Button btnRegistrarse;
    }

}

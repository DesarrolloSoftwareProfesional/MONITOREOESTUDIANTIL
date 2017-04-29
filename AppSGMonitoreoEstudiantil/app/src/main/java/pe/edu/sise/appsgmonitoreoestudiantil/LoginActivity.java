package pe.edu.sise.appsgmonitoreoestudiantil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.sise.model.Usuario;
import pe.edu.sise.utils.Atributes;
import pe.edu.sise.utils.SessionManager;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText log_etx_usu;
    private EditText log_etx_pass;
    private Button log_btn_entrar;
    private Button log_btn_reg;
    private TextView log_tvi_recuPass;
    private CheckBox log_chb_recUser;

    //Session Usuario

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.sessionManager=new SessionManager(this);

        if(sessionManager.isLoggedUsuario()){
            irFormularioMain();
        }

        iniciarUI();
    }

    private void iniciarUI() {
        log_etx_usu = (EditText) findViewById(R.id.log_etx_usu);
        log_etx_pass = (EditText) findViewById(R.id.log_etx_pass);
        log_btn_entrar = (Button) findViewById(R.id.log_btn_entrar);
        log_btn_reg = (Button) findViewById(R.id.log_btn_reg);
        //log_tvi_recuPass = (TextView) findViewById(R.id.log_txv_recupPass);
        log_chb_recUser=(CheckBox)findViewById(R.id.log_chb_recUser);
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

        log_btn_reg.setOnClickListener(LoginActivity.this);
        log_btn_entrar.setOnClickListener(LoginActivity.this);
    }


    //Implements Listener
    private void mostrarDialogoRegistro() {
        new UsuarioAddDialogFragment().show(getSupportFragmentManager(), "dialogo");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.log_btn_reg:
                mostrarDialogoRegistro();
                break;
            case R.id.log_btn_entrar:
                ingresarSistema();
                break;
        }
    }

    private void ingresarSistema() {

        String usu = log_etx_usu.getText().toString();
        String pass = log_etx_pass.getText().toString();
        validasCamposDeEntrad();

        if (usu.equals(Atributes.usuarioAdmin) & pass.equals(Atributes.passAdmin)) {
            Toast.makeText(getApplicationContext(), "Cargando...", Toast.LENGTH_SHORT).show();
            if(log_chb_recUser.isChecked()){
                this.guardarUsuario();
            }
            this.irFormularioMain();
        } else {
            Toast.makeText(getApplicationContext(),(getString(R.string.err_login)), Toast.LENGTH_LONG).show();
            log_etx_pass.setText("");
            log_etx_usu.setText("");
        }
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

        }
    }

    private  void guardarUsuario(){
        Usuario  usuario= new Usuario();
        usuario.setEmailusu("apalomino@gmail.com");
        usuario.setNomusu("Abel");
        usuario.setApeusu("Palomino Rojas");
        usuario.setIdusu("0");

        this.sessionManager.createUsuarioSession(usuario);
    }

    private  void irFormularioMain(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}

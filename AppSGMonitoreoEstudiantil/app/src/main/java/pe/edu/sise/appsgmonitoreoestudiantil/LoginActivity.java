package pe.edu.sise.appsgmonitoreoestudiantil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.sise.utils.Atributes;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText log_etx_usu;
    private EditText log_etx_pass;
    private Button log_btn_entrar;
    private Button log_btn_reg;
    private TextView log_tvi_recuPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniciarUI();
    }

    private void iniciarUI() {
        log_etx_usu = (EditText) findViewById(R.id.log_etx_usu);
        log_etx_pass = (EditText) findViewById(R.id.log_etx_pass);
        log_btn_entrar = (Button) findViewById(R.id.log_btn_entrar);
        log_btn_reg = (Button) findViewById(R.id.log_btn_reg);
        log_tvi_recuPass = (TextView) findViewById(R.id.log_txv_recupPass);

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
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(),(getString(R.string.err_login)), Toast.LENGTH_LONG).show();
            log_etx_pass.setText("");
            log_etx_usu.requestFocus();
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
}

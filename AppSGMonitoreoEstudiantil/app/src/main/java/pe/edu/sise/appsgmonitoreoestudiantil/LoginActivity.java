package pe.edu.sise.appsgmonitoreoestudiantil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener{
    private EditText log_etx_usu;
    private EditText log_etx_pass;
    private Button log_btn_entrar;
    private Button log_btn_reg;
    private TextView log_tvi_recuPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //creacion de varaibles
        iniciarUI();
    }
    private void iniciarUI(){
        log_etx_usu = (EditText) findViewById(R.id.log_etx_usu);
        log_etx_pass = (EditText) findViewById(R.id.log_etx_pass);
        log_btn_entrar = (Button) findViewById(R.id.log_btn_entrar);
        log_btn_reg = (Button) findViewById(R.id.log_btn_reg);
        log_tvi_recuPass = (TextView) findViewById(R.id.log_txv_recupPass);
        //Listener
        log_btn_reg.setOnClickListener(LoginActivity.this);
        log_btn_entrar.setOnClickListener(LoginActivity.this);
    }


    //Implements Listener
    private void mostrarDialogoRegistro()
    {
        new UsuarioAddDialogFragment().show(getSupportFragmentManager(), "dialogo");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.log_btn_reg:
                mostrarDialogoRegistro();
                break;
            case R.id.log_btn_entrar:
                ingresarSistema();
                break;
        }
    }
    private void ingresarSistema(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}

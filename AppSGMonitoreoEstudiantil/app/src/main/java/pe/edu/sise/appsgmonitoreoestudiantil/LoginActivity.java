package pe.edu.sise.appsgmonitoreoestudiantil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText log_etx_usu;
    private EditText log_etx_pass;
    private Button log_btn_entrar;

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
    }
}

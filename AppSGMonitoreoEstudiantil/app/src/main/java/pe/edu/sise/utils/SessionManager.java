package pe.edu.sise.utils;

import android.content.Context;
import android.content.SharedPreferences;

import pe.edu.sise.model.Usuario;

public class SessionManager {
    private static final String PREF_NAME = "sgme";
    private static final int PRIVATE_MODE = 0;

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        this.editor = this.sharedPreferences.edit();
    }

    public void createUsuarioSession(Usuario usuario) {
        this.editor.putString(Atributes.USU_ID_USUARIO, usuario.getIdusu());
        this.editor.putString(Atributes.USU_NOMBRES, usuario.getNomusu());
        this.editor.putString(Atributes.USU_APELLIDOS, usuario.getApeusu());
        this.editor.putString(Atributes.USU_EMAIL, usuario.getEmailusu());

        this.editor.commit();
    }

    public Usuario getUsuarioSession() {
        Usuario usuario = new Usuario();
        usuario.setIdusu(this.sharedPreferences.getString(Atributes.USU_ID_USUARIO, null));
        usuario.setNomusu(this.sharedPreferences.getString(Atributes.USU_NOMBRES, null));
        usuario.setApeusu(this.sharedPreferences.getString(Atributes.USU_APELLIDOS, null));
        usuario.setEmailusu(this.sharedPreferences.getString(Atributes.USU_EMAIL, null));
        return usuario;
    }

    public void closeUsuarioSession() {
        this.editor.clear();
        this.editor.commit();
    }


    public boolean isLoggedUsuario() {
        return (this.sharedPreferences.getString(Atributes.USU_ID_USUARIO,null)== null )?false:true;
    }

}

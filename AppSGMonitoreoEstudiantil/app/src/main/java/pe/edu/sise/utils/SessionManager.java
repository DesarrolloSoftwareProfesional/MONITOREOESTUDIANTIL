package pe.edu.sise.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import pe.edu.sise.model.Alumno;
import pe.edu.sise.model.Apoderado;
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
        this.editor.putString(Attributes.USU_ID_USUARIO, usuario.getIdusu());
        this.editor.putString(Attributes.USU_NOMBRES, usuario.getNomusu());
        this.editor.putString(Attributes.USU_APELLIDOS, usuario.getApeusu());
        this.editor.putString(Attributes.USU_EMAIL, usuario.getEmailusu());

        this.editor.commit();
    }

    public Usuario getUsuarioSession() {
        Usuario usuario = new Usuario();
        usuario.setIdusu(this.sharedPreferences.getString(Attributes.USU_ID_USUARIO, null));
        usuario.setNomusu(this.sharedPreferences.getString(Attributes.USU_NOMBRES, null));
        usuario.setApeusu(this.sharedPreferences.getString(Attributes.USU_APELLIDOS, null));
        usuario.setEmailusu(this.sharedPreferences.getString(Attributes.USU_EMAIL, null));
        return usuario;
    }


    public boolean isLoggedUsuario() {
        return (this.sharedPreferences.getString(Attributes.USU_ID_USUARIO,null)== null )?false:true;
    }

    public void createAlumnoSession(Alumno  alumno) {
        this.editor.putString(Attributes.ALUM_ID,alumno.getId());
        this.editor.putString(Attributes.ALUM_AP_PATERNO,alumno.getApPaterno());
        this.editor.putString(Attributes.ALUM_AP_MATERNO,alumno.getApMaterno());
        this.editor.putString(Attributes.ALUM_NOMBRES,alumno.getNombres());
        this.editor.putString(Attributes.ALUM_DNI,alumno.getDni());
        this.editor.putString(Attributes.ALUM_NOM_COMPLETO,alumno.getNomCompleto());
        this.editor.putString(Attributes.ALUM_FECHA_NAC,alumno.getFechaNac());
        this.editor.putString(Attributes.ALUM_DIRECCION,alumno.getDireccion());
        this.editor.putBoolean(Attributes.ALUM_ESTADO_REG,alumno.isEstadoRegistro());
        this.editor.putString(Attributes.ALUM_USUARIO,alumno.getUsuario());
        this.editor.putBoolean(Attributes.ALUM_IS_LOGGED,alumno.isLogged());

        this.editor.commit();
    }

    public void createApoderadoSession(Apoderado apoderado) {
        this.editor.putString(Attributes.APOD_ID,apoderado.getId());
        this.editor.putString(Attributes.APOD_AP_PATERNO,apoderado.getApPaterno());
        this.editor.putString(Attributes.APOD_AP_MATERNO,apoderado.getApMaterno());
        this.editor.putString(Attributes.APOD_NOMBRES,apoderado.getNombres());
        this.editor.putString(Attributes.APOD_DNI,apoderado.getDni());
        this.editor.putString(Attributes.APOD_NOM_COMPLETO,apoderado.getNomCompleto());
        this.editor.putString(Attributes.APOD_FECHA_NAC,apoderado.getFechaNac());
        this.editor.putString(Attributes.APOD_DIRECCION,apoderado.getDireccion());
        this.editor.putBoolean(Attributes.APOD_ESTADO_REG,apoderado.isEstadoRegistro());
        this.editor.putString(Attributes.APOD_USUARIO,apoderado.getUsuario());
        this.editor.putBoolean(Attributes.APOD_IS_LOGGED,apoderado.isLogged());

        this.editor.commit();
    }

    public Alumno getAlumnoSession() {
        Alumno alumno = new Alumno();
        alumno.setId(this.sharedPreferences.getString(Attributes.ALUM_ID, null));
        alumno.setApPaterno(this.sharedPreferences.getString(Attributes.ALUM_AP_PATERNO, null));
        alumno.setApMaterno(this.sharedPreferences.getString(Attributes.ALUM_AP_MATERNO, null));
        alumno.setNombres(this.sharedPreferences.getString(Attributes.ALUM_NOMBRES, null));
        alumno.setDni(this.sharedPreferences.getString(Attributes.ALUM_DNI, null));
        alumno.setNomCompleto(this.sharedPreferences.getString(Attributes.ALUM_NOM_COMPLETO, null));
        alumno.setFechaNac(this.sharedPreferences.getString(Attributes.ALUM_FECHA_NAC, null));
        alumno.setDireccion(this.sharedPreferences.getString(Attributes.ALUM_DIRECCION, null));
        alumno.setEstadoRegistro(this.sharedPreferences.getBoolean(Attributes.ALUM_ESTADO_REG, false));
        alumno.setUsuario(this.sharedPreferences.getString(Attributes.ALUM_USUARIO, null));
        alumno.setLogged(this.sharedPreferences.getBoolean(Attributes.ALUM_IS_LOGGED, false));
        return alumno;
    }

    public Apoderado getApoderadoSession() {
        Apoderado apoderado = new Apoderado();

        apoderado.setId(this.sharedPreferences.getString(Attributes.APOD_ID, null));
        apoderado.setApPaterno(this.sharedPreferences.getString(Attributes.APOD_AP_PATERNO, null));
        apoderado.setApMaterno(this.sharedPreferences.getString(Attributes.APOD_AP_MATERNO, null));
        apoderado.setNombres(this.sharedPreferences.getString(Attributes.APOD_NOMBRES, null));
        apoderado.setDni(this.sharedPreferences.getString(Attributes.APOD_DNI, null));
        apoderado.setNomCompleto(this.sharedPreferences.getString(Attributes.APOD_NOM_COMPLETO, null));
        apoderado.setFechaNac(this.sharedPreferences.getString(Attributes.APOD_FECHA_NAC, null));
        apoderado.setDireccion(this.sharedPreferences.getString(Attributes.APOD_DIRECCION, null));
        apoderado.setEstadoRegistro(this.sharedPreferences.getBoolean(Attributes.APOD_ESTADO_REG, false));
        apoderado.setUsuario(this.sharedPreferences.getString(Attributes.APOD_USUARIO, null));
        apoderado.setLogged(this.sharedPreferences.getBoolean(Attributes.APOD_IS_LOGGED, false));
        return apoderado;
    }

    public boolean isLoggedAlumno() {
        return this.sharedPreferences.getBoolean(Attributes.ALUM_IS_LOGGED, false);
    }

    public boolean isLoggedApoderado() {
        return this.sharedPreferences.getBoolean(Attributes.APOD_IS_LOGGED, false);
    }

    public boolean existsAlumno() {
        return (this.sharedPreferences.getString(Attributes.ALUM_ID,null)== null )?false:true;
    }

    public boolean existsApoderado() {
        return (this.sharedPreferences.getString(Attributes.APOD_ID,null)== null )?false:true;
    }


    public void closeSession() {
        this.editor.clear();
        this.editor.commit();
    }




}

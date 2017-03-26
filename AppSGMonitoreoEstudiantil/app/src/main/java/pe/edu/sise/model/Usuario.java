package pe.edu.sise.model;

public class Usuario {
    private String idusu;

    private String nomusu;

    private String apeusu;

    private String emailusu;


    public Usuario(String idusu, String nomusu, String apeusu, String emailusu) {
        this.idusu = idusu;
        this.nomusu = nomusu;
        this.apeusu = apeusu;
        this.emailusu = emailusu;
    }

    public Usuario() {
    }

    public String getIdusu() {
        return idusu;
    }

    public void setIdusu(String idusu) {
        this.idusu = idusu;
    }

    public String getNomusu() {
        return nomusu;
    }

    public void setNomusu(String nomusu) {
        this.nomusu = nomusu;
    }

    public String getApeusu() {
        return apeusu;
    }

    public void setApeusu(String apeusu) {
        this.apeusu = apeusu;
    }

    public String getEmailusu() {
        return emailusu;
    }

    public void setEmailusu(String emailusu) {
        this.emailusu = emailusu;
    }
}

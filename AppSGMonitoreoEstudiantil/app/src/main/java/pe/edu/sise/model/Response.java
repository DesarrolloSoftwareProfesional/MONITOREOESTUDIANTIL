package pe.edu.sise.model;

/**
 * Created by Abel on 23/06/2017.
 */

public class Response {
    private boolean state;
    private String msg;

    public Response() {
    }

    public Response(boolean state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

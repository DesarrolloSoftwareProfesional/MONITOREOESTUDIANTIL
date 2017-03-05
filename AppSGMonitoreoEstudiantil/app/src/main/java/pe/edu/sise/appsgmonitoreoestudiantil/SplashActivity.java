package pe.edu.sise.appsgmonitoreoestudiantil;

import android.content.Intent;
import android.support.annotation.InterpolatorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private Timer timer;
    private final int splashTime = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        timer = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                irLogin();
            }
        };
        timer.schedule(tt,splashTime);
    }

    private void irLogin(){
        Intent inte = new Intent(this,LoginActivity.class);
        startActivity(inte);
        this.finish();
    }
}

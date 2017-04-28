package pe.edu.sise.appsgmonitoreoestudiantil;

import android.app.Activity;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class NotificandoActivity extends AppCompatActivity {
    protected Button btnNotificar;
    private NotificationManager notificacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_notificando);
        btnNotificar = (Button)findViewById(R.id.btnNotificar);
        notificacion = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        btnNotificar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                notificar(1,R.mipmap.ic_launcher_app,"Notif ME","Actividad 01 Pendiente");
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void notificar(int id, int iconid, String titulo, String contenido)
    {
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                    .setSmallIcon(iconid)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_app))
                    .setContentTitle(titulo)
                    .setContentText(contenido)
                    .setColor(getResources().getColor(R.color.colorAccent,null));

        notificacion.notify(id,builder.build());
    }





}

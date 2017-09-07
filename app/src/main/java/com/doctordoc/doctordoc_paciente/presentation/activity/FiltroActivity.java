package com.doctordoc.doctordoc_paciente.presentation.activity;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.doctordoc.doctordoc_paciente.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;

public class FiltroActivity extends AppCompatActivity {


    private SearchableSpinner spnEspecialidad, spnClinica;
    private Button btnPublica;
    private int NOTIFICATION_ID = 465023;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);

        spnEspecialidad = (SearchableSpinner) findViewById(R.id.spn_especialidad);
        spnClinica = (SearchableSpinner) findViewById(R.id.spn_clinica);

        btnPublica = (Button) findViewById(R.id.btn_publicar);

        btnPublica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });

        List<String> especialidad = new ArrayList<>();
        especialidad.add("Oftalmología");
        especialidad.add("Pediatría");
        especialidad.add("Odontología");
        especialidad.add("Gastroenterología");
        especialidad.add("Psicología");

        List<String> clinica = new ArrayList<>();
        clinica.add("Clinica San Pablo");
        clinica.add("Clinica San Felipe");
        clinica.add("Clinica La Luz");
        clinica.add("Clinica Montefiori");
        clinica.add("Clinica Limatambo");
        clinica.add("Clinica Peruano-Japonesa");


        spnClinica.setTitle("Selecciona una clínica");
        spnClinica.setPositiveButton("OK");

        spnEspecialidad.setTitle("Selecciona una especialidad");
        spnEspecialidad.setPositiveButton("OK");

        ArrayAdapter<String> deporteAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, especialidad);
        deporteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnEspecialidad.setAdapter(deporteAdapter);

        ArrayAdapter<String> lugaresAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, clinica);
        lugaresAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnClinica.setAdapter(lugaresAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void notification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext());

        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setContentTitle(getBaseContext().getString(R.string.app_name));
        String text = "Hoy partido de basket a las 10:00 AM ¿Te Apuntas?";
        builder.setContentText(text);

        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(notificationSound);
        builder.setAutoCancel(true);

        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        android.support.v4.app.TaskStackBuilder stackBuilder = android.support.v4.app.TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(notificationIntent);
        stackBuilder.addNextIntent(new Intent());

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        Notification notification = builder.build();
        NotificationManagerCompat.from(getBaseContext()).notify(NOTIFICATION_ID + 3, notification);
    }

}

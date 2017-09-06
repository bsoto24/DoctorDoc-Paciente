package com.doctordoc.doctordoc_paciente.presentation.activity;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.doctordoc.doctordoc_paciente.R;
import com.doctordoc.doctordoc_paciente.presentation.fragment.LocaleFragment;
import com.doctordoc.doctordoc_paciente.util.ActivityUtils;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private int NOTIFICATION_ID = 465023;
    private Button btnBuscar;
    private LinearLayout lyBuscar;
    private int buscar = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToolbar("DOCTOR DOC +", false);

        btnBuscar = (Button) findViewById(R.id.btn_busqueda);
        lyBuscar=(LinearLayout) findViewById(R.id.ly_busqueda);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buscar%2!=0){
                    lyBuscar.setVisibility(View.VISIBLE);
                    btnBuscar.setText("Buscar");
                }else{
                    lyBuscar.setVisibility(View.GONE);
                    btnBuscar.setText("Busqueda Rápida");
                }
                buscar++;
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        LocaleFragment fragment = (LocaleFragment) getSupportFragmentManager().findFragmentById(R.id.body_local);
        if (fragment == null) {
            fragment = LocaleFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.body_local);
        }
    }

    public void showToolbar(String title, boolean upButton) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent = null;
        boolean flag = false;

        switch (id) {
            case R.id.nav_citas_reservadas:
                intent = new Intent(MainActivity.this, CitasActivity.class);
                flag = true;
                break;
            case R.id.nav_historial_citas:
                intent = new Intent(MainActivity.this, HistorialCitasActivity.class);
                flag = true;
                break;
            case R.id.nav_preguntas:
                intent = new Intent(MainActivity.this, PreguntasActivity.class);
                flag = true;
                break;
            case R.id.nav_configurar:
                intent = new Intent(MainActivity.this, ConfiguracionActivity.class);
                flag = true;
                break;
            case R.id.nav_familiares:
                intent = new Intent(MainActivity.this, FamiliaresActivity.class);
                flag = true;
                break;
            case R.id.nav_recetas:
                intent = new Intent(MainActivity.this, ConfiguracionActivity.class);
                flag = true;
                break;
            case R.id.nav_acerca_de:
                intent = new Intent(MainActivity.this, AboutActivity.class);
                flag = true;
                break;

            case R.id.nav_salir:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                flag = true;
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        if(flag){
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

        return false;
    }

    private void notification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext());

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle(getBaseContext().getString(R.string.app_name));
        String text = getBaseContext().getString(R.string.notify_message);
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


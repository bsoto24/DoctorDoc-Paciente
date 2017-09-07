package com.doctordoc.doctordoc_paciente.presentation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.doctordoc.doctordoc_paciente.R;
import com.doctordoc.doctordoc_paciente.data.entity.Familiar;
import com.doctordoc.doctordoc_paciente.data.entity.Locale;
import com.doctordoc.doctordoc_paciente.presentation.adapter.LocaleAdapter;

import java.util.ArrayList;
import java.util.List;

public class LocalesActivity extends AppCompatActivity {

    private RecyclerView rvClinicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locales);
        showToolbar("Centros de salud", true);
        rvClinicas = (RecyclerView) findViewById(R.id.rv_clinicas);

        rvClinicas.setLayoutManager(new LinearLayoutManager(this));
        rvClinicas.setAdapter(new LocaleAdapter(getData(), this));


    }

    private List<Locale> getData() {
        List<Locale> datos = new ArrayList<>();
        datos.add(new Locale("1", "Clinica San Pablo", "Av. El Polo 789", "-12.0449916", "-77.0501434", "Lunes - Domingo", R.drawable.ricpal, R.drawable.clinicasanpablo));
        datos.add(new Locale("2", "Clinica La Luz", "Av. Arequipa 4123", "-12.0762344", "-77.0382089", "Lunes - Domingo", R.drawable.laluz, R.drawable.clinicalaluz));
        datos.add(new Locale("3", "Clinica Peruano Japonesa", "Av. San Felipe 523", "-12.0730382", "-77.0616932", "Lunes - Domingo", R.drawable.perjap, R.drawable.clinicasanpablo));
        datos.add(new Locale("4", "Clinica San Gabriel", "Av. San Felipe 523", "-12.0765599", "-77.0979977", "Lunes - Domingo", R.drawable.sangabriel, R.drawable.clinicasanpablo));
        datos.add(new Locale("5", "Clinica Good Hope", "Av. San Felipe 523", "-12.1254717", "-77.0365961", "Lunes - Domingo", R.drawable.goodhope, R.drawable.clinicasanpablo));
        datos.add(new Locale("6", "Clinica San Felipe", "Av. San Felipe 523", "-12.1048677", "-77.0292098", "Lunes - Domingo", R.drawable.sanfelipe, R.drawable.clinicasanpablo));
        datos.add(new Locale("7", "Clinica Limatambo", "Av. San Felipe 523", "-12.100644", "-77.0217077", "Lunes - Domingo", R.drawable.limatambo, R.drawable.clinicasanpablo));
        datos.add(new Locale("8", "Clinica Montefiori", "Av. San Felipe 523", "-12.0656336", "-76.9685201", "Lunes - Domingo", R.drawable.montefiori, R.drawable.clinicasanpablo));
        datos.add(new Locale("9", "Clinica Sanna", "Av. San Felipe 523", "-12.0584567", "-77.1119756", "Lunes - Domingo", R.drawable.sanna, R.drawable.clinicasanpablo));
        return datos;
    }


    public void showToolbar(String title, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

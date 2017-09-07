package com.doctordoc.doctordoc_paciente.presentation.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.doctordoc.doctordoc_paciente.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;

public class CrearEventoActivity extends AppCompatActivity {

    private SearchableSpinner spnClinicas, spnEspecialidades, spnDistrito;
    private Button btnPublica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_evento);
        showToolbar("Reserve una cita", true);

        spnClinicas = (SearchableSpinner) findViewById(R.id.spn_clinica);
        spnEspecialidades = (SearchableSpinner) findViewById(R.id.spn_especialidad);
        spnDistrito= (SearchableSpinner) findViewById(R.id.spn_distritos);

        btnPublica = (Button) findViewById(R.id.btn_publicar);

        btnPublica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage(view, "Tu evento ha sido publicado");
            }
        });

        List<String> especialidades = new ArrayList<>();
        especialidades.add("psicologia");
        especialidades.add("gastrienterologia");
        especialidades.add("pediatria");
        especialidades.add("Good Programming");


        List<String> clinicas = new ArrayList<>();
        clinicas.add("Clinica San Pablo");
        clinicas.add("Clinica Peruano Japones");
        clinicas.add("Clinica Deportivo");
        clinicas.add("Clinica Limatambo");

        List<String> distritos = new ArrayList<>();
        clinicas.add("Lima");
        clinicas.add("Jesus Maria");
        clinicas.add("Breña");
        clinicas.add("San Isidro");
        clinicas.add("Lince");
        clinicas.add("Miraflores");

        spnEspecialidades.setTitle("Selecciona una especialidad");
        spnEspecialidades.setPositiveButton("OK");

        spnClinicas.setTitle("Selecciona una clinica");
        spnClinicas.setPositiveButton("OK");

        spnDistrito.setTitle("Selecciona un distrito");
        spnDistrito.setPositiveButton("OK");

        ArrayAdapter<String> especialidadAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, especialidades);
        especialidadAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnClinicas.setAdapter(especialidadAdapter);

        ArrayAdapter<String> clinicaAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, clinicas);
        clinicaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnEspecialidades.setAdapter(clinicaAdapter);

        ArrayAdapter<String> distritosAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, distritos);
        clinicaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDistrito.setAdapter(distritosAdapter);

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

    public void showMessage(View view, String texto) {
        final Snackbar snackbar = Snackbar.make(view, texto, Snackbar.LENGTH_INDEFINITE)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    }
                });

        //ACTION
        snackbar.setActionTextColor(getResources().getColor(R.color.colorAccent));
        View snackBarView = snackbar.getView();
        //MESSAGE
        TextView tv = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(getResources().getColor(R.color.white));

        snackbar.show();
    }
}

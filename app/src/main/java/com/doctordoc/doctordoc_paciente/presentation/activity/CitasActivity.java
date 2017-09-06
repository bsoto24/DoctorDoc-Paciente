package com.doctordoc.doctordoc_paciente.presentation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.doctordoc.doctordoc_paciente.R;
import com.doctordoc.doctordoc_paciente.data.entity.CitaTO;
import com.doctordoc.doctordoc_paciente.presentation.adapter.CitaAdapter;

import java.util.ArrayList;
import java.util.List;

public class CitasActivity extends AppCompatActivity {

    private RecyclerView rvCitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);
        showToolbar("Citas Programadas", true);

        rvCitas = (RecyclerView) findViewById(R.id.rv_citas_programadas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvCitas.setLayoutManager(llm);
        CitaAdapter adapter = new CitaAdapter(dataSet(), this);
        rvCitas.setAdapter(adapter);

    }

    public void showToolbar(String title, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    private List<CitaTO> dataSet() {
        List<CitaTO> citas = new ArrayList<>();
        citas.add(new CitaTO("Nº 001","22 AGO","9:00 AM","Greisy Arones","Consulta General"));
        citas.add(new CitaTO("Nº 002","25 AGO","11:00 AM","David Tacuchi","Consulta General"));
        citas.add(new CitaTO("Nº 003","27 AGO","6:00 PM","Alisson Cruz","Consulta General"));
        citas.add(new CitaTO("Nº 004","29 AGO","8:00 PM","Dickson Espinoza","Consulta General"));
        citas.add(new CitaTO("Nº 005","31 AGO","9:00 AM","Bryam Soto","Consulta General"));
        return citas;
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

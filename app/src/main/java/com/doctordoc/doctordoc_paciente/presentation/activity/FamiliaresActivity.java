package com.doctordoc.doctordoc_paciente.presentation.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.doctordoc.doctordoc_paciente.R;
import com.doctordoc.doctordoc_paciente.data.entity.CitaTO;
import com.doctordoc.doctordoc_paciente.data.entity.Familiar;
import com.doctordoc.doctordoc_paciente.presentation.adapter.CitaAdapter;
import com.doctordoc.doctordoc_paciente.presentation.adapter.FamiliarAdapter;

import java.util.ArrayList;
import java.util.List;

public class FamiliaresActivity extends AppCompatActivity {

    RecyclerView rvFamiliares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familiares);
        showToolbar("Mis Familiares", true);

        rvFamiliares = (RecyclerView) findViewById(R.id.rv_familiares);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvFamiliares.setLayoutManager(llm);
        FamiliarAdapter adapter = new FamiliarAdapter(dataSet(), this);
        rvFamiliares.setAdapter(adapter);

    }
    private List<Familiar> dataSet() {
        List<Familiar> familiares = new ArrayList<>();
        familiares.add(new Familiar("Diego Aldair", "Soto Ñahui", "12311234", "HIJO"));
        familiares.add(new Familiar("Monica", "Soto Ñahui", "25342342", "HIJA"));
        return familiares;
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

package com.doctordoc.doctordoc_paciente.presentation.presenter;

import android.content.Context;
import android.widget.Toast;

import com.doctordoc.doctordoc_paciente.R;
import com.doctordoc.doctordoc_paciente.data.entity.Locale;
import com.doctordoc.doctordoc_paciente.presentation.contract.LocaleContract;
import com.doctordoc.doctordoc_paciente.presentation.fragment.LocaleFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;
import java.util.List;

public class LocalePresenter implements LocaleContract {

    private GoogleMap mMap;
    private ClusterManager mClusterManager;
    private Context context;
    private LocaleFragment fragment;

    public LocalePresenter(GoogleMap mMap, Context context, LocaleFragment fragment) {
        this.mMap = mMap;
        this.context = context;
        this.fragment = fragment;
    }

    @Override
    public void mostrarLocales() {
        List<Locale> datos = new ArrayList<>();
        datos.add(new Locale("1", "Clinica Ricardo Palma", "Av. Javier Prado 1552", "-12.0906755", "-77.0203118","Lunes - Domingo", R.drawable.ricpal, R.drawable.clinicasanpablo));
        datos.add(new Locale("2", "Clinica La Luz", "Av. Arequipa 4123", "-12.0762344", "-77.0382089","Lunes - Domingo", R.drawable.laluz, R.drawable.clinicasanpablo));
        datos.add(new Locale("3", "Clinica Peruano Japonesa", "Av. San Felipe 523", "-12.0730382", "-77.0616932","Lunes - Domingo", R.drawable.perjap, R.drawable.clinicasanpablo));
        datos.add(new Locale("4", "Clinica San Gabriel", "Av. San Felipe 523", "-12.0765599", "-77.0979977","Lunes - Domingo", R.drawable.sangabriel, R.drawable.clinicasanpablo));
        datos.add(new Locale("5", "Clinica Good Hope", "Av. San Felipe 523", "-12.1254717", "-77.0365961","Lunes - Domingo", R.drawable.goodhope, R.drawable.clinicasanpablo));
        datos.add(new Locale("6", "Clinica San Felipe", "Av. San Felipe 523", "-12.1048677", "-77.0292098","Lunes - Domingo", R.drawable.sanfelipe, R.drawable.clinicasanpablo));
        datos.add(new Locale("7", "Clinica Limatambo", "Av. San Felipe 523", "-12.100644", "-77.0217077","Lunes - Domingo", R.drawable.limatambo, R.drawable.clinicasanpablo));
        datos.add(new Locale("8", "Clinica Montefiori", "Av. San Felipe 523", "-12.0656336", "-76.9685201","Lunes - Domingo", R.drawable.montefiori, R.drawable.clinicasanpablo));
        datos.add(new Locale("9", "Clinica Sanna", "Av. San Felipe 523", "-12.0584567", "-77.1119756","Lunes - Domingo", R.drawable.sanna, R.drawable.clinicasanpablo));

        showMarkers((ArrayList<Locale>) datos);
    }

    protected void showMarkers(ArrayList<Locale> items) {

        mClusterManager = new ClusterManager<Locale>(context, mMap);
        mClusterManager.setRenderer(new StoreRenderer(context, fragment, mMap, mClusterManager));
        mMap.setOnCameraChangeListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);
        mMap.setOnInfoWindowClickListener(mClusterManager);
        mClusterManager.setOnClusterClickListener(fragment);
        mClusterManager.setOnClusterItemClickListener(fragment);

        addItems(items);
        mClusterManager.cluster();
    }

    private void addItems(ArrayList<Locale> items) {
        mClusterManager.addItems(items);
    }

}

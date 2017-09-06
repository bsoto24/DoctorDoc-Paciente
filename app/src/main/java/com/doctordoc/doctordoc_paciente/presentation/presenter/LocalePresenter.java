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
        datos.add(new Locale("1","Clinica Ricardo Palma", "Av. Javier Prado 1552", "-12.0906755","-77.0203118", R.drawable.ricpal));
        datos.add(new Locale("1","Clinica La Luz", "Av. Arequipa 4123", "-12.0762344","-77.0382089", R.drawable.laluz));
        datos.add(new Locale("1","Clinica Peruano Japonesa", "Av. San Felipe 523", "-12.0730382","-77.0616932", R.drawable.perjap));

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

package com.doctordoc.doctordoc_paciente.data.entity;

import android.graphics.drawable.Drawable;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

import java.io.Serializable;

public class Locale implements ClusterItem, Serializable {

    private String localId;
    private String localNombre;
    private String localDireccion;
    private String localLatitud;
    private String localLongitud;
    private int imgLogo;

    public Locale(String localId, String localNombre, String localDireccion, String localLatitud, String localLongitud, int imgLogo) {
        this.localId = localId;
        this.localNombre = localNombre;
        this.localDireccion = localDireccion;
        this.localLatitud = localLatitud;
        this.localLongitud = localLongitud;
        this.imgLogo = imgLogo;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getLocalNombre() {
        return localNombre;
    }

    public void setLocalNombre(String localNombre) {
        this.localNombre = localNombre;
    }

    public String getLocalDireccion() {
        return localDireccion;
    }

    public void setLocalDireccion(String localDireccion) {
        this.localDireccion = localDireccion;
    }

    public String getLocalLatitud() {
        return localLatitud;
    }

    public void setLocalLatitud(String localLatitud) {
        this.localLatitud = localLatitud;
    }

    public String getLocalLongitud() {
        return localLongitud;
    }

    public void setLocalLongitud(String localLongitud) {
        this.localLongitud = localLongitud;
    }

    @Override
    public LatLng getPosition() {
        return new LatLng(Double.parseDouble(getLocalLatitud()), Double.parseDouble(getLocalLongitud()));
    }

    public int getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(int imgLogo) {
        this.imgLogo = imgLogo;
    }
}
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
    private String localHorario;
    private int imgLogo;
    private int imgFoto;

    public Locale(String localId, String localNombre, String localDireccion, String localLatitud, String localLongitud, String localHorario, int imgLogo, int imgFoto) {
        this.localId = localId;
        this.localNombre = localNombre;
        this.localDireccion = localDireccion;
        this.localLatitud = localLatitud;
        this.localLongitud = localLongitud;
        this.localHorario = localHorario;
        this.imgLogo = imgLogo;
        this.imgFoto = imgFoto;
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

    public String getLocalHorario() {
        return localHorario;
    }

    public void setLocalHorario(String localHorario) {
        this.localHorario = localHorario;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public void setImgFoto(int imgFoto) {
        this.imgFoto = imgFoto;
    }
}
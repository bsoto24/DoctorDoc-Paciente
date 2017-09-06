package com.doctordoc.doctordoc_paciente.data.entity;

/**
 * Created by Bryam Soto on 27/08/2017.
 */

public class Familiar {

    private String nombres;
    private String apellidos;

    private String documento;
    private String tipo;

    public Familiar(String nombres, String apellidos, String documento, String tipo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.tipo = tipo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

package com.sqlrest.app.request;

public class RequestAsientosTarj {
    private String cta;
    private float monto;
    private String moneda;
    private String concepto;
    private String descrAs;

    public String getCta() {
        return cta;
    }

    public void setCta(String cta) {
        this.cta = cta;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDescrAs() {
        return descrAs;
    }

    public void setDescrAs(String descrAs) {
        this.descrAs = descrAs;
    }
}

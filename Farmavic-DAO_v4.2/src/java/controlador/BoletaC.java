/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.BoletaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import modelo.Boleta;
import modelo.BoletaDetalle;

/**
 *
 * @author Jesus
 */
@Named(value = "boletaC")
@SessionScoped
public class BoletaC implements Serializable {

    private List<BoletaDetalle> listaBoletaDetalle;
    private List<BoletaDetalle> listaBoletaDetalleFinal;
    private BoletaImpl dao;
    private BoletaDetalle boletaDetalle;
    private Boleta boleta;

    public BoletaC() {
        listaBoletaDetalle = new ArrayList<>();
        listaBoletaDetalleFinal = new ArrayList<>();
        dao = new BoletaImpl();
        boletaDetalle = new BoletaDetalle();
        boleta = new Boleta();
    }

    public void agregarFila() {
        try {
            BoletaDetalle boletadet = dao.agregarFila(boletaDetalle.getMedicamento().getIDMED());
            boletadet.setIDMED(this.boletaDetalle.getMedicamento().getIDMED());
            boletadet.setCANTBODE(this.boletaDetalle.getCANTBODE());
//            boletadet.setLOTE(this.boletaDetalle.getMedicamento().getLOTMED());
            boletadet.setSUBTOT((boletadet.getMedicamento().getPRECMED() + 0.50) * this.boletaDetalle.getCANTBODE());

            this.listaBoletaDetalle.add(boletadet);
            boletaDetalle = new BoletaDetalle();
            for (BoletaDetalle boletadetalle : listaBoletaDetalle) {
                System.out.println(boletadetalle);
            }
            sumar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sumar() {
        double precioTotal = 0;
        for (BoletaDetalle boletaDetalle : listaBoletaDetalle) {
            precioTotal += boletaDetalle.getSUBTOT();
        }
        System.out.println(precioTotal);
        boleta.setIMPBOLE(precioTotal);
    }

    public void eliminarFila(BoletaDetalle v) {
        try {
            listaBoletaDetalle.remove(v);
            sumar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
     public void registrarVenta() {
        try {
            dao.registrar(boleta);
            int idven = dao.obtenerUltimoId();
            dao.registroMultiple(listaBoletaDetalle, idven);
            listaBoletaDetalle.clear();
            listar();
            boleta = new Boleta();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listar(){
        try {
            listaBoletaDetalleFinal = dao.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @PostConstruct
    public void start(){
        listar();
    }

    public List<BoletaDetalle> getListaBoletaDetalle() {
        return listaBoletaDetalle;
    }

    public void setListaBoletaDetalle(List<BoletaDetalle> listaBoletaDetalle) {
        this.listaBoletaDetalle = listaBoletaDetalle;
    }

    public List<BoletaDetalle> getListaBoletaDetalleFinal() {
        return listaBoletaDetalleFinal;
    }

    public void setListaBoletaDetalleFinal(List<BoletaDetalle> listaBoletaDetalleFinal) {
        this.listaBoletaDetalleFinal = listaBoletaDetalleFinal;
    }

    public BoletaImpl getDao() {
        return dao;
    }

    public void setDao(BoletaImpl dao) {
        this.dao = dao;
    }

    public BoletaDetalle getBoletaDetalle() {
        return boletaDetalle;
    }

    public void setBoletaDetalle(BoletaDetalle boletaDetalle) {
        this.boletaDetalle = boletaDetalle;
    }

    public Boleta getBoleta() {
        return boleta;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }

}

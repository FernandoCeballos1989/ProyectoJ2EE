/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernandoceballos.J2EEGIT.Entity;

/**
 *
 * @author Fernando ceballos <fernandoceballos1989@gmail.com>
 */
public class Juegos {
    
    private Integer idJuego;
    private String tituloJuego;
    private String plataformaJuego;
    private String generoJuego;
    private String estudioJuego;
    private Float rateJuego;
    private String portadaJuego;

    public Juegos(Integer idJuego, String tituloJuego, String plataformaJuego, String generoJuego, String estudioJuego, Float rateJuego, String portadaJuego) {
        this.idJuego = idJuego;
        this.tituloJuego = tituloJuego;
        this.plataformaJuego = plataformaJuego;
        this.generoJuego = generoJuego;
        this.estudioJuego = estudioJuego;
        this.rateJuego = rateJuego;
        this.portadaJuego = portadaJuego;
    }

    public Juegos(String tituloJuego, String plataformaJuego, String generoJuego, String estudioJuego, Float rateJuego, String portadaJuego) {
        this.tituloJuego = tituloJuego;
        this.plataformaJuego = plataformaJuego;
        this.generoJuego = generoJuego;
        this.estudioJuego = estudioJuego;
        this.rateJuego = rateJuego;
        this.portadaJuego = portadaJuego;
    }

    public Juegos() {
    }

    
    
    public Integer getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public String getTituloJuego() {
        return tituloJuego;
    }

    public void setTituloJuego(String tituloJuego) {
        this.tituloJuego = tituloJuego;
    }

    public String getPlataformaJuego() {
        return plataformaJuego;
    }

    public void setPlataformaJuego(String plataformaJuego) {
        this.plataformaJuego = plataformaJuego;
    }

    public String getGeneroJuego() {
        return generoJuego;
    }

    public void setGeneroJuego(String generoJuego) {
        this.generoJuego = generoJuego;
    }

    public String getEstudioJuego() {
        return estudioJuego;
    }

    public void setEstudioJuego(String estudioJuego) {
        this.estudioJuego = estudioJuego;
    }

    public Float getRateJuego() {
        return rateJuego;
    }

    public void setRateJuego(Float rateJuego) {
        this.rateJuego = rateJuego;
    }

    public String getPortadaJuego() {
        return portadaJuego;
    }

    public void setPortadaJuego(String portadaJuego) {
        this.portadaJuego = portadaJuego;
    }

    @Override
    public String toString() {
        return "Juegos{" + "idJuego=" + idJuego + ", tituloJuego=" + tituloJuego + ", plataformaJuego=" + plataformaJuego + ", generoJuego=" + generoJuego + ", estudioJuego=" + estudioJuego + ", rateJuego=" + rateJuego + ", portadaJuego=" + portadaJuego + '}';
    }
    
    
    
    

}

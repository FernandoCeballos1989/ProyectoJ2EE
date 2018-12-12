/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernandoceballos.J2EEGIT.Modelo;

/**
 *
 * @author Fernando ceballos <fernandoceballos1989@gmail.com>
 */
public class Usuarios {
    
    private Integer idUser;
    private String nickUser;
    private String nombreUser;
    private String emailUser;
    private String passUser;

    public Usuarios(Integer idUser, String nickUser, String nombreUser, String emailUser, String passUser) {
        this.idUser = idUser;
        this.nickUser = nickUser;
        this.nombreUser = nombreUser;
        this.emailUser = emailUser;
        this.passUser = passUser;
    }

    public Usuarios(String nickUser, String nombreUser, String emailUser, String passUser) {
        this.nickUser = nickUser;
        this.nombreUser = nombreUser;
        this.emailUser = emailUser;
        this.passUser = passUser;
    }

    public Usuarios(String nickUser, String nombreUser, String emailUser) {
        this.nickUser = nickUser;
        this.nombreUser = nombreUser;
        this.emailUser = emailUser;
    }

    public Usuarios() {
    }

    
    
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNickUser() {
        return nickUser;
    }

    public void setNickUser(String nickUser) {
        this.nickUser = nickUser;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "idUser=" + idUser + ", nickUser=" + nickUser + ", nombreUser=" + nombreUser + ", emailUser=" + emailUser + ", passUser=" + passUser + '}';
    }
    
    
    
    
    
    
}

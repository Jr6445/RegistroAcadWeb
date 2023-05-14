/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ra.registroacad.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author UFG
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByIdestudiante", query = "SELECT e FROM Estudiante e WHERE e.idestudiante = :idestudiante"),
    @NamedQuery(name = "Estudiante.findByCarnet", query = "SELECT e FROM Estudiante e WHERE e.carnet = :carnet"),
    @NamedQuery(name = "Estudiante.findByNombres", query = "SELECT e FROM Estudiante e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Estudiante.findByApellidos", query = "SELECT e FROM Estudiante e WHERE e.apellidos = :apellidos")})


public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Basic(optional = false)
    private Integer idestudiante;
    private String carnet;
    private String nombres;
    private String apellidos;
    //@OneToOne(cascade = {CascadeType.ALL})
    //@JoinColumn(name="idestudiante")
    //private Credencial credencial;
    
    @OneToMany(mappedBy="estudiante",targetEntity = Credencial.class, cascade = CascadeType.ALL)
    private List<Credencial> credencialList;
    
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    //private Collection<Credencial> credencialCollection;

    public Estudiante(String carnet, String nombres, String apellidos, List credencialList) {
        this.carnet = carnet;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.credencialList = credencialList;
    }
    
    
    
    public Estudiante() {
    }

    public Estudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Estudiante(String carnet, String nombres, String apellidos) {
        this.carnet = carnet;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    
    
    
    public Integer getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
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

    //public Collection<Credencial> getCredencialCollection() {
      //  return credencialCollection;
    //}

    //public void setCredencialCollection(Collection<Credencial> credencialCollection) {
      //  this.credencialCollection = credencialCollection;
    //}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestudiante != null ? idestudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.idestudiante == null && other.idestudiante != null) || (this.idestudiante != null && !this.idestudiante.equals(other.idestudiante))) {
            return false;
        }
        return true;
    }

    //@Override
    //public String toString() {
    //    return "Estudiante{" + "idestudiante=" + idestudiante + ", carnet=" + carnet + ", nombres=" + nombres + ", apellidos=" + apellidos + ", credencialCollection=" + credencialCollection + '}';
    //}

    public List<Credencial> getCredencialList() {
        return credencialList;
    }

    public void setCredencialList(List<Credencial> credencialList) {
        this.credencialList = credencialList;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "carnet=" + carnet + ", nombres=" + nombres + ", apellidos=" + apellidos + '}';
    }







    
    
}

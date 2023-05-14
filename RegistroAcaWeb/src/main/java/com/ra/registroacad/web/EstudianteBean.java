/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ra.registroacad.web;

import Services.EstudianteServiceImpl;
import com.ra.registroacad.domain.Estudiante;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Riveraa
 */

@Named("estudianteBean")
@RequestScoped
public class EstudianteBean {

    @Inject
    private EstudianteServiceImpl estudianteService;
    private Estudiante estudianteSeleccionado;
    List<Estudiante> estudiantes;

    public EstudianteBean(){
        
    }
    
    @PostConstruct
    public void inicializar(){
        estudiantes = estudianteService.listarEstudiantes();
        estudianteSeleccionado = new Estudiante();
        System.out.println(estudiantes);
    }
    
  public void editListener(RowEditEvent event){
    Estudiante estudiante = (Estudiante) event.getObject();
    estudianteService.modificarEstudiante(estudiante);
}

    
    //Get y set resoectuvox
    public Estudiante getEstudianteSeleccionado(){
        return estudianteSeleccionado;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public EstudianteServiceImpl getEstudianteService() {
        return estudianteService;
    }

    public void setEstudianteService(EstudianteServiceImpl estudianteService) {
        this.estudianteService = estudianteService;
    }

    
    
    
    public EstudianteBean(EstudianteServiceImpl estudianteService, Estudiante estudianteSeleccionado, List<Estudiante> estudiantes) {
        this.estudianteService = estudianteService;
        this.estudianteSeleccionado = estudianteSeleccionado;
        this.estudiantes = estudiantes;
    }
    
    
    
}

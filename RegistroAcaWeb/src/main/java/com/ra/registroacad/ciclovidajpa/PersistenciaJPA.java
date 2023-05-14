/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ra.registroacad.ciclovidajpa;

import com.ra.registroacad.domain.Credencial;
import com.ra.registroacad.domain.Estudiante;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author UFG
 */

import org.apache.logging.log4j.*;
public class PersistenciaJPA {
    
    public static void main(String[] args){
        //crearEstudianteCascada2();
        //recuperarEstudiante();
        //modificarEstudiante();
        //eliminarEstudianteCascada2();
    }
    static Logger log = LogManager.getRootLogger();
    
    

    
    

    public static void crearEstudianteCascada2() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
    EntityManager em= emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    Estudiante estudiante = new Estudiante("H12345","p12345","s123");
    em.persist(estudiante);
    em.flush();
    
    Credencial credencial = new Credencial("p123","21234565",estudiante.getIdestudiante());
    em.persist(credencial); 

    tx.commit();

    em.close();
    emf.close();

    log.debug("Objeto persistido: " + estudiante);
}

        
    
        public static void recuperarEstudiante(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        
        //inicia la transaccion
        //1. inicia la trasferencia
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        
        Estudiante estudiante = em.find(Estudiante.class, 25);
   
        Credencial credencial = em.find(Credencial.class,20);
        
       
        
        tx.commit();
        
        log.debug("Objeto recuperado: "+estudiante);
        log.debug("Objeto recuperado: "+credencial);
        em.close();           
    }
        
        
        
        
public static void modificarEstudiante(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Estudiante estudiante = em.find(Estudiante.class, 25);

        tx.commit();

        log.debug("Objeto recuperado: "+estudiante);

        Credencial credencial = em.find(Credencial.class, 20);


        estudiante.setCarnet("AV198984");
        estudiante.setNombres("Marisoles");
        estudiante.setApellidos("Avilessss");
        credencial.setUsername("sdhdsfhksd");
        credencial.setPassword("dfxkdm");



        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        tx2.commit();
        log.debug("Objeto guardado: "+estudiante);
        em.close();
    }
    
    

    
    public static void eliminarEstudianteCascada2(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
    EntityManager em = emf.createEntityManager();
    
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    
    Estudiante estudiante = em.find(Estudiante.class, 7);
    em.remove(estudiante);
    
    tx.commit();
    
    em.close();
    emf.close();
}

     
    
    
    
}

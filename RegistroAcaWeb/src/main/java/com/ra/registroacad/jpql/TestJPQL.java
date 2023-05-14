/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ra.registroacad.jpql;

import static com.ra.registroacad.ciclovidajpa.PersistenciaJPA.recuperarEstudiante;
import com.ra.registroacad.domain.Estudiante;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 *
 * @author UFG  
 */
public class TestJPQL {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String [] args){
    //metodos
    recuperarEstudiante();
    }
    
         private static void mostrarEstudiantes(List<Estudiante> estudiantes){
             for (Estudiante estudiante : estudiantes){
             log.debug(estudiante);
             }
         }
         
         public static void buscarEstudiantePorId(){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU"); 
         EntityManager em = emf.createEntityManager();
         String jpql = "select e from Estudiante e where e.idestudiante = 1";
         Estudiante estudiante = (Estudiante) em.createQuery(jpql).getSingleResult();
         log.debug(estudiante);
         }
         
         
         public static void buscarEstudiantePorIdeIn(){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
         EntityManager em = emf.createEntityManager();
         String jpql = "select e from Estudiante e where e.idestudiante in (1,2)";
         List<Estudiante> estudiantes = em.createQuery(jpql).getResultList();
         mostrarEstudiantes(estudiantes);
         }
         
         
         public static void buscarEstudiantes(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        String jpql = "select e from Estudiante e";
        List<Estudiante> estudiantes  = em.createQuery(jpql).getResultList();
        mostrarEstudiantes(estudiantes);
         }
         
         public static void buscarEstudianteNombreCarnet(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager  em = emf.createEntityManager();
        String jpql = "select e from Estudiante e where e.nombres='Mateo'";
        List<Estudiante> estudiantes  = em.createQuery(jpql).getResultList();
        mostrarEstudiantes(estudiantes);
        }
         
         public static void buscarDatosEstudiantes(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em= emf.createEntityManager();
        String jpql = "select e.carnet, e.nombres from  Estudiante e";
        Iterator iter = em.createQuery(jpql).getResultList().iterator();
        Object[] tupla = null;
        while (iter.hasNext()){
            tupla = (Object[]) iter.next();
            String carnet = (String) tupla[0];
            String nombres = (String) tupla[1];
            log.debug("Carnet: "+carnet+" Nombres: "+nombres);
            }
         }
         
         public static void obtenerEstudianteID(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em= emf.createEntityManager();
        int idEstudiante = 2;
        String jpql = "select e from Estudiante e where e.idestudiante= :id";
        Query q = em.createQuery(jpql); 
        q.setParameter("id", idEstudiante);
        Estudiante estudiante = (Estudiante) q.getSingleResult();
        log.debug(estudiante);
         }
         
         private static void clausulaLike(){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
         EntityManager em= emf.createEntityManager();
         String jpql = "select e from Estudiante e where upper(e.nombres) like (:parametro)";
         String paramString = "%ce%";
         Query q = em.createQuery(jpql);
         q.setParameter("parametro", paramString);
         List<Estudiante>  estudiante = q.getResultList();
         mostrarEstudiantes(estudiante);
         }
         
         
         
         
         
         
    
         
         
    
    
}

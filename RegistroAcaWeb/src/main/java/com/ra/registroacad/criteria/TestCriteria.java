/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ra.registroacad.criteria;

import com.ra.registroacad.domain.Estudiante;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author UFG
 */
public class TestCriteria {
    static Logger log = LogManager.getRootLogger();
    
    private static void mostrarEstudiantes(List<Estudiante> estudiantes) {
        for (Estudiante estudiante:estudiantes){
            log.debug(estudiante);
        }
    }
    private static void recuperarEstudiante(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
    EntityManager em = emf.createEntityManager();
    
    //1. con EM crear una instancia de CriteriaBulder
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    
    //2. Se crea un objeto CriteriaQuery
    CriteriaQuery<Estudiante> criteriaQuery = criteriaBuilder.createQuery(Estudiante.class);
            
    //3 se crea un objeto raiz de query
    Root<Estudiante> fromEstudiante = criteriaQuery.from(Estudiante.class);
    
    // 4 selecionamos del from
    criteriaQuery.select(fromEstudiante);
    
    //5 se crea un query tupeSafe
    TypedQuery query = em.createQuery(criteriaQuery);
    
    //6 ejecutamos la consulta
    List<Estudiante> estudiantes = query.getResultList();
    
    mostrarEstudiantes(estudiantes);
    }
    
    
    private static void recuperarPorCriterios(int idEstudiante){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePu");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Estudiante> cq = cb.createQuery(Estudiante.class);
        Root<Estudiante> fromEstudiante = cq.from(Estudiante.class);
        cq.select(fromEstudiante);
        List<Predicate> criterios = new ArrayList<Predicate>(); //creando lista de criterios
        
        //Evaluamos criterios
        Integer idEstudainte = 1;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class,"idEstudiante");
        criterios.add(cb.equal(fromEstudiante.get("idPersona"), parameter));
        if(criterios.isEmpty()){
            throw new RuntimeException("No hay criterios");//si no hay criteriuos
        }else if(criterios.size()==1){
            cq.where(criterios.get(0)); // si solo hay un criterio
        }else{
            cq.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        TypedQuery query = em.createQuery(cq);
        query.setParameter("idEstudiante", idEstudiante);
        Estudiante estudiante = (Estudiante) query.getSingleResult();
        log.debug(estudiante);
        
    }
        
    
    

    
    
    
    
}

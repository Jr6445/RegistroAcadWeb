/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import com.ra.registroacad.domain.Estudiante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author UFG
 */
@Stateless
public class EstudianteDaoImpl implements IEstudianteDao{
    
    @PersistenceContext(unitName="EstudiantePU")
    EntityManager em;

   @Override
    public List<Estudiante> buscarTodosEstudiante() {
        return em.createNamedQuery("Estudiante.findAll").getResultList();
    }
    
    @Override
    public Estudiante buscarEstudiantePorId(Estudiante estudiante) {
        return em.find(Estudiante.class, estudiante.getIdestudiante());
    }
    


    @Override
    public void insertarEstudiante(Estudiante estudiante) {
        em.persist(estudiante);
    }

    @Override
    public void modificarEstudiante(Estudiante estudiante) {
        em.merge(estudiante);
    }

    @Override
    public void borrarEstudiante(Estudiante estudiante) {
        em.remove(em.merge(estudiante));
    }

    @Override
    public Estudiante buscarEstudiantePorCarnet(Estudiante estudiante) {
        Query query = em.createQuery("from Estudiante e where e.carnet=: carnet");
        query.setParameter("carnet", estudiante.getCarnet());
        return (Estudiante) query.getSingleResult();
    }
    
    
    

    
    
    
}

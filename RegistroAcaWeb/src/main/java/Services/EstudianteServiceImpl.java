/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import com.ra.registroacad.domain.Estudiante;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Model;
//import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Riveraa
 */
//@Stateless


@Model
public class EstudianteServiceImpl implements  IEstudianteServiceLocal{

    @Inject
    private IEstudianteDao iestudianteDao;
    
    @Override
    public List<Estudiante> listarEstudiantes() {
        return iestudianteDao.buscarTodosEstudiante();
    }

    @Override
    public Estudiante buscarEstudiantePorId(Estudiante estudiante) {
        return iestudianteDao.buscarEstudiantePorId(estudiante);
    }

    @Override
    public Estudiante buscarEstudiantePorEmail(Estudiante estudiante) {
        return iestudianteDao.buscarEstudiantePorCarnet(estudiante);
    }

    @Override
    public void registrarEstudiante(Estudiante estudiante) {
        iestudianteDao.insertarEstudiante(estudiante);
    }

    @Override
    public void modificarEstudiante(Estudiante estudiante) {
        iestudianteDao.modificarEstudiante(estudiante);
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        iestudianteDao.borrarEstudiante(estudiante);
    }


    
}

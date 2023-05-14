/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import com.ra.registroacad.domain.Estudiante;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riveraa
 */
@Local
public interface IEstudianteServiceLocal {
    public List<Estudiante> listarEstudiantes();
    public Estudiante buscarEstudiantePorId(Estudiante estudiante);
    public Estudiante buscarEstudiantePorEmail(Estudiante estudiante);
    public void registrarEstudiante(Estudiante estudiante);
    public void modificarEstudiante(Estudiante estudiante);
    public void eliminarEstudiante (Estudiante estudiante);
}

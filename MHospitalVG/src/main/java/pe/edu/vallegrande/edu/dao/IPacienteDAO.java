
package pe.edu.vallegrande.edu.dao;

import java.util.List;
import pe.edu.vallegrande.model.Paciente;

public interface IPacienteDAO {
    void guardar(Paciente paciente) throws Exception; 
    void modificar(Paciente paciente) throws Exception;
    void Eliminar(int IdPaciente) throws Exception;
    List<Paciente> listarTodos() throws Exception;
    Paciente listarPorId(int IdPaciente) throws Exception;
}

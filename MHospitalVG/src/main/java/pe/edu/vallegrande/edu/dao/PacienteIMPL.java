package pe.edu.vallegrande.edu.dao;

import java.sql.PreparedStatement;
import java.util.List;
import pe.edu.vallegrande.model.Paciente;

public class PacienteIMPL extends Conexion implements IPacienteDAO {

    @Override
    public void guardar(Paciente paciente) throws Exception {
        String sql = "insert into paciente(nom,ape) values(?,?)";
        PreparedStatement ps = this.conectar().prepareStatement(sql);
    }

    @Override
    public void modificar(Paciente paciente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(int IdPaciente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Paciente> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paciente listarPorId(int IdPaciente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

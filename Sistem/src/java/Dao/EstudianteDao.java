package Dao;

import Modelo.Estudiantes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDao extends DAO {
//Registrar Estudiante

    public void RegistrarEstu(Estudiantes est) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Estudiantes (NomEstu,ApeEstu,DniEstu,DirecEstu,FecNacEstu,SexoEstu,CelEstu,CorreoEstu) values(?,?,?,?,?,?,?,?)");
            st.setString(1, est.getNombre());
            st.setString(2, est.getApellido());
            st.setString(3, est.getDNI());
            st.setString(4, est.getDireccion());
            st.setString(5, est.getFecNacEstu());
            st.setString(6, est.getSexo());
            st.setString(7, est.getCelular());
            st.setString(8, est.getCorreo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();

        }
    }
//Listar Estudiante

    public List<Estudiantes> listarEstu() throws Exception {
        List<Estudiantes> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "select * from Estudiantes";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            Estudiantes est;
            while (rs.next()) {
                est = new Estudiantes();
                est.setIdEstu(rs.getInt("idEstu"));
                est.setNombre(rs.getString("NomEstu"));
                est.setApellido(rs.getString("ApeEstu"));
                est.setDNI(rs.getString("DniEstu"));
                est.setDireccion(rs.getString("DirecEstu"));
                est.setFecNacEstu(rs.getString("FecNacEstu"));
                est.setSexo(rs.getString("SexoEstu"));
                est.setCelular(rs.getString("CelEstu"));
                est.setCorreo(rs.getString("CorreoEstu"));
                lista.add(est);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

/*public Estudiantes EstuID(Estudiantes estudiante) throws Exception {
        Estudiantes estu = null;
        ResultSet rs;
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("select NomEstu,ApeEstu,DniEstu,DirecEstu,FecNacEstu,SexoEstu,CelEstu,CorreoEstu from idEstu=?");
            st.setInt(1, estudiante.getIdEstu());
            rs = st.executeQuery();
            while (rs.next()) {
                estu = new Estudiantes();
                estu.setIdEstu(rs.getInt("idEstu"));
                estu.setNombre(rs.getString("NomEstu"));
                estu.setApellido(rs.getString("ApeEstu"));
                estu.setDNI(rs.getString("DniEstu"));
                estu.setDireccion(rs.getString("DirecEstu"));
                estu.setFecNacEstu(rs.getString("FecNacEstu"));
                estu.setSexo(rs.getString("SexoEstu"));
                estu.setCelular(rs.getString("CelEstu"));
                estu.setCorreo(rs.getString("CorreoEstu"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return estu;
    }*/

    public Estudiantes jalarDataAlumno(int cod) throws SQLException {
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "select  idEstu, NomEstu,ApeEstu,DniEstu,DirecEstu,FecNacEstu,SexoEstu,CelEstu,CorreoEstu from Estudiantes where idEstu = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            Estudiantes estu = new Estudiantes();
            rs.next();
            estu.setIdEstu(rs.getInt("idEstu"));
            estu.setNombre(rs.getString("NomEstu"));
            estu.setApellido(rs.getString("ApeEstu"));
            estu.setDNI(rs.getString("DniEstu"));
            estu.setDireccion(rs.getString("DirecEstu"));
            estu.setFecNacEstu(rs.getString("FecNacEstu"));
            estu.setSexo(rs.getString("SexoEstu"));
            estu.setCelular(rs.getString("CelEstu"));
            estu.setCorreo(rs.getString("CorreoEstu"));
            return estu;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void ModificarEstu(Estudiantes est) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("update Estudiantes set NomEstu=?,ApeEstu=?,DniEstu=?,DirecEstu=?,FecNacEstu=?,SexoEstu=?,CelEstu=?,CorreoEstu=? where idEstu=?");
            st.setString(1, est.getNombre());
            st.setString(2, est.getApellido());
            st.setString(3, est.getDNI());
            st.setString(4, est.getDireccion());
            st.setString(5, est.getFecNacEstu());
            st.setString(6, est.getSexo());
            st.setString(7, est.getCelular());
            st.setString(8, est.getCorreo());
            st.setInt(9, est.getIdEstu());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();

        }
    }

    public void EliminarEstu(Estudiantes est) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE from Estudiantes where idEstu=?");
            st.setInt(1, est.getIdEstu());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();

        }
    }
}

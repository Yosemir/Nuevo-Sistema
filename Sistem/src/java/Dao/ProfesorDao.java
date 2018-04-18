
package Dao;

import Modelo.Profesores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDao extends DAO {

    public void RegistrarProf(Profesores prof) throws Exception {
        try {
            this.Conexion();
            PreparedStatement prf = this.getCn().prepareStatement("insert into Profesores (NomProf, ApeProf, DniProf, DirecProf, FecNacProf, SexoProf, CelProf, CorreoProf, FecDeIngre,) values(?,?,?,?,?,?,?,?,?)");
            prf.setString(1, prof.getNomProf());
            prf.setString(2, prof.getApeProf());
            prf.setString(3, prof.getDniProf());
            prf.setString(4, prof.getDirecProf());
            prf.setString(5, prof.getFecNacProf());
            prf.setString(6, prof.getSexoProf());
            prf.setString(6, prof.getCelProf());
            prf.setString(7, prof.getCorreoProf());
            prf.setString(8, prof.getFecDeIngre());
           /* prf.setString(9, prof.getCursoProf());*/
            prf.executeUpdate();
        } catch (Exception e) {
        throw e;
        }finally{
            this.Cerrar();;
        }
    }
    
    public List<Profesores> listarProf () throws Exception{
        List<Profesores> listarProf;
        ResultSet rs;
        try {
            this.Conexion();
            PreparedStatement prf = this.getCn().prepareCall("select * from Profesores");
            rs = prf.executeQuery();
            listarProf = new ArrayList();
            while(rs.next()){
                Profesores prof = new Profesores();
                prof.setNomProf("NomProf");
                prof.setApeProf("ApeProf");
                prof.setDniProf("DniProf");
                prof.setDirecProf("DirecProf");
                prof.setFecNacProf("FecNacProf");
                prof.setSexoProf("SexoProf");
                prof.setCelProf("CelProf");
                prof.setCorreoProf("CorreoProf");
                prof.setFecDeIngre("FecDeIngre");
                /*prof.setCursoProf("");*/
                listarProf.add(prof);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return listarProf;
    }
    public Profesores jalarDataProfesor(int cod) throws SQLException {
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "select  idProf, NomProf,ApeProf,DniProf,DirecProf,FecNacProf,SexoProf,CelProf,CorreoProf,FecDeIngre from Estudiantes where idProf = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            Profesores prof = new Profesores();
            rs.next();
            prof.setIdProf(rs.getInt("idProf"));
            prof.setNomProf(rs.getString("NomProf"));
            prof.setApeProf(rs.getString("ApeProf"));
            prof.setDniProf(rs.getString("DniProf"));
            prof.setDirecProf(rs.getString("DirecProf"));
            prof.setFecNacProf(rs.getString("FecNacProf"));
            prof.setSexoProf(rs.getString("SexoProf"));
            prof.setCelProf(rs.getString("CelProf"));
            prof.setCorreoProf(rs.getString("CorreoProf"));
            prof.setFecDeIngre(rs.getString("FecDeIngre"));
            return prof;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void ModificarEstu(Profesores prof) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("update Profesores set NomProf=?,ApeProf=?,DniProf=?,DirecProf=?,FecNacProf=?,SexoProf=?,CelProf=?,CorreoProf=?, FecDeIngre=? where idProf=?");
            st.setString(1, prof.getNomProf());
            st.setString(2, prof.getApeProf());
            st.setString(3, prof.getDirecProf());
            st.setString(4, prof.getFecNacProf());
            st.setString(5, prof.getSexoProf());
            st.setString(6, prof.getCelProf());
            st.setString(7, prof.getCorreoProf());
            st.setString(8, prof.getFecDeIngre());
            st.setInt(9, prof.getIdProf());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();

        }
    }

    public void EliminarProf(Profesores prof) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE from Profesores where IdProf=?");
            st.setInt(1, prof.getIdProf());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();

        }
    }
}

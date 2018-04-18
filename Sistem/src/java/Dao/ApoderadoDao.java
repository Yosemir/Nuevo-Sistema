package Dao;

import Modelo.Apoderado;
import Modelo.Profesores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

public class ApoderadoDao extends DAO {

    public void RegistrarApo(Apoderado apo) throws SQLException {
        try {
            this.Conexion();
            PreparedStatement apd = this.getCn().prepareStatement("insert into Apoderado(NomApo, ApeApo, DniApo, DirecApo, CelApo, SexApo, ParenteApo)values(?,?,?,?,?,?,?)");
            apd.setString(1, apo.getNomApo());
            apd.setString(2, apo.getApeApo());
            apd.setString(3, apo.getDniApo());
            apd.setString(4, apo.getDirecApo());
            apd.setString(5, apo.getCelApo());
            apd.setString(6, apo.getSexApo());
            apd.setString(7, apo.getParenApo());

        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<Apoderado> listarApo() throws Exception {
        List<Apoderado> listarApo;
        ResultSet rs;
        try {
            this.Conexion();
            PreparedStatement apd = this.getCn().prepareCall("select * from Apoderado");
            rs = apd.executeQuery();
            listarApo = new ArrayList();
            while (rs.next()) {
                Apoderado apode = new Apoderado();
                apode.setNomApo(rs.getString("NomApo"));
                apode.setApeApo(rs.getString("ApeApo"));
                apode.setDniApo(rs.getString("DniApo"));
                apode.setDirecApo(rs.getString("DirecApo"));
                apode.setCelApo(rs.getString("CelApo"));
                apode.setSexApo(rs.getString("SexApo"));
                apode.setParenApo(rs.getString("ParenteApo"));
                listarApo.add(apode);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listarApo;
    }
    
    
    public Apoderado jalarDataApoderado (int cod) throws SQLException {
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "select  idEstu, NomEstu,ApeEstu,DniEstu,DirecEstu,FecNacEstu,SexoEstu,CelEstu,CorreoEstu from Estudiantes where idEstu = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            Apoderado estu = new Apoderado();
            rs.next();
            estu.setIdApo(rs.getInt("idEstu"));
            estu.setNomApo(rs.getString("NomEstu"));
            estu.setApeApo(rs.getString("ApeEstu"));
            estu.setDniApo(rs.getString("DniEstu"));
            estu.setDirecApo(rs.getString("DirecEstu"));
            estu.setFecNacApo(rs.getString("FecNacEstu"));
            estu.setSexApo(rs.getString("SexoEstu"));
            estu.setCelApo(rs.getString("CelEstu"));
            estu.setCorreoApo(rs.getString("CorreoEstu"));
            return estu;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void ModificarApo(Apoderado apo) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("update Estudiantes set NomEstu=?,ApeEstu=?,DniEstu=?,DirecEstu=?,FecNacEstu=?,SexoEstu=?,CelEstu=?,CorreoEstu=? where idEstu=?");
            st.setString(1, apo.getNomApo());
            st.setString(2, apo.getApeApo());
            st.setString(3, apo.getDniApo());
            st.setString(4, apo.getDirecApo());
            st.setString(5, apo.getCorreoApo());
            st.setString(6, apo.getFecNacApo());
            st.setString(7, apo.getSexApo());
            st.setString(8, apo.getCelApo());
            st.setInt(9, apo.getIdApo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();

        }
    }

    public void EliminarApo(Apoderado apo) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE from Estudiantes where idEstu=?");
            st.setInt(1, apo.getIdApo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();

        }
    }
    
}

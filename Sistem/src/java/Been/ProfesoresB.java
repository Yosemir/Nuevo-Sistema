package Been;

import Dao.ProfesorDao;
import Modelo.Profesores;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ProfesoresB {

    private Profesores profesores = new Profesores();
    private List<Profesores> lstProfesores;
    private Profesores selectP;

    public Profesores getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesores profesores) {
        this.profesores = profesores;
    }

    public void registrarProf() throws Exception {
        ProfesorDao dao;
        try {
            dao = new ProfesorDao();
            dao.RegistrarProf(profesores);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarProf() throws Exception {
        ProfesorDao dao;
        try {
            dao = new ProfesorDao();
            lstProfesores = dao.listarProf();
        } catch (Exception e) {
            throw e;
        }
    }

    public void jalarDataProfesor(int cod) throws Exception {
        ProfesorDao dao;
        try {
            dao = new ProfesorDao();
            selectP = dao.jalarDataProfesor(cod);
        } catch (SQLException e) {
            throw e;
        }
    }

    public void modificarEstu() throws Exception {
        ProfesorDao dao;
        try {
            dao = new ProfesorDao();
            dao.ModificarEstu(selectP);
            this.listarProf();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void EliminarProfesor(Profesores prof) throws Exception {
        ProfesorDao dao;
        try {
            dao = new ProfesorDao();
            dao.EliminarProf(prof);
            this.listarProf();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminar"));
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Profesores> getLstProfesores() {
        return lstProfesores;
    }

    public void setLstProfesores(List<Profesores> lstProfesores) {
        this.lstProfesores = lstProfesores;
    }
}

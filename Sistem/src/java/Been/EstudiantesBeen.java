package Been;

import Dao.EstudianteDao;
import Modelo.Estudiantes;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class EstudiantesBeen {

    private Estudiantes estudiante = new Estudiantes();
    private List<Estudiantes> listarEstudiantes;
    private Estudiantes select;

    @PostConstruct
    public void inicio() {
        try {
            listarEstu();
        } catch (Exception ex) {
            Logger.getLogger(EstudiantesBeen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Estudiantes getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiantes persona) {
        this.estudiante = persona;
    }

    public Estudiantes getSelect() {
        return select;
    }

    public void setSelect(Estudiantes select) {
        this.select = select;
    }

    public void registrarEstu() throws Exception {
        EstudianteDao dao;
        try {
            dao = new EstudianteDao();
            dao.RegistrarEstu(estudiante);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarEstu() throws Exception {
        EstudianteDao dao;
        try {
            dao = new EstudianteDao();
            listarEstudiantes = dao.listarEstu();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Estudiantes> getListarEstudiante() {
        return listarEstudiantes;
    }

    public void setListarEstudiante(List<Estudiantes> ListarEstudiante) {
        this.listarEstudiantes = ListarEstudiante;
    }

    /*public void EstuID(Estudiantes estudiante) throws Exception {
        EstudianteDao dao;
        Estudiantes tmp;
        try {
            dao = new EstudianteDao();
            tmp = dao.EstuID(estudiante);
            if (tmp != null) {
                this.estudiante = tmp;
            }
        } catch (Exception e) {
            throw e;
        }
    }*/
    public void jalarDataAlumno(int cod) throws Exception {
        EstudianteDao dao;
        try {
            dao = new EstudianteDao();
            select = dao.jalarDataAlumno(cod);
        } catch (SQLException e) {
            throw e;
        }
}
    public void modificarEstu() throws Exception {
        EstudianteDao dao;
        try {
            dao = new EstudianteDao();
            dao.ModificarEstu(select);
            this.listarEstu();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado"));
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
        public void EliminarEstu(Estudiantes estu) throws Exception {
        EstudianteDao dao;
        try {
            dao = new EstudianteDao();
            dao.EliminarEstu(estu);
            this.listarEstu();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminar"));
        } catch (Exception e) {
            throw e;
        }
    }

}

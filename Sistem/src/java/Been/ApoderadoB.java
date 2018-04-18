package Been;

import Dao.ApoderadoDao;
import Dao.EstudianteDao;
import Modelo.Apoderado;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ApoderadoB {

    private Apoderado apoderado = new Apoderado();
    private List<Apoderado> lstApoderado;
    private Apoderado Select2;

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    public Apoderado getSelect2() {
        return Select2;
    }

    public void setSelect2(Apoderado Select2) {
        this.Select2 = Select2;
    }

    
    public void registrarApo() throws Exception {
        ApoderadoDao dao;
        try {
            dao = new ApoderadoDao();
            dao.RegistrarApo(apoderado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listaApo() throws Exception {
        ApoderadoDao dao;
        try {
            dao = new ApoderadoDao();
            lstApoderado = dao.listarApo();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void jalarDataApoderado(int cod) throws Exception {
        ApoderadoDao dao;
        try {
            dao = new ApoderadoDao();
            Select2 = dao.jalarDataApoderado(cod);
        } catch (SQLException e) {
            throw e;
        }
}
    public void modificarApo() throws Exception {
        ApoderadoDao dao;
        try {
            dao = new ApoderadoDao();
            dao.ModificarApo(Select2);
            this.listaApo();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado"));
        } catch (Exception e) {
            throw e;
        }
    }
    
     public void EliminarApo(Apoderado Apo) throws Exception {
        ApoderadoDao dao;
        try {
            dao = new ApoderadoDao();
            dao.EliminarApo(Apo);
            this.listaApo();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminar"));
        } catch (Exception e) {
            throw e;
        }
     }

    public List<Apoderado> getLstApoderado() {
        return lstApoderado;
    }

    public void setLstApoderado(List<Apoderado> lstApoderado) {
        this.lstApoderado = lstApoderado;
    }

}

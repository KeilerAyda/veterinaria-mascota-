package managedBean;

import Dao.MascotaDao;
import entidades.Mascota;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@ViewScoped

public class MascotaBean {
    //Stributos 

    private Mascota mascota;

    /**
     * Creates a new instance of MascotaBean
     */
    public MascotaBean() {
        this.mascota = new Mascota();
    }

    public String guardar() {
        MascotaDao dao = new MascotaDao();
        boolean respuesta = dao.guardarMascota(mascota);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "asdsd", "qweqwe"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/index";

    }

    public String actualizarMascota() {

        MascotaDao mascotadao = new MascotaDao();
        boolean respuesta = mascotadao.actualizar(mascota);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "asdsd", "qweqwe"));

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }

        return "/index";
    }

    public ArrayList<Mascota> listar() {
        ArrayList<Mascota> milista = new ArrayList<>();
        MascotaDao dao = new MascotaDao();
        milista = dao.listarMascota();
        return milista;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public String limpiar() {
        return "/index.xhtml";

    }

    public String eliminar(Mascota mascotas) {
        MascotaDao DAO = new MascotaDao();
        boolean respuesta = DAO.eliminar(mascotas);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "asdsd", "qweqwe"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/index";

    }
}

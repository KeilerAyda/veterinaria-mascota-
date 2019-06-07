
package interfaces;

import entidades.Mascota;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author USUARIO
 */
public interface IMascota {

    public abstract void guardarMascota(Mascota mascota);
    public abstract ArrayList<Mascota> listarMascota(Session sesion);
    public abstract boolean actualizar(Mascota mascota);
    public abstract ArrayList<Mascota> listarRaza(Session sesion);
    public abstract ArrayList<Mascota> listarNombreMascota(Session sesion);
    public abstract Integer  contarResgistro(Session sesion);
}

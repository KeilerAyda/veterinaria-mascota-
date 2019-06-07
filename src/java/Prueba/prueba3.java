
package Prueba;

import Dao.MascotaDao;
import entidades.Mascota;
import org.hibernate.Session;

/**
 *
 * @author USUARIO
 */
public class prueba3 {

    /**
     * @param args the command line arguments
     */
    //Actualizar en la base de datos la información de una mascota.
    public static void main(String[] args) {
     MascotaDao mascotadao=new MascotaDao();
        Mascota mimascota=new Mascota(2, "peña", "martin", "pastor Aleman");
        mascotadao.actualizar( mimascota);
    }
    
}

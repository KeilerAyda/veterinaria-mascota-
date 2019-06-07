package Prueba;
import Dao.MascotaDao;
import entidades.Mascota;
/**
 *
 * @author USUARIO
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    //Listar desde la base de datos la información de todas las  mascotas.
    public static void main(String[] args) {
        MascotaDao mascotadao=new MascotaDao();
        Mascota mimascota=new Mascota(1, "mascota", "fernando", "get");
        mascotadao.guardarMascota(mimascota);
    }
    
}

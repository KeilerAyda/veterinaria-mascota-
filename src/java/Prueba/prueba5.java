package Prueba;

import Dao.MascotaDao;
import Utilitarios.HibernateUtil;
import entidades.Mascota;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author USUARIO
 */
public class prueba5 {

    //Encontrar de la base de datos la información de la mascota cuyo nombre sea: “Sandor”.
    public static void main(String[] args) {
    ArrayList<Mascota> lista = new ArrayList<>();
        
        MascotaDao mascotadao = new MascotaDao();
        Session sesion =HibernateUtil.geSessionFactory().openSession();
        lista = mascotadao.listarNombreMascota(sesion);
        
        for(Mascota mascota : lista){
            System.out.print(mascota.getNombreMascota() +"\t");
            System.out.print(mascota.getNombreCliente()+"\t");
            System.out.println(mascota.getRaza());
        }
    }
}

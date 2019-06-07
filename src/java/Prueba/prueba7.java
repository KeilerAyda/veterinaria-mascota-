package Prueba;

import Dao.MascotaDao;
import Utilitarios.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author USUARIO
 */
public class prueba7 {

    //Obtener la cantidad de mascotas registradas en la base de datos.
    public static void main(String[] args) {
      int contar;
        MascotaDao mascotadao = new MascotaDao();

        Session sesion =HibernateUtil.geSessionFactory().openSession();
        contar = mascotadao.contarResgistro(sesion);
        System.out.println("cantidad de registro :" + contar);
    }
    
}

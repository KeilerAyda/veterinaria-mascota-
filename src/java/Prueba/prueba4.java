/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class prueba4 {

 //Listar de la base de datos la información de las mascotas cuya raza sea: “Pastor Alemán”.

    public static void main(String[] args) {
   ArrayList<Mascota> lista = new ArrayList<>();

        MascotaDao mascotadao = new MascotaDao();

         Session sesions =HibernateUtil.geSessionFactory().openSession();
        lista = mascotadao.listarRaza(sesions);
        for (Mascota mascota : lista) { 
         JOptionPane.showMessageDialog(null,"ID :"+mascota.getIdMascota()+" \nNOMBRE MASCOTA: "+ mascota.getNombreMascota()+"\nNOMBRE CLIENTE: "+mascota.getNombreCliente()+"\nRAZA: "+mascota.getRaza());
       }
    }

}

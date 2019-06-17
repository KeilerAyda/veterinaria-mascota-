package Dao;

import Utilitarios.HibernateUtil;
import entidades.Mascota;
import interfaces.IMascota;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author USUARIO
 */
public class MascotaDao implements IMascota{

  @Override
    public boolean guardarMascota(Mascota mascota) {
        //Construir una nueva session y una nueva transaccion
        boolean respuesta = true;
         Session sesion =HibernateUtil.geSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        //Rgistrar en la base de datos la mascota

        try {
            sesion.save(mascota);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
        }

        sesion.close();
        return respuesta;
    }
        
    

    @Override
  public ArrayList<Mascota> listarMascota() {
        Session session =HibernateUtil.geSessionFactory().openSession();
        ArrayList<Mascota> milista = new ArrayList<>();
        Query query = session.createQuery("from Mascota");
        milista = (ArrayList<Mascota>)query.list();
        return milista;
    }

    @Override
    public boolean actualizar(Mascota mascota) {
        boolean respuesta=true;
        Session session =HibernateUtil.geSessionFactory().openSession();
         Transaction transaction=session.beginTransaction();
          try{
              session.update(mascota);
              transaction.commit();
          }catch(Exception e){
              respuesta=false;
          }
          session.close();
          return respuesta;
    }

    @Override
    public ArrayList<Mascota> listarRaza(Session sesion) {
         String hql = " from Mascota where raza='pastor Aleman'";        
        Query query = sesion.createQuery(hql);
        List< Mascota > lista= (List< Mascota >) query.list();
	return (ArrayList<Mascota>) lista;

    }

    @Override
    public ArrayList<Mascota> listarNombreMascota(Session sesion) {
        String hql = " from Mascota where nombreMascota='Sandor'";        
        Query query = sesion.createQuery(hql);
        List< Mascota > lista= (List< Mascota >) query.list();
	return (ArrayList<Mascota>) lista;
    }

    @Override
    public Integer contarResgistro(Session sesion) {
        String hql = "select count(*) from Mascota";
        Query query = sesion.createQuery(hql);
        Long FilasTab=(Long) query.uniqueResult();
        Integer cont=FilasTab.intValue();
        return cont;
        
    }

  @Override
   public boolean eliminar(Mascota mascota) {
      boolean respuesta=true;
       Session sesion =HibernateUtil.geSessionFactory().openSession();
     Transaction transaction=sesion.beginTransaction();
      try{
          sesion.delete(mascota);
          transaction.commit();
      }catch(Exception E){
          respuesta=false;
      }
      sesion.close();
      return respuesta;
    }
}


   
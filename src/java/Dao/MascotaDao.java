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
    public void guardarMascota(Mascota mascota) {
        //construir una nueva session y una nueva transaction
        
        Session session =HibernateUtil.geSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        //Registar en la base de datos de mascota
        try {
            session.save(mascota);
             transaction.commit();
        } catch (Exception e) {
            
        }
       
        session.close();
        
    }

    @Override
    public ArrayList<Mascota> listarMascota(Session sesion) {
          ArrayList<Mascota> milista=new ArrayList<>();
        Query query=sesion.createQuery("FROM Mascota");
        //ejecutar la consulta y obtener la listas
        milista=(ArrayList<Mascota>) query.list();
        return milista;
    }

    @Override
    public boolean actualizar(Mascota mascota) {
        Session session =HibernateUtil.geSessionFactory().openSession();
         Transaction transaction=session.beginTransaction();
          boolean update=false;
          int res = 0;
        session.update(mascota);
         if(res==1){
                 update=true; 
              }
          transaction.commit();
        session.close();
         
     return update;
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

  
    }


   
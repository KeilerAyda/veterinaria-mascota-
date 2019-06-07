
package managedBean;

import Dao.MascotaDao;
import entidades.Mascota;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
        this.mascota=new Mascota();
          }
  
    
     public void guardarMascota(){
 
    
         try {
              MascotaDao mascotadao= new MascotaDao ();
              mascotadao.guardarMascota(mascota);
         } catch (Exception e) {
             System.out.println("error"+e);
         }
         
     }
     public boolean actualizarMascota(Mascota mascota){
  
      boolean respuesta = true;
         try {
        MascotaDao mascotadao= new MascotaDao ();
        mascotadao.actualizar(mascota);
         } catch (Exception e) {
            respuesta = false; 
         }
       return respuesta;
     }
      public ArrayList<Mascota> listarMascota(){
      ArrayList<Mascota> lista = new ArrayList<>();
      MascotaDao mascotadao= new MascotaDao ();
    // lista = mascotadao.listarMascota(session);
     return lista;
  }
        
        public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

}   


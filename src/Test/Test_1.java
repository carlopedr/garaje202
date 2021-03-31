/*
 * Esta clase tiene por objeto incluir el método main
 * para iniciar laaplicación
 */
package Test;

import Modelo.Propietario;
import Modelo.Vehiculo;
import dao.VehiculoDAO;
import dao.VehiculoDAOMongo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Test_1 {
     public static void main(String[] args) {
        /*Propietario p = new Propietario(1003456873, "Carolina Perez", "cperez@gmail.com");
        Vehiculo v = new Vehiculo("MQA987", "Audi", "Plata", p, 2020);
        VehiculoDAOMongo vDAOMongo = new VehiculoDAOMongo();
        vDAOMongo.insertarVehiculo(v);
        Vehiculo v2 = new Vehiculo("HMZ54R", "AKT", "Negro", p, 2018);
        vDAOMongo.insertarVehiculo(v2);
        */
      /*  VehiculoDAOMongo vDAOM1 = new VehiculoDAOMongo();
         try {
             Vehiculo v1 = vDAOM1.obtenerVehiculo("JMZ56E");
             System.out.println(v1.toString());
             //v1.setMarca("Honda");
             //v1.setColors("Pink");
             //v1.setModelo(2021);
             //vDAOM1.actualizarVehiculo(v1);
             vDAOM1.eliminarVehiculo(v1);
         } catch (Exception e) {
             System.out.println("Vehiculo no existe");
             System.out.println(e.toString());
         }
     */    
        
    /*
    //Propietario p = new Propietario(5698, "AA", "aa@gmail.com");
    //    Vehiculo v = new Vehiculo("ZJY866", "QQ", "Azul", p, 2019);
    //   VehiculoDAO vDAO = new VehiculoDAO();
    //  vDAO.insertarVehiculo(v);
        VehiculoDAO vDAO = new VehiculoDAO();
        List<Vehiculo> list = vDAO.obtenerVehiculos();
        Iterator<Vehiculo> iter = list.iterator();
        Vehiculo v = null;
        while (iter.hasNext()) {
            v = iter.next();
    //        //System.out.println(per.getNombre());
            System.out.println(v.toString());
        }
    VehiculoDAO vDAO = new VehiculoDAO();
         try {
             Vehiculo v1 = vDAO.obtenerVehiculo("JY866");
             System.out.println(v1.toString());
         } catch (Exception e) {
             System.out.println("Vehiculo no existe");
         }
*/
    VehiculoDAOMongo vDAO = new VehiculoDAOMongo();
        List<Vehiculo> list = vDAO.obtenerVehiculos();
        Iterator<Vehiculo> iter = list.iterator();
        Vehiculo v = null;
        while (iter.hasNext()) {
            v = iter.next();
    //        //System.out.println(per.getNombre());
            System.out.println(v.toString());
        }
     }
}


/*
 * Esta clase tiene por objeto incluir el método main
 * para iniciar laaplicación
 */
package Test;

import Modelo.Propietario;
import Modelo.Vehiculo;
import dao.VehiculoDAO;
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
public class Test {
     public static void main(String[] args) {
        /*Propietario p = new Propietario(5698, "AA", "aa@gmail.com");
        Vehiculo v = new Vehiculo("JMZ56E", "Yamaha", "Negro", p, 2018);
        VehiculoDAO vDAO = new VehiculoDAO();
        vDAO.insertarVehiculo(v);
        Vehiculo v1 = vDAO.obtenerVehiculo("JMZ56E");
        String csvFile = "datos/Vehiculos.dat";
        BufferedReader br = null;
        String line = "";
//Se define separador ","
        String csvSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(csvSplitBy);
                //Imprime datos.
                System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4] );
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
    //Propietario p = new Propietario(5698, "AA", "aa@gmail.com");
    //    Vehiculo v = new Vehiculo("ZJY866", "QQ", "Azul", p, 2019);
    //   VehiculoDAO vDAO = new VehiculoDAO();
    //  vDAO.insertarVehiculo(v);
    //    VehiculoDAO vDAO = new VehiculoDAO();
    //    List<Vehiculo> list = vDAO.obtenerVehiculos();
    //    Iterator<Vehiculo> iter = list.iterator();
    //    Vehiculo v = null;
    //    while (iter.hasNext()) {
    //        v = iter.next();
    //        //System.out.println(per.getNombre());
    //        System.out.println(v.toString());
    //    }
    VehiculoDAO vDAO = new VehiculoDAO();
         try {
             Vehiculo v1 = vDAO.obtenerVehiculo("JY866");
             System.out.println(v1.toString());
         } catch (Exception e) {
             System.out.println("Vehiculo no existe");
         }
     }
}



/*
 * Esta clase tiene por objeto incluir el método main
 * para iniciar laaplicación
 */
package Test;

import Modelo.Propietario;
import Modelo.Vehiculo;
import dao.VehiculoDAO;

/**
 *
 * @author Usuario
 */
public class Test {
     public static void main(String[] args) {
         Propietario p = new Propietario(79,"CP","cp@gmail.com");
         Vehiculo v = new Vehiculo("ABC234","Renault","Azul",p,2021);
         VehiculoDAO vDAO = new VehiculoDAO();
         vDAO.insertarVehiculo(v);
     }
    
}

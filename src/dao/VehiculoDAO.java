/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import Modelo.Vehiculo;
import iDAO.IVehiculoDAO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class VehiculoDAO implements IVehiculoDAO{
    //declaración de métodos para acceder a los datos

    public VehiculoDAO() {
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vehiculo obtenerVehiculo(String placa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertarVehiculo(Vehiculo vehiculo) {
        //Archivo en este caso carpeta datos
        FileWriter flwriter = null;
        try {
            //crea el flujo para escribir en el archivo
            //File file = new File("datos/Vehiculos.dat");
            flwriter = new FileWriter("datos/Vehiculos.dat",true);
            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            //escribe los datos en el archivo
            bfwriter.newLine();
            bfwriter.write(vehiculo.getPlaca() + "," + vehiculo.getMarca()
                    + "," + vehiculo.getColor() + "," + vehiculo.getPropietario()
                    + "," + vehiculo.getModelo());
            //cierra el buffer intermedio
            bfwriter.flush();
            System.out.println("Registro creado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }

    @Override
    public void actualizarVehiculo(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarVehiculo(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //declaración de métodos para acceder a los datos

}

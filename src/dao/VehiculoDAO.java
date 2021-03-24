/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import Modelo.Propietario;
import Modelo.Vehiculo;
import iDAO.IVehiculoDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
        ArrayList<Vehiculo> lv = new ArrayList();
        String csvFile = "datos/Vehiculos.dat";
        BufferedReader br = null;
        String line = "";
        //Se define separador ","
        String csvSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(csvSplitBy);
                Propietario p = new Propietario(5698, "AA", "aa@gmail.com");
                Vehiculo v = new Vehiculo(datos[0],datos[1],datos[2],p,Integer.parseInt(datos[4]));
                //System.out.println(v.toString());
                lv.add(v);
                //System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4]);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        return lv;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public Vehiculo obtenerVehiculo(String placa) {
        Vehiculo vr = null;
        VehiculoDAO vDAO = new VehiculoDAO();
        List<Vehiculo> list = vDAO.obtenerVehiculos();
        Iterator<Vehiculo> iter = list.iterator();
        Vehiculo v = null;
        while (iter.hasNext()) {
            v = iter.next();
            if (placa.equals(v.getPlaca())) {
                vr = v;
            }
        }
        return vr;
    //Pendiente el manejo cuando el vehiculo buscado no existe   
    }

    public void insertarVehiculo(Vehiculo vehiculo) {
        //Archivo en este caso carpeta datos
        FileWriter flwriter = null;
        try {
            //crea el flujo para escribir en el archivo
            //File file = new File("datos/Vehiculos.dat");
            flwriter = new FileWriter("datos/Vehiculos.dat", true);
            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            //escribe los datos en el archivo
            bfwriter.newLine();
            bfwriter.write(vehiculo.getPlaca() + "," + vehiculo.getMarca()
                    + "," + vehiculo.getColors() + "," + vehiculo.getPropietario()
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

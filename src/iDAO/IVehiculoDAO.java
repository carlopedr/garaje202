/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iDAO;

import Modelo.Vehiculo;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IVehiculoDAO {
    //CRUD: Create, Read, Update, Delete
    public List<Vehiculo> obtenerVehiculos();

    public Vehiculo obtenerVehiculo(String placa);

    public void insertarVehiculo(Vehiculo vehiculo);
    
    public void actualizarVehiculo(Vehiculo vehiculo);

    public void eliminarVehiculo(Vehiculo vehiculo);
}

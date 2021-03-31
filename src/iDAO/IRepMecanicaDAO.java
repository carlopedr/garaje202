/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iDAO;

import Modelo.RepMecanica;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IRepMecanicaDAO {
     //CRUD: Create, Read, Update, Delete
    public List<RepMecanica> obtenerRepMecanicas();

    public RepMecanica obtenerRepMecanica(String placa);

    public void insertarRepMecanica(RepMecanica repmecanica);
    
    public void actualizarRepMecanica(RepMecanica repmecanica);

    public void eliminarRepMecanica(RepMecanica repmecanica);
    
}

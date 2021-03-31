/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iDAO;

import Modelo.RepLatoneria;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IRepLatoneriaDAO {
    //CRUD: Create, Read, Update, Delete
    public List<RepLatoneria> obtenerRepLatonerias();

    public RepLatoneria obtenerRepLatoneria(String placa);

    public void insertarRepLatoneria(RepLatoneria replatoneria);
    
    public void actualizarRepLatoneria(RepLatoneria replatoneria);

    public void eliminarRepLatoneria(RepLatoneria replatoneria);
}

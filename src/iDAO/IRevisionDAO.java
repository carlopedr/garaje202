/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iDAO;

import Modelo.Revision;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IRevisionDAO {
    //CRUD: Create, Read, Update, Delete
    public List<Revision> obtenerRevisiones();

    public Revision obtenerRevision(String placa);

    public void insertarRevision(Revision revision);
    
    public void actualizarRevision(Revision revision);

    public void eliminarRevision(Revision revision);
}

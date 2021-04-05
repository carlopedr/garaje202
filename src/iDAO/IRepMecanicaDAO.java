package iDAO;

import Modelo.RepMecanica;
import java.util.List;

/**
@author DUVERNEY NAVEROS COD.20201187763
        YOSSELINE CHILITO COD.20201187434
 */

public interface IRepMecanicaDAO {
     //CRUD: Create, Read, Update, Delete
    public List<RepMecanica> obtenerRepMecanicas();

    public RepMecanica obtenerRepMecanica(String placa);

    public void insertarRepMecanica(RepMecanica repmecanica);
    
    public void actualizarRepMecanica(RepMecanica repmecanica);

    public void eliminarRepMecanica(RepMecanica repmecanica);
    
}

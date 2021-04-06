/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Modelo.Propietario;
import Modelo.RepLatoneria;
import Modelo.Vehiculo;
import dao.RepLatoneriaDAO;
import dao.VehiculoDAOMongo;

/**
 *
 * @author pablo
 */
public class test_3 {

    public static void main(String[] args) {
        Propietario p = new Propietario(1187152, "pablo alexander salazar", "u20201187152@usco.edu.co");
        Vehiculo v = new Vehiculo("PAS-195", "ferrari", "rojo", p, 2014);
        VehiculoDAOMongo vDAOMongo = new VehiculoDAOMongo();

        RepLatoneria replatoneria1 = new RepLatoneria(435, "descripcion", 2, "estado", 30000, 60000, v, 8);
        RepLatoneriaDAO replatoneriadao = new RepLatoneriaDAO();

        v.setColors("blanco");

        replatoneriadao.actualizarRepLatoneria(replatoneria1);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Modelo.Propietario;
import Modelo.RepMecanica;
import Modelo.Vehiculo;
import dao.RepMecanicaDAO;
import dao.VehiculoDAOMongo;

/**
@author DUVERNEY NAVEROS COD.20201187763
        YOSSELINE CHILITO COD.20201187434
 */

public class test_2 {
    public static void main(String[] args){
        Propietario p = new Propietario(1187763, "duverney naveros gonzalez", "duvernaved16@gmail.com");
        Vehiculo v = new Vehiculo("ABC-123", "Audi", "Plata", p, 2020);
        VehiculoDAOMongo vDAOMongo = new VehiculoDAOMongo();
        //vDAOMongo.insertarVehiculo(v);
        RepMecanica repmecanica1 = new RepMecanica(123,"descripcion", 5, "estado",20000, 30000, v ,5);
        RepMecanicaDAO repmecanicadao = new RepMecanicaDAO();
        //repmecanicadao.insertarRepMecanica(repmecanica1);
        //repmecanicadao.obtenerRepMecanica("ABC-123");
        //repmecanicadao.eliminarRepMecanica(repmecanica1);
        //repmecanicadao.obtenerRepMecanicas();
        v.setColors("rojo");
        //vDAOMongo.actualizarVehiculo(v);
        repmecanicadao.actualizarRepMecanica(repmecanica1);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Vehiculo {
    private String placa;
    private String marca;
    private String colors;
    private Propietario propietario;
    private int modelo;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, String colors, Propietario propietario, int modelo) {
        this.placa = placa;
        this.marca = marca;
        this.colors = colors;
        this.propietario = propietario;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getColors() {
        return colors;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public int getModelo() {
        return modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColors(String color) {
        this.colors = color;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
    private static final Logger LOG = Logger.getLogger(Vehiculo.class.getName());

    @Override
    public String toString() {
        return "Vehiculos{" + "placa=" + placa + ", marca=" + marca + ", color=" + colors + ", propietario=" + propietario + ", modelo=" + modelo + '}';
    }
    
    
    
}

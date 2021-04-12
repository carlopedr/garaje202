/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Andres Camilo Gonzalez Velasquez
 * cod: 20201187519
 */
public class Revision extends Trabajos {
    
    private int plazo;
    double Pago;
    
    public Revision() {
    }

    public Revision(int plazo) {
        this.plazo = plazo;
    }

    public Revision( int id, String descripcion, int numHoras, String estado, int vrMaterial, double precioaCobrar, Vehiculo vehiculo,int plazo) {
        super(id, descripcion, numHoras, estado, vrMaterial, precioaCobrar, vehiculo);
        this.plazo = plazo;
    }

    
    
    public double CalcularPago(){
        precioaCobrar = precioaCobrar+200000;
        return precioaCobrar;
    }

    public double getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }
    
    
}

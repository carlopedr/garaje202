/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author PABLO ALEXANDER SALAZAR SANCHEZ 
 * CODE: 20201187152
 */
public class RepLatoneria extends Trabajos {
    //atributos
    private double plazo;

    public RepLatoneria(int id, String descripcion, int numHoras, String estado, int vrMaterial, double precioaCobrar, Vehiculo vehiculo,double plazo) {
        super(id, descripcion, numHoras, estado, vrMaterial, precioaCobrar, vehiculo);
        this.plazo=plazo;
    }
    
    //metdos
    public double CalcularPagos(){
    
        double pago = (1000+vrMaterial)*1.3;
        return pago;
    
    }
    
}

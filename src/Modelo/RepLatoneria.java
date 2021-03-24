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
    private int plazo;
    
    //metdos
    public double CalcularPagos(){
    
        double pago = (1000+vrMaterial)*1.3;
        return pago;
    
    }
    
}

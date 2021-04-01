/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * josselyne ester chilito galindez    20201187434
 */
public class RepMecanica extends Trabajos{
    
    //atributo
    
    private double plazo;
    
    //constructor 

    public RepMecanica(int id, String descripcion, int numHoras, String estado, int vrMaterial, double precioaCobrar, Vehiculo vehiculo,double plazo) {
        super(id, descripcion, numHoras, estado, vrMaterial, precioaCobrar, vehiculo);
        this.plazo=plazo;
    }
    
   
    
    
    //metodo 
   public double calcularpago(){    
   double saldo=(2000+vrMaterial)*1.1;
   return saldo;
   }
   
    
    
    
    
}

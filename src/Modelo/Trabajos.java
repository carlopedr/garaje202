/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *@author Cristian Stiven Perdomo Garcia
 * COD -- 20201188463
 */
public class Trabajos extends RegistrarTrabajos{
    public int id;
    public String descripcion;
    public int numHoras;
    public String estado;
    public int vrMaterial;
    public double precioaCobrar; //esta variable la uso en revision we, pongala para que sea el precio final pls
    //Vehiculo al cual se le realiza el trabajo
    public Vehiculo vehiculo;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras=0;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getVrMaterial() {
        return vrMaterial;
    }

    public void setVrMaterial(int vrMaterial) {
        this.vrMaterial = vrMaterial;
    }
    
 
    
    
    public void calcularIdTrabajo(){
        //Hay que buscar el la BD cual fue el ID de ultimo guardado
        //para calular el ID
        
        
    }
    
    
    public void incrementarHoras(int numHoras){
        
        
    }
    
    public void incrementarVrMaterial(int vrMaterial){
        
        
    }
}

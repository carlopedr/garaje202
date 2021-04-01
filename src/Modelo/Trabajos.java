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
    protected int id;
    protected  String descripcion;
    protected int numHoras;
    protected  String estado;
    protected  int vrMaterial;
    protected double precioaCobrar; //esta variable la uso en revision we, pongala para que sea el precio final pls
    //costructor lo necesito para repmedcanica

    public Trabajos(int id, String descripcion, int numHoras, String estado, int vrMaterial, double precioaCobrar, Vehiculo vehiculo) {
        this.id = id;
        this.descripcion = descripcion;
        this.numHoras = numHoras;
        this.estado = estado;
        this.vrMaterial = vrMaterial;
        this.precioaCobrar = precioaCobrar;
        this.vehiculo = vehiculo;
    }
    
    
    
    
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
    
 // 
    
    public void calcularIdTrabajo(){
        //Hay que buscar el la BD cual fue el ID de ultimo guardado
        //para calular el ID
        
        
    }
    
    
    public void incrementarHoras(int numHoras){
        
        
    }
    
    public void incrementarVrMaterial(int vrMaterial){
        
        
    }
}

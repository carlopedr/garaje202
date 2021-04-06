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
    
    //constructor
    public RepLatoneria(int id, String descripcion, int numHoras, String estado, int vrMaterial, double precioaCobrar, Vehiculo vehiculo,double plazo) {
        super(id, descripcion, numHoras, estado, vrMaterial, precioaCobrar, vehiculo);
        this.plazo=plazo;
    }
    
    //getters

    public double getPlazo() {
        return plazo;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public String getEstado() {
        return estado;
    }

    public int getVrMaterial() {
        return vrMaterial;
    }

    public double getPrecioaCobrar() {
        return precioaCobrar;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    //setters

    public void setPlazo(double plazo) {
        this.plazo = plazo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setVrMaterial(int vrMaterial) {
        this.vrMaterial = vrMaterial;
    }

    public void setPrecioaCobrar(double precioaCobrar) {
        this.precioaCobrar = precioaCobrar;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
    //metdos
    public double CalcularPagos(){
    
        double pago = (1000+vrMaterial)*1.3;
        return pago;
    
    }
    
}

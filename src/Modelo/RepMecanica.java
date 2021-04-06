package Modelo;

/**
 *
 * josselyne ester chilito galindez    20201187434
 */
public class RepMecanica extends Trabajos{
    
    //atributo
    
    private double plazo;
    
    //constructor 
    
    public RepMecanica() {
    }

    public RepMecanica(int id, String descripcion, int numHoras, String estado, int vrMaterial, double precioaCobrar, Vehiculo vehiculo, double plazo) {
        super(id, descripcion, numHoras, estado, vrMaterial, precioaCobrar, vehiculo);
        this.plazo=plazo;
    }
 
    //metodo 
   public double calcularpago(){    
   double saldo=(2000+vrMaterial)*1.1;
   return saldo;
   }  

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
        this.numHoras = numHoras;
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

    public double getPrecioaCobrar() {
        return precioaCobrar;
    }

    public void setPrecioaCobrar(double precioaCobrar) {
        this.precioaCobrar = precioaCobrar;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double getPlazo() {
        return plazo;
    }

    public void setPlazo(double plazo) {
        this.plazo = plazo;
    }
   
    
}

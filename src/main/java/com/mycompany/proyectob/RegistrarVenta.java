package com.mycompany.proyectob;
import java.io.Serializable;
import java.util.ArrayList;



public class RegistrarVenta implements Serializable{
    private String NombreCliente;
    private String  NIT;
    private String Direecion;
    private double total;
    private double totalsinIVA;
    private String Vendedor;
    private String Fecha;
    
    public static ArrayList<LibroVenta> LibroV = new ArrayList<>();
    public static ArrayList<LibroVenta> Reporte = ArchivoLibroVenta.CargarReporte();
    public static ArrayList<LibroVenta> LibroVendido = ArchivoLibroVenta.CargarLibroVenta();

    
    /**
     * @return the NIT
     */
    public String getNIT() {
        return NIT;
    }

    /**
     * @param NIT the NIT to set
     */
    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    /**
     * @return the NombreCliente
     */
    public String getNombreCliente() {
        return NombreCliente;
    }

    /**
     * @param NombreCliente the NombreCliente to set
     */
    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    /**
     * @return the Direecion
     */
    public String getDireecion() {
        return Direecion;
    }

    /**
     * @param Direecion the Direecion to set
     */
    public void setDireecion(String Direecion) {
        this.Direecion = Direecion;
    }


    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the Vendedor
     */
    public String getVendedor() {
        return Vendedor;
    }

    /**
     * @param Vendedor the Vendedor to set
     */
    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

    /**
     * @return the totalsinIVA
     */
    public double getTotalsinIVA() {
        return totalsinIVA;
    }

    /**
     * @param totalsinIVA the totalsinIVA to set
     */
    public void setTotalsinIVA(double totalsinIVA) {
        this.totalsinIVA = totalsinIVA;
    }

    /**
     * @return the Fecha
     */
    public String getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    
}

package com.mycompany.proyectob;
import java.io.Serializable;

public class Cupones implements Serializable{
    
    private String Codigo;
    private double Descuento;
    private String Tipo;
    private String Vencimiento;

    /**
     * @return the Codigo
     */
    public String getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    /**
     * @return the Descuento
     */
    public double getDescuento() {
        return Descuento;
    }

    /**
     * @param Descuento the Descuento to set
     */
    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    /**
     * @return the Vencimiento
     */
    public String getVencimiento() {
        return Vencimiento;
    }

    /**
     * @param Vencimiento the Vencimiento to set
     */
    public void setVencimiento(String Vencimiento) {
        this.Vencimiento = Vencimiento;
    }

    /**
     * @return the Tipo
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
}

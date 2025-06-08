package com.mycompany.proyectob;

import java.io.Serializable;


public class DireccionesVendedor implements Serializable{
    private String Calle;
    private String Avenida;
    private String Direccion;
    private String Zona;

    /**
     * @return the Calle
     */
    public String getCalle() {
        return Calle;
    }

    /**
     * @param Calle the Calle to set
     */
    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    /**
     * @return the Avenida
     */
    public String getAvenida() {
        return Avenida;
    }

    /**
     * @param Avenida the Avenida to set
     */
    public void setAvenida(String Avenida) {
        this.Avenida = Avenida;
    }

    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     * @return the Zona
     */
    public String getZona() {
        return Zona;
    }

    /**
     * @param Zona the Zona to set
     */
    public void setZona(String Zona) {
        this.Zona = Zona;
    }
}

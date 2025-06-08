package com.mycompany.proyectob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author brandon
 */
public class ArchivoDirecciones{

    private static final String FILE_NAME = "Direcciones de Vendedor.dat";

    public static void guardarDireccion(ArrayList<DireccionesVendedor> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<DireccionesVendedor> CargarDireccion() {
        ArrayList<DireccionesVendedor> lista = new ArrayList<>();
        File archivo = new File(FILE_NAME);

        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)) {
            }) {

                lista = (ArrayList<DireccionesVendedor>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

}

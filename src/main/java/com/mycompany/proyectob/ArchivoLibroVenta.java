package com.mycompany.proyectob;
import java.io.*;
import java.util.ArrayList;

public class ArchivoLibroVenta {
    private static final String FILE_NAME="LibroVenta.dat";
    
    public static void guardarCupon(ArrayList<LibroVenta> lista){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
         oos.writeObject(lista);
        } 
         catch (IOException e) {
             e.printStackTrace();
        }
    }
    
    public static ArrayList<LibroVenta> CargarCupon(){
        ArrayList<LibroVenta> lista = new ArrayList<>();
        File archivo = new File(FILE_NAME);
        
        if(archivo.exists()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)) {
            }){ 
                
                lista =(ArrayList<LibroVenta>) ois.readObject();
                
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } 
        }
        return lista;
    }     
}

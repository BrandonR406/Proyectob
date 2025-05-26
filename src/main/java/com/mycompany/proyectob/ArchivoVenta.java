package com.mycompany.proyectob;
import java.io.*;
import java.util.ArrayList;

public class ArchivoVenta {
    private static final String FILE_NAME="Ventas.dat";
    
    public static void guardarVenta(ArrayList<RegistrarVenta> lista){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
         oos.writeObject(lista);
        } 
         catch (IOException e) {
             e.printStackTrace();
        }
    }
    
    public static ArrayList<RegistrarVenta> CargarVenta(){
        ArrayList<RegistrarVenta> lista = new ArrayList<>();
        File archivo = new File(FILE_NAME);
        
        if(archivo.exists()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)) {
            }){ 
                
                lista =(ArrayList<RegistrarVenta>) ois.readObject();
                
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } 
        }
        return lista;
    } 
    
}

package com.mycompany.proyectob;
import java.io.*;
import java.util.ArrayList;


public class ArchivoCupones {
    private static final String FILE_NAME="Cupones.dat";
    
    public static void guardarCupon(ArrayList<Cupones> lista){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
         oos.writeObject(lista);
        } 
         catch (IOException e) {
             e.printStackTrace();
        }
    }
    
    public static ArrayList<Cupones> CargarCupon(){
        ArrayList<Cupones> lista = new ArrayList<>();
        File archivo = new File(FILE_NAME);
        
        if(archivo.exists()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)) {
            }){ 
                
                lista =(ArrayList<Cupones>) ois.readObject();
                
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } 
        }
        return lista;
    } 
    
}

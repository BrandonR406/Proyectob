package com.mycompany.proyectob;
import java.io.*;
import java.util.ArrayList;


public class ArchivoLibro {
    private static final String FILE_NAME="Libros.dat";
    
    public static void guardarLibro(ArrayList<Libro> lista){
        try (ObjectOutputStream Lib = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
         Lib.writeObject(lista);
        } 
         catch (IOException e) {
             e.printStackTrace();
        }
    }
    
    public static ArrayList<Libro> CargarLibro(){
        ArrayList<Libro> lista = new ArrayList<>();
        File archivo = new File(FILE_NAME);
        
        if(archivo.exists()){
            try (ObjectInputStream Lib = new ObjectInputStream(new FileInputStream(FILE_NAME)) {
            }){ 
                
                lista =(ArrayList<Libro>) Lib.readObject();
                
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } 
        }
        return lista;
    }   
    
}

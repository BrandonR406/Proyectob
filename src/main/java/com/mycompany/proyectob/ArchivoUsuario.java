package com.mycompany.proyectob;
import java.io.*;
import java.util.ArrayList;

public class ArchivoUsuario {
    private static final String FILE_NAME="Usuarios.dat";
    
    public static void guardarUsuarios(ArrayList<Usuarios> lista){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
         oos.writeObject(lista);
        } 
         catch (IOException e) {
             e.printStackTrace();
        }
    }
    
    public static ArrayList<Usuarios> CargarUsuarios(){
        ArrayList<Usuarios> lista = new ArrayList<>();
        File archivo = new File(FILE_NAME);
        
        if(archivo.exists()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)) {
            }){ 
                
                lista =(ArrayList<Usuarios>) ois.readObject();
                
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } 
        }
        return lista;
    }
    
}

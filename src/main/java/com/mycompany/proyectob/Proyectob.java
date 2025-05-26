package com.mycompany.proyectob;
import java.io.Serializable;

import java.util.ArrayList;

public class Proyectob implements Serializable{

    /**
     *
     */
    public static ArrayList<Usuarios> usuarios = //NuevoUsuario.usuarioxml;
           ArchivoUsuario.CargarUsuarios();
    public static ArrayList<Libro> Libro=
            ArchivoLibro.CargarLibro();
    public static ArrayList<Cupones> cupones=
            ArchivoCupones.CargarCupon();
    
    
    public static void main(String[] args) {
       
        Usuarios u=new Usuarios();
        u.setNombre("Administrador");
        u.setUsuario("admin");
        u.setRol(1);
        u.setPassword("admin");
        usuarios.add(u);
        
        Usuarios l=new Usuarios();
        l.setNombre("Brandon");
        l.setUsuario("Bhernandez");
        l.setRol(2);
        l.setPassword("Brandon/1");
        
        usuarios.add(l);
        
        /* Libro L=new Libro();
        L.setTitulo("El Alquimista");
        L.setAutor("Paulo Coelho");
        L.setGenero("Ficcion");
        L.setPrecio(92.50);
        L.setStock(50);
        Libro.add(L);
        Libro b=new Libro();
        b.setTitulo("Cien años de soledad");
        b.setAutor("Gabriel Garcia");
        b.setGenero("Novela");
        b.setPrecio(100);
        b.setStock(25);
        Libro.add(b);
        Libro i=new Libro();
        i.setTitulo("La sombra del viento");
        i.setAutor("Carlos Ruiz");
        i.setGenero("Drama");
        i.setPrecio(86.75);
        i.setStock(45); 
        
        Libro.add(i); */
        Login v = new Login();
        v.setVisible(true);
        
    }
}

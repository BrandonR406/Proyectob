package com.mycompany.proyectob;

import java.io.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ArchivoLibro {

    private static final String FILE_NAME = "Libros.dat";

    public static void guardarLibro(ArrayList<Libro> lista) {
        try (ObjectOutputStream Lib = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            Lib.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Libro> CargarLibro() {
        ArrayList<Libro> lista = new ArrayList<>();
        File archivo = new File(FILE_NAME);

        if (archivo.exists()) {
            try (ObjectInputStream Lib = new ObjectInputStream(new FileInputStream(FILE_NAME)) {
            }) {

                lista = (ArrayList<Libro>) Lib.readObject();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    public static void GuardarJson(ArrayList<Libro> lista) {
        
        JSONObject librosjson= new JSONObject();
        JSONArray list = new JSONArray();
        
        for(int i=0; i<lista.size();i++){
            JSONObject jsonlibro = new JSONObject();
            jsonlibro.put("Titulo", lista.get(i).getTitulo());
            jsonlibro.put("Autor", lista.get(i).getAutor());
            jsonlibro.put("Genero", lista.get(i).getGenero());
            jsonlibro.put("Precio", String.valueOf(lista.get(i).getPrecio()));
            jsonlibro.put("Stock", String.valueOf(lista.get(i).getStock()));
            list.add(jsonlibro);
            
        }
        
        librosjson.put("Libro", list);
        
        try(FileWriter file = new FileWriter("Libros.json")) {
            
            file.write(librosjson.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Libro> CargarJson() {

        ArrayList<Libro> libro = new ArrayList<>();
        File archivo = new File("Libros.json");

        if (archivo.exists()) {
            JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(new FileReader(archivo));

                JSONObject jsonlibro = (JSONObject) obj;
                JSONArray LibrosArray = (JSONArray) jsonlibro.get("Libro");

                for (int i = 0; i < LibrosArray.size(); i++) {
                    Libro L = new Libro();
                    Object ObjetoLibro = LibrosArray.get(i);
                    JSONObject Librojson = (JSONObject) ObjetoLibro;

                    L.setTitulo(Librojson.get("Titulo").toString());
                    L.setAutor(Librojson.get("Autor").toString());
                    L.setGenero(Librojson.get("Genero").toString());
                    L.setPrecio(Double.parseDouble((String) Librojson.get("Precio")));
                    L.setStock(Integer.parseInt(Librojson.get("Stock").toString()));
                    libro.add(L);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException E){
                E.printStackTrace();
            }
            catch(ParseException e){
                e.printStackTrace();
            }
        }

        return libro;

    }

}

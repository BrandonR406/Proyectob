package com.mycompany.proyectob;

import static com.mycompany.proyectob.NuevaVenta.InformeV;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ArchivoLibroVenta {

    private static final String FILE_NAME = "LibroVenta.dat";

    public static void guardarLibroVenta(ArrayList<LibroVenta> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<LibroVenta> CargarLibroVenta() {
        ArrayList<LibroVenta> lista = new ArrayList<>();
        File archivo = new File(FILE_NAME);

        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)) {
            }) {

                lista = (ArrayList<LibroVenta>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    public static ArrayList<LibroVenta> CargarReporte() {
        ArrayList<LibroVenta> venta = new ArrayList<>();
        String Informe = "Informe de Libros Vendidos.csv";
        File archivo = new File(Informe);
        FileReader fr = null;
        BufferedReader br = null;
        if (archivo.exists()) {

            try {
                fr = new FileReader(Informe);
                br = new BufferedReader(fr);

                String Linea;
                while ((Linea = br.readLine()) != null) {

                    String Libros[] = Linea.split(",");
                    if (Libros.length >= 4) {
                        LibroVenta L = new LibroVenta();
                        L.setTitulo(Libros[0]);
                        L.setPrecio(Double.parseDouble(Libros[1]));
                        L.setCantidad(Integer.parseInt(Libros[2]));
                        L.setSubtotal(Double.parseDouble(Libros[3]));
                        L.setFecha(Libros[4]);
                        venta.add(L);

                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fr != null) {
                        fr.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        return venta;
    }

    public static void GuardarReporte(ArrayList<LibroVenta> lista) {
        String Informe = "Informe de Libros Vendidos.csv";
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(Informe);
            pw = new PrintWriter(fw);

            for (LibroVenta L : lista) {
                String Linea = L.getTitulo() + "," + L.getPrecio() + "," + L.getCantidad() + "," + L.getSubtotal() + "," + L.getFecha();
                pw.println(Linea);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

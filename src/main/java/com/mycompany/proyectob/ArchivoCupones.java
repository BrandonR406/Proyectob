package com.mycompany.proyectob;

import static com.mycompany.proyectob.NuevaVenta.InformeV;
import static com.mycompany.proyectob.NuevoCupon.Cuponcsv;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ArchivoCupones {

    private static final String FILE_NAME = "Cupones.dat";

    public static void guardarCupon(ArrayList<Cupones> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Cupones> CargarCupon() {
        ArrayList<Cupones> lista = new ArrayList<>();
        File archivo = new File(FILE_NAME);

        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)) {
            }) {

                lista = (ArrayList<Cupones>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    public static ArrayList<Cupones> CargarArchivo() {
        ArrayList<Cupones> Cupon = new ArrayList<>();
        String Informe = "Cupones.csv";
        File archivo = new File(Informe);
        FileReader fr = null;
        BufferedReader br = null;
        if (archivo.exists()) {

            try {
                fr = new FileReader(Informe);
                br = new BufferedReader(fr);

                String Linea;
                while ((Linea = br.readLine()) != null) {

                    String Cupones[] = Linea.split("\\|");
                    if (Cupones.length >= 4) {
                        Cupones c = new Cupones();
                        
                        c.setCodigo(Cupones[0]);
                        c.setDescuento(Double.parseDouble(Cupones[1]));
                        c.setTipo(Cupones[2]);
                        c.setVencimiento(Cupones[3]);
                        Cupon.add(c);
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

        return Cupon;
    }

    public static void GuardarArchivo(ArrayList<Cupones> lista) {
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("Cupones.csv");
            pw = new PrintWriter(fw);

            for (Cupones c : lista) {
                String Linea = c.getCodigo() + "|" + c.getDescuento() + "|" + c.getTipo() + "|" + c.getVencimiento();
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

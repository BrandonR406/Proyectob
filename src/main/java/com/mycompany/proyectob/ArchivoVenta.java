package com.mycompany.proyectob;

import static com.mycompany.proyectob.NuevaVenta.InformeV;
import static com.mycompany.proyectob.NuevoCupon.Cuponcsv;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ArchivoVenta {

    private static final String FILE_NAME = "Ventas.dat";

    public static void guardarVenta(ArrayList<RegistrarVenta> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<RegistrarVenta> CargarVenta() {
        ArrayList<RegistrarVenta> lista = new ArrayList<>();
        File archivo = new File(FILE_NAME);

        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)) {
            }) {

                lista = (ArrayList<RegistrarVenta>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    public static ArrayList<RegistrarVenta> CargarArchivo() {
        ArrayList<RegistrarVenta> venta = new ArrayList<>();
        String Informe = "Informe de Ventas.csv";
        File archivo = new File(Informe);
        FileReader fr = null;
        BufferedReader br = null;
        if (archivo.exists()) {

            try {
                fr = new FileReader(Informe);
                br = new BufferedReader(fr);

                String Linea;
                while ((Linea = br.readLine()) != null) {

                    String ventas[] = Linea.split(",");
                    if (ventas.length >= 4) {
                        RegistrarVenta R = new RegistrarVenta();
                        R.setNombreCliente(ventas[0]);
                        R.setNIT(ventas[1]);
                        R.setDireecion(ventas[2]);
                        R.setTotal(Double.parseDouble(ventas[3]));
                        R.setTotalsinIVA(Double.parseDouble(ventas[4]));
                        R.setVendedor(ventas[5]);
                        R.setFecha(ventas[6]);
                        venta.add(R);
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

    public static void GuardarArchivo(ArrayList<RegistrarVenta> lista) {
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("Informe de Ventas.csv");
            pw = new PrintWriter(fw);

            for (RegistrarVenta R : lista) {
                String Linea = R.getNombreCliente() + "," + R.getNIT() + "," + R.getDireecion() + "," + R.getTotal() + "," + R.getTotalsinIVA() + "," + R.getVendedor() + "," + R.getFecha();
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

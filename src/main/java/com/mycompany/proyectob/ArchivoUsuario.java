package com.mycompany.proyectob;

import java.io.*;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ArchivoUsuario {

    private static final String FILE_NAME = "Usuarios.dat";

    public static void guardarUsuarios(ArrayList<Usuarios> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Usuarios> CargarUsuarios() {
        ArrayList<Usuarios> lista = new ArrayList<>();
        File archivo = new File(FILE_NAME);

        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)) {
            }) {

                lista = (ArrayList<Usuarios>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    public static ArrayList<Usuarios> leerxml() {

        ArrayList<Usuarios> lista = new ArrayList<>();
        File archivo = new File("Usuarios.xml");

        if (archivo.exists()) {
            try {

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
                Document doc = dbBuilder.parse(archivo);

                doc.getDocumentElement().normalize();

                NodeList nList = doc.getElementsByTagName("usuario");

                for (int i = 0; i < nList.getLength(); i++) {

                    Node nNode = nList.item(i);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element e = (Element) nNode;
                        Usuarios u = new Usuarios();
                        u.setNombre(e.getElementsByTagName("nombre").item(0).getTextContent());
                        u.setUsuario(e.getElementsByTagName("nombreusuario").item(0).getTextContent());
                        u.setRol(Integer.parseInt(e.getElementsByTagName("rol").item(0).getTextContent()));
                        u.setPassword(e.getElementsByTagName("password").item(0).getTextContent());

                        lista.add(u);

                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return lista;
    }

    public static void GuardarXML(ArrayList<Usuarios> lista) {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {

            fw = new FileWriter("usuarios.xml");
            pw = new PrintWriter(fw);

            pw.println("<usuarios>");

            for (Usuarios u : lista) {

                pw.println("<usuario>");

                pw.println("<nombre>" + u.getNombre() + "</nombre>");
                pw.println("<nombreusuario>" + u.getUsuario() + "</nombreusuario>");
                pw.println("<rol>" + u.getRol() + "</rol>");
                pw.println("<password>" + u.getPassword() + "</password>");

                pw.println("</usuario>");

            }

            pw.println("</usuarios>");

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

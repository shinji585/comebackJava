package manejoArchivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
public class Manejo1 {
    static Scanner s = new Scanner(System.in);
    public static void escribir(){
        // estudio de outputStream 
        try {
            FileOutputStream fo = new FileOutputStream("informacion.txt",true);

            System.out.print("Ingrese su nombre: ");
            String informacion = s.nextLine();
            
            System.out.print("Ingrese la ciudad en la que usted vive actualmente: ");
            String ciudadName = s.nextLine();
            
            System.out.print("Ingrese sus sueños: ");
            String sueños = s.nextLine();
            String sueñoCorto = sueños.substring(0, sueños.length());
            s.nextLine();
            
            String bloque = "------ Registro ------\n" +
                            "Persona nombre: " + informacion + "\n" +
                            "Ciudad de residencia: " + ciudadName + "\n" +
                            "Persona sueños: " + sueñoCorto + "\n\n";
            
            // Lo escribimos todo en el archivo
            fo.write(bloque.getBytes());
            
           fo.close();

        } catch (Exception e) {
            System.out.println("error de tipo: " + e.getLocalizedMessage());
        }
    }
    // estudio de la clase fileinputstream
    public static void leer(){
        try {
            FileInputStream fi = new FileInputStream("informacion.txt");

            // creamos un array de tipo byte 
            byte[] datos = new byte[fi.available()];

            // lee los bytes dentro de datos 
            fi.read(datos);

            // pasamos los datos una variable de tipo string 
            String informacion = new String(datos);
            System.out.println("contenido del archivo: ");
            System.out.println(informacion);
            
            fi.close();
        } catch (Exception e) {
            System.out.println("error de tipo: " + e.getLocalizedMessage());
        }
    }
    public static void main(String[] args) {
       // metodo de esctitura 
       escribir();
       // metodo de lectura 
       leer();
    }
}

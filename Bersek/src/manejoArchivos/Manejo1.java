package manejoArchivos;

import java.io.FileOutputStream;
import java.util.*;
public class Manejo1 {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        // estudio de outputStream 
        try {
            FileOutputStream fo = new FileOutputStream("informacion.txt",true);

           // capturamos informacion por el teclado
           System.out.print("ingrese su nombre: "); 
           String informacion = s.nextLine();

           // guardamos el nombre de la persona
           String personaNombre = "persona nombre: " + informacion;
           fo.write(personaNombre.getBytes());

           // capturamos la ciudad en donde la persona vive
           System.out.print("ingrese la ciudad en la que usted vive actualmente: ");
           String ciudadName = s.nextLine();

           // ahora concatenamos 
           String ciudadString = "\nCiudad de residencia: " + ciudadName;
           fo.write(ciudadString.getBytes());

           // ahora capturamos unicamete lo mas importante de un texto que tu ingreses 
           System.out.print("ingrese sus sueños: ");
           String sueños = s.nextLine();

           // calculamos la longitud minimia
           String sueñoCorto = sueños.substring(0,Math.min(11, sueños.length())); 
           // capturamos de esta forma 
           String personSueños = "\nPersona sueños: " + sueñoCorto;

           fo.write(personSueños.getBytes());
           fo.close();

        } catch (Exception e) {
            System.out.println("error de tipo: " + e.getLocalizedMessage());
        }
    }
}

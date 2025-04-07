package ejercicioMnajeoArchivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio1 {
    static Scanner s = new Scanner(System.in);
    // escribir un fichero de texto
    // para resolver este ejercicio crearemos un metodo de tipo filewrite 
    public static void escribir(){
        String texto = "texto.txt";
        try (FileWriter fl = new FileWriter(texto,true)) {

           // creamos un bufferrwriter
           BufferedWriter bw = new BufferedWriter(fl);

            System.out.print("ingrese su nombre: ");
            String nombre = s.nextLine();


            System.out.print("ingrese su edad: ");
            int edad = s.nextInt();

            String bloque = "------ Registro ------\n" +
            "Persona nombre: " + nombre + "\n" + 
            "Persona edad: "  + edad + "\n";
            
            bw.write(bloque + "\r\n");
            
            System.out.println("\nla informacion fue guardada con exito");

            // cerramos el bufferwriter 
            bw.close();
            
        } catch (Exception e) {
            System.out.println("error de tipo: " + e.getLocalizedMessage());
        }
    }
    public static void main(String[] args) {
        escribir();
    }
}

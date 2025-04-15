package MiniProyecto;
import java.util.*;

import MiniProyecto.Utiles.Utiles;

public class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        Utiles utiles = new Utiles();
        System.out.print("Ingrese la cantidad de veces que va a ingresar personas: ");
        int cantidad = s.nextInt();
        s.nextLine(); 
        
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el nombre: ");
            String nombre = s.nextLine().trim();  

            System.out.print("Ingrese la edad: ");
            while (!s.hasNextInt()) {
                System.out.println("Solo se admiten valores enteros. Intente nuevamente.");
                s.next(); 
            }
            int edad = s.nextInt();
            s.nextLine(); 

            System.out.print("Ingrese la asignatura: ");
            String asignatura = s.nextLine().trim();

            System.out.print("Ingrese la nota: ");
            while (!s.hasNextDouble()) {
                System.out.println("Solo se admiten valores decimales o enteros. Intente nuevamente.");
                s.next(); 
            }
            double nota = s.nextDouble();
            s.nextLine(); 

            utiles.escribir(asignatura, nota, nombre, edad);
        }

        System.out.println("\nLa información ingresada es la siguiente:");
        utiles.leer();
    }
}

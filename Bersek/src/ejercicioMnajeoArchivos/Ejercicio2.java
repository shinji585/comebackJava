package ejercicioMnajeoArchivos;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ejercicio2 {
    /*
     * create un fichero en el proyecto tu mismo y escribele el texto que quieras,
     * leelo con bufferedReader.
     * 
     * 
     */
    // creamos la clase de escritura de nuestro fichero
    static Scanner s = new Scanner(System.in); 
    public static void escribir(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("texto2.txt",true))) {
            System.out.print("Ingrese la cantidad de personas a registrar: ");
            int cantidad = s.nextInt();

            s.nextLine();
            for (int i = 0; i < cantidad; i++) {
                System.out.println("\n--- Persona #" + (i + 1) + " ---");
                System.out.print("Nombre: ");
                String nameString = s.nextLine();

                System.out.print("Edad: ");
                int edad = s.nextInt();

                System.out.print("Sueldo: ");
                double sueldo = s.nextDouble();

                s.nextLine(); // limpiar salto de línea

                Persona persona = new Persona(nameString, edad, sueldo);

                // escribimos cada persona en el bufferwirter 
                bw.write(persona.toString());
            }
            System.out.println("\nDatos guardados correctamente en 'texto2.txt'.");
        } catch (Exception e) {
            System.out.println("Error al guardar los datos: " + e.getLocalizedMessage());
        }
    }

    // creamos el metodo de lectura del archivo 
    public static void leer(){
        try (BufferedReader br = new BufferedReader(new FileReader("texto2.txt"))) {
            System.out.println("------ Contenido del archivo ------\n");
            String linea; 

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: "  + e.getLocalizedMessage());
        }
    }
    
    public static void main(String[] args) {
        escribir();
        System.out.println("\nMostrando los datos guardados...");
        leer();
    }
}


// creamos una clase persona 
class Persona{
    private String nombre; 
    private int  edad; 
    private double sueldo; 

    public Persona(String nombre,int edad,double sueldo){
        this.edad = edad;
        this.sueldo = sueldo;
        this.nombre = nombre;
    }

    // creamos los metodos getters y setters 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

     
    // creamos el toString 
    @Override
    public String toString(){
        return "Nombre: " + this.nombre 
        + "\r\nEdad: " + this.edad 
        + "\r\nSueldo: $" + this.sueldo + "\r\n";
    }
}

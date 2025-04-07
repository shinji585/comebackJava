package manejoArchivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import manejoArchivos.ClaseEjemplo.Ejemeplo1;


public class Manejo2 {
    // creamos el bloque que nos serializa el objecto y lo transforma a un archivo .dat
    public static void escribir(){
        try (ObjectOutputStream off = new ObjectOutputStream(new FileOutputStream("archivos.dat"))) {
            // creamos un objecto dentro de la claseejemplo 
            ClaseEjemplo ejemeplo1 = new Ejemeplo1("vaca", 4, 1500);

            // escribimos el objecto en off y lo cerramos 
            off.writeObject(ejemeplo1);
        } catch (Exception e) {
            System.out.println("error del tipo: " + e.getLocalizedMessage());
        }
    }
    
    // objectinputstream funcionamiento 
    // ahora realizamos un metodo para leer el objecoutputstream 
    public static void leer(){
        try (ObjectInputStream ffi = new ObjectInputStream(new FileInputStream("archivos.dat"))) {
            Ejemeplo1 ejemeplo1 = (Ejemeplo1) ffi.readObject();

            System.out.printf("Tipo Animal: %s\nNumero de patas: %d\nPrecio del Animal: %.2f",ejemeplo1.getAnimal(),ejemeplo1.getCantidadPatas(),ejemeplo1.getPrecio());
        } catch (Exception e) {
            System.out.println("error de tipo: " + e.getLocalizedMessage());
        }
    }
    
    
    
    public static void main(String[] args) {
        escribir();
        // se muestra la informacion 
        leer();
    }
}

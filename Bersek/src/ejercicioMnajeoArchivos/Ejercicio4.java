package ejercicioMnajeoArchivos;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ejercicio4 {
   /*
     Dado un fichero de texto con una lista de numeros, indica cual es el mayor y el menor. 
   */    
   // escribimos un metodo el cual nos crea el fichero y lo llenamos con numeros randoms
   public static void escribir(){
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("ejercicio4.txt"))) {
        // lenamos la lista 
        Random rd = new Random();
        for (int i = 0; i < rd.nextInt(150); i++) {
            int num = rd.nextInt(1000);
            bw.write(String.valueOf(num));
            bw.newLine();
        }
    } catch (Exception e) {
        System.out.println("error de tipo: " + e.getLocalizedMessage());
    }
   }

   // ahora escribimos el metodo de lectura como tal 
   public static void leer(){
    try (BufferedReader bi = new BufferedReader(new FileReader("ejercicio4.txt"))) {
        ArrayList<Integer> listaLectura = new ArrayList<>();
        String line = "";
        while ((line = bi.readLine()) != null) {
            // pasamos los datos de nuevo a una lista
            listaLectura.add(Integer.parseInt(line));
        }
        // buscamos el meaximo valor 
        int max = Collections.max(listaLectura);
        int min = Collections.min(listaLectura);
        System.out.println("el maximo valor encontrado es: " + max);
        System.out.println("el minimo valor encontrado es: " + min);
    } catch (Exception e) {
        System.out.println("error de tipo: " + e.getLocalizedMessage());
    }
   }

   // metodo principal 
   public static void main(String[] args) {
    escribir();
    // leemos 
    leer();
   }
}

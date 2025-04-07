package ejercicioMnajeoArchivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ejercicio3 {
    // create un fichero de texto tu mismo y cuenta el numero de lineas que este
    // tiene
    public static void escribir() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("texto3.txt"))) {
            String[] string = { "santiago", "sebastian", "francisco", "samuel", "martha" };

            for (String string2 : string) {
                bw.write(string2);
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("error de tipo: " + e.getLocalizedMessage());
        }
    }

    // creamos el metodo para leer y que nos cuente
    public static void leer() {
        try (BufferedReader br = new BufferedReader(new FileReader("texto3.txt"))) {
            String line;
            int con = 0;
            while ((line = br.readLine()) != null) {
                con++; 
                System.out.println(line);
            }
            System.out.println("cantidad de lineas encontradas: " + con);
        } catch (Exception e) {
            System.out.println("error de tipo: " + e.getLocalizedMessage());
        }
    }
    public static void main(String[] args) {
        // escribimos en el archivo
        escribir();
        // leemos la informacion 
        leer();
    }
}

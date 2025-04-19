package StreamEstudio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Manejo5 {
     // una diferencia pequeña pero clave 
     
     // 1 forma tradicional de leer un archivo de texto con bufferreader
    public static void leer(){
        String archivo = "mi_archivo.txt";
        File controladorArchivo = new File(archivo);
        try (BufferedReader br = new BufferedReader(new FileReader(controladorArchivo))) {
            String line; 
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("error de tipo: " + e.getLocalizedMessage());
        }
     }

    // una forma mas rapida de leer los datos 
    public static void leer2(){
       Path path = Paths.get("mi_Archivo.txt");
       try {
        Files.lines(path).forEach(line -> System.out.println(line));
       } catch (Exception e) {
        System.out.println("error de tipo: " + e.getLocalizedMessage());
       }
    }

    public static void main(String[] args) {
        String baseArchivo = "mi_Archivo.txt";
        File archivo = new File(baseArchivo);

        if (archivo.exists()){
            System.out.println("el archivo ya existe..");
        }else {
            try {
                PrintWriter escritor = new PrintWriter(new FileWriter(archivo));
                String nombre = "mariana";
                int edad = 5;
                String tipoFamilia = "Adinerada";

                List<String> lista = new ArrayList<>();
                lista.add(nombre);
                lista.add(String.valueOf(edad));
                lista.add(tipoFamilia);

                lista.forEach(e -> escritor.println(e));

                escritor.flush();
                escritor.close();
                System.out.println("se creo correctamente");
            } catch (IOException e) {
                System.out.println("error de tipo: " + e.getLocalizedMessage());
            }
        }
             System.out.println("\ndatos dentro del archivo: ");
           // leer();
           // leer2();             
    }
}

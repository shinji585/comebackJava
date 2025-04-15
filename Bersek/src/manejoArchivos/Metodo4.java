package manejoArchivos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Metodo4 {
    // ahora seguiremos practicando con bufferoutputstream and inputstream para dominar mas esta clase trataremos de clonar un pdf 
    public static void escribir(){
        String rutaPdf = "C:\\Users\\USUARIO\\Desktop\\comebackJava\\Bersek\\src\\manejoArchivos\\Horario_de_Estudio.pdf";
        String copia = "copiaPdf.pdf";
        
        // pasamos las rutas a un file 
        File ruta1 = new File(rutaPdf);
        File ruta20 = new File(copia);
        try (FileOutputStream fis = new FileOutputStream(copia);
             FileInputStream fus = new FileInputStream(rutaPdf);
             BufferedOutputStream bos = new BufferedOutputStream(fis);
             BufferedInputStream bis = new BufferedInputStream(fus)        
             ) {
            long inicio = System.currentTimeMillis();
            byte[] buffer = new byte[4096];
            int leidos; 
            while ((leidos = fus.read(buffer)) != -1) {
                bos.write(buffer, 0, leidos);
            }
            System.out.println("se ha clonado con exito");
           

            // mostramos tiempo que demoro la ejecucion 
           long fin = System.currentTimeMillis();
           System.out.println("Tiempo de copia: " + (fin-inicio) + " milisegundos");
           bos.flush();
        } catch (Exception e) {
            System.out.println("error de tipo: " + e.getLocalizedMessage());
        }
        System.out.println("cantidad de bytes del original: " + ruta1.length());
        System.out.println("cantidad de bytes de la copia: " + ruta20.length());
    }
    public static void main(String[] args) {
        escribir();
    }
}

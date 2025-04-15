package manejoArchivos;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Manejo3 {
    // estudio avanzado de la clase IO
    // ejemplo de como utilizar bufferoutputstream y como podemos clonr imagenes con este 

    public static void escribir(){
        String original = "C:\\Users\\USUARIO\\Desktop\\comebackJava\\Bersek\\src\\manejoArchivos\\Working time_.jpg";
        String copia = "copia.jpg";
        // utilizamos la clase file 
        File archivoOriginal = new File(original);
        File copiarOriginal = new File(copia);
        try (
            FileInputStream fis = new FileInputStream(original);
            FileOutputStream fos = new FileOutputStream(copia);
            BufferedOutputStream bos = new BufferedOutputStream(fos)
        ) {
            long longitud = original.length();
            byte[] buffer = new byte[(int)longitud];

            int bytesleidos;
            while ((bytesleidos = fis.read(buffer)) != -1) {
                bos.write(buffer,0,bytesleidos);
            }

            System.out.println("archivo copiado excelentemente");
            System.out.println("cantidad de bytes del original: " + archivoOriginal.length());
            System.out.println("cantidad de bytes de la copia: " + copiarOriginal.length());
        } catch (Exception e) {
            System.out.println("error de tipo: " + e.getLocalizedMessage());
        }
    }
    public static void main(String[] args) {
         escribir();
    }
}

package MiniProyecto.Utiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

import MiniProyecto.Estudiante;

public class Utiles {
    static Map<Integer,Estudiante> estudiantes = new TreeMap<>();
    // creamos el metodo de escritura y de lectura 
    public void escribir(String asignaturas,double nota,String nombre,int edad){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Estudiantes.txt",true))) {
            // creamos la instancia 
            int id = estudiantes.size() + 1;
            Estudiante estudiante = new Estudiante(asignaturas, nota, nombre, edad,id);

            // guardamos en el map 
            estudiantes.put(estudiante.getID(), estudiante);

            // escribimos en el archivo los estudiantes 
            for (Map.Entry<Integer,Estudiante> entry : estudiantes.entrySet()) {
                bw.write(entry.getKey() + ": " + entry.getValue());
                bw.newLine();
            }
            System.out.println("informacion guardada con exito");
        } catch (Exception e) {
            System.out.println("Error de tipo: " + e.getLocalizedMessage());
        }
    }

    // ahora creamos el metodo que nos permita leer el archivo que hemos creando 
    public void leer(){
        try (BufferedReader br = new BufferedReader(new FileReader("Estudiantes.txt"))) {
           Map<Integer,Estudiante> estudiantesReader = new TreeMap<>();
           
            String line; 
            while ((line = br.readLine()) != null) {
                String[] partes = line.split(": ");
                int id = Integer.parseInt(partes[0].trim());
                Estudiante estudiante = Estudiante.fromString(partes[1]);
                estudiantesReader.put(id, estudiante);
            }
            estudiantesReader.forEach((k,v) -> System.out.println(k + " -> " + v.getName() + " tiene una edad de: " + v.getEdad() + "\nSaco una nota de: " + v.getNota() + ",en la asignatura de: " +v.getAsignatura()));
        } catch (Exception e) {
            System.out.println("Error de tipo: " + e.getLocalizedMessage());
        }
    }
}

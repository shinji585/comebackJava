package com.example;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EstudioGuava {

    // Método para escribir un objeto Auto como línea JSON
    public static void escribir(Auto auto){
        String json = "autos.json";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(json, true))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String autojson = gson.toJson(auto);
            br.write(autojson);
            br.newLine(); // ← Asegura que cada objeto quede en una línea separada
            br.flush();
            System.out.println("Objeto guardado correctamente");
        } catch (Exception e) {
            System.out.println("Error de tipo: " + e.getLocalizedMessage());
        }
    }

    // Método para leer línea por línea cada Auto desde el archivo
    public static List<Auto> leer(){
        List<Auto> autos = new ArrayList<>();
        Path path = Paths.get("autos.json");
        Gson gson = new Gson();
        try (Stream<String> lineas = Files.lines(path)) {
            lineas.forEach(linea -> {
                if (!linea.trim().isEmpty()) { // ← Ignora líneas vacías (por si acaso)
                    try {
                        Auto auto = gson.fromJson(linea, Auto.class);
                        autos.add(auto);
                    } catch (Exception e) {
                        System.out.println("Línea ignorada por error: " + linea);
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("Error de tipo: " + e.getLocalizedMessage());
        }
        return autos;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de veces que va a guardar un carro: ");
        int cantidad = s.nextInt();
        s.nextLine(); // Limpia el buffer

        for (int i = 0; i < cantidad; i++) {
            System.out.printf("\n\t----- Ingrese el auto %d -----\n", (i + 1));
            System.out.print("Ingrese el nombre: ");
            String nombre = s.nextLine();

            System.out.print("Ingrese el tipo: ");
            String tipo = s.nextLine();

            System.out.print("Ingrese la cantidad de ruedas: ");
            int cantidadRuedas = s.nextInt();
            s.nextLine(); // Limpia el buffer

            Auto auto = new Auto(nombre, tipo, cantidadRuedas);
            escribir(auto);
        }

        List<Auto> autos = leer();
        System.out.println("\nLista de autos cargados desde el archivo:");
        autos.forEach(e -> {
            System.out.printf("- %s | Tipo: %s | Ruedas: %d\n", e.getNombre(), e.getTipo(), e.getCantidadRuedas());
        });
        s.close();
    }
}

// Clase Auto con getters y constructor
class Auto {
    private String nombre;
    private String tipo;
    private int cantidadRuedas;

    public Auto(String nombre, String tipo, int cantidadRuedas) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidadRuedas = cantidadRuedas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getCantidadRuedas() {
        return this.cantidadRuedas;
    }
}

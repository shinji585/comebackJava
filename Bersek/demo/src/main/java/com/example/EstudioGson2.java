package com.example;


import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class EstudioGson2 {
    public static void main(String[] args) {
        Collection<Integer> ints = Arrays.asList(1,24,58,78450);
        Gson gson = new Gson();
        // la serializacion de las collections se da de la misma forma que los otros tipos de datos 
        String json = gson.toJson(ints);
        System.out.println("serializacion de:  " + json);

        TypeToken<Collection<Integer>> colTypeToken = new TypeToken<Collection<Integer>>(){};

        Collection<Integer> ints2 = gson.fromJson(json,colTypeToken);
        System.out.println("deserializacion de: " + ints2);


        // imaginemos que tenemos una lista de personas 
        List<Persona> personas = Arrays.asList(new Persona("santiago", 14), new Persona("sebastian", 14), new Persona("samuel", 19));
        // quiero pasar las personas a un archivo para que se guardern 
        escibirJson(personas);

        // si quiero retonrar los datos 
        List<Persona> personas2 = (List<Persona>) leerJson();
        for (Persona persona : personas2) {
            System.out.println("nombre de la persona: " + persona.getNombre() + " |persona edad: " + persona.getEdad());
        }
    }

    public static void escibirJson(List<? extends Persona> objectos){

        try (FileWriter fw = new FileWriter("ejercicioGson.json",false)) {
            // creamos un ciclo para recorrer las personas 
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonLista = gson.toJson(objectos);
            fw.write(jsonLista);
            fw.flush();
            System.out.println("los datos fueron guardados correctamente");
        } catch (Exception e) {
            System.out.println("error de tipo: " + e.getLocalizedMessage());
        }
                   
    }

    public static List<Persona> leerJson(){
        String jsonLista = "ejercicioGson.json";
        List<Persona> personas = null;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
       
        try (FileReader fr = new FileReader(jsonLista)) {
            Type type = new TypeToken<List<Persona>>() {}.getType();
             personas = gson.fromJson(fr, type);
        } catch (Exception e) {
            System.out.println("error de tipo: " + e.getLocalizedMessage());
        }
        return personas;
    }
}
class Persona{
    private String nombre; 
    private int edad; 

    public Persona(String nombre,int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre(){
        return this.nombre;
    }
    public int getEdad(){
        return this.edad;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + edad;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (edad != other.edad)
            return false;
        return true;
    }

    
}
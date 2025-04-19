package com.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Scanner;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TablasYGson {
    static Scanner s = new Scanner(System.in);
    // ahora se estudiara como se relacionan estas dos librerias y la forma en como las debemos utilizar 
    public static void main(String[] args) {
      Table<String,String,Integer> tabla = HashBasedTable.create();
      tabla.put("Nissan", "V6", 6);
      tabla.put("Ferrari", "V12", 12);
      tabla.put("Nissan", "V8", 8);

      // tranformamos nuestra tabla a un map 
      Map<String,Map<String,Integer>> mapas= tabla.rowMap();

      // creamos gson y transformamos nuestro datos a un json 
      try (FileWriter fw = new FileWriter("guavaYgson.json")) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(mapas);
        fw.write(json);
        fw.flush();
        System.out.println("los datos se guardaron exito...");
      } catch (Exception e) {
        System.out.println("error de tipo: " + e.getLocalizedMessage());
      }

      // si queremos visualizar los datos deserializados preguntamos y ejecutamos 
      System.out.print("quiere visualizar los datos: (true or false) ");
      boolean valor = s.nextBoolean();
      if (valor == true){
        Table<String,String,Integer> tablaReconstruida = leer();
        
        // mostramos resumen agrupado por tipo de motor y cilindros
        tablaReconstruida.rowKeySet().forEach(marca -> {
            Map<String, Integer> motores = tablaReconstruida.row(marca);
            int cantidad = motores.size();
            StringBuilder sb = new StringBuilder();
            sb.append("El carro ").append(marca).append(" tiene ")
              .append(cantidad).append(" tipo").append(cantidad > 1 ? "s" : "")
              .append(" de motores: ");

            motores.forEach((tipo, cilindros) -> {
                sb.append(tipo).append(" (").append(cilindros).append(" cilindros), ");
            });

            // eliminamos la última coma y espacio
            String resultado = sb.toString().replaceAll(", $", "");
            System.out.println(resultado);
        });
      }
    }

    // metodo para leer y convertir a table de nuevo 
    public static Table<String,String,Integer> leer(){
        Table<String,String,Integer> tabla = HashBasedTable.create();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileReader fr = new FileReader("guavaYgson.json")) {
            // creamos un type de tipo typetoken 
            Type tipo = new TypeToken<Map<String,Map<String,Integer>>>(){}.getType();
            Map<String,Map<String,Integer>> map = gson.fromJson(fr, tipo);
            
            // convertimos el map a una tabla 
            map.forEach((k,v) -> {
                v.forEach((columna,valor) ->{
                    tabla.put(k, columna, valor);
                });
            });
        } catch (Exception e) {
            System.out.println("error de tipo: " + e.getLocalizedMessage());
        }
        return tabla;
    }
}

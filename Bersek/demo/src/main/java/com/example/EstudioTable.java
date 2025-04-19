package com.example;

import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class EstudioTable {
    
    public static void main(String[] args) {
     // las tablas de guava nos permiten mapear una clave de fila r y una clave de columna c a un valor v estas se crean de la siguiente forma 
     Table<String,String,Integer> tabla = HashBasedTable.create(); // de esta forma inicializamos la tabla de tipo HasBasedTable 
     tabla.put("samuel", "computer science", 19); // de esta forma le damos valores 
     for (Table.Cell<String,String,Integer> persona : tabla.cellSet()) {
        System.out.println(persona.getRowKey() + " tiene " + persona.getValue() + " años y estudia " + persona.getColumnKey());
     }
     // si desconocemos las filas y columnas podemos utilizar los metodos rowkeyset y columnkeyset que nos devuelven un set con los valores asociados 
     Set<String> filas = tabla.rowKeySet();
     Set<String> columna = tabla.columnKeySet();
     Iterator<String> it1 = filas.iterator();
     Iterator<String> it2 = columna.iterator();
     while(it1.hasNext()){
        while (it2.hasNext()) {
            System.out.println("la persona " + it1.next() + " tiene una edad de " + tabla.values() + " y estudia " + it2.next());
        }
     }

     // otra forma de recorrer las tablas utilizando streams y la forma mas practica seria 
     tabla.cellSet().stream().forEach(celda -> {
        String fila = celda.getRowKey();
        String colString = celda.getColumnKey();
        Integer valor = celda.getValue();
        System.out.println(fila + " estudia " + colString + " y tiene " + valor);
     });
    }

}

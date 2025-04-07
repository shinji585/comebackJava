package manejoArchivos;

import java.io.Serializable;

public  class ClaseEjemplo implements Serializable {
    protected static class Ejemeplo1 extends ClaseEjemplo  {
        private String animal;
        private int cantidadPatas;
        private double precio;

        public Ejemeplo1(String animal,int cantidadPatas,double precio){
            this.animal = animal;
            this.cantidadPatas = cantidadPatas;
            this.precio = precio;
        }

        // creamos los getters and setters 
       
        public String getAnimal() {
            return animal;
        }

        public void setAnimal(String animal) {
            this.animal = animal;
        }

        public int getCantidadPatas() {
            return cantidadPatas;
        }

        public void setCantidadPatas(int cantidadPatas) {
            this.cantidadPatas = cantidadPatas;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        // creamos el toString
        @Override
        public String toString() {
            return "Ejemeplo1 [animal=" + animal + ", cantidadPatas=" + cantidadPatas + ", precio=" + precio + "]";
        }
       
        

    }
}

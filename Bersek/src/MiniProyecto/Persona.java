package MiniProyecto;

public class Persona {
    private String name; 
    private int edad; 
    private int id = 1;
    private static int contadorId;
    
    public Persona(String name,int edad,int id){
        this.name = name;
        this.edad = edad;
        this.id = id;
        Persona.contadorId = Math.max(Persona.contadorId, id);
    }

    // getters and setters 
    public void setEdad(int edad){
       this.edad = edad;
    }
    public void setNombre(String name){
        this.name = name;
    }
    public int getEdad(){
        return this.edad;
    }
    public String getName(){
        return this.name;
    }
    public int getID(){
        return this.id;
    }

    // creamos el toString 
    @Override
    public String toString(){
        return "La persona: " + this.name 
        + "\n tiene una edad de: "  
        + this.edad 
        + "\n Esta identificada con el numero: " 
        + Persona.contadorId;
    }
    
}

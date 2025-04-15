package MiniProyecto;

public class Estudiante extends Persona{
    // generamos los nuevos atributos 
    private String asignatura;
    private double nota; 

    public Estudiante(String asignaturas,double nota,String nombre,int edad,int id){
         super(nombre, edad,id);
         this.asignatura = asignaturas;
         this.nota = nota;
        
    }

    // creamos getters and setters 
    public void setNota(double nota){
        this.nota = nota;
    }
    public void setAsignatura(String asignatura){
        this.asignatura = asignatura;
    }
    public double getNota(){
        return this.nota;
    }
    public String getAsignatura(){
        return this.asignatura;
    }

    @Override
    public String toString() {
        return super.getName() + ";" + super.getEdad() + ";" + this.asignatura + ";" + this.nota + ";" + super.getID();
    }

    public static Estudiante fromString(String string) {

        String[] partes = string.split(";");
        String nombre = partes[0];
        int edad = Integer.parseInt(partes[1].trim());
        String asignatura = partes[2];
        double nota = Double.parseDouble(partes[3].trim());
        int id = Integer.parseInt(partes[4].trim());
        return new Estudiante(asignatura, nota, nombre, edad,id);
    }
    

    
}

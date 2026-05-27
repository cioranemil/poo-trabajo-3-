package EquipoMaraton;

public class Programador {
    private String nombre;
    private String apellidos;

    public Programador(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
}

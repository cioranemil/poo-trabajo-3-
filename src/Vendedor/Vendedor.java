package Vendedor;

public class Vendedor {
    private String nombre;
    private String apellidos;
    private int edad;

    public Vendedor(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        verificarEdad(edad);
        this.edad = edad;
    }

    private void verificarEdad(int edad) {
        if (edad < 18) {
            throw new IllegalArgumentException("El vendedor debe ser mayor de 18 años.");
        }
        if (edad >= 0 && edad <= 120) {
            // Edad válida
        } else {
            throw new IllegalArgumentException("La edad no puede ser negativa ni mayor a 120.");
        }
    }

    @Override
    public String toString() {
        return "Vendedor guardado exitosamente:\nNombre: " + nombre + "\nApellidos: " + apellidos + "\nEdad: " + edad;
    }
}

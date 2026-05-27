package EquipoMaraton;

public class EquipoMaratonProgramacion {
    String nombreEquipo;
    String universidad;
    String lenguajeProgramacion;
    Programador[] programadores;
    int tamañoEquipo;

    public EquipoMaratonProgramacion(String nombreEquipo, String universidad, String lenguajeProgramacion) {
        this.nombreEquipo = nombreEquipo;
        this.universidad = universidad;
        this.lenguajeProgramacion = lenguajeProgramacion;
        this.tamañoEquipo = 0;
        this.programadores = new Programador[3];
    }

    public boolean estaLleno() {
        return tamañoEquipo == programadores.length;
    }

    public void añadir(Programador programador) throws Exception {
        if (estaLleno()) {
            throw new Exception("El equipo está completo. No se pudo agregar programador.");
        }
        programadores[tamañoEquipo] = programador;
        tamañoEquipo++;
    }

    public static void validarCampo(String campo) throws Exception {
        if (campo.length() > 20) {
            throw new Exception("La longitud no debe ser superior a 20 caracteres.");
        }
        for (int j = 0; j < campo.length(); j++) {
            char c = campo.charAt(j);
            if (Character.isDigit(c)) {
                throw new Exception("El nombre o apellido no puede tener dígitos.");
            }
        }
    }
}

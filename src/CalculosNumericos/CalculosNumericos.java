package CalculosNumericos;

public class CalculosNumericos {
    
    public static double calcularLogaritmoNeperiano(double valor) throws ArithmeticException {
        if (valor < 0) {
            throw new ArithmeticException("El valor debe ser un número positivo para calcular el logaritmo.");
        }
        return Math.log(valor);
    }

    public static double calcularRaizCuadrada(double valor) throws ArithmeticException {
        if (valor < 0) {
            throw new ArithmeticException("El valor debe ser un número positivo para calcular la raíz cuadrada.");
        }
        return Math.sqrt(valor);
    }
}

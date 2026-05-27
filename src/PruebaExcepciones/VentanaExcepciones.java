package PruebaExcepciones;

import Utilidades.UIUtils;
import javax.swing.*;
import java.awt.*;

public class VentanaExcepciones extends JFrame {
    private JTextArea areaTexto;

    public VentanaExcepciones() {
        setTitle("Ejercicio 6.4: Prueba de Excepciones");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        UIUtils.estilizarPanel(panelPrincipal);

        JLabel titulo = new JLabel("Trazas de Ejecución try/catch/finally");
        titulo.setFont(UIUtils.FUENTE_TITULO);
        panelPrincipal.add(titulo, BorderLayout.NORTH);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);
        panelPrincipal.add(scroll, BorderLayout.CENTER);

        JButton btnEjecutar = new JButton("Ejecutar Prueba de Excepciones");
        UIUtils.estilizarBoton(btnEjecutar);
        btnEjecutar.addActionListener(e -> ejecutarPrueba());
        
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(UIUtils.COLOR_FONDO);
        panelInferior.add(btnEjecutar);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    private void imprimir(String texto) {
        areaTexto.append(texto + "\n");
    }

    private void ejecutarPrueba() {
        areaTexto.setText(""); // Limpiar
        
        imprimir("--- INICIO DE PRUEBAS ---");
        
        // Primer bloque try
        try {
            imprimir("Ingresando al primer try");
            double cociente = 10000 / 0; // Se lanza excepción
            imprimir("Después de la división (No se ejecuta)");
        } catch (ArithmeticException e) {
            imprimir("División por cero (catch ArithmeticException ejecutado)");
        } finally {
            imprimir("Ingresando al primer finally");
        }

        imprimir("-----------------------");

        // Segundo bloque try
        try {
            imprimir("Ingresando al segundo try");
            Object objeto = null;
            objeto.toString(); // Se lanza NullPointerException (general)
            imprimir("Imprimiendo objeto (No se ejecuta)");
        } catch (ArithmeticException e) {
            imprimir("División por cero");
        } catch (Exception e) {
            imprimir("Ocurrió una excepción general: " + e.getClass().getSimpleName());
        } finally {
            imprimir("Ingresando al segundo finally");
        }
    }
}

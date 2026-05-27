package CalculosNumericos;

import Utilidades.UIUtils;
import javax.swing.*;
import java.awt.*;

public class VentanaCalculos extends JFrame {
    private JTextField txtValor;
    private JLabel lblResultado;

    public VentanaCalculos() {
        setTitle("Ejercicio 6.6: Cálculos Numéricos");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelCentral = new JPanel(new GridLayout(2, 2, 10, 20));
        UIUtils.estilizarPanel(panelCentral);

        panelCentral.add(new JLabel("Ingrese valor numérico:"));
        txtValor = new JTextField();
        panelCentral.add(txtValor);

        lblResultado = new JLabel("Resultado: ");
        lblResultado.setFont(UIUtils.FUENTE_TITULO);
        lblResultado.setForeground(UIUtils.COLOR_PRIMARIO);
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setBackground(UIUtils.COLOR_FONDO);
        
        JButton btnLog = new JButton("Calcular Logaritmo");
        UIUtils.estilizarBoton(btnLog);
        btnLog.addActionListener(e -> calcularLogaritmo());

        JButton btnRaiz = new JButton("Calcular Raíz Cuadrada");
        UIUtils.estilizarBoton(btnRaiz);
        btnRaiz.addActionListener(e -> calcularRaiz());

        panelBotones.add(btnLog);
        panelBotones.add(btnRaiz);

        add(panelCentral, BorderLayout.NORTH);
        add(lblResultado, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void calcularLogaritmo() {
        try {
            double valor = Double.parseDouble(txtValor.getText().trim());
            double res = CalculosNumericos.calcularLogaritmoNeperiano(valor);
            lblResultado.setText(String.format("Resultado: %.4f", res));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El valor debe ser numérico para calcular el logaritmo.", "InputMismatchException", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ArithmeticException", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularRaiz() {
        try {
            double valor = Double.parseDouble(txtValor.getText().trim());
            double res = CalculosNumericos.calcularRaizCuadrada(valor);
            lblResultado.setText(String.format("Resultado: %.4f", res));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El valor debe ser numérico para calcular la raíz cuadrada.", "InputMismatchException", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ArithmeticException", JOptionPane.ERROR_MESSAGE);
        }
    }
}

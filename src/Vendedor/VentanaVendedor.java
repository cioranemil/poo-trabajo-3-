package Vendedor;

import Utilidades.UIUtils;
import javax.swing.*;
import java.awt.*;

public class VentanaVendedor extends JFrame {
    private JTextField txtNombre, txtApellidos, txtEdad;

    public VentanaVendedor() {
        setTitle("Ejercicio 6.5: Validación de Vendedor");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 20));
        UIUtils.estilizarPanel(panel);

        panel.add(new JLabel("Nombre del vendedor:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Apellidos del vendedor:"));
        txtApellidos = new JTextField();
        panel.add(txtApellidos);

        panel.add(new JLabel("Edad del vendedor:"));
        txtEdad = new JTextField();
        panel.add(txtEdad);

        JButton btnCrear = new JButton("Crear y Validar");
        UIUtils.estilizarBoton(btnCrear);
        btnCrear.addActionListener(e -> validarVendedor());

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(UIUtils.COLOR_FONDO);
        panelBoton.add(btnCrear);

        add(panel, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
    }

    private void validarVendedor() {
        try {
            String nombre = txtNombre.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            if(nombre.isEmpty() || apellidos.isEmpty()) {
                throw new IllegalArgumentException("Nombre y apellidos no pueden estar vacíos.");
            }
            int edad = Integer.parseInt(txtEdad.getText().trim());
            
            Vendedor v = new Vendedor(nombre, apellidos, edad);
            JOptionPane.showMessageDialog(this, v.toString(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un valor numérico.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Argumento Ilegal", JOptionPane.WARNING_MESSAGE);
        }
    }
}

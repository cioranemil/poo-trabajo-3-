package Lanzador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JButton btnNotas, btnFiguras;
    private JLabel titulo;

    public MenuPrincipal() {
        inicio();
        setTitle("Menu del Curso - POO");
        setSize(350, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);
        // Uso de la clase Color (Requisito del libro)
        contenedor.setBackground(new Color(240, 245, 250));

        // Uso de la clase Font (Requisito del libro)
        Font fuenteTitulo = new Font("Arial", Font.BOLD, 16);
        Font fuenteBotones = new Font("Verdana", Font.PLAIN, 14);

        titulo = new JLabel("Seleccione un ejercicio:");
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(new Color(30, 60, 100));
        titulo.setBounds(75, 20, 250, 23);

        btnNotas = new JButton("Ejercicio 8.2 (Notas)");
        btnNotas.setFont(fuenteBotones);
        btnNotas.setBackground(new Color(100, 150, 220));
        btnNotas.setForeground(Color.WHITE);
        btnNotas.setFocusPainted(false);
        btnNotas.setBounds(60, 60, 220, 35);
        btnNotas.addActionListener(this);

        btnFiguras = new JButton("Ejercicio 8.3 (Figuras)");
        btnFiguras.setFont(fuenteBotones);
        btnFiguras.setBackground(new Color(100, 180, 150));
        btnFiguras.setForeground(Color.WHITE);
        btnFiguras.setFocusPainted(false);
        btnFiguras.setBounds(60, 110, 220, 35);
        btnFiguras.addActionListener(this);

        contenedor.add(titulo);
        contenedor.add(btnNotas);
        contenedor.add(btnFiguras);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == btnNotas) {
            Notas.VentanaPrincipal ventanaNotas = new Notas.VentanaPrincipal();
            ventanaNotas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            ventanaNotas.setVisible(true);
        }
        if (evento.getSource() == btnFiguras) {
            Figuras.VentanaPrincipal ventanaFiguras = new Figuras.VentanaPrincipal();
            ventanaFiguras.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            ventanaFiguras.setVisible(true);
        }
    }
}

package MenuGeneral;

import Utilidades.UIUtils;
import MenuPrincipal.VentanaPrincipalActividad4;

import Actividad5.VentanaBiblioteca;

import javax.swing.*;
import java.awt.*;

public class VentanaCursoPOO extends JFrame {

    public VentanaCursoPOO() {
        UIUtils.aplicarTema(); // Aplica el tema estilizado

        setTitle("Curso Programación Orientada a Objetos");
        setSize(400, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelCentral = new JPanel(new GridLayout(4, 1, 10, 20));
        UIUtils.estilizarPanel(panelCentral);

        JLabel lblTitulo = new JLabel("Aplicación Curso POO", SwingConstants.CENTER);
        lblTitulo.setFont(UIUtils.FUENTE_TITULO);
        
        JPanel pnlNorte = new JPanel(new BorderLayout());
        pnlNorte.setBackground(UIUtils.COLOR_FONDO);
        pnlNorte.add(lblTitulo, BorderLayout.CENTER);
        pnlNorte.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

        JButton btnAct3Notas = new JButton("Actividad 3 - Notas");
        UIUtils.estilizarBoton(btnAct3Notas);
        btnAct3Notas.addActionListener(e -> new Notas.VentanaPrincipal().setVisible(true));

        JButton btnAct3Figuras = new JButton("Actividad 3 - Figuras");
        UIUtils.estilizarBoton(btnAct3Figuras);
        btnAct3Figuras.addActionListener(e -> new Figuras.VentanaPrincipal().setVisible(true));

        JButton btnAct4 = new JButton("Actividad 4 - Excepciones y Archivos");
        UIUtils.estilizarBoton(btnAct4);
        btnAct4.addActionListener(e -> new VentanaPrincipalActividad4().setVisible(true));

        JButton btnAct5 = new JButton("Actividad 5 - Biblioteca (CRUD)");
        UIUtils.estilizarBoton(btnAct5);
        btnAct5.setBackground(new Color(46, 204, 113)); // Verde para destacar
        btnAct5.setForeground(Color.WHITE);
        btnAct5.addActionListener(e -> new VentanaBiblioteca().setVisible(true));

        panelCentral.add(btnAct3Notas);
        panelCentral.add(btnAct3Figuras);
        panelCentral.add(btnAct4);
        panelCentral.add(btnAct5);

        add(pnlNorte, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new VentanaCursoPOO().setVisible(true);
    }
}

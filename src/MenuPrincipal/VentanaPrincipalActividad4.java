package MenuPrincipal;

import Utilidades.UIUtils;
import PruebaExcepciones.VentanaExcepciones;
import Vendedor.VentanaVendedor;
import CalculosNumericos.VentanaCalculos;
import EquipoMaraton.VentanaEquipo;
import LeerArchivo.VentanaLeerArchivo;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipalActividad4 extends JFrame {

    public VentanaPrincipalActividad4() {
        UIUtils.aplicarTema();

        setTitle("Actividad 4 - Menú Principal");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelCentral = new JPanel(new GridLayout(5, 1, 10, 15));
        UIUtils.estilizarPanel(panelCentral);

        JLabel lblTitulo = new JLabel("Ejercicios de Programación Orientada a Objetos", SwingConstants.CENTER);
        lblTitulo.setFont(UIUtils.FUENTE_TITULO);
        
        JPanel pnlNorte = new JPanel(new BorderLayout());
        pnlNorte.setBackground(UIUtils.COLOR_FONDO);
        pnlNorte.add(lblTitulo, BorderLayout.CENTER);
        pnlNorte.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

        JButton btnEj1 = new JButton("1. Prueba Excepciones (Pág 400)");
        UIUtils.estilizarBoton(btnEj1);
        btnEj1.addActionListener(e -> new VentanaExcepciones().setVisible(true));

        JButton btnEj2 = new JButton("2. Validación Vendedor (Pág 406)");
        UIUtils.estilizarBoton(btnEj2);
        btnEj2.addActionListener(e -> new VentanaVendedor().setVisible(true));

        JButton btnEj3 = new JButton("3. Cálculos Numéricos (Pág 412)");
        UIUtils.estilizarBoton(btnEj3);
        btnEj3.addActionListener(e -> new VentanaCalculos().setVisible(true));

        JButton btnEj4 = new JButton("4. Equipo Maratón (Pág 418)");
        UIUtils.estilizarBoton(btnEj4);
        btnEj4.addActionListener(e -> new VentanaEquipo().setVisible(true));

        JButton btnEj5 = new JButton("5. Leer Archivo (Pág 427)");
        UIUtils.estilizarBoton(btnEj5);
        btnEj5.addActionListener(e -> new VentanaLeerArchivo().setVisible(true));

        panelCentral.add(btnEj1);
        panelCentral.add(btnEj2);
        panelCentral.add(btnEj3);
        panelCentral.add(btnEj4);
        panelCentral.add(btnEj5);

        add(pnlNorte, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
    }
}

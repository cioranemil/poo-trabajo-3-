package EquipoMaraton;

import Utilidades.UIUtils;
import javax.swing.*;
import java.awt.*;

public class VentanaEquipo extends JFrame {
    private JTextField txtNomEquipo, txtUniversidad, txtLenguaje;
    private JTextField txtNomProg, txtApeProg;
    private JButton btnCrearEquipo, btnAnadirProg;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaProgramadores;
    private EquipoMaratonProgramacion equipo;

    public VentanaEquipo() {
        setTitle("Ejercicio 6.7: Equipo de Maratón");
        setSize(550, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        UIUtils.estilizarPanel(panelPrincipal);

        // Panel superior: Crear Equipo
        JPanel pnlEquipo = new JPanel(new GridLayout(4, 2, 5, 5));
        pnlEquipo.setBorder(BorderFactory.createTitledBorder("Datos del Equipo"));
        pnlEquipo.setBackground(UIUtils.COLOR_FONDO);
        pnlEquipo.add(new JLabel("Nombre del Equipo:"));
        txtNomEquipo = new JTextField(); pnlEquipo.add(txtNomEquipo);
        pnlEquipo.add(new JLabel("Universidad:"));
        txtUniversidad = new JTextField(); pnlEquipo.add(txtUniversidad);
        pnlEquipo.add(new JLabel("Lenguaje:"));
        txtLenguaje = new JTextField(); pnlEquipo.add(txtLenguaje);
        
        btnCrearEquipo = new JButton("Crear Equipo");
        UIUtils.estilizarBoton(btnCrearEquipo);
        btnCrearEquipo.addActionListener(e -> crearEquipo());
        pnlEquipo.add(new JLabel("")); // Spacer
        pnlEquipo.add(btnCrearEquipo);

        // Panel central: Añadir Programador
        JPanel pnlProg = new JPanel(new GridLayout(3, 2, 5, 5));
        pnlProg.setBorder(BorderFactory.createTitledBorder("Añadir Programador"));
        pnlProg.setBackground(UIUtils.COLOR_FONDO);
        pnlProg.add(new JLabel("Nombre:"));
        txtNomProg = new JTextField(); pnlProg.add(txtNomProg);
        pnlProg.add(new JLabel("Apellidos:"));
        txtApeProg = new JTextField(); pnlProg.add(txtApeProg);
        
        btnAnadirProg = new JButton("Añadir Programador");
        UIUtils.estilizarBoton(btnAnadirProg);
        btnAnadirProg.setEnabled(false); // Solo se activa si hay equipo
        btnAnadirProg.addActionListener(e -> anadirProgramador());
        pnlProg.add(new JLabel("")); // Spacer
        pnlProg.add(btnAnadirProg);

        // Panel inferior: Lista
        modeloLista = new DefaultListModel<>();
        listaProgramadores = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(listaProgramadores);
        scroll.setPreferredSize(new Dimension(500, 100));

        JPanel pnlNorte = new JPanel(new BorderLayout());
        pnlNorte.add(pnlEquipo, BorderLayout.NORTH);
        pnlNorte.add(pnlProg, BorderLayout.CENTER);

        panelPrincipal.add(pnlNorte, BorderLayout.NORTH);
        panelPrincipal.add(scroll, BorderLayout.CENTER);

        add(panelPrincipal);
    }

    private void crearEquipo() {
        String n = txtNomEquipo.getText().trim();
        String u = txtUniversidad.getText().trim();
        String l = txtLenguaje.getText().trim();
        if(n.isEmpty() || u.isEmpty() || l.isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos del equipo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        equipo = new EquipoMaratonProgramacion(n, u, l);
        JOptionPane.showMessageDialog(this, "Equipo creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        btnAnadirProg.setEnabled(true);
        btnCrearEquipo.setEnabled(false);
        txtNomEquipo.setEditable(false);
        txtUniversidad.setEditable(false);
        txtLenguaje.setEditable(false);
    }

    private void anadirProgramador() {
        try {
            String nom = txtNomProg.getText().trim();
            String ape = txtApeProg.getText().trim();

            if (nom.isEmpty() || ape.isEmpty()) {
                 throw new Exception("Los campos de nombre y apellido no pueden estar vacíos.");
            }

            EquipoMaratonProgramacion.validarCampo(nom);
            EquipoMaratonProgramacion.validarCampo(ape);

            Programador p = new Programador(nom, ape);
            equipo.añadir(p);
            
            modeloLista.addElement(p.toString());
            txtNomProg.setText("");
            txtApeProg.setText("");

            if (equipo.estaLleno()) {
                btnAnadirProg.setEnabled(false);
                JOptionPane.showMessageDialog(this, "El equipo está completo (3 integrantes).", "Equipo Lleno", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Validación", JOptionPane.WARNING_MESSAGE);
        }
    }
}

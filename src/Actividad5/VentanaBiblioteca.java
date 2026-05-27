package Actividad5;

import Utilidades.UIUtils;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VentanaBiblioteca extends JFrame {
    private JTextField txtTitulo, txtAutor;
    private JComboBox<String> cbEstado;
    private JTable tablaLibros;
    private DefaultTableModel modeloTabla;
    private String tituloSeleccionadoParaActualizar = null; // Guarda el título original al actualizar

    public VentanaBiblioteca() {
        setTitle("Actividad 5: Biblioteca CRUD (Create, Read, Update, Delete)");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        UIUtils.estilizarPanel(panelPrincipal);

        // FORMULARIO (Norte)
        JPanel pnlFormulario = new JPanel(new GridLayout(4, 2, 10, 10));
        pnlFormulario.setBackground(UIUtils.COLOR_FONDO);
        pnlFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Libro"));

        pnlFormulario.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        pnlFormulario.add(txtTitulo);

        pnlFormulario.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        pnlFormulario.add(txtAutor);

        pnlFormulario.add(new JLabel("Estado:"));
        cbEstado = new JComboBox<>(new String[]{"Pendiente", "Leyendo", "Terminado"});
        pnlFormulario.add(cbEstado);

        // BOTONES CRUD
        JPanel pnlBotones = new JPanel(new FlowLayout());
        pnlBotones.setBackground(UIUtils.COLOR_FONDO);

        JButton btnCrear = new JButton("Añadir (Create)");
        UIUtils.estilizarBoton(btnCrear);
        btnCrear.addActionListener(e -> crear());

        JButton btnActualizar = new JButton("Guardar Edición (Update)");
        UIUtils.estilizarBoton(btnActualizar);
        btnActualizar.addActionListener(e -> actualizar());

        JButton btnBorrar = new JButton("Eliminar (Delete)");
        UIUtils.estilizarBoton(btnBorrar);
        btnBorrar.setBackground(new Color(231, 76, 60)); // Rojo para borrar
        btnBorrar.setForeground(Color.WHITE);
        btnBorrar.addActionListener(e -> borrar());

        JButton btnLimpiar = new JButton("Limpiar Campos");
        UIUtils.estilizarBoton(btnLimpiar);
        btnLimpiar.addActionListener(e -> limpiarFormulario());

        pnlBotones.add(btnCrear);
        pnlBotones.add(btnActualizar);
        pnlBotones.add(btnBorrar);
        pnlBotones.add(btnLimpiar);

        JPanel pnlSuperior = new JPanel(new BorderLayout());
        pnlSuperior.add(pnlFormulario, BorderLayout.CENTER);
        pnlSuperior.add(pnlBotones, BorderLayout.SOUTH);

        // TABLA (Read)
        modeloTabla = new DefaultTableModel(new String[]{"Título", "Autor", "Estado"}, 0);
        tablaLibros = new JTable(modeloTabla);
        tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Evento al hacer clic en la tabla para rellenar el formulario
        tablaLibros.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tablaLibros.getSelectedRow() != -1) {
                int row = tablaLibros.getSelectedRow();
                tituloSeleccionadoParaActualizar = modeloTabla.getValueAt(row, 0).toString();
                txtTitulo.setText(tituloSeleccionadoParaActualizar);
                txtAutor.setText(modeloTabla.getValueAt(row, 1).toString());
                cbEstado.setSelectedItem(modeloTabla.getValueAt(row, 2).toString());
            }
        });

        JScrollPane scrollTabla = new JScrollPane(tablaLibros);

        panelPrincipal.add(pnlSuperior, BorderLayout.NORTH);
        panelPrincipal.add(scrollTabla, BorderLayout.CENTER);

        add(panelPrincipal);
        cargarTabla(); // (Read) al iniciar
    }

    private void limpiarFormulario() {
        txtTitulo.setText("");
        txtAutor.setText("");
        cbEstado.setSelectedIndex(0);
        tituloSeleccionadoParaActualizar = null;
        tablaLibros.clearSelection();
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0); // Limpiar tabla
        try {
            ArrayList<String[]> libros = GestorArchivoBiblioteca.leerLibros();
            for (String[] l : libros) {
                modeloTabla.addRow(l);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error leyendo archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void crear() {
        String t = txtTitulo.getText().trim();
        String a = txtAutor.getText().trim();
        String e = cbEstado.getSelectedItem().toString();

        if (t.isEmpty() || a.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Título y Autor no pueden estar vacíos.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            GestorArchivoBiblioteca.crearLibro(t, a, e);
            JOptionPane.showMessageDialog(this, "Libro guardado exitosamente.");
            limpiarFormulario();
            cargarTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizar() {
        if (tituloSeleccionadoParaActualizar == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un libro de la tabla primero.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String t = txtTitulo.getText().trim();
        String a = txtAutor.getText().trim();
        String e = cbEstado.getSelectedItem().toString();

        try {
            GestorArchivoBiblioteca.actualizarLibro(tituloSeleccionadoParaActualizar, t, a, e);
            JOptionPane.showMessageDialog(this, "Libro actualizado correctamente.");
            limpiarFormulario();
            cargarTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void borrar() {
        if (tituloSeleccionadoParaActualizar == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un libro de la tabla primero.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar '" + tituloSeleccionadoParaActualizar + "'?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            try {
                GestorArchivoBiblioteca.borrarLibro(tituloSeleccionadoParaActualizar);
                JOptionPane.showMessageDialog(this, "Libro eliminado.");
                limpiarFormulario();
                cargarTabla();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al borrar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

package LeerArchivo;

import Utilidades.UIUtils;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class VentanaLeerArchivo extends JFrame {
    private JTextArea areaTexto;

    public VentanaLeerArchivo() {
        setTitle("Ejercicio 6.8: Lectura de Archivos");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        UIUtils.estilizarPanel(panelPrincipal);

        JButton btnSeleccionar = new JButton("Seleccionar Archivo .txt");
        UIUtils.estilizarBoton(btnSeleccionar);
        btnSeleccionar.addActionListener(e -> leerArchivo());

        JPanel pnlNorte = new JPanel();
        pnlNorte.setBackground(UIUtils.COLOR_FONDO);
        pnlNorte.add(btnSeleccionar);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);

        panelPrincipal.add(pnlNorte, BorderLayout.NORTH);
        panelPrincipal.add(scroll, BorderLayout.CENTER);

        add(panelPrincipal);
    }

    private void leerArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            areaTexto.setText(""); // Limpiar
            
            try (FileInputStream fis = new FileInputStream(archivo);
                 InputStreamReader isr = new InputStreamReader(fis);
                 BufferedReader br = new BufferedReader(isr)) {
                 
                String linea = br.readLine();
                while (linea != null) {
                    areaTexto.append(linea + "\n");
                    linea = br.readLine();
                }
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo leer el archivo:\n" + ex.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

package Utilidades;

import javax.swing.*;
import java.awt.*;

public class UIUtils {
    public static final Color COLOR_FONDO = new Color(245, 247, 250);
    public static final Color COLOR_PRIMARIO = new Color(52, 152, 219);
    public static final Color COLOR_TEXTO = new Color(44, 62, 80);
    public static final Font FUENTE_TITULO = new Font("Segoe UI", Font.BOLD, 22);
    public static final Font FUENTE_NORMAL = new Font("Segoe UI", Font.PLAIN, 14);

    public static void aplicarTema() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("Panel.background", COLOR_FONDO);
            UIManager.put("Label.font", FUENTE_NORMAL);
            UIManager.put("Label.foreground", COLOR_TEXTO);
            UIManager.put("Button.font", FUENTE_NORMAL);
            UIManager.put("TextField.font", FUENTE_NORMAL);
            UIManager.put("TextArea.font", new Font("Consolas", Font.PLAIN, 13));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void estilizarBoton(JButton boton) {
        boton.setFont(FUENTE_NORMAL);
        boton.setForeground(new Color(30, 30, 30)); // Texto oscuro para que se lea
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void estilizarPanel(JPanel panel) {
        panel.setBackground(COLOR_FONDO);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }
}

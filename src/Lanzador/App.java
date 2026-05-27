package Lanzador;

import javax.swing.UIManager;

public class App {
    public static void main(String[] args) {
        try {
            // Aplicar el Look and Feel Nimbus para una apariencia moderna
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Si Nimbus no está disponible, Swing usará el look and feel por defecto
        }

        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
    }
}

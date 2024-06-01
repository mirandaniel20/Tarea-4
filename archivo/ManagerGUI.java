/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivo;

/**
 *
 * @author Wine
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;

public class ManagerGUI extends javax.swing.JFrame {
    public ManagerGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Código de inicialización de la GUI (generado automáticamente)

        // Resto del código de la GUI (generado automáticamente)
    }

    private void jButtonOpenActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser jFileChooser = new JFileChooser(javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory());
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTableFiles.getModel();
        int result = jFileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File source = new File(jFileChooser.getSelectedFile().getAbsolutePath());
                File target = new File(System.getProperty("user.dir") + "/files");
                target.mkdir();
                target = new File(System.getProperty("user.dir") + "/files/" + jFileChooser.getSelectedFile().getName());
                Archivo.copiar(source, target);
                defaultTableModel.addRow(new Object[]{jFileChooser.getSelectedFile().getAbsolutePath(), System.getProperty("user.dir") + "/files/" + jFileChooser.getSelectedFile().getName()});
            } catch (IOException ex) {
                Logger.getLogger(ManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTableFiles.getModel();
        if (defaultTableModel.getRowCount() > 0) {
            for (int i = defaultTableModel.getRowCount() - 1; i > -1; i--) {
                defaultTableModel.removeRow(i);
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerGUI().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonOpen;
    private javax.swing.JLabel jLabelIP;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableFiles;
}

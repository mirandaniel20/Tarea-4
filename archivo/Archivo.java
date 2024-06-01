/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
import org.apache.commons.io.FileUtils;

public class Archivo {
    public static void copiar(File origen, File destinoDirectorio) {
        try {
            destinoDirectorio.mkdirs();
            File destino = new File(destinoDirectorio.getPath() + "/" + origen.getName());
            FileUtils.copyFile(origen, destino);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
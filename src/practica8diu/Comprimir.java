
package practica8diu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.*;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class Comprimir extends SwingWorker<String, Integer> {
    
    //Elementos del JFrame a modificar
    private final JProgressBar barraDeProgreso;
    private final JButton botonDestino;
    private final JButton botonOrigen;
    private final JButton botonComprimir;
    private final JButton botonCanelar;
    
    //Directorios origen y destino, nombre de archivo y lista de archivos
    private final String nombreCompletoArchivo;
    private final File origenArchivos;   
    private final List<File> archivos;       
    
    //Tamaño de archivos a comprimir, cantidad ya añadida al zip y archivo
    //que esta siendo procesado
    private float tamDirectorioOrigen, tamDirectorioDestino;
    
    //Tamaño de buffer
    private final int BUFFER_SIZE;
    
    
    public Comprimir(JProgressBar barraDeProgreso,
            JButton botonOrigen, JButton botonDestino,
            JButton botonComprimir, JButton botonCanelar,
            String nomArchivoComprimido, String rutaOrigen, String rutaDestino) {
        
        this.barraDeProgreso = barraDeProgreso;
        this.botonOrigen = botonOrigen;
        this.botonDestino = botonDestino;
        this.botonComprimir = botonComprimir;
        this.botonCanelar = botonCanelar;     
        this.nombreCompletoArchivo = rutaDestino + "\\" + nomArchivoComprimido + ".zip";
        this.origenArchivos = new File(rutaOrigen);
        
        this.archivos = new ArrayList<>();     
        this.tamDirectorioOrigen = 0;
        this.tamDirectorioDestino = 0;
        this.BUFFER_SIZE = 1024;
        
    }
    
    @Override
    protected String doInBackground() throws Exception {     
        añadirFicheros();
        
        if (tamDirectorioOrigen > 0) {
            this.botonCanelar.setEnabled(true);
            this.botonComprimir.setEnabled(false);
            this.botonOrigen.setEnabled(false);
            this.botonDestino.setEnabled(false);
        }
        
        compress();   
        
        return "";
    }
    
    @Override
    protected void process(List<Integer> value) {
        this.barraDeProgreso.setValue(value.get(value.size() - 1));     
        if (this.isCancelled() == true && new File(this.nombreCompletoArchivo).exists()) {  
            new File(this.nombreCompletoArchivo).delete();
        }
    }
    
    @Override
    protected void done() {
        this.botonDestino.setEnabled(true);
        this.botonOrigen.setEnabled(true);
        this.botonComprimir.setEnabled(true);
        this.botonCanelar.setEnabled(false);
    }
    
    
    
        
    private void añadirFicheros() {
        for (File fichero : this.origenArchivos.listFiles()) {
            if (!fichero.isDirectory()) {
                archivos.add(fichero);
                tamDirectorioOrigen += fichero.length();
            }   
        }
    }
    
    private void compress() {      
        try {
            // Objeto para referenciar a los archivos que queremos comprimir
            BufferedInputStream origin = null;
            // Objeto para referenciar el archivo zip de salida
            FileOutputStream dest = new FileOutputStream(this.nombreCompletoArchivo);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            // Buffer de transferencia para mandar datos a comprimir
            byte[] data = new byte[BUFFER_SIZE];
            
            for (File file : archivos) {
                
                if (!this.isCancelled()) {
                    FileInputStream fi = new FileInputStream(file.getAbsolutePath());
                    origin = new BufferedInputStream(fi, BUFFER_SIZE);

                    ZipEntry entry = new ZipEntry(file.getName());
                    out.putNextEntry(entry);
                    // Leemos datos desde el archivo origen y los mandamos al archivo destino
                    int count;
                    while((count = origin.read(data, 0, BUFFER_SIZE)) != -1) {
                        //Count = BufferSize hasta que tamaño datos sea menor                    
                        out.write(data, 0, count);
                        this.tamDirectorioDestino += count;
                        publish(Math.round(this.tamDirectorioDestino / this.tamDirectorioOrigen * 100));
                    }
                    // Cerramos el archivo origen, ya enviado a comprimir
                    origin.close();
                }   
                
                else break;
            }
            // Cerramos el archivo zip
            out.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

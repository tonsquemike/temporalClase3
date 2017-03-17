/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase3_paraleliza;

import Funciones.Archivos;
import java.io.BufferedWriter;
import java.io.File;

/**
 *
 * @author mike
 */
public class changeIterations {
    public static void main(String[] args) {
        String path= "/home/mike/Escritorio/Params/";
        String files[] = new File(path).list();
        for (int i = 0; i < files.length; i++) {
            modifyIterations(path+File.separator+files[i]);
            //System.out.println(path+File.separator+files[i]);
        }
    }
    public static void modifyIterations(String fileName)
    {
        String []content = Archivos.leerArchivoDeTexto(fileName);
        BufferedWriter bw = Archivos.newBuffer(fileName);      
        
        for (int i = 0; i < content.length; i++) {
            content[i] = content[i].replace("-MAXGEN		100", "-MAXGEN		300");
            Archivos.addLine(bw, content[i]);
        }
        Archivos.saveFile(bw);
     }
}

package com.datos;

import boletin_20.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class conexionDatos {
    
    public static void leerDatos() throws FileNotFoundException {
        
        try {
            // Lee los libros existentes
            
            Scanner sc = new Scanner(new File("src/com/datos/libros.txt"));
            
            while (sc.hasNextLine()) {
                String[] ref = sc.nextLine().split(" * ");
                Libro libro = new Libro(ref[0], ref[2], Float.parseFloat(ref[4]), Integer.parseInt(ref[6]));
                Libreria.libros.add(libro);
            }
            
            sc.close();
            
        } catch(FileNotFoundException except){
            
            System.out.print("No se ha encontrado el archivo de guardado.");
        }
    }
    
    public static void guardarDatos() throws FileNotFoundException, IOException {
        
        File ruta = new File("src/com/datos/libros.txt");
        FileWriter escribir;
        
        try {
            // Escribe los libros existentes
            escribir = new FileWriter(ruta, false);
            
            for(Libro libro: Libreria.libros){
                
                escribir.write(libro.getNome() + " * " + libro.getAutor() + " * "
                        + libro.getPrecio() + " * " + libro.getUnidades() + "\n");
            }
            
            
            
            escribir.close();
        } catch(IOException except){
            
            System.out.print("No se ha encontrado el archivo de guardado.");
        }
    }
}

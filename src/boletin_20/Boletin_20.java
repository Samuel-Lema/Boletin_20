package boletin_20;

import com.datos.conexionDatos;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class Boletin_20 {

    public static void main(String[] args) throws FileNotFoundException {
        
        conexionDatos.leerDatos();
        
        boolean exit = false;
        String[] possibilities = {"Añadir Libro", "Consultar Libro", 
            "Visualizar Libros", "Eliminar sin Stock", "Modificar Libro"};
        
        do {
            
            String opcion = (String)JOptionPane.showInputDialog(null, "", "Panel de Control",
                    JOptionPane.PLAIN_MESSAGE, null, possibilities, null );
            if (opcion == null){
                opcion = "";
            }

            switch(opcion){
                case "Añadir Libro": Libreria.engadir(); break; 
                case "Consultar Libro": Libreria.consultaPrecio(); break;
                case "Visualizar Libros": Libreria.visualizar(); break;
                case "Eliminar sin Stock": Libreria.borrar(); break;
                case "Modificar Libro": Libreria.modificar(); break;
                default: exit = true; break;
            }
            
        } while(exit == false);
    }
    
}

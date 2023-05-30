/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pilascolas;

import javax.swing.JOptionPane;

/**
 *
 * @author Darwin Castaño
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Cola x = new Cola();
        
        x.EncolarOrdenado(0);
        x.EncolarOrdenado(5);
        x.EncolarOrdenado(-2);
        x.EncolarOrdenado(1);
        x.Encolar(100);
        x.Encolar(2);
        
        x.Ordenado();
        
        x.MostrarCola();
        
        
        
        /*
        int menu = 0;

        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog("Desea trabajar con: \n"
                    + "1) Pilas\n"
                    + "2) Colas\n"
                    + "3) Pilas y Colas\n"
                    + "4) Salir\n\n\n"
                    + "Ingresa una Opcion: "));
        
            switch (menu) {

            case 1:

                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            default:
                JOptionPane.showConfirmDialog(null, "Opción Incorrecta");
                break;

        }
    }
    while(menu != 4);
    */    
        
        
    }
    
}

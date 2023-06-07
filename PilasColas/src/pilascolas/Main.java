
package pilascolas;


import javax.swing.JOptionPane;

/**
 * @author Darwin Castaño
 */

public class Main {

    public static void main(String[] args) {
       
        Pila p1 = new Pila();
        Cola c1 = new Cola();
        int menu = 0;

        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog("Desea trabajar con: \n"
                    + "1) Pilas\n"
                    + "2) Colas\n"
                    + "3) Salir\n\n"
                    + "Ingresa una Opcion: "));
        
            switch (menu) {

            case 1:
                p1.menuPilas();
                break;

            case 2:
                c1.menuColas();
                break;

            case 3:
                JOptionPane.showMessageDialog(null, "Adios!!!");
                   
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                break;

        }
    }while(menu != 3);  
        
        
    }
    
}

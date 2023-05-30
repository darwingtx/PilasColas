
package estudiantesnotas;

import javax.swing.JOptionPane;

public class EstudiantesNotas {

    public static void main(String[] args) {
        
        ListaEst estudiantes = new ListaEst();
        int op = 0;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("***Menu Notas Estudiantes***\n\n"
            + "1) Registrar Estudiante y materias\n"
            + "2) Mostrar Lista Estudiante\n"
            + "3) Numero de estudiantes\n"
            + "0) Salir"));

            switch (op) {
                case 1:
                    estudiantes.InsertarFinal();
                    break;
                
                case 2:
                    estudiantes.MostrarLista();
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Hay " + estudiantes.getNumE()+ " estudiantes registrados");
                    break;

                case 0:
                JOptionPane.showMessageDialog(null, "Adios!!!");
                    break;

                default:
                JOptionPane.showMessageDialog(null, "Opción Incorrecta");
                    break;
            }
        } while (op!=0);
        
        
    }
    
}

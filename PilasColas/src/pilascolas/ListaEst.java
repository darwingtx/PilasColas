
package pilascolas;

import javax.swing.JOptionPane;

/**
 *
 * @author Darwin Castaño
 */
public class ListaEst {

    private NodoList punta;
    private int numE;

    public ListaEst() {
        this.punta = null;
        this.numE = 0;
    }

    public void menuList(){
        ListaEst estudiantes = this;
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
    
    public void InsertarFinal() {

        String cedula = JOptionPane.showInputDialog("Ingrese la cedula: ");
        String nomb = JOptionPane.showInputDialog("Ingrese el nombre: ");
        String apell = JOptionPane.showInputDialog("Ingrese el apellido: ");
        String carrera = JOptionPane.showInputDialog("Ingrese el nombre de la carrera: ");
        int op = 0;
        NodoList x = new NodoList(cedula, nomb, apell, carrera);
        NodoList p = punta;
        do {
            x.getMaterias().Encolar();
            op=Integer.parseInt(JOptionPane.showInputDialog(null,"Desea agregar otra materia:\n 1.Si.\n2.No.\n"));
        } while (op!=2);

        if (punta == null) {
            punta = x;
        } else {
            while (p.getLiga() != null) {
                p = p.getLiga();
            }
            p.setLiga(x);
        }
        numE++;
    }

    public int getNumE() {
        return numE;
    }
    public void MostrarLista() {
        if (!this.Vacio()) {
            String s = "";
            NodoList p = punta;
            while (p != null) {
                s = s + "Cedula: " + p.getCedula() + "\n" + "Estudiante: " + p.getNomb() 
                + " " + p.getApell() 
                + "\n"
                + "Carrera: " + p.getCarrera() + "\n\n" 
                + p.getMaterias().MostrarCola();
                p = p.getLiga();
            }
            JOptionPane.showMessageDialog(null, s);
        } else {
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }

    }

    public boolean Vacio() {
        return punta == null ? true : false;
    }
}

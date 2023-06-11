
package listaestudiantes;

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



    public void Reemplazar(int a, NodoList p) {
        switch(a){
            case 1:
                p.setNomb(JOptionPane.showInputDialog(null,"Nuevo Nombre: "));
                break;
            
            case 2:
                p.setCedula(JOptionPane.showInputDialog(null,"Nueva cedula: "));
                break;
            case 3:
                p.setCarrera(JOptionPane.showInputDialog(null,"Nueva Carrera: "));
                break;
            
            case 4:
                p.setApell(JOptionPane.showInputDialog(null,"Nuevo Apellido: "));
                break;
            case 5:
            
                String d = JOptionPane.showInputDialog(null,"¿Que materia?\n");
                p.getMaterias().Buscar(p.getMaterias().punta, d);
                break;
            
            case 6:
                p.setCedula(JOptionPane.showInputDialog(null,"Nueva cedula: "));
                p.setNomb(JOptionPane.showInputDialog(null,"Nuevo Nombre: "));
                p.setCarrera(JOptionPane.showInputDialog(null,"Nueva Carrera: "));
                p.setApell(JOptionPane.showInputDialog(null,"Nuevo Apellido: "));

                ColaList c1 = new ColaList();
                while(!p.getMaterias().ColaVacia()){


                }

                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion erronea");
                a = Integer.parseInt(JOptionPane.showInputDialog(null,"¿Que desea remplazar?\n" +
                "1)Nombre\n"
                +"2)Cedula\n"
                +"3)Carrera\n"
                +"4)Apellido\n"
                +"5)Materia\n"
                +"6)Todo\n"));
                Reemplazar(a, p);
                break;

        }
    }

    public void Buscar(NodoList p, String Cedula) {
        
        if(p == null){
            JOptionPane.showMessageDialog(null, "No esta el estudiante");
        }
        else if(p.getCedula().equals(Cedula)){
            int a = Integer.parseInt(JOptionPane.showInputDialog(null,"1)Mostar\n"+ "2)Reemplazar"));
            if(a==1){
                this.MostrarNodo(p);
            }
            else{
                a = Integer.parseInt(JOptionPane.showInputDialog(null,"¿Que desea remplazar?\n" +
                "1)Nombre\n"
                +"2)Cedula\n"
                +"3)Carrera\n"
                +"4)Apellido\n"
                +"5)Materia\n"
                +"6)Todo\n"));

                Reemplazar(a, p);
            }
        }
        else{
            Buscar(p.getLiga(), Cedula);
            }
    }

    public void menuList(){
        ListaEst estudiantes = this;
        int op = 0;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("***Menu Notas Estudiantes***\n\n"
            + "1) Registrar Estudiante y materias\n"
            + "2) Mostrar Lista Estudiante\n"
            + "3) Numero de estudiantes\n"
            +"4)Buscar\n"
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
                case 4:
                    if(!estudiantes.Vacio()){
                        String ced = JOptionPane.showInputDialog(null,"cedula");
                        estudiantes.Buscar(punta, ced);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Lista vacia");
                    }
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
    public void MostrarNodo(NodoList x) {
        if (!this.Vacio()) {
            String s = "";
            NodoList p = x;
                s = s + "Cedula: " + p.getCedula() + "\n" + "Estudiante: " + p.getNomb() 
                + " " + p.getApell() 
                + "\n"
                + "Carrera: " + p.getCarrera() + "\n\n" 
                + p.getMaterias().MostrarCola();
            JOptionPane.showMessageDialog(null, s);
        
        }
    }

    public boolean Vacio() {
        return punta == null ? true : false;
    }
}

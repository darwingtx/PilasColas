
package pilascolas;

import javax.swing.JOptionPane;

/**
 *
 * @author abela
 */

public class ColaList{
    //Atributos

    private NodoCola punta;
    private int tope;

    //Constructor
    public ColaList(){
       punta = null;
       tope = -1;
    }

    //devolver verdadero si esta vacio
    private boolean ColaVacia() {
        return punta == null ? true : false;
    }

    public void Encolar() {
        String mater = JOptionPane.showInputDialog("Ingrese el nombre de la materia: ");
        NodoCola x = new NodoCola(mater);       
        for(int i=1; i<=4; i++){
            float nota = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la nota " + i + ": "));
            x.getNotas().Apilar(nota);
        }
        NodoCola p = punta;
        if (punta == null) {
            punta = x;
        } else {
            while (p.getLiga() != null) {
                p = p.getLiga();
            }
            p.setLiga(x);
        }
       tope++;
        
    }
        //hacer endemonio, mientras desencola encola al final
    public void Encolar(NodoCola c1){
        NodoCola x=punta;
         if (punta == null) {
            punta = c1;
        } else {
            while (x.getLiga() != null) {
                x= x.getLiga();
            }
            x.setLiga(c1);
        }
        tope++;
    }

    

    public NodoCola Desencolar() {
        NodoCola p = punta;
        punta = punta.getLiga();
        p.setLiga(null);
        tope--;
        return p;
    }

    public void pasarDato(ColaList c1){
        while (!c1.ColaVacia()) {
            Encolar(c1.Desencolar());
        }
    }

    public String MostrarCola(){
       String s = "";
       NodoCola p = punta;
       ColaList aux = new ColaList();
       while(p!=null){
        p = this.Desencolar();
        s = s + "Materia: " + p.getMat() + "\n" + "Nota Final: " + String.format("%.02f",p.getNotas().Promedio()) +  "\n";
        aux.Encolar(p);
        p = punta;
       }
       this.pasarDato(aux);
       s = s + "------------------------------------\n";
       return s;
    }
    }


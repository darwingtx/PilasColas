/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilascolas;

/**
 *
 * @author abela
 */
import javax.swing.JOptionPane;

public class Cola {
    //Atributos

    private int tope;
    private Nodo punta;

    //Constructor
    Cola() {
        tope = -1;
        punta = null;

    }

    //devolver verdadero si esta vacio
    private boolean ColaVacia() {
        return punta == null ? true : false;
    }

    void Encolar(int d) {
        tope++;
        Nodo x = new Nodo();
        x.setDato(d);
        Nodo p = punta;
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

    public void Encolar(Nodo c1) {
        Nodo x = punta;
        if (punta == null) {
            punta = c1;
        } else {
            while (x.getLiga() != null) {
                x = x.getLiga();
            }
            x.setLiga(c1);
        }
        tope++;
    }

    //hacer endemonio, mientras desencola encola al final
    public Nodo Desencolar() {
        Nodo p = punta;
        punta = punta.getLiga();
        p.setLiga(null);
        tope--;
        return p;
    }

    void pasarDato(Cola c1) {
        while (!c1.ColaVacia()) {
            Encolar(c1.Desencolar());
        }
    }

    public void EncolarOrdenado(int d) {
        Cola x = new Cola();
        int aux = 0;
        boolean a = true;
        if (punta == null) {
            this.Encolar(d);
        } else {
            while (!this.ColaVacia()) {
                if (d > this.punta.getDato()) {
                    aux = Desencolar().getDato();
                    x.Encolar(aux);

                } else if (d < this.punta.getDato() && a) {
                    x.Encolar(d);
                    a = false;

                } else {
                    aux = Desencolar().getDato();
                    x.Encolar(aux);
                }
                if (this.punta == null && a) {
                    x.Encolar(d);
                    a = !a;
                }

            }
            this.pasarDato(x);
        }

    }

    public void MostrarCola() {
        String s = "";
        Nodo p = punta;
        Cola aux = new Cola();
        while (p != null) {
            p = this.Desencolar();
            s = s + "[" + p.getDato() + "]" + " ";
            aux.Encolar(p);
            p = punta;
        }
        this.pasarDato(aux);
        JOptionPane.showMessageDialog(null, s);
    }

    public void Ordenado() {
        int aux = 0;
        for (int i = 0; i <= this.tope; i++) {
            Cola x = new Cola();
            aux = Desencolar().getDato();
            while (!this.ColaVacia()) {
                if (aux < this.punta.getDato()) {
                    x.Encolar(aux);
                    aux = this.Desencolar().getDato();

                } else if (aux > this.punta.getDato()) {
                    x.Encolar(Desencolar());
                } else {
                    x.Encolar(aux);
                    aux = Desencolar().getDato();

                }

            }
            x.Encolar(aux);
            this.pasarDato(x);
        }
    }

}

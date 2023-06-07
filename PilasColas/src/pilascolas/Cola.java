package pilascolas;

/**
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

    public void pasarDato(Cola c1) {
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

                } else if (d < this.punta.getDato() && a ){
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
            s = s + "[" + p.getDato() + "] ";
            aux.Encolar(p);
            p = punta;
        }
        this.pasarDato(aux);
        JOptionPane.showMessageDialog(null, s);
    }

    public void Ordenado(boolean ba) {
        int aux = 0;
        for (int i = 0; i <= this.tope; i++) {
            Cola x = new Cola();
            aux = Desencolar().getDato();
            while (!this.ColaVacia()) {
                if (ba && aux < this.punta.getDato() || !ba && aux > this.punta.getDato()) {
                    x.Encolar(aux);
                    aux = this.Desencolar().getDato();
                } else if (aux > this.punta.getDato() || aux < this.punta.getDato()) {
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

    public void menuColas() {
        int menu = 0;
        Cola c1 = this;
        int d = 0;
        Boolean ord =true;
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog("Desea trabajar con: \n"
                    + "1) Encolar\n"
                    + "2) Desencolar\n"
                    + "3) Encolar Ordenado\n"
                    + "4) Ordenar\n"
                    + "5) Mostrar\n"
                    + "0) Salir\n\n\n"
                    + "Ingresa una Opcion: "));

            switch (menu) {
                case 1:
                    d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
                    c1.Encolar(d);

                    break;

                case 2:
                    if (!c1.ColaVacia()) {
                        c1.Desencolar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Cola vacia");
                    }
                    break;

                case 3:
                    d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
                    if(!c1.ColaVacia()){
                    c1.EncolarOrdenado(d);
                    }
                    else{
                        c1.Encolar(d);
                    }
                    break;
                case 4:
                    if (!c1.ColaVacia()) {
                        d = Integer.parseInt(JOptionPane.showInputDialog("¿De manera?"
                                + "\n1)Ascendente"
                                + "\n2)Descendente"));
                        ord = (d == 1) ? true : false;
                        c1.Ordenado(ord);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Cola vacia");
                    }

                    break;

                case 5:
                    if (c1.ColaVacia()) {
                        JOptionPane.showMessageDialog(null, "Cola vacia");
                    } else {
                        c1.MostrarCola();
                    }

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                    break;

            }
        } while (menu != 0);
    }

}

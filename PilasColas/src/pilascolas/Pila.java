package pilascolas;

import javax.swing.JOptionPane;

public class Pila {

    private int Tope;
    private Nodo punta;

    public Pila() {
        this.Tope = 0;
        this.punta = null;
    }

    boolean PilaVacia() {
        return punta == null ? true : false;
    }

    private void Push(int d) {
        Tope++;
        Nodo x = new Nodo(d);
        if (punta != null) {
            x.setLiga(punta);

        }
        punta = x;// Avanza Punta
    }

    private void Push(Nodo x) {
        Tope++;
        if (punta != null) {
            x.setLiga(punta);
            ;
        }
        punta = x;// Avanza Punta
    }

    private Nodo Pop() {
        Nodo aux = punta;
        Nodo p;
        p = punta;
        punta = punta.getLiga();
        p.setLiga(null);
        Tope--;
        return aux;
    }

    private void pasarDato(Pila p1) {
        while (!p1.PilaVacia()) {
            Push(p1.Pop());
        }
    }

    private void MostrarPila() {

        int d;
        String s = "";
        Pila P2 = new Pila();
        while (PilaVacia() != true) {
            d = Pop().getDato();
            s = s + "[" + d + "]\n";
            P2.Push(d);
        }
        JOptionPane.showMessageDialog(null, s);
        pasarDato(P2);

    }

    public void PushOrdenado(int d) {
        boolean a = true;
        Pila p1 = new Pila();
        if (PilaVacia() || punta.getDato() < d) {
            Push(d);
        } else if (punta.getDato() > d) {
            do {
                if (PilaVacia() || punta.getDato() < d) {
                    Push(d);
                    a = false;
                } else if (punta.getDato() > d & a) {
                    p1.Push(Pop());
                } else {
                    Push(p1.Pop());
                }
            } while (!p1.PilaVacia());
        }

    }

    public void Ordenar(boolean ord) {
        Pila P1 = new Pila();
        Pila P2 = new Pila();
        Nodo aux = null;
        P1.pasarDato(this);
        aux = P1.Pop();
        while (!P1.PilaVacia() || !P2.PilaVacia()) {
            if (!P1.PilaVacia()) {
                if ((aux.getDato() >= P1.punta.getDato() && ord) || (aux.getDato() <= P1.punta.getDato() && !ord)) {
                    P2.Push(aux);
                    aux = P1.Pop();
                } else {
                    P2.Push(P1.Pop());
                }
            }
            if (P1.PilaVacia() && !P2.PilaVacia()) {
                P1.pasarDato(P2);
                Push(aux);
                aux = P1.Pop();
            }
            if (P1.PilaVacia() && P2.PilaVacia()) {
                Push(aux);
            }
        }
    }

    public void Mover(Pila px) {
        if (!this.PilaVacia() && px.PilaVacia()) {
            while (px.PilaVacia() || (!this.PilaVacia() && punta.getDato() == px.punta.getDato())) {
                px.Push(Pop());
            }
        } else if (!this.PilaVacia() && !px.PilaVacia() && px.Tope != 4 && punta.getDato() == px.punta.getDato()) {
            while (!this.PilaVacia() && punta.getDato() == px.punta.getDato()) {
                px.Push(Pop());
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se puede hacer este movimiento");
        }
    }

    public String MostrarJuego(Pila p1, Pila p2, Pila p3) {
        String s = "";
        int df1 = 4 - p1.Tope;
        int df2 = 4 - p2.Tope;
        int df3 = 4 - p3.Tope;
        Pila a1 = new Pila();
        Pila a2 = new Pila();
        Pila a3 = new Pila();
        for (int i = 0; i < 4; i++) {
            int d1 = 0, d2 = 0, d3 = 0;
            if (df1 == 0) {
                d1 = p1.Pop().getDato();
                df1++;
                a1.Push(d1);
            }
            if (df2 == 0) {
                d2 = p2.Pop().getDato();
                df2++;
                a2.Push(d2);
            }
            if (df3 == 0) {
                d3 = p3.Pop().getDato();
                df3++;
                a3.Push(d3);
            }
            df1--;
            df3--;
            df2--;
            s = s + "[" + d1 + "]   " + "[" + d2 + "]   " + "[" + d3 + "]\n";
        }
        p1.pasarDato(a1);
        p2.pasarDato(a2);
        p3.pasarDato(a3);
        return s;
    }

    public boolean win() {
        boolean uno = true;
        boolean dos = true;
        Pila a1 = new Pila();
        int i = 0;

        if (!this.PilaVacia()) {
            while (!this.PilaVacia()) {
                i++;
                int d = Pop().getDato();
                a1.Push(d);
                if (d != 1) {
                    uno = false;
                }
                if (d != 2) {
                    dos = false;
                }
            }
            this.pasarDato(a1);
        }

        return (uno || dos) && i == 4;
    }

    public void Juego() {
        Pila p1 = new Pila();
        Pila p2 = new Pila();
        Pila p3 = new Pila();

        for (int i = 0; i < 2; i++) {
            p1.Push(1);
            p2.Push(2);
            p1.Push(2);
            p2.Push(1);
        }

        boolean ba = false;
        int op = 80, mov = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("***Menu Principal***\n\n"
                    + "1) ¡JUGAR!\n"
                    + "0) Salir\n"
                    + "Ingrese la opcion: "));

            switch (op) { // validar si estan vacia la que se va a mover

                case 1:
                    while (!ba) {
                        // 1. p1 a p2
                        // 2. p1 a p3
                        // 3. p2 a p1
                        // 4. p2 a p3
                        // 5. p3 a p1
                        // 6. p3 a p2
                        mov = Integer.parseInt(JOptionPane.showInputDialog("JUEGO\n\n"
                                + MostrarJuego(p1, p2, p3)
                                + "P1--P2--P3"
                                + "\n\n1.p1 a p2\n"
                                + "2.p1 a p3\n"
                                + "3.p2 a p1\n"
                                + "4.p2 a p3\n"
                                + "5.p3 a p1\n"
                                + "6.p3 a p2\n"
                                + "0.Salir\n\n\n"
                                + "Ingrese la opcion: "));

                        switch (mov) {
                            case 1:
                                p1.Mover(p2);
                                break;
                            case 2:
                                p1.Mover(p3);
                                break;
                            case 3:
                                p2.Mover(p1);
                                break;
                            case 4:
                                p2.Mover(p3);
                                break;
                            case 5:
                                p3.Mover(p1);
                                break;
                            case 6:
                                p3.Mover(p2);
                                break;
                            case 0:
                                JOptionPane.showMessageDialog(null, "Ha terminado el juego :'/ ");
                                ;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                                break;
                        }
                        if ((p1.win() && p2.win()) || (p2.win() && p3.win()) || (p1.win() && p3.win())) {
                            JOptionPane.showMessageDialog(null, MostrarJuego(p1, p2, p3));
                            JOptionPane.showMessageDialog(null, "¡Has ganado el juego!");
                            ba = true;
                        }
                    }
                    break;

            }

        } while (op != 0);

    }

    public void menuPilas() {
        Pila p1 = this;
        int menu = 0;
        int d = 0;
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog("Desea trabajar con: \n"
                    + "1) Apilar\n"
                    + "2) Desapilar\n"
                    + "3) Apilar Ordenado\n"
                    + "4) Ordenar\n"
                    + "5) Mostrar\n"
                    + "6) Juego\n"
                    + "0) Salir\n\n\n"
                    + "Ingresa una Opcion: "));

            switch (menu) {

                case 1:
                    d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
                    p1.Push(d);
                    break;

                case 2:
                    p1.Pop();
                    break;

                case 3:
                    d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
                    p1.PushOrdenado(d);
                    break;
                case 4:
                    d = Integer.parseInt(JOptionPane.showInputDialog("¿De manera?"
                            + "\n1)Ascendente"
                            + "\n2)Descendente"));
                    Boolean ord = (d == 1) ? true : false;
                    p1.Ordenar(ord);
                    break;

                case 5:
                    p1.MostrarPila();
                    break;

                case 6:
                    Juego();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo al menu principal");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                    break;
            }
        } while (menu != 0);
    }

}

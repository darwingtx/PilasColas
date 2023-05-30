package pilascolas;

import javax.swing.JOptionPane;

public class Pila {

    private int limite, Tope, vec[];

    public Pila(int n) {

        this.limite = n - 1;
        this.Tope = -1;
        this.vec = new int[n];
    }

    boolean PilaVacia() {

        if (Tope == -1) {

            return true;

        } else {

            return false;

        }

    }
    
    boolean PilaLlena() {

        boolean b = false;

        if (Tope == limite) {

            b = true;

        }

        return b;

    }

    void Push(int d) {

        Tope++;
        vec[Tope] = d;

    }

    int Pop() {

        int Aux = vec[Tope];
        Tope--;
        return Aux;

    }

    void PasarDato(Pila P) {

        int d;

        while (P.PilaVacia() != true) {

            d = P.Pop();

            Push(d);

        }

    }

    void MostrarDato() {

        int d;
        String s = "";
        Pila P2 = new Pila(limite + 1);
        while (PilaVacia() != true) {

            d = Pop();
            s = s + d + "\n";
            P2.Push(d);
        }
        JOptionPane.showMessageDialog(null, s);
        PasarDato(P2);

    }

    void PushOrdenado(int d) {

        int x;

        Pila P2 = new Pila(limite + 1);

        while (PilaVacia() != true) {
            x = Pop();
            P2.Push(x);

        }
        Push(d);
        PasarDato(P2);

    }
    public void Ordenar() {
        Pila P1 = new Pila(this.limite);
        Pila P2 = new Pila(this.limite);
        int aux = 0;

       PasarDato(P1);
       aux=P1.Pop();
       while(!P1.PilaVacia() || !P2.PilaVacia()){
            if(!P1.PilaVacia()){
                if(aux >= P1.vec[Tope]){
                    P2.Push(aux);
                    aux=P1.Pop();
                } else{
                    P2.Push(P1.Pop());
                }
            }
              if(P1.PilaVacia() && !P2.PilaVacia()){
                P2.PasarDato(P1);
                Push(aux);
                aux=P1.Pop();
              }  
              if(P1.PilaVacia() && P2.PilaVacia()){
                Push(aux);
              }
       }
    }

    void Mover(Pila px) {
        if (!this.PilaVacia() && !px.PilaLlena()) {
            while (vec[Tope] == px.vec[px.Tope]) {
                px.Push(Pop());
            }
        } else if (!this.PilaVacia() && px.PilaVacia()) {
            px.Push(Pop());
        } else {
            JOptionPane.showMessageDialog(null, "No se puede hacer este movimiento");
        }
    }

     public String MostrarJuego(Pila p1, Pila p2, Pila p3) {
        int d, r, a;
        String s = "";
        Pila P2 = new Pila(limite + 1);
        if (!p3.PilaVacia()) {
            while (PilaVacia() != true) {

                d = p1.Pop();
                r = p2.Pop();
                a = p3.Pop();
                s = s + "[" + d + "]" + "\t" + "[" + r + "]" + "\t" + "[" + a + "]" + "\t" + "\n";
                P2.Push(d);
            }
            
            PasarDato(P2);
        }
        else{
            
        }
        
        return s;

    }

    void Juego() {
        Pila p1 = new Pila(4);
        Pila p2 = new Pila(4);
        Pila p3 = new Pila(4);

        while (!p1.PilaLlena() && !p2.PilaLlena()) {
            p1.Push(1);
            p2.Push(2);
            p1.Push(2);
            p2.Push(1);
        }

        boolean ba = false;
        int op = 80, mov = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("***Menu Principal***\n\n"
                    + "1.JUGAR"
                    + "8.Salir\n\n\n"
                    + "Ingrese la opcion: "));

            switch (op) { //validar si estan vacia la que se va a mover

                case 1:
                    while (!ba) {
                        //1. p1 a p2 
                        //2. p1 a p3
                        //3. p2 a p1
                        //4. p2 a p3
                        //5. p3 a p1
                        //6. p3 a p2
                        mov = Integer.parseInt(JOptionPane.showInputDialog("***Menu Principal***\n\n"
                                + MostrarJuego(p1, p2, p3)
                                + "\n\n1.p1 a p2\n"
                                + "2.p1 a p3\n"
                                + "3.p2 a p1\n"
                                + "4.p2 a p3\n"
                                + "5.p3 a p1\n"
                                + "6.p3 a p2\n"
                                + "7.Apilar Ordenado\n"
                                + "8.Salir\n\n\n"
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
                            case 7:

                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                                break;
                        }
                    }
                    break;

            }

        } while (op != 0);

    }
}

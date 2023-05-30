package estudiantesnotas;

/**
 *
 * @author Darwin Castaño
 */
public class Pila {

    private int limite, Tope;
    private float vec[];

    public Pila(int n) {

        this.limite = n - 1;
        this.Tope = -1;
        this.vec = new float[n];
    }

    public boolean PilaVacia() {
        return Tope == -1 ? true : false;
    }

    public boolean PilaLlena() {
        return Tope == limite ? true : false;
    }

    public void Push(float d) {
        Tope++;
        vec[Tope] = d;

    }

    public float Pop() {

        float Aux = vec[Tope];
        Tope--;
        return Aux;

    }

    public void PasarDato(Pila P) {
        float d;
        while (P.PilaVacia() != true) {
            d = P.Pop();
            Push(d);
        }

    }

    public float Promedio() {
        Pila aux = new Pila(4);
        float prom = 0, x = 0;
        while (!this.PilaVacia()) {
            x = this.Pop();
            aux.Push(x);
            prom = x + prom;
        }
        this.PasarDato(aux);
        prom = prom / (Tope + 1);
        return prom;
    }


    /*
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
     */
}

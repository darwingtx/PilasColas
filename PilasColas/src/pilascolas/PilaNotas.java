
package pilascolas;
/**
 *
 * @author Darwin Castaño
 */
public class PilaNotas {

    private int limite, Tope;
    private float vec[];

    public PilaNotas(int n) {

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

    public void Apilar(float d) {
        Tope++;
        vec[Tope] = d;

    }

    public float Desapilar() {
        float Aux = vec[Tope];
        Tope--;
        return Aux;
    }

    public void PasarDato(PilaNotas P) {
        float d;
        while (P.PilaVacia() != true) {
            d = P.Desapilar();
            Apilar(d);
        }

    }

    public float Promedio() {
        PilaNotas aux = new PilaNotas(4);
        float prom = 0, x = 0;
        while (!this.PilaVacia()) {
            x = this.Desapilar();
            aux.Apilar(x);
            prom = x + prom;
        }
        this.PasarDato(aux);
        prom = prom / 4;
        return prom;
    }

}

package pilascolas;

public class Nodo {

    // Atributos
    public int Dato;
    public Nodo Liga;

    public Nodo(int Dato) {
        this.Dato = Dato;
        Liga = null;
    }

    public Nodo() {
        Dato = 0;
        Liga = null;
    }

    public int getDato() {
        return Dato;
    }

    public void setDato(int dato) {
        Dato = dato;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo liga) {
        Liga = liga;
    }
}
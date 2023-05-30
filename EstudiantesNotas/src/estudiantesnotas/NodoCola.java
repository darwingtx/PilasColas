
package estudiantesnotas;

/**
 *
 * @author abela
 */
public class NodoCola {

    //Atributos
    private String mat;
    private Pila notas;
    private NodoCola Liga;

    public NodoCola(String mat) {
        notas = new Pila(4);
        this.mat = mat;
        Liga = null;
    }

    public String getMat() {
        return mat;
    }


    public void setMat(String mat) {
        this.mat = mat;
    }
/*
    public float getNotas() {
        float x = notas.Promedio();
        return x;
    }
*/

    public Pila getNotas() {
        return notas;
    }

    public NodoCola getLiga() {
        return Liga;
    }

    public void setLiga(NodoCola Liga) {
        this.Liga = Liga;
    }
    

    public void setNotas(float d) {
        notas.Push(d);
    }

}

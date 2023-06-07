
package listaestudiantes;



/**
 *
 * @author abela
 */
public class NodoCola {

    //Atributos
    private String mat;
    private PilaNotas notas;
    private NodoCola Liga;

    public NodoCola(String mat) {
        notas = new PilaNotas(4);
        this.mat = mat;
        Liga = null;
    }

    public String getMat() {
        return mat;
    }


    public void setMat(String mat) {
        this.mat = mat;
    }

    public PilaNotas getNotas() {
        return notas;
    }

    public NodoCola getLiga() {
        return Liga;
    }

    public void setLiga(NodoCola Liga) {
        this.Liga = Liga;
    }
    

    public void setNotas(float d) {
        notas.Apilar(d);
    }

}

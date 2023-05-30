/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiantesnotas;

/**
 *
 * @author abela
 */
public class NodoList {

    //Atributos del nodo
    private String nomb, apell, carrera, cedula;
    private NodoList liga;
    private ColaList materias;
    
    //Constructos
    public NodoList(String cedula, String nombre, String apell, String carrera){
          this.cedula = cedula;
          this.nomb = nombre;
          this.apell = apell;
          this.carrera = carrera;
          this.materias = new ColaList();
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nombre) {
        this.nomb = nombre;
    }

    public String getApell() {
        return apell;
    }

    public void setApell(String apell) {
        this.apell = apell;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public NodoList getLiga() {
        return liga;
    }

    public void setLiga(NodoList liga) {
        this.liga = liga;
    }

    public ColaList getMaterias() {
        return materias;
    }

    public void setMaterias(ColaList materias) {
         this.materias = materias;
     }
    
    
    
    
}

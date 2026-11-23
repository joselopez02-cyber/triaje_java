package triaje;

public class NodoArbol {
    Paciente datos;
    NodoArbol izquierdo;
    NodoArbol derecho;

    public NodoArbol(Paciente paciente) {
        this.datos = paciente;
        this.izquierdo = null;
        this.derecho = null;
    }
}

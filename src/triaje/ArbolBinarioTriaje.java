package triaje;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioTriaje {
    private NodoArbol raiz;

    public ArbolBinarioTriaje() {
        raiz = null;
    }

    // Inserción recursiva según puntaje de riesgo
    public void insertar(Paciente nuevoPaciente) {
        raiz = insertarRecursivo(raiz, nuevoPaciente);
    }

    private NodoArbol insertarRecursivo(NodoArbol actual, Paciente paciente) {
        if (actual == null) {
            return new NodoArbol(paciente);
        }
        if (paciente.getPuntajeRiesgo() < actual.datos.getPuntajeRiesgo()) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, paciente);
        } else {
            actual.derecho = insertarRecursivo(actual.derecho, paciente);
        }
        return actual;
    }

    // Recorrido InOrden (Izquierda -> Raíz -> Derecha)
    public void mostrarInOrden() {
        if (raiz == null) {
            System.out.println("El árbol se encuentra vacío.");
            return;
        }
        recorrerInOrden(raiz);
    }

    private void recorrerInOrden(NodoArbol nodo) {
        if (nodo == null) return;
        recorrerInOrden(nodo.izquierdo);
        System.out.println(nodo.datos);
        recorrerInOrden(nodo.derecho);
    }

    // Lista de pacientes ordenados de menor a mayor gravedad
    public List<Paciente> obtenerInOrden() {
        List<Paciente> lista = new ArrayList<>();
        llenarInOrden(raiz, lista);
        return lista;
    }

    private void llenarInOrden(NodoArbol nodo, List<Paciente> lista) {
        if (nodo == null) return;
        llenarInOrden(nodo.izquierdo, lista);
        lista.add(nodo.datos);
        llenarInOrden(nodo.derecho, lista);
    }

    // Respaldo en archivo TXT. Retorna la cantidad de pacientes respaldados.
    public int guardarRespaldoTxt(String ruta) throws IOException {
        List<Paciente> pacientes = obtenerInOrden();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (PrintWriter escritor = new PrintWriter(ruta, StandardCharsets.UTF_8)) {
            escritor.println("RESPALDO TRIAJE MEDICO - " + LocalDateTime.now().format(formato));
            escritor.println("Total pacientes: " + pacientes.size());
            escritor.println("Riesgo|Nombre|Cedula|Sintoma");
            for (Paciente p : pacientes) {
                escritor.println(p.getPuntajeRiesgo() + "|" + p.getNombre() + "|"
                        + p.getCedula() + "|" + p.getSintoma());
            }
        }
        return pacientes.size();
    }

    // Búsqueda binaria por puntaje de riesgo
    public Paciente buscarPorRiesgo(int puntaje) {
        return buscarRecursivo(raiz, puntaje);
    }

    private Paciente buscarRecursivo(NodoArbol actual, int puntaje) {
        if (actual == null) return null;
        if (actual.datos.getPuntajeRiesgo() == puntaje) return actual.datos;
        if (puntaje < actual.datos.getPuntajeRiesgo()) {
            return buscarRecursivo(actual.izquierdo, puntaje);
        }
        return buscarRecursivo(actual.derecho, puntaje);
    }

    // Paciente más crítico (extremo derecho del árbol)
    public Paciente obtenerMasCritico() {
        if (raiz == null) return null;
        NodoArbol actual = raiz;
        while (actual.derecho != null) {
            actual = actual.derecho;
        }
        return actual.datos;
    }

    // Visualización jerárquica del árbol en consola
    public void imprimirEstructura() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
        imprimirNodo(raiz, "", true, "RAÍZ");
    }

    private void imprimirNodo(NodoArbol nodo, String sangria, boolean esUltimo, String rama) {
        if (nodo == null) return;

        System.out.print(sangria);
        System.out.print(esUltimo ? "└── " : "├── ");
        System.out.println("[" + rama + "] " + nodo.datos.getNombre()
                + " (Riesgo: " + nodo.datos.getPuntajeRiesgo() + ")");

        sangria += esUltimo ? "    " : "│   ";

        if (nodo.izquierdo != null) {
            imprimirNodo(nodo.izquierdo, sangria, nodo.derecho == null, "IZQ <");
        }
        if (nodo.derecho != null) {
            imprimirNodo(nodo.derecho, sangria, true, "DER >=");
        }
    }
}

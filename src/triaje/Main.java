package triaje;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    // Lee un entero dentro de un rango; repite hasta que sea válido
    private static int leerEntero(Scanner sc, String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.hasNextLine() ? sc.nextLine().trim() : "";
            try {
                int valor = Integer.parseInt(linea);
                if (valor >= min && valor <= max) return valor;
            } catch (NumberFormatException e) {
                // se repite la solicitud
            }
            System.out.println("Valor inválido. Ingrese un número entre " + min + " y " + max + ".");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        ArbolBinarioTriaje arbolTriaje = new ArbolBinarioTriaje();

        // Carga inicial de datos de prueba
        arbolTriaje.insertar(new Paciente("Carlos Mendoza", "10984512", "Dolor torácico leve", 50));       // Raíz
        arbolTriaje.insertar(new Paciente("Ana Lucía Gómez", "52418963", "Esguince de tobillo", 25));      // Izquierda
        arbolTriaje.insertar(new Paciente("Jorge Ramírez", "80147258", "Dificultad respiratoria", 80));    // Derecha
        arbolTriaje.insertar(new Paciente("María Fernanda Ruiz", "10203040", "Fiebre moderada", 15));      // Izquierda de 25
        arbolTriaje.insertar(new Paciente("Luis Eduardo Torres", "79456123", "Trauma craneoencefálico", 95)); // Derecha de 80

        int opcion = 0;

        do {
            System.out.println("\n==============================================");
            System.out.println("   SISTEMA DE TRIAJE MÉDICO - ÁRBOL BINARIO   ");
            System.out.println("==============================================");
            System.out.println("1. Registrar nuevo paciente en el árbol");
            System.out.println("2. Visualizar jerarquía del Árbol Binario");
            System.out.println("3. Listar pacientes ordenados (Recorrido InOrden)");
            System.out.println("4. Consultar paciente más crítico (Extremo Derecho)");
            System.out.println("5. Buscar paciente por puntaje de riesgo");
            System.out.println("6. Respaldar pacientes en archivo TXT");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            if (!sc.hasNextLine()) break;
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                continue;
            }

            System.out.println();
            switch (opcion) {
                case 1:
                    System.out.print("Nombre del paciente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cédula: ");
                    String cedula = sc.nextLine();
                    System.out.print("Síntoma principal: ");
                    String sintoma = sc.nextLine();
                    int riesgo = leerEntero(sc, "Puntaje de riesgo (1 - 100): ", 1, 100);

                    arbolTriaje.insertar(new Paciente(nombre, cedula, sintoma, riesgo));
                    System.out.println("Paciente insertado correctamente en la estructura.");
                    break;

                case 2:
                    System.out.println("--- ESTRUCTURA JERÁRQUICA DE NODOS ---");
                    arbolTriaje.imprimirEstructura();
                    break;

                case 3:
                    System.out.println("--- LISTADO ORDENADO POR GRAVEDAD (INORDEN) ---");
                    arbolTriaje.mostrarInOrden();
                    break;

                case 4:
                    Paciente critico = arbolTriaje.obtenerMasCritico();
                    System.out.println(critico != null
                            ? "ALERTA MÁXIMA: " + critico
                            : "No hay pacientes registrados.");
                    break;

                case 5:
                    int buscar = leerEntero(sc, "Ingrese el puntaje de riesgo a buscar: ", 1, 100);
                    Paciente encontrado = arbolTriaje.buscarPorRiesgo(buscar);
                    System.out.println(encontrado != null
                            ? "Resultado encontrado: " + encontrado
                            : "No existe un paciente con ese puntaje exacto.");
                    break;

                case 6:
                    String ruta = "respaldo_triaje.txt";
                    try {
                        int total = arbolTriaje.guardarRespaldoTxt(ruta);
                        Path completa = Paths.get(ruta).toAbsolutePath();
                        System.out.println("Respaldo creado con " + total + " paciente(s).");
                        System.out.println("Archivo: " + completa);
                    } catch (IOException e) {
                        System.out.println("No se pudo crear el respaldo: " + e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 7);

        sc.close();
    }
}

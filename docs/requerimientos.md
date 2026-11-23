# Requerimientos del sistema: Triaje Médico con Árbol Binario

**Autor:** Juan José Lope Sarmiento (código 40938)

**Problema:** una clínica de urgencias necesita clasificar a los pacientes según su puntaje de riesgo clínico (escala de 1 a 100), con rapidez y orden, sin depender de bases de datos externas.

**Solución:** aplicación de consola en C# (.NET) y su migración a Java, que organiza a los pacientes en un Árbol Binario de Búsqueda (BST).

---

## 1. Requerimientos funcionales (RF)

| ID | Requerimiento | Criterio de aceptación |
|----|---------------|------------------------|
| RF-01 | Registrar un paciente con nombre, cédula, síntoma principal y puntaje de riesgo (1 a 100). | Al registrar, el sistema confirma "Paciente insertado correctamente". |
| RF-02 | El primer paciente ingresado se establece como la raíz del árbol. | Con el árbol vacío, el primer paciente aparece como `[RAÍZ]`. |
| RF-03 | Si el puntaje es menor al del nodo evaluado, el paciente va a la rama izquierda (prioridad moderada). | Un paciente con riesgo 15 queda a la izquierda de uno con riesgo 25. |
| RF-04 | Si el puntaje es mayor o igual, el paciente va a la rama derecha (prioridad crítica). | Un paciente con riesgo 50 frente a un nodo de 50 queda a la derecha. |
| RF-05 | Mostrar la jerarquía del árbol en pantalla. | La opción 2 dibuja el árbol con ramas `IZQ <` y `DER >=`. |
| RF-06 | Listar los pacientes de menor a mayor gravedad con el recorrido InOrden. | La opción 3 muestra los riesgos en orden ascendente (15, 25, 50, 80, 95). |
| RF-07 | Buscar un paciente por puntaje de riesgo exacto. | Al buscar 15 se muestra a María Fernanda Ruiz; al buscar 77 se informa que no existe. |
| RF-08 | Detectar automáticamente al paciente más crítico (nodo extremo derecho). | La opción 4 muestra al paciente de mayor puntaje (95). |
| RF-09 | Respaldar los pacientes en un archivo TXT. | La opción 6 crea `respaldo_triaje.txt` con todos los pacientes ordenados por gravedad. |

## 2. Requerimientos no funcionales (RNF)

| ID | Requerimiento |
|----|---------------|
| RNF-01 | El sistema no debe depender de bases de datos externas; los datos viven en memoria y se respaldan en TXT. |
| RNF-02 | Debe aplicar Programación Orientada a Objetos, con responsabilidades separadas en `Paciente`, `NodoArbol`, `ArbolBinarioTriaje` y `Program`/`Main`. |
| RNF-03 | La inserción y la búsqueda deben ser recursivas, con costo promedio O(log n). |
| RNF-04 | Debe validar entradas inválidas (texto o puntaje fuera de 1 a 100) sin cerrarse. |
| RNF-05 | Debe ejecutarse por consola en .NET 8.0 o superior (C#) y en Java 17 o superior. |
| RNF-06 | El archivo de respaldo se guarda en codificación UTF-8 para conservar las tildes. |
| RNF-07 | El código debe estar documentado con comentarios y publicado en GitHub. |

## 3. Requerimientos de dominio (RD)

| ID | Regla de dominio |
|----|------------------|
| RD-01 | El triaje clasifica a los pacientes de urgencias según su riesgo clínico. |
| RD-02 | Un puntaje bajo indica prioridad moderada y un puntaje alto indica prioridad crítica. |
| RD-03 | El paciente más grave es el de mayor puntaje de riesgo. |
| RD-04 | Dos pacientes con el mismo puntaje se tratan con igual gravedad; el posterior se ubica a la derecha. |
| RD-05 | Cada paciente se identifica por su cédula y se describe con un síntoma principal. |
| RD-06 | La escala de riesgo válida va de 1 a 100. |

## 4. Trazabilidad

| Requerimiento | Clase / método (C#) | Clase / método (Java) |
|---------------|--------------------|-----------------------|
| RF-01, RF-02, RF-03, RF-04 | `ArbolBinarioTriaje.Insertar` | `ArbolBinarioTriaje.insertar` |
| RF-05 | `ImprimirEstructura` | `imprimirEstructura` |
| RF-06 | `MostrarInOrden` | `mostrarInOrden` |
| RF-07 | `BuscarPorRiesgo` | `buscarPorRiesgo` |
| RF-08 | `ObtenerMasCritico` | `obtenerMasCritico` |
| RF-09 | `GuardarRespaldoTxt` | `guardarRespaldoTxt` |

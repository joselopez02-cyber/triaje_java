# Backlog del producto: Triaje Médico con Árbol Binario

**Autor:** Juan José Lope Sarmiento (código 40938), desarrollo individual.

**Escala de prioridad:** Alta, Media, Baja. **Estimación:** puntos de historia (1, 2, 3, 5).

## Épicas

- **E1:** Estructura de datos (árbol binario)
- **E2:** Consultas y reportes
- **E3:** Persistencia (respaldo)
- **E4:** Migración y entrega

## Historias de usuario

| # | Épica | Historia de usuario | Req. | Prioridad | Puntos | Sprint | Estado |
|---|-------|---------------------|------|-----------|--------|--------|--------|
| HU-01 | E1 | Como enfermero, quiero registrar un paciente para incluirlo en el triaje. | RF-01 | Alta | 2 | 1 | Hecho |
| HU-02 | E1 | Como sistema, quiero ubicar al paciente según su puntaje para mantener el orden del árbol. | RF-02, RF-03, RF-04 | Alta | 3 | 1 | Hecho |
| HU-03 | E2 | Como médico, quiero ver la lista ordenada por gravedad para decidir a quién atender. | RF-06 | Alta | 2 | 1 | Hecho |
| HU-04 | E2 | Como médico, quiero conocer al paciente más crítico para atenderlo primero. | RF-08 | Alta | 1 | 1 | Hecho |
| HU-05 | E2 | Como enfermero, quiero buscar un paciente por puntaje para consultar un caso específico. | RF-07 | Media | 2 | 2 | Hecho |
| HU-06 | E2 | Como administrador, quiero ver la jerarquía del árbol para verificar su estructura. | RF-05 | Media | 3 | 2 | Hecho |
| HU-07 | E3 | Como administrador, quiero respaldar los pacientes en un TXT para no perder información. | RF-09 | Media | 2 | 2 | Hecho |
| HU-08 | E1 | Como usuario, quiero que el sistema valide mis entradas para que no se cierre por errores. | RNF-04 | Media | 2 | 2 | Hecho |
| HU-09 | E4 | Como desarrollador, quiero migrar la solución a Java para comparar ecosistemas. | RNF-05 | Media | 5 | 3 | Hecho |
| HU-10 | E4 | Como estudiante, quiero un repositorio con código y documentación para entregar el proyecto. | RNF-07 | Alta | 2 | 3 | En curso |
| HU-11 | E4 | Como estudiante, quiero una presentación del ecosistema, la migración y el repositorio. | Entrega | Alta | 3 | 3 | Hecho |

## Criterios de aceptación

**HU-01:** al elegir la opción 1 e ingresar los cuatro datos, el sistema confirma la inserción.

**HU-02:** insertando 50, 25, 80, 15 y 95, el árbol queda con raíz 50, hijos 25 y 80, y los hijos 15 (de 25) y 95 (de 80).

**HU-03:** la opción 3 muestra los pacientes con riesgo ascendente.

**HU-04:** la opción 4 muestra al paciente con el mayor puntaje; con el árbol vacío informa que no hay pacientes.

**HU-05:** la opción 5 devuelve al paciente con ese puntaje exacto o informa que no existe.

**HU-06:** la opción 2 dibuja el árbol con ramas `IZQ <` y `DER >=`.

**HU-07:** la opción 6 crea `respaldo_triaje.txt` con encabezado, total y un paciente por línea en orden ascendente.

**HU-08:** un texto o un puntaje fuera de 1 a 100 muestra un mensaje y vuelve a pedir el dato.

**HU-09:** la versión Java ofrece el mismo menú y produce los mismos resultados que la de C#.

**HU-10:** el repositorio contiene `csharp/`, `java/`, `docs/` y un `README.md`.

**HU-11:** la presentación cubre el ecosistema .NET, la migración a Java y el repositorio.

## Definición de terminado

- El código compila y se probó con los datos de ejemplo.
- La funcionalidad existe en C# y en Java.
- Está subido al repositorio con un commit descriptivo.

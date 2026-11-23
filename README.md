# Triaje Médico con Árbol Binario (Java)

**Autor:** Juan José Lope Sarmiento (código 40938)

Migración a Java (JDK 17 o superior) del sistema de triaje desarrollado en C#. Mismas clases, mismo menú y misma opción de respaldo en TXT.

## Estructura

| Archivo | Responsabilidad |
|---------|-----------------|
| `src/triaje/Paciente.java` | Entidad de negocio |
| `src/triaje/NodoArbol.java` | Unidad estructural del árbol |
| `src/triaje/ArbolBinarioTriaje.java` | Inserción, InOrden, búsqueda, más crítico, dibujo y respaldo |
| `src/triaje/Main.java` | Menú interactivo |
| `docs/requerimientos.md` | Requerimientos funcionales, no funcionales y de dominio |
| `docs/backlog.md` | Backlog con historias de usuario |

## Ejecución

```
javac -encoding UTF-8 -d out src/triaje/*.java
java -cp out triaje.Main
```

O abrir la carpeta en IntelliJ, Eclipse o VS Code y ejecutar `Main.java`. El respaldo `respaldo_triaje.txt` se crea en la carpeta desde donde se ejecuta.

## Equivalencias C# a Java

| C# | Java |
|----|------|
| `{ get; set; }` | atributos privados con getters |
| `Console.WriteLine` | `System.out.println` |
| `Console.ReadLine` | `Scanner.nextLine` |
| `int.TryParse` | `Integer.parseInt` con `try/catch` |
| `StreamWriter` | `PrintWriter` |
| `namespace` | `package` |
| `Paciente?` (nullable) | referencia que puede ser `null` |

## Versión en C#

La solución original está en el repositorio `triaje-csharp`.

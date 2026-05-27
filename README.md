# Proyecto Final - Programación Orientada a Objetos

Este repositorio contiene la entrega final del curso de Programación Orientada a Objetos (Actividades 3, 4 y 5) integradas en una única aplicación con Interfaz Gráfica (GUI) construida en Java Swing.

## Estructura del Proyecto

El menú principal da acceso a los siguientes módulos:

1. **Actividad 3 - Notas y Figuras:**
   - **Notas:** Permite ingresar 5 notas y calcula el promedio, desviación estándar, nota mayor y nota menor.
   - **Figuras Geométricas:** Calcula el volumen y la superficie de un Cilindro, una Esfera y una Pirámide utilizando herencia y polimorfismo.

2. **Actividad 4 - Excepciones:**
   - Un compendio de 5 ejercicios interactivos adaptados desde consola a GUI. Demuestra el manejo robusto de errores (`try/catch/finally`) para eventos como división por cero, formato de números inválido, validaciones de constructores (ej. Vendedores menores de edad) y lectura segura de archivos.

3. **Actividad 5 - Sistema CRUD (Biblioteca):**
   - Una aplicación completa de gestión de inventario de libros que cumple con el patrón **CRUD** (Create, Read, Update, Delete) haciendo uso de archivos secuenciales (`RandomAccessFile`). La información ingresada en la tabla persiste físicamente en el disco.

## Requisitos
- **Java Runtime Environment (JRE)** 8 o superior.
- **Java Development Kit (JDK)** 8 o superior (Solo si se desea compilar desde el código fuente).

## Instrucciones de Ejecución Rápida

Para facilitar la evaluación, se incluye el ejecutable compilado en la raíz del proyecto. 

Para ejecutar el programa directamente:
1. Abre una terminal o consola de comandos en la carpeta raíz del proyecto.
2. Ejecuta el siguiente comando:
   ```bash
   java -jar Ejecutable_Proyecto.jar
   ```

## Compilación desde Código Fuente

Si deseas recompilar el proyecto desde el código fuente, asegúrate de estar en la raíz de este directorio y ejecuta:

1. Crear el directorio de binarios (si no existe):
   ```bash
   mkdir bin
   ```
2. Compilar:
   ```bash
   javac -d bin -sourcepath src src/MenuGeneral/VentanaCursoPOO.java
   ```
3. Generar el ejecutable (Opcional):
   ```bash
   jar cfe Nuevo_Ejecutable.jar MenuGeneral.VentanaCursoPOO -C bin .
   ```

## Autor
- Cristian 

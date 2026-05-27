package Actividad5;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class GestorArchivoBiblioteca {
    private static final String FILE_NAME = "biblioteca.txt";

    // READ
    public static ArrayList<String[]> leerLibros() throws IOException {
        ArrayList<String[]> lista = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return lista;

        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            String line;
            while ((line = raf.readLine()) != null) {
                // Fix encoding issue with RandomAccessFile readLine
                line = new String(line.getBytes("ISO-8859-1"), "UTF-8");
                String[] datos = line.split("!");
                if (datos.length == 3) {
                    lista.add(datos);
                }
            }
        }
        return lista;
    }

    // CREATE
    public static void crearLibro(String titulo, String autor, String estado) throws Exception {
        ArrayList<String[]> libros = leerLibros();
        for (String[] libro : libros) {
            if (libro[0].equalsIgnoreCase(titulo)) {
                throw new Exception("El libro ya existe en la biblioteca.");
            }
        }

        String record = titulo + "!" + autor + "!" + estado;
        File file = new File(FILE_NAME);
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(raf.length()); // ir al final
            raf.write(record.getBytes("UTF-8"));
            raf.writeBytes(System.lineSeparator());
        }
    }

    // UPDATE
    public static void actualizarLibro(String tituloBuscar, String nuevoTitulo, String nuevoAutor, String nuevoEstado) throws Exception {
        File file = new File(FILE_NAME);
        File temp = new File("temp.txt");

        boolean encontrado = false;

        try (RandomAccessFile raf = new RandomAccessFile(file, "rw");
             RandomAccessFile tmpraf = new RandomAccessFile(temp, "rw")) {

            String line;
            while ((line = raf.readLine()) != null) {
                String utf8Line = new String(line.getBytes("ISO-8859-1"), "UTF-8");
                String[] datos = utf8Line.split("!");
                if (datos.length == 3 && datos[0].equalsIgnoreCase(tituloBuscar)) {
                    encontrado = true;
                    String newRecord = nuevoTitulo + "!" + nuevoAutor + "!" + nuevoEstado;
                    tmpraf.write(newRecord.getBytes("UTF-8"));
                    tmpraf.writeBytes(System.lineSeparator());
                } else {
                    tmpraf.write(utf8Line.getBytes("UTF-8"));
                    tmpraf.writeBytes(System.lineSeparator());
                }
            }
        }

        if (encontrado) {
            file.delete();
            temp.renameTo(file);
        } else {
            temp.delete();
            throw new Exception("El libro no fue encontrado.");
        }
    }

    // DELETE
    public static void borrarLibro(String tituloBuscar) throws Exception {
        File file = new File(FILE_NAME);
        File temp = new File("temp.txt");

        boolean encontrado = false;

        try (RandomAccessFile raf = new RandomAccessFile(file, "rw");
             RandomAccessFile tmpraf = new RandomAccessFile(temp, "rw")) {

            String line;
            while ((line = raf.readLine()) != null) {
                String utf8Line = new String(line.getBytes("ISO-8859-1"), "UTF-8");
                String[] datos = utf8Line.split("!");
                if (datos.length == 3 && datos[0].equalsIgnoreCase(tituloBuscar)) {
                    encontrado = true;
                    // No escribimos la linea en el archivo temporal para borrarla
                } else {
                    tmpraf.write(utf8Line.getBytes("UTF-8"));
                    tmpraf.writeBytes(System.lineSeparator());
                }
            }
        }

        if (encontrado) {
            file.delete();
            temp.renameTo(file);
        } else {
            temp.delete();
            throw new Exception("El libro no fue encontrado.");
        }
    }
}

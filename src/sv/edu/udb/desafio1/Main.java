package sv.edu.udb.desafio1;
import sv.edu.udb.desafio1.material.escrito.Libro;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Mediateca mediateca = new Mediateca();
        int opcion = 0;
        boolean pass;

        do {
            String input = JOptionPane.showInputDialog(null, "1-Libros\n 2-DVD\n "
                    + "3-Material Audiovisual\n 4-CdAudio\n 5-Revistas\n 6-Salir");
            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Bienvendio a al sección de libros");

                        // Agregar código para la opción 1 (CdAudio)
                        int optBook=0;
                         do{
                             optBook = Integer.parseInt(JOptionPane.showInputDialog(null, "Que desea hacer?\n" +
                                     "1-Agregar\n 2-Modificar\n 3-Listar\n 4-Borrar\n 5-Buscar\n 6-salir"));
                             switch (optBook){
                                 case 1:
                                     JOptionPane.showMessageDialog(null, "Bienvenido a la sección de agregar libros");

                                     //Autogenerar ID
                                     String codigoIdentificacion = generarCodigoIdentificacion("LIB");

                                     //Titulo
                                     String titulo;
                                     do {
                                         titulo = JOptionPane.showInputDialog  ("Ingrese el título del libro:");
                                         if (titulo.trim().isEmpty()){
                                             JOptionPane.showMessageDialog(null, "Ingrese un titulo valido");
                                         }
                                     } while (titulo.trim().isEmpty());

                                     //Autor
                                     String autor;
                                     do {
                                         autor = JOptionPane.showInputDialog ("Ingrese el autor del libro:");
                                         if (autor == null || autor.trim().isEmpty()){
                                             JOptionPane.showMessageDialog(null, "Ingrese un titulo valido");
                                         }
                                     } while (autor == null || autor.trim().isEmpty());

                                     //Num Páginas
                                     pass = false;
                                     int numeroPaginas = 0;
                                     do {
                                         try {
                                             String numeroPaginasString = JOptionPane.showInputDialog ("Ingrese el número de páginas del libro:");
                                             numeroPaginas = Integer.parseInt(numeroPaginasString);
                                             pass = true;
                                         } catch (NumberFormatException e){
                                             JOptionPane.showMessageDialog(null, "Error. Por favor, ingrese un número entero válido.");
                                         }
                                     } while (!pass);

                                     //Editorial
                                     String editorial;
                                     do {
                                         editorial = JOptionPane.showInputDialog ("Ingrese la editorial del libro:");
                                         if (editorial.trim().isEmpty()){
                                             JOptionPane.showMessageDialog(null, "Ingrese un titulo valido");
                                         }
                                     } while (editorial.trim().isEmpty());

                                     //ISBN
                                     pass = false;
                                     int ISBN = 0;
                                     do {
                                         try {
                                             String ISBNString = JOptionPane.showInputDialog("Ingrese el ISBN del libro:");
                                             // Verificar la longitud y si es un número entero
                                             if (ISBNString.length() == 9) {
                                                 ISBN = Integer.parseInt(ISBNString);
                                                 pass = true;
                                             } else {
                                                 JOptionPane.showMessageDialog(null, "Error. El ISBN debe tener exactamente 9 dígitos.");
                                             }
                                         } catch (NumberFormatException e) {
                                             JOptionPane.showMessageDialog(null, "Error. Por favor, ingrese un número entero válido.");
                                         }
                                     } while (!pass);

                                     //Año Publicación
                                     pass = false;
                                     int anioPublicacion = 0;
                                     do {
                                         try {
                                             String anioPublicacionString = JOptionPane.showInputDialog ("Ingrese el año de publicación del libro:");
                                             if (anioPublicacionString.length() <= 4){
                                                 anioPublicacion = Integer.parseInt(anioPublicacionString);

                                                 int anioActual = Calendar.getInstance().get(Calendar.YEAR);

                                                 if (anioPublicacion > anioActual) {
                                                     JOptionPane.showMessageDialog(null, "Error. Ingrese un año válido");
                                                 } else {
                                                     pass = true;
                                                 }
                                             } else {
                                                 JOptionPane.showMessageDialog(null, "Error. Ingrese un año valido");
                                             }

                                         } catch (NumberFormatException e) {
                                             JOptionPane.showMessageDialog(null, "Error. Por favor, ingrese un número entero válido.");
                                         }
                                     } while (!pass);

                                     //Unidades Disponibles
                                     pass = false;
                                     int unidadesDisponibles = 0;
                                     do {
                                         try {
                                             String unidadesDisponiblesString = JOptionPane.showInputDialog ("Ingrese el número de unidades disponibles del libro:");
                                             unidadesDisponibles = Integer.parseInt(unidadesDisponiblesString);
                                             pass = true;

                                         } catch(NumberFormatException e){
                                             JOptionPane.showMessageDialog(null, "Error. Por favor, ingrese un número entero válido.");
                                         }
                                     } while (!pass);

                                     // Crear una instancia de Libro con los datos ingresados por el usuario
                                     Libro libro = new Libro(codigoIdentificacion, titulo, autor, numeroPaginas, editorial, ISBN, anioPublicacion, unidadesDisponibles);

                                     // Agregar el libro a la mediateca
                                     mediateca.addBooks(libro);

                                     JOptionPane.showMessageDialog(null, "Libro agregado correctamente a la mediateca.");
                                     System.out.println(libro.toString());

                                     break;

                                 case 2:
                                     break;

                                 case 3:

                                     break;

                                 case 4:
                                     String codigoLibro = JOptionPane.showInputDialog(null, "Ingrese el código de identificación del libro a borrar:");
                                     if (codigoLibro != null) {
                                         mediateca.removeBook(codigoLibro);
                                     }
                                 case 5:
                                     codigoLibro = JOptionPane.showInputDialog(null, "Ingrese el código de identificación del libro a buscar");
                                     if (codigoLibro != null) {
                                         mediateca.searchBook(codigoLibro);
                                     }
                                     break;
                                 case 6:
                                     break;

                             }
                         }while (optBook != 6 );
                        break;
                    case 2:
                        // Agregar código para la opción 2 (DVD)
                        break;
                    case 3:
                        // Agregar código para la opción 3 (Material Audiovisual)
                        break;
                    case 4:
                        // Agregar código para la opción 4 (Libros)
                        break;
                    case 5:
                        // Agregar código para la opción 5 (Revistas)
                        break;
                    case 6:
                        // Salir del programa
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingresa un número del 1 al 6.", "Error", JOptionPane.WARNING_MESSAGE);
                        break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingresa un número del 1 al 6.", "Error", JOptionPane.WARNING_MESSAGE);
                opcion = 0; // Reiniciar la opción para volver a pedir la entrada al usuario
            }

        } while (opcion != 6);
    }
    private static String generarCodigoIdentificacion(String prefijo) {
        Random random = new Random();
        int codigoAleatorio = random.nextInt(90000) + 10000;
        return prefijo + codigoAleatorio;
    }
}

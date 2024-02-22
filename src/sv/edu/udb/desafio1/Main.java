package sv.edu.udb.desafio1;
import sv.edu.udb.desafio1.material.escrito.Libro;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {



        int opcion = 0;

        do {
            String input = JOptionPane.showInputDialog(null, "1-Libros\n 2-DVD\n "
                    + "3-Material Audiovisual\n 4-CdAudio\n 5-Revistas\n 6-Salir");


            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "bienvendio a al sección de libros");

                        // Agregar código para la opción 1 (CdAudio)
                        int optBook=0;
                         do{
                             optBook = Integer.parseInt(JOptionPane.showInputDialog(null, "Que desea hacer?\n" +
                                     "1-Agregar\n 2-Modificar\n 3-Listar\n 4-Borrar\n 5-Buscar\n 6-salir"));
                             switch (optBook){
                                 case 1:
                                     JOptionPane.showMessageDialog(null, "Bienvenido a la sección de libros");

                                     // Pedir al usuario que ingrese los detalles del libro
                                     String codigoIdentificacion = JOptionPane.showInputDialog
                                             ("Ingrese el código de identificación del libro:");
                                     String titulo = JOptionPane.showInputDialog
                                             ("Ingrese el título del libro:");
                                     String autor = JOptionPane.showInputDialog
                                             ("Ingrese el autor del libro:");
                                     int numeroPaginas = Integer.parseInt(JOptionPane.showInputDialog
                                             ("Ingrese el número de páginas del libro:"));
                                     String editorial = JOptionPane.showInputDialog
                                             ("Ingrese la editorial del libro:");
                                     String ISBN = JOptionPane.showInputDialog
                                             ("Ingrese el ISBN del libro:");
                                     int anioPublicacion = Integer.parseInt(JOptionPane.showInputDialog
                                             ("Ingrese el año de publicación del libro:"));
                                     int unidadesDisponibles = Integer.parseInt(JOptionPane.showInputDialog
                                             ("Ingrese el número de unidades disponibles del libro:"));

                                     // Crear una instancia de Libro con los datos ingresados por el usuario
                                     Libro libro = new Libro(codigoIdentificacion, titulo, autor, numeroPaginas,
                                             editorial, ISBN, anioPublicacion, unidadesDisponibles);

                                     // Obtener la mediateca
                                     Libro.Mediateca mediateca = libro.new Mediateca();

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
                                     break;

                                 case 5:
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
}

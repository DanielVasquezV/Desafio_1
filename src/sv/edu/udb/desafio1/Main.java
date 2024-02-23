package sv.edu.udb.desafio1;
//imports de package´s
import sv.edu.udb.desafio1.material.escrito.*;
import sv.edu.udb.desafio1.material.audiovisual.*;
import  sv.edu.udb.desafio1.material.audiovisual.CdAudio;

//Import de librerias de java
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Mediateca mediateca = new Mediateca();
        DvdMediateca dvdMediateca = new DvdMediateca();
//        CdMediateca cdMediateca = new CdMediateca();
        int opcion = 0;
        boolean pass;

        do {
            String input = JOptionPane.showInputDialog(null, "1-Libros\n 2-Dvd\n "
                    + "3-Material Audiovisual\n 4-CdAudio\n 5-Revistas\n 6-Salir");
            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Bienvendio a al sección de libros");

                        // Agregar código para la opción 1 (CdAudio)
                        int optBook=0;
                         do{
                             optBook = mostrarMenu();

                             switch (optBook){
                                 case 1:
                                     JOptionPane.showMessageDialog(null, "Bienvenido a la sección de agregar libros");

                                     //Autogenerar ID
                                     String codigoIdentificacion = generarCodigoIdentificacion("LIB");
                                     //Titulo
                                     String titulo = obtenerTitulo("Libro");
                                     //Autor
                                     String autor = obtenerAutor("Libro");

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
                                     String editorial = obtenerEditorial("Libro");
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
                                     int unidadesDisponibles = obtenerUnidades("Libro");

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
                                     String codigoLibro = JOptionPane.showInputDialog(null,
                                             "Ingrese el código de identificación del libro a borrar:");

                                     if (codigoLibro != null) {
                                         mediateca.removeBook(codigoLibro);
                                     }
                                 case 5:
                                     codigoLibro = JOptionPane.showInputDialog(null,
                                             "Ingrese el código de identificación del libro a buscar");

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
                        JOptionPane.showMessageDialog(null, "Bienvendio a al sección de Dvd");
                        int optDvd= 0;
                        do {
                            optDvd=mostrarMenu();

                            switch (optDvd){
                                case 1:
                                    JOptionPane.showMessageDialog(null, "Bienvenido a la sección de agregar Dvd's");

                                    //Id
                                    String codigoIdentificaciondvd = generarCodigoIdentificacion("DVD");
                                    //Titulo
                                    String titulodvd = obtenerTitulo("Dvd");
                                    //unidades
                                    int unidadesDisponiblesdvd = obtenerUnidades("Dvd");
                                    //duracion
                                    String duraciondvd = obtenerDuracion("Dvd");
                                    //genero
                                    String generodvd = obtenerGenero("Dvd");
                                    //director
                                    String director;
                                    do {
                                        director = JOptionPane.showInputDialog ("Ingrese el director del Dvd:");
                                        if (director == null || director.trim().isEmpty()){
                                            JOptionPane.showMessageDialog(null, "Ingrese un nombre valido");
                                        }
                                    } while (director == null || director.trim().isEmpty());

                                    Dvd dvd = new Dvd(codigoIdentificaciondvd, titulodvd,
                                            unidadesDisponiblesdvd, duraciondvd, generodvd, director);

                                    // Agregar el DVD a la mediateca
                                    dvdMediateca.addDvds(dvd);

                                    break;
                            }

                        }while (optDvd != 6 );
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null, "Bienvendio a al sección de Cd's");
                        int optCd=0;
                        do {
                            optCd=mostrarMenu();
                            switch (optCd){
                                case 1:
                                    JOptionPane.showMessageDialog(null, "Bienvenido a la sección de agregar Cd's");
                                    //Id
                                    String codigoIdentificacionCd = generarCodigoIdentificacion("CDS");

                                    String tituloCd = obtenerTitulo("Cd");
                                    int unidadesDisponiblesCd = obtenerUnidades("Cd");
                                    String duracionCd = obtenerDuracion("Cd");
                                    String generoCd = obtenerGenero("Cd");
                                    String artistaCd;
                                    do {
                                        artistaCd = JOptionPane.showInputDialog ("Ingrese el director del Dvd:");
                                        if (artistaCd == null || artistaCd.trim().isEmpty()){
                                            JOptionPane.showMessageDialog(null, "Ingrese un nombre valido");
                                        }
                                    } while (artistaCd == null || artistaCd.trim().isEmpty());

                                    pass = false;
                                    int numeroCancionesCd = 0;
                                    do {
                                        try {
                                            String numeroCancionesCdString = JOptionPane.showInputDialog ("Ingrese el n° de canciones: ");
                                            if (numeroCancionesCdString.length() <=0 ){
                                                numeroCancionesCd = Integer.parseInt(numeroCancionesCdString);
                                                JOptionPane.showMessageDialog(null, "Error: " +
                                                        "Ingrese un numero valido");
                                            }else {
                                                pass = true;
                                            }
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "Error. Por favor, ingrese un número entero válido.");
                                        }
                                    } while (!pass);

                                    CdAudio cdAudio = new CdAudio(codigoIdentificacionCd,tituloCd,unidadesDisponiblesCd,
                                            duracionCd,generoCd, artistaCd, numeroCancionesCd);

//                                    cdMediateca.addCds(cdAudio);


                                    break;
                            }
                        }while (optCd !=6);

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

    public static int mostrarMenu() {
        int opcionSeleccionada = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                opcionSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Qué desea hacer?\n" +
                                "1-Agregar\n" +
                                "2-Modificar\n" +
                                "3-Listar\n" +
                                "4-Borrar\n" +
                                "5-Buscar\n" +
                                "6-Salir"));

                // Verifica si la opción seleccionada está dentro del rango permitido
                if (opcionSeleccionada >= 1 && opcionSeleccionada <= 6) {
                    entradaValida = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione una opción válida (1-6)");
                }
            } catch (NumberFormatException e) {
                // Maneja el caso en que la entrada no sea un número entero
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número entero válido");
            }
        }
        return opcionSeleccionada;
    }

    private static String generarCodigoIdentificacion(String prefijo) {
        Random random = new Random();
        int codigoAleatorio = random.nextInt(90000) + 10000;
        return prefijo + codigoAleatorio;
    }

    private static String obtenerTitulo(String tipoMaterial){
        String titulo;
        do {
            titulo = JOptionPane.showInputDialog("Ingrese el titulo de "+ tipoMaterial + ":");
            if (titulo == null || titulo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un título válido");
            }
        } while (titulo == null || titulo.trim().isEmpty());
        return titulo;
    }
    private static String obtenerAutor( String tipoMatrial){
        String autor;
        do {
            autor = JOptionPane.showInputDialog ("Ingrese el autor del " + tipoMatrial + ":");
            if (autor == null || autor.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese un titulo valido");
            }
        } while (autor == null || autor.trim().isEmpty());
        return autor;
    }

    private static String obtenerEditorial(String tipoMaterial){
        String editorial;
        do {
            editorial = JOptionPane.showInputDialog ("Ingrese la editorial del " + tipoMaterial+":");
            if (editorial.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese un titulo valido");
            }
        } while (editorial.trim().isEmpty());
        return editorial;
    }

    private static int obtenerUnidades(String tipoMaterial){
        boolean nextStep = false;

        int unidadesDisponibles = 0;
        do {
            try {
                String unidadesDisponiblesString = JOptionPane.showInputDialog ("Ingrese el número de unidades disponibles del :" +
                        tipoMaterial + ":");
                unidadesDisponibles = Integer.parseInt(unidadesDisponiblesString);
                nextStep = true;

            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error. Por favor, ingrese un número entero válido.");
            }
        } while (!nextStep);
        return unidadesDisponibles;
    }

    private static String obtenerDuracion(String tipoMaterial){
        String duracion;
        do {
            duracion = JOptionPane.showInputDialog ("Ingrese la editorial del " +tipoMaterial +":");
            if (duracion.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese un titulo valido");
            }
        } while (duracion.trim().isEmpty());
        return duracion;
    }
    private static String obtenerGenero(String tipoMaterial){
        String genero;
        do {
            genero = JOptionPane.showInputDialog ("Ingrese el " + tipoMaterial + ":");
            if (genero.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese un titulo valido");
            }
        } while (genero.trim().isEmpty());
        return genero;
    }

}

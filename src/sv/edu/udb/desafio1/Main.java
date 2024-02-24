package sv.edu.udb.desafio1;

//imports de package´s
import sv.edu.udb.desafio1.mediateca.*;
import sv.edu.udb.desafio1.material.escrito.*;
import sv.edu.udb.desafio1.material.audiovisual.*;
import  sv.edu.udb.desafio1.material.audiovisual.CdAudio;
import sv.edu.udb.desafio1.material.escrito.Revista;

//Import de librerias de java
import java.util.Calendar;
import java.util.Random;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Mediateca mediateca = new Mediateca();
        DvdMediateca dvdMediateca = new DvdMediateca();
        CdMediateca cdMediateca = new CdMediateca();
        RevistasMediateca revistasMediateca = new RevistasMediateca();

        int opcion;
        boolean pass;

        do {
            String input = JOptionPane.showInputDialog(null, """
                    Seleccione el tipo de material a gestionar\s
                     1-Libros
                     2-Dvd
                     3-CdAudio
                     4-Revistas
                     5-Salir""");
            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:

                        JOptionPane.showMessageDialog(null, "Bienvenido a al sección de libros");
                        int optBook;
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
                                     String autor = obtenerAutor();

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
                                     do{
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
                                     mediateca.guardarLibroTxt("libros.txt");
                                     System.out.println(libro);

                                     break;

                                 case 2:
                                     String updLibro = JOptionPane.showInputDialog(null,
                                             "Inresa el codigo de intentificacion del libro a actualizar:");
                                     if (updLibro != null){
                                         if(mediateca.libros.containsKey(updLibro)){
                                             Libro libroExistente = mediateca.libros.get(updLibro);
                                             String nuevoTitulo = obtenerTitulo("Libro");
                                             String nuevoAutor = obtenerAutor();
                                             boolean nextstep = false;
                                             int nuevoNumeroPaginas = 0;
                                             do {
                                                 try {
                                                     String nuevoNumeroPaginasString = JOptionPane.showInputDialog("Ingrese el nuevo número de páginas:");
                                                     nuevoNumeroPaginas = Integer.parseInt(nuevoNumeroPaginasString);
                                                     nextstep = true;
                                                 } catch (NumberFormatException e) {
                                                     JOptionPane.showMessageDialog(null, "Error. Por favor, ingrese un número entero válido.");
                                                 }
                                             } while (!nextstep);
                                             String nuevaEditorial = obtenerEditorial("Libro");

                                             nextstep = false;
                                             int nuevoISBN = 0;
                                             do {
                                                 try {
                                                     String ISBNString = JOptionPane.showInputDialog("Ingrese el ISBN del libro:");
                                                     // Verificar la longitud y si es un número entero
                                                     if (ISBNString.length() == 9) {
                                                         nuevoISBN = Integer.parseInt(ISBNString);
                                                         nextstep = true;
                                                     } else {
                                                         JOptionPane.showMessageDialog(null, "Error. El ISBN debe tener exactamente 9 dígitos.");
                                                     }
                                                 } catch (NumberFormatException e) {
                                                     JOptionPane.showMessageDialog(null, "Error. Por favor, ingrese un número entero válido.");
                                                 }
                                             } while (!nextstep);

                                             pass = false;
                                             int nuevoAnioPublicacion = 0;
                                             do {
                                                 try {
                                                     String nuevoAnioPublicacionString = JOptionPane.showInputDialog ("Ingrese el año de publicación del libro:");
                                                     if (nuevoAnioPublicacionString.length() <= 4){
                                                         nuevoAnioPublicacion = Integer.parseInt(nuevoAnioPublicacionString);

                                                         int anioActual = Calendar.getInstance().get(Calendar.YEAR);

                                                         if (nuevoAnioPublicacion > anioActual) {
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
                                             int nuevasUnidades = obtenerUnidades("Libro");

                                             Libro nuevoLibro = new Libro(libroExistente.getCodigoIdentificacion(), nuevoTitulo, nuevoAutor,
                                                     nuevoNumeroPaginas, nuevaEditorial,nuevoISBN,
                                                     nuevoAnioPublicacion,nuevasUnidades);
                                             mediateca.updateBooks(updLibro, nuevoLibro);
                                             System.out.println("Se actualizo");
                                             System.out.println(nuevoLibro);
                                         }else {
                                             JOptionPane.showMessageDialog(null, "El libro con código " + updLibro + " no se encuentra en la mediateca.");
                                         }
                                     }
                                     break;

                                 case 3:
                                     mediateca.listarLibros();


                                     break;

                                 case 4:
                                     String codigoLibro = JOptionPane.showInputDialog(null,
                                             "Ingrese el código de identificación del libro a borrar:");

                                     if (codigoLibro != null) {
                                         mediateca.removeBook(codigoLibro);
                                     }
                                     break;
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
                        JOptionPane.showMessageDialog(null, "Bienvenido a al sección de Dvd");
                        int optDvd;
                        do {
                            optDvd=mostrarMenu();

                            switch (optDvd){
                                case 1:
                                    JOptionPane.showMessageDialog(null, "Bienvenido a la sección de agregar Dvd's");

                                    //Id
                                    String codigoIdentificaciondvd = generarCodigoIdentificacion("DVD");
                                    //Titulo
                                    String titulodvd = obtenerTitulo("Dvd");
                                    //director
                                    String director;
                                    do {
                                        director = JOptionPane.showInputDialog ("Ingrese el director del Dvd:");
                                        if (director == null || director.trim().isEmpty()){
                                            JOptionPane.showMessageDialog(null, "Ingrese un nombre valido");
                                        }
                                    } while (director == null || director.trim().isEmpty());

                                    String duraciondvd = obtenerDuracion("Dvd");
                                    String generodvd = obtenerGenero("Dvd");
                                    int unidadesDisponiblesdvd = obtenerUnidades("Dvd");

                                    Dvd dvd = new Dvd(codigoIdentificaciondvd, titulodvd, director, duraciondvd, generodvd, unidadesDisponiblesdvd);

                                    // se agg el DVD a la mediateca
                                    dvdMediateca.addDvds(dvd);
                                    JOptionPane.showMessageDialog(null, "DVD agregado correctamente a la mediateca.");
                                    dvdMediateca.guardarDvdTxt("DVDs.txt");
                                    System.out.println(dvd);

                                    break;

                                case 2:
                                    String updtDvd = JOptionPane.showInputDialog(null,
                                            "Inresa el codigo de intentificacion del libro a actualizar:");
                                    if (updtDvd != null){
                                        if(dvdMediateca.dvds.containsKey(updtDvd)){
                                            String nuevoCodigoIntentificacion = generarCodigoIdentificacion("DVD");
                                            String nuevoTitulo = obtenerTitulo("Dvd");
                                            int nuevasUnidades = obtenerUnidades("Dvd");
                                            String nuevaDuracion = obtenerDuracion("Dvd");
                                            String nuevoGenero = obtenerGenero("Dvd");
                                            String nuevodirector;
                                            do {
                                                nuevodirector = JOptionPane.showInputDialog ("Ingrese el director del Dvd:");
                                                if (nuevodirector == null || nuevodirector.trim().isEmpty()){
                                                    JOptionPane.showMessageDialog(null, "Ingrese un nombre valido");
                                                }
                                            } while (nuevodirector == null || nuevodirector.trim().isEmpty());

                                            Dvd nuevoDvd = new Dvd(nuevoCodigoIntentificacion,nuevoTitulo
                                                    ,nuevaDuracion,nuevoGenero,nuevodirector, nuevasUnidades);
                                             dvdMediateca.updateDvd(updtDvd, nuevoDvd);

                                            System.out.println(nuevoDvd);

                                        }else {
                                            JOptionPane.showMessageDialog(null, "DVD con código " + updtDvd +
                                                    " no se encuentra en la mediateca.");
                                        }
                                    }

                                    break;
                                case 3:
                                    dvdMediateca.listarDvd();


                                case 4:
                                    String codigoDvd = JOptionPane.showInputDialog(null,
                                            "Ingrese el código de identificación del DVD a borrar:");

                                    if (codigoDvd != null) {
                                        dvdMediateca.removeDvd(codigoDvd);
                                    }
                                    break;
                                case 5:
                                    codigoDvd = JOptionPane.showInputDialog(null,
                                            "Ingrese el código de identificación del DVD a buscar:");

                                    if (codigoDvd != null) {
                                        dvdMediateca.searchDvd(codigoDvd);
                                    }
                                    break;
                            }

                        }while (optDvd != 6 );
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null, "Bienvendio a al sección de Cd's");
                        int optCd;
                        do {
                            optCd=mostrarMenu();
                            switch (optCd){
                                case 1:
                                    JOptionPane.showMessageDialog(null, "Bienvenido a la sección de agregar CD's");
                                    //Id
                                    String codigoIdentificacionCd = generarCodigoIdentificacion("CDA");
                                    //titulo
                                    String tituloCd = obtenerTitulo("CD");
                                    //artista
                                    String artistaCd;
                                    do {
                                        artistaCd = JOptionPane.showInputDialog ("Ingrese el artista del CD:");
                                        if (artistaCd == null || artistaCd.trim().isEmpty()){
                                            JOptionPane.showMessageDialog(null, "Ingrese un nombre valido");
                                        }
                                    } while (artistaCd == null || artistaCd.trim().isEmpty());
                                    //genero
                                    String generoCd = obtenerGenero("CD");
                                    //duracion
                                    String duracionCd = obtenerDuracion("CD");
                                    //num canciones
                                    pass = false;
                                    int numeroCancionesCd = 0;
                                    do {
                                        try {
                                            String numeroCancionesCdString = JOptionPane.showInputDialog ("Ingrese el n° de canciones: ");
                                            if (numeroCancionesCdString.isEmpty()){
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
                                    //unidades
                                    int unidadesDisponiblesCd = obtenerUnidades("CD");

                                    CdAudio cdAudio = new CdAudio(codigoIdentificacionCd, tituloCd, artistaCd, generoCd, duracionCd, numeroCancionesCd, unidadesDisponiblesCd);

                                    cdMediateca.addCds(cdAudio);
                                    JOptionPane.showMessageDialog(null, "CD agregado correctamente a la mediateca.");
                                    cdMediateca.guardarCdTxt("CDs.txt");
                                    System.out.println(cdAudio);
                                    break;

                                case 2:
                                    String updtCd = JOptionPane.showInputDialog(null,
                                            "Inresa el codigo de intentificacion del libro a actualizar:");
                                    if (updtCd != null){
                                        if(cdMediateca.cdAudios.containsKey(updtCd)){
                                            String nuevoCodigoIntentificacion = generarCodigoIdentificacion("CDS");
                                            String nuevoTitulo = obtenerTitulo("CDS");
                                            int nuevasUnidades = obtenerUnidades("CDS");
                                            String nuevaDuracion = obtenerDuracion("CDS");
                                            String nuevoGenero = obtenerGenero("CDS");
                                            String nuevoArtista;
                                            do {
                                                nuevoArtista = JOptionPane.showInputDialog ("Ingrese el director del Dvd:");
                                                if (nuevoArtista == null || nuevoArtista.trim().isEmpty()){
                                                    JOptionPane.showMessageDialog(null, "Ingrese un nombre valido");
                                                }
                                            } while (nuevoArtista == null || nuevoArtista.trim().isEmpty());

                                            int nuevonumeroCancionesCd = 0;
                                            pass = false;
                                            do {
                                                try {
                                                    String nuevonumeroCancionesString = JOptionPane.showInputDialog ("Ingrese el n° de canciones: ");
                                                    if (nuevonumeroCancionesString.isEmpty()){
                                                        nuevonumeroCancionesCd = Integer.parseInt(nuevonumeroCancionesString);
                                                        JOptionPane.showMessageDialog(null, "Error: " +
                                                                "Ingrese un numero valido");
                                                    }else {
                                                        pass = true;
                                                    }
                                                } catch (NumberFormatException e) {
                                                    JOptionPane.showMessageDialog(null, "Error. Por favor, ingrese un número entero válido.");
                                                }
                                            } while (!pass);

                                            CdAudio nuevoCd = new CdAudio(nuevoCodigoIntentificacion,nuevoTitulo
                                                    ,nuevaDuracion,nuevoGenero,nuevoArtista, nuevasUnidades, nuevonumeroCancionesCd);
                                            cdMediateca.updateCd(updtCd, nuevoCd);

                                            System.out.println(nuevoCd);

                                        }else {
                                            JOptionPane.showMessageDialog(null, "DVD con código " + optCd +
                                                    " no se encuentra en la mediateca.");
                                        }
                                    }

                                    break;
                                case 3:

                                    cdMediateca.listarCds();

                                    break;
                                case 4:
                                    String codigoCd = JOptionPane.showInputDialog(null,
                                            "Ingrese el código de identificación del CD a borrar:");

                                    if (codigoCd != null) {
                                        cdMediateca.removeCd(codigoCd);
                                    }
                                    break;
                                case 5:
                                    codigoCd = JOptionPane.showInputDialog(null,
                                            "Ingrese el código de identificación del CD a buscar:");

                                    if (codigoCd != null) {
                                        cdMediateca.searchCd(codigoCd);
                                    }
                                    break;
                            }
                        }while (optCd !=6);

                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Bienvenido a al sección de Revista");

                        int optRev;
                        do {
                            optRev = mostrarMenu();
                            switch (optRev){
                                case 1:
                                    String codiIndetificacionRev = generarCodigoIdentificacion("REV");
                                    String tituloRev = obtenerTitulo("Revista");
                                    String editorialRev =  obtenerEditorial("Revista");
                                    int unidadesDisponiblesRev = obtenerUnidades("Revista");


                                    String periodicidadRev;
                                    do {
                                        periodicidadRev = JOptionPane.showInputDialog ("Ingrese la periodicidad:");
                                        if (periodicidadRev == null || periodicidadRev.trim().isEmpty()){
                                            JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
                                        }
                                    } while (periodicidadRev == null || periodicidadRev.trim().isEmpty());

                                    String fechaPublicacionRev;
                                    do {
                                        fechaPublicacionRev = JOptionPane.showInputDialog ("Ingrese la fecha de publicación de la revista");
                                        if (fechaPublicacionRev == null || fechaPublicacionRev.trim().isEmpty()){
                                            JOptionPane.showMessageDialog(null, "Ingrese una fecha");
                                        }
                                    } while (fechaPublicacionRev == null || fechaPublicacionRev.trim().isEmpty());

                                    Revista revista = new Revista(codiIndetificacionRev,tituloRev,editorialRev,periodicidadRev,fechaPublicacionRev, unidadesDisponiblesRev);

                                    revistasMediateca.addRevista(revista);
                                    JOptionPane.showMessageDialog(null, "Revista agregada correctamente a la mediateca.");
                                    System.out.println(revista);
                                    revistasMediateca.guardarRevistaTxt("revistas.txt");
                                    break;

                                case 2:
                                    String updtRevista = JOptionPane.showInputDialog(null,
                                            "Inresa el codigo de intentificacion de ls revista a actualizar:");
                                    if (updtRevista != null) {
                                        if(revistasMediateca.revistas.containsKey(updtRevista)) {
                                            String nuevocodigoIdentificacion = generarCodigoIdentificacion("Rev");
                                            String nuevoTitulo = obtenerTitulo("Revista");
                                            String nuevaEditorial = obtenerEditorial("Revista");
                                            int nuevasUnidadesDisponiblesRev = obtenerUnidades("Revista");

                                            String nuevaperiodicidadRev;
                                            do {
                                                nuevaperiodicidadRev = JOptionPane.showInputDialog ("Ingrese la periodicidad:");
                                                if (nuevaperiodicidadRev == null || nuevaperiodicidadRev.trim().isEmpty()){
                                                    JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
                                                }
                                            } while (nuevaperiodicidadRev == null || nuevaperiodicidadRev.trim().isEmpty());

                                            String nuevaFechaPublicacionRev;
                                            do {
                                                nuevaFechaPublicacionRev = JOptionPane.showInputDialog ("Ingrese la fecha de publicación de la revista");
                                                if (nuevaFechaPublicacionRev == null || nuevaFechaPublicacionRev.trim().isEmpty()){
                                                    JOptionPane.showMessageDialog(null, "Ingrese una fecha");
                                                }
                                            } while (nuevaFechaPublicacionRev == null || nuevaFechaPublicacionRev.trim().isEmpty());



                                            Revista nuevaRevista = new Revista(nuevocodigoIdentificacion, nuevoTitulo, nuevaEditorial,
                                                    nuevaFechaPublicacionRev, nuevaperiodicidadRev, nuevasUnidadesDisponiblesRev);

                                            revistasMediateca.updateRevista(updtRevista, nuevaRevista);
                                            System.out.println(nuevaRevista);

                                        }else {
                                            JOptionPane.showMessageDialog(null, "Revista con código " + updtRevista + " no se encuentra en la mediateca.");
                                        }
                                    }



                                    break;
                                case 3:
                                    revistasMediateca.listarRevistas();
                                    break;
                                case 4:
                                    String codigoRev = JOptionPane.showInputDialog(null,
                                            "Ingrese el código de identificación de la revista a borrar:");

                                    if (codigoRev != null) {
                                        revistasMediateca.removeRevista(codigoRev);
                                    }
                                    break;
                                case 5:
                                    codigoRev = JOptionPane.showInputDialog(null,
                                            "Ingrese el código de identificación de la revista a buscar:");

                                    if (codigoRev != null) {
                                        revistasMediateca.searchRevista(codigoRev);
                                    }
                                    break;
                            }
                        }while (optRev != 6);
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingresa un número del 1 al 6.", "Error", JOptionPane.WARNING_MESSAGE);
                        break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingresa un número del 1 al 6.", "Error", JOptionPane.WARNING_MESSAGE);
                opcion = 0t ; // Reiniciar la opción para volver a pedir la entrada al usuario
            }

        } while (opcion != 5);
    }

    public static int mostrarMenu() {
        int opcionSeleccionada = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                opcionSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(null,
                        """
                                Qué desea hacer?
                                1-Agregar
                                2-Modificar
                                3-Listar
                                4-Borrar
                                5-Buscar
                                6-Regresar"""));

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
    private static String obtenerAutor(){
        String autor;
        do {
            autor = JOptionPane.showInputDialog ("Ingrese el autor del Libro: ");
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
                String unidadesDisponiblesString = JOptionPane.showInputDialog ("Ingrese el número de unidades disponibles del " +
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
            duracion = JOptionPane.showInputDialog ("Ingrese la duración del " +tipoMaterial +":");
            if (duracion.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese una duración");
            }
        } while (duracion.trim().isEmpty());
        return duracion;
    }
    private static String obtenerGenero(String tipoMaterial){
        String genero;
        do {
            genero = JOptionPane.showInputDialog ("Ingrese el género del " + tipoMaterial + ":");
            if (genero.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese un género valido");
            }
        } while (genero.trim().isEmpty());
        return genero;
    }
}

package sv.edu.udb.desafio1;
import sv.edu.udb.desafio1.material.escrito.Libro;
import java.util.HashMap;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        Mediateca mediateca = new Mediateca();
        //Para almacenar los libros
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Agregar\n 2-Modificar\n " +
                                                                        "3-Listar\n 4-Borrar\n 5-Buscar\n 6-Salir"));

            try{//try para validar que el usuario coloque una variable numerica y no ponga un string
                switch (opcion){
                    case 1:

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

            }catch (NumberFormatException e)//convierte una cadena no numerica a numero
            {
                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ",
                                              "ingresa un número del 1 al 6", JOptionPane.WARNING_MESSAGE);

            }


        }while (opcion !=6);
    }
}
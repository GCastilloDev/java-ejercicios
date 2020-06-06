/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Alumno;
import Modelo.Menu;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author @LastShadow
 */
public class TestRA {

    public static void main(String[] args) {

        Scanner n = new Scanner(System.in);

        int opcion = 0;
        int matricula;
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Menu menu = new Menu();
        
        do {
            System.out.println("====================< MENÚ >====================");
            System.out.println("(1) Agregar Alumno");
            System.out.println("(2) Buscar Alumno");
            System.out.println("(3) Actualizar Alumno");
            System.out.println("(4) Eliminar Alumno");
            System.out.println("(5) Mostrar Todos");
            System.out.println("(6) Mostrar de Mayor a Menor(edad)");
            System.out.println("(7) Salir");
            System.out.print("¿Qué opción desea? ");
            opcion = n.nextInt();
            System.out.println("");
            System.out.println("");

            switch (opcion) {

                case 1:
                    int casoUno = 0;
                    int bandera = 0;
                    do {
                        System.out.println("");
                        System.out.println("====================< AGREGAR ALUMNO >====================");
                        System.out.print("Matricula: ");
                        matricula = n.nextInt();
                        if (menu.existeMatricula(alumnos, matricula)) {
                            System.out.println("Matricula ya existe.");
                        } else {
                            alumnos = menu.agregarAlumno(alumnos, matricula, bandera);
                        }
                        System.out.println("");
                        System.out.print("¿Desea agregar otro alumno? (1) Si (2) No: ");
                        casoUno = n.nextInt();
                        bandera++;
                                
                    } while (casoUno != 2);
                    break;
                case 2:
                    int casoDos = 0;
                    do {
                        System.out.println("");
                        System.out.println("====================< BUSCAR ALUMNO >====================");
                        System.out.print("Ingrese la matrícula del alumno a bucar: ");
                        matricula = n.nextInt();
                        menu.buscarAlumno(alumnos, matricula);
                        Alumno alumno = new Alumno();
                        alumno = menu.buscarAlumno(alumnos, matricula);
                        if (alumno == null) {
                            System.out.println("Alumno no encontrado.");
                            System.out.print("¿Desea buscar otro alumno? (1) Si (2) No: ");
                            casoDos = n.nextInt();
                        } else {
                            System.out.println(alumno);
                            System.out.println("");
                            System.out.print("¿Desea buscar otro alumno? (1) Si (2) No: ");
                            casoDos = n.nextInt();
                        }
                    } while (casoDos != 2);
                    break;
                case 3:
                    int casoTres = 0;
                    do {
                        System.out.println("");
                        System.out.println("====================< ACTUALIZAR ALUMNO >====================");
                        System.out.print("Ingresa la matrícula del alumno que desea actualizar: ");
                        matricula = n.nextInt();
                        alumnos = menu.actualizarAlumno(alumnos, matricula);
                        System.out.println("");
                        System.out.print("¿Desea actualizar otro alumno? (1) Si (2) No: ");
                        casoTres = n.nextInt();
                    } while (casoTres != 2);
                    break;
                case 4:
                    int casoCuatro = 0;
                    do {
                        System.out.println("");
                        System.out.println("====================< ELIMINAR ALUMNO >====================");
                        System.out.print("Ingresa la matrícula del alumno que desea eliminar: ");
                        matricula = n.nextInt();
                        alumnos = menu.eliminarAlumno(alumnos, matricula);
                        System.out.println("");
                        System.out.print("¿Desea eliminar otro alumno? (1) Si (2) No: ");
                        casoCuatro = n.nextInt();
                    } while (casoCuatro != 2);
                    break;
                case 5:
                    System.out.println("====================< ALUMNOS REGISTRADOS (" + alumnos.size() + ")1"
                            + " >====================");
                    menu.mostrarAlumnos(alumnos);
                    break;
                case 6:
                    System.out.println("====================< ALUMNOS ORDENADOS POR EDAD (DE MAYOR A MENOR) >====================");
                    menu.mostrarAlumnos(menu.ordenarDeMayorAMenor(alumnos));
                    break;
            }
            System.out.println("");
            System.out.println("");

        } while (opcion != 7);
    }
}

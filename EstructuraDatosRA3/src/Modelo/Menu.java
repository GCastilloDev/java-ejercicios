package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author @LastShadow
 */
public class Menu {

    Scanner n = new Scanner(System.in);

    /**
     * Método que permite agregar un objeto de la clase Alumno a una Lista.<br>
     * La bandera se ocupa para solucionar el problema del buffer de Scanner.
     * @param alumnos
     * @param matricula
     * @param bandera
     * @return un ArrayList de tipo Alumno
     */
    public ArrayList<Alumno> agregarAlumno(ArrayList<Alumno> alumnos, int matricula, int bandera) {

        Alumno alumno = new Alumno();

        alumno.setMatricula(matricula);
        if (bandera > 0) {
            n.nextLine();
        }
        System.out.print("Nombre: ");
        alumno.setNombre(n.nextLine().toUpperCase());
        System.out.print("Apellido: ");
        alumno.setApellido(n.nextLine().toUpperCase());
        System.out.print("Edad: ");
        alumno.setEdad(n.nextInt());

        alumnos.add(alumno);

        return alumnos;
    }

    public Alumno buscarAlumno(List<Alumno> alumnos, int matricula) {
        Alumno alumno = null;

        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getMatricula() == matricula) {
                alumno = alumnos.get(i);
                break;
            }
        }
        return alumno;
    }

    public ArrayList<Alumno> actualizarAlumno(ArrayList<Alumno> alumnos, int matricula) {

        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getMatricula() == matricula) {
                System.out.println("Matricula: " + matricula);
                n.nextLine();
                System.out.print("Nombre: ");
                alumnos.get(i).setNombre(n.nextLine().toUpperCase());
                System.out.print("Apellido: ");
                alumnos.get(i).setApellido(n.nextLine().toUpperCase());
                System.out.print("Edad: ");
                alumnos.get(i).setEdad(n.nextInt());
                break;
            }

        }
        return alumnos;
    }

    public ArrayList<Alumno> eliminarAlumno(ArrayList<Alumno> alumnos, int matricula) {

        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getMatricula() == matricula) {
                alumnos.remove(i);
                break;
            }
        }

        return alumnos;
    }

    public void mostrarAlumnos(ArrayList<Alumno> alumnos) {
        System.out.println("");
        System.out.println("ID\tDatos(Matrícula, nombre, apellidos, edad):");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println((i + 1) + "\t" + alumnos.get(i));
        }
    }

    public ArrayList<Alumno> ordenarDeMayorAMenor(ArrayList<Alumno> alumnos) {

        for (int i = 0; i < alumnos.size(); i++) {
            for (int j = 0; j < alumnos.size() - 1; j++) {
                if (alumnos.get(j).getEdad() < alumnos.get(j + 1).getEdad()) {
                    Alumno temporal = alumnos.get(j);
                    alumnos.set(j, alumnos.get(j + 1));
                    alumnos.set(j + 1, temporal);
                }
            }
        }
        return alumnos;
    }

    public boolean existeMatricula(ArrayList<Alumno> alumnos, int matricula) {
        boolean existe = false;

        if (alumnos != null) {
            for (int i = 0; i < alumnos.size(); i++) {
                if (alumnos.get(i).getMatricula() == matricula) {
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }

}

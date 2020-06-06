package Modelo.Comando;

import Modelo.Archivos.Archivo;
import Modelo.Datos.Datos;
import Modelo.Usuario.Usuario;
import java.util.ArrayList;

/**
 *
 * @author @LastShadow
 */
public class Comando extends Usuario {

    private static Comando comando = null;

    private Comando() {

    }

    public static Comando getComando() {
        if (comando == null) {
            return new Comando();
        } else {
            return comando;
        }
    }

    public boolean usuarioPswCorrecto(String usuario, String contraseña) {
        return (getUSUARIO().equals(usuario) && getCONTRASEÑA().equals(contraseña));
    }

    public boolean crearBD(String nombreBD) {
        return Archivo.getArchivo().crearCarpeta(nombreBD);
    }

    public ArrayList<Object> crearTabla(String nombreBD, String comando) {
        ArrayList<Object> tabla = new ArrayList<>();
        String c = comando.replace(",", "");
        String comandos[] = c.split(" ");
        String nombreTabla = comandos[2];
        String campos = null;
        int numCampos = comandos.length - 4;

        if (comandos[0].equals("CREAR")) {
            if (comandos[1].equals("TABLA")) {
                nombreTabla = comandos[2];
                if (comandos[3].equals("CAMPOS")) {
                    if (comandos.length > 3) {
                        campos = comandos[4];
                        if (comandos.length > 4) {
                            for (int i = 5; i < comandos.length; i++) {
                                campos += "," + comandos[i];
                            }
                        }
                    } else {
                        System.err.println("Se requiere(n) nombre(s) del campo(s)");
                    }

                } else {
                    System.err.println(comandos[3] + " comando no reconocido");
                }
            } else {
                System.err.println(comandos[1] + " comando no reconocido");
            }
        } else {
            System.err.println(comandos[0] + " comando no reconocido");
        }

        tabla.add(nombreTabla);
        tabla.add(numCampos);
        tabla.add(campos);
        Archivo.getArchivo().crearArchivo(tabla, nombreBD, nombreTabla);
        return tabla;
    }

    public void seleccionarCampos(ArrayList<Object> tabla, String condicion) {
        if (condicion.equals("*")) {
            for (int i = 2; i < tabla.size(); i++) {
                String[] temporal = tabla.get(i).toString().split(",");
                if (i == 2) {
                    System.out.print("Indice\t\t");
                    for (int j = 0; j < temporal.length; j++) {
                        System.out.print(temporal[j].toUpperCase() + "\t\t");
                    }
                } else {
                    System.out.println("");
                    System.out.print((i - 2) + "\t\t");
                    for (int j = 0; j < temporal.length; j++) {
                        System.out.print(temporal[j] + "\t\t");
                    }
                }
            }
        } else {
            //Obtener el nombre del campo a buscar
            String campoTabla = String.valueOf(condicion.charAt(0));
            String contenido = "";
            for (int i = 1; i < condicion.length(); i++) {
                if (condicion.charAt(i) == '=') {
                    for (int j = 1; j < i; j++) {
                        campoTabla += condicion.charAt(j);
                    }
                    for (int j = (i + 1); j < condicion.length(); j++) {
                        contenido += condicion.charAt(j);
                    }
                }
            }
            System.out.println("campoTabla: " + campoTabla);
            System.out.println("contenido: " + contenido);

            String temporal[] = tabla.get(2).toString().split(",");
            int indiceBuscar = -1;
            for (int i = 0; i < temporal.length; i++) {
                if (campoTabla.equals(temporal[i])) {
                    indiceBuscar = i;
                }
            }

            System.out.println("indice: " + indiceBuscar);

            for (int i = 2; i < tabla.size(); i++) {
                if (i == 2) {
                    System.out.print("Indice\t\t");
                    for (int j = 0; j < temporal.length; j++) {
                        System.out.print(temporal[j].toUpperCase() + "\t\t");
                    }
                    System.out.println("");
                } else {
                    temporal = tabla.get(i).toString().split(",");

                    if (temporal[indiceBuscar].equals(contenido)) {
//                        System.out.println("Existe"); 
                        System.out.print((i - (i - 1)) + "\t\t");
                        for (int j = 0; j < temporal.length; j++) {
                            System.out.print(temporal[j] + "\t\t");
                        }
                    }
                }
            }
        }
        System.out.println("");
    }

    public void agregarCampos(ArrayList<Object> tabla, String comando, String nombreBD, String nombreTabla) {
        Datos datos = new Datos(tabla, comando);
        tabla = datos.guardarDatos();
        Archivo.getArchivo().crearArchivo(tabla, nombreBD, nombreTabla);
    }

    public void eliminarTabla(String nombreBD, String nombreTabla, String condicion, ArrayList<Object> tabla) {
        for (int i = 0; i < tabla.size(); i++) {
            if (tabla.get(i).toString().contains(condicion)) {
                Archivo.getArchivo().eliminarCarpeta(nombreBD, nombreTabla);
            }
        }
    }

    public void actualizarTabla(ArrayList<Object> tabla, String nombreTabla, String nombreBD, String[] campos, String condicion) {
        int numCampos = (int) tabla.get(1);
        if (numCampos == campos.length) {
            System.out.println("Son el mismo numero de campos");
            String camposTabla[] = tabla.get(2).toString().split(",");
            String camposUpdate[] = new String[campos.length];
            int posicion = -1;

            for (int i = 0; i < camposTabla.length; i++) {
                if (campos[i].contains(camposTabla[i] + "=")) {
                    camposUpdate[i] = campos[i].replace(camposTabla[i] + "=", "");
//                    System.out.println(i + "si contiene");
                } else {
                    System.err.println("Campos inexistentes y/o en posición erronea.");
                    return;
                }
            }

            //Obtener posicion dentro de la lista
            for (int i = 3; i < tabla.size(); i++) {
                if (tabla.get(i).toString().contains(condicion)) {
                    posicion = i;
                    break;
                }
            }

            //Creo la variable tipo string que enviare a la actualizar a la lista
            String camposNuevos = camposUpdate[0];
            for (int j = 1; j < camposUpdate.length; j++) {
//                System.out.println(j + " ggg " + camposUpdate[j]);
                camposNuevos += "," + camposUpdate[j];
            }
//            System.out.println(camposNuevos);
//            System.out.println("posicion " + posicion);
            tabla.set(posicion, camposNuevos);
            Archivo.getArchivo().crearArchivo(tabla, nombreBD, nombreTabla);
            System.out.println("Tabla actualizada con éxito.");
        }
    }

    public static void main(String[] args) {

        System.out.println(Comando.getComando().usuarioPswCorrecto("admin", "1234"));
        Comando.getComando().crearBD("prueba2");
        ArrayList tabla = Comando.getComando().crearTabla("prueba2", "CREAR TABLA Orlando CAMPOS orlando, elena, tirso, gustavo");
        for (int i = 0; i < tabla.size(); i++) {
            System.out.println(i + " " + tabla.get(i));
        }

        Comando.getComando().agregarCampos(tabla, "AGREGAR Orlando VALOR (hola,como,estas,tu)", "prueba2", "Orlando");
        Comando.getComando().agregarCampos(tabla, "AGREGAR Orlando VALOR (1,2,3,4)", "prueba2", "Orlando");

        for (int i = 0; i < tabla.size(); i++) {
            System.out.println(i + " " + tabla.get(i));
        }
        String[] campos = {"orlando=uno", "elena=dos", "tirso=tres", "gustavo=cuatro"};//Separar mas los campos
        Comando.getComando().actualizarTabla(tabla, "Orlando", "prueba2", campos, "4");

        System.out.println("tabla actualizada");
        for (int i = 0; i < tabla.size(); i++) {
            System.out.println(i + " " + tabla.get(i));
        }

        Comando.getComando().seleccionarCampos(tabla, "orlando=uno");
//        Comando.getComando().eliminarTabla("prueba2", "Orlando", "4", tabla);
//        tabla.clear();
    }
}

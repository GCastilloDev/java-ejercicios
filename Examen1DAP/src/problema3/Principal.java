/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema3;

/**
 *
 * @author Estudiante
 */
public class Principal {

    public static void main(String[] args) {

        //Datos para la cuenta, 
        // Cambia el package
        System.out.println("Cuenta numero 1");
        Persona p1 = new Persona("nombre1", "apellido1", "telefono1");
        Cuenta c1 = new Cuenta();
        c1.transaccion(378, "retiro", 0);
        c1.transaccion(23456, "deposito", 0);
        //objeto c1 de la clase persona,,, parametros (23456,"deposito",0)son los que se mandan al metodo transacion.

        System.out.println("Cuenta numero 2");
        Persona p2 = new Persona("nombre2", "apellido2", "telefono2");
        Cuenta c2 = new Cuenta();
        c2.transaccion(378, "retiro", 0);
        c2.transaccion(23456, "deposito", 0);

        System.out.println("Cuenta numero 3");
        Persona p3 = new Persona("nombre3", "apellido3", "telefono3");
        Cuenta c3 = new Cuenta();
        c3.transaccion(378, "retiro", 0);
        c3.transaccion(23456, "deposito", 0);

        System.out.println("Cuenta numero 4");
        Persona p4 = new Persona("nombre4", "apellido4", "telefono4");
        Cuenta c4 = new Cuenta();
        c3.transaccion(378, "retiro", 0);
        c3.transaccion(23456, "deposito", 0);

        System.out.println("Cuenta numero 5");
        Persona p5 = new Persona("nombre5", "apellido5", "telefono5");
        Cuenta c5 = new Cuenta();
        c3.transaccion(378, "retiro", 0);
        c3.transaccion(23456, "deposito", 0);
    }
}

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
        Persona p1=new Persona();
        System.out.println("Nombre de la persona");
        System.out.println(p1.apellido);
        System.out.println(p1.nombre);
        System.out.println(p1.telefono);
        Cuenta c1= new Cuenta();
        c1.transaccion(378,"retiro",0 );
        c1.transaccion(23456,"deposito",0);
       //objeto c1 de la clase persona,,, parametros (23456,"deposito",0)son los que se mandan al metodo transacion.
       
    }
}

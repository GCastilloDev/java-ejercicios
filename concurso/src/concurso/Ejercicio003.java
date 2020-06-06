/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurso;

/**
 *
 * @author gustavo
 */
public class Ejercicio003 {

    public static void main(String[] args) {

        int numA = 1000;
        int numB = 1001;

//        System.out.println("" + sumaA(1184));
//        System.out.println("" + sumaB(1210));

        for (int i = 1; i < 500; i++) {      
          
                    
            
            for (int j = 1; j < 500; j++) {

                if (sumaA(i) == j && sumaB(j) == i) {
                    System.out.println(i);
                    System.out.println(j);                 
                    break;
                }
               
            }
        }

    }

    static int sumaA(int numA) {

        int sumaA = 0;

        for (int i = 1; i < numA; i++) {

            if (numA % i == 0) {

                //System.out.println(i);
                sumaA += i;
                //System.out.println("suma "+i+" = " + sumaA);
            }
        }

        return sumaA;
    }

    static int sumaB(int numB) {

        int sumaB = 0;
        for (int i = 1; i < numB; i++) {

            if (numB % i == 0) {

                //System.out.println(i);
                sumaB += i;
                //System.out.println("suma "+i+" = " + sumaA);
            }
        }

        return sumaB;
    }

}

package ejercicios;

import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class subsecuencia {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
      
       
        //Ingresar los datos
        System.out.println("ingrese cuantos casos de prueba: ");
        int cprueba=leer.nextInt();
         
         String[][] cadena=new String[cprueba][1];
         int[] valores=new int[cprueba];
        // char[][] aCaracteres;
        int contador=0;
         int aux,aux2,contadorHola=0;
         
        for (int i = 0; i < cprueba; i++) {
            System.out.println("Ingrese el texto del caso:"+(i+1));
            cadena[i][0]=leer.nextLine();
            aux=cadena[i][0].length();
            valores[i]=aux;
           
            
        }
        
        //le doy el valor diferente a la matriz en cada hilera a las columnas
        char [][] caracteres=new char[cprueba][];
        for (int i = 0; i < cprueba; i++) {
            caracteres[i]=new char[valores[i]];
        }
        //transformo mis String a un array de char
        for (int i = 0; i < cprueba; i++) {
            for (int j = 0; j < valores[i]; j++) {
            caracteres[i][j]=cadena[i][0].charAt(j);
              //  System.out.print("- "+caracteres[i][j]);
        }
        }
        
        
        /*
        for (int i = 0; i < cprueba; i++) {
            for (int j = 0; j < valores[i]; j++) {
                
            }
        }
*/
        for (int i = 0; i < cprueba; i++) {
            
            for (int j = 0; j < valores[i]; j++) {
                if (caracteres[i][j]=='h'||caracteres[i][j]=='H') {
                    //System.out.println("1-"+caracteres[i][j]);
                    //System.out.println("h");
                    for (int k = j; k < valores[i]; k++) {
                    if (caracteres[i][k]=='o'||caracteres[i][k]=='O'){
                      //  System.out.println("o");
                        for (int m = k; m < valores[i]; m++) {
                        if (caracteres[i][m]=='l'||caracteres[i][m]=='L'){
                        //    System.out.println("l");
                            for (int n = m; n < valores[i]; n++) {
                                
                                if (caracteres[i][n]=='a'||caracteres[i][n]=='A'){
                          //          System.out.println("a");
                                    contador=contador+1;
                                    
                                }
                            }
                        }
                    }
                    }
                    
                }
                }
                
            }
        }
        
        System.out.println("el numero de repeticiones es: "+contador);
    }
}

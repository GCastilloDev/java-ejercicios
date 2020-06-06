package NivelMedio;

import java.util.Scanner;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class MCDRecursivo {
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
        
        System.out.print("Ingresa el valor de \"X\": ");
        int valorX = n.nextInt();
        System.out.print("Ingresa el valor de \"Y\": ");
        int valorY = n.nextInt();
        
//        int mcd = obtener_mcd(valorY, valorX);
        int mcd = obtenerMCD(valorY, valorX);
        
        System.out.println("El Máximo Común Divisor es: " + mcd);
    }
    
    public static int obtenerMCD(int valorX, int valorY){              
        if(valorY == 0)
            return valorX;
        else
        return obtenerMCD(valorY, valorX%valorY);
    }   
}

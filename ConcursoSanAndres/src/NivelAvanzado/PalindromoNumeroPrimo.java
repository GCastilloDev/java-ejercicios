package NivelAvanzado;

import java.util.Scanner;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class PalindromoNumeroPrimo {

    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
        
        System.out.print("Ingresa el número: ");
        int numero = n.nextInt();
        boolean next = true;
        do{
            if(esPalindromo(numero) == true && esPrimo(numero) == true){
                next = false;
            }else{
                numero += 1;
            }
        }while(next == true);
        
        System.out.println("Salida: " + numero);       
    }
    
    static boolean esPalindromo(int numero){
        String num = String.valueOf(numero);
        int tamaño = num.length() - 1;
        
        for (int i = 0; i < num.length(); i++) {             
            if(num.charAt(i) != num.charAt(tamaño)){
                return false;
            }
            tamaño--;            
        }        
        return true;
    }
    
    static boolean esPrimo(int numero){
        if(numero == 1){
            return false;
        }
        for (int i = 2; i < numero; i++) {
            if(numero % i == 0){
                return false;
            }
        }        
        return true;
    }
}

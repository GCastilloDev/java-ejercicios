package NivelMedio;

import java.util.Scanner;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class NumeroAleatorios {

    public static void main(String[] args) {

        Scanner n = new Scanner(System.in);

        char respuesta = ' ';
        int partidasGanadas = 0;
        int partidasPerdidas = 0;

        do {
            int numeroA = generarNumero();
            int numeroB = generarNumero();

            while (numeroA == numeroB) {
                numeroA = generarNumero();
                numeroB = generarNumero();
            }

            System.out.print("Apuestas por A o B?: ");
            char apuesta = n.next().charAt(0);

            if (numeroA > numeroB) {
                if (apuesta == 'a' || apuesta == 'A') {
                    partidasGanadas++;
                    System.out.println("A saca " + numeroA + " y B saca un " + numeroB + " HAS GANADO!!!");
                }
                if (apuesta == 'b' || apuesta == 'B') {
                    partidasPerdidas++;
                    System.out.println("A saca " + numeroA + " y B saca un " + numeroB + " HAS PERDIDO!!!");
                }
            }

            if (numeroA < numeroB) {
                if (apuesta == 'a' || apuesta == 'A') {
                    partidasPerdidas++;
                    System.out.println("A saca " + numeroA + " y B saca un " + numeroB + " HAS PERDIDO!!!");
                }
                if (apuesta == 'b' || apuesta == 'B') {
                    partidasGanadas++;
                    System.out.println("A saca " + numeroA + " y B saca un " + numeroB + " HAS GANADO!!!");
                }
            }
            
            System.out.println("Llevas " + partidasGanadas + " partidas ganadas y " + partidasPerdidas + " partidas perdidas");
            System.out.print("Quieres probar otra vez? (S/N): ");
            respuesta = n.next().charAt(0);

        } while (respuesta == 's' || respuesta == 'S');

        System.out.println("Adiós");

    }

    public static int generarNumero() {
        return (int) Math.floor(Math.random() * 101);
    }

}

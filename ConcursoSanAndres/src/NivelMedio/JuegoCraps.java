package NivelMedio;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class JuegoCraps {

    public static void main(String[] args) {

        int dadoA = generarNumero();
        int dadoB = generarNumero();
        int sumaDados = dadoA + dadoB;
        System.out.println("Dado A: " + dadoA);
        System.out.println("Dado B: " + dadoB);
        System.out.println("Suma de los dados: " + sumaDados);

        switch (sumaDados) {
            case 7:
            case 11:
                System.out.println("Has ganado!!!");
                break;
            case 2:
            case 3:
            case 12:
                System.out.println("Has perdido!!");
                break;
            default:
                int next = 0;
                int tirada = 1;
                do {
                    tirada++;
                    System.out.println("");
                    System.out.println("====== TIRADA " + tirada + " =====");
                    dadoA = generarNumero();
                    dadoB = generarNumero();
                    int suma = dadoA + dadoB;
                    System.out.println("Dado A: " + dadoA);
                    System.out.println("Dado B: " + dadoB);
                    System.out.println("Número a encontrar: " + sumaDados);
                    System.out.println("Suma de los dados: " + suma);
                    if (suma == 7) {
                        System.out.println("Has perdido!!");
                        break;
                    }

                    if (suma == sumaDados) {
                        System.out.println("Has ganado!!!");
                        break;
                    }

                } while (next != 7);
                break;
        }
    }

    public static int generarNumero() {
        int menor = 1;
        int mayor = 6;
        return (int) Math.floor(Math.random() * (mayor - menor + 1) + menor);
    }
}

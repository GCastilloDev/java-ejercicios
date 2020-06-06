package Ejercicio002;

/**
 * 
 * @author Gustavo <@LastShadow>
 */
public class TestCuenta {
    public static void main(String[] args) {
        
        Cuenta objeto = new Cuenta("Yosiel","800336581", 7.5, 10000.5);
        Cuenta cuentaOrigen = new Cuenta(objeto);
        
        cuentaOrigen.transferencia("855504669", 500);
    }
}

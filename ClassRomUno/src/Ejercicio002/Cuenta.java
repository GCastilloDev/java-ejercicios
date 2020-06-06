package Ejercicio002;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Cuenta {

    private String nombreCliente;
    private String numeroCuenta;
    private double tipoInteres;
    private double saldo;

    public Cuenta() {

    }

    public Cuenta(String nombreCliente, String numeroCuenta, double tipoInteres, double saldo) {
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.tipoInteres = tipoInteres;
        this.saldo = saldo;
    }
    
    public Cuenta(Cuenta objeto){
        this.nombreCliente = objeto.nombreCliente;
        this.numeroCuenta = objeto.numeroCuenta;
        this.tipoInteres = objeto.tipoInteres;
       this.saldo = objeto.saldo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean ingreso(double cantidadIngreso) {

        if (cantidadIngreso >= 0) {
            setSaldo(cantidadIngreso);
            return true;
        }
        return false;

    }

    public boolean reintegro(double cantidadRetiro) {

        if (cantidadRetiro >= 0) {
            if (getSaldo() >= cantidadRetiro) {
                setSaldo(getSaldo() - cantidadRetiro);
                return true;
            }
            return false;
        }
        return false;
    }

    public void transferencia(String cuentaDestino, double importe) {

        if (getSaldo() >= importe) {
            System.out.println("DETALLE DE LA TRANSACCION");
            System.out.println("Cuenta origen saldo inicial $" + getSaldo());
            setSaldo(getSaldo() - importe);
            System.out.println("Transferencia autorizada por $" + importe + " a la cuenta " + cuentaDestino);
            System.out.println("Cuenta origen saldo final $" + getSaldo());
        } else {
            System.out.println("Saldo insuficiente en la cuenta " + getNumeroCuenta());
        }

    }

}

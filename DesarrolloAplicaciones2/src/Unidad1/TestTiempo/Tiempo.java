package Unidad1.TestTiempo;

/**
 *
 * @author gustavo
 */
public class Tiempo {

    //PRIVATE: Encapsulamiento
    private int hora;
    private int minuto;
    private int segundo;
    private String formato = "12hrs";

    //Métodos de acceso: GET y SET
    //GET: Método de lectura de valores de los atributos
    //SET: Método de escritura de valores de los atributos
    //Métodos de lectura
    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    //Métodos de escritura
    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    //Constructor por defecto
    public Tiempo() {

    }

    //Primera sobrecarga de constructor
    public Tiempo(int hora) {
        this.hora = hora;
    }

    //Segunda sobrecarga de constructor
    public Tiempo(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    //Tercer sobrecarga de constructor
    public Tiempo(int hora, int minuto, int segundo) {

        if (validarHora(hora, minuto, segundo)) {
            this.hora = hora;
            this.minuto = minuto;
            this.segundo = segundo;
        }

    }
    
    //Método validar hora
    private boolean validarHora(int hora, int minuto, int segundo){
        
        if ((minuto >= 0 && minuto <= 59) && (segundo >= 0 && segundo <= 59) ){
            
            if(this.formato.equals("12hrs") && hora >= 1 && hora <= 12){
                return true;
            }
            
            else if(this.formato.equals("24hrs") && hora >= 0 && hora <= 24){
                    return true;
                }
            }          
                
        return false;
    }
    
}

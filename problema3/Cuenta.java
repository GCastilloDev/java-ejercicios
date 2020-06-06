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
public class Cuenta {
    // Atributos de la clase
    String numeroCuenta;
    float saldo;
    
    //Objeto propietario pertenece a la clase persona
    Persona propietario =new Persona();
    
    //metodo constructor por defecto
    public Cuenta(){
        
    }
    //metodo constructor con parametros
    public Cuenta(String numCuenta, int saldo, Persona propietario){
        
    }
    
    //Metodos Getter and setter, de los atributos(numeroCuenta, saldo, propietario).
    public Persona getPropietario() {
        
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }
    
    

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public float getSaldo() {
       return saldo;
    }
    //Termino de metodos getter and setter
    
    //Metodo get saldo para validar que nuestro saldo no sea menor a 0

    public void setSaldo(int saldo) {
         
        if(saldo>0){
            System.out.println("Saldo"+saldo);
        }else{
            System.out.println("saldo no disponible");  
        }
            
    }
    
    //Creacion del metodo transaccion , lleva parametros cantidad que es la que se ingresa para hacer las 
    //transacciones deposito
     public void transaccion(float cantidad, String tipoTrans,float total) { 
        //Validamos el tipo de transaccion a si es "deposito" o si es "retiro"
        saldo=3000;
        if(tipoTrans=="retiro") 
        { 
            total=saldo-cantidad; 
            System.out.println("Se realizo la operación (retiro) su saldo es "+total); 
        } 
        else if(tipoTrans=="deposito") 
        { 
            total=saldo+cantidad; 
            System.out.println("Se realizo la operacion (deposito) su saldo es "+total); 
        } 
    } 
     
     //Metodo toString , sobrecarga de metodo y retorno los metodos getSaldo, getNumCuenta, getPropietario
    @Override
    public String toString(){
        return getNumeroCuenta()+getSaldo()+getPropietario();
    }
    
    
}

package problema3;

/**
 *
 * @author Estudiante
 */
public class Persona {
    //Atributos de la clase(nombre, apellido,telefono)
    String  nombre;
    String apellido;
    String telefono;
    
    //metodo constructor de la clase persona SIN parametros
    public Persona(){
        this.nombre="Karla";
        this.apellido="Villalobos";
        this.telefono="123456789";
    }
    //Metodo constructor de la clase 
    public Persona(String nombre,String apellido ,String telefono){
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono=telefono;
    }
    //Metodos getter an setter , se da click izquierdo , insert code , getter and setter, 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
       return telefono;
            
    }
    // aqui termina los getter and setter
    
    //Validacion de datos , para telefono solo se pueda ingresar 9 caracteres
    public void setTelefono(String telefono) {
        
        if (telefono.length()!=9) {
                System.out.println("Formato incorrecto...");
            }else{
                System.out.println("Número correcto..");
            }
    }   
    
    // Metodo toString , se pone una sobrecarga del metodo(@Override), y se retornan los metodos (getApellido, getNombre, getTelefono)
    @Override
    public String toString(){
        return getApellido()+getNombre()+getTelefono();
        
    }
    
}

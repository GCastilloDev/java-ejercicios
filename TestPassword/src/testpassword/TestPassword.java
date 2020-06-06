package testpassword;

/**
 *
 * @author Estudiante
 */
public class TestPassword {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Password password = new Password();

//        String contraseña = Password.generarPassword(100);
//        System.out.println("Contraseña: " + contraseña);
        System.out.println("El password es fuerte: " + password.esFuerte("AAAaa12345"));
        System.out.println(password.generarPassword(50));

        
//        System.out.println("Contraseña propia:");
//        System.out.println(Password.esFuerte("Aabx123456789"));

    }

}

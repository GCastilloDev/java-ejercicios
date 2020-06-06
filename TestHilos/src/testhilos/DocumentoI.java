
package testhilos;

/**
 * 
 * @author @LastShadow
 */
public class DocumentoI implements Runnable{
    
    String texto;
    
    public DocumentoI(String texto){
        this.texto = texto;
    }

    @Override
    public void run() {
        System.out.println("Procesando documento interfaz...");
        for (int i = 0; i < 10; i++) {
            System.out.println(this.texto + " - " + (i+1) + " procesado.");
        }
    }

}

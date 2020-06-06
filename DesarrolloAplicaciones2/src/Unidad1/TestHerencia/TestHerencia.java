package Unidad1.TestHerencia;
/**
 *
 * @author gustavo
 */
public class TestHerencia {
    
    public static void main(String[] args) {        
        
        AutoBocho bochito = new AutoBocho();        
        bochito.setColor("Rojo");
        bochito.setMarca("VW");
        bochito.setModelo("1980");
        bochito.setNumSerie("X1SD34");
        bochito.setPotencia(40);
        
        AutoFerrari ferrari = new AutoFerrari();
        ferrari.setColor("Amarillo");
        ferrari.setMarca("Ferrari");
        ferrari.setModelo("2018");
        ferrari.setNumSerie("X1SSD34");
        ferrari.setPotencia(550);       
 
    }
    
}

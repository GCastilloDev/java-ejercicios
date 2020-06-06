package Ejercicio001;

/**
 *
 * @author Gustavo <@LastShadow>
 */
public class Test {

    public static void main(String[] args) {

        Edificio edificios[] = new Edificio[6];

        Edificio edificioPolimorfico;

        edificioPolimorfico = new Polideportivo(50, "Yosiel");
        edificios[0] = edificioPolimorfico;

        edificioPolimorfico = new EdificioOficinas(500, 60);
        edificios[1] = edificioPolimorfico;

        edificioPolimorfico = new Edificio(555.55);
        edificios[2] = edificioPolimorfico;

        edificioPolimorfico = new Polideportivo(80, "Macaco");
        edificios[3] = edificioPolimorfico;

        /*
        edificios[0] = new Polideportivo(3665.23, "Macaco 1");
        edificios[1] = new EdificioOficinas(556.32,500);
        edificios[2] = new Edificio(523.33);
        edificios[3] = new Polideportivo(50, "Yosiel");
         */
        //foreach
        for (Edificio edi : edificios) {

            if (edi != null) {
                if (edi instanceof EdificioOficinas) {
                    EdificioOficinas ofi = (EdificioOficinas) edi;
                    System.out.println(edi.toString());
                } else if (edi instanceof Polideportivo) {
                    Polideportivo poli = (Polideportivo) edi;
                    System.out.println(edi.toString());

                } else {
                    System.out.println(edi.toString());
                }
            }
        }
        
        
    }
    
}
